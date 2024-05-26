<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="cssMain.css">
<meta charset="UTF-8">
<title>인하공업전문대학 컴퓨터정보공학과</title>
</head>
<body>
    <h2 class="btn-dark">인하공업전문대학 컴퓨터정보공학과 미니 페이지</h2>

    <form id="categoryForm" action="board" method="post">
        <input type="hidden" id="boardCategory" name="boardCategory" value="">

        <div class="dropdown">
            <button type="button" class="btn btn-dark btn-pad">
                <span class="dropbtn_icon"></span> 학과안내
            </button>
            <div class="dropdown-content">
                <button type="button" onclick="submitForm('deptinfo')">학과소개</button>
                <button type="button" onclick="submitForm('depthistory')">학과연혁</button>
            </div>
        </div>

        <div class="dropdown">
            <button type="button" class="btn btn-dark btn-pad">
                <span class="dropbtn_icon"></span> 교과과정
            </button>
            <div class="dropdown-content">
                <button type="button" onclick="submitForm('1grade')">1학년</button>
                <button type="button" onclick="submitForm('2grade')">2학년</button>
                <button type="button" onclick="submitForm('3grade')">3학년</button>
                <button type="button" onclick="submitForm('4grade')">전공심화</button>
            </div>
        </div>

        <div class="dropdown">
            <button type="button" class="btn btn-dark btn-pad">
                <span class="dropbtn_icon"></span> 커뮤니티
            </button>
            <div class="dropdown-content">
                <button type="button" onclick="submitForm('notice')">공지사항</button>
                <button type="button" onclick="submitForm('faq')">FAQ</button>
                <button type="button" onclick="submitForm('free')">자유게시판</button>
            </div>
        </div>

        <div class="dropdown">
            <button type="button" class="btn btn-dark btn-pad" onclick="submitForm('location')">
                <span class="dropbtn_icon"></span> 오시는 길
            </button>
        </div>
    </form>

    <script>
        function submitForm(category) {
            document.getElementById('boardCategory').value = category;
            document.getElementById('categoryForm').submit();
        }
    </script>
    
    
</body>
</html>
