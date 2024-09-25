<script setup>
import {ref, reactive, onMounted} from "vue";
import Sakura from "@/assets/logo/Sakura.vue";
import {login} from "@/api/auth.js";

const formState = reactive({
  username: '',
  password: '',
  remember: true,
});
const onFinish = values => {
  console.log('Success:', values);
  login(values)
};
const onFinishFailed = errorInfo => {
  console.log('Failed:', errorInfo);
};
</script>

<template>
  <div class="login-box">
    <div class="login-container">
      <div class="title">Flack Login</div>
      <div class="form">
        <a-form
            :model="formState"
            name="basic"
            autocomplete="off"
            @finish="onFinish"
            @finishFailed="onFinishFailed"
        >
          <a-form-item
              name="username"
              :rules="[{ required: true, message: '请输入用户名!' }]"
          >
            <a-input placeholder="请输入用户名" class="w100" v-model:value="formState.username"/>
          </a-form-item>

          <a-form-item
              name="password"
              :rules="[{ required: true, message: '请输入密码!' }]"
          >
            <a-input-password placeholder="请输入密码" v-model:value="formState.password"/>
          </a-form-item>

          <a-form-item name="remember" :wrapper-col="{ span: 16 }">
            <a-checkbox v-model:checked="formState.remember">记住我</a-checkbox>
          </a-form-item>
          <a-button class="w100" type="primary" html-type="submit">登录</a-button>
        </a-form>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.login-box {
  width: 100vw;
  height: 100vh;
  background: #f5f5f5;
  display: flex;
  justify-content: center;
  align-items: center;

  .login-container {
    width: 20rem;
    background: #FFF;
    border-radius: 8px;
    box-shadow: 2px 2px 10px rgba(0 0 0 / .2);
    padding: 1rem;

    .title {
      text-align: center;
      font-family: Alimama;
      font-size: 1.4rem;
    }

    .form {
      width: 100%;
      margin-top: 1rem;
    }
  }
}

.w100 {
  width: 100%;
}

.sakura{
  zoom: .2;
  position: relative;

}
</style>
