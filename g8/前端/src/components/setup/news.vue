<template>
	<div class="main">
		<!-- 消息与邮件 -->
		<div class="div1">
			<div class="div2">
				<h2>消息与邮件</h2>
				<p>私信设置/邀请设置/赞同与赞赏/关注/邮件设置</p>
			</div>
			
			<div class="div2">
				<h3 >
					私信设置
				</h3>
				<p>允许谁给我发私信 <a @click="boxshow = !boxshow">编辑</a></p>
				<transition name="draw">   <!--这里的name 和 css 类名第一个字段要一样-->
				        <div class="box"  v-show="boxshow"></div>
				    </transition>
			</div>
			<div class="div2">
				<h3>
					邀请/评论消息设置
				</h3>
				<p>有人对我发出邀请时，我会收到消息通知 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3>
					赞同/赞赏消息设置
				</h3>
				<p>有人对我赞同或赞赏时，我会收到消息通知 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3>
					关于消息设置
				</h3>
				<p>我的关注有新动态时，我会收到消息通知<a>编辑</a></p>
				
			</div>
			<div class="div2">
				<h3 >
					邮件设置
				</h3>
				<p>重要事件发生时，我将会受到邮件提醒<a>编辑</a></p>
				
			</div>
		</div>
		
		<div class="right3">
			<h2>常见问题</h2>
			<h3>消息与邮件</h3>
			<el-collapse v-model="activeNames" @change="handleChange">
			  <el-collapse-item title="1.什么是陌生人私信箱？" name="1">
			    <div>&#160 &#160  陌生人私信箱可以减少陌生私信打扰，提高私信的浏览效率。</div>
			    <div>   开启后，陌生私信将统一被放入陌生人私信箱，除非主动查看回复，该用户的私信将不会显示在私信列表。</div>
			  </el-collapse-item>
			  <el-collapse-item title="2.什么是「获取所有新回答通知」？" name="2">
			    <div>  正常情况下，当一个新回答产生后，我们会按一定规则将它先发送给某些用户，根据这些用户的反馈（点赞，喜欢，没有帮助等）决定该回答后续的推送，以此确保大部分关注者可以接收到更加优质的回答。</div>
			    <div>「获取所有新回答通知」即不经过用户反馈，直接获取全部新回答。选中后， 你会收到更多的新回答通知，但是无法得到保证回答质量。</div>
			  </el-collapse-item>
			 
			</el-collapse>
			<h3>
				其他问题
			</h3>
			<p class="text-p">3.网站出现了问题？<a>问题反馈</a></p>
		</div>
	</div>

</template>

<script>
	
	export default {
		name: "news",
		data() {
			return {
				
				 activeNames: ['1']
			}
		},

		 methods: {
		      handleChange(val) {
		        console.log(val);
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
