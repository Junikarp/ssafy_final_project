<template>
  <section class="notice">

    <div class="group-img"></div>
    <div class="logo" data-aos="fade-up" data-aos-duration="5000"><router-link :to="{ name: 'home' }"
                style="text-decoration: none; color: black;">BREMEN</router-link></div>
    <div class="sub-text" data-aos="fade-up" data-aos-duration="5000">근처에 있는 사람들과 함께할 수 있어요</div>


    <!-- board list area -->
    <div id="board-list">
      <div class="container">
        <router-link :to="{ name: 'groupCreate'}" type="button" class="card">
          <img src="../../assets/plus.png" id="create-board-img">
        </router-link>
        <router-link class="board-box"
          v-for="groupItem in store.groupList" :key="groupItem.groupId" :to="{ name: 'groupDetail', params: { id: groupItem.groupId }}" data-aos="fade-up" data-aos-duration="5000">
          <div class="box-item">
            <div class="box-up">
              <div class="profile-img"></div>
              <div class="group-title">{{ groupItem.groupTitle }}</div>
            </div>
            <div class="group-content"> {{ groupItem.groupContent }}</div>
            <div class="group-detail">
              <div class="group-current">현재 인원 : {{ groupItem.groupCurrentPeople }}</div>
              <div class="group-Max">모집인원 : {{ groupItem.groupMaxPeople }}</div>
              <div class="group-writer">작성자 : {{ groupItem.groupWriter }}</div>
            </div>
          </div>
          <hr>
        </router-link>
      </div>
    </div>
  </section>
</template>
  
<script setup>
import { onMounted } from 'vue';
import { useGroupStore } from '../../stores/group';
import { useRoute } from 'vue-router'

const store = useGroupStore();
const route = useRoute();

onMounted(() => {
  store.getGroupList(route.params.category);
  console.log(route.params.category)
});

</script>
  
  
<style scoped>
hr {
  color: black;
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
  background-image: url("../../assets/group/grouplistimg.jpg");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 700px;
  width: 100%;
  
}

#create-board {
  display: flex;
  justify-content: center;
  align-items: center;
}

#create-board-img {
  width: 70px;
}

.logo {
  font-weight: 800;
    font-size: 50px;
    text-align: center;
    margin: 50px;
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

.board-box:hover {
  height: auto;
  
  opacity: 0.1;
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

.group-detail {
  display: flex;
  padding-left: 40px;
  gap: 20px;
  font-size: 15px;
  font-weight: 600;
  color: #212529BF;
}
</style>