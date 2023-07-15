# Hello World(Scala)

---

## 싱글톤 오브젝트의 main 함수 구현

> Scala 에서는 `def main()` 으로 함수를 구현합니다
> 

```scala
object HelloWorld {
	def main(args: Array[String]): Unit = {
		println("Hellow World")
	}
}
```

## App 트레잇 상속

- 자바와 같이 extends로 App 트레잇을 상속하고, 실행하고자 하는 코드를 작성하면 순차적으로 실행됩니다.

```scala
object HelloWorld extends App {
	println("Hello world")
}
```

## App Trait?

```scala
/** The `App` trait can be used to quickly turn objects
 *  into executable programs. Here is an example:
 *  {{{
 *  object Main extends App {
 *    Console.println("Hello World: " + (args mkString ", "))
 *  }
 *  }}}
 *
 *  No explicit `main` method is needed.  Instead,
 *  the whole class body becomes the “main method”.
 *
 *  `args` returns the current command line arguments as an array.
 *
 *  ==Caveats==
 *
 *  '''''It should be noted that this trait is implemented using the [[DelayedInit]]
 *  functionality, which means that fields of the object will not have been initialized
 *  before the main method has been executed.'''''
 *
 *  Future versions of this trait will no longer extend `DelayedInit`.
 * 
 *  In Scala 3, the `DelayedInit` feature was dropped. `App` exists only in a limited form
 *  that also does not support command line arguments and will be deprecated in the future.
 * 
 *  [[https://docs.scala-lang.org/scala3/book/methods-main-methods.html @main]] methods are the
 *  recommended scheme to generate programs that can be invoked from the command line in Scala 3.
 * 
 *  {{{
 *  @main def runMyProgram(args: String*): Unit = {
 *    // your program here
 *  }
 *  }}}
 * 
 *  If programs need to cross-build between Scala 2 and Scala 3, it is recommended to use an
 *  explicit `main` method:
 *  {{{
 *  object Main {
 *    def main(args: Array[String]): Unit = {
 *      // your program here
 *    }
 *  }
 *  }}}
 */
@nowarn("""cat=deprecation&origin=scala\.DelayedInit""")
trait App extends DelayedInit {

  /** The time when the execution of this program started, in milliseconds since 1
    * January 1970 UTC. */
  final val executionStart: Long = currentTime

  /** The command line arguments passed to the application's `main` method.
   */
  protected final def args: Array[String] = _args

  private[this] var _args: Array[String] = _

  private[this] val initCode = new ListBuffer[() => Unit]

  /** The init hook. This saves all initialization code for execution within `main`.
   *  This method is normally never called directly from user code.
   *  Instead it is called as compiler-generated code for those classes and objects
   *  (but not traits) that inherit from the `DelayedInit` trait and that do not
   *  themselves define a `delayedInit` method.
   *  @param body the initialization code to be stored for later execution
   */
  @deprecated("the delayedInit mechanism will disappear", "2.11.0")
  override def delayedInit(body: => Unit): Unit = {
    initCode += (() => body)
  }

  /** The main method.
   *  This stores all arguments so that they can be retrieved with `args`
   *  and then executes all initialization code segments in the order in which
   *  they were passed to `delayedInit`.
   *  @param args the arguments passed to the main method
   */
  final def main(args: Array[String]) = {
    this._args = args
    for (proc <- initCode) proc()
    if (util.Properties.propIsSet("scala.time")) {
      val total = currentTime - executionStart
      Console.println("[total " + total + "ms]")
    }
  }
}
```

- DelayedInit라는 Trait를 상속받습니다.
- main이 보통 entrypoint 일텐데 잘보면 init code라는 것에서 proc를 가져와서 이걸 실행합니다.
- delayedInit 함수가 body가 넘어와서 initCode에 저장됩니다.
- 자세한건 저로써는 이해가 어려워서 아래 링크를 참고해주세요
- [https://charsyam.wordpress.com/2015/02/27/입-개발-scala-의-app-trait는-어떻게-동작하는가/](https://charsyam.wordpress.com/2015/02/27/%EC%9E%85-%EA%B0%9C%EB%B0%9C-scala-%EC%9D%98-app-trait%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80/)