<template>
	<div>
		<div class="main">
			<nav class="nav">
				<el-menu :default-active="this.$route.path" router class="el-menu-demo" mode="horizontal">
					<el-menu-item index="/index/main">首页</el-menu-item>
					<el-menu-item index="/index/follow">关注</el-menu-item>
					<el-menu-item index="/index/hot">热榜</el-menu-item>
				</el-menu>
			</nav>
			<router-view />
		</div>

		<IndexRight></IndexRight>
	</div>
</template>

<script>
	import IndexRight from '@/components/index/index-right.vue';
	export default {
		name: "index",
		components: {
			IndexRight
		}
	}
</script>

<style lang="scss" scoped>
	@import "../style/common";

	.main {
		@include index_main;
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
</style>
