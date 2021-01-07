<template>
	<div class="main">
		<!-- 好物推荐 -->
		<div class="div1">
			<div class="div2">
				<h2>好物推荐</h2>
				<p>设置好物推荐相关信息</p>
			</div>

			<div class="div2">
				<h3>
					第三方账号绑定与设置擅长品类
				</h3>
				<p>绑定京东联盟、淘宝联盟账号<a>编辑</a></p>
			</div>

		</div>
		<div class="right3">
			<h2>常见问题</h2>
			<h3>偏好设置</h3>
			<el-collapse v-model="activeNames" @change="handleChange">

				<el-collapse-item title="1.「偏好设置」是一个怎样的板块？" name="2">
					<div> 在「偏好设置」中，我们为用户提供了更加个性化的设置项，例如新功能体验、为图片添加水印等。</div>
					<div> 我们鼓励用户在「偏好设置」中选择适合自己的设置项，在使用过程中有任何建议可以通过问题反馈给我们，知乎期待和你一起成长。</div>
				</el-collapse-item>

			</el-collapse>
			<h3>
				其他问题
			</h3>
			<p class="text-p">2.网站出现了问题？<a>问题反馈</a></p>
		</div>
	</div>

</template>

<script>
	export default {
		name: "things",
		data() {
			return {
				defaultOpen: ['1', '1-1'] // 默认展开菜单项
			}
		},
		computed: {
			activeMenu() {
				const route = this.$route
				const {
					meta,
					path
				} = route
				// if set path, the sidebar will highlight the path you set
				if (meta.apiActiveMenu) { // 注意这里很重要
					return meta.apiActiveMenu
				}
				return path
			}
		}
	}
</script>

<style>
	.div2 a {
		color: royalblue;
		float: right;
		margin-right: 10px;
	}

	p {
		color: gray;
		font-size: 13px;
	}


	.div2 .p {
		font-weight: normal;
		margin-bottom: 5px;
	}

	.div2 {
		padding-top: 20px;
		padding-bottom: 20px;


		border-bottom: 1px solid gainsboro;
	}

	h2 {
		margin-bottom: 5px;

	}

	h3 {
		margin-bottom: 5px;

	}

	.div1 {
		float: left;
		margin-top: 1px;
		width: 550px;

		background-color: white;

		padding-left: 20px;
		/* border:2px solid red; */
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
		margin-right: 10px;
	}

	.right3 {
		float: left;
		background-color: white;
		width: 228px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
		padding-left: 20px;
		padding-right: 10px;
	}

	.right3 h2 {
		margin-bottom: 10px;
		padding-top: 20px;
	}

	.right3 h3 {

		margin-bottom: 10px;

	}

	.right3 .text-p {

		margin-bottom: 20px;
	}

	.right3 p {

		font-size: 13px;
	}

	.right3 .bold-font {
		padding-left: 20px;
	}

	.main {}
</style>
