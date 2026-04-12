<script setup>
import { ref } from 'vue'
import Navbar from './components/Navbar.vue'
import LoginModal from './components/LoginModal.vue'

const showLogin = ref(false)

const openLogin = () => {
  showLogin.value = true
}

const closeLogin = () => {
  showLogin.value = false
}
</script>

<template>
  <div class="app">
    <Navbar @open-login="openLogin" />
    <router-view />
    <LoginModal :show="showLogin" @close="closeLogin" />
  </div>
</template>

<style>
.app {
  min-height: 100vh;
}
</style>
