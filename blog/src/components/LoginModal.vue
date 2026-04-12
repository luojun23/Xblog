<script setup>
import { ref } from 'vue'

const props = defineProps({
  show: Boolean
})

const emit = defineEmits(['close'])

const username = ref('')
const password = ref('')
const isLogin = ref(true)

const close = () => {
  emit('close')
}

const toggleMode = () => {
  isLogin.value = !isLogin.value
}

const handleSubmit = () => {
  // 这里处理登录/注册逻辑
  console.log(isLogin.value ? '登录' : '注册', username.value, password.value)
  close()
}

const handleOverlayClick = (e) => {
  if (e.target === e.currentTarget) {
    close()
  }
}
</script>

<template>
  <Teleport to="body">
    <Transition name="fade">
      <div v-if="show" class="modal-overlay" @click="handleOverlayClick">
        <Transition name="scale">
          <div v-if="show" class="modal-container">
            <button class="close-btn" @click="close">×</button>
            
            <div class="modal-content">
              <div class="modal-left">
                <div class="brand">Corrain</div>
              </div>
              
              <div class="modal-right">
                <div class="form-header">
                  <h2>{{ isLogin ? '登录' : '注册' }}</h2>
                  <p class="toggle-text">
                    {{ isLogin ? '没有账号？' : '已有账号？' }}
                    <a href="#" @click.prevent="toggleMode">
                      {{ isLogin ? '立即注册 >' : '立即登录 >' }}
                    </a>
                  </p>
                </div>
                
                <form @submit.prevent="handleSubmit" class="login-form">
                  <div class="form-group">
                    <input 
                      v-model="username"
                      type="text" 
                      placeholder="用户名/邮箱"
                      required
                    />
                  </div>
                  
                  <div class="form-group">
                    <input 
                      v-model="password"
                      type="password" 
                      placeholder="登录密码"
                      required
                    />
                  </div>
                  
                  <div v-if="!isLogin" class="form-group">
                    <input 
                      type="password" 
                      placeholder="确认密码"
                      required
                    />
                  </div>
                  
                  <div class="form-options" v-if="isLogin">
                    <a href="#" class="forgot-link">修改密码</a>
                    <a href="#" class="forgot-link">免密登录</a>
                  </div>
                  
                  <button type="submit" class="submit-btn">
                    <span class="btn-icon">🔒</span>
                    {{ isLogin ? '登录' : '注册' }}
                  </button>
                </form>
              </div>
            </div>
          </div>
        </Transition>
      </div>
    </Transition>
  </Teleport>
</template>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 2000;
  backdrop-filter: blur(5px);
}

.modal-container {
  background: white;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
  position: relative;
  max-width: 800px;
  width: 90%;
}

.close-btn {
  position: absolute;
  top: 16px;
  right: 16px;
  width: 32px;
  height: 32px;
  border: none;
  background: rgba(0, 0, 0, 0.1);
  border-radius: 50%;
  font-size: 20px;
  cursor: pointer;
  z-index: 10;
  transition: all 0.3s;
  display: flex;
  align-items: center;
  justify-content: center;
}

.close-btn:hover {
  background: rgba(0, 0, 0, 0.2);
}

.modal-content {
  display: flex;
  min-height: 450px;
}

.modal-left {
  flex: 1;
  background: linear-gradient(135deg, #e8e8e8 0%, #d4d4d4 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  overflow: hidden;
}

.modal-left::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: url('https://images.unsplash.com/photo-1513694203232-719a280e022f?w=600') center/cover;
  opacity: 0.3;
}

.brand {
  font-size: 32px;
  font-weight: bold;
  color: #333;
  position: relative;
  z-index: 1;
}

.modal-right {
  flex: 1;
  padding: 50px 40px;
  display: flex;
  flex-direction: column;
}

.form-header {
  margin-bottom: 30px;
}

.form-header h2 {
  font-size: 28px;
  color: #333;
  margin-bottom: 8px;
}

.toggle-text {
  font-size: 13px;
  color: #666;
}

.toggle-text a {
  color: #ff6b9d;
  text-decoration: none;
}

.toggle-text a:hover {
  text-decoration: underline;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 16px;
  flex: 1;
}

.form-group input {
  width: 100%;
  padding: 14px 0;
  border: none;
  border-bottom: 1px solid #e0e0e0;
  font-size: 14px;
  outline: none;
  transition: border-color 0.3s;
  background: transparent;
}

.form-group input:focus {
  border-bottom-color: #ff6b9d;
}

.form-group input::placeholder {
  color: #999;
}

.form-options {
  display: flex;
  justify-content: flex-end;
  gap: 12px;
  font-size: 12px;
}

.forgot-link {
  color: #999;
  text-decoration: none;
}

.forgot-link:hover {
  color: #ff6b9d;
}

.submit-btn {
  background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
  color: white;
  border: none;
  padding: 14px;
  border-radius: 25px;
  font-size: 15px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-top: auto;
  transition: all 0.3s;
}

.submit-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 20px rgba(79, 172, 254, 0.4);
}

.btn-icon {
  font-size: 14px;
}

/* Transitions */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.scale-enter-active,
.scale-leave-active {
  transition: all 0.3s ease;
}

.scale-enter-from,
.scale-leave-to {
  opacity: 0;
  transform: scale(0.9);
}

@media (max-width: 700px) {
  .modal-left {
    display: none;
  }
  
  .modal-right {
    padding: 40px 30px;
  }
}
</style>
