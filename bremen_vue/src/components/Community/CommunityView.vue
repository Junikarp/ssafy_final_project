<template>
  <div id="board-list">
  <div id="community-image">
  <p id="main-text">다양한 사람들과 자신의 이야기를 공유하세요!</p>
  <button type="button" class="btn btn-info" id="create-button">지금 참여하기!!</button></div>
    <div class="box">
    <div class="button-group">
      <router-link :to="{name:'info'}" class="btn btn-outline-primary">정보</router-link>
      <router-link :to="{name:'question'}" class="btn btn-outline-secondary">질문</router-link>
      <router-link :to="{name:'free'}" class="btn btn-outline-success">자유</router-link>
      <router-link :to="{name:'info'}" class="btn btn-outline-danger">인기글</router-link>
      <router-link :to="{name:'humor'}" class="btn btn-outline-warning">유머</router-link>
    </div>
     <router-view></router-view>
     </div> 
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute } from 'vue-router'

const store = useBoardStore();
const route = useRoute();

onMounted(() => {
  // 게시글 목록을 가져오는 메서드 호출
  store.getBoardList(route.params.category);
});

</script>


<style scoped>
.box {
  margin-top: 50px;
  margin-left: 300px;
  margin-right: 300px;
}

#main-text {
  font-weight: 800;
  font-size: 40px;
}

#create-button {
  color: rgb(240, 236, 236);
  font-size: 20px;
  font-weight: 550;
  width:200px;
}

#community-image {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-image: url("../../assets/community/123.png");
  height: 300px;
}

.button-group {
  display: flex;
  margin-bottom: 40px;
  justify-content: center;
}

.button-group * {
  margin-left: 20px;
  margin-right: 20px;
  width: 80px;
}

#board-list {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  width: 100%;
}

.card {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  border-radius: 20px;
  padding: 20px;
  margin-bottom: 30px;
  width: 800px;
  height: 180px;
}

.card:hover {
  background-color: rgb(156, 162, 162);
}

.card * {
  padding: 10px;
}

.textbox {
  padding-left: 30px;
}

.card .title {
  font-size: 25px;
  font-weight: bold;
}

#boardImg {
  width: 26%;
  border-radius: 25px;
  padding-right: -500px;
}

.detail {
  text-decoration: none;
}
</style>