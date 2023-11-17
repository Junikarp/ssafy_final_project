<template>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="#page-top"><img src="../../assets/logo.png" alt="..." id="logo" /></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars ms-1"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="#services">메인페이지1</a></li>
          <li class="nav-item"><a class="nav-link" href="#portfolio">커뮤니티</a></li>
          <li class="nav-item"><a class="nav-link" href="#about">승부예측</a></li>
          <li class="nav-item"><a class="nav-link" href="#team">그냥페이지</a></li>
          <li class="nav-item"><a class="nav-link" href="#contact">자드가자</a></li>
          <li class="nav-item"><router-link class="nav-link" :to="{ name: 'login' }">로그인</router-link></li>
          <li class="nav-item"><router-link class="nav-link" :to="{ name: 'signup' }">회원가입</router-link></li>
        </ul>
      </div>
    </div>
  </nav>

  <body id="page-top">
    <header class="masthead" id="introduce" background-color="black">
      <div class="container">
        <div class="masthead-subheading">브레멘에 어서오세요!!!</div>
        <div class="masthead-heading">만나서 반갑습니당</div>
        <a class="btn btn-primary btn-xl" href="#services">브레멘 더 알아보기</a>
      </div>
    </header>
    <section class="page-section" id="services">
      <div class="container">
        <div class="text-center">
          <h2 class="section-heading">메인 페이지1</h2>
          <h3 class="section-subheading text-muted">오늘도 커피 한잔과 함께.</h3>
        </div>
      </div>
    </section>
    <section class="page-section bg-light" id="portfolio">
      <div class="container">
        <div class="text-center">
          <h2 class="section-heading">메인 페이지2</h2>
          <h3 class="section-subheading text-muted">뒤에 사진 넣고 이것저것 합시다.</h3>
        </div>
      </div>
    </section>
    <section class="page-section" id="about">
      <div class="container">
        <div class="text-center">
          <h2 class="section-heading">메인페이지3</h2>
          <h3 class="section-subheading text-muted">자 승부예측 드가자~</h3>
        </div>
      </div>
    </section>
    <section class="page-section bg-light" id="team">
      <div class="container">
        <div class="text-center">
          <h2 class="section-heading">커뮤니티만 하기 심심</h2>
          <h3 class="section-subheading text-muted">동네에서 같이 운동할 사람도 찾아주자구</h3>
        </div>

      </div>
    </section>
    <section class="page-section" id="contact">
      <div class="container">
        <div class="text-center">
          <h2 class="section-heading">여긴 뭐넣지</h2>
          <h3 class="section-subheading text-muted">일단은 사진넣고 하면 될 듯 하네.</h3>
        </div>
      </div>
    </section>
  </body>
</template>

<script setup>
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
    max-width: 960px;
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

.page-section {
  padding: 6rem 0;
}

.page-section h2.section-heading,
.page-section .section-heading.h2 {
  font-size: 2.5rem;
  margin-top: 0;
  margin-bottom: 1rem;
}

.page-section h3.section-subheading,
.page-section .section-subheading.h3 {
  font-size: 1rem;
  font-weight: 400;
  margin-bottom: 4rem;
}

@media (min-width: 768px) {
  section {
    padding: 9rem 0;
  }
}

.btn-xl {
  padding: 1.25rem 2.5rem;
  font-size: 1.125rem;
}

#mainNav {
  background-color: #212529;
}

#mainNav .navbar-brand img {
  height: 100%;
  width: auto;
}

#mainNav .navbar-nav .nav-item .nav-link {
  font-size: 0.95rem;
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
  background-image: url(../../assets/main/space.jpeg);
  padding-top: 100px;
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
</style>