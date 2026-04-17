<script setup>
import { ref } from 'vue'

const tools = ref([
  { id: 1, name: 'JSON格式化', icon: '{ }', desc: '在线JSON格式化工具', color: '#4CAF50' },
  { id: 2, name: 'Base64编码', icon: '64', desc: 'Base64编码解码工具', color: '#2196F3' },
  { id: 3, name: '颜色选择器', icon: '🎨', desc: '在线颜色选择工具', color: '#9C27B0' },
  { id: 4, name: '正则测试', icon: '.*', desc: '正则表达式测试工具', color: '#FF9800' },
  { id: 5, name: '代码对比', icon: '⚖️', desc: '文本差异对比工具', color: '#607D8B' },
  { id: 6, name: 'Markdown', icon: 'M↓', desc: 'Markdown编辑器', color: '#795548' },
])
</script>

<template>
  <div class="toolbox-page">
    <div class="page-title">
      <h1>百宝箱</h1>
      <p>实用的在线工具集合</p>
    </div>
    
    <div class="tools-grid">
      <div v-for="tool in tools" :key="tool.id" class="tool-card" :style="{ '--tool-color': tool.color }">
        <div class="tool-icon">{{ tool.icon }}</div>
        <h3>{{ tool.name }}</h3>
        <p>{{ tool.desc }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.toolbox-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  padding: 100px 20px 40px;
}

.page-title {
  text-align: center;
  margin-bottom: 40px;
}

.page-title h1 {
  font-size: 36px;
  color: #333;
  margin-bottom: 10px;
}

.page-title p {
  color: #666;
}

.tools-grid {
  max-width: 1000px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 20px;
}

.tool-card {
  background: white;
  border-radius: 16px;
  padding: 30px;
  text-align: center;
  cursor: pointer;
  transition: all 0.3s;
  border: 2px solid transparent;
}

.tool-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 30px rgba(0,0,0,0.1);
  border-color: var(--tool-color);
}

.tool-icon {
  width: 60px;
  height: 60px;
  background: var(--tool-color);
  color: white;
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 24px;
  margin: 0 auto 16px;
  font-weight: bold;
}

.tool-card h3 {
  font-size: 18px;
  color: #333;
  margin-bottom: 8px;
}

.tool-card p {
  font-size: 14px;
  color: #666;
}

/* 移动端适配 */
@media (max-width: 768px) {
  .toolbox-page {
    padding: 70px 15px 100px;
  }
  
  .page-title {
    font-size: 28px;
  }
  
  .tools-grid {
    grid-template-columns: repeat(auto-fill, minmax(140px, 1fr));
    gap: 15px;
  }
}

@media (max-width: 480px) {
  .toolbox-page {
    padding: 60px 10px 100px;
  }
  
  .page-title {
    font-size: 24px;
  }
  
  .tools-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
  }
  
  .tool-card {
    padding: 20px 15px;
  }
  
  .tool-icon {
    width: 50px;
    height: 50px;
    font-size: 20px;
  }
  
  .tool-card h3 {
    font-size: 15px;
  }
  
  .tool-card p {
    font-size: 12px;
  }
}
</style>
