# 게시판
> 다양한 소통을 할 수 있는 콘솔 게시판 만들기<br/>
> 타겟 : 우리반 친구들<br/>
> 문제해결 : 공지, 자유, 질문 게시판을 자유로운 소통 도모
<br/>

## 💻 스택
<table border="1">
<th colspan='2'>Language</th>
<th colspan='2'>Develop Tool</th>
<th colspan='2'>Manage Tool</th>
<tr><!-- 첫번째 줄 시작 -->
<td style="text-align:center"><img src="https://user-images.githubusercontent.com/76681519/230399518-66c434d9-8fa9-4f3d-b69a-b629ab57f515.png" width="50"/><br/>Java 11</td>
<td style="text-align:center"><img src="https://user-images.githubusercontent.com/76681519/230399678-3028b643-7d25-4458-abf0-f08bae5ddc92.png" width="50"/><br/>OracleDataBase 21C XE</td>

<td style="text-align:center"><img src="https://user-images.githubusercontent.com/76681519/230399691-2ab61687-5413-4c6a-8b9a-fe2bd42d74d2.png" width="50"/><br/>Eclipse</td>
<td style="text-align:center"><img src="https://user-images.githubusercontent.com/76681519/230399561-1f1c3ead-15c0-456a-9160-e6f8a0c85c65.png" width="50"/><br/>Intellij</td>

<td style="margin-left:auto;margin-right:auto;"><img src="https://user-images.githubusercontent.com/76681519/230399649-2cd73a04-95a6-401c-ae69-111a9e3b287e.png" width="50"/><br/>Git</td>
<td style="text-align:center"><img src="https://user-images.githubusercontent.com/76681519/230399701-4a0f404a-efd3-4223-9fc3-17def4744797.png" width="50"/><br/>MatterMose</td>

</tr><!-- 첫번째 줄 끝 -->
</table>
<br/>


## 🏄‍♀️ 주요 기능
```
1. 회원가입 및 로그인/로그아웃
2. 게시글 조회(공지/자유/질문/조회수 랭킹/좋아요 랭킹)
3. 게시글 작성
4. 게시글 수정
5. 게시글 삭제
6. 게시글 좋아요 기능
7. 게시글 조회 시 자동 조회수 증가 기능
8. 댓글 조회
9. 댓글 작성
10. 댓글 수정
11. 댓글 삭제
12. 질문 게시판 댓글 채택 
13. 질문 게시판 질문 해결
14. 내 게시글 조회
15. 마이페이지
16. 오늘의 식단
17. 종료
```
<br/>


## 💾 DB
![image 57](https://user-images.githubusercontent.com/76681519/230402294-e80383ba-7cb6-4d21-8750-469031ac6d51.png)
<br/>

## ✅ MVC
![image 58](https://user-images.githubusercontent.com/76681519/230402361-5e88503a-016f-46e2-b23d-9b0c82696768.png)
<br/>


## 🗂 프로젝트 폴더 구조

```
📦resources
 ┣ 📂scheam
 ┗ ┗ 📜projectSchema.sql
📦src
 ┣ 📂common
 ┃ ┗ 📜DBManager.java
 ┃ ┗ 📜DBProperties.java
 ┣ 📂controller
 ┃ ┣ 📜BoardController.java
 ┃ ┣ 📜LoginController.java
 ┃ ┗ 📜ReplyController.java
 ┣ 📂dao
 ┃ ┣ 📜BoardDAO.java
 ┃ ┣ 📜BoardDAOImpl.java
 ┃ ┣ 📜LoginDAO.java
 ┃ ┣ 📜LoginDAOImpl.java
 ┃ ┣ 📜ReplyDAO.java
 ┃ ┗ 📜ReplyDAOImpl.ts
 ┣ 📂dto
 ┃ ┣ 📂boarddto
 ┃ ┃ ┣ 📜BoardDTO.java
 ┃ ┃ ┣ 📜FreeBoard.java
 ┃ ┃ ┣ 📜NoticeBoard.java
 ┃ ┃ ┗ 📜QuestionBoard.java
 ┃ ┣ 📂mealdto
 ┃ ┃ ┗ 📜MealDTO.java
 ┃ ┗ 📂replydto
 ┃ ┃ ┣ 📜QuestionReply.java
 ┃ ┃ ┗ 📜ReplyDTO.java
 ┃ ┗ 📂userdto
 ┃ ┃ ┣ 📜Admin.java
 ┃ ┃ ┣ 📜AppUser.java
 ┃ ┃ ┣ 📜UserDTO.java
 ┃ ┃ ┗ 📜UserSession.java
 ┣ 📂exception
 ┃ ┣ 📜DMLException.java
 ┃ ┣ 📜LoginWrongException.java
 ┃ ┣ 📜SearchWrongException.java
 ┃ ┗ 📜SignupWrongException.java
 ┣ 📂service
 ┃ ┣ 📜BoardService.java
 ┃ ┣ 📜BoardServiceImpl.java
 ┃ ┣ 📜LoginService.java
 ┃ ┣ 📜LoginServiceImpl.java
 ┃ ┣ 📜ReplyService.java
 ┃ ┗ 📜ReplyServiceImpl.java
 ┣ 📂view
 ┃ ┣ 📜FailView.java
 ┃ ┣ 📜LoginView.java
 ┃ ┣ 📜MainApp.java
 ┃ ┣ 📜MainView.java
 ┗ ┗ 📜SuccessView.java
```

<br/>

## 📷 결과화면 캡처
<details>
<summary>0. 회원가입 및 로그인</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230403063-aeb7b526-728b-4a67-a279-5f1d61816619.png"/>
</div>
</details>

<details>
<summary>1. 게시글 작성</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230402686-a2397a13-2514-44cd-9c86-6f1c5f1d75fa.png"/>
</div>
</details>

<details>
<summary>2.게시글 조회 및 댓글작성</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230402719-efae4cfe-a702-4e1b-8ba0-085ddb29606a.png"/>
</div>
</details>

<details>
<summary>3. 게시글 키워드 검색</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230402810-7d89dec5-470f-4a93-a26d-a5d7ee20206e.png"/>
</div>
</details>

<details>
<summary>4. 내 게시글 조회 및 마이페이지</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230402853-ef075cb5-85ad-452b-97a3-a30851650dcb.png"/>
</div>
</details>

<details>
<summary>5. 로그아웃 및 종료</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230402919-d3c0dde4-cd0f-4061-9203-abc72cd002dc.png"/>
</div>
</details>

<details>
<summary>6. 마이페이지</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230403128-1021a8c7-8953-4e8b-b665-e3e5e094c42f.png"/>
</div>
</details>

<details>
<summary>7. 좋아요 누르기</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230403161-12ec8d8c-6065-4582-a773-acffc0cce80a.png"/>
</div>
</details>

<details>
<summary>8. 좋아요, 조회수 랭킹 순 조회</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/76681519/230403268-ad0e94cc-690e-4484-90a5-4ba2f5b3fb6b.png"/>
</div>
</details>

<br/>

## 👨‍👧‍👦 Team  
  
  <table border="1">
	<th>김원우</th>
	<th>박주호</th>
  <th>서지수</th>
  <th>임재현</th>
	<tr><!-- 첫번째 줄 시작 -->
	    <td><img src="https://avatars.githubusercontent.com/u/86345526?v=4" width="200"/></td>
	    <td><img src="#" width="200"/></td>
       <td><img src="https://avatars.githubusercontent.com/u/76681519?v=4" width="200"/></td>
	    <td><img src="https://avatars.githubusercontent.com/u/32118818?v=4" width="200"/></td>
	</tr><!-- 첫번째 줄 끝 -->
	<tr><!-- 두번째 줄 시작 -->
	    <td>
      1. 로그인 기능 구현 <br/>
      2. BoardService / BoardController 구현
      </td>
	    <td>
      1. UML 형성<br/>
2. PPT 작성<br/>
3. 발표
      </td>
       <td>
       1. 게시글/댓글 dao<br/>
2. 댓글 Controller, view 구현<br/>
3. DB 구현
       </td>
	    <td>
      1. 로그인/게시글/기타 View 작성<br/>
2. 댓글 view refactor +  MainView 연동<br/>
3. 게시글 관련 Controller 작성
      </td>
	</tr><!-- 두번째 줄 끝 -->
    </table>
<br/>

