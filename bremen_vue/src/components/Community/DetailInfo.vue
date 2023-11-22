<template>
  <tr>
    <template v-if="dynamicProps.boardType === 'info'">
      <div type="button" class="card" :class="{ 'toggle': toggle }" @click="toggleOn()">
        <div v-if="!toggle" class="textbox">
          <div class="simple-head">
            <div class="simple-profile-img"></div>
            <div class="simple-btitle">
              {{ dynamicProps.boardTitle }}
            </div>
          </div>
          <div class="simple-content">
            {{ dynamicProps.boardContent }}
          </div>
          <div>
            <img src="../../assets/main/space.jpeg" id="boardImg">
          </div>
        </div>
        <!-- 펼침상태 -->
        <div v-else>
          <div class="detail-textbox">
            <div class="detail-btitle">
              {{ dynamicProps.boardTitle }}
            </div>
            <hr>
            <div class="detail-writer">
              <div class="detail-profile-img"></div>
              {{ dynamicProps.boardWriter }}
            </div>
            <div class="a">
              <img src="../../assets/main/space.jpeg" id="boardImg">
            </div>
            <div class="detail-content">
              {{ dynamicProps.boardContent }}
            </div>
          </div>
          <div class="button-box">
            <div class="boomup-btn">
              <button class="btn btn-primary">
                <img src="../../assets/boomup.png" id="boomup-img">
              </button>
              <button class="btn btn-danger">
                <img src="../../assets/boomdown.png" id="boomdown-img">
              </button>
            </div>
            <div class="crud">
              <button class="btn btn" data-bs-toggle="modal" data-bs-target="#aa" data-bs-whatever="@mdo"
                @click.stop="up(dynamicProps.boardId)">수정</button>
              <button class="btn" @click.stop="deleteBoard(dynamicProps.boardId)">삭제</button>
            </div>
          </div>
          <hr>
          <div class="review-list" v-for="(comm, index) in dynamicProps.reviewList" :key="comm.reviewId">
            {{ index + 1 }} | {{ comm.reviewWriter }} | {{ comm.reviewContent }}
          </div>
          <div>
            <br>
            <br>
            <hr>
          </div>
        </div>
      </div>
      <div class="modal fade" id="aa" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
          <div class="modal-content">
            <!-- 모달 내용 -->
            <div class="modal-body">
              <form>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">제목</label>
                  <input type="text" class="form-control" v-model="store.board.boardTitle">
                </div>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">작성자</label>
                  <input type="text" class="form-control" v-model="store.board.boardWriter" readonly>
                </div>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">내용</label>
                  <textarea class="form-control" rows="10" v-model="store.board.boardContent"></textarea>
                </div>
              </form>
            </div>
            <!-- 모달 푸터 -->
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary" @click="update" data-bs-dismiss="modal">수정</button>
            </div>
          </div>
        </div>
      </div>
    </template>
  </tr>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router'
import { useBoardStore } from '@/stores/board'


defineProps({
  dynamicProps: Object
})

const router = useRouter();
const toggle = ref(false);
const edit = ref({});
const store = useBoardStore();

const up = function (id) {
  store.getBoard(id)
}

const update = function () {
  updateBoard();
}

const toggleOn = function () {
  toggle.value = !toggle.value
}



const deleteBoard = function (id) {
  axios.delete(`http://localhost:8080/api/board/${id}`)
    .then(() => {
      window.location.reload()
      alert("게시글이 삭제되었습니다.")
    })
}

const updateBoard = function () {
  axios.put(`http://localhost:8080/api/board`, store.board)
    .then(() => {
      window.location.reload()
      router.push({ name: edit.boardType, params: { id: edit.value.boardId, category: edit.value.boardCategory } });
      alert("게시글이 수정되었습니다.")
    })
    .catch((err) => {
      console.log(err);
    });
}

</script>

<style scoped>
.a {
  display: flex;
  justify-content: center;
  align-items: center;
}

.textbox {
  position: relative;
  padding-left: 30px;
  height: 70%;
  overflow: hidden;
}

.textbox .title {
  height: 20%;
}

.button-box {
  display: flex;
  justify-content: space-between;
}

.boomup-btn {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 15%;
  position: absolute;
  right: 43%;
  bottom: 10px;
}

.boomup-btn .btn {
  padding: 0px !important;
}

.review-list {
  display: flex;
  flex-direction: column !important;
  padding: 3px;
  margin-left: 30px
}


#boomup-img {
  width: 40px;
  height: 40px;
  padding: 0px !important;
}


#boomdown-img {
  width: 40px;
  height: 40px;
  padding: 0px !important;
}


.crud {
  display: flex;
  flex-direction: row;
  justify-content: right;
  width: 40%;
  position: absolute;
  bottom: 10px;
  right: 10px;
}

.crud .btn {
  font-weight: 550;
  color: rgb(114, 112, 112);
  width: 25%;
  margin-left: 10px;
  background-color: #E9ECEF;
}

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
  background-color: rgb(156, 162, 162);
}

.toggle {
  height: fit-content;
  overflow: hidden;
  transition: all 0.6s ease-out;
}

.card * {
  padding: 5px;
}

.textbox {
  display: flex;
  flex-direction: column;
  padding-left: 30px;
}

.card {
  font-size: 25px;

}

.simple-btitle {
  font-weight: 700;
}

.detail-btitle {
  font-weight: 700;
}

#boardImg {
  width: 80%;
  align-items: center;
  border-radius: 25px;
}

.detail-writer {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 20px;
  font-weight: 400;
}

.simple-head{
  display: flex;
  align-items: center;
}
.simple-profile-img {
  background-image: url(../../assets/group/profile.png);
  background-size: cover;
  width: 30px;
  height: 30px;
  margin-right: 15px;
}
.detail-profile-img {
  background-image: url(../../assets/group/profile.png);
  background-size: cover;
  width: 50px;
  height: 50px;
  margin-right: 15px;
}

.simple-content {
  margin-top: 8px;
  margin-bottom: 3px;
  margin-left: 10px;
  font-size: 16px;
  font-weight: 500;
  color: #212529BF;

}

.detail-content {
  margin-top: 30px;
  margin-left: 50px;
  font-size: 20px;
  font-weight: 500;
  color: #212529BF;

}</style>