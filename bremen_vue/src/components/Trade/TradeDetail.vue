<template>
    <div>
       <h4>게시글 상세</h4>
       <hr>
       <div>{{ store.trade.tradeTitle }}</div>
       <div>{{ store.trade.tradeWriter }}</div>
       <div>{{ store.trade.tradeDate }}</div>
       <div>{{ store.trade.tradeViewCnt }}</div>
       <div>{{ store.trade.tradeontent }}</div>

       <button @click="deleteTrade">삭제</button>
       <button @click="updateTrade">수정</button>
   </div>
</template> 

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { useGroupStore } from "../../stores/group";
import { onMounted } from "vue";
import axios from 'axios';

const store = useGroupStore()
const route = useRoute();
const router = useRouter();

onMounted(() => {
   store.getGroup(route.params.id)
})

const deleteBoard = function () {
   axios.delete(`http://localhost:8080/groupapi/group/${route.params.id}`)
       .then(() => {
           router.push({ name: 'group', params:{ id: route.params.category} })
           alert("게시글이 삭제되었습니다.")
       })
}

const updateBoard = function () {
   router.push({ name: 'groupUpdate' })
}
</script>

<style scoped>

</style>