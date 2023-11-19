<template>
     <div>
        <h4>게시글 상세</h4>
        <hr>
        <div>{{ store.board.boardTitle }}</div>
        <div>{{ store.board.boardWriter }}</div>
        <div>{{ store.board.boardRegDate }}</div>
        <div>{{ store.board.boardViewCnt }}</div>
        <div>{{ store.board.boardContent }}</div>

        <tr v-for="(comments, index) in store.board.reviewList" :key="comments.reviewId">
        {{comments.reviewContent}}
        </tr>

        <!-- <button @click="deleteBoard">삭제</button>-->
        <button @click="updateBoard">수정</button>
    </div>
</template> 

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";

const store = useBoardStore()

const route = useRoute();

onMounted(() => {
    store.getBoard(route.params.id)
})
// const deleteBoard = function () {
//     axios.delete(`http://localhost:8080/api/board/${route.params.id}`)
//         .then(() => {
//             router.push({ name: 'BoardList' })
//         })
// }

const updateBoard = function () {
    router.push({ name: 'boardUpdate' })
}
</script>

<style scoped>

</style>