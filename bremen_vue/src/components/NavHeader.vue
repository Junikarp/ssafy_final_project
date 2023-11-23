<template>
  <nav id="navbarorigin" class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/"><img src="../assets/logo_white.png" class="logo">BREMEN</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars ms-1"></i>
      </button>
      <div class="navbar-collapse justify-content-between" id="navbarResponsive">
        <ul class="navbar-nav">
          <router-link class="nav-link" :to="{ name: 'category' }">커뮤니티</router-link>
          <router-link class="nav-link" :to="{ name: 'groupcategory' }">동호회</router-link>
          <router-link class="nav-link" :to="{ name: 'tradecategory' }">경기영상</router-link>
          <router-link class="nav-link" :to="{ name: 'groupcategory' }">중고거래</router-link>
        </ul>
        
          <ul class="navbar-nav">
            <li v-if="!loginStatus" class="nav-item"><router-link class="nav-link"
                :to="{ name: 'login' }">로그인</router-link>
            </li>
            <li v-if="!loginStatus" class="nav-item"><router-link class="nav-link"
                :to="{ name: 'signup' }">회원가입</router-link></li>
            <li v-if="loginStatus" class="nav-item" @click="logout"><router-link class="nav-link"
                :to="{ name: 'home' }">로그아웃</router-link></li>
          </ul>
        
      </div>
    </div>
  </nav>
</template>

<!-- 나머지 script 및 style 섹션은 변경되지 않았습니다. -->


<script setup>
import { useUserStore } from '@/stores/user';
import { computed, onMounted } from 'vue'
const store = useUserStore()

const loginStatus = computed(() => {
  return store.isAuthenticated
})


onMounted(() => {
  if (sessionStorage.getItem('access-token') == null) {
    store.isAuthenticated = false;
  } else {
    store.isAuthenticated = true;
  }
})

const logout = function () {
  sessionStorage.clear()
  store.isAuthenticated = false;
}

</script>

<style scoped>
.navbar {
  background-color: rgb(20, 20, 20);
}

#navbarorigin {
  margin-bottom: 30px !important;
}

.logo {
  width: 30px;
}
.nav-link {
  font-size: 17px;
  font-weight: 600;
  color: white;
  margin-right: 7px;
  display: block;
  text-decoration: none;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out;
}

</style>