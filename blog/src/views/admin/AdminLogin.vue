<template>
  <div class="admin-login-page">
    <!-- 背景装饰 -->
    <div class="bg-decoration">
      <div class="bubble bubble-1"></div>
      <div class="bubble bubble-2"></div>
      <div class="bubble bubble-3"></div>
      <div class="bubble bubble-4"></div>
    </div>

    <div class="login-container">
      <!-- 左侧装饰区 -->
      <div class="login-left">
        <div class="brand-logo">
          <span class="logo-icon">✦</span>
          <span class="logo-text">Xblog</span>
        </div>
        <h2 class="left-title">欢迎回来</h2>
        <p class="left-subtitle">博客后台管理系统</p>
        <div class="left-decorations">
          <div class="deco-circle deco-1"></div>
          <div class="deco-circle deco-2"></div>
          <div class="deco-circle deco-3"></div>
        </div>
      </div>

      <!-- 右侧表单区 -->
      <div class="login-right">
        <div class="login-form-wrap">
          <h3 class="form-title">管理员登录</h3>
          <p class="form-subtitle">请输入您的账号和密码</p>

          <el-form ref="loginFormRef" :model="loginForm" :rules="rules" @submit.prevent="handleLogin">
            <el-form-item prop="username">
              <div class="input-wrap">
                <span class="input-icon">
                  <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/>
                    <circle cx="12" cy="7" r="4"/>
                  </svg>
                </span>
                <el-input
                  v-model="loginForm.username"
                  placeholder="请输入账号"
                  size="large"
                  class="custom-input"
                />
              </div>
            </el-form-item>

            <el-form-item prop="password">
              <div class="input-wrap">
                <span class="input-icon">
                  <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <rect x="3" y="11" width="18" height="11" rx="2" ry="2"/>
                    <path d="M7 11V7a5 5 0 0 1 10 0v4"/>
                  </svg>
                </span>
                <el-input
                  v-model="loginForm.password"
                  type="password"
                  placeholder="请输入密码"
                  size="large"
                  class="custom-input"
                  show-password
                  @keyup.enter="handleLogin"
                />
              </div>
            </el-form-item>

            <div class="form-options">
              <el-checkbox v-model="rememberMe" class="remember-check">记住我</el-checkbox>
              <span class="forgot-link">忘记密码？</span>
            </div>

            <el-button
              class="login-btn"
              type="primary"
              size="large"
              :loading="loading"
              @click="handleLogin"
            >
              {{ loading ? '登录中...' : '登 录' }}
            </el-button>
          </el-form>

          <div class="back-link" @click="goHome">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <path d="M19 12H5M12 19l-7-7 7-7"/>
            </svg>
            <span>返回博客首页</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()
const loginFormRef = ref(null)
const loading = ref(false)
const rememberMe = ref(false)

const loginForm = reactive({
  username: '',
  password: ''
})

const rules = {
  username: [
    { required: true, message: '请输入账号', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, message: '密码长度不少于6位', trigger: 'blur' }
  ]
}

const handleLogin = async () => {
  if (!loginFormRef.value) return
  await loginFormRef.value.validate(async (valid) => {
    if (!valid) return
    loading.value = true
    // 模拟登录请求
    setTimeout(() => {
      if (loginForm.username === 'admin' && loginForm.password === '123456') {
        ElMessage.success('登录成功，欢迎回来！')
        router.push('/admin/dashboard')
      } else {
        ElMessage.error('账号或密码错误')
      }
      loading.value = false
    }, 800)
  })
}

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.admin-login-page {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  position: relative;
  overflow: hidden;
}

/* 背景气泡 */
.bg-decoration {
  position: absolute;
  inset: 0;
  pointer-events: none;
}

.bubble {
  position: absolute;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.08);
  animation: floatBubble 8s ease-in-out infinite;
}

.bubble-1 { width: 300px; height: 300px; top: -80px; left: -80px; animation-delay: 0s; }
.bubble-2 { width: 200px; height: 200px; top: 60%; right: -60px; animation-delay: 2s; }
.bubble-3 { width: 150px; height: 150px; bottom: -40px; left: 30%; animation-delay: 4s; }
.bubble-4 { width: 100px; height: 100px; top: 30%; left: 20%; animation-delay: 1s; }

@keyframes floatBubble {
  0%, 100% { transform: translateY(0) scale(1); }
  50% { transform: translateY(-20px) scale(1.05); }
}

/* 卡片容器 */
.login-container {
  display: flex;
  width: 860px;
  min-height: 500px;
  border-radius: 24px;
  overflow: hidden;
  box-shadow: 0 30px 80px rgba(0, 0, 0, 0.3);
  position: relative;
  z-index: 1;
}

/* 左侧装饰 */
.login-left {
  flex: 1;
  background: linear-gradient(160deg, rgba(255,255,255,0.25) 0%, rgba(255,255,255,0.05) 100%);
  backdrop-filter: blur(10px);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 48px;
  text-align: center;
  position: relative;
  overflow: hidden;
}

.brand-logo {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 32px;
}

.logo-icon {
  font-size: 28px;
  color: #fff;
}

.logo-text {
  font-size: 26px;
  font-weight: 700;
  color: #fff;
  letter-spacing: 2px;
}

.left-title {
  font-size: 32px;
  font-weight: 700;
  color: #fff;
  margin: 0 0 12px 0;
}

.left-subtitle {
  font-size: 15px;
  color: rgba(255, 255, 255, 0.75);
  margin: 0;
}

.left-decorations {
  position: absolute;
  inset: 0;
  pointer-events: none;
}

.deco-circle {
  position: absolute;
  border-radius: 50%;
  border: 2px solid rgba(255, 255, 255, 0.15);
}

.deco-1 { width: 200px; height: 200px; top: -60px; right: -60px; }
.deco-2 { width: 140px; height: 140px; bottom: 40px; left: -40px; }
.deco-3 { width: 80px; height: 80px; bottom: 100px; right: 30px; }

/* 右侧表单 */
.login-right {
  flex: 1.1;
  background: #fff;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 48px;
}

.login-form-wrap {
  width: 100%;
  max-width: 360px;
}

.form-title {
  font-size: 26px;
  font-weight: 700;
  color: #1a1a2e;
  margin: 0 0 8px 0;
}

.form-subtitle {
  font-size: 14px;
  color: #8c8c8c;
  margin: 0 0 32px 0;
}

/* 输入框 */
.input-wrap {
  position: relative;
  display: flex;
  align-items: center;
  width: 100%;
}

.input-icon {
  position: absolute;
  left: 14px;
  z-index: 10;
  display: flex;
  align-items: center;
  color: #999;
}

.input-icon svg {
  width: 18px;
  height: 18px;
}

.custom-input :deep(.el-input__wrapper) {
  padding-left: 44px;
  border-radius: 12px;
  box-shadow: none;
  border: 1.5px solid #e8e8e8;
  transition: all 0.25s;
}

.custom-input :deep(.el-input__wrapper:hover),
.custom-input :deep(.el-input__wrapper.is-focus) {
  border-color: #7c3aed;
  box-shadow: 0 0 0 3px rgba(124, 58, 237, 0.1);
}

.custom-input :deep(.el-input__inner) {
  font-size: 14px;
  color: #333;
}

/* 选项行 */
.form-options {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 4px 0 20px;
}

.remember-check :deep(.el-checkbox__label) {
  font-size: 13px;
  color: #666;
}

.remember-check :deep(.el-checkbox__input.is-checked .el-checkbox__inner) {
  background-color: #7c3aed;
  border-color: #7c3aed;
}

.forgot-link {
  font-size: 13px;
  color: #7c3aed;
  cursor: pointer;
  transition: opacity 0.2s;
}

.forgot-link:hover {
  opacity: 0.7;
}

/* 登录按钮 */
.login-btn {
  width: 100%;
  height: 48px;
  border-radius: 12px;
  font-size: 16px;
  font-weight: 600;
  letter-spacing: 4px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border: none;
  transition: all 0.3s;
  box-shadow: 0 4px 15px rgba(118, 75, 162, 0.4);
}

.login-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 25px rgba(118, 75, 162, 0.5);
}

/* 返回链接 */
.back-link {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 6px;
  margin-top: 24px;
  color: #999;
  font-size: 13px;
  cursor: pointer;
  transition: color 0.2s;
}

.back-link:hover {
  color: #7c3aed;
}

.back-link svg {
  width: 14px;
  height: 14px;
}

/* el-form-item 间距 */
:deep(.el-form-item) {
  margin-bottom: 18px;
}

/* 移动端适配 */
@media (max-width: 680px) {
  .login-container {
    flex-direction: column;
    width: 90%;
    min-height: unset;
    border-radius: 16px;
  }

  .login-left {
    padding: 32px 24px;
    border-right: none;
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  }

  .left-title { font-size: 24px; }

  .login-right {
    padding: 32px 24px;
  }
}
</style>
