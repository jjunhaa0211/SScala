# Scala 객체

---

## Scala 특징

- 기본자료형, 함수, 클래스등 모든 것을 객체로 취급합니다.
- 객체는 Any를 최상위 클래스로 값 타입과 참조 타입을 상속하여 구현합니다.
    - int, Byte, String 등등 기본 자료형은 AnyVal을 상속하고
    - class는 AnyRef를 상속합니다.
<img width="579" alt="스크린샷 2023-07-15 오후 3 10 31" src="https://github.com/jjunhaa0211/SScala/assets/102890390/b5945d78-b251-47b1-8b4a-c441ecccf7d3">


## 객체의 비교

- 객체의 비교는 ==, ≠ 연산자를 이용합니다. 자바에서는 문자열의 비교는 `equals`를 이용했지만 스칼라는 모든 것을 ==, ≠ 를 사용합니다

```scala
scala> 1 == 1
res15: Boolean = true

scala> 'a' == 'a'
res16: Boolean = true

scala> 1 == 'a'
res17: Boolean = false
```

## 문자열 비교

```scala
scala> var s1 = "Hello"
var s1: String = Hello
                                                                                
scala> var s2 = "Hello2"
var s2: String = Hello2
                                                                                
scala> var s3 = "Hello3"
var s3: String = Hello3
                                                                                
scala> s1 == s2
val res2: Boolean = false
                                                                                
scala> s1 == s1
val res3: Boolean = truep1 == p2
```

## 객체의 비교

```scala
scala> case class Person( p1:String, p2:String )
// defined case class Person
                                                                                
scala> val p1 = Person("a", "b")
     | val p2 = Person("a", "b")
     | val p3 = Person("b", "c")
val p1: Person = Person(a,b)
val p2: Person = Person(a,b)
val p3: Person = Person(b,c)
                                                                                
scala> p1 == p2
val res4: Boolean = true
```
