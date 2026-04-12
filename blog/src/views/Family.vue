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
const anniversaryDate = new Date('2023-05-29T00:00:00')

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

<template>
  <div class="family-page">
    <div class="hero-banner">
      <div class="couple-section">
        <div class="avatar-container">
          <div class="avatar">
            <img src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200&h=200&fit=crop" alt="Rain" />
          </div>
          <span class="name">Rain</span>
        </div>
        
        <div class="heart">
          <span class="heart-icon">❤️</span>
          <div class="heart-rays">
            <span v-for="i in 8" :key="i" class="ray"></span>
          </div>
        </div>
        
        <div class="avatar-container">
          <div class="avatar">
            <img src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=200&h=200&fit=crop" alt="Snow" />
          </div>
          <span class="name">Snow</span>
        </div>
      </div>
    </div>
    
    <div class="counter-section">
      <h2 class="counter-title">这是我们一起走过的</h2>
      
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
        <img src="https://images.unsplash.com/photo-1518837695005-2083093ee35b?w=400&h=200&fit=crop" alt="飞车传信" />
        <div class="card-title">飞车传信</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.family-page {
  min-height: 100vh;
  background: #f5f5f5;
}

.hero-banner {
  height: 400px;
  background: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)),
              url('https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=1920') center/cover;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
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
  display: flex;
  align-items: center;
  gap: 60px;
  z-index: 1;
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
  font-size: 48px;
  animation: heartbeat 1.5s ease-in-out infinite;
}

@keyframes heartbeat {
  0%, 100% { transform: scale(1); }
  50% { transform: scale(1.1); }
}

.heart-rays {
  position: absolute;
  width: 100%;
  height: 100%;
}

.ray {
  position: absolute;
  width: 8px;
  height: 8px;
  background: rgba(255,255,255,0.8);
  border-radius: 50%;
  top: 50%;
  left: 50%;
  transform-origin: center;
}

.ray:nth-child(1) { transform: translate(-50%, -50%) rotate(0deg) translateX(50px); }
.ray:nth-child(2) { transform: translate(-50%, -50%) rotate(45deg) translateX(50px); }
.ray:nth-child(3) { transform: translate(-50%, -50%) rotate(90deg) translateX(50px); }
.ray:nth-child(4) { transform: translate(-50%, -50%) rotate(135deg) translateX(50px); }
.ray:nth-child(5) { transform: translate(-50%, -50%) rotate(180deg) translateX(50px); }
.ray:nth-child(6) { transform: translate(-50%, -50%) rotate(225deg) translateX(50px); }
.ray:nth-child(7) { transform: translate(-50%, -50%) rotate(270deg) translateX(50px); }
.ray:nth-child(8) { transform: translate(-50%, -50%) rotate(315deg) translateX(50px); }

.counter-section {
  padding: 60px 20px;
  text-align: center;
}

.counter-title {
  font-size: 24px;
  color: #d4a574;
  margin-bottom: 30px;
  font-weight: normal;
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
</style>
