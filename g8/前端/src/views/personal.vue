<template>
	<!--主体-->
		<div  class="wrapper-div">
					<div class="div-top">
						<div class="div-img2"><img src="../assets/logo.png"></div>		
						<p>微微</p><br>
						<div class="div2">
							<span>点击查看详细信息</span>
						</div>
						<div class="div3">
							
								 <el-menu :default-active="this.$route.path" router class="el-menu-demo" mode="horizontal">
									<el-menu-item index="/modify"><button class="button1">编辑个人资料</button></el-menu-item>
								</el-menu>
							
						</div>
						
					</div>
					<div class="main">
					    <nav class="nav">
					        <el-menu :default-active="this.$route.path" router class="el-menu-demo" mode="horizontal">
					            <el-menu-item index="/personal/dynamic">动态</el-menu-item>
					            <el-menu-item index="/personal/reply">回答</el-menu-item>
					            <el-menu-item index="/personal/questions">提问</el-menu-item>
								<el-menu-item index="/personal/article">文章</el-menu-item>
								<el-menu-item index="/personal/column">专栏</el-menu-item>
								<el-menu-item index="/personal/collection">收藏</el-menu-item>
								<el-menu-item index="/personal/concern">关注</el-menu-item>
					        </el-menu>
					    </nav>
					    <router-view/>
					</div>
					<personalRight></personalRight>
		</div>
	
</template>

<script>
	import personalRight from '../components/personal/personal-right.vue';
	export default {
		name: "personal",
		components: {
			personalRight
		}
	}
</script>
<style lang="scss" scoped>
	@import "../style/xadmin.css";
@import "../style/common";
.main {
    @include index_main;
}
.el-menu-demo{
	border:2px solid white;
}
.nav {
    @include index_nav;
    .el-menu.el-menu--horizontal {
        border-bottom: none;
        .el-menu-item {
            border-bottom: none !important;
            padding: 0 20px !important;
            &.is-active {
                color: #409EFF !important;
                font-weight: 600;
            }
        }
    }
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
</style>