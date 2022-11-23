<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">
          心理健康管理系统
        </div>
        <div>
          <el-dropdown class="userInfo" @command="commandHandler">
            <span class="el-dropdown-link">
              <el-row class="demo-avatar demo-basic">
              <el-col :span="10">
                <div class="demo-basic--circle">
                  <div class="block">
                    <el-avatar shape="square" :size="50"> {{ userInfo.username }} </el-avatar>
                  </div>
                </div>
              </el-col>
          </el-row>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="userInfo">个人中心</el-dropdown-item>
                <el-dropdown-item command="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>
      <div style="display: flex;height: 900px">
        <div>
          <el-table :data="dataInfo"  id="roleWidth1">
            <el-table-column type="index" width="60" label="编号"
                             v-if="userInfo.identify == 1 || userInfo.identify == 3">
                            </el-table-column>
            <el-table-column align="center" prop="username" label="用户列表" width="80"/>
            <el-table-column width="100" label="擅长领域" prop="counselor.goodAt" :show-overflow-tooltip="true"
                             v-if="userInfo.identify == 1 || userInfo.identify == 3">
                            </el-table-column>
            <el-table-column width="100" label="简历"
                             v-if="userInfo.identify == 1 || userInfo.identify == 3">
              <template #default="scope">
                <span class="divHove" :title="scope.row.counselor != null ? scope.row.counselor.introduce : ''">
                  {{ scope.row.counselor != null ? scope.row.counselor.introduce : ''}}
                </span>
              </template>
            </el-table-column>
            <el-table-column align="right" width="120">
              <template #default="scope">
                <el-button @click="routePush(scope.row)" v-if="userInfo.identify == 1">
                  申请连线
                </el-button>
                <el-button @click="routePush(scope.row)" v-if="userInfo.identify == 2">
                  接受申请
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div style="border-left: #cccccc solid 1px">
          <router-view class="homeRouterView"/>
        </div>
      </div>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      userInfo: JSON.parse(window.sessionStorage.getItem('userInfo')),
      dataInfo: [],
    }
  },
  mounted() {
    this.dataInit()
    document.getElementById("roleWidth1").style.width = this.userInfo.identify == 2 ?"280px":"460px"
  },
  methods: {
    dataInit() {
      let identify = null;
      if (this.userInfo.identify == 1) {
        identify = 2;
      } else if (this.userInfo.identify == 2) {
        identify = 1;
      }
      let url = '/api/user/page?size=500&current=1';
      if (identify && identify != 3) {
        url += '&identify=' + identify;
      }
      this.getRequest(url).then((res) => {
        if (res) {
          window.sessionStorage.setItem("userInfoList", JSON.stringify(res.data.r.records))
          this.dataInfo = res.data.r.records.filter((v) => v.id != this.userInfo.id)
          console.log(this.dataInfo)
        }
      })
    },
    routePush(row) {
      console.log("hhh ")
      this.$router.push({path: '/chitchat', query: {id: row.id, username: row.username}})
    },
    commandHandler(common) {
      if (common == "logout") {
        this.$confirm('此操作将注销登录，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          window.sessionStorage.removeItem("userInfo");
          this.$router.replace("/");
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消操作'
          })
        })
      }
    }
  }
}
</script>

<style scoped>

.divHove {
  width: 100%;
  overflow:hidden;
  white-space: nowrap;
  text-overflow:ellipsis;
}

.homeHeader {
  height: 10%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 40px;
  box-sizing: border-box;
  border-bottom: solid #cccccc 1px;
}

.homeHeader .title {
  font-size: 28px;
  font-family: 宋体;
  color: #806868;
}

.homeHeader .userInfo {
  margin: 5px;
  cursor: pointer;
}
</style>