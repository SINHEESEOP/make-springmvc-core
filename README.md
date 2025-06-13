# MySpringMVC - MVC 핵심 구조 학습 프로젝트

## 프로젝트 개요
Spring MVC의 핵심 구조를 이해하기 위해 점진적으로 발전시키는 학습용 프로젝트입니다.  
순수 서블릿부터 시작하여 Spring MVC의 DispatcherServlet(프론트 컨트롤러)까지 단계별로 구현합니다.

## 기술 스택
- Java 17
- Spring Boot 3.5.0  
- JSP & JSTL
- Lombok
- Embedded Tomcat
- Gradle

## 프로젝트 구조

```
src/main/java/com/study/myspringmvc/
├── 📂 servlet/
│   ├── 📂 basic/           # 기본 서블릿 학습
│   ├── 📂 domain/          # 도메인 모델 (Member)
│   └── 📂 web/
│       ├── 📂 servlet/     # 순수 서블릿 구현
│       ├── 📂 servletmvc/  # 서블릿 + JSP MVC 패턴
│       └── 📂 frontcontroller/ # 프론트 컨트롤러 구현
│           ├── 📂 v1/      # 1단계: 기본 프론트 컨트롤러
│           ├── 📂 v2/      # 2단계: View 분리
│           ├── 📂 v3/      # 3단계: Model 추가
│           ├── 📂 v4/      # 4단계: 실용적인 컨트롤러
│           └── 📂 v5/      # 5단계: 어댑터 패턴 적용
└── 📂 springmvc/           # Spring MVC 구현
    ├── 📂 v1/              # Spring MVC 기본
    ├── 📂 v2/              # 컨트롤러 통합
    └── 📂 v3/              # 실용적인 방식
```

## 발전 단계

### 1. 기본 서블릿
순수 서블릿으로 웹 애플리케이션 구현
- **패키지**: `servlet.basic.*`
- **URL**: `/hello`, `/request-*`, `/response-*`
- **목표**: HTTP 요청/응답 처리의 기본 원리 이해

### 2. 순수 서블릿 MVC
서블릿으로 회원 관리 시스템 구현
- **패키지**: `servlet.web.servlet.*`
- **URL**: `/servlet/members/*`
- **특징**: HTML을 자바 코드로 직접 생성
- **문제점**: 뷰와 비즈니스 로직이 섞임

### 3. 서블릿 + JSP MVC
MVC 패턴 적용으로 관심사 분리
- **패키지**: `servlet.web.servletmvc.*`
- **URL**: `/servlet-mvc/members/*`
- **개선점**: 뷰(JSP)와 컨트롤러(서블릿) 분리
- **문제점**: 공통 처리 로직의 중복

### 4. 프론트 컨트롤러 V1
중앙 집중식 요청 처리 도입
- **패키지**: `servlet.web.frontcontroller.v1.*`
- **URL**: `/front-controller/v1/members/*`
- **개선점**: 하나의 서블릿으로 모든 요청 처리
- **핵심**: 프론트 컨트롤러 패턴 도입

### 5. 프론트 컨트롤러 V2
View 처리 로직 분리
- **패키지**: `servlet.web.frontcontroller.v2.*`
- **URL**: `/front-controller/v2/members/*`
- **개선점**: MyView 클래스로 뷰 렌더링 공통화

### 6. 프론트 컨트롤러 V3
Model 도입으로 서블릿 종속성 제거
- **패키지**: `servlet.web.frontcontroller.v3.*`
- **URL**: `/front-controller/v3/members/*`
- **개선점**: 
  - ModelView 객체 도입
  - 컨트롤러의 서블릿 종속성 완전 제거
  - 뷰 이름만으로 논리적 처리

### 7. 프론트 컨트롤러 V4
실용성을 위한 인터페이스 개선
- **패키지**: `servlet.web.frontcontroller.v4.*`
- **URL**: `/front-controller/v4/members/*`
- **개선점**: 컨트롤러가 ModelView 대신 viewName만 반환

### 8. 프론트 컨트롤러 V5
어댑터 패턴으로 다양한 컨트롤러 지원
- **패키지**: `servlet.web.frontcontroller.v5.*`
- **URL**: `/front-controller/v5/*/members/*`
- **개선점**: 
  - HandlerAdapter 도입
  - 다양한 종류의 컨트롤러 동시 지원
  - 확장성 극대화

### 9. Spring MVC 구현
실제 Spring MVC와 동일한 구조
- **패키지**: `springmvc.v*.*`
- **URL**: `/springmvc/v*/members/*`
- **특징**: Spring의 DispatcherServlet과 동일한 동작 원리

## 실행 방법

### 애플리케이션 실행
```bash
# 프로젝트 빌드 및 실행
./gradlew bootRun

# 또는 JAR 파일 생성 후 실행
./gradlew build
java -jar build/libs/MySpringMVC-0.0.1-SNAPSHOT.jar
```

### 중요 설정
`@ServletComponentScan` 어노테이션이 메인 클래스에 추가되어 있어야 `@WebServlet`으로 등록된 서블릿들이 정상 작동합니다.

## 주요 URL

애플리케이션 실행 후 브라우저에서 접속:

| 단계 | URL | 설명 |
|------|-----|------|
| 메인 페이지 | http://localhost:8080/ | 모든 예제 링크 제공 |
| 기본 서블릿 | http://localhost:8080/hello | 기본 서블릿 동작 |
| 순수 서블릿 | http://localhost:8080/servlet/members/new-form | 순수 서블릿 회원가입 |
| 서블릿 MVC | http://localhost:8080/servlet-mvc/members/new-form | JSP 활용 MVC |
| 프론트 컨트롤러 V1 | http://localhost:8080/front-controller/v1/members/new-form | 기본 프론트 컨트롤러 |
| Spring MVC | http://localhost:8080/springmvc/v1/members/new-form | Spring MVC 구현 |

## 학습 목표

1. 서블릿의 동작 원리 이해
2. MVC 패턴의 필요성과 발전 과정 학습
3. 프론트 컨트롤러 패턴의 핵심 가치 이해
4. Spring DispatcherServlet의 동작 원리 파악
5. HTTP 요청/응답 처리 메커니즘 습득
6. 디자인 패턴의 실전 적용
7. 점진적 리팩토링 기법 연습

## 참고 자료

- 김영한의 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술
- Spring Framework Documentation
- Servlet & JSP 스펙 문서
