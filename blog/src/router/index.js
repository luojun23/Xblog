import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Family from '../views/Family.vue'
import Essays from '../views/Essays.vue'
import Records from '../views/Records.vue'
import Album from '../views/Album.vue'
import Toolbox from '../views/Toolbox.vue'
import Guestbook from '../views/Guestbook.vue'
import Contact from '../views/Contact.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/family', name: 'Family', component: Family },
  { path: '/essays', name: 'Essays', component: Essays },
  { path: '/records', name: 'Records', component: Records },
  { path: '/album', name: 'Album', component: Album },
  { path: '/toolbox', name: 'Toolbox', component: Toolbox },
  { path: '/guestbook', name: 'Guestbook', component: Guestbook },
  { path: '/contact', name: 'Contact', component: Contact },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
