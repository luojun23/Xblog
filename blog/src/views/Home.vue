<template>
  <div class="home-page" :class="{ 'search-active': showSearchPanel }">
    <div class="hero-section">
      <div class="time-display">
        <div class="time">
          <div class="time-main">
            <span class="time-num">{{ hours }}</span>
            <span class="separator">:</span>
            <span class="time-num">{{ minutes }}</span>
          </div>
          <span class="am-pm">{{ amPm }}</span>
        </div>
        <div class="date-info">
          <span class="lunar">{{ lunarDate }}</span>
          <div class="date">
            <span class="date-num">{{ currentMonth }}</span>
            <span class="date-unit">月</span>
            <span class="date-num">{{ currentDay }}</span>
            <span class="date-unit">日</span>
            <span class="date-week">{{ weekDay }}</span>
          </div>
        </div>
      </div>
      
      <div class="search-container" ref="searchContainer">
        <div class="search-box">
          <span class="search-icon" @click="toggleSearchPanel" v-html="currentEngineIcon"></span>
          <input type="text" placeholder="搜点什么吧" autocomplete="false" id="main-input"
           v-model="searchQuery" @keyup.enter="doSearch"/>
          <div class="go" @click="doSearch"> 
            <span class="search-btn" v-html="currentButtonIcon"></span>
        </div>
        </div>
        
        <Transition name="slide-fade">
          <div v-if="showSearchPanel" class="search-panel">
            <div class="search-engines">
              <div 
                v-for="engine in searchEngines" 
                :key="engine.name"
                class="engine-item"
                :class="{ active: currentEngine === engine.name }"
                @click="selectEngine(engine)"
              >
                <span class="engine-icon" v-html="engine.icon"></span>
                <span class="engine-name">{{ engine.name }}</span>
              </div>
            </div>
          </div>
        </Transition>
      </div>
      
      <div class="quick-links">
        <div class="link-item">
          <div class="link-icon blog">📷</div>
          <span>博客</span>
        </div>
        <div class="link-item">
          <div class="link-icon more">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
          </div>
          <span>更多</span>
        </div>
      </div>
    </div>
    
    <div class="footer">
      本网站由LUOJUN强力支持 京公网安备 11011602001009号
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted, computed } from 'vue'
import { Solar } from 'lunar-javascript'

const currentTime = ref('')
const currentDate = ref('')
const lunarDate = ref('')
const weekDay = ref('')
const hours = ref('12')
const minutes = ref('00')
const amPm = ref('AM')
const currentYear = ref('2026')
const currentMonth = ref('1')
const currentDay = ref('1')
const searchQuery = ref('')
const showSearchPanel = ref(false)
const currentEngine = ref('百度')
const searchContainer = ref(null)

const currentEngineIcon = computed(() => {
  const engine = searchEngines.find(e => e.name === currentEngine.value)
  return engine ? engine.icon : '🐾'
})

const currentButtonIcon = computed(() => {
  const engine = searchEngines.find(e => e.name === 'button')
  return engine.icon
})

const searchEngines = [
  { 
    name: '百度', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor"><path d="M 206.578 584.504 c -52.7959 0 -94.1032 -62.1602 -94.1032 -141.578 S 153.783 301.349 206.578 301.349 s 94.0991 62.1598 94.0991 141.578 s -41.3101 141.578 -94.0991 141.578 Z m 188.106 -188.079 c -52.6931 0 -94.0064 -61.9732 -94.0064 -141.06 S 341.99 114.308 394.683 114.308 s 94.0117 61.9732 94.0117 141.057 s -41.3141 141.06 -94.0117 141.06 Z m 235.35 0 c -52.7878 0 -94.102 -61.9732 -94.1019 -141.06 S 577.245 114.308 630.033 114.308 s 94.102 61.9732 94.102 141.057 s -41.3141 141.06 -94.102 141.06 Z M 818.237 584.504 c -52.7919 0 -94.102 -62.1602 -94.102 -141.578 s 41.3101 -141.578 94.102 -141.578 S 912.339 363.509 912.339 442.927 s -41.3101 141.578 -94.1019 141.578 Z M 677.086 866.619 c -40.8427 0 -68.4599 -13.8229 -92.7892 -25.9997 c -22.5815 -11.2867 -42.062 -21.0208 -71.8903 -21.0208 c -29.6901 0 -49.1665 9.73412 -71.7521 21.0208 c -24.4211 12.1768 -52.0887 25.9997 -92.9261 25.9997 c -26.1614 0 -50.7666 -14.2456 -67.6138 -39.0747 c -29.4974 -43.5414 -29.9681 -109.599 -1.31726 -181.258 c 51.6173 -128.929 136.73 -202.84 233.564 -202.84 s 181.99 73.9102 233.558 202.84 c 28.6537 71.6586 28.1822 137.717 -1.31685 181.258 c -16.798 24.8291 -41.4523 39.0747 -67.6146 39.0747 h 0.0975441 Z M 512.406 772.578" fill="#ffffff"/></svg>`, 
    url: 'https://www.baidu.com/s?wd=' 
  },
  { 
    name: '必应', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor"><path d="M 716.791 639.892 c -36.2109 -12.4865 -67.3023 -24.2655 -99.0181 -34.0882 c -32.7979 -10.1557 -54.6909 -29.1352 -66.5947 -62.4326 c -19.0627 -53.5671 -41.1639 -106.01 -61.9747 -158.953 c -7.53353 -19.146 -10.1973 -38.1671 6.49299 -54.1082 s 35.3785 -12.1119 54.1082 -2.53892 c 56.1061 29.1352 112.712 56.8969 168.36 86.6564 c 155.832 83.2434 191.46 302.798 69.7164 429.952 a 169.567 169.567 0 0 1 -26.3049 23.5163 c -65.3461 44.5769 -132.274 86.698 -201.657 124.865 c -161.118 88.2796 -361.152 -20.8109 -392.409 -198.577 a 294.723 294.723 0 0 1 -4.16217 -51.6942 q 0.499461 -340.257 0.624326 -680.515 A 190.003 190.003 0 0 1 164.471 39.1244 c 3.53785 -31.0082 35.0455 -49.2385 61.2255 -33.1309 c 48.4477 29.7179 96.8537 59.9353 142.305 93.9818 c 30.0509 22.4757 42.0795 56.9385 41.9963 95.7299 q -0.332974 297.554 0.624326 595.19 c 0 9.1984 -5.20271 22.0595 3.91244 26.8876 c 7.40866 3.91244 15.7746 -6.36812 23.3082 -10.8216 q 130.775 -77.2499 261.218 -155.082 c 4.62001 -2.78866 8.99029 -6.16001 17.7308 -11.9871 Z" fill="#ffffff"/></svg>`, 
    url: 'https://www.bing.com/search?q=' 
  },
  { 
    name: 'Google', 
    icon: `<svg viewBox="0 0 24 24" fill="currentColor"><path d="M12.545 10.239v3.821h5.445c-.712 2.315-2.647 3.972-5.445 3.972a6.033 6.033 0 110-12.064c1.498 0 2.866.549 3.921 1.453l2.814-2.814A9.969 9.969 0 0012.545 2C6.477 2 1.545 6.932 1.545 13s4.932 11 11 11 11-4.932 11-11c0-.732-.074-1.446-.214-2.136H12.545z" fill="#ffffff"/></svg>`, 
    url: 'https://www.google.com/search?q=' 
  },
  { 
    name: '搜狗', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor">
        <path d="M 512 973.824 c -257.365 0 -465.988 -207.735 -465.988 -463.94 S 254.635 45.9435 512 45.9435 c 257.365 0 465.988 207.735 465.988 463.94 a 460.732 460.732 0 0 1 -109.431 298.598 l 37.0688 26.624 a 505.719 505.719 0 0 0 117.897 -325.222 c 0 -281.259 -229.035 -509.269 -511.522 -509.269 S 0.477867 228.693 0.477867 509.952 s 229.035 509.269 511.522 509.269 c 67.0379 0 133.393 -13.0389 195.243 -38.5707 l -23.0059 -39.5947 a 466.534 466.534 0 0 1 -172.237 32.768 Z m 215.245 9.89867 l 23.0059 39.5947 a 512.819 512.819 0 0 0 198.315 -145.476 l -37.0688 -26.624 a 466.739 466.739 0 0 1 -184.32 132.437 Z" fill="#ffffff"/>
        <path d="M502.237867 702.122667s-186.094933 1.365333-287.470934-92.637867l-7.9872 131.345067s612.5568 221.184 618.0864-134.075734c0 0 13.038933-84.3776-208.759466-142.404266 0 0-87.4496-21.162667-186.094934-77.4144 0 0-50.7904-62.2592 104.174934-49.834667 183.773867 14.813867 280.576 62.2592 280.576 62.2592V283.2384S395.264 126.976 231.424 305.3568c0 0-55.5008 81.578667 0 132.7104 55.569067 51.2 168.072533 116.1216 319.488 154.8288-0.068267 0 194.3552 88.4736-48.674133 109.226667z" fill="#ffffff"/></svg>`, 
    url: 'https://www.sogou.com/web?query=' 
  },
  { 
    name: '360搜索', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor"><circle cx="12" cy="12" r="10"/><path fill="#fff" d="M 958.244 134.515 c -33.298 -16.109 -68.41 -23.743 -104.463 -27.597 c -7.92 -0.848 -16.01 -0.125 -26.531 -0.125 C 953.436 211.25 1021.19 342.95 1023.92 504.4 c 2.309 136.7 -44.828 256.318 -138.022 357.239 c -177.47 192.193 -497.773 229.087 -722.417 27.259 c -5.771 37.258 -4.731 73.756 1.462 113.104 c -18.232 -21.498 -31.42 -42.771 -41.206 -66.061 c -15.578 -37.074 -25.186 -75.682 -29.598 -115.697 c -0.89 -8.071 -4.038 -16.653 -8.507 -23.451 C 43.4 732.557 16.124 662.584 5.204 586.612 C -2.28 534.56 -1.739 482.498 7.13 430.333 C 33.729 273.888 115.792 154.959 250.297 72.2301 C 319.631 29.5871 395.921 6.75307 477.444 1.22907 c 88.36 -5.985 172.373 9.918 252.705 46.806 c 6.815 3.129 14.999 4.56 22.556 4.592 c 52.394 0.228 102.592 10.741 150.657 31.283 c 24.039 10.275 41.772 27.933 54.882 50.605 Z M 180.793 781.437 c -3.434 17.476 -7.027 32.89 -9.2 48.503 c -0.683 4.909 0.777 12.018 4.072 15.296 c 61.884 61.525 135.3 103.454 220.13 123.896 c 76.62 18.464 153.679 18.313 230.254 -1.711 c 100.158 -26.191 182.979 -79.631 248.537 -159.445 c 40.958 -49.866 70.28 -105.919 88.243 -168.1 c 12.74 -44.104 18.593 -89.031 18.378 -134.599 c -0.22 -46.301 -7.566 -91.688 -21.679 -136.086 c -33.557 -105.558 -96.713 -188.762 -188.11 -250.795 c -4.951 -3.362 -13.242 -3.906 -19.515 -2.896 c -47.906 7.694 -89.099 31.62 -130.723 54.623 c -44.293 24.474 -83.406 56.002 -122.55 87.589 c -4.355 3.519 -9.855 7.212 -15.14 7.753 c -67.97 6.949 -122.042 38.126 -161.964 93.063 c -10.904 15.008 -18.646 32.305 -28.159 49.117 h 427.646 c -34.55 -82.875 -93.391 -130.501 -183.706 -142.491 c 4.277 -3.229 6.071 -4.614 7.897 -5.955 c 25.75 -18.914 50.854 -38.794 77.438 -56.461 c 26.874 -17.856 55.128 -33.667 82.979 -50.027 c 6.407 -3.762 13.095 -5.468 20.841 -0.866 c 69.471 41.287 120.348 98.899 153.479 172.404 c 24.374 54.074 37.16 111.029 41.244 169.887 c 1.629 23.462 0.268 47.132 0.268 73.598 h -634.93 c 3.949 42.05 18.217 76.925 43.414 106.673 c 46.41 54.797 108.738 74.977 177.938 75.7 c 71.845 0.752 134.71 -24.91 188.667 -72.036 c 5.145 -4.493 8.567 -4.546 14.25 -1.841 c 34.715 16.538 69.626 32.661 104.44 48.985 c 17.451 8.182 34.843 16.492 53.145 25.168 c -2.443 4.271 -4.045 7.771 -6.255 10.828 C 811.904 830.677 746.93 880.572 664.103 904.3 c -82.871 23.741 -167.079 27.866 -252.055 10.31 c -79.833 -16.493 -150.209 -50.591 -208.198 -108.563 c -7.384 -7.38 -14.296 -15.231 -23.057 -24.61 Z m -87.811 -49.319 c 0.832 -5.614 1.122 -8.589 1.727 -11.499 c 6.153 -29.609 8.133 -60.923 19.324 -88.503 c 36.758 -90.594 92.643 -169.871 154.319 -245.198 c 12.181 -14.876 24.344 -29.765 36.515 -44.649 c -30.652 19.561 -59.525 41.063 -82.792 68.835 c -23.009 27.467 -46.263 54.884 -67.083 83.981 c -20.905 29.216 -38.939 60.483 -58.25 90.881 c -0.605 -3.36 -1.512 -7.741 -2.176 -12.159 c -8.65 -57.641 -6.415 -114.668 7.421 -171.488 c 42.968 -176.45 202.432 -305.4 384.596 -310.357 c 16.284 -0.443 32.948 0.791 48.762 -2.257 c 30.56 -5.889 60.611 -14.373 90.929 -21.559 c 8.872 -2.106 17.922 -3.454 29.365 -5.615 C 491.982 5.52907 277.054 47.6701 142.336 213.1 C 4.757 382.048 15.996 599.435 92.982 732.118 Z" fill="#ffffff"/></svg>`, 
    url: 'https://www.so.com/s?q=' 
  },
  { 
    name: '微博', 
    icon: `<svg viewBox="0 0 24 24" fill="currentColor"><path d="M10.098 20.323c-3.977.391-7.414-1.406-7.672-4.02-.259-2.609 2.759-5.047 6.74-5.441 3.979-.394 7.413 1.404 7.671 4.018.259 2.6-2.759 5.049-6.739 5.443zM9.05 17.219c-.384.616-1.208.884-1.829.602-.612-.279-.793-.991-.406-1.593.379-.595 1.176-.861 1.793-.601.622.263.82.972.442 1.592zm1.27-1.627c-.141.237-.449.353-.689.253-.236-.09-.313-.361-.177-.586.138-.227.436-.346.672-.24.239.09.315.36.194.573zm.176-2.719c-1.893-.493-4.033.45-4.857 2.118-.836 1.704-.026 3.591 1.886 4.21 1.983.64 4.318-.341 5.132-2.179.8-1.793-.201-3.642-2.161-4.149zm7.563-1.224c-.346-.105-.579-.18-.405-.649.381-1.017.42-1.894-.003-2.521-.801-1.169-2.986-1.108-5.52-.031 0 0-.791.345-.589-.281.39-1.209.332-2.219-.276-2.803-1.381-1.321-5.052.052-8.206 3.069C1.019 10.729 0 13.347 0 15.574c0 4.253 5.491 6.844 10.863 6.844 7.04 0 11.728-4.089 11.728-7.336 0-1.96-1.653-3.073-3.522-3.433zm2.663-5.443c-1.206-1.334-2.986-1.844-4.575-1.442l-.016.004c-.333.085-.537.416-.452.749.086.333.417.536.75.451 1.134-.291 2.381.083 3.233 1.026.852.943 1.066 2.239.617 3.356l-.007.016c-.124.32.039.679.359.803.32.124.679-.039.803-.359.639-1.585.334-3.423-.712-4.604z" fill="#ffffff"/></svg>`, 
    url: 'https://s.weibo.com/weibo?q=' 
  },
  { 
    name: 'BiliBili', 
    icon: `<svg viewBox="0 0 24 24" fill="currentColor"><path d="M17.813 4.653h.854c1.51.054 2.769.578 3.773 1.574 1.004.995 1.524 2.249 1.56 3.76v7.36c-.036 1.51-.556 2.769-1.56 3.773s-2.262 1.524-3.773 1.56H5.333c-1.51-.036-2.769-.556-3.773-1.56S.036 18.858 0 17.347v-7.36c.036-1.511.556-2.765 1.56-3.76 1.004-.996 2.262-1.52 3.773-1.574h.774l-1.174-1.12a1.234 1.234 0 0 1-.373-.906c0-.356.124-.658.373-.907l.027-.027c.267-.249.573-.373.92-.373.347 0 .653.124.92.373L9.653 4.44c.071.071.134.142.187.213h4.267a.836.836 0 0 1 .16-.213l2.853-2.747c.267-.249.573-.373.92-.373.347 0 .662.151.929.4.267.249.391.551.391.907 0 .355-.124.657-.373.906l-1.174 1.12zM5.333 7.24c-.746.018-1.373.276-1.88.773-.506.498-.769 1.13-.786 1.894v7.52c.017.764.28 1.395.786 1.893.507.498 1.134.756 1.88.773h13.334c.746-.017 1.373-.275 1.88-.773.506-.498.769-1.129.786-1.893v-7.52c-.017-.765-.28-1.396-.786-1.894-.507-.497-1.134-.755-1.88-.773H5.333zM8 11.107c.373 0 .684.124.933.373.25.249.383.569.4.96v1.173c-.017.391-.15.711-.4.96-.249.25-.56.374-.933.374s-.684-.125-.933-.374c-.25-.249-.383-.569-.4-.96V12.44c0-.373.129-.689.386-.947.258-.257.574-.386.947-.386zm8 0c.373 0 .684.124.933.373.25.249.383.569.4.96v1.173c-.017.391-.15.711-.4.96-.249.25-.56.374-.933.374s-.684-.125-.933-.374c-.25-.249-.383-.569-.4-.96V12.44c.017-.391.15-.711.4-.96.249-.249.56-.373.933-.373z" fill="#ffffff"/></svg>`, 
    url: 'https://search.bilibili.com/all?keyword=' 
  },
  { 
    name: 'Github', 
    icon: `<svg viewBox="0 0 24 24" fill="currentColor"><path d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z" fill="#ffffff"/></svg>`, 
    url: 'https://github.com/search?q=' 
  },
  { 
    name: '知乎', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor">
        <path d="M 512 12.8341 A 499.166 499.166 0 1 0 1011.17 512 A 499.166 499.166 0 0 0 512 12.8341 Z m -112.139 522.103 l -19.1147 76.0946 l 26.9426 -23.6658 s 61.349 69.723 72.8178 87.0172 s 1.6384 78.4612 1.6384 78.4612 l -105.222 -128.705 s -33.1321 115.052 -77.915 141.266 a 111.047 111.047 0 0 1 -91.0222 7.46382 a 389.211 389.211 0 0 0 97.2117 -102.127 a 435.632 435.632 0 0 0 44.965 -135.805 h -130.89 s 10.0124 -46.0572 27.4887 -47.3316 s 103.401 0 103.401 0 l -2.00249 -141.995 l -49.152 2.54862 a 109.227 109.227 0 0 1 -36.4089 54.6133 c -27.4887 19.8428 -43.6907 12.379 -43.6907 12.379 s 48.6059 -134.531 63.5335 -160.745 s 57.344 -28.581 57.344 -28.581 l -26.2144 75.9125 h 168.209 c 20.0249 0 21.1172 46.2393 21.1172 46.2393 h -103.037 v 139.446 s 69.723 -2.54862 92.2965 0 s 22.3915 47.3316 22.3915 47.3316 Z m 374.829 182.044 h -104.129 l -74.0921 52.6108 l -15.4738 -52.6108 h -42.0523 v -418.702 h 236.658 Z" fill="#ffffff"/>
        <path d="M615.40124445 716.43591111l62.44124444-47.14951111h48.96995556V344.33706667h-137.80764445v324.94933333h12.74311111l13.65333334 47.14951111z" fill="#ffffff"/>
        </svg>`, 
    url: 'https://www.zhihu.com/search?type=content&q=' 
  },
   { 
    name: 'button', 
    icon: `<svg viewBox="0 0 1024 1024" fill="currentColor" width="16" height="16">
        <path d="M 453.818 23.2727 C 704.465 23.2727 907.636 226.444 907.636 477.091 c 0 35.7469 -4.14255 70.9818 -12.2647 105.193 a 46.5455 46.5455 0 0 1 -90.5775 -21.504 c 6.46982 -27.1825 9.75127 -55.2029 9.75127 -83.6887 C 814.545 277.876 653.033 116.364 453.818 116.364 C 254.604 116.364 93.0909 277.876 93.0909 477.091 C 93.0909 676.305 254.604 837.818 453.818 837.818 c 101.004 0 195.212 -41.6582 262.982 -113.827 a 46.5455 46.5455 0 0 1 63.6509 -3.97964 c 2.97891 1.792 5.81818 3.95636 8.40145 6.44655 l 213.201 205.684 a 45.7076 45.7076 0 0 1 0.581818 65.2335 l -0.581818 0.581818 a 46.5455 46.5455 0 0 1 -65.2335 0.581818 l -185.391 -178.828 A 452.305 452.305 0 0 1 453.818 930.909 C 203.171 930.909 0 727.738 0 477.091 S 203.171 23.2727 453.818 23.2727 Z m 76.6138 179.828 c 86.7142 23.5985 147.2 76.0785 177.245 154.973 a 46.5455 46.5455 0 0 1 -86.9935 33.1404 c -19.1767 -50.3622 -55.9942 -82.3156 -114.688 -98.2807 a 46.5455 46.5455 0 1 1 24.4364 -89.8327 Z" fill="#ffffff"/>
        </svg>`
  }
]

// 获取【干支年 农历月日】
function getLunarDate(date) {
  const solar = Solar.fromDate(date)   // 公历转农历
  const lunar = solar.getLunar()      // 获取农历对象

  return lunar.getYearInGanZhi() + '年' + lunar.getMonthInChinese() + lunar.getDayInChinese()
}


const updateTime = () => {
  const now = new Date()
  let h = now.getHours()
  // 获取分钟数并确保长度为2
  const m = String(now.getMinutes()).padStart(2, '0')
  
  // 12小时制
  amPm.value = h >= 12 ? 'PM' : 'AM'
  h = h % 12
  h = h ? h : 12 // 0点显示为12
  hours.value = String(h).padStart(2, '0')
  minutes.value = m
  
  const year = now.getFullYear()
  const month = now.getMonth() + 1
  const day = now.getDate()
  currentDate.value = `${year}年${month}月${day}日`
  currentYear.value = String(year)
  currentMonth.value = String(month)
  currentDay.value = String(day)
  
  const weekDays = ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
  weekDay.value = weekDays[now.getDay()]
  
  // 简化的农历日期（实际项目中可使用农历库）
  lunarDate.value = getLunarDate(now)
}

let timer = null

const handleClickOutside = (event) => {
  if (searchContainer.value && !searchContainer.value.contains(event.target)) {
    showSearchPanel.value = false
  }
}

onMounted(() => {
  updateTime()
  timer = setInterval(updateTime, 1000)
  document.addEventListener('click', handleClickOutside)
})

onUnmounted(() => {
  clearInterval(timer)
  document.removeEventListener('click', handleClickOutside)
})

const toggleSearchPanel = () => {
  showSearchPanel.value = !showSearchPanel.value
}

const selectEngine = (engine) => {
  currentEngine.value = engine.name
  showSearchPanel.value = false
}

const doSearch = () => {
  if (!searchQuery.value.trim()) return
  const engine = searchEngines.find(e => e.name === currentEngine.value)
  if (engine) {
    window.open(engine.url + encodeURIComponent(searchQuery.value), '_blank')
  }
}
</script>

<style scoped>
.home-page {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
}

.home-page::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)),
              url('https://file.corrain.top/randomCover/Corrain11725337684049633.jpg') center/cover;
  z-index: -1;
  transition: filter 0.3s ease;
}

.home-page.search-active::before {
  filter: blur(8px);
}

.hero-section {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.time-display {
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
    cursor: pointer;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
    margin-top: 100px;
    transform: translateY(-150px);
    color: #fff;
    animation: fade-time-in .6s cubic-bezier(.21, .78, .36, 1);
    transition: transform .3s, opacity .5s, margin-bottom .3s;
}

.time {
    display: flex;
    align-items: flex-end;
    gap: 12px;
    margin: 6px 0;
    text-shadow: 0 0 8px #00000066;
    transition: transform .3s;
}

.time:hover {
  transform: scale(1.05);
}

.time-main {
  display: flex;
  align-items: baseline;
}

.time-num {
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  font-weight: 700;
  font-size: 6rem;
  letter-spacing: 2px;
  line-height: 1;
}

.separator {
  opacity: 0.9;
  font-size: 5rem;
  display: inline-block;
  margin: 0 4px;
  animation: separator-breathe 0.7s ease infinite alternate;
  line-height: 1;
}
    
.am-pm {
  font-size: 1.4rem;
  opacity: 0.7;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  font-weight: 500;
  margin-bottom: 12px;
}

@keyframes separator-breathe {
  0% {
    opacity: 0.3;
  }
  100% {
    opacity: 1;
  }
}



.date-info {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 6px;
  margin-top: 20px;
  font-size: 18px;
  opacity: 0.9;
  font-weight: 600;
  letter-spacing: 2px;
}

.lunar {
    font-size: 1rem;
    opacity: .7;
    text-shadow: 0 0 8px #00000066;
    letter-spacing: 3px;
}

.date {
    display: flex;
    align-items: baseline;
    gap: 2px;
    font-weight: 700;
    font-size: 1.3rem;
    opacity: .85;
    margin: 4px 0;
    text-shadow: 0 0 8px #00000066;
}

.date-num {
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  font-weight: 700;
  font-size: 1.5rem;
  letter-spacing: 1px;
}

.date-unit {
  font-size: 1.1rem;
  opacity: 0.8;
  margin-right: 2px;
}

.date-week {
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  font-weight: 700;
  font-size: 1.3rem;
  margin-left: 6px;
  opacity: 0.9;
}

.search-container {
    position: absolute;
    display: flex;
    flex-direction: row;
    align-items: center;
    max-width: 680px;
    width: calc(100% - 60px);
    transition: width .35s linear;
}

.search-box {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    height: 42px;
    width: 100%;
    border-radius: 30px;
    color: #fff;
    background-color: #00000040;
    backdrop-filter: blur(10px);
    opacity: 1;
    animation: fade-up-in .7s cubic-bezier(.37, .99, .36, 1);
    transition: transform .3s, background-color .3s, opacity .5s;
}

.search-icon {
  width: 24px;
  height: 24px;
  color: white;
  margin-right: 12px;
  margin-left: 12px;
  cursor: pointer;
  transition: transform 0.2s;
  display: flex;
  align-items: center;
  justify-content: center;
}
#main-input{
    height: 100%;
    width: 100%;
    padding: 0;
    margin: 0;
    border: none;
    outline: none;
    background: none;
    font-size: 16px;
    color: #fff;
}

.search-icon svg {
  width: 100%;
  height: 100%;
}

.search-icon:hover {
  transform: scale(1.5);
}

.search-box input {
    height: 100%;
    width: 100%;
    padding: 0;
    margin: 0;
    border: none;
    outline: none;
    background: none;
    font-size: 16px;
    color: #fff;
}

.search-box input::placeholder {
  color: rgba(255,255,255,0.6);
}

.go {
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    width: 64px;
    border-radius: 30px;
    transition: background-color .3s, opacity .3s;
}
.go:hover {
  background-color: rgba(255,255,255,0.1);
  opacity: 0.8;
}
.search-btn {
    display: inline-flex;
    align-items: center;
}

.search-panel {
  position: absolute;
  top: calc(100% + 10px);
  left: 0;
  right: 0;
  background: rgba(255,255,255,0.15);
  backdrop-filter: blur(20px);
  border-radius: 20px;
  padding: 20px;
  border: 1px solid rgba(255,255,255,0.2);
}

.search-engines {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 12px;
}

.engine-item {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 12px 16px;
  background: rgba(255,255,255,0.1);
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
  border: 2px solid transparent;
}

.engine-item:hover {
  background: rgba(255,255,255,0.2);
  transform: translateY(-2px);
}

.engine-item.active {
  background: rgba(255,255,255,0.25);
  border-color: rgba(255,255,255,0.5);
}

.engine-icon {
  width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.engine-icon svg {
  width: 100%;
  height: 100%;
}

.engine-name {
  color: white;
  font-size: 14px;
  font-weight: 500;
}

/* Transition animations */
.slide-fade-enter-active,
.slide-fade-leave-active {
  transition: all 0.3s ease;
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}

.quick-links {
  display: flex;
  gap: 30px;
  margin-top: 20px;
}

.link-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 8px;
  color: white;
  cursor: pointer;
  transition: transform 0.3s;
}

.link-item:hover {
  transform: translateY(-5px);
}

.link-icon {
  width: 50px;
  height: 50px;
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 24px;
}

.link-icon.blog {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.link-icon.more {
  background: rgba(255,255,255,0.2);
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 3px;
  padding: 12px;
}

.link-icon.more span {
  width: 8px;
  height: 8px;
  background: white;
  border-radius: 2px;
}

.footer {
  position: absolute;
  bottom: 20px;
  color: rgba(255,255,255,0.6);
  font-size: 12px;
}
</style>
