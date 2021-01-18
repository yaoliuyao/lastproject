<template>
    <div class="box">
        <div class="pic">
            <img src="@/assets/follow-pic.png" alt="follow">
        </div>
        <p>还没有关注的人，快去热榜看看吧👀～</p>
    </div>
</template>

<script>
    export default {
        name: "found"
    }
</script>

<style lang="scss" scoped>
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
</style>