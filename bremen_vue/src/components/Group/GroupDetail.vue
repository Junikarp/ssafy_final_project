<template>
   <div class="group-detail">
      <h4>{{ store.group.groupTitle }}</h4>
      <hr>
      <div class="detail-head">
         <div class="profile-img"></div>
         <div class="detail-writer">{{ store.group.groupWriter }}</div>
         <div class="detail-button">
            <button @click="updateBoard" style="background-color: white; border: 0;"><img src="../../assets/group/update.png" class="button-img"></button>
            <button @click="deleteGroup" style="background-color: white; border: 0;"><img src="../../assets/group/trash2.png" class="button-img"></button>
         </div>
      </div>
      <div class="detail-content">{{ store.group.groupContent }}</div>
      <div class="detail-recruit">
         <div>현재 인원 : {{ store.group.groupCurrentPeople }}</div>
         <div>모집 인원 : {{ store.group.groupMaxPeople }}</div>
      </div>
      <div class="detail-else">
         <div>조회수 : {{ store.group.groupViewCnt }}</div>   
         <div>작성일 : {{ store.group.groupDate }}</div>
      </div>
      <hr>

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
   store.getGroup(route.params.id)
})

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
</script>

<style scoped>
.group-detail {
   margin-left: 100px;
   margin-right: 100px;
}

.detail-head {
   display: flex;
   align-items: center;
   gap: 20px;
   margin-bottom: 40px;
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

.detail-button{
   display: flex;
   margin-left: 650px;
   gap: 20px;
}
.button-img{
   width: 30px;
   height: 30px;
}
.detail-content{
   font-size: 25px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 30px;
}
.detail-recruit{
   display: flex;
   gap: 20px;
   font-size: 20px;
   font-weight: 500;
   color: #212529BF;
   margin-bottom: 50px;
}
.detail-else{
   display: flex;
   gap: 40px;
   margin-left: 600px;
}
</style>