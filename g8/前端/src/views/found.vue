<template>
    <div class="found clear">
        <div class="tit">
            <i class="el-icon-s-order"></i>
            <h1>最新专题</h1>
        </div>
        <section>
            <div class="box">
                <transition-group>
                <div class="card" v-for="item in arrs" :key="item.id">
                    <a><img :src="item.img"></a>
                    <div class="card-header">
                        <div class="card-tit">
                            <a>{{item.cardtit}}</a>
                            <div class="card-count">
                                <span>{{item.time}}更新</span>
                                <span>{{item.count}}浏览</span>
                            </div>
                        </div>
                        <div class="card-button">
                            <button>关注专题</button>
                        </div>
                    </div>
                    <div class="card-list">
                        <div class="card-item" v-for="list in item.cardlist">
                            <a class="tag">{{list.tag}}</a>
                            <a class="title">{{list.title}}</a>
                        </div>
                    </div>
                </div>
                </transition-group>
                <div class="more">
                    <a>
                        <button>查看更多专题</button>
                    </a>
                </div>
            </div>
        </section>

        <div class="tit">
            <i class="el-icon-s-order"></i>
            <h1>专栏</h1>
        </div>
        <section>
            <div class="column">
                <transition-group>
                    <div class="lists" v-for="item in lists" :key="item.id">
                        <a :href="item.url" class="col-pic" target="_blank">
                            <img :src="item.img">
                        </a>
                        <a :href="item.url" class="col-tit" target="_blank">{{item.tit}}</a>
                        <div class="col-count">
                            <span>{{item.follow}} 关注 · </span>
                            <span>{{item.artical}} 文章</span>
                        </div>
                        <div class="col-info">{{item.info}}</div>
                        <button class="col-button">进入专栏</button>
                    </div>
                </transition-group>
                <div class="more">
                    <a>
                        <button>查看更多专栏</button>
                    </a>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
export default {
    name: "found",
    data () {
        return {
            arrs: [],
            lists: []
        }
    },
    methods: {
      load () {
          this.$axios({
              methods: 'get',
              url: 'data/found.json'
          })
              .then(res => {
                  this.lists = res.data.lists
              })
              .catch(err => {
                  console.log(err);
              })
      },
      handleScroll () {
          if (window.pageYOffset > 450) this.load()
      }
    },
    created () {
        this.$axios({
            methods: 'get',
            url: 'data/found.json'
        })
        .then(res => {
            this.arrs = res.data.res
        })
        .catch(err => {
            console.log(err);
        })
    },
    mounted () {
        window.addEventListener('scroll', this.handleScroll)
    },
    destroyed () {
        window.removeEventListener('scroll', this.handleScroll)
    }
}
</script>

<style lang="scss" scoped>
@import "../style/common";
@import "../style/found";
@include animate(translateX(150px));
.box > span {
    display: contents;
}
.column > span {
    display: inline-flex;
    padding-bottom: 20px;
}
</style>