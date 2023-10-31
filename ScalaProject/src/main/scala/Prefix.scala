object Prefix {
  def main(args: Array[String]): Unit = {

    rowMain()
  }

  val name = "junha"

  def sMain(): Unit = {
    println(s"Hello! ${name}")
    println("${ 1 + 1 }")
    println(s"${ 1 + 1 }")
  }

  val height: Double = 182.3

  def fMain(): Unit = {
    println(f"$name%s is $height%2.2f meters tall")
  }

  def rowMain(): Unit = {
    s"가\n나"
    raw"가\n나"
  }
}

object S02_Strings extends App {
  var str1 = "Hello World!"
  println(str1)

  var str2 = """Hello
    World"""
  println(str2)

  var str3 = s"println $str1"
  println(str3)
  println(s"2 * 3 = ${2 * 3}")
  def minus(x: Int, y: Int) = x - y
  println(s"${Math.pow(2, 3)}")
  println(s"${minus(2, 3)}")

  val height:Double = 182.3
  val name = "James"
  println(f"$name%s is $height%2.2f meters tall")

  val rawStr = raw"가\n나"
  println(rawStr)
}
