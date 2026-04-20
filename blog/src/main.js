import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
const app = createApp(App)

// Element Plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import constants from './utils/constants'


app.config.globalProperties.Constants = constants


app.use(ElementPlus)
app.use(router)
app.mount('#app')
