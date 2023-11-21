import "bootstrap/dist/css/bootstrap.min.css";
import "./css/reset.css";

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";

const app = createApp(App);

app.use(createPinia());
app.use(router);

app.mount("#app");

import "bootstrap/dist/js/bootstrap.js";

// 카카오 로그인 앱키
window.Kakao.init("952a820ea47f5522840fbe0b479967cd");