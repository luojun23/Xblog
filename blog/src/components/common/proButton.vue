<template>
  <div class="myButton">
    <div :style="beforeColor">{{ info ? '登录中...' : '登 录' }}</div>
    <div :style="afterColor">{{ info ? '登录中...' : '登 录' }}</div>
    <div :style="afterColor">{{ info ? '登录中...' : '登 录' }}}</div>
  </div>
</template>

<script setup>
import { defineProps,ref ,computed} from 'vue'
const props = defineProps({
  info: {
    type: String,
    default: '确定'
  },
  before: {
    type: String,
  },
  after: {
    type: String,
  }
})

const beforeColor = computed(() => ({'background': props.before}))
const afterColor = computed(() => ({'background': props.after}))

</script>

<style lang="less" scoped>
 .myButton {
    cursor: pointer;
    user-select: none;
    position: relative;
    width: 264px;
    height: 48px;
    border-radius: 4px;
    color: var(--white);
    font-size: 14px;
    overflow: hidden;
  }

  /* 按钮内部 3 个 div 的共同样式 */
  .myButton div {
    width: 264px;
    height: 48px;
    line-height: 48px;
    border-radius: 12px;
    text-align: center;
    position: absolute;
  }

  /* 第二个 div：斜角光效层 */
  .myButton div:nth-child(2) {
    width: 264px;
    transition: all 0.3s ease;
    transform: translateX(-500px) skewX(-30deg);
  }

  /* 第三个 div：覆盖层 */
  .myButton div:nth-child(3) {
    transition: all 0.3s ease;
    transform: translateX(-500px);
  }

  /* 鼠标 hover 时，第二个 div 动画 */
  .myButton:hover div:nth-child(2) {
    transform: translateX(20px) skewX(-30deg);
  }

  .myButton:hover div:nth-child(3) {
    transform: translateX(0px);
  }
</style>
