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
- <img src="https://img.shields.io/badge/windows 11-48B0F1?style=flat&logo=windows11&logoColor=white"/>
- <img src="https://img.shields.io/badge/chrome-4285F4?style=flat&logo=googlechrome&logoColor=white"/>
- <img src="https://img.shields.io/badge/JAVA 8-007396?style=flat&logo=Java&logoColor=white"/>
- <img src="https://img.shields.io/badge/JDK 1.8.0-34567C?style=flat&logoColor=white"/>
- Server : <img src="https://img.shields.io/badge/apache tomcat 9.0-F09D13?style=flat&logo=apachetomcat&logoColor=white"/>
- IDE : <img src="https://img.shields.io/badge/eclipse-2C2255?style=flat&logo=eclipseide&logoColor=white"/>
- Framework : <img src="https://img.shields.io/badge/Mybatis-000000?style=flat&logoColor=white"/> <img src="https://img.shields.io/badge/Bootstrap5-512BD4?style=flat&logoColor=white"/>
- Database : <img src="https://img.shields.io/badge/oracle-F80000?style=flat&logo=oracle&logoColor=white"/>
- Library : <img src="https://img.shields.io/badge/JSTL-43A047?style=flat&logoColor=white"/> <img src="https://img.shields.io/badge/JSON-000000?style=flat&logo=json&logoColor=white"/> <img src="https://img.shields.io/badge/spring JDBC-6DB33F?style=flat&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/spring MVC-6DB33F?style=flat&logo=spring&logoColor=white"/>

## 🛠주요 기능
#### 1️⃣회원가입
###### ✔아이디 중복 확인
- ajax를 통한 아이디 중복 확인을 통해 중복되거나 그렇지 않은 아이디의 경우, alert를 띄워 아이디 사용의 유무를 알려주고 중복되는 아이디의 가입을 막음.
#### 2️⃣로그인
###### ✔DB 검증 후 session 생성
- 로그인 시 입력한 아이디와 비밀번호가 DB에 저장된 아이디, 비밀번호와 일치하면 세션이 생성되게 함.
#### 3️⃣로그아웃
###### ✔로그인 Session 종료
- 로그아웃 시 사용자의 로그인 정보를 담은 Session이 종료됨.
#### 4️⃣할 일 CRUD
###### ✔할 일 작성
- 달력을 클릭하여 마감 시간을 선택할 수 있으며, 등록 버튼을 눌러 간편하게 할 일 작성이 가능함.
###### ✔할 일 조회
- 메인 화면에 작성한 할 일들의 목록이 나타나게 하여 직관적으로 확인할 수 있게 함.
###### ✔할 일 수정
- 할 일의 내용을 변경하거나 혹은 진행중인 과정의 상태를 수정 버튼을 눌러 수정할 수 있게 함.
###### ✔할 일 삭제
- 삭제 버튼을 통해 완료되었거나, 지우고 싶은 할 일을 제거할 수 있게 함.
#### 5️⃣할 일 검색
###### ✔검색 기능
- '모두'를 클릭하여 검색할 시에 진행중인 할 일과 완료된 할 일들이 모두 나타나며, '진행중'이거나 '완료'를 클릭하여 검색 시 각각에 맞는 상태의 글들만 목록화되어 나열됨.

