<template>
  <div id="board-list">
    <div id="community-image">
    </div>
    <div class="main-text" data-aos="fade-up" data-aos-duration="5000"><router-link :to="{ name: 'home' }"
                            style="text-decoration: none; color: black;">BREMEN</router-link></div>
    <div class="sub-text" data-aos="fade-up" data-aos-duration="5000">근처에 있는 사람들과 함께할 수 있어요</div>
    <div class="box">
      <div class="button-group" data-aos="fade-up" data-aos-duration="5000">
        <router-link :to="{ name: 'info' }" class="btn">정보</router-link>
        <router-link :to="{ name: 'question' }" class="btn ">질문</router-link>
        <router-link :to="{ name: 'free' }" class="btn">자유</router-link>
        <router-link :to="{ name: 'info' }" class="btn">인기글</router-link>
        <router-link :to="{ name: 'humor' }" class="btn">유머</router-link>
      </div>
        <router-view class="community-board" ></router-view>
      
    </div>
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
  background-image: url("../../assets/community/boardmain2.jpeg");
  background-size: cover;
  background-repeat: no-repeat;
  width: 100%;
  height: 600px;
}

.box{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 50px;
}
.button-group {
  display: flex;
  justify-content: center;
  gap: 30px;
  margin-bottom: 50px;
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
</style>