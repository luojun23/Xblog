<script setup>
import { ref } from 'vue'

const albums = ref([
  { id: 1, title: '风景', count: 24, cover: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=300&h=300&fit=crop' },
  { id: 2, title: '美食', count: 18, cover: 'https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=300&h=300&fit=crop' },
  { id: 3, title: '生活', count: 36, cover: 'https://images.unsplash.com/photo-1513694203232-719a280e022f?w=300&h=300&fit=crop' },
  { id: 4, title: '旅行', count: 12, cover: 'https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?w=300&h=300&fit=crop' },
  { id: 5, title: '宠物', count: 8, cover: 'https://images.unsplash.com/photo-1425082661705-1834bfd09dca?w=300&h=300&fit=crop' },
  { id: 6, title: '摄影', count: 45, cover: 'https://images.unsplash.com/photo-1452587925148-ce544e77e70d?w=300&h=300&fit=crop' },
])
</script>

<template>
  <div class="album-page">
    <div class="page-title">
      <h1>相册</h1>
      <p>用镜头记录美好瞬间</p>
    </div>
    
    <div class="album-grid">
      <div v-for="album in albums" :key="album.id" class="album-card">
        <div class="album-cover">
          <img :src="album.cover" :alt="album.title" />
          <div class="album-overlay">
            <span class="album-count">{{ album.count }} 张</span>
          </div>
        </div>
        <h3>{{ album.title }}</h3>
      </div>
    </div>
  </div>
</template>

<style scoped>
.album-page {
  min-height: 100vh;
  background: #1a1a2e;
  padding: 100px 20px 40px;
}

.page-title {
  text-align: center;
  color: white;
  margin-bottom: 40px;
}

.page-title h1 {
  font-size: 36px;
  margin-bottom: 10px;
}

.page-title p {
  opacity: 0.7;
}

.album-grid {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 24px;
}

.album-card {
  cursor: pointer;
  transition: transform 0.3s;
}

.album-card:hover {
  transform: scale(1.02);
}

.album-cover {
  position: relative;
  border-radius: 16px;
  overflow: hidden;
  aspect-ratio: 1;
}

.album-cover img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s;
}

.album-card:hover .album-cover img {
  transform: scale(1.1);
}

.album-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(to top, rgba(0,0,0,0.7), transparent);
  display: flex;
  align-items: flex-end;
  justify-content: flex-end;
  padding: 16px;
  opacity: 0;
  transition: opacity 0.3s;
}

.album-card:hover .album-overlay {
  opacity: 1;
}

.album-count {
  color: white;
  font-size: 14px;
  background: rgba(255,255,255,0.2);
  padding: 4px 12px;
  border-radius: 20px;
  backdrop-filter: blur(10px);
}

.album-card h3 {
  color: white;
  text-align: center;
  margin-top: 12px;
  font-size: 16px;
}

/* 移动端适配 */
@media (max-width: 768px) {
  .album-page {
    padding: 80px 15px 100px;
  }
  
  .page-title h1 {
    font-size: 28px;
  }
  
  .page-title p {
    font-size: 14px;
  }
  
  .album-grid {
    grid-template-columns: repeat(auto-fill, minmax(140px, 1fr));
    gap: 15px;
  }
  
  .album-cover {
    height: 140px;
  }
}

@media (max-width: 480px) {
  .album-page {
    padding: 70px 10px 100px;
  }
  
  .page-title h1 {
    font-size: 24px;
  }
  
  .album-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
  }
  
  .album-cover {
    height: 120px;
  }
  
  .album-card h3 {
    font-size: 14px;
  }
}
</style>
