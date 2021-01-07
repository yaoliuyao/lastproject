module.exports = {
    outputDir: "../back-end/web",
    publicPath: "/campus_wall",
    devServer: {
        port: 8080,
        proxy: {
            // CORS 问题
            // axios(http://localhost:9999/myblog/comment/list)
            // axios(/api/comment/list)
            "/api": {
                target: "http://localhost",
                pathRewrite: {
                    "/api": "/campus_wall"
                },
                changeOrigin: true
            }
        }
    }
}