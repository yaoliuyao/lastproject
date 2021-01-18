<template>
    <div class="bg recommend">
        <transition-group>
		为你推荐
		<meta charset="utf-8">
        <div class="content" v-for="(item, index) in questions" @mouseenter="num = index" :key="item.question.id">
            <div class="close" v-show="num===index" @click="del(index)">
                <el-tooltip class="item" effect="dark" content="不感兴趣 😐" placement="top">
                    <i class="el-icon-close"></i>
                </el-tooltip>
            </div>
            <div class="look">
                <img :src="item.icons[0].url">
                <span>{{item.reason}}</span>
            </div>
            <div class="text">
                <h2>
                   <!-- <a :href="item.question.url | filter('question')" target="_blank">{{item.question.title}}</a> -->
					<a >2</a>
				</h2>
                <div class="recbtn">
                    <a class="write">
                        <i class="el-icon-edit"></i>
                        <span>写回答</span>
                    </a>
                    <div class="count">
                        <span>{{item.question.answer_count}} 回答 · </span>
                        <span>{{item.question.follower_count}} 关注</span>
                    </div>
                </div>
            </div>
        </div>
        </transition-group>

    </div>
</template>

<script>
export default {
    name: "recommend",
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
                url: 'data/recommend.json'
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