<template>
  <nav class="navbar">
    <div class="nav-brand">
      <router-link to="/">Luojun</router-link>
    </div>
    
    <div class="nav-menu">
      <!-- 首页下拉菜单 -->
      <div class="nav-item dropdown">
        <span class="nav-icon">🏡</span>
        <span class="nav-text">首页</span>
        <div class="dropdown-menu">
          <router-link 
            v-for="item in homeDropdownItems" 
            :key="item.path"
            :to="item.path"
            class="dropdown-item"
            :class="{ active: isActive(item.path) }"
          >
            <span class="dropdown-icon">{{ item.icon }}</span>
            <span>{{ item.name }}</span>
          </router-link>
        </div>
      </div>
      
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
  
  <!-- 移动端底部导航 -->
  <nav class="mobile-nav">
    <router-link 
      v-for="item in navItems.slice(0, 5)" 
      :key="item.path"
      :to="item.path"
      class="mobile-nav-item"
      :class="{ active: isActive(item.path) }"
    >
      <span class="mobile-nav-icon">{{ item.icon }}</span>
      <span>{{ item.name }}</span>
    </router-link>
  </nav>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const emit = defineEmits(['open-login'])

const navItems = [
  { name: '家', path: '/love', icon: '💖' },
  { name: '随笔', path: '/essays', icon: '🏖️' },
  { name: '记录', path: '/records', icon: '📒' },
  { name: '相册', path: '/album', icon: '📷' },
  { name: '百宝箱', path: '/toolbox', icon: '🧰' },
  { name: '留言', path: '/guestbook', icon: '💬' },
  { name: '联系我', path: '/contact', icon: '📪' },
]

// 首页下拉菜单项
const homeDropdownItems = [
  { name: '博客', path: '/blog', icon: '🏠' },
  { name: '起始页', path: '/', icon: '🔍' },
  { name: '内容', path: '/content', icon: '📁' },
  { name: '专栏', path: '/column', icon: '🏷️' },
]

const isActive = (path) => {
  return route.path === path
}

const openLogin = () => {
  emit('open-login')
}
</script>



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
  position: relative;
}

.nav-item::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 50%;
  width: 0;
  height: 3px;
  background: linear-gradient(90deg, #ff6b9d, #c44569);
  border-radius: 2px;
  transition: all 0.3s ease;
  transform: translateX(-50%);
}

.nav-item:hover::after {
  width: 60%;
}

.nav-item:hover {
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
  font-family: 'Luojun', sans-serif;
}

/* 下拉菜单样式 */
.dropdown {
  position: relative;
  cursor: pointer;
}

.dropdown-menu {
  position: absolute;
  top: calc(100% + 10px);
  left: 50%;
  transform: translateX(-50%);
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(10px);
  border-radius: 12px;
  padding: 8px;
  min-width: 140px;
  opacity: 0;
  visibility: hidden;
  transition: all 0.3s ease;
  box-shadow: 0 4px 20px rgba(0,0,0,0.15);
}

.dropdown-menu::before {
  content: '';
  position: absolute;
  top: -6px;
  left: 50%;
  transform: translateX(-50%);
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  border-bottom: 6px solid rgba(255, 255, 255, 0.95);
}

.dropdown:hover .dropdown-menu {
  opacity: 1;
  visibility: visible;
}

.dropdown-item {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 10px 16px;
  color: #333;
  text-decoration: none;
  border-radius: 8px;
  transition: all 0.3s;
  font-size: 14px;
}

.dropdown-item:hover {
  background: rgba(102, 126, 234, 0.1);
  color: #667eea;
}

.dropdown-item.active {
  background: rgba(102, 126, 234, 0.15);
  color: #667eea;
}

.dropdown-icon {
  font-size: 16px;
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

@media (max-width: 768px) {
  .navbar {
    height: 50px;
    padding: 0 15px;
  }
  
  .nav-brand a {
    font-size: 20px;
  }
  
  .login-btn {
    padding: 6px 16px;
    font-size: 12px;
  }
}

/* 底部移动端导航 */
.mobile-nav {
  display: none;
}

@media (max-width: 900px) {
  .mobile-nav {
    display: flex;
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    height: 60px;
    background: rgba(255, 255, 255, 0.95);
    backdrop-filter: blur(10px);
    justify-content: space-around;
    align-items: center;
    z-index: 1000;
    box-shadow: 0 -2px 10px rgba(0,0,0,0.1);
  }
  
  .mobile-nav-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 4px;
    padding: 8px 12px;
    color: #666;
    text-decoration: none;
    font-size: 12px;
    transition: all 0.3s;
  }
  
  .mobile-nav-item.active {
    color: #c44569;
  }
  
  .mobile-nav-icon {
    font-size: 20px;
  }
}

@media (max-width: 480px) {
  .mobile-nav {
    height: 55px;
  }
  
  .mobile-nav-item {
    padding: 6px 8px;
    font-size: 10px;
  }
  
  .mobile-nav-icon {
    font-size: 18px;
  }
}
</style>
