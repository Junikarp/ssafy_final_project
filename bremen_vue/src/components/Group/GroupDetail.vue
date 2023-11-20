<template>
    <!-- <div>
       <h4>게시글 상세</h4>
       <hr>
       <div>{{ store.group.groupTitle }}</div>
       <div>{{ store.group.groupWriter }}</div>
       <div>{{ store.group.groupDate }}</div>
       <div>{{ store.group.groupViewCnt }}</div>
       <div>{{ store.group.groupontent }}</div>

       <button @click="deleteBoard">삭제</button>
       <button @click="updateBoard">수정</button>
   </div> -->
</template> 

<script setup>
// import { useRoute, useRouter } from 'vue-router'
// import { useGroupstore } from "../../stores/group";
// import { onMounted } from "vue";
// import axios from 'axios';

// const store = useGroupstore()
// const route = useRoute();
// const router = useRouter();

// onMounted(() => {
//    store.getBoard(route.params.id)
// })

// const deleteBoard = function () {
//    axios.delete(`http://localhost:8080/api/group/${route.params.id}`)
//        .then(() => {
//            router.push({ name: 'group', params:{ id: route.params.category} })
//            alert("게시글이 삭제되었습니다.")
//        })
// }

// const updateBoard = function () {
//    router.push({ name: 'groupUpdate' })
// }
</script>

<style scoped>

</style>