<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 관리</title>
</head>
<body>
<style>
  table {
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #ddd;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
  }
  th {
    background-color: #f2f2f2;
  }
  a {
    color: #000;
    text-decoration: none;
  }
</style>

<h1>메인 화면</h1>

<h3>전체 회원 수 : ${fn:length(memberList)}명</h3>

<table border="1" style="border-collapse: collapse;">
  <thead>
    <tr>
      <th>회원 번호</th>
      <th>회원명</th>
      <th>등급명</th>
      <th>삭제</th>
      <th>수정</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${memberList}" var="member">
      <tr>
        <td>${member.memberNo}</td>
        <td>${member.memberName}</td>
        <td>${member.gradeName}</td>
        <td><a href="/MM/delete?memberNo=${member.memberNo}"><button>삭제</button></a></td>
        <td><a href="/MM/update?memberNo=${member.memberNo}"><button>수정</button></a></td>
      </tr>

    </c:forEach>
  </tbody>
</table>

<form action="/MM/add" method="get">
    <h4>회원 추가</h4>
    <div>
    회원 번호 : <input type="text" name="memberNo">
    </div>
    <div>
    회원명 : <input type="text" name="memberName">
    </div>
    <div>
    회원 등급 : <input type="text" name="gradeName">
    </div>
    <button>추가</button>
</form>

    <c:if test="${not empty message}" >
    <script>
    alert("${message}");
    </script>
    <c:remove var="message"/>
    </c:if>


</body>
</html>