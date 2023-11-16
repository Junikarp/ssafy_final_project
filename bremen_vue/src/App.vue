<template>
  <div class="main">
  <main>
    <RouterView></RouterView>
  </main>
  <footer>
    <MainFooter></MainFooter>
  </footer>
  </div>
</template>

<script setup>
import MainFooter from './components/MainFooter.vue';

</script>

<style scoped>

main {
  padding-top: 70px;
  width: 100%;
  min-height: calc(100vh - 167px);
}

footer {
  width: 100%;
}

.main {
  display: flex;
  flex-direction: column;
}

</style>
