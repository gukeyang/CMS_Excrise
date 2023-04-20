<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>河南科技学院</title>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <link rel="stylesheet" href="./CSS/index.css">
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <link rel="stylesheet" href="./CSS/jquery.fullPage.css">
    <link rel="stylesheet" href="./Css/style.css">
    <!-- 在线引入字体图标 -->
    <link rel="stylesheet" href="http://at.alicdn.com/t/c/font_2943196_ha99x8qsa2e.css">
    <script src="./js/jQuery.min.js"></script>
    <script src="./js/jquery.fullPage.min.js"></script>
    <script src="./js/index.js"></script>
</head>

<body>
<div class="nav">
    <div class="logo">
        <#list pictures as p>
            <#if p.imgName == "logo">
                <a href=""><img src = ${p.imgPath} alt=""></a>
            </#if>
        </#list>
    </div>

    <#list first as first>
        <div>
            <a href="./shitiku.html">${first.firstTargetName}</a>

            <#if first.firstId == 2>
                <ul class="menu-bar">
                <#list allSecond2 as allSecond2>
                        <li><a href="./shitiku.html">${allSecond2.secondTargetName}</a></li>
                </#list>
                </ul>
            </#if>

            <#if first.firstId == 3>
                <ul class="menu-bar">
                <#list allSecond3 as allSecond3>

                        <li><a href="./shitiku.html">${allSecond3.secondTargetName}</a></li>

                </#list>
                </ul>
            </#if>

            <#if first.firstId == 4>
                <ul class="menu-bar">
                <#list allSecond4 as allSecond4>

                        <li><a href="./shitiku.html">${allSecond4.secondTargetName}</a></li>

                </#list>
                </ul>
            </#if>

            <#if first.firstId == 5>
                <ul class="menu-bar">
                <#list allSecond5 as allSecond5>

                        <li><a href="./shitiku.html">${allSecond5.secondTargetName}</a></li>

                </#list>
                </ul>
            </#if>

            <#if first.firstId == 6>
                <ul class="menu-bar">
                <#list allSecond6 as allSecond6>

                        <li><a href="./shitiku.html">${allSecond6.secondTargetName}</a></li>

                </#list>
                </ul>
            </#if>

            <#if first.firstId == 7>
                <ul class="menu-bar">
                <#list allSecond7 as allSecond7>

                        <li><a href="./shitiku.html">${allSecond7.secondTargetName}</a></li>

                </#list>
                </ul>
            </#if>

        </div>
    </#list>

</div>
<div id="dowebok">
    <div class="section page1">
        <!-- 没有添加小圆点 -->
        <ul class="yuandian">
            <li class="li" style="background-color: white;"></li>
            <li class="li"></li>
            <li class="li"></li>
        </ul>
        <#list pictures as p>
            <#if p.imgName == "轮播图1">
                <img class="img" class="img_one" src= ${p.imgPath} alt="" style="display: block;">
            </#if>
        </#list>
        <#list pictures as p>
            <#if p.imgName == "轮播图2">
                <img class="img" class="img_two" src= ${p.imgPath} alt="" >
            </#if>
        </#list>
        <#list pictures as p>
            <#if p.imgName == "轮播图3">
                <img class="img" class="img_three" src= ${p.imgPath} alt="">
            </#if>
        </#list>
        <!-- 添加文字 -->
        <span>河南科技学院</span>
    </div>
    <div class="section page2">
        <div class="container">
            <div class="row">
                <div class="notice col-lg-4 col-md-4" style="margin-top: 20px;">
                    <div class="title">公告通知</div>
                    <a href="./gonggao.html"><div class="more">查看更多公告</div></a>
                    <div class="news">
                        <#list notices as item>
                            <span class="col-sm-6 col-xs-6">
                                <img src="./images/bg3.png" alt="">
                                <ul>
                                    <li><a href="">${item.noticeTitle}</a></li>
                                    <li>${item.noticeTime}</li>
                                </ul>
                            </span>

                        </#list>
                    </div>
                </div>
                <div class="center col-lg-4 col-md-4" style="margin-top: 20px;">
                    <div class="title">中心要闻</div>
                    <a href="./zhongxin.html"><div class="more">查看更多</div></a>
                    <div class="news">
                        <#list news as item1>
                            <span class="col-sm-6 col-xs-6">
                                <img src="./images/bg3.png" alt="">
                                <ul>
                                    <li><a href="">${item1.noticeTitle}</a></li>
                                    <li>${item1.noticeTime}</li>
                                </ul>
                            </span>

                        </#list>
                    </div>
                </div>
                <div class="tupian col-lg-4 col-md-4 hidden-sm hidden-xs">
                    <div class="img1">
                        <#list pictures as p>
                            <#if p.imgName == "侧边图A">
                                <img src=${p.imgPath} alt="" >
                            </#if>
                        </#list>
                        <#--                        <img src=${} alt="" >-->
                    </div>
                    <div class="img1">
                        <#list pictures as p>
                            <#if p.imgName == "侧边图B">
                                <img src=${p.imgPath} alt="" >
                            </#if>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="section page3">
        <div class="container">
            <div class="row">
                <div class="title">特色平台</div>
<#--                <span>-->
<#--                        <div class="wai">-->
<#--                            <div class="nei">-->
<#--                                <a href="./yangzhu.html">-->
<#--                                    <div class="huati">虚拟仿真</div>-->
<#--                                    <img src="./images/01.jpg" alt="">-->
<#--                                </a>-->
<#--                            </div>-->
<#--                        </div>-->
<#--                </span>-->
<#--                <span>-->
<#--                        <div class="wai">-->
<#--                            <div class="nei">-->
<#--                                <a href="./zhuchangyuancheng.html">-->
<#--                                    <div class="huati">远程互动</div>-->
<#--                                    <img src="./images/02.jpg" alt="">-->
<#--                                </a>-->
<#--                            </div>-->
<#--                        </div>-->
<#--                </span>-->
<#--                <span>-->
<#--                        <div class="wai">-->
<#--                            <div class="nei">-->
<#--                                <a href="./dongwubiaoben.html">-->
<#--                                    <div class="huati">数字标本</div>-->
<#--                                    <img src="./images/03.jpg" alt="">-->
<#--                                </a>-->
<#--                            </div>-->
<#--                        </div>-->
<#--                    </span>-->
<#--                <span>-->
<#--                        <div class="wai">-->
<#--                            <div class="nei">-->
<#--                                <a href="./binglibiaoben.html">-->
<#--                                    <div class="huati">阿里库</div>-->
<#--                                    <img src="./images/04.jpg" alt="">-->
<#--                                </a>-->
<#--                            </div>-->
<#--                        </div>-->
<#--                </span>-->

                <#list lister as lister>
                    <span>
                        <div class="wai">
                            <div class="nei">
                                <a href="./binglibiaoben.html">
                                    <div class="huati">${lister.chTitle}</div>
                                    <#if lister.id == 1> <img src="./images/01.jpg" alt=""> </#if>
                                    <#if lister.id == 2> <img src="./images/02.jpg" alt=""> </#if>
                                    <#if lister.id == 3> <img src="./images/03.jpg" alt=""> </#if>
                                    <#if lister.id == 4> <img src="./images/04.jpg" alt=""> </#if>

                                </a>
                            </div>
                        </div>
                </span>
                </#list>
            </div>
        </div>
    </div>
    <div class="section page4">
        <div class="container">
            <div class="row">
                <ul>
                    <li>
                        <a href="./jingpinkecheng.html">
                            <img src="./images/m1.jpg" alt="">
                            <p>精品课程</p>
                        </a>
                    </li>
                    <li>
                        <a href="./zhuchangyuancheng.html">
                            <img src="./images/m2.jpg" alt="">
                            <p>动医课程</p>
                        </a>
                    </li>
                    <li>
                        <a href="./dongwushoushu.html">
                            <img src="./images/m3.jpg" alt="">
                            <p>在线学习</p>
                        </a>
                    </li>
                    <li>
                        <a href="./roujisiyang.html">
                            <img src="./images/m4.jpg" alt="">
                            <p>动科课程</p>
                        </a>
                    </li>
                    <li>
                        <a href="./zaixian.html">
                            <img src="./images/m2.jpg" alt="">
                            <p>在线考试</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="section page5">
        <div class="leftimg lr"><img src="./images/hky-studyfont.png" alt=""></div>
        <div class="rightimg lr"><img src="./images/hky-studyfont.png" alt=""></div>
        <div class="welcome">
            <span class="title">Welcome To Visit!</br>Study Gother!</span>
            <!-- <span class="zixun">扫码关注</span>
        <span class="zixun iconfont icon-weixin"></span>
        <span class="zixun iconfont icon-weibo">3</span>
        <span class="zixun iconfont icon-douyin">4</span> -->
            <span class="zixun"><img src="./images/keyuan.jpg" alt=""></span>
            <span class="iconfont icon-weixin" style="color: green;">
                    <img src="./images/weixin.png" alt="">
                </span>
            <span class="iconfont icon-weibo" style="color: red;">
                    <img src="./images/weibo.png" alt=""></span>
            <span class="iconfont icon-douyin" style="color: black;">
                    <img src="./images/douyin.png" alt=""></span>
        </div>
        <div class="rooter">
            <span><img src="./images/2.png" alt=""></span>
            <span>
                    <ul>
                        <li>版权所有：畜牧兽医仿真实验中心</li>
                        <li>地址: 河南省新乡市华兰大道90号</li>
                        <li>电话: 0373-3040718</li>
                        <li>豫ICP备2021029424号-1</li>
                    </ul>
                </span>
            <span></span>
            <span>畜牧兽医河南省虚拟</br>仿真实验教学中心</span>
            <span><img src="./images/1.png" alt=""></span>
        </div>
    </div>
</div>
</body>

</html>