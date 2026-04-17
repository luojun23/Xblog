<template>
  <div class="setting-page">
    <!-- 页面标题栏 -->
    <div class="page-header">
      <el-icon color="#f59e0b"><Star /></el-icon>
      <span>基础信息</span>
    </div>

    <div class="setting-content">
      <el-form
        :model="form"
        :rules="rules"
        ref="formRef"
        label-width="90px"
        class="setting-form"
      >
        <!-- 网站名称 -->
        <el-form-item label="网站名称" prop="webName" required>
          <el-input v-model="form.webName" placeholder="请输入网站名称" />
        </el-form-item>

        <!-- 网站标题 -->
        <el-form-item label="网站标题" prop="webTitle" required>
          <el-input v-model="form.webTitle" placeholder="请输入网站标题" />
        </el-form-item>

        <!-- 页脚 -->
        <el-form-item label="页脚" prop="webFooter" required>
          <el-input v-model="form.webFooter" placeholder="请输入页脚信息" />
        </el-form-item>

        <!-- 状态 -->
        <el-form-item label="状态" required>
          <el-switch v-model="form.status" />
        </el-form-item>

        <!-- 背景图 -->
        <el-form-item label="背景" required>
          <div class="upload-area">
            <el-input v-model="form.backgroundImage" placeholder="图片URL" class="upload-input">
              <template #append>
                <span class="url-tag">URL地址</span>
              </template>
            </el-input>
            <el-upload
              class="upload-dragger"
              drag
              action="#"
              :auto-upload="false"
              :show-file-list="false"
              accept="image/*"
              :on-change="(file) => handleUploadChange(file, 'backgroundImage')"
            >
              <div class="upload-inner">
                <el-icon class="upload-icon"><Upload /></el-icon>
                <div class="upload-text">拖拽上传 / 点击上传</div>
              </div>
            </el-upload>
            <div class="upload-tip">一次最多上传1张图片，且每张图片不超过3M！</div>
            <el-button type="success" class="upload-submit-btn" @click="handleSubmitBg">上传</el-button>
          </div>
        </el-form-item>

        <!-- 头像 -->
        <el-form-item label="头像" required>
          <div class="upload-area">
            <el-input v-model="form.avatar" placeholder="图片URL" class="upload-input">
              <template #append>
                <span class="url-tag">URL地址</span>
              </template>
            </el-input>
            <el-upload
              class="upload-dragger"
              drag
              action="#"
              :auto-upload="false"
              :show-file-list="false"
              accept="image/*"
              :on-change="(file) => handleUploadChange(file, 'avatar')"
            >
              <div class="upload-inner">
                <el-icon class="upload-icon"><Upload /></el-icon>
                <div class="upload-text">拖拽上传 / 点击上传</div>
              </div>
            </el-upload>
            <div class="upload-tip">一次最多上传1张图片，且每张图片不超过2M！</div>
          </div>
        </el-form-item>

        <!-- 作者名称 -->
        <el-form-item label="作者名称" prop="author">
          <el-input v-model="form.author" placeholder="请输入作者名称" />
        </el-form-item>

        <!-- 网站公告 -->
        <el-form-item label="网站公告" prop="notice">
          <el-input
            v-model="form.notice"
            type="textarea"
            :rows="3"
            placeholder="请输入网站公告"
          />
        </el-form-item>

        <!-- 提交按钮 -->
        <el-form-item>
          <el-button type="primary" class="submit-btn" @click="handleSave">
            保存设置
          </el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'
import { Star, Upload } from '@element-plus/icons-vue'

const formRef = ref()

const form = reactive({
  webName: 'Sara',
  webTitle: 'POETIZE', 
  webFooter: '云想衣裳花想容，更多资源bygoukai.com',
  status: true,
  backgroundImage: '',
  avatar: '', 
  author: 'Luojun',
  notice: ''
})

const rules = {
  webName: [{ required: true, message: '请输入网站名称', trigger: 'blur' }],
  webTitle: [{ required: true, message: '请输入网站标题', trigger: 'blur' }],
  webFooter: [{ required: true, message: '请输入页脚', trigger: 'blur' }]
}

const handleUploadChange = (file, field) => {
  const url = URL.createObjectURL(file.raw)
  form[field] = url
}

const handleSubmitBg = () => {
  ElMessage.success('背景图上传成功')
}

const handleSave = async () => {
  await formRef.value.validate((valid) => {
    if (valid) {
      ElMessage.success('保存成功')
    }
  })
}

const handleReset = () => {
  formRef.value.resetFields()
}
</script>

<style scoped>
.setting-page {
  background: white;
  border-radius: 8px;
  overflow: hidden;
}

.page-header {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 14px 20px;
  background: linear-gradient(90deg, #fef3c7, #fde68a);
  font-size: 15px;
  font-weight: 500;
  color: #555;
}

.setting-content {
  padding: 30px 40px;
}

.setting-form {
  max-width: 900px;
}

/* 上传区域 */
.upload-area {
  display: flex;
  flex-direction: column;
  gap: 10px;
  width: 100%;
}

.upload-input {
  width: 100%;
}

.url-tag {
  font-size: 12px;
  color: #666;
  white-space: nowrap;
}

.upload-dragger {
  width: 100%;
}

.upload-dragger :deep(.el-upload) {
  width: 100%;
}

.upload-dragger :deep(.el-upload-dragger) {
  width: 100%;
  height: 120px;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px dashed #d9d9d9;
  border-radius: 8px;
  background: #fafafa;
  transition: border-color 0.3s;
}

.upload-dragger :deep(.el-upload-dragger:hover) {
  border-color: #7c3aed;
}

.upload-inner {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
}

.upload-icon {
  font-size: 36px;
  color: #7c3aed;
}

.upload-text {
  font-size: 14px;
  color: #7c3aed;
}

.upload-tip {
  font-size: 12px;
  color: #f56c6c;
}

.upload-submit-btn {
  width: fit-content;
  align-self: center;
  background: #4caf50;
  border-color: #4caf50;
}

.upload-submit-btn:hover {
  background: #43a047;
  border-color: #43a047;
}

.submit-btn {
  background: #20c0a0;
  border-color: #20c0a0;
  padding: 10px 40px;
}

.submit-btn:hover {
  background: #18a88c;
  border-color: #18a88c;
}
</style>
