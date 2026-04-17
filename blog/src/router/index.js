import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Index from '../views/Index.vue'
import Love from '../views/Love.vue'
import Essays from '../views/Essays.vue'
import Records from '../views/Records.vue'
import Album from '../views/Album.vue'
import Toolbox from '../views/Toolbox.vue'
import Guestbook from '../views/Guestbook.vue'
import Contact from '../views/Contact.vue'
import Admin from '../views/admin/Admin.vue'
import AdminLogin from '../views/admin/AdminLogin.vue'
import AdminDashboard from '../views/admin/AdminDashboard.vue'
import AdminSetting from '../views/admin/AdminSetting.vue'
import AdminUser from '../views/admin/AdminUser.vue'
import Test from '../views/Test.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/blog', name: 'Blog', component: Index },
  { path: '/love', name: 'Love', component: Love },
  { path: '/essays', name: 'Essays', component: Essays },
  { path: '/records', name: 'Records', component: Records },
  { path: '/album', name: 'Album', component: Album },
  { path: '/toolbox', name: 'Toolbox', component: Toolbox },
  { path: '/guestbook', name: 'Guestbook', component: Guestbook },
  { path: '/contact', name: 'Contact', component: Contact },
  { path: '/admin/login', name: 'AdminLogin', component: AdminLogin },
  { path: '/test', name: 'Test', component: Test },
  {
    path: '/admin',
    component: Admin,
    redirect: '/admin/dashboard',
    children: [
      { path: 'dashboard', name: 'AdminDashboard', component: AdminDashboard },
      { path: 'setting', name: 'AdminSetting', component: AdminSetting },
      { path: 'user', name: 'AdminUser', component: AdminUser },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
