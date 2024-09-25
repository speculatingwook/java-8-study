# java8 study

이 스터디는 사용법을 익숙하게 만드는 것을 우선으로 합니다. 이후 이론이나 자세한 내용은 여유가 있다면 정리해봐요!

### 사용 교재
- 모던 액션 인 자바
- 자바 성능 튜닝 이야기

## 1. 람다표현식 / Stream 익숙해지기
`lambda` 디렉토리를 확인해보자. 

### 미션
- [ ] [UserServiceTest](/lambda/src/test/java/org/speculatingwook/service/UserServiceTest.java)의 테스트를 모두 통과한다.
- [ ] [LibraryServiceTest](/lambda/src/test/java/org/speculatingwook/service/LibraryServiceTest.java)의 테스트를 모두 통과한다.

## 2. Optional 클래스
- [ ] [OrderProcessingServiceTest](/lambda/src/test/java/org/speculatingwook/service/OrderProcessingServiceTest.java)의 테스트를 모두 통과한다.


### 요구사항
- JDK 8 이상을 사용합니다.

## 3. 함수형 프로그래밍과 자바
- 이 파트는 미션이 없습니다!

## 4. 병렬 데이터 처리 알아보기
`parallel` 디렉토리를 확인해보자.

### Stream 성능 측정 툴 JMH
<아직 제작중>
- 인텔리제이 extension 설치(선택)
- 다음 [링크](https://github.com/melix/jmh-gradle-plugin) 참고
- 해당 프로젝트 디렉토리 가서 다음 명령어 실행
```text
gradle jmh
```
## 5. 리팩토링, 테스팅, 디버깅

## 6. 자바 동시성 프로그래밍