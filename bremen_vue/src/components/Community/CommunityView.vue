<template class="community">
  <div id="board-list">
    <div class="box">
      <table class="board-table">
        <tbody>
          <tr v-for="(boardItem, index) in store.boardList" :key="boardItem.boardId">
            <router-link class="detail" :to="{ name: 'detail', params: { id: boardItem.boardId } }">
              <div class="card">
                <div class="title">
                  {{ boardItem.boardTitle }}
                </div>
                <div class="content">
                  {{ boardItem.boardContent }}
                </div>
              </div>
            </router-link>
          </tr>
        </tbody>
      </table>
    </div>
    <router-link :to="{ name: 'boardCreate' }">글 작성</router-link>
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
template {
  display: flex;
  flex-direction: column;
}

.box {
  margin:300px
}

#board-list {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  width: 1800px;
}

.card {
  display: flex;
  justify-content: center;
  align-items: left;
  padding: 20px;
  margin-bottom: 30px;
  width: 800px;
  height: 180px;
}

.card * {
  padding: 10px;
}

.card .title {
  font-size: 25px;
  font-weight: bold;
}

.detail {
  text-decoration: none;
}
</style>