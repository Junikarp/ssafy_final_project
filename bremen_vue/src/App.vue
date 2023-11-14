<template>
    <header>
      <NavHeader></NavHeader>
    </header>
  <main>
  <MainPage1></MainPage1>
  </main>
  <Footer>
    <MainFooter></MainFooter>
  </Footer>
</template>

<script setup>
import MainFooter from './components/MainFooter.vue';
import MainPage1 from './components/MainPage/MainPage1.vue';
import NavHeader from './components/NavHeader.vue';

</script>

<style scoped>

main {
  margin-left: 200px;
  margin-right: 200px;
}


</style>
