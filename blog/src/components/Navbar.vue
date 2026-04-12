<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const emit = defineEmits(['open-login'])

const navItems = [
  { name: '首页', path: '/', icon: '🏠' },
  { name: '家', path: '/family', icon: '🏩' },
  { name: '随笔', path: '/essays', icon: '📝' },
  { name: '记录', path: '/records', icon: '📋' },
  { name: '相册', path: '/album', icon: '📷' },
  { name: '百宝箱', path: '/toolbox', icon: '🧰' },
  { name: '留言', path: '/guestbook', icon: '💬' },
  { name: '联系我', path: '/contact', icon: '✉️' },
]

const isActive = (path) => {
  return route.path === path
}

const openLogin = () => {
  emit('open-login')
}
</script>

<template>
  <nav class="navbar">
    <div class="nav-brand">
      <router-link to="/">Luojun</router-link>
    </div>
    
    <div class="nav-menu">
      <router-link 
        v-for="item in navItems" 
        :key="item.path"
        :to="item.path"
        class="nav-item"
        :class="{ active: isActive(item.path) }"
      >
        <span class="nav-icon">{{ item.icon }}</span>
        <span class="nav-text">{{ item.name }}</span>
      </router-link>
    </div>
    
    <div class="nav-actions">
      <button class="login-btn" @click="openLogin">登录</button>
    </div>
  </nav>
</template>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 60px;
  background: transparent;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 30px;
  z-index: 1000;
  transition: all 0.3s ease;
}

.navbar:hover {
  background: rgba(0, 0, 0, 0.3);
  backdrop-filter: blur(10px);
}

.nav-brand a {
  font-size: 24px;
  font-weight: bold;
  color: white;
  text-decoration: none;
  letter-spacing: 1px;
}

.nav-menu {
  display: flex;
  align-items: center;
  gap: 8px;
}

.nav-item {
  display: flex;
  align-items: center;
  gap: 6px;
  padding: 8px 14px;
  color: rgba(255, 255, 255, 0.8);
  text-decoration: none;
  border-radius: 20px;
  transition: all 0.3s;
  font-size: 14px;
  font-family: 'Quicksand', sans-serif;
}

.nav-item:hover {
  background: rgba(255, 255, 255, 0.1);
  color: white;
}

.nav-item.active {
  background: rgba(255, 255, 255, 0.2);
  color: white;
}

.nav-icon {
  font-size: 16px;
}

.nav-text {
  font-size: 14px;
}

.nav-actions {
  display: flex;
  align-items: center;
}

.login-btn {
  background: linear-gradient(135deg, #ff6b9d, #c44569);
  color: white;
  border: none;
  padding: 8px 20px;
  border-radius: 20px;
  font-size: 14px;
  cursor: pointer;
  transition: all 0.3s;
}

.login-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 15px rgba(196, 69, 105, 0.4);
}

@media (max-width: 900px) {
  .nav-menu {
    display: none;
  }
}
</style>
