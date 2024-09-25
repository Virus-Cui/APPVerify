<script setup>
import {ref, reactive, onMounted} from "vue";
import {DownOutlined, SmileOutlined} from "@ant-design/icons-vue";
import Fazil from "@/assets/logo/Fazil.vue";
import * as apis from "@/api/verifys.js";
import NewVerifyDialog from "@/views/user/dialogs/NewVerifyDialog.vue";
import dayjs from 'dayjs'
import ChangeVerifyDialog from "@/views/user/dialogs/ChangeVerifyDialog.vue";

const page_params = reactive({
  domain: '',
  total: 0,
  current_page: 1,
  page_size: 10
})

const newVerifyDialogRef = ref()
const changeVerifyDialogRef = ref()

const columns = [
  {
    title: '应用图标',
    dataIndex: 'appImage',
    key: 'appImage',
    width: 150
  },
  {
    title: '应用名称',
    dataIndex: 'appName',
    key: 'appName',
    width: 150
  },
  {
    title: '授权域名',
    dataIndex: 'domain',
    key: 'domain',
    width: 150
  },
  {
    title: 'HWID',
    dataIndex: 'hwid',
    key: 'hwid',
    width: 150
  },
  {
    title: '序列号',
    dataIndex: 'liscense',
    key: 'liscense',
    width: 150
  },
  {
    title: '过期时间',
    dataIndex: 'expireTime',
    key: 'expireTime',
    width: 150
  },
  {
    title: '操作',
    key: 'action',
    width: 150
  },
];
const data = ref()

onMounted(() => {
  init()
})

const init = ()=>{
  apis.load_all_verify(page_params).then(res => {
    data.value = res.data.data
    console.log(res)
  })
}

const rowSelection = ref({
  checkStrictly: true,
  onChange: (selectedRowKeys, selectedRows) => {
    console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
  },
  onSelect: (record, selected, selectedRows) => {
    console.log(record, selected, selectedRows);
  },
  onSelectAll: (selected, selectedRows, changeRows) => {
    console.log(selected, selectedRows, changeRows);
  },
});
</script>

<template>
  <a-space direction="vertical" size="large" style="width: 100%">
    <a-space wrap>
      <a-button type="primary" @click="newVerifyDialogRef.dialog.show()">添加授权</a-button>
      <a-button type="primary" danger>删除授权</a-button>
      <a-button type="primary" danger>停用授权</a-button>
    </a-space>
    <a-table :row-selection="rowSelection" :columns="columns" :data-source="data">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key == 'appImage'">
          <Fazil style="zoom: .5;"/>
        </template>
        <template v-if="column.key == 'expireTime'">
          {{ dayjs(record.expireTime).format("YYYY-MM-DD HH:mm:ss") }}
        </template>
        <template v-if="column.key == 'action'">
          <a-space>
            <a-button type="primary" size="small" @click="changeVerifyDialogRef.dialog.show(record)">编辑</a-button>
            <a-button type="primary" danger size="small">停用</a-button>
            <a-button type="primary" danger size="small" @click="apis.delete_verify(record.id).then(r=>init())">删除</a-button>
          </a-space>
        </template>
      </template>
      <template #headerCell="{ column }">
        <template v-if="column.key === 'action'">
        <span>
          <a-input-search
              placeholder="请输入绑定域名"
              style="width: 200px"
          />
        </span>
        </template>
      </template>
    </a-table>
  </a-space>

  <NewVerifyDialog ref="newVerifyDialogRef" @success="init()" />
  <ChangeVerifyDialog ref="changeVerifyDialogRef" @success="init()" />

</template>

<style scoped>

</style>
