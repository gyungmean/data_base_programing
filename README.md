# 드라이브 코스 추천 서비스
**2021-2학기 데이터베이스프로그래밍 팀프로젝트**  
  
**:computer:DBDEEP**  
김경민:heart: https://github.com/gyungmean  
구진희:purple_heart: https://github.com/rnkwg  
서채연:yellow_heart: https://github.com/chaney1475  
이예림:blue_heart: https://github.com/yerimm99  

## 1. 프로젝트의 목적 및 용도
**코로나 시대의 바람직한 외부활동으로 떠오르고 있는 드라이브! :car:  
드라이브를 가고 싶지만 어디로 가야할지 모를 때, 시간이 얼마나 걸릴지 모를 때, 원하는 드라이브 테마가 있을때  
적절한 드라이브 코스를 추천받기 위한 서비스를 만들었습니다.**

- 드라이브 코스를 찾을때의 문제점
 	- 원하는 조건의 드라이브코스를 찾을면 포털사이트에 검색해서 따로따로 찾아야하는 불편함
	- 드라이브 코스만을 전문적으로 검색할 수 있는 플랫폼이 없음 
	- 드라이브에 필수적인 음악 플레이리스트까지 추천해 줄 수 있는 플랫폼이 없음
	- 드라이브 코스에 관심있는 사람들끼리 모일 수 있는 커뮤니티가 없음

- 차별화된 우리 프로젝트
	- 지역/테마/소요시간 별 조건으로 원하는 드라이브코스를 매칭받을 수 있다.
	- 드라이브를 하면서 즐길 수 있는 컨텐츠(음악 플레이리스트, 맛집)를 함께 볼 수 있다.

## 2. 사용한 기술스택

<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/EclipseIDE-2C2255?style=for-the-badge&logo=eclipseIDE&logoColor=white"/>
<img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"/>  
![Generic badge](http://img.shields.io/badge/ERWIN-509EE3?style=for-the-badge)
![Generic badge](http://img.shields.io/badge/mybatis-red?style=for-the-badge)  
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"/>
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=black"/>  
<img src="https://img.shields.io/badge/googlemeet-00897B?style=for-the-badge&logo=googlemeet&logoColor=white"/>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/>


## 3. 주요기능
###  :white_check_mark:메인화면
- 회원가입
  - 회원가입시 이메일, 닉네임, 비밀번호를 입력받습니다. *(RegisterUserController.java)*
  - 회원가입 완료시 선호 키워드(지역, 테마)를 선택할 수 있습니다. *(KeywordUserController.java)*

- 로그인/로그아웃
  - 이메일과 비밀번호를 입력하여 로그인합니다. *(LoginController.java)*
  - 로그아웃 버튼으로 로그아웃 할 수 있습니다. *(LogoutController.java)*

- 마이페이지 *(MyPageController.java)*
  - 로그인시 오른쪽 상단에 마이페이지로 이동할 수 있는 버튼이 나타납니다.
  - 회원정보 : 닉네임과 이메일을 출력 / 닉네임을 수정할 수 있습니다.
  - 선호키워드 : 가입시 선택한 선호키워드를 볼 수 있습니다. 선호키워드를 수정할 수 있습니다.
  - 좋아요 한 코스 : 좋아요를 누른 코스들을 모아서 볼 수 있습니다.
  - 내가 작성한 글 : 내가 작성한 드라이브 코스와 내가 작성한 맛집 게시물을 볼 수 있습니다.

###  :white_check_mark:드라이브 코스 추천 *(MatchCourseController.java)*
- 로그인하지 않았을 때 : 코스 아이디 순으로 전체 코스를 보여줍니다
- 로그인 했을 때 : 사용자가 선호한 지역, 테마에 해당하는 코스를 먼저 상단에 노출 후, 전체 코스를 보여줍니다. 
- 키워드(시간, 지역, 테마)를 선택하면, 해당하는 코스를 보여줍니다. 
- 코스를 클릭하면 코스의 자세한 정보 페이지로 이동합니다. *(ViewCourseController.java)*
	- 코스사진, 코스이름, 테마, 소요시간, 좋아요수, 경로, 지역, 주차가능여부를 볼 수 있습니다.
	- 좋아요 버튼 : 
	  - 로그인하지 않았을때 : 로그인 화면으로 이동합니다.
	  - 로그인 했을때 : ‘좋아요’ 한 코스를 사용자의 마이페이지에서 확인할 수 있습니다. *(LikeCourseController)*
	- 주변 갈만한 곳 : 해당 코스 주변의 맛집을 볼 수 있는 게시판의 게시글 목록으로 이동합니다. *(MoveCourseController)*

###  :white_check_mark:베스트 드라이브 코스 순위 *(RankCourseController.java)*
- 코스이름으로 검색할 수 있는 검색창이 상단에 있습니다.
- 좋아요 수에 따른 코스 랭킹을 보여줍니다.

###  :white_check_mark:드라이브 코스 입력 *(CreateCourseController.java)*
- 로그인하지 않은 상태로 메뉴를 클릭하면 로그인화면으로 이동합니다.
- 코스이름, 출발지, 경유지, 도착지, 주차장소 존재 여부, 시간, 지역, 테마, 사진url(인터넷상에 업로드 되어 있는 사진 url)을 입력받습니다.
- 필수 요소(코스 이름, 시간, 지역, 테마)를 입력해야 합니다.
- 코스 입력이 완료 된 후 코스의 자세한 정보를 보여주는 페이지로 이동합니다. *(ViewCourseController.java)*

###  :white_check_mark:드라이브 플레이리스트 추천
- 사용자들이 등록한 유튜브 음악 플레이 리스트를 볼 수 있습니다. *(ListMusicController.java)*
- 음악의 테마를 검색하면 해당하는 음악 플레이리스트를 보여줍니다. *(FindMusicController.java)*
- 뮤직리스트 이름, url, tag(#해시태그 사용)을 입력받습니다. *(AddMusicController.java)*

###  :white_check_mark:드라이브 코스 주변 핫플
- 최신글부터 차례대로 전체 목록을 보여줍니다. *(ListCommentsController.java)*
- 해당 게시물과 연결된 코스로 이동할 수 있는 버튼이 있습니다. *(MoveCommentsController.java)*
- 게시물을 클릭시 게시물의 제목, 작성자, 작성일자, 내용을 볼 수 있고, 댓글을 달 수 있습니다. *(Comments_viewController.java)*
- 게시물을 작성할 때는 연결할 코스의 이름을 검색하여 선택 할 수 있습니다. *(WriteCommentsController.java)*


## 4. 스크린샷
###  :white_check_mark:메인화면
![MAIN](https://user-images.githubusercontent.com/70059000/155846838-44034812-7e49-40d2-a01b-c107ee35eee1.png)
###  :white_check_mark:마이페이지
![mypage](https://user-images.githubusercontent.com/70059000/155847333-7c83ff4e-c3ee-4837-89e9-27d499774c7f.png)
###  :white_check_mark:드라이브 코스 추천
![코스](https://user-images.githubusercontent.com/70059000/155846849-e9d25f0a-6dce-484e-80fe-6fd151f7f0a3.png)
![코스매칭](https://user-images.githubusercontent.com/70059000/155847295-25dbea23-901a-41fc-a414-b34e30bdfff9.png)
###  :white_check_mark:베스트 드라이브 코스 순위
![코스랭킹](https://user-images.githubusercontent.com/70059000/155846939-18b815c0-cef7-4702-86c9-d9dd4ca7fa12.png)
###  :white_check_mark:드라이브 코스 입력
![코스입력](https://user-images.githubusercontent.com/70059000/155846960-fdae975c-e5a7-4178-9145-0b73f0e48f85.png)
###  :white_check_mark:드라이브 플레이리스트 추천
![플레이리스트](https://user-images.githubusercontent.com/70059000/155846968-e21d8cb2-528e-43c4-bfc6-6ad25f692174.png)
###  :white_check_mark:드라이브 코스 주변 핫플
![게시물](https://user-images.githubusercontent.com/70059000/155847379-698ef3c6-34cf-4cd7-8121-c8d4e7cd0449.png)
![게시물상세](https://user-images.githubusercontent.com/70059000/155847247-67edea9e-d5d0-4434-98df-c2536197dc42.png)

