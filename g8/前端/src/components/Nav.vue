<template>
    <header>
		<!-- 导航条 -->
        <div class="container clear">
            <div class="fixed">
                <div class="pic">
                    <a href="/">
                        <img src="@/assets/logo.png" alt="logo">
                    </a>
                </div>
                <el-menu :default-active="'/' + this.$route.path.split('/')[1]" router class="el-menu-demo" mode="horizontal">
                    <el-menu-item index="/index">首页</el-menu-item>
                    <el-menu-item index="/found">发现</el-menu-item>
                    <el-menu-item index="/answer">等你来答</el-menu-item>
                </el-menu>

                <el-autocomplete
                        popper-class="my-autocomplete"
                        v-model="state"
                        :fetch-suggestions="querySearch"
                        placeholder="《沉默的真相》大结局"
                        :class="{active:bol}"
                        @focus="bol = true"
                        @blur="bol = false">
                    <i class="el-icon-search el-input__icon" slot="suffix" :class="{change:bol}"></i>
                    <template slot-scope="{item}">
						<!-- 搜索栏 -->
                        <div class="name">{{ item.value }}</div>
                        <span class="addr">{{ item.address }}</span>
                    </template>
                </el-autocomplete>
                <el-button type="primary" :class="{scale:bol}">提问</el-button>

                <div class="info">
                    <el-popover
                            placement="bottom"
                            width="100px"
                            trigger="click">
							<div class="nav2">
                                <el-menu :default-active="this.$route.path" router class="el-menu-demo2" mode="horizontal">
									<el-menu-item index="/personal">
										<i class="el-icon-user-solid"></i>
										<span>个人主页</span>
									</el-menu-item>
								</el-menu>   
							</div>
                            <div class="nav2">
								<el-menu :default-active="this.$route.path" router class="el-menu-demo2" mode="horizontal">
									<el-menu-item index="/setup">
										<i class="el-icon-s-tools"></i>
										<span>设置</span>
									</el-menu-item>
								</el-menu>        
                               
                            </div>
							<div class="nav2">
								<el-menu :default-active="this.$route.path" router class="el-menu-demo2" mode="horizontal">
									<el-menu-item index="/personal">
										<i class="el-icon-s-help"></i>
										<span>退出</span>
									</el-menu-item>
								</el-menu>        
							   
							</div>
                           
                        <img src="@/assets/tx.png" class="tx" slot="reference">
                    </el-popover>
                    <el-popover
                            placement="bottom"
                            width="300"
                            trigger="click">
                        <div class="letter">
                            <div class="letter-top">
                                <span>我的私信</span>
                            </div>
                            <div class="letter-middle">
                                <img src="@/assets/message2.png">
                            </div>
                            <div class="letter-middle-text">
                                <span>暂时还没有消息(っ °Д °;)っ</span>
                            </div>
                            <div  class="letter-below">
                                <div>
                                    <i class="el-icon-edit"></i>
                                    <span>写私信</span>
                                </div>
                                <div>
                                    <span>查看全部私信</span>
                                </div>
                            </div>
                        </div>
                        <i class="el-icon-chat-dot-round" slot="reference"></i>
                    </el-popover>
                    <el-popover
                            placement="bottom"
                            width="359"
                            trigger="click">
                        <div class="message">
                            <el-tabs type="border-card">
                                <el-tab-pane>
                                    <span slot="label"><i class="el-icon-s-fold"></i></span>
                                </el-tab-pane>
                                <el-tab-pane>
                                    <span slot="label"><i class="el-icon-connection"></i></span>
                                </el-tab-pane>
                                <el-tab-pane>
                                    <span slot="label"><i class="el-icon-attract"></i></span>
                                </el-tab-pane>
                            </el-tabs>
                        </div>
                        <div class="message-middle">
                            <img src="@/assets/message.png">
                        </div>
                        <div class="message-middle-text">
                            <span>你还没有消息哦o(*￣▽￣*)o</span>
                        </div>
                        <div class="message-below">
                            <div>
                                <i class="el-icon-s-tools"></i>
                                <span>设置</span>
                            </div>
                            <div>
                                <span>查看全部通知</span>
                            </div>
                        </div>
                        <i class="el-icon-message" slot="reference"></i>
                    </el-popover>
                </div>
            </div>
        </div>
    </header>
</template>

<script>
export default {
    name: "Nav",
    data() {
        return {
            suggestions: [],
            state: '',
            bol: false
        }
    },
    methods: {
        querySearch(queryString, cb) {
            var suggestions = this.suggestions;
            var results = queryString ? suggestions.filter(this.createFilter(queryString)) : suggestions;
            cb(results);
        },
        createFilter(queryString) {
            return (suggestions) => {
                return (suggestions.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
            };
        },
        loadAll() {
            return [
                {"value": "《沉默的真相》大结局 🔥"},
                {"value": "罗永浩还了4个亿 🔥"},
                {"value": "曲婉婷发文 🔥"},
                {"value": "《王者荣耀》S21赛季改动"},
                {"value": "如何戒掉天天看手机的习惯"}
            ]
        }
    },
    mounted() {
        this.suggestions = this.loadAll()
    }
}
</script>

<style lang="scss">
@import "../style/common";
@import "../style/nav";
.personal span{
	
}
.nav2 {
    @include index_nav2;
    .el-menu.el-menu--horizontal {
        border-bottom: none;
        .el-menu-item {
            border-bottom: none !important;
            padding: 0 0 0 0;
			padding-top:0px;
            &.is-active {
                color: #409EFF !important;
                font-weight: 600;
            }
        }
    }
}
.div-el{
	border:2px solid red;
}
.info span:hover{
	border:2px solid white;
}
.el-menu-demo2{
	
	
	}

</style>