<template>
	
	<div class="main">
		<div class="main-left">
			<img src="../assets/logo.png">
		</div>
	    <div class="main-right">
			<h1>微微</h1>

				<el-menu :default-active="this.$route.path" router class="el-menu-demo2" mode="horizontal">
					<el-menu-item index="/personal"><span>返回我的主页></span></el-menu-item>
				</el-menu>
			
			</div>
			<div class="content">
			
				<el-form ref="form" :model="form" label-width="80px">
					<el-form-item label="性别" >
					  <el-radio-group v-model="form.resource">
					    <el-radio label="男"></el-radio>
					    <el-radio label="女"></el-radio>
					  </el-radio-group>
					</el-form-item>
				  <el-form-item label="介绍">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 <el-form-item label="居住地">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 <el-form-item label="所在行业">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 <el-form-item label="职业经历">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 <el-form-item label="教育经历">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 <el-form-item label="个人简历">
				    <el-input v-model="form.name"></el-input>
				 </el-form-item>
				 
				</el-form>
			</div>
			
		
	        
	</div>
</template>

<script>
	export default {
	    name: "modify",
	    data () {
	        return {
				  form: {
				           name: '',
				           region: '',
				           date1: '',
				           date2: '',
				           delivery: false,
				           type: [],
				           resource: '',
				           desc: ''
				         },
	            lists: []
	        }
	    },
		 methods: {
		      onSubmit() {
		        console.log('submit!');
		      }
		    }
	}
</script>

<style lang="scss" scoped>
	.el-menu-demo2{
		width:150px;
		float: right;
		border:1px  solid white;
		color:grey;
		height:40px;
		
	}
	span:hover{
		color:blue;
	}
	
	.main{
		margin-top:20px;
		height:700px;
		background-color: white;
		box-shadow: 0 1px 3px rgba(18, 18, 18, 0.1);
	}
	h1{
		float:left;
		font-size:30px;
	}
	
		
	label{
		font-weight: bold;
	}
	form{
		font-weight: bold;
	}
	.main-left{
		float:left;
	
		margin-left:10px;
	}
	.main-left img{
		width:200px;
		height:200px;
	}
	.main-right{
		float:left;
			margin-left:15px;
		width:760px;
		margin-top:30px;
	}
	.content{
		float:left;
		margin-left:1px;
		margin-top:30px;

		padding-left:1px;
		text-align: left;
		width:550px;
		height:600px;
	}
	
</style>
