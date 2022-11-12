<template>
  <div class="main">
    <div class="main-item">
      <p>测前须知：</p>
      <p>SDS是（心理学）抑郁自评量表。广泛应用于门诊病人的粗筛、情绪状态评定以及调查、科研等，不能用于诊断。</p>
      <el-divider></el-divider>
      <p>本评定量表共有20个题目，分别列出了有些人可能会有的问题。
    在自评者评定之前，一定要把整个量表的填写方法及每个问题的涵义都弄明白，然后作出独立的、不受他人影响的自我评定。
    必须仔细阅读每一条目，然后根据最近一星期以内你的实际感受，选择一个与自身情况最相符合的答案。四个选项分别表示没有该项症状，小部分时间，相当多的时间有该症状，绝大部分时间或全部时间。
    不要有所顾忌，应该根据自己的真实体验和实际情况来回答，不要花费太多的时间去思考，应顺其自然，应根据第一印象作出判断。
   </p>
    <p>注意：测验中的每一个问题都要回答，不要遗漏，以避免影响测验结果的准确性。</p>
    </div>
    <el-button type="success" plain class="bnt" @click="totest2">开始测试</el-button>
    <!-- <router-link to="/test2" type="primary" class="bnt">
        <el-button type="success" plain>开始测试</el-button>
    </router-link> -->

  </div>
</template>

<script>
import index from '../index.vue'
export default {
  components: { index },
  name: "test",
  methods:{
    totest2(){
      this.$router.push('/test2')
    }
  }
}
</script>

<style scoped>
.main{
  background-color: rgb(158, 205, 189);
  width:600px;
  height:450px;
  margin-left: 32%;
  margin-top: 5%;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border-radius: 4px
}

.main-item{
  width:570px;
  margin-left: 15px;
  height:290px;
  padding-top: 10px;
}

.bnt{
  margin-left: 40%;
  margin-top: 88px;
}
</style>
