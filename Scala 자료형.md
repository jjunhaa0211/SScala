# Scala 자료형

---

## Scala 자료형?

- 스칼라의 자료형은 자바와 동일합니다.
- Scala 는 자바의 원시 자료형이 존재하지 않고, 모든 것이 클래스 입니다.
- Scala 의 자료형은 자바의 자료형 으로 컴파일 시점에 자동으로 변환됩니다.
- Scala에서 자료형을 선언하지 않으면 컴파일러에서 자동을 정수는 Int로 실수는 Double로 선언됩니다

## 참조 자료형

| 자료형 | 설명 |
| --- | --- |
| String | 문자열 표현 |
| Unit | 리턴값이 없음을 표현 |
| Null | Null 값 표현 |
| Nothing | 모든 객체의 서브 타입 |
| Any | 모든 객체의 기본 타입 |
| AnyVal | 기본 값 타입의 부모 타입 |
| AnyRef | 참조 타입의 부모 타입 |

## 캐스팅

- 정수형과 실수형 사이의 업캐스팅은 자동으로 이루어지고, 다운캐스팅은 명시적으로 처리해야함
- Byte를 Short으로 형 변환하면 업캐스팅으로 자동 지원됩니다.
- Long형을 Int형으로 변화하면 다운캐스팅이 일어나서 64 → 32 하는 것은 자동으로 처리 되지  않고 오류가 발생합니다.

```scala
def main(args: Array[String]): Unit = {

    var a: Int = 10
    var b: Double = 20

    a = b
    println(a)
  }
```

- 위코드는 타입 불일치 발생 안됨 에러남

```scala
def main(args: Array[String]): Unit = {

    var a: Int = 10;
    var b: Short = 20;

    a = b
    println(a)
  }
```

- 위 코드는 잘됨 에러가 발생하지 않음

## 데이터 형 선언

```scala
//암시적인 선언
var x = 20
var y = "asdf"

//명시적인 선언
var b: Byte = 10
var i: Int = 10

//값에 약어를 추가하여 명시적 선언
var f = 100.0f
var d = 20.0d

// 암시적 선언, 자동으로 타입을 선택
var ii = 10
```

## 논리형

```scala
var t = true
var f = false

if(t)
    println("참")
  else
    println("거짓")
```