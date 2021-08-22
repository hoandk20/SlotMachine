/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function  help() {
    var r = document.getElementById("help");
    if (r.style.display == 'block') {
        r.style.display = 'none';
    } else {
        r.style.display = 'block';
    }
}
function load() {
    $.ajax({
        type: "POST",
        url: "../Play",
        success: function (data) {
            var r = document.getElementById("ajax");
            r.innerHTML = data;
        }
    });
}
function reset() {
    var conf = confirm("Do you want to reset your coin?");
    if (conf == false) {
        return;
    }
    document.getElementById("reset").submit();
}
var running = false;
function play() {
    if (running == true) {
        return;
    }
    running = true;
    var img = document.getElementById("machine");
    img.src = "img/Play.png";
    var spin1 = document.getElementById("spin1");
    var spin2 = document.getElementById("spin2");
    var spin3 = document.getElementById("spin3");
    var s = document.getElementById("num").innerHTML;
    if (s < 2) {
        alert("You are out!");
        return;
    }
    s = s - 2;
    document.getElementById("mes").innerHTML = "";
    spin1.style.display = 'block';
    spin2.style.display = 'block';
    spin3.style.display = 'block';
    setTimeout(stop, 2500);
    setTimeout(load, 2000);
    setTimeout(load1, 3000);

}
function load_btnReset() {
    var img = document.getElementById("btn-re");
    img.src = img.src = "img/re.png";
    load1();
}
function load1() {
    running = false;
    var img = document.getElementById("machine");
    img.src = "img/Normal.png";
}
function stop() {
    spin1.style.display = 'none';
    spin2.style.display = 'none';
    spin3.style.display = 'none';

}
function restart() {
    var r = document.getElementById("frm-re");
    var img = document.getElementById("btn-re");
    img.src = img.src = "img/re-press.png";
    r.submit();
}
function isAlphaOrParen(str) {
  return /^[a-zA-Z0-9() ]+$/.test(str);
}
function checkLogin() {
    var inputName = document.getElementById("name-inputLogin");
    if (inputName.value.trim().length == 0) {
        var name = document.getElementById("invalid-nameLogin");
        name.innerHTML = "Name Can not be blank!";
        name.style.display = 'block';
        return;
    }
    if (inputName.value.trim().length > 20 || inputName.value.length < 3) {
        var name = document.getElementById("invalid-nameLogin");
        name.innerHTML = "Name Too long or short!";
        name.style.display = 'block';
        return;
    }
    
    if (isAlphaOrParen(inputName.value))
    {
    } else {
        var name = document.getElementById("invalid-nameLogin");
        name.innerHTML = "Invalid Name!";
        name.style.display = 'block';
        return;
    }

    var play = document.getElementById("login");
    play.submit();
}


