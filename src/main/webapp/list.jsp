<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<body>



	<table border=1 align=center>
		<tr>
			<th>ID
			<th>Name
			<th>Contact <c:forEach var="i" items="${list}">
					<tr>
						<td>${i.id}
						<td>${i.writer}
						<td>${i.message}
				</c:forEach>
		<tr>
			<td colspan=3 align=center>
				<form action='/update.message'>
					<input type=text placeholder='수정 할 대상 ID' name='updId'><br>
					<input type=text placeholder='이름' name='updWriter'><br>
					<input type=text placeholder='메세지' name='updMsg'><br>
					<button id='mod'>수정</button>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan=3 align=center>
				<form action='/delete.message'>
					<input type=text placeholder='삭제 할 대상 ID' name='delID' id='delID'>
					<button id='delbtn'>삭제</button>
				</form>
		<tr>
			<td colspan=3 align=center><a href="index.html">back</a>
	</table>


	<script>
   
   $("#delbtn").on("click",function() {
      let delID = $("#delID").val();
      location.href = "DeleteContact?del=" + delID;
   });
   
   document.getElementById("mod").onclick = function(){
         alert("수정이 완료되었습니다."); }

      
      
      
      
   </script>


</body>
</html>