<template>
  <div class="family-page">
    <div class="hero-banner">
      <div class="couple-section">
        <div class="avatar-container">
          <div class="avatar">
            <img src="../assets/img/lj.jpg" alt="Rain" />
          </div>
          <span class="name">朝朝</span>
        </div>
        
        <div class="heart">
          <img src="../assets/img/loveLike.svg" alt="love" class="heart-icon" />
        </div>
        
        <div class="avatar-container">
          <div class="avatar">
            <img src="../assets/img/lmx.jpg" alt="Snow" />
          </div>
          <span class="name">尔尔</span>
        </div>
      </div>
    <!-- 波浪动画 -->
    <div id="bannerWave1"></div>
    <div id="bannerWave2"></div>
    </div>
    
    <div class="counter-section">
      <div class="counter-title">这是我们一起走过的</div>
      
      <div class="time-counter">
        <div class="time-unit">
          <span class="label">第</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ years }}</span>
          <span class="label">年</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ months }}</span>
          <span class="label">月</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ days }}</span>
          <span class="label">日</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ String(hours).padStart(2, '0') }}</span>
          <span class="label">时</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ String(minutes).padStart(2, '0') }}</span>
          <span class="label">分</span>
        </div>
        <div class="time-unit">
          <span class="number">{{ String(seconds).padStart(2, '0') }}</span>
          <span class="label">秒</span>
        </div>
      </div>
      
      <div class="new-year-countdown">
        元旦: {{ newYearDays }}天{{ newYearHours }}时{{ newYearMinutes }}分{{ newYearSeconds }}秒
      </div>
    </div>
    
    <div class="content-preview">
      <div class="preview-card">
        <img src="../assets/img/fc.jpg" alt="飞车传信" />
        <div class="card-title">飞车传信</div>
      </div>
    </div>
    
    <!-- 功能卡片区域 -->
    <div class="feature-cards">
      <div class="feature-card">
        <div class="feature-icon">
          <img src="../assets/img/diandi.jpg" alt="点点滴滴" />
        </div>
        <div class="feature-info">
          <h3 class="feature-title">点点滴滴</h3>
          <p class="feature-desc">🍻 今朝有酒今朝醉</p>
        </div>
      </div>
      
      <div class="feature-card">
        <div class="feature-icon">
          <img src="../assets/img/xiangce.jpg" alt="时光相册" />
        </div>
        <div class="feature-info">
          <h3 class="feature-title">时光相册</h3>
          <p class="feature-desc">📷 记录美好瞬间</p>
        </div>
      </div>
      
      <div class="feature-card">
        <div class="feature-icon">
          <img src="../assets/img/zhufu.jpg" alt="祝福板" />
        </div>
        <div class="feature-info">
          <h3 class="feature-title">祝福板</h3>
          <p class="feature-desc">📝 写下你们的祝福</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const years = ref(0)
const months = ref(0)
const days = ref(0)
const hours = ref(0)
const minutes = ref(0)
const seconds = ref(0)

const newYearDays = ref(0)
const newYearHours = ref(0)
const newYearMinutes = ref(0)
const newYearSeconds = ref(0)

// 设置纪念日（示例：2023年5月29日）
const anniversaryDate = new Date('2025-12-16T00:00:00')

const updateCounter = () => {
  const now = new Date()
  const diff = now - anniversaryDate
  
  const totalSeconds = Math.floor(diff / 1000)
  const totalMinutes = Math.floor(totalSeconds / 60)
  const totalHours = Math.floor(totalMinutes / 60)
  const totalDays = Math.floor(totalHours / 24)
  
  years.value = Math.floor(totalDays / 365)
  months.value = Math.floor((totalDays % 365) / 30)
  days.value = Math.floor((totalDays % 365) % 30)
  hours.value = totalHours % 24
  minutes.value = totalMinutes % 60
  seconds.value = totalSeconds % 60
  
  // 计算到下一个元旦
  const currentYear = now.getFullYear()
  const nextNewYear = new Date(currentYear + 1, 0, 1)
  const newYearDiff = nextNewYear - now
  
  newYearDays.value = Math.floor(newYearDiff / (1000 * 60 * 60 * 24))
  newYearHours.value = Math.floor((newYearDiff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60))
  newYearMinutes.value = Math.floor((newYearDiff % (1000 * 60 * 60)) / (1000 * 60))
  newYearSeconds.value = Math.floor((newYearDiff % (1000 * 60)) / 1000)
}

let timer = null

onMounted(() => {
  updateCounter()
  timer = setInterval(updateCounter, 1000)
})

onUnmounted(() => {
  clearInterval(timer)
})
</script>

<style scoped>
.family-page {
  min-height: 100vh;
  background: #f5f5f5;
}

.hero-banner {
  height: 400px;
  background: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)),
              url('../assets/img/love_img.jpg') center/cover;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  width: 100%;

}

.hero-banner::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100px;
  background: linear-gradient(to top, #f5f5f5, transparent);
}

.couple-section {
    width: 90%;
    background: hsla(0, 0%, 100%, .1);
    max-width: 950px;
    border-radius: 3em;
    display: flex;
    align-items: center;
    justify-content: space-around;
    padding: 50px 70px 30px 70px;
}

.avatar-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
}

.avatar {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  overflow: hidden;
  border: 4px solid white;
  box-shadow: 0 4px 20px rgba(0,0,0,0.2);
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.name {
  color: white;
  font-size: 20px;
  font-weight: 500;
  text-shadow: 0 2px 4px rgba(0,0,0,0.3);
}

.heart {
  position: relative;
  width: 80px;
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.heart-icon {
  width: 48px;
  height: 48px;
  animation: heartbeat 2s linear infinite;
}

@keyframes heartbeat {
0% {
    transform: scale(1.5);
}

50% {
    transform: scale(2.5);
}
100% {
    transform: scale(1.5);
}
}

.heart-rays {
  position: absolute;
  width: 100%;
  height: 100%;
  animation: raybeat 1.5s ease-in-out infinite;
}


@keyframes raybeat {
  0%, 100% { transform: scale(1); }
  50% { transform: scale(1.5); }
}

/* 波浪动画 */
#bannerWave1, #bannerWave2 {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 200%;
  animation: gradientBG 120s linear infinite;
}

#bannerWave1 {
  height: 84px;
  background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="rgba(255,255,255,0.3)" d="M0,192L48,197.3C96,203,192,213,288,229.3C384,245,480,267,576,250.7C672,235,768,181,864,181.3C960,181,1056,235,1152,234.7C1248,235,1344,181,1392,154.7L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path></svg>') repeat-x;
  background-size: 50% 100%;
  z-index: 10;
}

#bannerWave2 {
  height: 60px;
  background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="rgba(255,255,255,0.5)" d="M0,256L48,261.3C96,267,192,277,288,266.7C384,256,480,224,576,213.3C672,203,768,213,864,224C960,235,1056,245,1152,234.7C1248,224,1344,192,1392,176L1440,160L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path></svg>') repeat-x;
  background-size: 50% 100%;
  z-index: 9;
}

@keyframes gradientBG {
  0% {
    background-position: 0 0;
  }
  100% {
    background-position: -200% 0;
  }
}

.counter-section {
  padding: 60px 20px;
  text-align: center;
}

.counter-title {
  font-size: 2rem;
  font-weight: 600;
  letter-spacing: .2rem;
  line-height: 4rem;
  text-align: center;
  background-image: linear-gradient(270deg, #ff4500, orange, gold, #90ee90, #0ff, #1e90ff, #9370db, #ff69b4, #ff4500);
  -webkit-background-clip: text;
  animation: jianBian 60s linear infinite;
  background-clip: text;
  color: transparent;
}

@keyframes jianBian {
  100% { background-position: -2000rem; }
}


.time-counter {
  display: flex;
  justify-content: center;
  align-items: baseline;
  gap: 8px;
  flex-wrap: wrap;
}

.time-unit {
  display: flex;
  align-items: baseline;
  gap: 4px;
}

.time-unit .number {
  font-size: 48px;
  font-weight: 300;
  color: #333;
}

.time-unit .label {
  font-size: 18px;
  color: #666;
}

.new-year-countdown {
  margin-top: 30px;
  font-size: 16px;
  color: #666;
}

.content-preview {
  padding: 0 20px 40px;
  display: flex;
  justify-content: center;
}

.preview-card {
  width: 300px;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
  background: white;
}

.preview-card img {
  width: 100%;
  height: 150px;
  object-fit: cover;
}

.card-title {
  padding: 12px;
  text-align: center;
  color: #333;
  font-size: 14px;
}

/* 功能卡片样式 */
.feature-cards {
  display: flex;
  justify-content: center;
  gap: 30px;
  padding: 40px 20px;
  flex-wrap: wrap;
}

.feature-card {
  display: flex;
  align-items: center;
  gap: 20px;
  padding: 20px 30px;
  background: white;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.08);
  transition: all 0.3s ease;
  cursor: pointer;
  min-width: 280px;
}

.feature-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 30px rgba(0,0,0,0.12);
}

.feature-icon {
  width: 70px;
  height: 70px;
  border-radius: 50%;
  overflow: hidden;
  flex-shrink: 0;
}

.feature-icon img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.feature-info {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.feature-title {
  font-size: 20px;
  font-weight: 600;
  color: #333;
  margin: 0;
}

.feature-desc {
  font-size: 14px;
  color: #999;
  margin: 0;
}

/* 移动端适配 */
@media (max-width: 768px) {
  .hero-banner {
    height: 300px;
  }
  
  .couple-section {
    width: 95%;
    padding: 30px 20px 20px 20px;
    gap: 30px;
  }
  
  .avatar {
    width: 80px;
    height: 80px;
  }
  
  .name {
    font-size: 16px;
  }
  
  .heart-icon {
    width: 36px;
    height: 36px;
  }
  
  .counter-title {
    font-size: 1.5rem;
    line-height: 3rem;
  }
  
  .time-unit .number {
    font-size: 32px;
  }
  
  .time-unit .label {
    font-size: 14px;
  }
  
  .new-year-countdown {
    font-size: 14px;
  }
  
  .preview-card {
    width: 250px;
  }
  
  .feature-cards {
    flex-direction: column;
    align-items: center;
    gap: 20px;
  }
  
  .feature-card {
    width: 90%;
    min-width: auto;
    max-width: 350px;
  }
  
  #bannerWave1 {
    height: 60px;
  }
  
  #bannerWave2 {
    height: 40px;
  }
}

@media (max-width: 480px) {
  .hero-banner {
    height: 250px;
  }
  
  .couple-section {
    flex-direction: column;
    gap: 20px;
    padding: 20px;
  }
  
  .avatar {
    width: 60px;
    height: 60px;
  }
  
  .heart {
    width: 60px;
    height: 60px;
  }
  
  .heart-icon {
    width: 32px;
    height: 32px;
  }
  
  .counter-section {
    padding: 40px 15px;
  }
  
  .time-counter {
    gap: 4px;
  }
  
  .time-unit .number {
    font-size: 24px;
  }
  
  .time-unit .label {
    font-size: 12px;
  }
  
  .feature-card {
    padding: 15px 20px;
  }
  
  .feature-icon {
    width: 50px;
    height: 50px;
  }
  
  .feature-title {
    font-size: 16px;
  }
  
  .feature-desc {
    font-size: 12px;
  }
  
  #bannerWave1 {
    height: 40px;
  }
  
  #bannerWave2 {
    height: 30px;
  }
}
</style>
