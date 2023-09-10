const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  publicPath:'/cp',
  transpileDependencies: true,
  //关闭eslint校验
  lintOnSave: false,
  //解决跨域
  // devServer:{
  //   proxy: {
  //     '/cms': {
  //       target:'http://121.4.47.113:8081',
  //       pathRewrite:{'^/cms':''},
  //     }
  //   }
  // }

})

