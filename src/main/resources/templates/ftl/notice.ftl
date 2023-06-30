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
                    <#list secondList as secondList>
                        <#if first.firstId == secondList.firstId>
                            ${secondList.url}
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

                        <#list secondList as secondList>
                            <#if first.firstId == secondList.firstId>
                                <li></li>
                                <li><a href="${secondList.url}">${secondList.secondTargetName}</a></li>
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
                            <li
                            <#if item1.secondTargetName == current.secondTargetName>
                                style="background-color: #337ab7"
                            </#if>

                            ><a href="${item1.url}">${item1.secondTargetName}</a></li>
                </#list>
<#--                <li style="border: 1px solid red"><a href="">${data.getFirstTarget()}</a></li>-->
            </ul>
        </div>
        <div class="right-lab col-lg-9 col-md-12">
            <h2>${data.getNoticeTitle()}</h2>
            <ul>
                <li class="linear"></li>
            </ul>
            <div class="neil">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    ${data.getNoticeContent()}
                    <br><br>
                <p style="text-align: right">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    ${data.getNoticeTime()}
                </p>


                    <p>
                        <ul style="list-style-type:none">
                            <li>附件【<a id="download-button" onclick="downloadFile()"> ${object.objectName} + ${object.htitle} </a>】</li>
                        </ul>
                    </p>

            </div>

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
<script>
    function downloadFile() {
        var htitle = "${object.htitle}"; // 替换为实际的 htitle 值
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/minioDownload?htitle='+ htitle, true);
        xhr.responseType = 'blob';
        xhr.onload = function() {
            if (this.status === 200) {
                var filename = '';
                var contentDisposition = this.getResponseHeader('content-disposition');
                if (contentDisposition && contentDisposition.indexOf('attachment') !== -1) {
                    filename = contentDisposition.split('fileName=')[1];
                }
                var blob = new Blob([this.response], { type: 'application/octet-stream' });
                var url = URL.createObjectURL(blob);

                var a = document.createElement('a');
                a.href = url;
                a.download = filename || 'download';
                a.target = '_self';
                document.body.appendChild(a);
                a.click();
                document.body.removeChild(a);

                URL.revokeObjectURL(url);
            }
        };
        xhr.setRequestHeader('Content-Type', 'application/octet-stream;charset=utf-8');
        xhr.setRequestHeader('Cache-Control', 'no-cache, no-store, max-age=0, must-revalidate');
        xhr.setRequestHeader('Expires', '0');
        xhr.setRequestHeader('Pragma', 'no-cache');
        xhr.send();
    }
</script>
</body>
</html>
