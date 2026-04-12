<script setup>
import { ref } from 'vue'

const essays = ref([
  {
    id: 1,
    author: 'Corrain',
    level: 'LV6',
    avatar: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop',
    content: '好久没有更新了，可算是把论文忙的差不多了，接下来差不多生活进入平稳期了，可以开始更新啦hhh。',
    date: '2026-01-24',
    comments: 1
  },
  {
    id: 2,
    author: 'Corrain',
    level: 'LV6',
    avatar: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop',
    content: '转博成功，开心的一天~',
    date: '2024-09-23',
    comments: 2
  },
  {
    id: 3,
    author: 'Corrain',
    level: 'LV6',
    avatar: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop',
    content: '准备学HSpice了，有时间的话会更新学习记录的',
    date: '2024-09-20',
    comments: 2
  },
  {
    id: 4,
    author: 'Corrain',
    level: 'LV6',
    avatar: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop',
    content: '今天听了一晚上的《梦返》，副歌真的太好听了',
    date: '2024-09-17',
    comments: 0
  }
])
</script>

<template>
  <div class="essays-page">
    <div class="page-header">
      <div class="user-info">
        <img class="header-avatar" src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop" alt="avatar" />
        <span class="header-name">Corrain</span>
      </div>
    </div>
    
    <div class="essays-container">
      <div v-for="essay in essays" :key="essay.id" class="essay-card">
        <div class="essay-header">
          <img class="avatar" :src="essay.avatar" :alt="essay.author" />
          <div class="author-info">
            <div class="author-name">
              {{ essay.author }}
              <span class="level-badge">{{ essay.level }}</span>
            </div>
          </div>
        </div>
        
        <div class="essay-content">
          {{ essay.content }}
        </div>
        
        <div class="essay-footer">
          <span class="date">{{ essay.date }}</span>
          <div class="actions">
            <span class="action-btn">{{ essay.comments }} 💬</span>
            <span class="action-btn">✏️</span>
            <span class="action-btn">↗️</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.essays-page {
  min-height: 100vh;
  background: linear-gradient(rgba(0,0,0,0.2), rgba(0,0,0,0.2)),
              url('https://images.unsplash.com/photo-1513694203232-719a280e022f?w=1920') center/cover fixed;
  padding: 80px 20px 40px;
}

.page-header {
  max-width: 800px;
  margin: 0 auto 30px;
  background: rgba(255,255,255,0.95);
  border-radius: 12px;
  padding: 20px;
  display: flex;
  align-items: center;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 12px;
}

.header-avatar {
  width: 50px;
  height: 50px;
  border-radius: 8px;
  object-fit: cover;
}

.header-name {
  font-size: 18px;
  font-weight: 500;
  color: #333;
}

.essays-container {
  max-width: 800px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.essay-card {
  background: rgba(255,255,255,0.95);
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.essay-header {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 12px;
}

.avatar {
  width: 40px;
  height: 40px;
  border-radius: 8px;
  object-fit: cover;
}

.author-name {
  font-size: 15px;
  font-weight: 500;
  color: #333;
  display: flex;
  align-items: center;
  gap: 8px;
}

.level-badge {
  background: linear-gradient(135deg, #ff6b6b, #ee5a24);
  color: white;
  font-size: 11px;
  padding: 2px 8px;
  border-radius: 4px;
  font-weight: bold;
}

.essay-content {
  font-size: 15px;
  line-height: 1.6;
  color: #333;
  margin-bottom: 16px;
}

.essay-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #999;
  font-size: 13px;
}

.actions {
  display: flex;
  gap: 16px;
}

.action-btn {
  cursor: pointer;
  transition: color 0.3s;
}

.action-btn:hover {
  color: #666;
}
</style>
