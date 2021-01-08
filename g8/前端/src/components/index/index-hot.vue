<template>
	<!-- 热榜 -->
    <div id="body" style="padding-bottom: 50px;">
        <transition-group>
            <div class="HotItem clear" v-for="(item, index) in hots" :key="item.target.id">
                <div class="HotIndex" :class="{origin:index<3}">
                    <div>{{index + 1}}</div>
                    <div class="HotIndex-new" v-if="item.debut">新</div>
                </div>
                <div class="HotItem-content">
                    <a class="HotItem-content-text">
                        <h2>2</h2>
                        <p>3</p>
                    </a>
                    <div class="HotItem-content-btn">
                        <i class="el-icon-s-promotion">&nbsp;4</i>
                        <i class="el-icon-share">&nbsp;分享</i>
                    </div>
                </div>
                <a class="HotItem-content-img">
                    <img src="../../assets/logo.png">
                </a>
            </div>
        </transition-group>
        <div class="below-text">
            <span>没有更多内容了,,ԾㅂԾ,,</span>
        </div>
    </div>
</template>

<script>
export default {
    name: "index-hot",
    data () {
        return {
            hots: []
        }
    },
    methods: {
        loadHot () {
            this.$axios({
                methods: 'get',
                url: 'data/indexhot.json'
            })
            .then(res => {
                this.hots = res.data.data
            })
            .catch(err => {
                console.log(err);
            })
        }
    },
    created() {
        this.loadHot()
    },
    filters: {
        filter (val, str) {
            let pattern = 'questions';
            let res = val.replace(new RegExp(pattern), str);
            return res.replace('api', 'www')
        }
    }
}
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/index/index-hot";
@include animate();
</style>