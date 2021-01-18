<template>
    <div class="bg recommend">
		<meta charset="utf-8">
        <transition-group>
			<!-- �����ش� -->
			<!-- 邀请回答 -->
            <div class="content" v-for="(item, index) in questions" @mouseenter="num = index" :key="item.id">
                <div class="close" v-show="num===index" @click="del(index)">
                    <el-tooltip class="item" effect="dark" content="不感兴趣 😐" placement="top">
                        <i class="el-icon-close"></i>
                    </el-tooltip>
                </div>
                <div class="look">
                    <img :src="item.head.avatar_url">
                    <span>{{item.content.title}}{{item.content.sub_title}}</span>
                </div>
                <div class="text">
                    <h2>
                        <!-- <a :href="item.content.target_link" target="_blank">{{item.content.text}}</a> -->
						<a >2</a>
					</h2>
                    <div class="recbtn">
                        <a class="write">
                            <i class="el-icon-edit"></i>
                            <span>写回答</span>
                        </a>
                        <div class="count">
                            <span>{{item.target_source.sub_text}}</span>
                        </div>
                    </div>
                </div>
            </div>
        </transition-group>

    </div>
</template>

<script>
export default {
    name: "invite",
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
                url: 'data/invite.json'
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
    }
}
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/answer/recommend";
@include animate();
</style>