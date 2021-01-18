// vue.config.js
module.exports = {
    publicPath: '/bookshop', // 基本路径
    outputDir: '../bookshop-server/web', // 输出文件目录
    // 选项...
    devServer: {
        open: true,
        host: 'localhost',
        port: 9999,
        https: false,
        //以上的ip和端口是我们本机的;下面为需要跨域的
        proxy: {  //配置跨域
            '/api': {		// /api 拦截以 /api 开始的请求
                target: 'http://localhost:8080/bookshop/api',  //这里后台的地址模拟的;应该填写你们真实的后台接口
                ws: true,
                changOrigin: true,  //允许跨域
                pathRewrite: { //地址改写
                    '^/api': ''  //请求的时候使用这个api就可以
                }
            },
            '/image': {
                target: 'http://localhost:8080/bookshop',  //这里后台的地址模拟的;应该填写你们真实的后台接口
                ws: true,
                changOrigin: true,  //允许跨域
                pathRewrite: { //地址改写
                    '^/image': ''  //请求的时候使用这个api就可以
                }
            }
        }
    }
}