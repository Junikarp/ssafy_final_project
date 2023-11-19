import { ref } from "vue";
import { defineStore } from "pinia";
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/userapi`

export const useUserStore = defineStore('user', () => {

    const User = ref({})
    const login = function (user) {
        axios.post(REST_BOARD_API + "/login", user)
            .then((response) => {
                User.value = response.data
                router.push({ name: "login" })
            })
            .catch((err) => {
                alert("로그인 실패")
            })
    }

    return{User, login}
})