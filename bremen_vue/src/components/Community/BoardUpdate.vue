<template>
    <NavHeader></NavHeader>
    <div>
        <h4>게시글 수정</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="store.board.boardId">
            </div>
            <div>
                <label for="writer">쓰니 : </label>
                <textarea type="text" id="writer" readonly v-model="store.board.boardWriter"></textarea>
            </div>
            <div>
                <label for="category">쓰니 : </label>
                <textarea type="text" id="category" readonly v-model="store.board.boardCategory"></textarea>
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.board.boardContent"></textarea>
            </div>
            <div>
                <button @click="updateBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import NavHeader from '../NavHeader.vue';
const store = useBoardStore();

const updateBoard = function () {
    store.updateBoard()
}
</script>

<style scoped></style>