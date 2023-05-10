<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>畜牧兽医虚拟仿真实验中心</title>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="iconfont/iconfont.css">
    <link rel="stylesheet" href="css/jquery.fullPage.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/jquery.fullPage.min.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
    <div class="topnav">
        <div class="logo">
            <#list pictures as p>
                <#if p.imgName == "logo">
                    <a href="./index.html"><img src= "${p.imgPath}" alt=""></a>
                </#if>
            </#list>
        </div>

        <div class="nav">
            <ul class="fm">
                <#list first as first>
                    <li class="li" style="color: white"><a href="
                    <#list secondList as secondList>
                        <#if first.firstId == secondList.firstId>
                            ${secondList.url}
                            <#break>
                        </#if>
                    </#list>
                    ">${first.firstTargetName}</a>

                        <#if first.firstTargetName != "首页">
                            <span class="iconfont icon-jiantou"></span>
                            <ul class="menu-bar">

                        <#list secondList as secondList>
                            <#if first.firstId == secondList.firstId>
                                        <li></li>
                                        <li><a href="${secondList.url}">${secondList.secondTargetName}</a></li>
                            </#if>
                        </#list>
                             </ul>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>

    </div>
    <div id="dowebok">
        <div class="section page1">
            <!-- 没有添加小圆点 -->
            <ul class="yuandian">
                <li class="dian" style="background-color: white;"></li>
                <li class="dian"></li>
                <li class="dian"></li>
            </ul>
            <#list pictures as p>
                <#if p.imgName == "轮播图1">
                    <img class="img" class="img_one" src= "${p.imgPath}" alt="" style="display: block;">
                </#if>
            </#list>
            <#list pictures as p>
                <#if p.imgName == "轮播图2">
                    <img class="img" class="img_two" src= "${p.imgPath}" alt="" >
                </#if>
            </#list>
            <#list pictures as p>
                <#if p.imgName == "轮播图3">
                    <img class="img" class="img_three" src= "${p.imgPath}" alt="">
                </#if>
            </#list>
            <!-- 添加文字 -->
            <span>畜牧兽医河南省虚拟仿真实验中心</span>
        </div>

        <div class="section page2">
            <div class="contents">
                <div class="left">
                    <div class="indexbox">
                            <div class="biaotis">
                                <ul class="biaotiul">
                                    <li class="biaotili zhongxin"><span class="iconfont icon-xinwen"></span>&nbsp;中心要闻</li>
                                    <li class="biaotili gonggao"><span class="iconfont icon-notice"></span>&nbsp;公告通知</li>
                                    <li><a href="${more1}">更多...</a></li>
                                </ul>
                            </div>
                            <div class="box-content">
                                <ul class="zhongxinul">
                                    <#list news as news>
    <#--                                    <#if item.firstTarget == "中心要闻">-->
                                            <li>
                                                <span class="iconfont icon-xinwen"></span>
                                                <span class="xiaobt"><a href="${news.htmlUrl}">${news.noticeTitle}</a></span>
                                                <span class="shijian">&nbsp;${news.noticeTime}</span>

                                            </li>
    <#--                                    </#if>-->
                                    </#list>
                                </ul>
                                <ul class="gonggaoul">
                                    <#list notices as notices>
    <#--                                    <#if item.firstTarget == "公告通知">-->
                                            <li>
                                                <span class="iconfont icon-notice"></span>
                                                <span class="xiaobt"><a href="${notices.htmlUrl}">${notices.noticeTitle}</a></span>
                                                <span class="shijian">&nbsp;${notices.noticeTime}</span>

                                            </li>
    <#--                                    </#if>-->
                                    </#list>
                                </ul>
                            </div>
                    </div>
                    <div class="indexbox leftbox">
                            <div class="biaotis">
                                <ul class="biaotiul">
                                    <li class="biaotili zhongxin"><span class="iconfont icon-kaoshi"></span>&nbsp;在线测试</li>
                                    <li class="biaotili gonggao"><span class="iconfont icon-zhishihudong"></span>&nbsp;师生互动</li>
                                    <li><a href="${more2}">更多...</a></li>
                                </ul>
                            </div>
                            <div class="box-content">
                                <ul class="zhongxinul">

                                    <#list ceshi as ceshi>
                                    <#--                                    <#if item.firstTarget == "公告通知">-->
                                        <li>
                                            <span class="iconfont icon-kaoshi"></span>
                                            <span class="xiaobt"><a href="${ceshi.htmlUrl}">${ceshi.noticeTitle}</a></span>
                                            <span class="shijian">&nbsp;${ceshi.noticeTime}</span>

                                        </li>
                                    <#--                                    </#if>-->
                                    </#list>

                                </ul>
                                <ul class="gonggaoul">

                                    <#list hudong as hudong>
                                    <#--                                    <#if item.firstTarget == "公告通知">-->
                                        <li>
                                            <span class="iconfont icon-zhishihudong"></span>
                                            <span class="xiaobt"><a href="${hudong.htmlUrl}">${hudong.noticeTitle}</a></span>
                                            <span class="shijian">&nbsp;${hudong.noticeTime}</span>

                                        </li>
                                    <#--                                    </#if>-->
                                    </#list>

                                </ul>
                            </div>
                    </div>
                </div>
                <div class="youce">
                    <ul>
                        <li class="ydian"></li>
                        <li class="ydian"></li>
                        <li class="ydian"></li>
                        <li class="ydian"></li>
                        <li class="ydian"></li>
                    </ul>

                    <#list pictures as p>
                        <#if p.imgName == "侧边图A">
                            <img class="yimg" src="${p.imgPath}" alt="">
                        </#if>
                    </#list>
                    <#list pictures as p>
                        <#if p.imgName == "侧边图B">
                            <img class="yimg" src="${p.imgPath}" alt="">
                        </#if>
                    </#list>
                    <#list pictures as p>
                        <#if p.imgName == "侧边图C">
                            <img class="yimg" src="${p.imgPath}" alt="">
                        </#if>
                    </#list>
                    <#list pictures as p>
                        <#if p.imgName == "侧边图D">
                            <img class="yimg" src="${p.imgPath}" alt="">
                        </#if>
                    </#list>
                    <#list pictures as p>
                        <#if p.imgName == "侧边图E">
                            <img class="yimg" src="${p.imgPath}" alt="">
                        </#if>
                    </#list>
                </div>
            </div>
        </div>
        <div class="section page3">
            <div class="contents">
                <div class="title">
                    <span class="datitle">
                        <div class="eng">Characteristic platform</div>
                        <div class="chi">特色平台</div>
                        <div class="fengexian"></div>
                        <div class="jianjie">
                            本专业培养适应社会生产发展和经济建设需要，
                            德、智、体全面发展，掌握畜牧兽医方面的基本
                            理论、基本知识和基本技术，能够在国家畜牧兽
                            医业务部门、生产单位及有关部门从事畜牧兽医
                            生产、服务及管理的实用型、技能型专门人才。
                        </div>
                    </span>
                    <ul class="tsul">

                        <#list lister as lister>
                            <#if lister.id == 1>
                                <a href="./second5.html"><li class="tsulli1">${lister.chTitle}</li></a>
                            </#if>
                            <#if lister.id == 2>
                                <a href="./second4.html"><li class="tsulli2">${lister.chTitle}</li></a>
                            </#if>
                            <#if lister.id == 3>
                                <a href="./second10.html"><li class="tsulli3">${lister.chTitle}</li></a>
                            </#if>
                            <#if lister.id == 4>
                                <a href="./second11.html"><li class="tsulli4">${lister.chTitle}</li></a>
                            </#if>

                        </#list>
                    </ul>
                </div>

                <div class="gebiaoti">
                    <img class="gebiaotiimg" src="images/xuni.jpg" alt="">
                </div>
            </div>
        </div>
        <div class="section page4">
            <div class="contents">
                <div class="media">
                    <div class="dabiaoti">
                        FOLLOW US @SOCIAL MEDIA<br>
                        <span class="span1">前往社交媒体上的我们</span>
                    </div>
                    <div class="meiti">
                        <ul>
                            <li><a href="https://www.douyin.com/user/MS4wLjABAAAAv_GPLlwLYf174lXlK3K1XQft8d0BIUrHAapv4Un7ZJo" target="_blank" title="抖音"><span class="iconfont icon-douyin"></span></a></li>
                            <li><a href="https://www.kuaishou.com/profile/3xamw5c5je49zqc" target="_blank" title="快手"><span class="iconfont icon-kuaishou"></span></a></li>
                            <li><a href="https://weibo.com/hkeyuan" target="_blank" title="微博"><span class="iconfont icon-weibo"></span></a></li>
                            <li><a href="https://www.hist.edu.cn/" target="_blank" title="更多咨询"><span class="iconfont icon-gengduo"></span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="xiangxi">
                    <ul>
<#--                        <li>-->
<#--                            <a  target="_blank" href="https://www.douyin.com/user/MS4wLjABAAAAv_GPLlwLYf174lXlK3K1XQft8d0BIUrHAapv4Un7ZJo?modal_id=7216598790361337127"><img src="images/doushipin.jpg" alt="">-->
<#--                            <div class="tun">-->
<#--                                <span class="tunbt">春天里的浪漫鲜花占一半</span>-->
<#--                                <span class="iconfont icon-douyin tuntb">&nbsp;抖音</span>-->
<#--                            </div>-->
<#--                        </a>-->
<#--                        </li>-->


                        <#list pictures as p>
                            <#if p.imgName == "抖音">
                                <li>
                                    <a  target="_blank" href="https://www.douyin.com/user/MS4wLjABAAAAv_GPLlwLYf174lXlK3K1XQft8d0BIUrHAapv4Un7ZJo?modal_id=7216598790361337127"><img src="${p.imgPath}" alt="">
                                        <div class="tun">
                                            <span class="tunbt">春天里的浪漫鲜花占一半</span>
                                            <span class="iconfont icon-douyin tuntb">&nbsp;抖音</span>
                                        </div>
                                    </a>
                                </li>
                            </#if>
                        </#list>
                        <#list pictures as p>
                            <#if p.imgName == "快手">
                                <li>
                                    <a  target="_blank" href="https://www.douyin.com/user/MS4wLjABAAAAv_GPLlwLYf174lXlK3K1XQft8d0BIUrHAapv4Un7ZJo?modal_id=7216598790361337127"><img src="${p.imgPath}" alt="">
                                        <div class="tun">
                                            <span class="tunbt">愿所有美好不期而遇</span>
                                            <span class="iconfont icon-douyin tuntb">&nbsp;快手</span>
                                        </div>
                                    </a>
                                </li>
                            </#if>
                        </#list>
                        <#list pictures as p>
                            <#if p.imgName == "微博">
                                <li>
                                    <a  target="_blank" href="https://www.douyin.com/user/MS4wLjABAAAAv_GPLlwLYf174lXlK3K1XQft8d0BIUrHAapv4Un7ZJo?modal_id=7216598790361337127"><img src="${p.imgPath}" alt="">
                                        <div class="tun">
                                            <span class="tunbt">时光藏在校园的每个角落里</span>
                                            <span class="iconfont icon-douyin tuntb">&nbsp;微博</span>
                                        </div>
                                    </a>
                                </li>
                            </#if>
                        </#list>
<#--                        <li>-->
<#--                            <a  target="_blank" href="https://www.kuaishou.com/short-video/3xcnamrgxu2qp92?authorId=3xamw5c5je49zqc&streamSource=profile&area=profilexxnull&currentPcursor=1.677478757734E12"><img src="images/kuaishipin.jpg" alt="">-->
<#--                            <div class="tun">-->
<#--                                <span class="tunbt">愿所有美好不期而遇</span>-->
<#--                                <span class="iconfont icon-kuaishou tuntb">&nbsp;快手</span>-->
<#--                            </div>-->
<#--                        </a>-->
<#--                        </li>-->
<#--                        <li>-->
<#--                            <a  target="_blank" href="https://s.weibo.com/weibo?q=%23%E5%9B%BE%E8%AF%B4%E7%A7%91%E9%99%A2%23#_loginLayer_1681263126533"><img src="images/weishipin.jpg" alt="">-->
<#--                            <div class="tun">-->
<#--                                <span class="tunbt">时光藏在校园的每个角落里</span>-->
<#--                                <span class="iconfont icon-weibo tuntb">&nbsp;微博</span>-->
<#--                            </div>-->
<#--                        </a>-->
<#--                        </li>-->
                    </ul>
                </div>
            </div>
            <div class="float1">
                <div class="jfooter"></div>
            </div>
            <div class="float2">
                <div class="zfooter">
                    <img src="images/logo.png" style="width: 220px;height: 65px;vertical-align: middle;" alt="">
                    <span class="diandi">
                    &nbsp;&nbsp;&nbsp;
                    <span class="iconfont icon-dianhua"></span>
                    电话: 0373-3040718&nbsp;&nbsp;&nbsp;
                    <span class="iconfont icon-dizhi"></span>
                    地址: 河南省新乡市华兰大道90号
                </span>
                    <div class="banquan">
                        <div class="xian"></div>
                        <span class="suoyou">
                        版权所有：畜牧兽医仿真实验中心&nbsp;&nbsp;&nbsp;
                        豫ICP备2021029424号-1
                    </span>
                    </div>
                    <div class="erweima">
                        <span><img src="./images/weixin.png" alt="" style="width: 180px;height: 180px;"></span>
                        欢迎关注河南科技学院公众号
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>