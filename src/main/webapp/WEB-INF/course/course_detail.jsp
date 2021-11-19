<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="EUC-KR">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>코스 상세페이지</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="drive_course_detail/blog.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
        <a class="link-secondary" href="#">뒤로 가기</a>
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" href="#">북악 스카이웨이</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="link-secondary" href="#" aria-label="Search">
        </a>
      </div>
    </div>
  </header>
</div>

<main class="container">
  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic">코스 사진</h1>
    </div>
  </div>

  <div class="row g-5">
    <div class="col-md-8">
      <article class="blog-post">
      <table class="table" align = "center">
          <tbody>
            <tr>
              <td>북악 스카이웨이</td>
              <td>#야경</td>
       		  <td>30분~1시간</td>
       		  <td>♥1999</td>
            </tr>
          </tbody>
        </table>
        <table class="table" align = "center">
          <tbody>
            <tr>
              <td>경로</td>
              <td>북악 스카이웨이</td>
            </tr>
            <tr>
              <td>지역</td>
              <td>서울 종로구 평창동</td>
            </tr>
            <tr>
              <td>코멘터리</td>
              <td>야경을 보며 데이트하기 좋은 곳</td>
            </tr>
            <tr>
              <td>주차할 만한 곳</td>
              <td>북악 팔각정 주차장</td>
            </tr>
          </tbody>
        </table>
      </article>
      <nav class="blog-pagination" aria-label="Pagination">
        <a class="btn btn-outline-primary" href="#">좋아요</a>
        <a class="btn btn-outline-primary" href="#">주변 갈만한 곳</a>
        <a class="btn btn-outline-primary" href="#">드라이브 음악 추천</a>
      </nav>
    </div>
  </div>
  
</main>
</body>
</html>