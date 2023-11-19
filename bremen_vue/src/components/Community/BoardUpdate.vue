<template>
    <div>
        <h4>게시글 수정</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="store.board.title">
            </div>
            <div>
                <label for="writer">쓰니 : </label>
                <input type="text" id="writer" readonly v-model="store.board.writer">
            </div>
            <div>
                <label for="category">내용 : </label>
                <textarea id="category" cols="10" rows="10" readonly v-model="category"></textarea>
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.board.content"></textarea>
            </div>
            <div>
                <button @click="updateBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";
const store = useBoardStore();

const updateBoard = function () {
    store.updateBoard()
}

onMounted(() => {
    console.log(category)
})
</script>

<style scoped></style>