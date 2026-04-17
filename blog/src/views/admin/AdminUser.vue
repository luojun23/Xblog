<template>
  <div class="user-page">
    <!-- 搜索栏 -->
    <div class="search-bar">
      <el-select v-model="searchForm.type" placeholder="用户类型" clearable style="width: 130px">
        <el-option label="管理员" value="admin" />
        <el-option label="游客" value="tourist" />
        <el-option label="普通用户" value="user" />
      </el-select>

      <el-select v-model="searchForm.status" placeholder="用户状态" clearable style="width: 130px">
        <el-option label="启用" value="1" />
        <el-option label="禁用" value="0" />
      </el-select>

      <el-input
        v-model="searchForm.keyword"
        placeholder="用户名/手机号/邮箱"
        style="width: 200px"
        clearable
      />

      <el-button type="primary" class="search-btn" @click="handleSearch">
        <el-icon><Search /></el-icon> 搜索
      </el-button>

      <el-button type="danger" @click="handleClearSearch">清除参数</el-button>
    </div>

    <!-- 用户表格 -->
    <el-table
      :data="userList"
      border
      style="width: 100%"
      :header-cell-style="{ background: '#fff', color: '#606266' }"
    >
      <el-table-column prop="id" label="ID" align="center" width="60" />
      <el-table-column prop="username" label="用户名" align="center" min-width="100" />
      <el-table-column prop="phone" label="手机号" align="center" min-width="120" />
      <el-table-column prop="email" label="邮箱" align="center" min-width="150" />
      <el-table-column label="赞赏" align="center" width="80">
        <template #default="{ row }">
          <el-image
            v-if="row.reward"
            :src="row.reward"
            style="width: 40px; height: 40px"
            fit="cover"
          />
        </template>
      </el-table-column>
      <el-table-column label="用户状态" align="center" width="90">
        <template #default="{ row }">
          <el-tag :type="row.status === 1 ? 'success' : 'danger'" size="small">
            {{ row.status === 1 ? '启用' : '禁用' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="头像" align="center" width="80">
        <template #default="{ row }">
          <el-avatar :size="32" :src="row.avatar">
            <span>{{ row.username?.[0] }}</span>
          </el-avatar>
          <div v-if="row.avatarFailed" class="avatar-fail-text">加载失败</div>
        </template>
      </el-table-column>
      <el-table-column label="性别" align="center" width="70">
        <template #default="{ row }">
          <el-tag
            :type="row.gender === '男' ? 'primary' : 'danger'"
            size="small"
          >
            {{ row.gender || '未知' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="intro" label="简介" align="center" min-width="120" show-overflow-tooltip />
      <el-table-column label="用户类型" align="center" width="90">
        <template #default="{ row }">
          <el-tag type="success" size="small">{{ row.type || '游客' }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="createdAt" label="注册时间" align="center" min-width="160" />
    </el-table>

    <!-- 分页 -->
    <div class="pagination-wrap">
      <el-pagination
        v-model:current-page="pagination.page"
        v-model:page-size="pagination.size"
        :total="pagination.total"
        :page-sizes="[10, 20, 50]"
        layout="total, prev, pager, next"
        @current-change="handlePageChange"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { Search } from '@element-plus/icons-vue'

const searchForm = reactive({
  type: '',
  status: '',
  keyword: ''
})

const pagination = reactive({
  page: 1,
  size: 10,
  total: 1
})

const userList = ref([
  {
    id: 1,
    username: 'luojun',
    phone: '',
    email: '',
    reward: '',
    status: 1,
    avatar: '',
    avatarFailed: false,
    gender: '男',
    intro: '',
    type: '站长',
    createdAt: '2026-04-14 15:14:45'
  }
])

const handleSearch = () => {
  // 实际项目中调用接口
  console.log('搜索：', searchForm)
}

const handleClearSearch = () => {
  searchForm.type = ''
  searchForm.status = ''
  searchForm.keyword = ''
}

const handlePageChange = (page) => {
  pagination.page = page
  // 实际项目中调用接口获取数据
}
</script>

<style scoped>
.user-page {
  background: white;
  border-radius: 8px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

/* 搜索栏 */
.search-bar {
  display: flex;
  align-items: center;
  gap: 10px;
  flex-wrap: wrap;
}

.search-btn {
  background: #409eff;
  border-color: #409eff;
}

/* 表格 */
:deep(.el-table) {
  font-size: 13px;
}

:deep(.el-table th) {
  font-weight: 500;
  color: #606266;
}

.avatar-fail-text {
  font-size: 10px;
  color: #f56c6c;
  text-align: center;
}

/* 分页 */
.pagination-wrap {
  display: flex;
  justify-content: flex-end;
  padding-top: 10px;
}

@media (max-width: 768px) {
  .search-bar {
    flex-direction: column;
    align-items: stretch;
  }

  .user-page {
    padding: 15px;
  }
}
</style>
