<script setup>
import { ref } from 'vue'

const messages = ref([
  { id: 1, name: '访客A', content: '博客设计得很漂亮！', date: '2026-01-20', avatar: '👤' },
  { id: 2, name: '访客B', content: '期待更多技术分享~', date: '2026-01-18', avatar: '👥' },
  { id: 3, name: '访客C', content: '祝博主生活愉快！', date: '2026-01-15', avatar: '😊' },
])

const newMessage = ref('')
const userName = ref('')

const submitMessage = () => {
  if (!newMessage.value.trim() || !userName.value.trim()) return
  
  messages.value.unshift({
    id: Date.now(),
    name: userName.value,
    content: newMessage.value,
    date: new Date().toISOString().split('T')[0],
    avatar: '✨'
  })
  
  newMessage.value = ''
}
</script>

<template>
  <div class="guestbook-page">
    <div class="page-title">
      <h1>留言板</h1>
      <p>留下你的足迹</p>
    </div>
    
    <div class="guestbook-container">
      <div class="message-form">
        <input 
          v-model="userName" 
          type="text" 
          placeholder="你的名字" 
          class="name-input"
        />
        <textarea 
          v-model="newMessage" 
          placeholder="写下你的留言..." 
          rows="4"
          class="message-input"
        ></textarea>
        <button @click="submitMessage" class="submit-btn">发表留言</button>
      </div>
      
      <div class="messages-list">
        <div v-for="msg in messages" :key="msg.id" class="message-item">
          <div class="message-avatar">{{ msg.avatar }}</div>
          <div class="message-content">
            <div class="message-header">
              <span class="message-name">{{ msg.name }}</span>
              <span class="message-date">{{ msg.date }}</span>
            </div>
            <p class="message-text">{{ msg.content }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.guestbook-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
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

.guestbook-container {
  max-width: 800px;
  margin: 0 auto;
}

.message-form {
  background: white;
  border-radius: 16px;
  padding: 24px;
  margin-bottom: 24px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
}

.name-input {
  width: 100%;
  padding: 12px 16px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  margin-bottom: 12px;
  font-size: 14px;
  outline: none;
}

.name-input:focus {
  border-color: #fcb69f;
}

.message-input {
  width: 100%;
  padding: 12px 16px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  margin-bottom: 16px;
  font-size: 14px;
  resize: vertical;
  outline: none;
  font-family: inherit;
}

.message-input:focus {
  border-color: #fcb69f;
}

.submit-btn {
  background: linear-gradient(135deg, #ffecd2, #fcb69f);
  color: #333;
  border: none;
  padding: 12px 32px;
  border-radius: 24px;
  font-size: 14px;
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
}

.submit-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(252, 182, 159, 0.4);
}

.messages-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.message-item {
  background: white;
  border-radius: 12px;
  padding: 20px;
  display: flex;
  gap: 16px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.05);
}

.message-avatar {
  width: 48px;
  height: 48px;
  background: linear-gradient(135deg, #ffecd2, #fcb69f);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 20px;
  flex-shrink: 0;
}

.message-content {
  flex: 1;
}

.message-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 8px;
}

.message-name {
  font-weight: 500;
  color: #333;
}

.message-date {
  font-size: 12px;
  color: #999;
}

.message-text {
  color: #666;
  line-height: 1.6;
}
</style>
