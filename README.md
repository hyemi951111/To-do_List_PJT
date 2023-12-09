# To-do_List_PJT
나만의 할 일을 작성하고 관리할 수 있는 사이트.
## 📝프로젝트 소개
하루의 할 일들을 작성하고 작성한 할 일들의 목록을 관리하면서 나만의 할 일들을 한 눈에 직관적으로 간편하게 관리할 수 있는 사이트 입니다.
## 🗓프로젝트 타임라인
#### ➡️프로젝트 계획 및 조사(23.10.16)
- 프로젝트 주제 설정<br>
- 참고 할 사이트 조사
#### ➡️프로젝트 설계(23.10.17)
- 디자인 설계 및 구현<br>
- 구현 할 기능 설계<br>
- 데이터 베이스 설계
#### ➡️프로젝트 기능 구현(23.10.18 ~ 23.10.19)
- 서버단 기능 구현<br>
- 데이터 베이스 구축
#### ➡️프로젝트 테스트 및 오류 수정(23.10.20)
- 구현한 기능 테스트 및 오류 수정<br>
- 프로젝트 관련 서류 정리
## ⚙개발 환경
-<img src="https://img.shields.io/badge/windows 11-48B0F1?style=flat&logo=windows11&logoColor=white"/>
- <img src="https://img.shields.io/badge/chrome-4285F4?style=flat&logo=googlechrome&logoColor=white"/>
- <img src="https://img.shields.io/badge/JAVA 8-007396?style=flat&logo=Java&logoColor=white"/>
- <img src="https://img.shields.io/badge/JDK 1.8.0-34567C?style=flat&logoColor=white"/>
- Server : <img src="https://img.shields.io/badge/apache tomcat 9.0-F09D13?style=flat&logo=apachetomcat&logoColor=white"/>
- IDE : <img src="https://img.shields.io/badge/eclipse-2C2255?style=flat&logo=eclipseide&logoColor=white"/>
- Framework : <img src="https://img.shields.io/badge/Mybatis-000000?style=flat&logoColor=white"/> <img src="https://img.shields.io/badge/Bootstrap5-512BD4?style=flat&logoColor=white"/>
- Database : <img src="https://img.shields.io/badge/oracle-F80000?style=flat&logo=oracle&logoColor=white"/>
- Library : <img src="https://img.shields.io/badge/JSTL-43A047?style=flat&logoColor=white"/> <img src="https://img.shields.io/badge/JSON-000000?style=flat&logo=json&logoColor=white"/> <img src="https://img.shields.io/badge/spring JDBC-6DB33F?style=flat&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/spring MVC-6DB33F?style=flat&logo=spring&logoColor=white"/>

## 🖥️주요 기능
#### 1️⃣회원가입
###### ✔아이디 중복 확인
- ajax와 @RestController를 사용해 아이디 중복 확인 -> 중복된 아이디의 경우 커스텀된 Validator의 유효성검사에 걸리며 다시 회원가입 페이지로 리턴하고 alert를 띄워 아이디 사용의 유무를 알려주고 중복되는 아이디의 가입을 막음.
###### ✔유효성 검사
- 이름, id, 비밀번호, 비밀번호 확인 유효성 검사 실시
#### 2️⃣로그인
###### ✔유효성 검사
- id, 비밀번호 유효성 검사 실시
###### ✔비밀번호 찾기
- 가입 시 입력한 이름과 아이디를 통하여 비밀번호를 찾을 수 있게 함.
###### ✔로그인 시 Session 생성
- 로그인 시 입력한 아이디와 비밀번호가 DB에 저장된 아이디, 비밀번호와 일치하면 세션이 생성되게 함.
#### 3️⃣로그아웃
###### ✔로그인 Session 종료
- 로그아웃 시 사용자의 로그인 정보를 담은 Session이 종료됨.
#### 4️⃣정보 수정
###### ✔회원정보 수정
- 로그인 시 생성된 session을 토대로 회원의 정보를 가져와서 수정페이지에 나타나게 함.
- 이름과 아이디를 제외하고 회원정보를 수정할 수 있게 함.
#### 5️⃣수강 신청
###### ✔전체 과정 및 과목 조회
- 과정 분류, 과정 명, 교육 기간, 수강 신청 가능 총 인원 수, 현재 신청된 인원 수, 커리큘럼 버튼, 그리고 수강 신청 버튼이 표시됨.
###### ✔검색 기능
- 과정 종류와 과정 명으로 수강 신청할 과목을 검색할 수 있음.
###### ✔수강 신청 기능
- 로그인한 이용자가 이미 수강 신청한 과목이라면 수강 신청이 불가능함.
- 수강 신청 가능 인원이 정원을 초과했을 경우에도 수강 신청이 불가능함.
- 위 내용에 해당하지 않을 경우 수강 신청 기능이 작동함.
#### 6️⃣수강 조회
###### ✔수강 신청한 과정 및 과목 조회
- 과정 분류, 과정 명, 교육 기간, 수강 신청 가능 총 인원 수, 현재 신청된 인원 수, 커리큘럼 버튼, 그리고 수강 취소 버튼이 나타남.
###### ✔검색 기능
- 과정 종류와 과정 명으로 수강 신청한 과목을 검색할 수 있음.
#### 7️⃣게시판
###### ✔게시판 글 작성, 읽기, 수정, 삭제(CRUD)
- 각 과정별의 게시판마다 과정명을 선택하여 서로 다른 게시판이어도 글 작성을 할 수 있고, 파일첨부 기능을 포함시켜 사진 등을 회원들에게 보여줄 수 있게 함.
- 게시글의 제목을 클릭할때마다 조회수가 증가하여 나타나게 함.
- 게시판 목록 페이지에서 회원들이 작성한 글들을 확인 할 수 있고 글 제목을 선택하여 내용이 나타날 시에, 로그인한 회원의 정보와 글 작성자의 정보가 일치하면 수정과 삭제 버튼이 뜨게 하여 게시글의 수정과 삭제가 가능하게 함.
###### ✔게시글 좋아요
-게시글마다 좋아요가 있어서 게시글 작성자 본인 혹은 다른 회원들이 좋아요 버튼을 눌러 좋아요를 체크할 수 있고, 로그인한 회원의 정보과 좋아요를 체크한 회원의 정보가 일치하면 좋아요 버튼을 중복으로 누를 때 좋아요가 취소될 수 있게 함.
###### ✔게시글 댓글
-게시글마다 댓글을 작성할 수 있고, 작성한 댓글은 등록순/최신순의 버튼으로 정렬하여 확인할 수 있게 함.
-로그인한 회원과 댓글 작성자의 정보가 일치하면 댓글에 수정과 삭제 버튼이 나타나며, 그에 따라 댓글 수정과 삭제를 가능하게 함.
###### ✔게시글 검색
- 전체, 제목, 게시글, 글 작성자로 나눠서 검색할 수 있게 하여 회원이 찾고자 하는 키워드를 손쉽게 찾을 수 있게 함.

