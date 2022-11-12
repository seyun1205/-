<template>
    <div>
        <div class="b">
            <h1>SDS测试</h1>
        </div>
        <div>
            <ul v-for="(item,index) in list" :key="index">
                <li>{{ index+1 }}、{{ item }}</li>
                <li>
                    <input type="radio" name="choose" value="1">A.很少 
                    <input type="radio" name="choose" value="2">B.小部分时间 
                    <input type="radio" name="choose" value="3">C.相当多时间 
                    <input type="radio" name="choose" value="4">D.绝大部分时间 
                </li>
            </ul>

            <router-link to="/judge" type="primary" class="bnt">
                <el-button type="warning" plain>提交</el-button>
             </router-link>
        </div>
    </div>
    
</template>

<script>
export default ({
    data(){
        return {
            list:['平常感兴趣的事我仍然照样感兴趣。','我一阵阵哭出来或觉得想哭。']
        }
    }
})
</script>

<style scoped>
.b{
    background-color: burlywood;
    height:70px;
}
h1{
    margin-left: 15%;
    padding: 1%;
}
ul{
    list-style: none;
}
</style>
