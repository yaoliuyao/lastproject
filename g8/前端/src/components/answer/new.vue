<template>
    <div class="bg recommend">
		<!-- 最新问题 -->
		<meta charset="utf-8">
        <transition-group>
            <div class="content" v-for="(item, index) in questions" @mouseenter="num = index" :key="item.question.id">
                <div class="close" v-show="num===index" @click="del(index)">
                    <el-tooltip class="item" effect="dark" content="不感兴趣 😐" placement="top">
                        <i class="el-icon-close"></i>
                    </el-tooltip>
                </div>
                <div class="text">
                    <h2>
                        <!-- <a :href="item.question.url | filter('question')" target="_blank">{{item.question.title}}</a> -->
						<a >1</a>
					</h2>
                    <div class="recbtn">
                        <a class="write">
                            <i class="el-icon-edit"></i>
                            <span>写回答</span>
                        </a>
                        <div class="count">
                            <span>{{item.question.answer_count}} 回答 · </span>
                            <span>{{item.question.follower_count}} 关注 · </span>
                            <span>{{item.question.visit_count}} 人看过</span>
                        </div>
                    </div>
                </div>
            </div>
        </transition-group>

    </div>
</template>

<script>
    export default {
        name: "new",
        data () {
            return {
                questions: [],
                num: ''
            }
        },
        methods: {
            load () {
                this.$axios({
                    methods: 'get',
                    url: 'data/new.json'
                })
                    .then(res => {
                        this.questions = res.data.data
                    })
                    .catch(err => {
                        console.log(err);
                    })
            },
            del (index) {
                this.questions.splice(index, 1)
            }
        },
        created() {
            this.load()
        },
        filters: {
            filter (val, str) {
                let pattern = 'api/v4/questions';
                return  val.replace(new RegExp(pattern), str);
            }
        }
    }
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/answer/recommend";
@include animate();
</style>