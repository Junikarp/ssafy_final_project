<template>
    <header>
      <NavHeader></NavHeader>
    </header>
  <main>
  <MainPage1></MainPage1>
  <MainPage2></MainPage2>
  <MainPage3></MainPage3>
  </main>
  <Footer>
    <MainFooter></MainFooter>
  </Footer>
</template>

<script setup>
import MainFooter from './components/MainFooter.vue';
import MainPage1 from './components/MainPage/MainPage1.vue';
import MainPage2 from './components/MainPage/MainPage2.vue';
import MainPage3 from './components/MainPage/MainPage3.vue';
import NavHeader from './components/NavHeader.vue';

</script>

<style scoped>

main {
  padding-top: 70px;
  margin-left: 200px;
  margin-right: 200px;
}


</style>
