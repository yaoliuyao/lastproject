<template>
	<div class="main">
		<!-- 隐私 -->
		<div class="div1">
			<div class="div2">
				<h2>隐私</h2>
				<p>隐私保护</p>
			</div>
			
			<div class="div2">
				<h3 >
					隐私保护
					<a>编辑</a>
				</h3>
				
			</div>
			
		</div>
		<div class="right3">
			<h2>常见问题</h2>
			<h3>隐私</h3>
			<el-collapse v-model="activeNames" @change="handleChange">
			 
			  <el-collapse-item title="1.「隐私保护」在什么范围内生效？" name="2">
			    <div>在知乎网、知乎日报和面向站外的内容精选和用户推荐中，这个设置都会生效。但是，其他用户在回答里提到的你的名字并不会被隐藏，如果内容已经被搜索引擎收录，则需要等待一段时间才会生效。</div>
			    <div>   这个选项可以为担心隐私泄露的用户提供一定的保护。相反，如果你认为你在知乎上的互动可以丰富你的个人形象，希望更多人由此了解你，那你可以选择在单独的问题下使用匿名身份来保护隐私，而非使用这个功能。</div>
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
		name: "privacy",
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
		font-size:15px;
		font-weight: normal;
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
		margin-top:10px;
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
