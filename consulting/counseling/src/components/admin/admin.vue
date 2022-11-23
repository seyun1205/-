<template>
  <div style="width: 840px;">
    <div style="height: 100px;line-height: 100px;padding-left: 50px">
      <el-select v-model="search.student"
                 style="margin: 0px 4px;width: 130px"
                 placeholder="大学生">
        <div v-for="item in userinfoList" :key="item">
          <el-option v-if="item.role == 1"
                    :key="item.id"
                    :label="item.username"
                    :value="item.id">
          </el-option>
        </div>
      </el-select>
      <el-select v-model="search.counselor"
                 style="margin: 0px 4px;width: 130px"
                 placeholder="咨询师">
        <div v-for="item in userinfoList" :key="item">
          <el-option v-if="item.role == 2"
                     :key="item.id"
                     :label="item.username"
                     :value="item.id">
          </el-option>
        </div>
      </el-select>
      <el-button style="margin: 0px 4px;padding: 0px 20px" type="primary" @click="getCounselorRecordsList">搜索</el-button>
      <el-button style="margin: 0px 4px;padding: 0px 20px" type="success" @click="dataInit">所有</el-button>
    </div>

    <el-table
        :data="dataInfo"
        style="width: 100%;height: 740px">
      <el-table-column
          prop="fromUser.username"
          label="发送者"
          width="180">
      </el-table-column>
      <el-table-column
          prop="toUser.username"
          label="接收者"
          width="180">
      </el-table-column>
      <el-table-column
          prop="message"
          label="消息">
      </el-table-column>
      <el-table-column
          prop="createTime"
          label="发送时间"
          width="200">
      </el-table-column>
    </el-table>
    <div style="display: flex;margin-top: 40px">
      <el-pagination
          v-show="all"
          :page-size="size"
          @current-change="currentChange"
          @size-change="sizeChange"
          layout="prev, pager, next" :total="total"></el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "admin",
  data() {
    return {
      dataInfo: [],
      userinfoList: JSON.parse(window.sessionStorage.getItem("userInfoList")),
      total: 0,
      currentPage: 1,
      size: 17,
      search: {
        student: null,
        counselor: null
      },
      all: true
    }
  },
  mounted() {
    this.dataInit();
  },
  methods: {
    dataInit() {
      let url = '/api/counselorRecords/page?current='+ this.currentPage+'&size='+ this.size;
      this.getRequest(url).then((res) => {
        if (res) {
          this.all = true
          this.total = res.data.r.total;
          this.dataInfo = res.data.r.records;
        }
      })
    },
    getCounselorRecordsList(){
      if (this.search.student && this.search.counselor) {
        console.log(this.search.counselor)
        let url = '/api/counselorRecords/getCounselorRecordsList/'+this.search.student+'/'+this.search.counselor;
        this.getRequest(url).then((res) => {
          if (res) {
            this.all = false
            this.dataInfo = res.data.r;
            console.log(res.data.r)
          }
          console.log(this.total+"嘿嘿嘿")
        })
      }

    },
    sizeChange(currentSize) {
      this.size = currentSize;
      this.dataInit();
    },
    currentChange(currentPage) {
      this.currentPage = currentPage;
      this.dataInit();
    },
  }
}
</script>

<style scoped>

</style>