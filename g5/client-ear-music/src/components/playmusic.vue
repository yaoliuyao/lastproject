<template>
  <section class="play">
      <div v-show="$route.name!=='my'
            && $route.name!=='musician'"> 
     <aplayer 
     :music="audio[0]"   
     :list="audio"  :showLrc="true"  
     :lrcType="3" 
     class="music" 
     listFolded="false"
     >

     </aplayer>
     </div>
  </section>
</template>



<script>
import aplayer from "vue-aplayer";  
export default {
    data(){
        return{
            audio:  [
                {
                    title:'不要说话',
                    artist: '陈奕迅',
                    src: require('../mp3/不要说话 - 陈奕迅.mp3'),
                    lrc: '../components/kiss.lrc',
                    pic:'../img/login.png'
                    
                },
            
            ],
        }
    },
    components: {
        aplayer 
    },
}
</script>
<style  scoped>
    .music{
        left: 0;  position: fixed; bottom: 0;  width: 100%;  z-index: 1000; 
    }
</style>