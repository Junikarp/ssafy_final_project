<template>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="#page-top"><img src="../../assets/logo_white.png">BREMEN</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars ms-1"></i>
      </button>
      <div class="collapse navbar-collapse justify-content-between" id="navbarResponsive">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="#services">커뮤니티</a></li>
          <li class="nav-item"><a class="nav-link" href="#portfolio">동호회</a></li>
          <li class="nav-item"><a class="nav-link" href="#about">하이라이트</a></li>
          <li class="nav-item"><a class="nav-link" href="#team">중고거래</a></li>
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

  <body id="page-top">
    <header class="masthead" id="introduce" background-color="black" data-aos="fade-up" data-aos-duration="3000">
      <div class="container">
        <div class="masthead-subheading"></div>
        <div class="masthead-heading"></div>
        
      </div>
    </header>


    <div class="title" data-aos="fade-up" data-aos-duration="5000">BREMEN</div>
    <div class="intro-bremen" data-aos="fade-up">
      <div class="title-text">함께하는 스포츠 커뮤니티 브레멘에 오신것을 환영합니다!</div>
    </div>

    <section class="page-section bg-light" id="services">
      <div class="info-page1">
        <div class="info-img1" data-aos="fade-right" data-aos-offset="300" data-aos-easing="ease-in-sine"></div>
        <div class="text-center" data-aos="fade-left" data-aos-offset="300" data-aos-easing="ease-in-sine">
          <h2 class="info-heading">거대하고 다양한 커뮤니티</h2>
          <h3 class="info-bottom">다양한 종목의 커뮤니티에서 정보를 공유하며 서로의 선생님이 되어주세요</h3>
          <button type="button" class="main-link"><router-link class="button-none" :to="{ name: 'category' }">
              커뮤니티</router-link> </button>
        </div>
      </div>
    </section>
    <section class="page-section" id="portfolio">
      <div class="info-page1">
        <div class="text-center" data-aos="fade-up" data-aos-duration="1000">
          <h2 class="info-heading">가까운 이웃과의 동호회</h2>
          <h3 class="info-bottom">근처의 이웃과 취미를 공유하세요</h3>
          <button type="button" class="main-link"><router-link class="button-none" :to="{ name: 'groupcategory' }">
              동호회</router-link> </button>
        </div>
        <div class="info-img2" data-aos="flip-left" data-aos-easing="ease-out-cubic" data-aos-duration="1000"></div>
      </div>
    </section>
    <section class="page-section bg-light" id="about">
      <div class="info-page1">
        <div class="info-img3" data-aos="fade-up" data-aos-duration="2000" data-aos-anchor-placement="center-bottom"></div>
        <div class="text-center" data-aos="fade-down" data-aos-duration="2000" data-aos-anchor-placement="center-bottom">
          <h2 class="info-heading">한치 앞도 모르는 승부의 세계</h2>
          <h3 class="info-bottom">다양한 스포츠의 최고의 순간들을 함께 즐기세요.</h3>
          <button type="button" class="main-link"><router-link class="button-none" :to="{ name: 'category' }">
              하이라이트</router-link> </button>
        </div>
      </div>
    </section>
    <section class="page-section" id="team">
      <div class="info-page1">
        <div class="text-center" data-aos="fade-left" data-aos-offset="300" data-aos-easing="ease-in-sine">
          <h2 class="info-heading">믿을 수 있는 중고거래</h2>
          <h3 class="info-bottom">직접 만나서 취미 생활중 필요한 물품을 거래하세요</h3>
          <button type="button" class="main-link"><router-link class="button-none" :to="{ name: 'tradecategory' }">
            중고거래</router-link> </button>
          </div>
          <div class="info-img4" data-aos="fade-right" data-aos-offset="300" data-aos-easing="ease-in-sine"></div>
      </div>
    </section>

  </body>
</template>

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


window.addEventListener('DOMContentLoaded', event => {

  var navbarShrink = function () {
    const navbarCollapsible = document.body.querySelector('#mainNav');
    if (!navbarCollapsible) {
      return;
    }
    if (window.scrollY === 0) {
      navbarCollapsible.classList.remove('navbar-shrink')
    } else {
      navbarCollapsible.classList.add('navbar-shrink')
    }

  };

  navbarShrink();

  document.addEventListener('scroll', navbarShrink);

  const mainNav = document.body.querySelector('#mainNav');
  if (mainNav) {
    new bootstrap.ScrollSpy(document.body, {
      target: '#mainNav',
      rootMargin: '0px 0px -40%',
    });
  };

  const navbarToggler = document.body.querySelector('.navbar-toggler');
  const responsiveNavItems = [].slice.call(
    document.querySelectorAll('#navbarResponsive .nav-link')
  );
  responsiveNavItems.map(function (responsiveNavItem) {
    responsiveNavItem.addEventListener('click', () => {
      if (window.getComputedStyle(navbarToggler).display !== 'none') {
        navbarToggler.click();
      }
    });
  });

});

</script>

<style>
*,
*::before,
*::after {
  box-sizing: border-box;
}

@media (prefers-reduced-motion: no-preference) {
  :root {
    scroll-behavior: smooth;
  }
}

h4,
.h4,
h3,
.h3,
h2,
.h2 {
  margin-top: 0;
  margin-bottom: 0.5rem;
  font-weight: 700;
  line-height: 1.2;
}

h2,
.h2 {
  font-size: calc(1.325rem + 0.9vw);
}

@media (min-width: 1200px) {

  h2,
  .h2 {
    font-size: 2rem;
  }
}


h3,
.h3 {
  font-size: calc(1.3rem + 0.6vw);
}

@media (min-width: 1200px) {

  h3,
  .h3 {
    font-size: 1.75rem;
  }
}

h4,
.h4 {
  font-size: calc(1.275rem + 0.3vw);
}

@media (min-width: 1200px) {

  h4,
  .h4 {
    font-size: 1.5rem;
  }
}

p {
  margin-bottom: 1rem;
}


ul {
  padding-left: 2rem;
}


ul {
  margin-bottom: 1rem;
}

a {
  text-decoration: underline;
}

img {
  vertical-align: middle;
}

.container {
  width: 100%;
  margin-right: auto;
  margin-left: auto;
}

@media (min-width: 576px) {
  .container {
    max-width: 540px;
  }
}

@media (min-width: 768px) {
  .container {
    max-width: 720px;
  }
}

@media (min-width: 992px) {
  #page-top {
    margin-top: -86px;
  }

  .container {
    max-width: 1000px;
  }
}

@media (min-width: 1200px) {
  .container {
    max-width: 1140px;
  }
}

@media (min-width: 1400px) {
  .container {
    max-width: 1320px;
  }

}

.row {
  display: flex;
  flex-wrap: wrap;
}

.row>* {
  flex-shrink: 0;
  width: 100%;
  max-width: 100%;
}

@media (min-width: 768px) {
  .col-md-4 {
    flex: 0 0 auto;
    width: 33.33333333%;
  }
}

@media (min-width: 992px) {
  .col-lg-4 {
    flex: 0 0 auto;
    width: 33.33333333%;
  }

  .col-lg-8 {
    flex: 0 0 auto;
    width: 66.66666667%;
  }
}

.collapse:not(.show) {
  display: none;
}

.nav {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
}

.nav-link {
  font-weight: 600;
  margin-right: 7px;
  display: block;
  text-decoration: none;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out;
}

@media (prefers-reduced-motion: reduce) {
  .nav-link {
    transition: none;
  }
}

.navbar {
  position: relative;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: space-between;
}

.navbar>.container {
  display: flex;
  flex-wrap: inherit;
  align-items: center;
  justify-content: space-between;
  padding-top: 10px;
  padding-bottom: 10px;
}

.navbar-brand {
  text-decoration: none;
  white-space: nowrap;
  margin-right: 50px;
}

.navbar-nav {
  display: flex;
  flex-direction: column;
  list-style: none;
}

.navbar-collapse {
  flex-basis: 100%;
  flex-grow: 1;
  align-items: center;
}

@media (prefers-reduced-motion: reduce) {
  .navbar-toggler {
    transition: none;
  }
}

@media (min-width: 992px) {
  .navbar-expand-lg {
    flex-wrap: nowrap;
    justify-content: flex-start;
  }

  .navbar-expand-lg .navbar-nav {
    flex-direction: row;
  }

  .navbar-expand-lg .navbar-collapse {
    display: flex !important;
    flex-basis: auto;
  }

  .navbar-expand-lg .navbar-toggler {
    display: none;
  }
}

.fixed-top {
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  z-index: 1030;
}

.align-items-center {
  align-items: center !important;
}

@media (min-width: 992px) {
  .text-lg-start {
    text-align: left !important;
  }

  .text-lg-end {
    text-align: right !important;
  }
}

body {
  position: relative;
}

p {
  line-height: 1.75;
}



.btn-xl {
  padding: 1.25rem 2.5rem;
  font-size: 1.125rem;
}

#mainNav {
  background-color: #212529;
}

#mainNav .navbar-brand img {
  
  width: 30px;
}

#mainNav .navbar-nav .nav-item .nav-link {
  font-size: 17px;
  color: #fff;
  letter-spacing: 0.0625em;
}

#mainNav .navbar-nav .nav-item .nav-link:hover {
  color: black;
}

@media (min-width: 992px) {
  #mainNav {
    border: none;
    background-color: transparent;
    transition: padding-top 0.3s ease-in-out, padding-bottom 0.3s ease-in-out;
  }

  #mainNav .navbar-brand {
    font-size: 1.5em;
    transition: font-size 0.3s ease-in-out;
  }

  #mainNav .navbar-brand img {
    height: 2rem;
    transition: height 0.3s ease-in-out;
  }

  #mainNav.navbar-shrink {
    padding-top: 1rem;
    padding-bottom: 1rem;
    background-color: #212529;
  }

  #mainNav.navbar-shrink .navbar-brand {
    font-size: 1.25em;
  }

  #mainNav.navbar-shrink .navbar-brand svg,
  #mainNav.navbar-shrink .navbar-brand img {
    height: 1.5rem;
  }

  #mainNav .navbar-nav .nav-item {
    margin-right: 1rem;
  }

  #mainNav .navbar-nav .nav-item:last-child {
    margin-right: 0;
  }
}

header.masthead {
  padding-bottom: 6rem;
  text-align: center;
  color: #fff;
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center center;
  background-size: cover;
}

header.masthead .masthead-subheading {
  font-size: 1.5rem;
  font-style: italic;
  line-height: 1.5rem;
  margin-bottom: 25px;
}

header.masthead .masthead-heading {
  font-size: 3.25rem;
  font-weight: 700;
  line-height: 3.25rem;
  margin-bottom: 2rem;
}

@media (min-width: 768px) {
  header.masthead {
    padding-top: 17rem;
    padding-bottom: 12.5rem;
  }

  header.masthead .masthead-subheading {
    font-size: 2.25rem;
    font-style: italic;
    line-height: 2.25rem;
    margin-bottom: 2rem;
  }

  header.masthead .masthead-heading {
    font-size: 4.5rem;
    font-weight: 700;
    line-height: 4.5rem;
    margin-bottom: 4rem;
  }
}

section#contact {
  background-color: #212529;
  background-image: url("../../assets/main/workout.png");
  background-repeat: no-repeat;
  background-position: center;
}

section#contact .section-heading {
  color: #fff;
}

#introduce {
  background-image: url('../../assets/main//running.jpeg');
  height: 800px;
  padding-top: 100px;
  margin-bottom: 100px;
}

.login-nav {
  display: flex;
  justify-content: space-around;
  width: 12%;
  text-decoration: none;
  font-size: 18px;
}

#logo {
  width: 100px !important;
}

.intro-bremen {
  margin: 100px;
}

.title {
  margin-top: 100px;
  margin-bottom: 100px;
  font-weight: 800;
  font-size: 50px;
  text-align: center;
}

.title-text {
  text-align: center;
  font-weight: 500;
  margin-bottom: 100px;
  font-size: 25px;
  color: #212529BF;
}

.main-link {
  background-color: #E9ECEF;
  color: #212529;
  font-size: 20px;
  font-weight: 500;
  border: none;
  border-radius: 6px;
  text-decoration: none;
  padding: 12px 2rem;
  display: inline-block;
  margin-left: 10px;

}

.info-page1 {
  display: flex;
  flex-direction: row;
  width: 100%;
  position: relative;
  align-items: center;
}

.info-img1 {
  background-image: url('../../assets/main/pt.jpeg');
  background-size: cover;
  background-repeat: no-repeat;
  width: 50%;
  height: 600px;
}

.info-img2 {
  background-image: url('../../assets/main/basketball.jpeg');
  background-size: cover;
  background-repeat: no-repeat;
  width: 50%;
  height: 600px;
}

.info-img3 {
  background-image: url('../../assets/main/wow.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  width: 50%;
  height: 600px;
}
.info-img4 {
  background-image: url('../../assets/main/trading.jpeg');
  background-size: cover;
  background-repeat: no-repeat;
  width: 50%;
  height: 600px;
}

.text-center {
  justify-content: center;
  width: 50%;
  

}

.info-heading {
  margin-bottom: 30px;
}

.info-bottom {
  margin: 40px;
  font-size: 23px;
  color: #212529BF;
}

.button-none {
  color: #444648;
  text-decoration: none;
}
</style>