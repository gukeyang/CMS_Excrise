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
        <div>
            <img src="./ziyuan/images/logogo.png" alt="" />
            <span>畜牧兽医河南省虚拟仿真实验中心</span>
        </div>
    </div>
    <!-- nav 部分 -->
    <div class="nav">
        <#list first as first>
            <div>
                <a href="
                    <#list secondListT as secondListT>
                        <#if first.firstId == secondListT.firstId>
                            ${secondListT.url}
                            <#break>
                        </#if>
                        <#if first.firstTargetName == "首页">
                            ./index.html
                            <#break>
                        </#if>
                    </#list>
                ">${first.firstTargetName}</a>

                <#if first.firstTargetName != "首页">
                    <ul class="menu-bar">

                        <#list secondListT as secondListT>
                            <#if first.firstId == secondListT.firstId>
                                <li></li>
                                <li><a href="${secondListT.url}">${secondListT.secondTargetName}</a></li>
                            </#if>
                        </#list>
                    </ul>
                </#if>
            </div>
        </#list>
    </div>
</div>

<!-- 主体内容 -->
<div class="container">
    <div class="row">
        <div class="left-lab col-lg-3 col-md-12">
            <ul>
                <#list allSecond as item1>
                    <#list secondList as item2>
                        <#if item1_index == item2_index>
                            <li
                                    <#if item1_index == item2_index && item1.secondTargetName == currentTargetName>
                                        style="background-color: #337ab7"
                                    </#if>
                            ><a href="${item2.url}">${item1.secondTargetName}</a></li>
                        </#if>
                    </#list>
                </#list>
            </ul>
        </div>

        <div class="right-lab col-lg-9 col-md-12">
            <h2>文章列表</h2>
            <ul>
                <li class="linear"></li>
            </ul>

            <ul class="li">
                     <#list notices1 as notices1>

                         <#if notices1.firstTarget == currentTargetName>
                            <li>

                                 <a href="${notices1.htmlUrl}"> ${notices1.noticeTitle}</a>
                                 <a href="${notices1.htmlUrl}" >
                                     <div style="text-align: right;"> ${notices1.noticeTime} </div>
                                 </a>

                            </li>
                        </#if>
                     </#list>
            </ul>
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