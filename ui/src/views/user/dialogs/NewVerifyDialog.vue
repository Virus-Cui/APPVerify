<script setup>
import {ref, reactive, onMounted} from "vue";
import {new_verify} from "@/api/verifys.js";

const emits = defineEmits(['success'])

const dialog = reactive({
  title: '创建验证项',
  open: false,
  data: {},
  show: (data) => {
    Object.assign(dialog.data, data)
    dialog.open = true
  },
  close: () => {
    Object.assign(dialog.data, {})
    dialog.open = false
  },
  rules: {},
  submit: () => {
    new_verify(dialog.data).then(res => {
      emits('success')
      dialog.close()
    })
  }
})

defineExpose({
  dialog
})
</script>

<template>
  <a-modal v-model:open="dialog.open" :title="dialog.title" @ok="dialog.submit()" ok-text="提交" cancel-text="取消">
    <a-space direction="vertical" style="width: 100%">
      <a-form
          :label-col="{ span: 4 }"
          label-align="right" style="margin-top: 1rem;">
        <a-form-item label="应用名称">
          <a-input v-model:value="dialog.data.appName" placeholder="应用名称"></a-input>
        </a-form-item>
        <a-form-item label="域名">
          <a-input v-model:value="dialog.data.domain" placeholder="域名"></a-input>
        </a-form-item>
        <a-form-item label="到期时间">
          <a-date-picker placeholder="请选择到期时间" style="width: 100%" v-model:value="dialog.data.expireTime"/>
        </a-form-item>
      </a-form>
    </a-space>
  </a-modal>
</template>

<style scoped>

</style>
