<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginId" value ="${sessionScope.id}"/>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
</head>
<body>
<%--@GetMapping("/login")--%>
<%--public String loginForm(){--%>
<%--return "LoginForm";--%>
<%--}--%>

<div class="w3-top">
  <div class="w3-bar w3-red w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href = "/" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">홈</a>
    <a href = "/register/add"class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">회원가입</a>
    <a href = "/boardList2"class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" name = "board">게시판</a>
    <%if(session.getAttribute("id") == null) {%>
    <a href = "/loginform" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" name="login">로그인</a>
	<%} else { %>
	<a href = "/logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">로그아웃</a>
	<%} %>
  
  </div>

</div>
<script>
    $(document).ready(function (){

        $('[name="board"]').on("click",function(){
            let loginId = '${loginId}'
          if(loginId == null || loginId == ""){
              alert("로그인을 먼저 해주세요");
          }

        })
    })
</script>
</body>
</html>

