<template>
  <NavHeader></NavHeader>
  <div v-if="loginStatus" type="button" class="card" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">
      <img src="../../assets/plus.png" id="create-board-img">
    </div>
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 작성</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">제목</label>
                  <input type="text" class="form-control" id="title" v-model="board.boardTitle">
                </div>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">카테고리</label>
                  <input type="text" class="form-control" id="category" readonly :placeholder="board.boardCategory">
                </div>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">내용</label>
                  <textarea class="form-control" id="content" rows="10" v-model="board.boardContent"></textarea>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary" @click="createBoard" data-bs-dismiss="modal">등록</button>
            </div>
          </div>
      </div>
    </div>
    <table class="board-table">
      <tbody>
        <DetailInfo v-for="boardItem in store.boardList" :key="boardItem.boardId" :dynamic-props="boardItem" data-aos="fade-up" data-aos-duration="1000"></DetailInfo>
      </tbody>
    </table>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { useRoute } from 'vue-router'
import DetailInfo from '@/components/Community/DetailInfo.vue'
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

const createBoard = function () {
  store.createBoard(board.value)
}

const board = ref({
  boardTitle: '',
  boardWriter: ustore.loginUserId,
  boardCategory: route.params.category,
  boardContent: '', 
  boardType: 'info'
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
  transition: 0.2s;
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