<script setup>
import { ref } from 'vue'

const contactInfo = ref([
  { icon: '📧', label: '邮箱', value: 'corrain@example.com' },
  { icon: '💬', label: '微信', value: 'CorrainWeChat' },
  { icon: '🐙', label: 'GitHub', value: 'github.com/corrain' },
  { icon: '📱', label: '电话', value: '138****8888' },
])

const socialLinks = ref([
  { name: 'GitHub', icon: '🐙', url: '#' },
  { name: 'Twitter', icon: '🐦', url: '#' },
  { name: 'Bilibili', icon: '📺', url: '#' },
  { name: 'Weibo', icon: '📱', url: '#' },
])
</script>

<template>
  <div class="contact-page">
    <div class="contact-container">
      <div class="contact-header">
        <h1>联系我</h1>
        <p>有任何问题或建议，欢迎随时联系</p>
      </div>
      
      <div class="contact-content">
        <div class="contact-info">
          <h2>联系方式</h2>
          <div class="info-list">
            <div v-for="info in contactInfo" :key="info.label" class="info-item">
              <span class="info-icon">{{ info.icon }}</span>
              <div class="info-detail">
                <span class="info-label">{{ info.label }}</span>
                <span class="info-value">{{ info.value }}</span>
              </div>
            </div>
          </div>
        </div>
        
        <div class="social-links">
          <h2>社交媒体</h2>
          <div class="links-grid">
            <a v-for="link in socialLinks" :key="link.name" :href="link.url" class="social-link">
              <span class="link-icon">{{ link.icon }}</span>
              <span class="link-name">{{ link.name }}</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.contact-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  padding: 100px 20px 40px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.contact-container {
  max-width: 800px;
  width: 100%;
}

.contact-header {
  text-align: center;
  color: white;
  margin-bottom: 40px;
}

.contact-header h1 {
  font-size: 36px;
  margin-bottom: 10px;
}

.contact-header p {
  opacity: 0.8;
}

.contact-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 24px;
}

.contact-info,
.social-links {
  background: rgba(255,255,255,0.95);
  border-radius: 16px;
  padding: 30px;
}

.contact-info h2,
.social-links h2 {
  font-size: 20px;
  color: #333;
  margin-bottom: 20px;
}

.info-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.info-item {
  display: flex;
  align-items: center;
  gap: 12px;
}

.info-icon {
  font-size: 24px;
  width: 40px;
  height: 40px;
  background: linear-gradient(135deg, #667eea, #764ba2);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.info-detail {
  display: flex;
  flex-direction: column;
}

.info-label {
  font-size: 12px;
  color: #999;
}

.info-value {
  font-size: 14px;
  color: #333;
  font-weight: 500;
}

.links-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 12px;
}

.social-link {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
  padding: 20px;
  background: #f5f5f5;
  border-radius: 12px;
  text-decoration: none;
  transition: all 0.3s;
}

.social-link:hover {
  background: linear-gradient(135deg, #667eea, #764ba2);
  transform: translateY(-3px);
}

.social-link:hover .link-icon,
.social-link:hover .link-name {
  color: white;
}

.link-icon {
  font-size: 28px;
  transition: color 0.3s;
}

.link-name {
  font-size: 14px;
  color: #666;
  transition: color 0.3s;
}

@media (max-width: 768px) {
  .contact-content {
    grid-template-columns: 1fr;
  }
}
</style>
