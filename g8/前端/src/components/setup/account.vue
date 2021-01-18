<template>
	<div class="main">
		<!-- 账号密码 -->
		<div class="div1">
			<div class="div2">
				<h2>账号与密码</h2>
				<p>账号设置/个性域名</p>
			</div>
			<div class="div2">
				<h3>账号设置</h3>
				<p>绑定手机和邮箱，并设置密码，账号更安全</p>
				<p>注意：为保证账号安全，需进行二次验证</p>
			</div>
			<div class="div2">
				<h3 class="p">
					密码
				</h3>
				<p>未设置 <el-a type="text" @click="open" class="button3">编辑</el-a>
				</p>
			</div>
			<div class="div2">
				<h3 class="p">
					绑定手机
				</h3>
				<p>+13247891224 <el-a type="text" @click="open" class="button3">编辑</el-a>
				</p>

			</div>
			<div class="div2">
				<h3 class="p">
					绑定邮箱
				</h3>
				<p>未绑定 <a>编辑</a></p>
			</div>
			<div class="div2">
				<h3 class="p">
					个性域名
				</h3>
				<p>个人主页的地址，个性域名只可更改一次<el-a type="text" @click="open" class="button3">编辑</el-a>
				</p>
				<p>http://localhost:8080/#/setup/account</p>
			</div>
			<div class="div2">
				<ul class="newslist">
					<li v-for="(items, index) in proLists" :key="index">
						<p @click="openFunc(index)">
							
							<span>1</span>
						</p>
						<div class="p" ref="liCon">
							<div>
								测试111
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="right3">
			<h2>常见问题</h2>
			<h3>帐号与密码</h3>
			<el-collapse v-model="activeNames" @change="handleChange">
				<el-collapse-item title="1.为什么要进行二次验证？" name="1">
					<div> 二次验证可以有效防止盗号，维护号主自身权益。在修改密码、换绑手机、换绑邮箱前需需统一验证，通过后 30 分钟内无需再次验证。</div>
				</el-collapse-item>
				<el-collapse-item title="2.二次验证的手机/邮箱不可用？" name="2">
					<div> 点此进行人工申诉</div>
					<div> 点此进行人工申诉</div>
				</el-collapse-item>
				<el-collapse-item title="3.忘记密码怎么办？" name="2">
					<div> 已绑定手机/邮箱，点此重置密码</div>
					<div>未绑定手机和邮箱，点此人工申诉</div>
				</el-collapse-item>
				<el-collapse-item title="4.手机丢失，手机号不可用怎么办？" name="2">
					<div> 如果已绑定邮箱，可使用邮箱二次验证后更换手机号</div>
					<div>「未绑定邮箱且未设置密码，点此人工申诉</div>
				</el-collapse-item>
				<el-collapse-item title="5.绑定的手机号已经注册，怎么办？" name="2">
					<div> 通过手机号+验证码的形式登录确认是否为自己的帐号。</div>
					<div> 如该手机号近期进行过绑定操作，则 180 天内无法再次执行绑定、换绑操作</div>
				</el-collapse-item>
			</el-collapse>
			<h3>
				其他问题
			</h3>
			<p class="text-p">6.网站出现了问题？<a>问题反馈</a></p>
		</div>
	</div>

</template>

<script>
	export default {
		name: "account",
		data() {
			return {
				defaultOpen: ['1', '1-1'], // 默认展开菜单项
				liConHeight: 0, // 折叠面板内容初始高度
				proLists: [{
						name: '测试1',
					},
					
				],
			}
		},

		methods: {
			open() {
				this.$prompt('请输入手机号+86132****1224验证', '身份验证', {
					confirmButtonText: '验证',
					cancelButtonText: '取消',
					inputPattern: /^1[34578]\d{9}$/,
					inputErrorMessage: '手机号格式不正确'
				}).then(({
					value
				}) => {
					this.$message({
						type: 'success',
						message: '您的手机号是: ' + value
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '取消输入'
					});
				});
			},
			// 项目折叠面板动画
			openFunc(i) {
				const liCon = this.$refs.liCon[i]
				let height = liCon.offsetHeight
				if (height === this.liConHeight) { // 展开
					liCon.style.height = 'auto'
					height = liCon.offsetHeight
					liCon.style.height = this.liConHeight + 'px'
					// eslint-disable-next-line no-unused-vars
					let f = document.body.offsetHeight // 必加
					liCon.style.height = height + 'px'
				} else { // 收缩
					liCon.style.height = this.liConHeight + 'px'
				}
			},
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
	.newslist>li>div {
		height: 0px;
		overflow: hidden;
		transition: height .3s; /* // 动画效果 */
	}

	.div2 .button3 {
		color: royalblue;
		float: right;
		margin-right: 10px;
	}

	p {
		color: gray;
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
