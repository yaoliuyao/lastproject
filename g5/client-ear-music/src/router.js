import VueRouter from "vue-router";
import con from './components/combination/conformity';
import icon2 from './components/combination/conformity2';
import icon3 from './components/combination/conformity3';   
import icon4 from './components/combination/conformity4';   
import ss2 from './components/ss2';
import my from './components/mymusic';
import musician from './components/musician'
import songsheet from './components/song-sheet.vue'

export default new VueRouter({
    routes: [

        //每日推荐
        {
            path: "/con", component: con,
            name: 'music-conformity',
        },
        //遇见不同
        {
            path: "/icon2",
            name: 'music-conformity2',
            components:{
                icon2:icon2,
            }
        },
        //独家放送
        {
            path: "/icon3",
            name: 'music-conformity3',
            components:{
                icon3:icon3,
            }
        },
        //耳遇专栏
        {
            path: "/icon4",
            name: 'music-conformity4',
            components:{
                icon3:icon4,
            }
        },
        //热门歌单
        {
            path: "/songsheet",
            name: 'sheet',
            components:{
                songsheet:songsheet,
            }
        },
       
        {
            //飙升榜
            path: "/song1",
            name:'music-song1',
            components:{
                from:ss2,
            }
           
        },
        {
            //网络热曲
            path: "/song2",
            name:'music-song2',
            components:{
                from2:ss2,
            }
           
        },
        //我的音乐
        {
            path: "/music2",
            name: 'my',
            components:{
                my:my,
            }
        },
         //音乐人
         {
            path: "/music3",
            name: 'musician',
            components:{
                musician:musician,
            }
        },
       
    ]
});