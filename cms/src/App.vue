<template>
    <div id="app">
        <!-- 指定组件的呈现位置 -->
        <router-view v-if="isRouterAlive"></router-view>
        <!-- <router-link to="/login">denglu</router-link> -->
    </div>
</template>

<script>
export default {
    name: "App",
    provide(){
      return {
        reload:this.reload
      }
    },
    data(){
      return {
        isRouterAlive:true
      }
    },
    methods:{
      reload(){
        this.isRouterAlive=false
        this.$nextTick(function(){
          this.isRouterAlive=true
        })
      }
    }
};
</script>
<style>
#app {
  height: 100%;
  /* min-width: 1176px; */
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Helvetica Neue,
    Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, Arial, sans-serif;
  margin: 0;
}
</style>
