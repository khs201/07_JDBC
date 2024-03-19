<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 페이지</title>
</head>
<body>
    
    <h3>회원 가입 페이지 화아악인</h3>
    <form action="/MM/add" method="get">

        <div>
        회원 번호 : <input type="text" name="memberNo">
        </div>
        <div>
        회원명 : <input type="text" name="memberName">
        </div>
        <div>
        회원 등급 : <input type="text" name="gradeName">
        </div>
        <button>가입</button>
    </form>

</body>
</html>