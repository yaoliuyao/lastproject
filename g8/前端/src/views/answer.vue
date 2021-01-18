<template>
    <div>
        <div class="main">
            <div class="Fixed">
                <div class="fix"></div>
                <nav class="nav">
                    <a v-for="(item, index) in navs" class="nav-btn"
                       @click="changeRouter(index, item.path)"
                       :class="{nav_active:index===count}"
                    >
                        <i :class="item.class"></i>
                        <span>{{item.span}}</span>
                    </a>
            </nav>
            </div>
            <router-view/>
<!--            <Recommend v-if="count===0"></Recommend>-->
<!--            <Hot v-if="count===1"></Hot>-->
<!--            <New v-if="count===2"></New>-->
<!--            <Invite v-if="count===3"></Invite>-->
        </div>
		<!-- 引入右侧导航条 -->
        <IndexRight></IndexRight>
    </div>
</template>

<script>
import IndexRight from '@/components/index/index-right.vue';
export default {
    name: "answer",
    data () {
        return {
            navs: [
                {path: '/recommend', class: 'el-icon-star-on', span: '为你推荐'},
                {path: '/hot', class: 'el-icon-s-data', span: '人气问题'},
                {path: '/new', class: 'el-icon-question', span: '最新问题'},
                {path: '/invite', class: 'el-icon-warning', span: '邀请回答'}
            ],
            count: 0
        }
    },
    components: {
        IndexRight
    },
    methods: {
        changeRouter (index, path) {
            this.count = index;
            this.$router.push('/answer' + path);
        }
    }
}
</script>

<style lang="scss" scoped>
@import "../style/common";
@import "../style/answer/answer-nav";
</style>