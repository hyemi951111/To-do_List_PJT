<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#list1 .form-control {
	border-color: transparent;
}

#list1 .form-control:focus {
	border-color: transparent;
	box-shadow: none;
}

#list1 .select-input.form-control[readonly]:not([disabled]) {
	background-color: #fbfbfb;
}

.listcontent{
border: 0px !important;

}

.h1_class{
	font-weight: bold;
	margin-top: 30px;
    margin-bottom: 30px;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</head>
<body>
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card" id="list1" style="border-radius: .75rem; background-color: #eff1f2;">
          <div class="card-body py-4 px-4 px-md-5" >
          <div class="d-flex justify-content-between align-items-center">
              <h1 class="h1_class" style="text-align: center;">To-do list</h1>
            	<div class="form-group text-right" >
					<h5> ${user_id}님 반갑습니다.</h5>
					<a href="${root}user/logout"><button type="button" class="btn btn-sm btn-danger">로그아웃</button></a>
				</div>
			</div>
            <div class="pb-2">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-row align-items-center">
				    <%-- todo-list 작성 --%>
				    <form action="${root}todo/addTodo?user_key=${user_key}" method="post" class="d-flex flex-row" style="width: 100%;">
				        <input type="text" class="form-control form-control-lg" id="exampleFormControlInput1"
				               placeholder="할 일을 작성해 주세요." name="todo_content" style="flex: 5; margin-right: 10px;"/>
				        <input type="date" name="end_time" style="flex: 1; margin-right: 10px;">
				        <button type="submit" class="btn btn-primary" style="flex: 1;">등록</button>
				    </form>
				</div>
                </div>
              </div>
            </div>

            <hr class="my-4">

            <div class="d-flex justify-content-between align-items-center mb-4 pt-2 pb-3">
			    <div>
			        <h4>총 ${totalNumber}건</h4>
			    </div>
			    <div> <!-- 추가된 클래스 ms-2 -->
			        <%--검색 --%>
			        <form:form action="${root}todo/statusSearch?user_id=${user_id}&user_key=${user_key}" method="post" modelAttribute="searchBean" class="d-flex align-items-center">
			            <form:select path="todo_status" class="form-select">
			                <form:option value="모두" />
			                <form:option value="진행중" />
			                <form:option value="완료" />
			            </form:select>
			            <button type="submit" class="btn btn-primary col-auto" >검색</button>
			        </form:form>
			    </div>
			</div>

            <div class="col-lg-12 col-md-8 mx-auto d-flex flex-column justify-content-center align-items-center">
		      <div class="table small" style="width: 100%;">
				<table class="table table-striped table-sm">
		          <thead>
					<tr>
						<th class="col-1 course_th" scope="col">구분</th>
						<th class="col-4 course_th" scope="col">할일</th>
						<th class="col-2 course_th" scope="col">시작시간</th>
						<th class="col-2 course_th" scope="col">마감시간</th>
						<th class="col-1 course_th" scope="col">상태</th>
						<th class="col-1 course_th" scope="col">변경</th>
						<th class="col-1 course_th" scope="col">삭제</th>
					</tr>
				 </thead>
		          <tbody>
		          <%--form태그 라이브러리 이용하여 수정 --%>
		          	<c:forEach var="todo" items="${todoList}">
		          		<form:form action="${root}todo/todoList_modify?user_key=${user_key}" method="post" modelAttribute="todoModifyBean">
				            <tr>
				              <td class="col-1 center-text listcontent"><form:input path="todo_key" value="${todo.todo_key}"/></td>
				              <td class="col-4 center-text listcontent"><form:input path="todo_content" value="${todo.todo_content}"/></td>
				              <td class="col-2 center-text listcontent"><form:input path="start_time" value="${todo.start_time}"/></td>
				              <td class="col-2 center-text listcontent"><form:input path="end_time" value="${todo.end_time}"/></td>
				              <td class="col-1 center-text listcontent">
				              	<form:select path="todo_status">
				              		<c:choose>
					              		<c:when test="${todo.todo_status == '진행중'}">
					              			<option value="진행중" selected>진행중</option>
					              			<option value="완료">완료</option>
					              		</c:when>
					              		<c:otherwise>
					              			<option value="완료" selected>완료</option>
					              			<option value="진행중">진행중</option>
					              		</c:otherwise>
				              		</c:choose>
				              	</form:select>
				              </td>
				              <td class="col-1 center-text">
				              	<form:button class="btn btn-sm btn-secondary">수정</form:button>
				              </td>
				              <td class="col-1 center-text">
				              	<a href="${root}todo/deleteTodo?todo_key=${todo.todo_key}&user_key=${user_key}"><button type="button" class="btn btn-sm btn-secondary">삭제</button></a>
				              </td>
				              <!-- Modal -->
				            </tr>
			            </form:form>
			         </c:forEach>
		          </tbody>
		        </table>
		      </div>
	      </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>