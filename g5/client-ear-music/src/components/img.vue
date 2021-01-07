<template>
    <section class="long-img">
         <div style="padding-top: 50px">
              <img :src="imgsrc" alt="" width="100%" height="150px" />
            </div>
    </section>
</template>
<script>
export default {
  props:['imgsrc'],
  data(){
    return{

    }
  },
}
</script>