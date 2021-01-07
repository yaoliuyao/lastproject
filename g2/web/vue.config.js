module.exports = {
    devServer: {
        port: 8082,
        proxy: {
            "/api": {
                target: "http://localhost:8084/",
                changeOrigin: true,
                pathRewrite:{
                    "/api":""
                }
            }
        }
    }
}