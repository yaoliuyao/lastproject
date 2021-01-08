<template>
    <div>
        <el-card shadow="never" :body-style="'0px'">
            <section class="bookinfo">
                <div class="cover">
                    <img :src="'/image'+bookinfo.cover">
                </div>
                <div class="book-header">
                    <div>
                        <h3>{{bookinfo.bookName}}</h3>
                        <p>
                            <span class="author">作者：{{bookinfo.author}}</span>
                            <span> 类型：{{bookinfo.name}}</span>
                            <span class="buy-count"> 已销售：{{bookinfo.buyCount}} 本</span>
                        </p>
                        <div class="body">

                            <span>￥{{showPrice(bookinfo.price)}}</span>
                            <p>
                                <el-button type="danger" round>立即购买</el-button>
                                <el-button type="warning" round>加入书架</el-button>
                            </p>
                            <div class="content">{{bookinfo.content}}</div>
                        </div>
                    </div>
                    <div class="right-nav">
                        <div>
                            <h5></h5>
                        </div>
                    </div>
                </div>
            </section>
        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                bookinfo: {},
            }
        },
        methods: {
            //加载对应 书籍编号的信息
            loadBookinfo(bid) {
                this.axios({
                    url: "/api/book/info",
                    params: {id: bid},
                }).then(resp => {
                    if (resp.data.code === 200) {
                        this.bookinfo = resp.data.data
                        console.log(resp)
                    } else {
                        console.log(resp)
                    }
                })
            },
            //显示书籍价格
            showPrice(price) {
                if (price != undefined) {
                    return price.toFixed(2)
                }
            }
        },
        created() {
            const bid = this.$route.query["bid"]
            this.loadBookinfo(bid)
        }
    }
</script>

<style scoped>

    .bookinfo {
        display: flex;
        align-items: center;
    }

    .bookinfo .cover {
        margin-left: 50px;
        margin-right: 20px;
    }

    .book-header {
        display: flex;
        justify-content: space-between;
    }

    .book-header p {
        font-size: 14px;
        color: #999999;
        border-bottom: 1px solid #eeeeee;
        padding-bottom: 10px;
    }

    .book-header p span {
        margin-right: 7px;
    }
    .body{
        margin-top: 50px;
    }
    .body > span {
        font-size: 24px;
        color: red;
    }

    .body > h3 {
        font-size: 14px;
        color: #999999;
    }

    .content {
        color: #999999;
        font-size: 14px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical
    }
</style>