<template>
  <ul>
    <li v-for="item in 5" :key="item">
        <span>
            <h3>“三明治效应”</h3>
            <span class="desc">在批评心理学中，人们把批评的内容夹在两个表扬之中从而使受批评者愉快地接受批评的现象，称之为三明治效应。这种现象就如三明治，第一层总是认同、赏识、肯定、关爱对方的优点或积极面，中间这一层夹着建议、批评或不同观点，第三层总是鼓励、希望、信任、支持和帮助，使之后味无穷。比如：今天的汤真好喝，就是稍微咸了一点，下次清淡点我能连喝三大碗。</span>
        </span>
    </li>
  </ul>
</template>

<script>
export default {

}
</script>

<style scoped>
li {
    list-style: none;
    display: flex;
    background-color: #fff;
}
/* .no {
    border: 1px solid #ccc;
    background-color: #fff;
    color: #000;
    width: 40px;
    height: 40px;
    border-radius: 5px;
    overflow: hidden;
} */
h3 {
    text-align: left;
}
.desc {
    display: -webkit-box;   /*必须结合的属性,将对象作为弹性伸缩盒子模型显示*/
    -webkit-line-clamp: 1;  /*设置多少行*/
    -webkit-box-orient: vertical;   /*必须结合的属性,设置或检索伸缩盒对象的子元素的排列方式*/
    overflow: hidden;   /*文本会被修剪，并且剩余的部分不可见*/
    text-overflow: ellipsis; 
}
</style>