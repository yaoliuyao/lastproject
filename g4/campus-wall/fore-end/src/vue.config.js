module.exports = {
    outputDir: "../server/web",
    publicPath: "/myblog",
    devServer: {
        port: 8080,
        proxy: {
            // CORS 问题
            // axios(http://localhost:9999/myblog/comment/list)
            // axios(/api/comment/list)
            "/api": {
                target: "http://localhost",
                pathRewrite: {
                    "/api": "/myblog"
                },
                changeOrigin: true
            }
        }
    }
}