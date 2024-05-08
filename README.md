## Pick ME
![pickme](https://github.com/beezSSG/.github/assets/60279992/a3ddd7a4-ba80-430e-b084-4b452b4a2b74)

사용자가 직접 소비기한을 확인할 수 있고 사용자 위치 기반으로 매장 서비스를 제공하는 __지능형 온라인 편의점 사이트__

---

## ⚙ 아키텍쳐 구조도

![Architecture](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/8e3f78ff-d4b5-4953-a873-d225622a0986)

## ERD
![ERD](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/6c01b502-82b5-48e8-91fd-a309941de352)


## DB Schema
![dbschema](https://github.com/beezSSG/finalproject_pickme_back/assets/60279992/c092c3b1-ad4d-492e-b795-2b26bd65f08d)

---

## 📢 실행 방법

따로 maven으로 빌드해서 jar를 실행도 가능하지만 해당 프로젝트는 docker을 사용하였기에 docker 기준으로 설명하겠다. ( docker 설치 필수 )

1. 해당 프로젝트를 git으로 clone을 한 후에 clone을 받을 폴더로 이동을 해준다. (Window면 gitbash, mac 이면 터미널로)

2. clone받은 프로젝트의 최상단으로 가서 [docker build -t {이미지명:태그명} .] 명령어를 실행하여 작성한 도커파일 기반으로 이미지를 빌드해준다. (태그명 뒤에 띄우고 . 을 반드시 해주자)

3. docker run 명령어로 실행을 실행을 시켜서 실행한 뒤에 실행할 때의 포트포워딩 포트로 접속을 하면된다. [ ex docker run -d -p 8080:8080 {이미지명:태그명} ] localhost:포워딩한 포트로 접속을 하면 실행이 될 것이다.


## Git Convention
[Commit convention 확인하러 가기](.github/ISSUE_TEMPLATE/custom.md)

[PR convention 확인하러 가기](.github/pull_request_template.md) 


## Code Convention
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

##  폴더 구조 📂
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
