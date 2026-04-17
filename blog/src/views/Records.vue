<script setup>
import { ref } from 'vue'

const records = ref([
  { id: 1, title: '学习笔记', desc: '记录每天的学习进度', icon: '📝', count: 12 },
  { id: 2, title: '生活点滴', desc: '生活中的小确幸', icon: '🌸', count: 8 },
  { id: 3, title: '技术分享', desc: '编程与技术心得', icon: '💻', count: 15 },
  { id: 4, title: '读书笔记', desc: '阅读记录与感悟', icon: '📚', count: 6 },
])
</script>

<template>
  <div class="records-page">
    <div class="page-title">
      <h1>记录</h1>
      <p>记录生活的点点滴滴</p>
    </div>
    
    <div class="records-grid">
      <div v-for="record in records" :key="record.id" class="record-card">
        <div class="record-icon">{{ record.icon }}</div>
        <h3>{{ record.title }}</h3>
        <p>{{ record.desc }}</p>
        <span class="record-count">{{ record.count }} 篇</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.records-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
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
  opacity: 0.8;
}

.records-grid {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 20px;
}

.record-card {
  background: rgba(255,255,255,0.95);
  border-radius: 16px;
  padding: 30px;
  text-align: center;
  transition: transform 0.3s, box-shadow 0.3s;
  cursor: pointer;
}

.record-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 30px rgba(0,0,0,0.2);
}

.record-icon {
  font-size: 48px;
  margin-bottom: 16px;
}

.record-card h3 {
  font-size: 18px;
  color: #333;
  margin-bottom: 8px;
}

.record-card p {
  font-size: 14px;
  color: #666;
  margin-bottom: 12px;
}

.record-count {
  display: inline-block;
  background: linear-gradient(135deg, #667eea, #764ba2);
  color: white;
  padding: 4px 12px;
  border-radius: 20px;
  font-size: 12px;
}

/* 移动端适配 */
@media (max-width: 768px) {
  .records-page {
    padding: 80px 15px 100px;
  }
  
  .page-title h1 {
    font-size: 28px;
  }
  
  .records-grid {
    grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
    gap: 15px;
  }
  
  .record-card {
    padding: 20px;
  }
  
  .record-icon {
    font-size: 36px;
  }
}

@media (max-width: 480px) {
  .records-page {
    padding: 70px 10px 100px;
  }
  
  .page-title h1 {
    font-size: 24px;
  }
  
  .page-title p {
    font-size: 14px;
  }
  
  .records-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
  }
  
  .record-card {
    padding: 15px;
  }
  
  .record-icon {
    font-size: 32px;
    margin-bottom: 12px;
  }
  
  .record-card h3 {
    font-size: 15px;
  }
  
  .record-card p {
    font-size: 12px;
  }
}
</style>
