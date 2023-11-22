<template>
   <div class="group-detail">
      <h4>{{ store.group.groupTitle }}</h4>
      <hr />
      <div class="detail-head">
      <div class="detail-user">
         <div class="profile-img"></div>
         <div class="detail-writer">{{ store.group.groupWriter }}</div>
      </div>
         <div class="detail-button">
            <button @click="updateBoard" style="background-color: white; border: 0;">
               <img src="../../assets/group/update.png" class="button-img" />
            </button>
            <button @click="deleteGroup" style="background-color: white; border: 0;">
               <img src="../../assets/group/trash2.png" class="button-img" />
            </button>
         </div>
      </div>
      <div>
         <!-- 카카오 맵 코드 직접 작성 -->
         <div id="map" style="width: 40%; height: 400px; border-radius:20px;"></div>
      </div>
      <div class="detail-content">{{ store.group.groupContent }}</div>
      <div class="detail-recruit">
         <div>현재 인원 : {{ store.group.groupCurrentPeople }}</div>
         <div>모집 인원 : {{ store.group.groupMaxPeople }}</div>
      </div>
      <div class="detail-else">
         <div>조회수 : {{ store.group.groupViewCnt }}</div>
         <div>일정 : {{ store.group.groupDate }} {{ store.group.groupTime }}</div>
      </div>
      <hr />
   </div>
</template>
 
<script setup>
import { useRoute, useRouter } from 'vue-router'
import { useGroupStore } from "../../stores/group";
import { onMounted } from "vue";
import axios from 'axios';

const store = useGroupStore()
const route = useRoute();
const router = useRouter();

onMounted(() => {
   store.getGroup(route.params.id);

   // 카카오 맵 초기화
   loadKakaoMap();
});

const deleteGroup = function () {
   axios.delete(`http://localhost:8080/groupapi/group/${route.params.id}`)
      .then(() => {
         router.push({ name: 'group', params: { id: route.params.category } })
         alert("게시글이 삭제되었습니다.")
      })
}

const updateBoard = function () {
   router.push({ name: 'groupUpdate' })
}

// 카카오 맵 초기화 함수
const loadKakaoMap = () => {
   const script = document.createElement("script");
   script.src =
      "https://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9c2e2b61d467effcf3ddff2aba363dd9&libraries=services";
   document.head.appendChild(script);

   script.onload = () => {
      window.kakao.maps.load(() => {
         initializeMap();
      });
   };
}

const initializeMap = () => {
   const mapContainer = document.getElementById("map");
   const mapOptions = {
      center: new window.kakao.maps.LatLng(
         parseFloat(store.group.positionX),
         parseFloat(store.group.positionY)
      ),
      level: 3,
   };

   const map = new window.kakao.maps.Map(mapContainer, mapOptions);

   const markerPosition = new window.kakao.maps.LatLng(
      parseFloat(store.group.positionX),
      parseFloat(store.group.positionY)
   );

   const marker = new window.kakao.maps.Marker({
      position: markerPosition,
      map: map,
   });

   map.setCenter(markerPosition);
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
   gap:20px;
}

.profile-img {
   background-image: url('../../assets/group/profile.png');
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
   font-size: 25px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 30px;
}

.detail-recruit {
   display: flex;
   gap: 20px;
   font-size: 20px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 50px;
}

.detail-else {
   display: flex;
   gap: 40px;
   margin-left: 600px;
}</style>
 