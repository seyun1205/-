<template>
    <div class="body">
        <div class="b">
            <h1>SDS测试</h1>
        </div>
        <div class="center">

            <div v-for="(item,index) in list2" :key="index" class="item-item">
                <div>{{ index+1 }}.{{ item.question }}</div>
                <div>
                    <li v-for="(son,index1) in list_a" :key="index1" class="son-item"> 
                        <input type="radio" :name="item.name" :value="son.value" @change="get_radio_value(index)" 
                            v-model="checkedValue[index]">
                         <span>{{son.value}}</span>
                    </li><br>
                </div> 
            </div>

        </div>
         <div class="but"> 
                <el-button type="warning" plain @click="tojudge">提交</el-button>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <router-link to="/index" type="primary" >
                    <el-button type="warning" plain>返回</el-button>
                </router-link>
            </div>   
    </div>
    
</template>

<script>
export default ({
    name:"test",
    data(){
        return {
            list:[],
            list2:[],
            checkedValue:[],
            score:[],
            list_a: [
                {'value': 'A.很少'}, {'value': 'B.小部分时间'}, {'value': 'C.相当多时间'}, {'value': 'D.绝大部分时间'}
                ]
        }
    },
    methods:{
        tojudge(){
            for(var i=0;i<this.list.length;i++)
                if(this.list[i] === '' || typeof(this.list[i]) === 'undefined')
                    this.list.splice(i,1)
            if(this.list.length !== this.list2.length){
                alert('答案没有选择完毕')
                //console.log(this.list.length)
            }
            else {
                    var sum = 0.0;
                    for(var i=0;i<this.score.length;i++)
                        sum+=this.score[i];
                    sum = sum/80.0
                    //console.log(sum)
                    this.$router.push({
                        name: 'judge',
                        params:  {
                            sum
                        }
                    })
                }
            
        },
        get_radio_value(index){
            console.log((index+1)+'题'+this.checkedValue[index])
            this.list[index] = this.checkedValue[index]
           
            if(this.checkedValue[index]===("A.很少"))
                this.score[index] = 1
                else if(this.checkedValue[index]===("B.小部分时间"))
                    this.score[index] = 2
                    else if(this.checkedValue[index]===("C.相当多时间"))
                        this.score[index] = 3
                            else this.score[index] = 4
            
            console.log(this.score[index])
        },

        getlist(){
            this.axios({
                        url: '/api/test2',
                        method: 'get',
                    }).then(res =>{
                        this.list2 = res.data
                    })
           
        }
    },

    created(){
       this.getlist()
    }
})
</script>

<style scoped>
.body{
    background-color: antiquewhite;
}
.b{
    background-color: burlywood;
    height:70px;
}
h1{
    margin-left: 20%;
    padding: 1%;
}
ul{ 
    list-style: none;
}
.center{
    margin-left: 40%;
    margin-top: 3%;
}
.but{
    margin-left: 38%;
    /* margin-top: 5%; */
}

li{
    list-style: none;
}
.son-item{
    margin-top: 8px;
}
.item-item{
    margin-top: 20px;
}
</style>
