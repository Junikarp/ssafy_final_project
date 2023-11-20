<template>
  <div id="board-list">
  <div id="community-image">asdf</div>
    <div class="box">
    <div class="button-group">
      <button type="button" class="btn btn-outline-primary">정보</button>
      <button type="button" class="btn btn-outline-secondary">질문</button>
      <button type="button" class="btn btn-outline-success">자유</button>
      <button type="button" class="btn btn-outline-danger">인기글</button>
      <button type="button" class="btn btn-outline-warning">유머</button>
    </div>
      <table class="board-table">
        <tbody>
          <tr v-for="(boardItem, index) in store.boardList" :key="boardItem.boardId">
            <router-link class="detail" :to="{ name: 'detail', params: { id: boardItem.boardId } }">
              <div class="card">
                <div class="textbox">
                  <div class="title">
                    {{ boardItem.boardTitle }}
                  </div>
                  <div class="content">
                    {{ boardItem.boardContent }}
                  </div>
                </div>
                <img src="../../assets/main/space.jpeg" id="boardImg">
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
.box {
  margin-top: 50px;
  margin-left: 300px;
  margin-right: 300px;
}

#community-image {
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