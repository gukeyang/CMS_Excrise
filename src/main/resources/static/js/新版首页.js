window.addEventListener('load', function () {
    var imgs = this.document.getElementsByClassName('img')
    var lis = this.document.getElementsByClassName('li')
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
    var list = document.querySelectorAll('.list');
    function accordion(e) {
        e.stopPropagation();
        if (this.classList.contains('active')) {
            this.classList.remove('active');
        } else
            if (this.parentElement.parentElement.classList.contains('active')) {
                this.classList.add('active');
            } else {
                for (i = 0; i < list.length; i++) {
                    list[i].classList.remove('active');
                }
                this.classList.add('active');
            }
    }
    for (i = 0; i < list.length; i++) {
        list[i].addEventListener('click', accordion);
    }
})
$(function () {
    $('#dowebok').fullpage({
        navigation: true,
        scrollingSpeed: 1000,
        verticalCentered: false
    });
});
