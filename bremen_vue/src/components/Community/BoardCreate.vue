<template>
    <div>
        <h4>게시글 작성</h4>
        <fieldset>
            <legend>등록</legend>
            <div class="create-box">
                <div class="create-input-box">
                    <label for="title"></label>
                    <input type="text" id="title" v-model="board.boardTitle" placeholder="title">
                </div>
                <div class="create-input-box">
                    <label for="writer"></label>
                    <input type="text" id="writer" v-model="board.boardWriter" placeholder="writer">
                </div>
                <div class="create-input-box">
                    <label for="category"></label>
                    <textarea id="category" cols="30" rows="10" readonly>{{this.$route.params.category}}</textarea>
                </div>
                <div class="create-input-box">
                    <label for="content"></label>
                    <textarea id="content" cols="30" rows="10" v-model="board.boardContent" placeholder="content"></textarea>
                </div>
                <div>
                    <button class="custom-btn btn-3" @click.prevent="createBoard"><span>CREATE!</span></button>
                </div>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { useBoardStore } from "@/stores/board";
import { useRoute } from "vue-router";

const route = useRoute();

const store = useBoardStore()
const board = ref({
    boardTitle: '',
    boardWriter: '',
    boardCategory: route.params.category,
    boardContent: ''
})

const createBoard = function () {
    store.createBoard(board.value)
}
</script>

<style scoped>
.create-box {
    background-color: #FFFFFF;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    width: 100%;
    height: 100%;
    text-align: center;
}

.create-input-box {
    background-color: #FFFFFF;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    width: 100%;
    height: 100%;
    text-align: center;
    margin-bottom: 20px;
}

input {
    width: 30%;
    height: 20%;
    border-radius: 5px;
}

textarea {
    width: 30%;
}

.custom-btn {
    width: 130px;
    height: 40px;
    color: #fff;
    border-radius: 5px;
    padding: 10px 25px;
    font-family: 'Lato', sans-serif;
    font-weight: 500;
    background: transparent;
    cursor: pointer;
    transition: all 0.3s ease;
    position: relative;
    display: inline-block;
    box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
        7px 7px 20px 0px rgba(0, 0, 0, .1),
        4px 4px 5px 0px rgba(0, 0, 0, .1);
    outline: none;
}

.btn-3 {
    background: rgb(0, 172, 238);
    background: linear-gradient(0deg, rgba(0, 172, 238, 1) 0%, rgba(2, 126, 251, 1) 100%);
    width: 130px;
    height: 40px;
    line-height: 42px;
    padding: 0;
    border: none;

}

.btn-3 span {
    position: relative;
    display: block;
    width: 100%;
    height: 100%;
}

.btn-3:before,
.btn-3:after {
    position: absolute;
    content: "";
    right: 0;
    top: 0;
    background: rgba(2, 126, 251, 1);
    transition: all 0.3s ease;
}

.btn-3:before {
    height: 0%;
    width: 2px;
}

.btn-3:after {
    width: 0%;
    height: 2px;
}

.btn-3:hover {
    background: transparent;
    box-shadow: none;
}

.btn-3:hover:before {
    height: 100%;
}

.btn-3:hover:after {
    width: 100%;
}

.btn-3 span:hover {
    color: rgba(2, 126, 251, 1);
}

.btn-3 span:before,
.btn-3 span:after {
    position: absolute;
    content: "";
    left: 0;
    bottom: 0;
    background: rgba(2, 126, 251, 1);
    transition: all 0.3s ease;
}

.btn-3 span:before {
    width: 2px;
    height: 0%;
}

.btn-3 span:after {
    width: 0%;
    height: 2px;
}

.btn-3 span:hover:before {
    height: 100%;
}

.btn-3 span:hover:after {
    width: 100%;
}
</style>