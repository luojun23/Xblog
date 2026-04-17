<template>
  <el-container class="admin-layout">
    <!-- 左侧菜单 -->
    <el-aside :width="isCollapse ? '64px' : '200px'" class="admin-aside">
      <!-- Logo -->
      <div class="aside-logo">
        <span v-if="!isCollapse" class="logo-text">后台管理</span>
      </div>

      <!-- 折叠按钮 -->
      <div class="collapse-btn" @click="toggleCollapse">
        <el-icon><Grid /></el-icon>
        <span v-if="!isCollapse" class="collapse-label">折叠</span>
      </div>

      <!-- 导航菜单 -->
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :collapse-transition="false"
        background-color="transparent"
        text-color="#606266"
        active-text-color="#20c0a0"
        class="admin-menu"
        @select="handleMenuSelect"
      >
        <el-menu-item index="/admin/dashboard">
          <el-icon><House /></el-icon>
          <template #title>系统首页</template>
        </el-menu-item>
        <el-menu-item index="/admin/setting">
          <el-icon><Setting /></el-icon>
          <template #title>网站设置</template>
        </el-menu-item>
        <el-menu-item index="/admin/user">
          <el-icon><User /></el-icon>
          <template #title>用户管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/article">
          <el-icon><Document /></el-icon>
          <template #title>文章管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/category">
          <el-icon><FolderOpened /></el-icon>
          <template #title>分类管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/config">
          <el-icon><Monitor /></el-icon>
          <template #title>配置管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/comment">
          <el-icon><EditPen /></el-icon>
          <template #title>评论管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/message">
          <el-icon><ChatDotRound /></el-icon>
          <template #title>留言管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/resource">
          <el-icon><Link /></el-icon>
          <template #title>资源管理</template>
        </el-menu-item>
        <el-menu-item index="/admin/aggregate">
          <el-icon><Coin /></el-icon>
          <template #title>资源聚合</template>
        </el-menu-item>
        <el-menu-item index="/admin/wall">
          <el-icon><Stamp /></el-icon>
          <template #title>衣白墙</template>
        </el-menu-item>
      </el-menu>

      <!-- 底部角色图 -->
      <div class="aside-character">
        <img src="https://file.corrain.top/webInfo/character.png" alt="character" class="character-img" />
      </div>
    </el-aside>

    <!-- 右侧主体 -->
    <el-container class="admin-main-container">
      <!-- 顶部栏 -->
      <el-header class="admin-header">
        <div class="header-left"></div>
        <div class="header-right">
          <el-button text class="home-btn" @click="goHome">
            <el-icon color="#f59e0b"><Star /></el-icon>
            首页
          </el-button>
          <el-avatar :size="36" class="header-avatar" />
        </div>
      </el-header>

      <!-- 内容区域 -->
      <el-main class="admin-main">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import {
  Grid, House, Setting, User, Document, FolderOpened,
  Monitor, EditPen, ChatDotRound, Link, Coin, Stamp, Star
} from '@element-plus/icons-vue'

const router = useRouter()
const route = useRoute()
const isCollapse = ref(false)

const activeMenu = computed(() => route.path)

const toggleCollapse = () => {
  isCollapse.value = !isCollapse.value
}

const handleMenuSelect = (index) => {
  router.push(index)
}

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.admin-layout {
  height: 100vh;
  background: #f0f4f8;
}

/* 左侧菜单 */
.admin-aside {
  background: #fff;
  box-shadow: 2px 0 8px rgba(0,0,0,0.06);
  display: flex;
  flex-direction: column;
  transition: width 0.3s;
  overflow: hidden;
  position: relative;
}

.aside-logo {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-bottom: 1px solid #f0f0f0;
}

.logo-text {
  font-size: 18px;
  font-weight: bold;
  color: #333;
}

.collapse-btn {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 14px 20px;
  cursor: pointer;
  color: #606266;
  font-size: 14px;
  transition: background 0.3s;
}

.collapse-btn:hover {
  background: #f5f7fa;
  color: #20c0a0;
}

.admin-menu {
  border: none;
  flex: 1;
}

.admin-menu :deep(.el-menu-item) {
  height: 50px;
  font-size: 14px;
}

.admin-menu :deep(.el-menu-item.is-active) {
  background: rgba(32, 192, 160, 0.08) !important;
  font-weight: 500;
}

.aside-character {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  pointer-events: none;
}

.character-img {
  width: 140px;
  object-fit: contain;
}

/* 顶部栏 */
.admin-header {
  background: #fff;
  box-shadow: 0 2px 8px rgba(0,0,0,0.06);
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
  height: 60px;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 16px;
}

.home-btn {
  font-size: 14px;
  color: #606266;
}

.header-avatar {
  background: #ddd;
  cursor: pointer;
}

/* 内容区域 */
.admin-main-container {
  flex: 1;
  overflow: hidden;
}

.admin-main {
  background: #f0f4f8;
  padding: 20px;
  overflow-y: auto;
}
</style>
