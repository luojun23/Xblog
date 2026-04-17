<script setup>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import Navbar from './components/Navbar.vue'
import LoginModal from './components/LoginModal.vue'

const route = useRoute()
const showLogin = ref(false)

// 后台路由下隐藏 Navbar
const isAdminRoute = computed(() => {
  return route.path.startsWith('/admin')
})

const openLogin = () => {
  showLogin.value = true
}

const closeLogin = () => {
  showLogin.value = false
}
</script>

<template>
  <div class="app">
    <Navbar v-if="!isAdminRoute" @open-login="openLogin" />
    <router-view />
    <LoginModal v-if="!isAdminRoute" :show="showLogin" @close="closeLogin" />
  </div>
</template>

<style>
.app {
  min-height: 100vh;
}
</style>
