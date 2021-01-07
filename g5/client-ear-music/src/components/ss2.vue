<template>
  <section class="ss2">
    <div class="music-ss">
       <el-link :underline="false" @click="$router.push('/')" v-show="ok" style="font-size:18px;">返回首页</el-link>
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 90%;margin-left:40px;"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column label="排序" width="50">
          <template slot-scope="scope">{{ scope.row.date }}</template>
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="240">
        </el-table-column>
        <el-table-column prop="names" label="歌手" width="100">
        </el-table-column>
        <el-table-column prop="address" label="时长" width="50">
        </el-table-column>
      </el-table>
    </div>
  </section>
</template>
<script>
export default {
  props: ["tableData","ok"],
  data() {
    return {
      // tableData: [{
      //   date: '1',
      //   name: '歌曲标题',
      //   address: '4:20',
      //   names:'华晨宇',
      // }],
      multipleSelection: [],
    };
  },

  methods: {
 
  },
};
</script>
<style scoped>
</style>