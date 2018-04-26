var num = 0,
    result = 0,
    numshow = "0";
var operate = 0; //判断输入状态的标志 
var calcul = 0; //判断计算状态的标志 
var quit = 0; //防止重复按键的标志 
function run(num) {
    var c = document.getElementById("cc").value;
    c = (c != "0") ? ((operate == 0) ? c : "") : "";
    c = c + num;
    document.getElementById("cc").value = c;
    operate = 0; //重置输入状态 
    quit = 0; //重置防止重复按键的标志 
}

function dzero() {
    var c = document.getElementById("cc").value;
    c = (c != "0") ? ((operate == 0) ? c + "00" : "0") : "0"; //如果当前值不是"0"，且状态为0，则返回当str+"00"，否则返回"0"; 
    document.getElementById("cc").value = c;
    operate = 0;
}

function dot() {
    var c = document.getElementById("cc").value;
    c = (c != "0") ? ((operate == 0) ? c : "0") : "0"; //如果当前值不是"0"，且状态为0，则返回当前值，否则返回"0"; 
    for (i = 0; i <= c.length; i++) { //判断是否已经有一个点号 
        if (c.substr(i, 1) == ".")
            return false; //如果有则不再插入
    }
    c = c + ".";
    document.getElementById("cc").value = c;
    operate = 0;
}

function del() { //退格 
    var c = document.getElementById("cc").value;
    c = (c != "0") ? c : "";
    c = c.substring(0, c.length - 1);
    c = (c != "") ? c : "0";
    document.getElementById("cc").value = c;
}

function clearscreen() { //清除数据 
    num = 0;
    result = 0;
    numshow = "0";
    document.getElementById("cc").value = "0";
}

function plus() { //加法 
    calculate(); //调用计算函数 
    operate = 1; //更改输入状态 
    calcul = 1; //更改计算状态为加 
}

function minus() { //减法 
    calculate();
    operate = 1;
    calcul = 2;
}

function times() { //乘法 
    calculate();
    operate = 1;
    calcul = 3;
}

function divide() { //除法 
    calculate();
    operate = 1;
    calcul = 4;
}

function persent() { //求余 
    calculate();
    operate = 1;
    calcul = 5;
}

function equal() {
    calculate(); //等于 
    operate = 1;
    num = 0;
    result = 0;
    numshow = "0";
}

function calculate() {
    numshow = Number(document.getElementById("cc").value);
    if (num != 0 && quit != 1) { //判断前一个运算数是否为零以及防重复按键的状态 
        switch (calcul) { //判断要输入状态 
            case 1:
                result = num + numshow;
                break; //计算"+" 
            case 2:
                result = num - numshow;
                break; //计算"-" 
            case 3:
                result = num * numshow;
                break;
            case 4:
                if (numshow != "0") {
                    result = num / numshow;
                } else {
                    var xjx = '被除数不能为零！'
                    document.getElementById("cc").value = xjx;
                    setTimeout(clearnote, 4000)
                }
                break;
            case 5:
                result = num % numshow;
                break;
        }
        quit = 1; //避免重复按键 
    } else {
        result = numshow;
    }
    numshow = String(result);
    document.getElementById("cc").value = numshow;
    num = result; //存储当前值 
}

function clearnote() { //清空提示 
    document.getElementById("cc").value = "";
}