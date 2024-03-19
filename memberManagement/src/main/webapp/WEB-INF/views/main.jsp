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

        body {
            font-family: Arial, sans-serif; 
            margin: 0;
            padding: 20px;
        }

        h1, h3, h4 {
            color: #333;
            font-size: 2em;
            font-weight: bold;
            margin-top: 0;
        }

        table {
            width: 80%; 
            border-collapse: collapse;
            margin: 20px auto; 
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        td {
            font-size: 0.9em;
        }

        th {
            background-color: #e0e0e0;
            font-weight: bold;
            font-size: 1em;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        a {
            color: #007bff; 
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 0.9em;
            font-weight: normal;
        }

        form div {
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 200px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
        }
    
</style>



<h3>전체 회원 수 : ${fn:length(memberList)}명</h3>
 <form action="/MM/search" method="get">
 <h1>회원 검색</h1>
        <select name="searchType">
            <option value="MEMBER_NO">회원 번호</option>
            <option value="MEMBER_NAME">회원명</option>
            <option value="GRADE_NAME">등급명</option>
        </select>
        <input type="text" name="keyword">
        <button type="submit">검색</button>
    </form>
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
    <c:forEach items="${searchList}" var="member">
      <tr>
        <td>${member.memberNo}</td>
        <td>${member.memberName}</td>
        <td>${member.gradeName}</td>
        <td><a href="/MM/delete?memberNo=${member.memberNo}"><button>삭제</button></a></td>
        <td><button onclick="updateMember('${member.memberNo}')">수정</button></td>
      </tr>
    </c:forEach>
  </tbody>
</table>




<h3>회원 목록</h3>
<table border="1" style="border-collapse: collapse;">
  <thead>
    <tr>
      <th>회원 번호<span onclick="asc('MEMBER_NO')">🔼</span><span onclick="desc('MEMBER_NO')">🔽</span></th>
      <th>회원명<span onclick="asc('MEMBER_NAME')">🔼</span><span onclick="desc('MEMBER_NAME')">🔽</span></th>
      <th>등급명<span onclick="asc('GRADE_NAME')">🔼</span><span onclick="desc('GRADE_NAME')">🔽</span></th>
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
        <td><button onclick="updateMember('${member.memberNo}')">수정</button></td>
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



  <script src="/resources/js/main.js"></script>

</body>
</html>