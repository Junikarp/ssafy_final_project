<template>
  <tr>
    <template v-if="dynamicProps.boardType === 'humor'">
      <div type="button" class="card" :class="{ 'toggle': toggle }" @click="toggleOn">
        <div v-if="!toggle" class="textbox">
          <div class="title">
            {{ dynamicProps.boardTitle }}
          </div>
          <div class="content">
            {{ dynamicProps.boardContent }}
          </div>
        </div>
        <!-- 펼침상태 -->
        <div v-else>
          <div class="textbox">
            <div class="writer">
              작성자 : {{ dynamicProps.boardWriter }}
            </div>
            <div class="title">
              {{ dynamicProps.boardTitle }}
            </div>
            <div class="content">
              {{ dynamicProps.boardContent }}
            </div>
          </div>
          <div class="button-box">
            <div class="review-box">
              <button>review</button>
            </div>
            <div class="boomup-btn">
              <button class="btn btn-primary">
                <img src="../../assets/boomup.png" id="boomup-img">
              </button>
              <button class="btn btn-danger">
                <img src="../../assets/boomdown.png" id="boomdown-img">
              </button>
            </div>
            <div class="crud">
              <button class="btn btn">수정</button>
              <button class="btn btn-outlin">삭제</button>
            </div>
          </div>
        </div>
        <img src="../../assets/main/space.jpeg" id="boardImg">
      </div>
    </template>
  </tr>
</template>

<script setup>
import { ref } from 'vue';
defineProps({
  dynamicProps: Object
})

const toggle = ref(false);

const toggleOn = function () {
  toggle.value = !toggle.value
}

</script>

<style scoped>
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
  right:43%;
  bottom: 10px;
}

.boomup-btn .btn {
  padding: 0px !important;
}

.review-box {
  position: absolute;
  bottom: 10px;
  width: 30%;
}

#boomup-img {
  width: 40px;
  height: 40px;
  padding: 0px !important;
}

.boomdown {
  padding: 0px !important;
  margin: 10px;
}

#boomdown-img {
  width: 40px;
  height: 40px;
  padding: 0px !important;
}

.boomup {
  padding: 0px !important;
  margin: 10px;
}

.box {
  margin-top: 50px;
  margin-left: 300px;
  margin-right: 300px;
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
  transition: 0.2s;
}

.card:hover {
  background-color: rgb(156, 162, 162);
}

.toggle {
  height: 400px;
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