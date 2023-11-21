<template>
    <table class="board-table">
      <tbody>
        <!-- <tr v-for="(boardItem, index) in store.boardList" :key="boardItem.boardId">
        <template v-if="boardItem.boardType === 'info'">
            <div type="button" class="card" :class="{'toggle':toggle}" @click="toggleOn">
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
        </template>
        </tr> -->
        <DetailInfo v-for="boardItem in store.boardList" :key="boardItem.boardId" :dynamic-props="boardItem"></DetailInfo>
      </tbody>
    </table>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute } from 'vue-router'
import DetailInfo from '@/components/Community/DetailInfo.vue'

const store = useBoardStore();
const route = useRoute();
const toggle = ref(false);

const toggleOn = function() {
    toggle.value = !toggle.value
}

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

#main-text {
font-weight: 800;
font-size: 40px;
}

#create-button {
color: rgb(240, 236, 236);
font-size: 20px;
font-weight: 550;
width:200px;
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