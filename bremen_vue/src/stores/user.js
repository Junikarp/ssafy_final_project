import { ref } from "vue";
import { defineStore } from "pinia";
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/userapi`

export const useUserStore = defineStore('user', () => {

    // 아무데서나 가져다 쓸수있음 이제
    const loginUserId = ref('')

    const User = ref({})

    const isAuthenticated = ref(false)

    // 사용자 로그인
    const login = function (user) {
        axios({
            url: REST_USER_API + "/login",
            method: 'POST',
            params: user
        }).then((user) => {
            console.log(user)
            User.value = user.data
            isAuthenticated.value = true;

            sessionStorage.setItem('access-token', user.data["access-token"])

            const token = user.data["access-token"].split('.')
            let id = token[1]
            id = atob(id)
            id = JSON.parse(id)
            console.log(id['id'])
            loginUserId.value = id['id']

            router.push({ name: 'home' })
        }).catch(()=>{
            isAuthenticated.value = false;
        })
    }

    // 로그아웃
    const logout = function(){
        User.value={name: ''}
        sessionStorage.clear()
    }


    // 사용자 회원가입
    const router = useRouter();    
    const signUp = function (user) {`as`
        console.log(user)
        axios({
            url: REST_USER_API+"/signup",
            method: 'POST',
            params: user
        })
            .then(() => {
                router.push({ name: 'login' })
                User.value = user.data
            })


    }



    return { User, login, signUp, isAuthenticated, logout, loginUserId}
})
