<<template id="c">
  
    <div id="comment0">
      <personal/>
      <div class="comment1">
        <label>昵称：
          <el-input placeholder="请输入内容" v-model="lists2.nickname" ></el-input>
        </label>
        <label>留言内容：
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="lists2.content"></el-input>
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
    list:[
    
    ],
    lists2:[{
             nickname:'',
             content:'',
             createOn:''
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
    add(){
    if((this.lists2.nickname===null||this.lists2.nickname===''||this.lists2.nickname===undefined)&&(this.lists2.content!==null||this.lists2.content!==''||this.lists2.content!==undefined))
    {
      alert("请填写昵称！");
    }else if((this.lists2.nickname!==null||this.lists2.nickname!==''||this.lists2.nickname!==undefined)&&(this.lists2.content===null||this.lists2.content===''||this.lists2.content===undefined))
    {
      alert("请填写留言！");
    }else if((this.lists2.nickname!==null||this.lists2.nickname!==''||this.lists2.nickname!==undefined)&&(this.lists2.content!==null||this.lists2.content!==''||this.lists2.content!==undefined))
    {
      this.lists.push(
         {
            nickname: this.lists2.nickname,
            content:this.lists2.content,
            createOn:Date.now()+1000,
                }
              )
      this.lists2.nickname = ''
      this.lists2.content = ''
      this.lists2.createOn = ''
      
    }
   },

   getlist(){
        this.axios({
                        url: '/api/comment',
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
