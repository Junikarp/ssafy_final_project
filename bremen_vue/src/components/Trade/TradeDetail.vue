<template>
   <NavHeader></NavHeader>
   <div>
      <div class="group-detail">
         <h4>{{ store.trade.tradeTitle }}</h4>
         <hr />
         <div class="detail-head">
            <div class="detail-user">
               <div class="profile-img"></div>
               <div class="detail-writer">{{ store.trade.tradeWriter }}</div>
            </div>
            <div class="detail-button">
               <button @click="updateTrade" style="background-color: white; border: 0;">
                  <img src="../../assets/update.png" class="button-img" />
               </button>
               <button @click="deleteTrade" style="background-color: white; border: 0;">
                  <img src="../../assets/trash2.png" class="button-img" />
               </button>
            </div>
         </div>
         <div class="map-container">

            <div class="detail-content">{{ store.trade.tradeContent }}</div>
            <div class="detail-recruit">
               <div class="detail-recruit2">
               <div>가격 : {{ store.trade.tradePrice }}</div>
            </div>
            <div>장소 : {{ store.trade.tradePlace }}</div>

            </div>
         </div>
         <div class="detail-else">
            <div>조회수 : {{ store.trade.tradeViewCnt }}</div>
         </div>
         <hr>
      </div>
   </div>
</template> 

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { useTradeStore } from "../../stores/trade";
import { onMounted } from "vue";
import axios from 'axios';
import NavHeader from '../NavHeader.vue';

const store = useTradeStore()
const route = useRoute();
const router = useRouter();

onMounted(() => {
   store.getTrade(route.params.id)
})

const deleteTrade = function () {
   axios.delete(`http://localhost:8080/tradeapi/trade/${route.params.id}`)
      .then(() => {
         window.location.reload()
         router.push({ name: 'trade', params: { id: route.params.category } })
         alert("게시글이 삭제되었습니다.")
      })
}

const updateTrade = function () {
   router.push({ name: 'tradeUpdate' })
}
</script>

<style scoped>
.group-detail {
   margin-left: 100px;
   margin-right: 100px;
}

.detail-head {
   display: flex;
   justify-content: space-between;
   align-items: center;
   gap: 20px;
   margin-bottom: 40px;
}

.detail-user {
   display: flex;
   align-items: center;
   gap: 20px;
}

.profile-img {
   background-image: url('../../assets/profile.png');
   background-size: cover;
   height: 50px;
   width: 50px;
}

.detail-writer {
   font-size: 25px;
   font-weight: 300;
}

.detail-button {
   display: flex;
   margin-left: 650px;
   gap: 20px;
}

.button-img {
   width: 30px;
   height: 30px;
}

.detail-content {
   margin-top: 40px;
   font-size: 25px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 30px;
   justify-content: left;
}

.detail-recruit {
   display: flex;
   flex-direction: column;
   gap: 20px;
   font-size: 20px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 50px;
}

.detail-recruit2 {
   display: flex;
   gap: 20px;
}

.detail-else {
   display: flex;
   flex-direction: row-reverse;
   gap: 40px;
   margin-right: 20px;
}

.map-container {
   margin-left: 50px;
   margin-right: 50px;
}

#map {
   width: 100%;
   height: 400px;
   border-radius: 20px;
}

.participate-button {
   background-color: #E9ECEF;
   color: #212529;
   font-size: 20px;
   font-weight: 500;
   border: none;
   border-radius: 6px;
   text-decoration: none;
   padding: 12px 2rem;
   display: inline-block;

}
</style>