import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/api`

export const useBoardStore = defineStore('board', () => {
  const boardList = ref([])
  const getBoardList = function (category) {
    axios.get(`${REST_BOARD_API}/board/${category}`)
      .then((response) => {
        boardList.value = response.data
      })
  }
  
  //게시글 한개
  const board = ref({})
  const getBoard = function (id) {
    axios.get(`${REST_BOARD_API}/detail/${id}`)
      .then((response) => {
        board.value = response.data
      })
  }
  //게시글 등록
  const createBoard = function (board) {
    console.log(board)
    axios({
      url: `${REST_BOARD_API}/board`,
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      data: board
    })
    .then(() => {
      router.push({ name: 'board'});
      alert("게시글이 등록되었습니다.")
    })
      .catch((err) => {
      console.log(err)
    })
  }

  const updateBoard = function () {
    axios.put(`${REST_BOARD_API}/board`, board.value)
      .then(() => {
        router.push({ name: 'detail' , params:{ id: board.value.boardId, category: board.value.boardCategory }});
        alert("게시글이 수정되었습니다.")
      })
      .catch((err) => {
        console.log(err);
      });
  }
  return {
    boardList,
    getBoardList,
    board,
    getBoard,
    createBoard,
    updateBoard,
    // searchBoardList
  }
})
