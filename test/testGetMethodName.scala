/**
  * Created by jie on 17-2-23.
  */
object testGetMethodName {
  def main(args: Array[String]): Unit = {
    val t = new testGetMethodName()
    //    val fun = t.getClass.getMethod("run")
    //    fun.invoke(t)
    //    t.test("run")
    try {
      t.throwEx()
    } catch {
      case e: Exception => println(e.toString)
    }
  }

}

class testGetMethodName {
  def run(): Unit = {
    println("lllll")
  }

  def test(name: String): Unit = {
    this.getClass.getMethod(name).invoke(this)
  }

  def throwEx(): Unit ={
    throw new RuntimeException()
  }
}
