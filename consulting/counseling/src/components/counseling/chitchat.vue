<template>
<!--咨询师 1630-->
  <div id="roleWidth2">
    <div style="height: 40px;text-align: center;padding-top: 5px">{{ this.$route.query.username }}</div>
    <div>
      <div id="content" style="height: 650px;overflow-y:auto"></div>
      <div style="border-top: #cccccc solid 1px;">
        <el-input @keydown.enter.native="send" v-model="message.msg" :rows="10" type="textarea" />
        <el-button style="position: absolute;left: 1830px;top: 950px" type="primary" @click="send">发送</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "chitchat",
  data(){
    return{
      userInfo: JSON.parse(window.sessionStorage.getItem('userInfo')),
      path:"ws://localhost:8088/websocket/"+JSON.parse(window.sessionStorage.getItem('userInfo')).id,
      socket:"",
      message:{
        sendId: null,
        receiverId: null,
        sendDate: new Date(),
        message:"发送的消息",
        autoMsg: null
      },
    }
  },
  mounted () {
    this.webSocketInit()
    document.getElementById("roleWidth2").style.width = this.userInfo.role == 2 ?"1620px":"1440px"
  },
  methods: {
    webSocketInit: function () {
      if(typeof(WebSocket) === "undefined"){
        alert("您的浏览器不支持socket")
      }else{
        this.socket = new WebSocket(this.path)
        this.socket.onopen = this.open
        this.socket.onerror = this.error
        this.socket.onmessage = this.getMessage
      }
    },
    open: function () {
      console.log("socket连接成功")
    },
    error: function () {
      console.log("连接错误")
    },
    getMessage: function (msg) {
      let newDiv = "";
      if (JSON.parse(msg.data).receiverId == this.userInfo.id) {
        newDiv = "<div class='newDiv' style='text-align: left;height: 60px;line-height: 60px; padding-left: 30px;box-sizing: border-box'>" +
            "<span style='height: 40px;width: 40px;line-height: 40px;border-radius: 5px;display: inline-block;background-color: #9d9696;text-align: center;color:#ffffff;margin-right: 15px'>"+this.$route.query.username+"</span>" +
            "<span style='border-radius: 3px; padding: 3px 15px; '>"+JSON.parse(msg.data).message+"</span></div>";
      }
      if (JSON.parse(msg.data).autoMsg) {
        console.log(JSON.parse(msg.data).autoMsg)
        newDiv = "<div class='newDiv' style='text-align: left;height: 60px;line-height: 60px; padding-left: 30px;box-sizing: border-box'>" +
            "<span style='height: 40px;width: 40px;line-height: 40px;border-radius: 5px;display: inline-block;background-color: #9d9696;text-align: center;color:#ffffff;margin-right: 15px'>"+this.$route.query.username+"</span>" +
            "<span style='border-radius: 3px; padding: 3px 15px; '>"+JSON.parse(msg.data).autoMsg+"</span></div>";
      }
      let html = document.getElementById("content").innerHTML;
      document.getElementById("content").innerHTML = html + newDiv;
    },
    send: function () {
      console.log(this.message.msg)
      console.log(this.userInfo.id)
      this.socket.send(JSON.stringify({
        "sendId": this.userInfo.id,
        "receiverId": this.$route.query.id,
        "sendDate": new Date(),
        "message": this.message.msg,
        "autoMsg": ""
      }))
      let newDiv = "<div class='newDiv' style='text-align: right;height: 60px;line-height: 60px; padding-right: 30px;box-sizing: border-box'>" +
          "<span style='border-radius: 3px; padding: 3px 15px;'>"+this.message.msg+"</span>" +
          "<span style='height: 40px;width: 40px;line-height: 40px;border-radius: 5px;display: inline-block;background-color: #9d9696;text-align: center;color:#ffffff;margin-left: 15px'>"+this.userInfo.username+"</span></div>";
      let html = document.getElementById("content").innerHTML;
      document.getElementById("content").innerHTML = html + newDiv;
      this.message.msg = ""
    },
    close: function () {
      console.log("socket已经关闭")
    }
  },
  destroyed () {
    this.socket.onclose = this.close
  },
  watch: {
    $route(to, from) {
      if (this.$route.query.id) {
        location.reload(true)
        console.info( "加载页面数据" );
      }
    }
  },
}
</script>

<style scoped>
  /deep/ .el-textarea__inner {
    outline: none;
    border: none;
    box-shadow: none;
  }

  .newDiv{
    height: 40px;
    line-height: 40px;
    border: #7c7cec solid 1px;
    padding: 0px 30px;
  }
  .newDiv span {
    border-radius: 3px;
    padding: 3px 15px;
    border: #9d9696 solid 1px;
  }
</style>