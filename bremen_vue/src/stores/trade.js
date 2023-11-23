import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/tradeapi`

export const useTradeStore = defineStore('trade', () => {
  const tradeList = ref([])
  const getTradeList = function (category) {
    axios.get(`${REST_BOARD_API}/trade/${category}`)
      .then((response) => {
        tradeList.value = response.data
      })
  }
  
  //게시글 한개
  const trade = ref({})
  const getTrade = function (id) {
    axios.get(`${REST_BOARD_API}/trade/detail/${id}`)
      .then((response) => {
        trade.value = response.data
      })
  }
  //게시글 등록
  const createTrade = function (trade) {
    axios({
      url: `${REST_BOARD_API}/trade`,
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      data: trade
    })
    .then(() => {
      window.location.reload()
      alert("게시글이 등록되었습니다.")
    })
      .catch((err) => {
      console.log(err)
    })
  }

  const updateTrade = function () {
    axios.put(`${REST_BOARD_API}/trade`, trade.value)
      .then(() => {
        router.push({ name: 'category' , params:{ id: trade.value.tradeId, category: trade.value.tradeCategory }});
        alert("게시글이 수정되었습니다.")
      })
      .catch((err) => {
        console.log(err);
      });
  }
  return {
    tradeList,
    getTradeList,
    trade,
    getTrade,
    createTrade,
    updateTrade,
    // searchBoardList
  }
})
