import { ref } from "vue";
import { defineStore } from "pinia";
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/userapi`

export const useUserStore = defineStore('user', () => {

    const User = ref({})

    const isAuthenticated = ref(false)

    // 사용자 로그인
    const login = function (user) {
        axios({
            url: REST_USER_API + "/login",
            method: 'POST',
            params: user
        }).then((user) => {
            User.value = user.data
            isAuthenticated.value = true;
            router.push({ name: 'home' })
        }).catch(()=>{
            isAuthenticated.value = false;
        })
    }


    // 사용자 회원가입
    const router = useRouter();    // 사용자 회원가입
    const signUp = function (user) {
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



    return { User, login, signUp, isAuthenticated}
})
