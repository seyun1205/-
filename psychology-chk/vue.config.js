// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })

module.exports = {
    devServer: {
        port: 3000,//它是用来修改你打开后的端口号的
        proxy:{
            '/api':{
                target:'http://localhost:8080/',//跨域请求的公共地址
                changeOrigin:true, //是否开启跨域，值为 true 就是开启， false 不开启
                pathRewrite:{
                    '^/api':''//注册全局路径， 但是在你请求的时候前面需要加上 /api  
                }
            }
        }
    }
}
