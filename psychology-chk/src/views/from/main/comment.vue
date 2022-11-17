<template id="c">
  <div id="comment1">
    <message-board @func="loadMessages"></message-board>
   <ul class="list-group">
    <li class="list-group-item" v-for="item in list" :key="item.createOn">
      <span class="badge">   
        留言人昵称：
        {{item.username}}
      </span>
      {{item.content}}
      留言时间：
      {{item.creatOn|dataFormat}}
    </li>
  </ul>
  </div>
</template>

<script>
var messageBoard={
    data(){
      return{
        username:'',
        content:'',
        createOn:'',
      }
    },
    template:`
     <div class="panel panel-primary">
       <div class="panel-body from-inline">
        <div class="form-group">
          // <input type="text" class="c_n" placeholder="请写下你的昵称"/>
          <label for="">留言内容：</label>
          <textarea class="form-control" v-model="content"></textarea>
           </div>
           <div class="form-group">
            <input type="button" value="发表留言" class="btn btn-primary" @click="postMessage">
            </div>
        </div>
      </div>
    `,
    props:['username','content','createOn'],
    methods: {
      postMessage(){
        var comment={ createOn:Date.now(),username:this.username,content:this.content}
        var list=JSON.parse(localStorage.getItem('message')||'[]')
        list.unshift(comment)
        localStorage.setItem('message',JSON.stringify(list))
        this.username=this.content=''
        this.$emit('func')
      }
    },
 }
export default {
  name: "comment",
  components:{
  'message-board':messageBoard,
 },
  data:{
    list:[
     {
      createOn:Date.now()+1000,username:'小小',content:'测试下来挺不错！',
     }
    ],
  },
  created(){
    this.loadMessages()
  },
  methods: {
    loadMessages(){
      var list=JSON.parse(localStorage.getItem('message')||'[]')
      if(list&&list.length>0){
        this.list=list
      }
    }
  },
}
</script>

<style scoped>
body{
margin: 0;
}
</style>
