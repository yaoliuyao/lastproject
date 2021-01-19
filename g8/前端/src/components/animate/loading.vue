<template>
    <div id="loading">
        <div class="loader ball-beat">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
</template>

<script>
export default {
    name: "loading"
}
</script>

<style lang="scss" scoped>
    #loading {
        width: 694px;
        min-height: 85%;
        position: absolute;
        background: rgba(0, 0, 0, .1);
        z-index: 99;
        .loader {
            position: absolute;
            top: 50%;
            left: 50%;
            z-index: 100;
            transform: translateX(-50%) translateY(-50%);
        }
    }
    .ball-beat > div {
        width: 10px;
        height: 10px;
        border-radius: 50%;
        background-color: #279fcf;
        margin: 5px;
        display: inline-block;
        animation-fill-mode: both;
        animation: ball-beat 0.7s 0s infinite linear;
    }
    .ball-beat > div:nth-child(2n-1) {
        animation-delay: .35s;
    }
    @keyframes ball-beat {
        50% {
            opacity: 0.2;
            transform: scale(0.75);
        }
        100% {
            opacity: 1;
            transform: scale(1);
        }
    }
</style>