<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<c:set var="loginId" value ="${sessionScope.id}"/>--%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<jsp:include page="Sub.jsp"></jsp:include>
<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">홈페이지 화면입니다...</h1>
 
  <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top">Get Started</button>
</header>


<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}



  <%--var loginId = "<c:out value='${loginId}'/>";--%>

  <%--if(loginId ==null || loginId == ""){--%>
  <%--  alert("로그인을 먼저 해줴요");--%>
  <%--}--%>

</script>

</body>
</html>
	

    