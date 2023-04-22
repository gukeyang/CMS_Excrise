<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="./ziyuan/images/favicon.ico">
    <link rel="stylesheet" href="./ziyuan/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./ziyuan/CSS/erjiyemian.css" />
    <!-- [if lt IE 9]> -->
    <script src="https://cdn.jsdelivr.cn/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.cn/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- <![endif] -->
    <title>畜牧兽医河南省虚拟仿真实验中心</title>
</head>
<body>
<!-- 顶部 -->
<div class="top">
    <div class="banner">
        <img src="./ziyuan/images/banne10.png" alt="" />
    </div>
    <!-- nav 部分 -->
    <div class="nav">
        <#list first as first>
            <div>
                <a href="./index.html">${first.firstTargetName}</a>

                <#if first.firstId == 2>
                    <ul class="menu-bar">
                        <#list allSecond2 as allSecond2>
                            <li></li>
                            <li><a href="${allSecond2.url}">${allSecond2.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 3>
                    <ul class="menu-bar">
                        <#list allSecond3 as allSecond3>
                            <li></li>
                            <li><a href="${allSecond3.url}">${allSecond3.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 4>
                    <ul class="menu-bar">
                        <#list allSecond4 as allSecond4>
                            <li></li>
                            <li><a href="${allSecond4.url}">${allSecond4.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 5>
                    <ul class="menu-bar">
                        <#list allSecond5 as allSecond5>
                            <li></li>
                            <li><a href="${allSecond5.url}">${allSecond5.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 6>
                    <ul class="menu-bar">
                        <#list allSecond6 as allSecond6>
                            <li></li>
                            <li><a href="${allSecond6.url}">${allSecond6.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 7>
                    <ul class="menu-bar">
                        <#list allSecond7 as allSecond7>
                            <li></li>
                            <li><a href="${allSecond7.url}">${allSecond7.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 8>
                    <ul class="menu-bar">
                        <#list allSecond8 as allSecond8>
                            <li></li>
                            <li><a href="${allSecond8.url}">${allSecond8.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
                <#if first.firstId == 9>
                    <ul class="menu-bar">
                        <#list allSecond9 as allSecond9>
                            <li></li>
                            <li><a href="${allSecond9.url}">${allSecond9.secondTargetName}</a></li>
                        </#list>
                    </ul>
                </#if>
            </div>
        </#list>

        <#--        <div>-->
        <#--            <a href="./xueyuan.html">中心概述</a>-->
        <#--            <ul class="menu-bar">-->
        <#--                <li><a href="./xueyuan.html">学院概括</a></li>-->
        <#--            </ul>-->
        <#--        </div>-->
        <#--        <div>-->
        <#--            <a href="./yangzhu.html">虚拟仿真</a>-->
        <#--            <ul class="menu-bar">-->
        <#--                <li><a href="">虚拟养猪</a></li>-->
        <#--                <li><a href="./yangji.html">虚拟养鸡</a></li>-->
        <#--                <li><a href="./zhuwenhua.html">猪文化馆</a></li>-->
        <#--                <li><a href="./dongwubiaoben.html">动物标本馆</a></li>-->
        <#--                <li><a href="./binglibiaoben.html">病理标本馆</a></li>-->
        <#--            </ul>-->
        <#--        </div>-->
        <#--        <div>-->
        <#--            <a href="./zhuchangyuancheng.html">远程互动</a>-->
        <#--            <ul class="menu-bar">-->
        <#--                <li><a href="./zhuchangyuancheng.html">猪场远程</a></li>-->
        <#--                <li><a href="./roujisiyang.html">肉鸡饲养远程</a></li>-->
        <#--                <li><a href="./roujijiagong.html">肉鸡加工远程</a></li>-->
        <#--            </ul>-->
        <#--        </div>-->
        <#--        <div>-->
        <#--            <a href="./jingpinkecheng.html">视频教学</a>-->
        <#--            <ul class="menu-bar">-->
        <#--                <li><a href="./jingpinkecheng.html">精品课程</a></li>-->
        <#--                <li><a href="./dongwushoushu.html">动物手术视频</a></li>-->
        <#--            </ul>-->
        <#--        </div>-->
        <#--        <div>-->
        <#--            <a href="./shitiku.html">在线考试</a>-->
        <#--            <ul class="menu-bar">-->
        <#--                <li><a href="./shitiku.html">试题库</a></li>-->
        <#--                <li><a href="./zaixian.html">在线测试</a></li>-->
        <#--                <li><a href="./shisheng.html">师生互动</a></li>-->
        <#--            </ul>-->
        <#--        </div>-->
    </div>
</div>
<!-- 主体内容 -->
<div class="container">
    <div class="row">
        <div class="left-lab col-lg-3 col-md-12">
            <ul>
                <#list allSecond as item1>
                            <li><a href="${item1.url}">${item1.secondTargetName}</a></li>
                </#list>
<#--                <li style="border: 1px solid red"><a href="">${data.getFirstTarget()}</a></li>-->
            </ul>
        </div>
        <div class="right-lab col-lg-9 col-md-12">
            <h2>${data.getNoticeTitle()}</h2>
            <ul>
                <li class="linear"></li>
            </ul>
            <div class="neil"> <p>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    ${data.getNoticeContent()}
                    <br><br>
                </p>
                <p>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    ${data.getNoticeTime()}
                </p></div>

        </div>
    </div>
</div>
<div class="rooter">
    <span><img src="./ziyuan/images/2.png" alt=""></span>
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
    <span><img src="./ziyuan/images/1.png" alt=""></span>
</div>
</body>
</html>
