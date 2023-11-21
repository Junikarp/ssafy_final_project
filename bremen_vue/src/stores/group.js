import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_GROUP_API = `http://localhost:8080/groupapi`

export const useGroupStore = defineStore('group', () => {
    const groupList = ref([])
  const getGroupList = function (category) {
    axios.get(`${REST_GROUP_API}/group/${category}`)
      .then((response) => {
        groupList.value = response.data
      })
  }

  //게시글 한개
  const group = ref({})
  const getGroup = function (id) {
    axios.get(`${REST_GROUP_API}/group/detail/${id}`)
      .then((response) => {
        group.value = response.data
      })
  }
  //게시글 등록
  const createGroup = function (group) {
    console.log(group)
    axios({
      url: `${REST_GROUP_API}/group`,
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      data: group
    })
    .then(() => {
      router.push({ name: 'category'});
    })
      .catch((err) => {
      console.log(err)
    })
  }
  const updateBoard = function () {
    axios.put(`${REST_BOARD_API}/group`, group.value)
      .then(() => {
        router.push({ name: 'groupDetail' , params:{ id: group.value.groupId, category: group.value.groupCategory }});
        alert("게시글이 수정되었습니다.")
      })
      .catch((err) => {
        console.log(err);
      });
  }
  return {
    groupList,
    getGroupList,
    group,
    getGroup,
    createGroup
  }
});