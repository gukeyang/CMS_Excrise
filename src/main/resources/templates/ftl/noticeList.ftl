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
    <style>
        #next-page,#prev-page{
            width: 65px;
            height: 25px;
            border: none;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 12px;
        }
        .pagenum{
            border: none;
            width: 25px;
            height: 25px;
            margin-left: 5px;
        }
        .pagenum:hover{
            background-color: skyblue;
        }
        .current-page{
            background-color: #337ab7;
        }
        .boxparent{
            width: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #pagination{   //好了
        width: auto;
            display: flex;
        }
    </style>

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

        <div class="right-lab col-lg-9 col-md-12" style="position: relative" id="notices">
            <h2>文章列表</h2>
            <ul>
                <li class="linear"></li>
            </ul>
<#--            <#assign length = 0 />-->
            <ul class="li" id="notices-list">
                     <#list notices1 as notices1>
                         <#if notices1.firstTarget == currentTargetName>
                            <li>
                                 <a href="${notices1.htmlUrl}"> ${notices1.noticeTitle}</a>
                                 <a href="${notices1.htmlUrl}" ><div style="text-align: right;"> ${notices1.noticeTime} </div></a>
                            </li>
<#--                             <#assign length = length + 1 />-->
                        </#if>
                     </#list>
            </ul>
            <div style="position: absolute; left: 50%; transform: translateX(-50%)" class="boxparent">
                <button class="page-btn" id="prev-page">&laquo; 上一页</button>
                <span id="pagination"></span>
                <span id="total-count"></span>
            </div>
        </div>
    </div>
</div>

<div class="rooter" style="margin-top: 20px">
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

<script>
    var itemsPerPage = 9; // 每页显示的数量
    var currentPage = 1; // 当前页数
    var notices = [
        <#list notices1 as notices1>
        <#if notices1.firstTarget == currentTargetName>
        {
            htmlUrl: "${notices1.htmlUrl}",
            noticeTitle: "${notices1.noticeTitle}",
            noticeTime: "${notices1.noticeTime}"
        },
        </#if>
        </#list>
    ];
    var totalNotices = notices.length; // 公告总数量
    var totalPages = Math.ceil(totalNotices / itemsPerPage); // 计算总页数
    function getPageItems(currentPage, itemsPerPage, notices) {
        var startIndex = (currentPage - 1) * itemsPerPage;
        var endIndex = Math.min(startIndex + itemsPerPage, totalNotices);
        return notices.slice(startIndex, endIndex);
    }
    //渲染下方页面导航
    function renderPagination(currentPage, totalPages) {
        var pagination = document.getElementById("pagination");
        console.log(pagination);
        var pages = "";
        if (totalPages > 1) {
            if (currentPage > 1) {
                pages +=
                    '<button class="page-btn" id="prev-page">&laquo; 上一页</button>';
            }
            for (var i = 1; i <= totalPages; i++) {
                if (i === currentPage) {
                    pages +=
                        '<button class="page-btn pagenum current-page" id="page-' +
                        i +
                        '">' +
                        i +
                        "</button>";
                } else {
                    pages +=
                        '<button class="page-btn pagenum" id="page-' + i + '">' + i + "</button>";
                }
            }
            if (currentPage < totalPages) {
                pages +=
                    '<button class="page-btn" id="next-page">下一页 &raquo;</button>';
            }
        }
        pagination.innerHTML = pages;
        // 绑定点击事件
        var pageBtns = document.querySelectorAll(".page-btn");
        for (var i = 0; i < pageBtns.length; i++) {
            pageBtns[i].addEventListener("click", function (event) {
                var targetPageNum = 0;
                if (event.target.id === "prev-page") {
                    targetPageNum = currentPage - 1;
                    currentPage--;
                    if(currentPage < 1) currentPage = 1;

                } else if (event.target.id === "next-page") {
                    currentPage++;
                    targetPageNum = currentPage + 1;
                    if(currentPage > totalPages ){
                        currentPage = totalPages;
                    }

                } else {
                    currentPage = parseInt(event.target.id.split("-")[1]);
                }
                renderNotices(
                    getPageItems(currentPage, itemsPerPage, notices)
                );
                //更新下方按钮数据
                renderButton(currentPage);
            });
        }
    }
    //渲染主体部分，
    function renderNotices(items) {
        var noticesList = document.getElementById("notices-list");
        var listItems = "";
        for (var i = 0; i < items.length; i++) {
            listItems +=
                '<li><a href="' +
                items[i].htmlUrl +
                '">' +
                items[i].noticeTitle +
                '</a><div style="text-align: right;">' +
                items[i].noticeTime +
                "</div></li>";
        }
        noticesList.innerHTML = listItems;
        var totalCount = document.getElementById("total-count");
        totalCount.innerHTML = "共" + totalNotices + "条";
        if(totalPages<=1){
            var prevPageButton = document.getElementById("prev-page");
            prevPageButton.style.display = "none"; // 当前页为1时隐藏上一页按钮
            var nextPageButton = document.getElementById("next-page");
            nextPageButton.style.display = "none"; // 当前页为最后一页时隐藏下一页按钮
        }
        renderPagination(currentPage, totalPages);
    }


    //初始化渲染
    renderNotices(getPageItems(currentPage, itemsPerPage, notices));
    //修改下方按钮的显示于掩藏
    function renderButton(page){
        console.log(page,totalPages);
        var prevPageButton = document.getElementById("prev-page");
        if (page === 1) {

            var prevPageButton = document.getElementById("prev-page");
            prevPageButton.style.display = "none"; // 当前页为1时隐藏上一页按钮
        } else {
            var prevPageButton = document.getElementById("prev-page");
            prevPageButton.style.display = "inline-block"; // 当前页不为1时显示上一页按钮
        }
        //判断是否显示下一页按钮
        var nextPageButton = document.getElementById("next-page");
        if (page >= totalPages) {

            var nextPageButton = document.getElementById("next-page");
            nextPageButton.style.display = "none"; // 当前页为最后一页时隐藏下一页按钮
        } else {
            var nextPageButton = document.getElementById("next-page");
            nextPageButton.style.display = "inline-block"; // 当前页不为最后一页时显示下一页按钮
        };
        if(totalPages <=1){
            var prevPageButton = document.getElementById("prev-page");
            prevPageButton.style.display = "none"; // 当前页为1时隐藏上一页按钮
            var nextPageButton = document.getElementById("next-page");
            nextPageButton.style.display = "none"; // 当前页为最后一页时隐藏下一页按钮
        }
    }

</script>


</body>
</html>