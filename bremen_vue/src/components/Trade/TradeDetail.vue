<template>
    <div>
       <h4>게시글 상세</h4>
       <hr>
       <div>{{ store.trade.tradeTitle }}</div>
       <div>{{ store.trade.tradeWriter }}</div>
       <div>{{ store.trade.tradeDate }}</div>
       <div>{{ store.trade.tradeViewCnt }}</div>
       <div>{{ store.trade.tradeContent }}</div>

       <button @click="deleteTrade">삭제</button>
       <button @click="updateTrade">수정</button>
   </div>
</template> 

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { useTradeStore } from "../../stores/trade";
import { onMounted } from "vue";
import axios from 'axios';

const store = useTradeStore()
const route = useRoute();
const router = useRouter();

onMounted(() => {
   store.getTrade(route.params.id)
   console.log(store.trade)
})

const deleteTrade = function () {
   axios.delete(`http://localhost:8080/tradeapi/trade/${route.params.id}`)
       .then(() => {
         window.location.reload()
           router.push({ name: 'trade', params:{ id: route.params.category} })
           alert("게시글이 삭제되었습니다.")
       })
}

const updateTrade = function () {
   router.push({ name: 'tradeUpdate' })
}
</script>

<style scoped>

</style>