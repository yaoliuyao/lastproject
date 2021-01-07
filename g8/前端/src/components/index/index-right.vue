<template>
    <transition appear>
        <div class="right">
            <div :class="{Fixed:bol}">
                <div class="right-top">
                    <div class="right-top-upper">
                        <div class="right-top-upper-nav">
                            <div class="one">
                                <i class="el-icon-document"></i>
                                <span>答问题</span>
                            </div>
                            <div class="two">
                                <i class="el-icon-video-camera"></i>
                                <span>发视频</span>
                            </div>
                            <div class="three">
                                <i class="el-icon-edit"></i>
                                <span>写文章</span>
                            </div>
                            <div class="four">
                                <i class="el-icon-magic-stick"></i>
                                <span>写想法</span>
                            </div>

                        </div>
                    </div>
                    <div class="right-top-below">
                        <div>
                            <span>稍后答</span>
                        </div>
                        <div>
                            <span>草稿箱</span>
                        </div>
                    </div>
                </div>
                <div class="right-part-two">
                    <div class="right-part-two-nav">
                        <div class="right-part-two-nav-right">
                            <i class="el-icon-user-solid"></i>
                            <span>创作中心</span>
                        </div>
                        <div>
                            <span>去开通</span>
                            <i class="el-icon-arrow-right"></i>
                        </div>
                    </div>
                </div>
                <div class="right-part-three">
                    <div class="right-part-three-nav">
                        <div>
                            <img src="../../assets/index-side/advertising.png">
                        </div>
                        <div class="right-part-three-ul">
                            <ul class="Ful">
                                <li>
                                    <i class="el-icon-s-promotion"></i>
                                    <div>Live</div>
                                </li>
                                <li>
                                    <i class="el-icon-s-management"></i>
                                    <div>书店</div>
                                </li>
                                <li>
                                    <i class="el-icon-cpu"></i>
                                    <div>圆桌</div>
                                </li>
                            </ul>
                            <ul class="Sul">
                                <li>
                                    <i class="el-icon-edit-outline"></i>
                                    <div>专栏</div>
                                </li>
                                <li>
                                    <i class="el-icon-money"></i>
                                    <div>付费</div>
                                </li>
                                <li>
                                    <i class="el-icon-copy-document"></i>
                                    <div>百科</div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="right-gg">
                    <img src="../../assets/index-side/gg2.png">
                </div>
                <div class="right-part-four">
                    <div class="right-part-four-nav">
                        <ul class="right-part-four-ul">
                            <li>
                                <i class="el-icon-star-on"></i>
                                <span>我的收藏</span>
                                <span class="right-part-four-ul-num">0</span>
                            </li>
                            <li>
                                <i class="el-icon-question"></i>
                                <span>我关注的问题</span>
                                <span class="right-part-four-ul-num">0</span>
                            </li>
                            <li>
                                <i class="el-icon-plus"></i>
                                <span>我的邀请</span>
                                <span class="right-part-four-ul-num">0</span>
                            </li>
                            <li>
                                <i class="el-icon-s-finance"></i>
                                <span>我的余额</span>
                            </li>
                            <li>
                                <i class="el-icon-s-operation"></i>
                                <span>站务中心</span>
                            </li>
                            <li>
                                <i class="el-icon-bangzhu"></i>
                                <span>帮助中心</span>
                            </li>
                            <li>
                                <i class="el-icon-key"></i>
                                <span>版权服务中心</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="right-gg">
                    <img src="../../assets/index-side/gg3.png">
                </div>
            </div>
        </div>
    </transition>
</template>

<script>
export default {
    name: "index-right",
    data () {
        return {
            bol: false
        }
    },
    methods: {
        handleScroll () {
            window.pageYOffset > 720 ? this.bol = true : this.bol = false
        }
    },
    mounted () {
        window.addEventListener('scroll', this.handleScroll)
    },
    destroyed () {
        window.removeEventListener('scroll', this.handleScroll)
    }
}
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/index/index-right";
@include animate(translateX(50px));
.Fixed {
    position: fixed;
    top: -650px;
}
</style>