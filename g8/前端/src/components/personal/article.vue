<template>
	<!-- 文章-->
	<div id="body">
		<div style="padding-left:16px;background-color: white;border-bottom: 1px solid gainsboro;height:30px;padding-top:10px;">
			<div style="float:left">
				<h4>我的文章</h4>
			</div>
			<div style="float: right;margin-right:30px;">
				<span style="font-size:14px;color:gray">按时间排序</span>
			</div>
			
		</div>
		
		<div class="box">
		    <div class="pic">
		        <img src="@/assets/follow-pic.png" alt="follow">
		    </div>
		    <p>还没有文章</p>
		</div>
	</div>
</template>

<script>
	export default {
	    name: "article",
	    data () {
	        return {
	            lists: []
	        }
	    },
	}
</script>

<style lang="scss" scoped>
@import "../../style/common";
@import "../../style/index/index-main";
#body {
    padding-bottom: 50px;
}
.box {
    padding: 10px;
    background-color: #fff;
    box-shadow: 0 1px 3px rgba(18, 18, 18, 0.1);
    .pic {
        padding: 20px 0;
        display: flex;
        justify-content: center;
    }
    p {
        text-align: center;
    }
}
@include animate();
</style>