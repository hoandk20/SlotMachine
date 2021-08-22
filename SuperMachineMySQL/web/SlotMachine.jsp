<%-- 
    Document   : SlotMachine
    Created on : Aug 7, 2021, 4:01:59 PM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
            <span class="name" id="name">Name: ${cookie.name.getValue()}</span>
            
            <a onclick="reset()" class="re"><img id="btn-re"src="img/re.png" alt=""/></a>
            <form id="reset" method="Post" action="Reset"></form>
            <div class="fruits">             
                <div class="ajax" id="ajax">       
                    <div class="cash"><lable class="number" id="num" style=""> ${cookie.coin.getValue()} </lable><img class="coinx" src="img/coinx.png"alt=""/></div>
                    <img class="img1" src="img/${n1}" alt=""/>
                    <img class="img2" src="img/${n2}" alt=""/>
                    <img class="img3" src="img/${n3}" alt=""/>
                    <lable class="message" id="mes">Welcome</lable>
                </div>  

                <lable class="spin1" id="spin1">
                    <a class="show">
                        <div class="img-run" >
                            <div class="img-r"><img  src="img/Banana.png" alt=""/></div>
                            <div class="img-r"><img src="img/apple.png" alt=""/></div>
                            <div class="img-r"> <img  src="img/avocado.png" alt=""/></div>
                            <div class="img-r"> <img src="img/cherry.png" alt=""/></div>
                            <div class="img-r"><img  src="img/lemon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/megalon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/peach.png" alt=""/></div>
                            <div class="img-r"><img  src="img/pineapple.png" alt=""/></div>
                            <div class="img-r"><img  src="img/coconut.png" alt=""/></div>
                            <div class="img-r"><img  src="img/strawberry.png" alt=""/></div>
                        </div>
                    </a>
                </lable>
                <lable class="spin2" id="spin2">
                    <a class="show">
                        <div class="img-run">
                            <div class="img-r"><img  src="img/Banana.png" alt=""/></div>
                            <div class="img-r"><img src="img/apple.png" alt=""/></div>
                            <div class="img-r"> <img  src="img/avocado.png" alt=""/></div>
                            <div class="img-r"> <img src="img/cherry.png" alt=""/></div>
                            <div class="img-r"><img  src="img/lemon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/megalon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/peach.png" alt=""/></div>
                            <div class="img-r"><img  src="img/pineapple.png" alt=""/></div>
                            <div class="img-r"><img  src="img/coconut.png" alt=""/></div>
                            <div class="img-r"><img  src="img/strawberry.png" alt=""/></div>
                        </div>
                    </a>
                </lable>
                <lable class="spin3" id="spin3">
                    <a class="show">
                        <div class="img-run">
                            <div class="img-r"><img  src="img/Banana.png" alt=""/></div>
                            <div class="img-r"><img src="img/apple.png" alt=""/></div>
                            <div class="img-r"> <img  src="img/avocado.png" alt=""/></div>
                            <div class="img-r"> <img src="img/cherry.png" alt=""/></div>
                            <div class="img-r"><img  src="img/lemon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/megalon.png" alt=""/></div>
                            <div class="img-r"><img  src="img/peach.png" alt=""/></div>
                            <div class="img-r"><img  src="img/pineapple.png" alt=""/></div>
                            <div class="img-r"><img  src="img/coconut.png" alt=""/></div>
                            <div class="img-r"><img  src="img/strawberry.png" alt=""/></div>
                        </div>
                    </a>
                </lable>
                <button  class="btn-play" type="submit" value=""  onclick="play()">
            </div>
            <img class="machine" id="machine" style="width: 1071px;height: auto;padding-right: 100px;" src="img/Normal.png" alt=""/> 
            <div class="footer">
                <a href="https://www.facebook.com/hoandk20" target="_blank"><img class="fb" src="img/fb.png" alt=""/></a>
                <div class="cre">Cre: hoandk</div>      
                <div class="cre" >Contact: </div> 
            </div>
        </div>
        <div class="description">
            <a class="how" href="#" onclick="help()">HOW IT WORK?</a><br>
            <lable class="help" id="help">
                - You will start with 100<img class="coin1" src="img/coinx.png"alt=""/>.<br>
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
                    <th class="tb-coin">Highest Coin</th>
                    <th class="tb-cmt">Description</th>
                </tr>
                <c:forEach items="${requestScope.listPlayer}" var="c">
                    <tr>
                        <td class="tb-name" >${c.name}</td>
                        <td class="tb-coin">${c.coin}</td>
                        <td class="tb-cmt">${c.comment}</td>
                    </tr>
                </c:forEach>


            </table>
        </div>

        <script>
        </script>

    </body>

</html>
