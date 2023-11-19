<template>
    <div>
        {{ store.User.userName }} 님 환영합니다
        <button @click="logout">로그아웃</button>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { useRouter } from 'vue-router'


const router = useRouter();
const store = useUserStore()


const logout = function () {
    router.push({ name: 'login'})
}

</script>

<style scoped></style>