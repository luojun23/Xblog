<template>
  <div class="form-validation">
    <h2>表单验证</h2>
    
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label>用户名:</label>
        <input 
          v-model="username" 
          placeholder="请输入用户名"
          :class="{ invalid: !usernameValid }"
        >
        <span v-if="!usernameValid" class="error-message">{{ usernameError }}</span>
      </div>
      
      <div class="form-group">
        <label>邮箱:</label>
        <input 
          v-model="email" 
          type="email" 
          placeholder="请输入邮箱"
          :class="{ invalid: !emailValid }"
        >
        <span v-if="!emailValid" class="error-message">{{ emailError }}</span>
      </div>
      
      <div class="form-group">
        <label>密码:</label>
        <input 
          v-model="password" 
          type="password" 
          placeholder="请输入密码"
          :class="{ invalid: !passwordValid }"
        >
        <span v-if="!passwordValid" class="error-message">{{ passwordError }}</span>
      </div>
      
      <div class="form-group">
        <label>确认密码:</label>
        <input 
          v-model="confirmPassword" 
          type="password" 
          placeholder="请确认密码"
          :class="{ invalid: !confirmPasswordValid }"
        >
        <span v-if="!confirmPasswordValid" class="error-message">{{ confirmPasswordError }}</span>
      </div>
      
      <button type="submit" :disabled="!formValid">提交</button>
    </form>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';

// 表单数据
const username = ref('');
const email = ref('');
const password = ref('');
const confirmPassword = ref('');

// 用户名验证
const usernameValid = computed(() => {
  return username.value.length >= 3 && username.value.length <= 20;
});

const usernameError = computed(() => {
  if (username.value.length === 0) return '';
  if (username.value.length < 3) return '用户名至少3个字符';
  if (username.value.length > 20) return '用户名最多20个字符';
  return '';
});

// 邮箱验证
const emailValid = computed(() => {
  if (!email.value) return true; // 空值暂时视为有效，提交时再强制检查
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email.value);
});

const emailError = computed(() => {
  if (!email.value) return '';
  return emailValid.value ? '' : '请输入有效的邮箱地址';
});

// 密码验证
const passwordValid = computed(() => {
  if (!password.value) return true; // 空值暂时视为有效
  return password.value.length >= 6 && /[A-Z]/.test(password.value) && /[0-9]/.test(password.value);
});

const passwordError = computed(() => {
  if (!password.value) return '';
  if (password.value.length < 6) return '密码至少6个字符';
  if (!/[A-Z]/.test(password.value)) return '密码必须包含大写字母';
  if (!/[0-9]/.test(password.value)) return '密码必须包含数字';
  return '';
});

const confirmPasswordValid = computed(() => {
  return confirmPassword.value === password.value;
});

const confirmPasswordError = computed(() => {
  if (!confirmPassword.value) return '';
  return confirmPasswordValid.value ? '' : '两次输入的密码不一致';
}); 

const formValid = computed(() => {
  return usernameValid.value && emailValid.value && passwordValid.value && confirmPasswordValid.value;
});
</script>
