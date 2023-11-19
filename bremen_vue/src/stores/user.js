import { ref } from "vue";
import { defineStore } from "pinia";
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/userapi`

export const useUserStore = defineStore('user', () => {

    const User = ref({})

    // 사용자 로그인
    const login = function (user) {
        axios({
            url: REST_USER_API + "/login",
            method: 'POST',
            params: user
        }).then((user) => {
            router.push({ name: 'home' })
            User.value = user.data
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
                router.push({ name: '/login' })
                User.value = user.data
            })


    }



    return { User, login, signUp}
})