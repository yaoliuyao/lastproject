<template>
	<!-- 设置 -->
	<div class="main">
		<el-row class="tac">
			<el-col :span="12">

				<el-menu :default-active="this.$route.path" router class="el-menu-demo2" mode="horizontal">
					<div class="nav2">
						<el-menu-item index="/setup/account">
							<i class="el-icon-user-solid"></i>
							<span slot="title">账号与密码</span>
						</el-menu-item>
					</div>
					<div class="nav2">
						<el-menu-item index="/setup/news">
							<i class="el-icon-message-solid"></i>
							<span slot="title">消息与邮件</span>
						</el-menu-item>
					</div>
					<div class="nav2">
						<el-menu-item index="/setup/shielding">
							<i class="el-icon-close-notification"></i>
							<span slot="title">屏蔽</span>
						</el-menu-item>
					</div>
					<div class="nav2">
						<el-menu-item index="/setup/privacy">
							<i class="el-icon-lock"></i>
							<span slot="title">隐私</span>
						</el-menu-item>
					</div>
					<div class="nav2">
						<el-menu-item index="/setup/preference">
							<i class="el-icon-setting"></i>
							<span slot="title">偏好设置</span>
						</el-menu-item>
					</div>
					<div class="nav2">
						<el-menu-item index="/setup/things">
							<i class="el-icon-shopping-cart-full"></i>
							<span slot="title">好物推荐</span>
						</el-menu-item>
					</div>
				</el-menu>

			</el-col>
			<router-view></router-view>
		</el-row>

	</div>

</template>

<script>
	export default {
		name: "setup",
		data() {
			return {};
		},

		methods: {
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			},
			goTo(path) {
				this.$router.replace(path);
			}
		},
	}
</script>

<style lang="scss">
	.tac{
		margin-top: 15px;
	}
	.title {
		width: 200px;
	
	}

	.el-menu-demo2 {}

	.main {
		margin-top: 1px;

	}

	.main span:hover {
		border: 2px solid white;
	}

	.el-col-12 {
		width: 15%;
	}
</style>
