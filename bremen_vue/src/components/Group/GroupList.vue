<template>
  <section class="notice">

    <div class="group-img"></div>
    <div class="main-text">함께 할 동료를 찾아보세요</div>
    <div class="sub-text">근처에 있는 사람들과 함께할 수 있어요</div>


    <!-- board list area -->
    <div id="board-list">
      <div class="container">
        <router-link class="board-box" :to="{ name: 'groupDetail', params: { id: groupItem.groupId } }"
          v-for="groupItem in store.groupList" :key="groupItem.groupId">
          <div class="group-title">
            {{ groupItem.groupTitle }}
          </div>
          <div class="group-content"> {{ groupItem.groupContent }}</div>

        </router-link>
      </div>

      <router-link :to="{ name: 'groupCreate' }">글 작성</router-link>
    </div>
  </section>
</template>
  
<script setup>
import { onMounted } from 'vue';
import { useGroupStore } from '../../stores/group';
import { useRoute } from 'vue-router'

const store = useGroupStore();
const route = useRoute();

onMounted(() => {
  store.getGroupList(route.params.category);
});

</script>
  
  
<style scoped>
.group-img {
  background-image: url("../../assets/group/단체이미지.jpeg");
  height: 600px;
  width: 100%;
}

.main-text {
  margin-top: 50px;
  margin-bottom: 20px;
  font-weight: 600;
  text-align: center;
  font-size: 40px;
}

.sub-text {
  text-align: center;
  font-weight: 400;
  font-size: 20px;
}

#board-list {
  margin: 50px;
  margin-top: 100px;
  padding-left: 20px;
  padding-right: 20px;

}

.container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-between;

}

.board-box {
  width: 600px;
  height: 300px;
  margin-bottom: 30px;
  padding: 40px;
  text-decoration: none;
  border-width: 5px;
  border-color: rgb(212, 212, 212);
  border-style: solid;
  border-radius: 20px;

}

.group-title {
  text-align: left;
  font-size: 35px;
  font-weight: 500;
  color: black;
  margin-bottom: 20px;
}

.group-content {
  text-align: left;
  font-size: 20px;
  font-weight: 400;
  color: black;
}

.board-box:hover {
  background-color: rgb(244, 240, 240);
}</style>