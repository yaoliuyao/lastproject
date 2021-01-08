<template>
    <div id="editorElem" style="text-align:left"></div>
</template>

<script>
    import  E from 'wangeditor'

    export default {

        name: "Fulltext",
        data () {
            return {
                editorContent: ''
            }
        },
        methods: {
            getContent: function () {
                alert(this.editorContent)

            },
        },
        mounted() {
            var editor = new E('#editorElem')
           editor.config.uploadImgShowBase64 = true;
            editor.create()

        }

    }
</script>

<style scoped>

</style>