<template>
  <NavHeader></NavHeader>
    <table class="board-table">
      <tbody>
        <DetailPop v-for="boardItem in store.boardList" :key="boardItem.boardId" :dynamic-props="boardItem" data-aos="fade-up" data-aos-duration="1000"></DetailPop>
      </tbody>
    </table>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { useRoute } from 'vue-router'
import DetailPop from '../../components/Community/DetailPop.vue'
import { onMounted, ref, computed } from 'vue';
import {useUserStore} from '@/stores/user'
import NavHeader from '../NavHeader.vue';

const store = useBoardStore();
const ustore = useUserStore();
const route = useRoute();

const loginStatus = computed(() => {
  return ustore.isAuthenticated
})

onMounted(() => {
  if (sessionStorage.getItem('access-token') == null) {
    ustore.isAuthenticated = false;
  } else {
    ustore.isAuthenticated = true;
  }
})

onMounted(() => {
// 게시글 목록을 가져오는 메서드 호출
store.getBoardList(route.params.category);
});

</script>


<style scoped>

#main-text {
  font-weight: 800;
  font-size: 40px;
}

#create-button {
  color: rgb(240, 236, 236);
  font-size: 20px;
  font-weight: 550;
  width: 200px;
}

#community-image {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-image: url("../../assets/community/123.png");
  height: 300px;
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
  background-color: rgb(239, 241, 241);
}

.card * {
  padding: 10px;
}

.card{
  font-size: 25px;
  font-weight: bold;
}

#boardImg {
  width: 26%;
  border-radius: 25px;
  padding-right: -500px;
}

#create-board {
  display: flex;
  justify-content: center;
  align-items: center;
}

#create-board-img {
  margin-left: 330px;
  width: 70px;
}
</style>