<template>
  <div class="printer">
    <span class="printer-text">{{ displayText }}</span>
    <span class="cursor" :class="{ 'cursor-blink': isBlinking }"></span>
  </div>
</template>

<script setup>
import { ref, watch, onMounted } from 'vue'

const props = defineProps({
  printerInfo: {
    type: String,
    default: ''
  },
  speed: {
    type: Number,
    default: 150
  }
})

const displayText = ref('')
const isBlinking = ref(true)
let currentIndex = 0
let timer = null

const startTyping = () => {
  displayText.value = ''
  currentIndex = 0
  isBlinking.value = false
  
  if (timer) {
    clearInterval(timer)
  }
  
  timer = setInterval(() => {
    if (currentIndex < props.printerInfo.length) {
      displayText.value += props.printerInfo[currentIndex]
      currentIndex++
    } else {
      clearInterval(timer)
      isBlinking.value = true
    }
  }, props.speed)
}

// 监听 printerInfo 变化
watch(() => props.printerInfo, (newVal) => {
  if (newVal) {
    startTyping()
  }
}, { immediate: true })

onMounted(() => {
  if (props.printerInfo) {
    startTyping()
  }
})
</script>

<style scoped>
.printer {
  display: inline-flex;
  align-items: center;
  font-family: 'ZCOOL WenYiTi', 'PingFang SC', 'Microsoft YaHei', serif;
}

.printer-text {
  white-space: nowrap;
}

.cursor {
  display: inline-block;
  width: 2px;
  height: 1em;
  background: currentColor;
  margin-left: 2px;
  vertical-align: middle;
}

.cursor-blink {
  animation: blink 1s infinite;
}

@keyframes blink {
  0%, 50% {
    opacity: 1;
  }
  51%, 100% {
    opacity: 0;
  }
}
</style>
