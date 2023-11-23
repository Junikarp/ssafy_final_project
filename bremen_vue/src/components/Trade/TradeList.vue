<template>
  <NavHeader></NavHeader>
  <section class="notice">

    <div class="main-text" data-aos="fade-up" data-aos-duration="5000">BREMEN</div>
    <div class="sub-text" data-aos="fade-up" data-aos-duration="5000">쓰지않는 물건 서로 판다 윈윈</div>


    <!-- board list area -->
    <div id="board-list">
      <div class="container">
        <div class="search">
          <input type="text" placeholder="희망 지역을 입력하세요" style="font-size: 20px;" v-model="place">
          <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" type="button"
            @click="search">
        </div>
        <router-link :to="{ name: 'tradeCreate' }" type="button" class="card">
          <img src="../../assets/plus.png" id="create-board-img">
        </router-link>
        <router-link class="board-box" :to="{ name: 'tradeDetail', params: { id: tradeItem.tradeId } }"
          v-for="tradeItem in store.tradeList" :key="tradeItem.tradeId">
          <div class="box-item">
            <div class="box-up">
              <div class="profile-img"></div>
              <div class="group-title">{{ tradeItem.tradeTitle }}</div>
            </div>
            <div class="group-content"> {{ tradeItem.tradeContent }}</div>
            <div class="detail-bind">
              <div class="group-detail"> 지역 : {{ tradeItem.tradePlace }}</div>
              <div class="group-detail"> 가격 : {{ tradeItem.tradePrice }} 원</div>
            </div>
          </div>
        </router-link>
      </div>
    </div>
  </section>
</template>
  
<script setup>
import { onMounted, ref } from 'vue';
import { useTradeStore } from '../../stores/trade';
import { useRoute } from 'vue-router'
import axios from 'axios';
import NavHeader from '../NavHeader.vue';

const store = useTradeStore();
const route = useRoute();
const place = ref();

const search = function () {
  axios.get(`http://localhost:8080/tradeapi/trade/search/${place.value}`)
    .then((response) => {
      store.tradeList = response.data
    })
}

onMounted(() => {
  store.getTradeList(route.params.category);
  console.log(store.tradeList)
});

</script>
  
  
<style scoped>
#create-board-img {
  width: 70px;
}

.card {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border-radius: 20px;
  padding: 20px;
  margin-bottom: 30px;
  width: 87%;
  height: 150px;
}

.card:hover {
  background-color: rgb(156, 162, 162);
}

.group-img {
  background-image: url("../../assets/community");
  height: 600px;
  width: 100%;
}

.main-text {
  margin: 50px;
  font-weight: 800;
  text-align: center;
  font-size: 50px;
}

.sub-text {
  text-align: center;
  font-weight: 600;
  font-size: 25px;
  color: #212529BF;
}

#board-list {
  margin: 50px;
  margin-top: 100px;
  padding-left: 30px;
  padding-right: 30px;

}

.container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: center;
}

.board-box {
  width: 100%;
  height: 150px;
  margin-left: 40px;
  margin-right: 40px;
  padding: 40px;
  text-decoration: none;
  margin-bottom: 30px;

}

.profile-img {
  background-image: url('../../assets/profile.png');
  background-size: cover;
  width: 50px;
  height: 50px;
  margin-right: 15px;
}

.group-title {

  font-size: 35px;
  font-weight: 600;
  color: rgb(37, 37, 37);

}

.group-content {

  text-align: left;
  font-size: 25px;
  font-weight: 600;
  color: #212529BF;
  height: 50%;
  width: 100%;
  margin-left: 30px;

}
.group-detail {
  text-align: left;
  font-size: 18px;
  font-weight: 600;
  color: #212529BF;
  margin-left: 30px;

}

.board-box:hover {
  height: auto;
  opacity: 0.6;
  border-radius: 5px;
}


.box-item {
  display: flex;
  flex-direction: column;
  align-items: start;
  justify-content: center;
  gap: 30px;
}

.box-up {
  display: flex;
  align-items: center;
}

.search {
  position: relative;
  width: 87%;
  margin-bottom: 40px;

}

.search input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

.search img {
  position: absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}
.detail-bind{
  display: flex;
  flex-wrap: nowrap;
}
</style>