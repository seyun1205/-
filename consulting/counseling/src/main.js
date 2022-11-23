import {createApp} from 'vue'
import App from './App.vue'
import router from "./router/router";
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

import {deleteRequest, getRequest, postRequest, putRequest} from "@/utils/request";


const app = createApp(App);
app.use(router);
app.use(ElementPlus);
app.config.globalProperties.postRequest = postRequest;
app.config.globalProperties.getRequest = getRequest;
app.config.globalProperties.putRequest = putRequest;
app.config.globalProperties.deleteRequest = deleteRequest;
app.mount('#app')