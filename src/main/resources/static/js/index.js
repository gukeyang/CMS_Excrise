window.addEventListener = function () {
    // page1轮播图
    var imgs = this.document.getElementsByClassName('img')
    var lis = this.document.getElementsByClassName('dian')
    var a = 0;

    
    //添加一个定时器
    setInterval(fun, 2000)
    //遍历添加事件
    for (var j = 0; j < lis.length; j++) {

        //将每一个导航节点添加一个num属性
        lis[j].num = j
        lis[j].onclick = function () {
            num = this.num
            //遍历所有的导航节点去除样式
            for (var k = 0; k < lis.length; k++) {
                lis[k].style.background = 'rgba(100, 100, 100, 0.6)'
            }
            //让鼠标点击的节点变白
            this.style.backgroundColor = 'white'

            //遍历轮播图部分
            for (var z = 0; z < imgs.length; z++) {
                //判断
                if (z == num) {
                    imgs[z].style.display = 'block'
                } else {
                    imgs[z].style.display = 'none'
                }
            }
            a = num;
        }
    }
    function fun() {
        for (var i = 0; i < imgs.length; i++) {
            imgs[i].style.display = 'none';
            lis[i].style.background = 'rgba(100, 100, 100, 0.6)'
        }
        a++;
        if (a == 3) {
            a = 0;
        }
        imgs[a].style.display = 'block';
        lis[a].style.backgroundColor = 'white'
    }

    //page2 轮播图
    var yimgs = this.document.getElementsByClassName('yimg')
    var ylis = this.document.getElementsByClassName('ydian')
    var b = 0;

    
    //添加一个定时器
    setInterval(funs, 2000)
    //遍历添加事件
    for (var j = 0; j < ylis.length; j++) {

        //将每一个导航节点添加一个num属性
        ylis[j].num = j
        ylis[j].onclick = function () {
            num = this.num
            //遍历所有的导航节点去除样式
            for (var k = 0; k < ylis.length; k++) {
                ylis[k].style.background = 'rgba(100, 100, 100, 0.6)'
            }
            //让鼠标点击的节点变白
            this.style.backgroundColor = 'white'

            //遍历轮播图部分
            for (var z = 0; z < yimgs.length; z++) {
                //判断
                if (z == num) {
                    yimgs[z].style.display = 'block'
                } else {
                    yimgs[z].style.display = 'none'
                }
            }
            b = num;
        }
    }
    function funs() {
        for (var i = 0; i < yimgs.length; i++) {
            yimgs[i].style.display = 'none';
            ylis[i].style.background = 'rgba(100, 100, 100, 0.6)'
        }
        b++;
        if (b == 5) {
            b = 0;
        }
        yimgs[b].style.display = 'block';
        ylis[b].style.backgroundColor = 'white'
    }

    // 鼠标经过显示方块内容
    var zx = document.getElementsByClassName("zhongxin");
    var zxul = document.getElementsByClassName("zhongxinul");
    var gg = document.getElementsByClassName("gonggao");
    var ggul=document.getElementsByClassName("gonggaoul")
    zx[0].onmouseenter = function () {
        ggul[0].style.display = 'none';
        zxul[0].style.display = 'block';
        gg[0].style.backgroundColor='rgb(249,250,250)';
        gg[0].style.borderTop='none';
        zx[0].style.backgroundColor='#fff';
        zx[0].style.borderTop='rgb(218,0,0) solid 1px';
    }
    zx[1].onmouseenter = function () {
        ggul[1].style.display = 'none';
        zxul[1].style.display = 'block';
        gg[1].style.backgroundColor='rgb(249,250,250)';
        gg[1].style.borderTop='none';
        zx[1].style.backgroundColor='#fff';
        zx[1].style.borderTop='rgb(218,0,0) solid 1px';
    }

    gg[0].onmouseenter = function () {
        ggul[0].style.display = 'block';
        zxul[0].style.display = 'none';
        zx[0].style.backgroundColor='rgb(249,250,250)';
        zx[0].style.borderTop='none';
        gg[0].style.backgroundColor='#fff';
        gg[0].style.borderTop='rgb(218,0,0) solid 1px';
    }
    gg[1].onmouseenter = function () {
        ggul[1].style.display = 'block';
        zxul[1].style.display = 'none';
        zx[1].style.backgroundColor='rgb(249,250,250)';
        zx[1].style.borderTop='none';
        gg[1].style.backgroundColor='#fff';
        gg[1].style.borderTop='rgb(218,0,0) solid 1px';
    }
    
    // 特色平台控制
    var tsulli1=document.getElementsByClassName("tsulli1");
    var tsulli2=document.getElementsByClassName("tsulli2");
    var tsulli3=document.getElementsByClassName("tsulli3");
    var tsulli4=document.getElementsByClassName("tsulli4");
    var gebiaoti=document.getElementsByClassName("gebiaotiimg")

    // 刷新完页面就加载出来
    tsulli1[0].style.backgroundImage = "url(./images/img542.png)";
    tsulli1[0].style.backgroundSize = "100% 100%";
    tsulli1[0].style.borderLeft = "#337AB7 solid 6px";
    tsulli1[0].style.paddingLeft = "20px";
    tsulli1[0].style.animation="popup 1s forwards";
    tsulli1[0].style.width="420px";
    
    tsulli1[0].onmouseenter=function(){
        gebiaoti[0].src="./images/xuni.jpg"
        tsulli2[0].style.backgroundImage ="";
        tsulli3[0].style.backgroundImage ="";
        tsulli4[0].style.backgroundImage ="";
        tsulli2[0].style.borderLeft = "";
        tsulli3[0].style.borderLeft = "";
        tsulli4[0].style.borderLeft = "";
        tsulli2[0].style.paddingLeft = "";
        tsulli3[0].style.paddingLeft = "";
        tsulli4[0].style.paddingLeft = "";
        
        tsulli1[0].style.backgroundImage = "url(./images/img542.png)";
        tsulli1[0].style.backgroundSize = "100% 100%";
        tsulli1[0].style.borderLeft = "#337AB7 solid 6px";
        tsulli1[0].style.paddingLeft = "20px";
        
    }
    tsulli2[0].onmouseenter=function(){
        gebiaoti[0].src="./images/yuancheng.jpg"
        tsulli1[0].style.backgroundImage ="";
        tsulli3[0].style.backgroundImage ="";
        tsulli4[0].style.backgroundImage ="";
        tsulli1[0].style.borderLeft = "";
        tsulli3[0].style.borderLeft = "";
        tsulli4[0].style.borderLeft = "";
        tsulli1[0].style.paddingLeft = "";
        tsulli3[0].style.paddingLeft = "";
        tsulli4[0].style.paddingLeft = "";

        tsulli2[0].style.backgroundImage = "url(./images/img542.png)";
        tsulli2[0].style.backgroundSize = "100% 100%";
        tsulli2[0].style.borderLeft = "#337AB7 solid 6px";
        tsulli2[0].style.paddingLeft = "20px";
        
    }
    tsulli3[0].onmouseenter=function(){
        gebiaoti[0].src="./images/biaoben.jpg"
        tsulli2[0].style.backgroundImage ="";
        tsulli1[0].style.backgroundImage ="";
        tsulli4[0].style.backgroundImage ="";
        tsulli2[0].style.borderLeft = "";
        tsulli1[0].style.borderLeft = "";
        tsulli4[0].style.borderLeft = "";
        tsulli2[0].style.paddingLeft = "";
        tsulli1[0].style.paddingLeft = "";
        tsulli4[0].style.paddingLeft = "";

        tsulli3[0].style.backgroundImage = "url(./images/img542.png)";
        tsulli3[0].style.backgroundSize = "100% 100%";
        tsulli3[0].style.borderLeft = "#337AB7 solid 6px";
        tsulli3[0].style.paddingLeft = "20px";
    }
    tsulli4[0].onmouseenter=function(){
        gebiaoti[0].src="./images/ali.jpg"
        tsulli2[0].style.backgroundImage ="";
        tsulli3[0].style.backgroundImage ="";
        tsulli1[0].style.backgroundImage ="";
        tsulli2[0].style.borderLeft = "";
        tsulli3[0].style.borderLeft = "";
        tsulli1[0].style.borderLeft = "";
        tsulli2[0].style.paddingLeft = "";
        tsulli3[0].style.paddingLeft = "";
        tsulli1[0].style.paddingLeft = "";

        tsulli4[0].style.backgroundImage = "url(./images/img542.png)";
        tsulli4[0].style.backgroundSize = "100% 100%";
        tsulli4[0].style.borderLeft = "#337AB7 solid 6px";
        tsulli4[0].style.paddingLeft = "20px";
    }
}
$(function () {
    $('#dowebok').fullpage();
});