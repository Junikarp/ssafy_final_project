import "bootstrap/dist/css/bootstrap.min.css";
import "./css/reset.css";
import "bootstrap/dist/js/bootstrap.js";
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";

import AOS from 'aos';
import "aos/dist/aos.css";


const app = createApp(App);
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate)
AOS.init();



app.use(pinia);
app.use(router);

app.mount("#app");


// 카카오 로그인 앱키
window.Kakao.init("952a820ea47f5522840fbe0b479967cd");