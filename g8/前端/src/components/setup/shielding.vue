<template>
	<div class="main">
		<!-- 屏蔽 -->
		<div class="div1">
			<div class="div2">
				<h2>屏蔽</h2>
				<p>用户黑名单/话题黑名单/不看他的动态</p>
			</div>
			
			<div class="div2">
				<h3 >
					用户黑名单
				</h3>
				<p>查看或撤销已屏蔽用户 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3 >
					瓦力黑名单
				</h3>
				<p>查看或撤销已屏蔽用户 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3>
					话题黑名单
				</h3>
				<p>查看或撤销已屏蔽话题<a>编辑</a></p>
			</div>
			<div class="div2">
				<h3>
					不看他的动态
				</h3>
				<p>屏蔽已关注用户的动态 <a>编辑</a></p>
				
			</div>
		</div>
		<div class="right3">
			<h2>常见问题</h2>
			<h3>屏蔽</h3>
			<el-collapse v-model="activeNames" @change="handleChange">
			 
			  <el-collapse-item title="1.屏蔽用户后会发生什么？" name="2">
			    <div>屏蔽后，对方将不能关注你，向你发私信，评论你的实名回答，使用「@」提及你，邀请你回答问题等，但仍然可以查看你的公开信息。</div>

			  </el-collapse-item>
			 <el-collapse-item title="2.屏蔽话题后会发生什么？" name="2">
			   <div> 屏蔽后，在首页的动态中将不会出现该话题下的内容。</div>

			 </el-collapse-item>
			 <el-collapse-item title="3.什么是「受限话题」？" name="2">
			   <div>   「受限话题」是一类特殊的话题，该类话题不利于普通用户。该类话题下的内容将不会进入知乎发现、每周精选、知乎阅读等公共内容列表，不会在受限话题的父话题页面显示，也不会出现在用户个人首页动态中。了解更多</div>

			 </el-collapse-item>
			 <el-collapse-item title="4.什么是「限制名单」？？" name="2">
			   <div> 「限制名单」是在保证用户社交关系下，选择不看某些用户的内容所推出的功能。</div>
			   <div>   将某个用户加入「限制名单」后，对方的动态将不会出现在首页「关注」和想法中，但不影响你们的关注关系，也可以正常发送私信，评论，邀请回答等。</div>
			 </el-collapse-item>
			</el-collapse>
			<h3>
				其他问题
			</h3>
			<p class="text-p">5.网站出现了问题？<a>问题反馈</a></p>
		</div>
	</div>

</template>

<script>
	export default {
		name: "shielding",
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
		margin: 0px;
		background-color: white;
		padding: 0px;
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
