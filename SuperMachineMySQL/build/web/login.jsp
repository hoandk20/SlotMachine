<%-- 
    Document   : SlotMachine
    Created on : Aug 7, 2021, 4:01:59 PM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="img/coinx.png"></link>
        <script src="js/ajax.googleapis.com_ajax_libs_jquery_3.5.1_jquery.min.js" type="text/javascript"></script>
        <script src="js/js.js" type="text/javascript"></script>
        <link href="css/css.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple slot machine</title>
    </head>
    <body>


        <div class="Container"> 
            <a onclick="" class="re"><img id="btn-re"src="img/re.png" alt=""/></a>
            <img class="machine" id="machine" style="width: 1071px;height: auto;padding-right: 100px;" src="img/Normal.png" alt=""/> 
            <div class="footer">
                <a href="https://www.facebook.com/hoandk20" target="_blank"><img class="fb" src="img/fb.png" alt=""/></a>
                <div class="cre">Cre: hoandk</div>      
                <div class="cre" >Contact: </div> 
            </div>
        </div>

        <div class="login"> 
            <button class="btn-login" onclick="checkLogin()">Play</button><br>
            <form action="Login" method="POST" id="login">
                <p>Login<br>
                    Name: <input type="text" name="name" id="name-inputLogin" >
                    <span  id="invalid-nameLogin" style="color: red;font-family: monospace;display: none;">asdasd</span>
                    <a style="color: red;">${mess}</a>
                </p> 
            </form>

        </div>      
        <div class="description">
            <a class="how" href="#" onclick="help()">HOW IT WORK?</a><br>
            <lable class="help" id="help">
                - You will start with 300<img class="coin1" src="img/coinx.png"alt=""/>.<br>
                - Each time pull the Lever you will spend 2<img class="coin1" src="img/coinx.png"alt=""/> to play the game.<br>
                - If there are two same fruits, you get a small win (get 8 <img class="coin1" src="img/coinx.png"alt=""/>). <br>
                - If you get three same fruits, you will get a big prize(200 <img class="coin1" src="img/coinx.png"alt=""/>)<br>
                Note: number of coin  reach to 0, game is over. <br>
                Other: you can reset your coin=100 by click on "re" button
            </lable>


            <table class="rank">
                <div class="titleRank">Rank</div>
                <tr>
                    <th class="tb-name">_____Name_____</th>
                    <th class="tb-coin">Coin</th>
                    <th class="tb-cmt">Description</th>
                </tr>



            </table>
        </div>

        <script>
        </script>

    </body>

</html>
