<template>
	<div class="main">
		<!-- 偏好设置 -->
		<div class="div1">
			<div class="div2">
				<h2>偏好设置</h2>
				<p>图片水印/瓦力保镖私信保护/快捷键</p>
			</div>
			
			<div class="div2">
				<h3 >
					图片水印
				</h3>
				<p>在我上传的图片上显示水印 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3>
					瓦力保镖私信保护
				</h3>
				<p>开启后，系统会对你收到的私信进行检测，被识别为「不友善」的私信将<a><el-tooltip :content="'Switch value: ' + value" placement="top">
				  <el-switch
				    v-model="value"

				    active-value="100"
				    inactive-value="0">
				  </el-switch>
				</el-tooltip></a></p>
				<p>会被自动隐藏，严重者将会主动帮你拉黑对方，以减少收到「不友善」私</p>
				<p>信的打扰。</p>
			</div>
			<div class="div2">
				<h3>
					快捷键
				</h3>
				<p>更加方便地浏览知乎，按 ?（Shift + /）查看所有快捷键
				<a>
				<el-tooltip :content="'Switch value: ' + value" placement="top">
				  <el-switch
				    v-model="value2"

				    active-value="100"
				    inactive-value="2">
				  </el-switch>
				</el-tooltip></a></p>
			</div>
			
		</div>
		<div class="right3">
			<h2>常见问题</h2>
			<h3>偏好设置</h3>
			<el-collapse v-model="activeNames" @change="handleChange">
			 
			  <el-collapse-item title="1.「偏好设置」是一个怎样的板块？" name="2">
			    <div>    在「偏好设置」中，我们为用户提供了更加个性化的设置项，例如新功能体验、为图片添加水印等。</div>
			    <div>  我们鼓励用户在「偏好设置」中选择适合自己的设置项，在使用过程中有任何建议可以通过问题反馈给我们，知乎期待和你一起成长。</div>
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
		name: "preference",
		data() {
			return {
				defaultOpen: ['1', '1-1'] ,// 默认展开菜单项
				 value: '100',
				  value2: '100'
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
		font-size:13px;
	}

	
	.div2 .p {
		font-weight: normal;
		margin-bottom: 5px;
	}

	.div2 {
		padding-top: 20px;
		padding-bottom:20px;
		

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
		padding-left:20px;
		padding-right: 10px;
	}
	.right3 h2{
		margin-bottom: 10px;
		padding-top:20px;
	}
	.right3 h3{
		
		margin-bottom: 10px;
		
	}
	.right3 .text-p{
	
		margin-bottom: 20px;
	}
	.right3 p{
		
		font-size:13px;
	}
	.right3 .bold-font{
		padding-left:20px;
	}
	.main {}
</style>
