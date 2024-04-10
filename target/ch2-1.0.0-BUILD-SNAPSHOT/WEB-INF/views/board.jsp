<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>


<%--
  Created by IntelliJ IDEA.
  User: gominjeong
  Date: 4/4/24
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>


<html>
<head>
    <style>
        #fhead{

        }
        #fbody{
            top: 200px;
            left: 30px;
            position: relative;

        }
    </style>
    <div id = "fhead">
    <jsp:include page="Sub.jsp"></jsp:include>
    <title>게시물 읽기</title>
    </div>
</head>
<body>
    <div id = "fbody">
        <h2>게시물 ${mode=="new"?"글쓰기":"읽기"}</h2>
    <form action="" id="form">
<%--        <input type ="text" name="bno" value="${boardDto.bno}" readonly/><br>--%>
        <input type = "text" name = "title" value = "${boardDto.title}" ${mode =="new"?'':'readonly'}/><br>
        <textarea name="content" id="" cols="30" rows="10"${mode =="new"?"":"readonly='readonly'"}>${boardDto.content}</textarea><br>
        <c:if test="${mode eq 'new'}">
        <button type="button" id="writeBtn" class="btn" >등록</button></a>
        </c:if>
        <c:if test = "${boardDto.writer eq loginId}">
        <button type="button" id="modifyBtn" class="btn">수정</button>
        <a href="${pageContext.request.contextPath}/remove?bno=${boardDto.bno}"><button type="button" id="removeBtn" class="btn">삭제</button></a>
        </c:if>
        <button type="button" id="listBtn" class="btn" >목록</button>
    </form>
    </div>
<script>
    $(document).ready(function(){
        $('#writeBtn').on("click",function(){
            let form = $('#form');
            form.attr("action","<c:url value='write'/>");
            form.attr("method","post");
            form.submit();
        })

        let msg = "${msg}";
        if(msg == "WRT_ERR")alert("게시글 등록에 실패했습니다.")



        <%--$('#modifyBtn').on("click",function (){--%>
        <%--    let form = $('#form');--%>
        <%--    let isReadonly = $("input[name ='title']").attr('readonly');--%>

        <%--    if(isReadonly =='readonly'){--%>

        <%--        $("input[name='title'],textarea[name='content']").attr('readonly',false);--%>
        <%--         alert("수정모드로 전환되었습니다.")--%>
        <%--        $(this).text("저장")--%>
        <%--        return;--%>
        <%--    }--%>

        <%--    form.attr("action","<c:url value='modify'/>");--%>
        <%--    form.attr("method","post");--%>
        <%--    form.submit();--%>


        <%--})--%>


        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');

            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/modify?bno=${boardDto.bno}'/>");
            form.attr("method", "post");

            form.submit();
        });
        $('#listBtn').on("click",function(){
            window.location.href = "<c:url value='boardList2'/>"; // 목록 페이지로 이동
        });

    });




</script>
</body>
</html>
