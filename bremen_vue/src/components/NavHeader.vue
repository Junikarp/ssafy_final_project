<template>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <a class="navbar-brand"><img src="../../assets/logo_white.png">BREMEN</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars ms-1"></i>
      </button>
      <div class="navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="#services">커뮤니티</a></li>
          <li class="nav-item"><a class="nav-link" href="#portfolio">커뮤니티</a></li>
          <li class="nav-item"><a class="nav-link" href="#about">승부예측</a></li>
          <li class="nav-item"><a class="nav-link" href="#team">그냥페이지</a></li>
          <li class="nav-item"><a class="nav-link" href="#contact">자드가자</a></li>
          <li v-if="!loginStatus" class="nav-item"><router-link class="nav-link" :to="{ name: 'login' }">로그인</router-link>
          </li>
          <li v-if="!loginStatus" class="nav-item"><router-link class="nav-link"
              :to="{ name: 'signup' }">회원가입</router-link></li>
          <li v-if="loginStatus" class="nav-item" @click="logout" data-aos="fade-right"><router-link class="nav-link"
              :to="{ name: 'home' }">로그아웃</router-link></li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script setup>

</script>

<style scoped>
.navbar {
  background-color: rgb(20, 20, 20);
}

</style>