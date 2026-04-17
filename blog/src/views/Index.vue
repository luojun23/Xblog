<template>
  <div class="blog-index">
    <!-- 顶部大图区域 -->
    <div class="hero-section">
      <el-image
        class="hero-bg"
        :src="heroImage"
        fit="cover"
        loading="lazy"
      />
      <div class="hero-overlay">
        <!-- 站点标题 - 逐字渲染 -->
        <h1 class="site-title">
          <span
            v-for="(char, index) in titleChars"
            :key="index"
            class="title-char"
            :style="{ animationDelay: `${index * 0.1}s` }"
          >
            {{ char }}
          </span>
        </h1>
        
        <!-- 每日诗词 - 打字机效果 -->
        <div class="poem-container">
          <printer :printerInfo="printerInfo" />
        </div>
      </div>
      
      <!-- 波浪装饰 -->
      <div class="wave-decoration">
        <svg viewBox="0 0 1440 120" preserveAspectRatio="none">
          <path
            d="M0,60 C360,120 720,0 1080,60 C1260,90 1380,60 1440,60 L1440,120 L0,120 Z"
            fill="rgba(255,255,255,0.1)"
          />
        </svg>
      </div>
    </div>
    
    <!-- 内容区域 -->
    <div class="content-section">
      <div class="container">
        <!-- 左侧个人信息卡片 -->
        <aside class="profile-card">
          <div class="avatar-wrapper">
            <el-avatar
              :size="120"
              :src="webInfo.avatar || defaultAvatar"
              class="profile-avatar"
            />
          </div>
          <h2 class="profile-name">{{ webInfo.author || '博主' }}</h2>
          <div class="profile-stats">
            <div class="stat-item">
              <span class="stat-icon">📖</span>
              <span class="stat-label">文章</span>
              <span class="stat-value">{{ articleCount }}</span>
            </div>
            <div class="stat-item">
              <span class="stat-icon">📂</span>
              <span class="stat-label">分类</span>
              <span class="stat-value">{{ categoryCount }}</span>
            </div>
            <div class="stat-item">
              <span class="stat-icon">🔥</span>
              <span class="stat-label">访问量</span>
              <span class="stat-value">{{ visitCount }}</span>
            </div>
          </div>
          <el-button type="primary" class="friend-btn" @click="goToFriends">
            ⭐ 友站
          </el-button>
        </aside>
        
        <!-- 右侧内容区域 -->
        <main class="main-content">
          <!-- 欢迎语 -->
          <div class="welcome-box">
            <span class="welcome-icon">🔊</span>
            <span class="welcome-text">欢迎每一位朋友~</span>
          </div>
          
          <!-- 最新文章标题栏 -->
          <div class="section-header">
            <div class="section-title">
              <span class="title-icon">📱</span>
              <span>最新</span>
            </div>
            <router-link to="/articles" class="more-link">
              MORE <span class="arrow">➤</span>
            </router-link>
          </div>
          
          <!-- 文章列表 -->
          <div class="articles-grid">
            <article
              v-for="article in latestArticles"
              :key="article.id"
              class="article-card"
              @click="goToArticle(article.id)"
            >
              <div class="article-cover">
                <el-image
                  :src="article.cover"
                  fit="cover"
                  loading="lazy"
                />
              </div>
              <div class="article-info">
                <h3 class="article-title">{{ article.title }}</h3>
                <p class="article-summary">{{ article.summary }}</p>
                <div class="article-meta">
                  <span class="meta-date">📅 {{ article.date }}</span>
                  <span class="meta-views">👁️ {{ article.views }}</span>
                </div>
              </div>
            </article>
          </div>
        </main>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import Printer from '../components/Printer.vue'

const router = useRouter()

// 默认头像
const defaultAvatar = 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'

// 网站信息（可以从本地存储或API获取）
const webInfo = ref({
  siteTitle: '尔尔辞晚',
  author: 'Luojun',
  avatar: '',
  backgroundImage: '',
  randomCover: [
    'https://images.unsplash.com/photo-1518495973542-4542c06a5843?w=1920',
    'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=1920',
    'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=1920'
  ]
})

// 站点标题
const siteTitle = computed(() => {
  return webInfo.value.siteTitle || '尔尔辞晚'
})

// 将标题拆分为字符数组
const titleChars = computed(() => {
  return siteTitle.value.split('')
})

// 顶部大图
const heroImage = computed(() => {
  if (webInfo.value.backgroundImage) {
    return webInfo.value.backgroundImage
  }
  if (webInfo.value.randomCover && webInfo.value.randomCover.length > 0) {
    const randomIndex = Math.floor(Math.random() * webInfo.value.randomCover.length)
    return webInfo.value.randomCover[randomIndex]
  }
  return 'https://images.unsplash.com/photo-1518495973542-4542c06a5843?w=1920'
})

// 打字机信息
const printerInfo = ref('')

// 统计数据
const articleCount = ref(74)
const categoryCount = ref(5)
const visitCount = ref(68678)

// 最新文章
const latestArticles = ref([
  {
    id: 1,
    title: 'Silent Shore',
    summary: 'A peaceful journey to the silent shore...',
    cover: 'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=400&h=300&fit=crop',
    date: '2024-01-15',
    views: 1234
  },
  {
    id: 2,
    title: 'Mountain Mist',
    summary: 'Exploring the mysterious mountain mist...',
    cover: 'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=400&h=300&fit=crop',
    date: '2024-01-12',
    views: 892
  },
  {
    id: 3,
    title: 'Ocean Dreams',
    summary: 'Dreaming by the endless ocean...',
    cover: 'https://images.unsplash.com/photo-1505142468610-359e7d316be0?w=400&h=300&fit=crop',
    date: '2024-01-10',
    views: 756
  }
])

// 获取今日诗词
const fetchDailyPoem = async () => {
  try {
    const response = await fetch('https://v1.jinrishici.com/all.json')
    const data = await response.json()
    if (data && data.content) {
      printerInfo.value = data.content
    } else {
      printerInfo.value = '云母屏风烛影深，长河渐落晓星沉。'
    }
  } catch (error) {
    console.error('获取诗词失败:', error)
    printerInfo.value = '云母屏风烛影深，长河渐落晓星沉。'
  }
}

// 跳转到文章详情
const goToArticle = (id) => {
  router.push(`/article/${id}`)
}

// 跳转到友站
const goToFriends = () => {
  router.push('/friends')
}

onMounted(() => {
  fetchDailyPoem()
})
</script>

<style scoped>
.blog-index {
  min-height: 100vh;
  background: #1a1a2e;
}

/* 顶部大图区域 */
.hero-section {
  position: relative;
  height: 500px;
  overflow: hidden;
}

.hero-bg {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.hero-bg :deep(img) {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.5));
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  z-index: 1;
}

/* 站点标题 - 逐字动画 */
.site-title {
  font-size: 48px;
  color: white;
  font-weight: bold;
  letter-spacing: 8px;
  margin-bottom: 30px;
  text-shadow: 0 2px 10px rgba(0,0,0,0.3);
}

.title-char {
  display: inline-block;
  opacity: 0;
  transform: translateY(20px);
  animation: charFadeIn 0.5s ease forwards;
}

@keyframes charFadeIn {
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* 诗词容器 */
.poem-container {
  background: rgba(0,0,0,0.5);
  backdrop-filter: blur(10px);
  padding: 15px 30px;
  border-radius: 30px;
  color: white;
  font-size: 18px;
  letter-spacing: 2px;
}

/* 波浪装饰 */
.wave-decoration {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 60px;
  z-index: 2;
}

.wave-decoration svg {
  width: 100%;
  height: 100%;
}

/* 内容区域 */
.content-section {
  padding: 40px 20px;
  background: #1a1a2e;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 300px 1fr;
  gap: 30px;
}

/* 个人信息卡片 */
.profile-card {
  background: linear-gradient(135deg, #e3f2fd 0%, #f3e5f5 100%);
  border-radius: 20px;
  padding: 30px;
  text-align: center;
  height: fit-content;
  position: sticky;
  top: 80px;
}

.avatar-wrapper {
  margin-bottom: 20px;
}

.profile-avatar {
  border: 4px solid white;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
}

.profile-name {
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
  font-weight: 600;
}

.profile-stats {
  display: flex;
  justify-content: space-around;
  margin-bottom: 25px;
}

.stat-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 5px;
}

.stat-icon {
  font-size: 20px;
}

.stat-label {
  font-size: 12px;
  color: #666;
}

.stat-value {
  font-size: 18px;
  font-weight: bold;
  color: #333;
}

.friend-btn {
  width: 100%;
  border-radius: 25px;
  height: 45px;
  font-size: 16px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border: none;
}

/* 主内容区域 */
.main-content {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.welcome-box {
  background: rgba(255,255,255,0.05);
  border: 1px dashed rgba(255,255,255,0.2);
  border-radius: 12px;
  padding: 20px;
  display: flex;
  align-items: center;
  gap: 15px;
  color: rgba(255,255,255,0.8);
}

.welcome-icon {
  font-size: 20px;
}

.welcome-text {
  font-size: 16px;
}

/* 区块标题 */
.section-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 0;
  border-bottom: 1px solid rgba(255,255,255,0.1);
}

.section-title {
  display: flex;
  align-items: center;
  gap: 10px;
  color: white;
  font-size: 18px;
  font-weight: 500;
}

.title-icon {
  font-size: 20px;
}

.more-link {
  color: rgba(255,255,255,0.6);
  text-decoration: none;
  font-size: 14px;
  display: flex;
  align-items: center;
  gap: 5px;
  transition: color 0.3s;
}

.more-link:hover {
  color: white;
}

.arrow {
  font-size: 12px;
}

/* 文章网格 */
.articles-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 20px;
}

.article-card {
  background: rgba(255,255,255,0.05);
  border-radius: 16px;
  overflow: hidden;
  cursor: pointer;
  transition: all 0.3s ease;
}

.article-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 30px rgba(0,0,0,0.3);
}

.article-cover {
  height: 180px;
  overflow: hidden;
}

.article-cover :deep(img) {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s;
}

.article-card:hover .article-cover :deep(img) {
  transform: scale(1.05);
}

.article-info {
  padding: 20px;
}

.article-title {
  color: white;
  font-size: 16px;
  margin-bottom: 10px;
  font-weight: 500;
}

.article-summary {
  color: rgba(255,255,255,0.6);
  font-size: 14px;
  line-height: 1.6;
  margin-bottom: 15px;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.article-meta {
  display: flex;
  gap: 15px;
  color: rgba(255,255,255,0.4);
  font-size: 12px;
}

/* 移动端适配 */
@media (max-width: 968px) {
  .container {
    grid-template-columns: 1fr;
  }
  
  .profile-card {
    position: static;
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 20px;
    text-align: left;
  }
  
  .avatar-wrapper {
    margin-bottom: 0;
  }
  
  .profile-stats {
    flex: 1;
    justify-content: flex-start;
    gap: 30px;
    margin-bottom: 0;
  }
  
  .friend-btn {
    width: auto;
    padding: 0 30px;
  }
}

@media (max-width: 768px) {
  .hero-section {
    height: 400px;
  }
  
  .site-title {
    font-size: 36px;
    letter-spacing: 4px;
  }
  
  .poem-container {
    font-size: 14px;
    padding: 12px 20px;
  }
  
  .profile-card {
    flex-direction: column;
    text-align: center;
  }
  
  .profile-stats {
    justify-content: center;
  }
  
  .friend-btn {
    width: 100%;
  }
  
  .articles-grid {
    grid-template-columns: 1fr;
  }
}

@media (max-width: 480px) {
  .hero-section {
    height: 350px;
  }
  
  .site-title {
    font-size: 28px;
  }
  
  .content-section {
    padding: 20px 15px;
  }
}
</style>
