<template>
  <main>
  <header>
  <NavHeader></NavHeader>
  </header>
  </main>
  <Footer>
  <MainFooter></MainFooter>
  </Footer>
</template>

<script setup>
import MainFooter from './components/MainFooter.vue';
import NavHeader from './components/NavHeader.vue';

</script>

<style scoped>
main {
    margin-left: 200px;
    margin-right: 200px;
}

</style>
