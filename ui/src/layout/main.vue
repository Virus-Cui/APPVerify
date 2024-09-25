<script setup>
import {ref, reactive, onMounted} from "vue";
import {useRouter} from "vue-router";
import {DownOutlined} from "@ant-design/icons-vue";
import {logout} from "@/api/auth.js";
import {success} from "@/utils/message.js";

const router = useRouter();

const navigateTo = (path)=>{
  router.push({
    path: path
  })
}

const selectedKeys = ref([router.currentRoute.value.path])

const _router = [
  { path: '/home', label: '概览' },
  { path: '/user', label: '用户管理' },
  { path: '/app', label: '应用管理' },
  { path: '/setting', label: '系统设置' },
]

const get_label = (path)=>{
  for (let i = 0; i < _router.length; i++) {
    let ele = _router[i]
    if(ele.path == path){
      return ele.label
    }
  }
  return "无"
}
</script>

<template>
  <div class="layout">
    <context-holder />
    <a-layout class="layout">
      <div style="padding: 25px 50px 0 50px">
        <a-layout-header class="header" style="display: flex;justify-content: space-between;background: #FFF;border-radius: 8px;border: 1px solid #f0f0f0">
          <div style="display: flex">
            <img src="../assets/img/logo.png" width="100" style="margin-right: 1rem;">
            <a-menu
                v-model:selectedKeys="selectedKeys"
                theme="light"
                mode="horizontal"
                :style="{ lineHeight: '64px' }"
            >
              <a-menu-item key="/home" @click="navigateTo('/home')">概览</a-menu-item>
              <a-menu-item key="/user" @click="navigateTo('/user')">授权管理</a-menu-item>
              <a-menu-item key="/app" @click="navigateTo('/app')">应用管理</a-menu-item>
              <a-menu-item key="/setting" @click="navigateTo('/setting')">系统设置</a-menu-item>
            </a-menu>
          </div>
          <div style="color: #FFF">
            <a-dropdown>
              <a class="ant-dropdown-link" @click.prevent>
                Admin
                <DownOutlined />
              </a>
              <template #overlay>
                <a-menu>
                  <a-menu-item key="0" @click="logout">
                    退出登录
                  </a-menu-item>
                </a-menu>
              </template>
            </a-dropdown>
          </div>
        </a-layout-header>
      </div>

      <a-layout-content style="padding: 0 50px">
        <a-breadcrumb style="margin: 16px 0">
<!--          <a-breadcrumb-item>{{ get_label(selectedKeys[0]) }}</a-breadcrumb-item>-->
        </a-breadcrumb>
        <div :style="{ background: '#fff', padding: '24px', height: 'calc(100vh - 12rem)' }">
              <RouterView />
        </div>
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        Powered By Virus-Cui | <span class="link" @click="success('123123')">Github</span>
      </a-layout-footer>
    </a-layout>

  </div>
</template>

<style scoped lang="scss">

.site-layout-content {
  min-height: 280px;
  padding: 24px;
  background: red;
}
#components-layout-demo-top .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}
.ant-row-rtl #components-layout-demo-top .logo {
  float: right;
  margin: 16px 0 16px 24px;
}


.header{
  transition: all .2s;
  &:hover{
    transform: scale3d(1.03,1.05,1);
  }
}
</style>
