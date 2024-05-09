## Pick ME
![pickme](https://github.com/beezSSG/.github/assets/60279992/a3ddd7a4-ba80-430e-b084-4b452b4a2b74)

사용자가 직접 소비기한을 확인할 수 있고 사용자 위치 기반으로 매장 서비스를 제공하는 __지능형 온라인 편의점 사이트__

---

## ⚙ 아키텍쳐 구조도

![Architecture](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/8e3f78ff-d4b5-4953-a873-d225622a0986)


## 🗃️ ERD
![ERD](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/6c01b502-82b5-48e8-91fd-a309941de352)


## 🗄️ DB Schema
[DB Schema 보러가기👆](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/c092c3b1-ad4d-492e-b795-2b26bd65f08d)

---

## 🛠️ Tech Stack

| Role | Stacks |
|-|-|
| Framework |<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=springboot&logoColor=white" /> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat&logo=Spring Security&logoColor=white" /> <img src="https://img.shields.io/badge/MyBatis-C4242B?style=flat&logo=mybatis&logoColor=white" /> |
| Database | <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white" /> |
| Database Service | ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=flat&logo=apache-tomcat&logoColor=black) <img src="https://img.shields.io/badge/Github_Actions-2088FF?style=flat&logo=githubactions&logoColor=white"/> <img src="https://img.shields.io/badge/NGINX-009639?style=flat&logo=nginx&logoColor=white"/> <img src="https://img.shields.io/badge/amazonrds-527FFF?style=flat&logo=amazonrds&logoColor=white"/> <img src="https://img.shields.io/badge/amazons3-DD344C?style=flat&logo=amazons3&logoColor=white"/> <img src="https://img.shields.io/badge/Amazonaws-232F3E?style=flat&logo=amazonaws&logoColor=white" /> <img src="https://img.shields.io/badge/Argo-EF7B4D?style=flat&logo=argo&logoColor=white" /> <img src="https://img.shields.io/badge/Kubernetes-326CE5?style=flat&logo=kubernetes&logoColor=white"/>  |
| Programming Language | ![Java](https://img.shields.io/badge/java_17-007396.svg?style=flat&logo=openjdk&logoColor=white) |
| API | <img src="https://img.shields.io/badge/NAVER_Cloud-03C75A?style=flat&logo=naver&logoColor=white"/> |                                 
| Version Control | ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=flat&logo=git&logoColor=white) <img src="https://img.shields.io/badge/Github-181717?style=flat&logo=github&logoColor=white"> |


## 🚀 실행 방법 

따로 maven으로 빌드해서 jar를 실행도 가능하지만, 해당 프로젝트는 docker를 사용하였기에 docker 기준으로 설명하겠다. 

___🚨 docker 설치 필수___

1. 해당 프로젝트를 git으로 clone을 한 후에 clone을 받을 폴더로 이동을 해준다. (Window면 gitbash, mac이면 터미널로)

2. clone 받은 프로젝트의 최상단으로 가서
   ```[docker build -t {이미지명:태그명} .]``` 명령어를 실행하여 작성한 도커파일 기반으로 이미지를 빌드해준다.
   ___🚨 태그명 뒤에 띄우고 . 을 반드시 해주자___

4. docker run 명령어로 실행을 시켜서 실행한 뒤에 실행할 때의 포트 포워딩 포트로 접속을 하면 된다.

5. ```[ ex docker run -d -p 8080:8080 {이미지명:태그명} ] localhost:포워딩한 포트```로 접속을 하면 실행이 될 것이다.



## 🖇️ Git Convention
[Commit convention 확인하러 가기](.github/ISSUE_TEMPLATE/custom.md)

[PR convention 확인하러 가기](.github/pull_request_template.md) 



## 📝 Code Convention
### Class 규칙 
- Pascal Case로 한다
  ex. MypageController

### DB 및 DTO 작성 요령

- DB 테이블 및 **컬럼** 작성시 **소문자** 및 **snake_case**을 사용 
  ex) **purchase_order** 테이블의 **ceo_id** 컬럼
- sts에서 **dto** 작성시 **camelCase** 사용
  ex) **ceo_id** 컬럼을 dto로 받을시 **ceoId** 로 작성
ex. sts에서 sqls 작성 예시 select문
```sql
select ceo_id as `ceoId`
from purchase_order;
```

---

##  📂 폴더 구조 
```bash
├── 📁 src
│   ├── 🗂️ main
│   │   ├── 🗂️ java.com.pick.beeze
│   │   │   ├── 🗂️ ceo
│   │   │   ├── 🗂️ customer
│   │   │   ├── 🗂️ login
│   │   │   ├── 🗂️ manager
│   │   │   ├── 🗂️ mypage
│   │   │   ├── 🗂️ product
│   │   │   ├── 🗂️ review
│   │   │   ├── 🗂️ store
│   │   │   ├── 🗂️ util
│   │   │   ├── DatabaseConfig.js
│   │   │   ├── MediaTypeUtils.js
│   │   │   ├── PickmeApplication.js
│   │   │   ├── WebConfigurer.js
│   │   │ 
│   │   ├── 🗂️ resources
│   │   │   ├── 🗂️ sqls
│   │   │   ├── 🗂️ static/upload
│   │   │   ├── 🗂️ application.properties
│   │   │ 
│   ├── 🗂️ test.java.com.pick.beeze
│   │   ├── PickmeApplicationTests.java
├── Info.plist
```
