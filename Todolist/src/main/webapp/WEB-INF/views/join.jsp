<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로고 클릭 시 메인페이지로 가야하는데 절대경로를 동적으로 지정해주기 위해 url 설정 -->
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
   function checkUserIdExist(){
      /* #은 특정 HTML요소의 id값을 선택하는 jQuery 문법 */
      var user_id = $("#user_id").val()
      
      if(user_id.length == 0){
         alert("아이디를 입력해주세요")
         return
      }
      
      /* 서버에 비동기적으로 요청을 보내는 ajax통신 */
      $.ajax({
         url : "${root}checkUserIdExist/" + user_id,
         type : "get",
         /* 서버에서 반환되는 데이터 타입을 text로 지정함 */
         dataType : "text",
         /* 서버에서 성공적으로 응답을 받았을 시 실행됨 */
         success : function(result){
            /* trim()은 문자열의 양쪽 끝에있는 공백을 제거함 */
            if(result.trim() == "true"){
               alert("사용할 수 있는 아이디입니다.")
               $("#userIdExist").val(true)
            } else{
               alert("사용할 수 없는 아이디입니다.")
               $("#userIdExist").val(false)
            }
         }
      })
   }
   
   function resetUserIdExist(){
      $("#userIdExist").val("false")
   }
</script>
</head>
<body>

<div class="container" style="margin-top:100px">
   <div class="row">
      <div class="col-sm-3"></div>
      <div class="col-sm-6">
         <div class="card shadow">
            <div class="card-body">
               <form:form action="${root }user/joinPro" method="post" modelAttribute="joinUserBean">
                  <form:hidden path="userIdExist"/>
                  <div class="form-group">
                     <form:label path="user_id">아이디</form:label>
                     <div class="input-group">
                        <form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
                        <div class="input-group-append">
                           <button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</button>
                        </div>
                     </div>
                  </div>
                  <div class="form-group">
                     <form:label path="user_pw">비밀번호</form:label>
                     <form:password path="user_pw" class="form-control"/>
                  </div>
                  <div class="form-group">
                     <div class="text-right">
                        <form:button class="btn-primary">회원가입</form:button>
                     </div>
                  </div>
               </form:form>
            </div>
         </div>
      </div>
      <div class="col-sm-3"></div>
   </div>
</div>

</body>
</html>







