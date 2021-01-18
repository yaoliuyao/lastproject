<template>
    <div id="body">
		<!-- 首页 -->
        <transition-group>
        <div class="list" v-for="list in lists" :key="list.id">
            <div>
                <h2>
                    <a target="_blank">1</a>
                </h2>
                <div class="content">
                    <div class="inner">
                        <span>2</span>
                        <button>阅读全文
                            <i class="el-icon-arrow-down"></i>
                        </button>
                    </div>
                    <div class="actions">
                        <span>
                            <button><i class="el-icon-caret-top"></i>赞同 {{list.voteup_count}}</button>
                            <button><i class="el-icon-caret-bottom"></i></button>
                        </span>
                        <span>
                            <i class="el-icon-s-comment">&nbsp;{{list.comment_count}} 条评论</i>
                        </span>
                        <span>
                            <i class="el-icon-s-promotion">&nbsp;分享</i>
                        </span>
                        <span>
                            <i class="el-icon-star-on">&nbsp;收藏</i>
                        </span>
                        <span>
                            <i class="el-icon-s-flag">&nbsp;喜欢</i>
                        </span>
                        <span>
                            <i class="el-icon-more"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        </transition-group>
    </div>
</template>

<script>
export default {
    name: "index-main",
    data () {
        return {
            lists: []
        }
    },
    methods: {
        load () {
            this.$axios({
                methods: 'get',
                url: 'data/indexmain.json'
            })
            .then(res => {
                this.lists = res.data.data
            })
            .catch(err => {
                console.log(err);
            })
        }
    },
    created() {
        this.load()
    }

}
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/index/index-main";
#body {
    padding-bottom: 50px;
}
@include animate();
</style>