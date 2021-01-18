<template>
	<!-- 回答 -->
	<div id="body">
		<!-- 首页 -->
		<div style="padding-left:16px;background-color: white;border-bottom: 1px solid gainsboro;height:30px;padding-top:10px;">
			<h4>我的回答</h4>
		</div>
		<div class="box">
		    <div class="pic">
		        <img src="@/assets/follow-pic.png" alt="follow">
		    </div>
		    <p>还没有回答，看看<a target="_blank" style="color:#0000FF">为你推荐的问题</a></p>
		</div>
	</div>
</template>

<script>
	export default {
	    name: "reply",
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