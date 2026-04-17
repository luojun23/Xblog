<template>
  <div class="dashboard-page">
    <!-- 页面标题栏 -->
    <div class="page-header">
      <el-icon color="#f59e0b"><Star /></el-icon>
      <span>统计信息</span>
    </div>

    <div class="dashboard-content">
      <!-- 总览 -->
      <div class="section-block">
        <el-button type="primary" class="section-btn teal-btn">总览</el-button>
        <div class="stat-total">
          总访问量（每个IP每天记一次）：<span class="stat-number">{{ totalVisit }}</span>
        </div>

        <div class="stat-tables">
          <!-- 省份访问 TOP10 -->
          <div class="stat-table-wrap">
            <div class="stat-table-title">省份访问TOP10</div>
            <el-table :data="provinceTop10" border style="width: 100%" empty-text="暂无数据">
              <el-table-column prop="province" label="省份" align="center" />
              <el-table-column prop="count" label="数量" align="center" />
            </el-table>
          </div>

          <!-- IP访问 TOP10 -->
          <div class="stat-table-wrap">
            <div class="stat-table-title">IP访问TOP10</div>
            <el-table :data="ipTop10" border style="width: 100%" empty-text="暂无数据">
              <el-table-column prop="ip" label="IP" align="center" />
              <el-table-column prop="count" label="数量" align="center" />
            </el-table>
          </div>
        </div>
      </div>

      <!-- 今日访问 -->
      <div class="section-block">
        <el-button type="primary" class="section-btn teal-btn">今日访问</el-button>
        <div class="stat-total">
          今日访问量：<span class="stat-number red">{{ todayVisit }}</span>
        </div>

        <div class="stat-tables">
          <!-- 今日省份统计 -->
          <div class="stat-table-wrap">
            <div class="stat-table-title">今日访问省份统计</div>
            <el-table :data="todayProvince" border style="width: 100%" empty-text="暂无数据">
              <el-table-column prop="province" label="省份" align="center" />
              <el-table-column prop="count" label="数量" align="center" />
            </el-table>
          </div>

          <!-- 今日访问用户 -->
          <div class="stat-table-wrap">
            <div class="stat-table-title">今日访问用户</div>
            <el-table :data="todayUsers" border style="width: 100%" empty-text="暂无数据">
              <el-table-column label="头像" align="center" width="80">
                <template #default="{ row }">
                  <el-avatar :size="32" :src="row.avatar" />
                </template>
              </el-table-column>
              <el-table-column prop="username" label="用户" align="center" />
            </el-table>
          </div>
        </div>
      </div>

      <!-- 昨日访问 -->
      <div class="section-block">
        <el-button type="primary" class="section-btn teal-btn">昨日访问</el-button>
        <div class="stat-total">
          昨日访问量：<span class="stat-number red">{{ yesterdayVisit }}</span>
        </div>

        <div class="stat-tables">
          <div class="stat-table-wrap full-width">
            <div class="stat-table-title">昨日访问用户</div>
            <el-table :data="yesterdayUsers" border style="width: 100%" empty-text="暂无数据">
              <el-table-column label="头像" align="center" width="80">
                <template #default="{ row }">
                  <el-avatar :size="32" :src="row.avatar" />
                </template>
              </el-table-column>
              <el-table-column prop="username" label="用户" align="center" />
            </el-table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { Star } from '@element-plus/icons-vue'

const totalVisit = ref(2)
const todayVisit = ref(1)
const yesterdayVisit = ref(0)

const provinceTop10 = ref([])
const ipTop10 = ref([
  { ip: '10.64.194.131', count: 2 }
])

const todayProvince = ref([])
const todayUsers = ref([
  { avatar: '', username: 'luojun' }
])

const yesterdayUsers = ref([])
</script>

<style scoped>
.dashboard-page {
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

.dashboard-content {
  padding: 30px 40px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 40px;
}

.section-block {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 16px;
}

.section-btn {
  min-width: 120px;
  height: 40px;
  border-radius: 4px;
  font-size: 15px;
}

.teal-btn {
  background: #20c0a0 !important;
  border-color: #20c0a0 !important;
}

.teal-btn:hover {
  background: #18a88c !important;
  border-color: #18a88c !important;
}

.stat-total {
  font-size: 16px;
  color: #333;
  text-align: center;
}

.stat-number {
  font-size: 22px;
  font-weight: bold;
  color: #20c0a0;
  margin-left: 4px;
}

.stat-number.red {
  color: #f56c6c;
}

.stat-tables {
  width: 100%;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 30px;
}

.stat-table-wrap {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.stat-table-wrap.full-width {
  grid-column: 1 / -1;
}

.stat-table-title {
  font-size: 15px;
  font-weight: 500;
  color: #333;
  text-align: center;
}

@media (max-width: 768px) {
  .dashboard-content {
    padding: 20px 15px;
  }

  .stat-tables {
    grid-template-columns: 1fr;
  }
}
</style>
