<template>
    <div >

       <topmark></topmark>
    <Navigationbars></Navigationbars>
        <Content></Content>

    </div>
</template>

<script>

    import Navigationbars from "./navigationbars";
    import topmark from "./topmark";

    // import Fulltext from "./Fulltext";
    import Content from "./Content";

    export default {
        name: "Home",
        components: {Content, Navigationbars,topmark,}

    }
</script>

<style scoped>

</style>