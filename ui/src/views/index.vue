<script setup>
import {ref, reactive, onMounted} from "vue";

</script>

<template>
  <div style=" padding: 20px">
    <a-row :gutter="16">
      <a-col :span="8">
        <a-card title="应用数量" :bordered="true">
          <p style="font-size: 2rem">100</p>
        </a-card>
      </a-col>
      <a-col :span="8">
        <a-card title="在线数量" :bordered="true">
          <p style="font-size: 2rem">100</p>
        </a-card>
      </a-col>
      <a-col :span="8">
        <a-card title="在线用户" :bordered="true">
          <p style="font-size: 2rem">100</p>
        </a-card>
      </a-col>

    </a-row>
  </div>
</template>

<style scoped>

</style>
