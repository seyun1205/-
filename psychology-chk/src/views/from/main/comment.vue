<<template id="c">
  
    <div id="comment0">
      <personal/>
      <div class="comment1">
        <label>昵称：
          <el-input placeholder="请输入内容" v-model="list2.nickname" ></el-input>
        </label>
        <label>留言内容：
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="list2.content"></el-input>
        </label>

        <div class="form-group">
          <el-button round value="返回" class="btn-primary2" type="primary" @click="toindex">返回</el-button>
          <el-button round value="发表留言" class="btn-primary" type="primary" @click="add">发表留言</el-button>
        </div>
      </div>
      <br/>
      <div class="comment2">
        <el-table :data="list" style="width: 100%; "> 
          <el-table-column prop="nickname" label="" width="180"></el-table-column>
          <el-table-column prop="content" label=""></el-table-column>
          <el-table-column prop="ctime" label="" width="180">
            <template slot-scope="scope">
              {{scope.row.ctime|dataFormat}}
            </template> 
          </el-table-column>
      </el-table>
    </div>
   </div>
</template>

<script>
import personal from '@/components/personal.vue'
export default {
  components: { personal },
  name: "comment",
  data(){
   return{
    username: localStorage.getItem('username') ?? '',
    list:[
    
    ],
    list2:[{
             username:'',
             nickname:'',
             content:'',
             ctime:''
                }
                ]
    }
  },
  filters:{
    dataFormat(input,pattern=""){
    var dt=new Date(input)
    //  console.log(dt)
    var y=dt.getFullYear()
    var m=(dt.getMonth()+1).toString().padStart(2,'0')
    var d=dt.getDate().toString().padStart(2,'0')
    if(pattern.toLocaleLowerCase()==='yyyy-mm-dd'){
      return `${y}-${m}-${d}`
    }else{
      var hh=dt.getHours().toString().padStart(2,'0')
      var mm=dt.getMinutes().toString().padStart(2,'0')
      var ss=dt.getSeconds().toString().padStart(2,'0')
      return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
    }
    }
  },
  methods: {
    toindex(){
      this.$router.push('/index')
    },

    async add(){
    if((this.list2.nickname===null||this.list2.nickname===''||this.list2.nickname===undefined)&&(this.list2.content!==null||this.list2.content!==''||this.list2.content!==undefined))
    {
      alert("请填写昵称！");
    }else if((this.list2.nickname!==null||this.list2.nickname!==''||this.list2.nickname!==undefined)&&(this.list2.content===null||this.list2.content===''||this.list2.content===undefined))
    {
      alert("请填写留言！");
    }else if((this.list2.nickname!==null||this.list2.nickname!==''||this.list2.nickname!==undefined)&&(this.list2.content!==null||this.list2.content!==''||this.list2.content!==undefined))
    {
      this.list2.username = this.username;
      this.list2.ctime = Date.now()+1000;
      
      // console.log(this.list2)
      //把list2传给后端
      const { username, nickname, content, ctime} = this.list2
            const res = await this.axios({
                url: '/api/comment/add',
                method: 'POST',
                params: {
                    username,
                    nickname,
                    content,
                    ctime
                }
            })
       if(res.data.msg === '发表成功！') {
          this.$message.success('发表成功');
          this.list.push({
            username:this.username,
            nickname:this.list2.nickname,
            content:this.list2.content,
            ctime:this.list2.ctime
          })
          this.list2.nickname = ''
          this.list2.content = ''
       }
     
    }
   },

   getlist(){
      this.axios({
                  url: '/api/comment/selectAll',
                        method: 'get',
                    }).then(res =>{
                      this.list = res.data
                })
   }

  },
  mounted(){
    this.getlist()
  }
}
</script>

<style scoped>

.comment1{
  position: relative;
  margin-left: 20px;
  margin-right: 20px;
  margin: 0 auto;
  padding: 20px;
  width: 60%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
 
}

.form-group{
  line-height: 50px;
}
.btn-primary2{
  margin-left: 3px;
}
.btn-primary{
  /* background-color: #C0C4CC; */
  margin-right: 10px;
  float: right;
  margin-top:7px;
}
.comment2{
  position: relative;
  margin-left: 20px;
  margin-right: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
  
}
.el0{
  background-color: #409EFF;
}
</style>
