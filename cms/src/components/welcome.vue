<template>
    <div>
        <!-- Welcome to the background management system!!! -->
        <img src="../images/a.png" style="height:550px;">
        <span  style="font-size: 30px;font-weight: 500;">
            Welcome to the background management system!
        </span>
    </div>
</template>
<script>
export default{
    created(){
        this.getData()
    },
    methods:{
        async getData(){
            //这个get会返回一个promise对象，为了简化promise操作，我们可以使用async await来优化这次异步操作
            const {data:res1} =await this.$http.get("/date")
            // const {data:res2} =await this.$http.get("/ip")
            console.log(res1);
            // console.log(res2);
        }
    }
}
</script>
<style scoped>
img{
    width: 100%;
    height: 100%;
}
</style>