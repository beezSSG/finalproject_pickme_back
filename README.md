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
1.


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
