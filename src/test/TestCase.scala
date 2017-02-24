package test

import java.lang.reflect.{InvocationTargetException, Method}

/**
  * Created by jie on 17-2-23.
  */
class TestCase {

  var methodName: String = _
  var fun: Method = _

  def apply(mName: String = "tunTest"): TestCase = {
    methodName = mName
    fun = {
      try {
        this.getClass.getMethod(methodName)
      } catch {
        case e: NoSuchMethodException => throw e
      }
    }
    return this
  }


  // first run it.
  def setUp(): Unit = {}

  // last run it.
  def tearDown(): Unit = {}

  def countTestCase(): Int = 1

  def run(res: TestResult = null): Unit = {
    var result = res
    if (result == null) result = new TestResult()
    res.startTest()
    try {
      try {
        setUp()
      } catch {
        case e: Exception => result.addError(e.toString)
          return
      }

      try {
        fun.invoke(this)
      } catch {
        case e: InvocationTargetException => if (e.getCause.getMessage.equalsIgnoreCase("assertion failed")) result.addFail(e.getCause.toString) else result.addError(e.getCause.toString)
        case e: Exception => result.addError(e.toString)
      }

      try {
        tearDown()
      } catch {
        case e: Exception => result.addError(e.toString)
      }
    }
    finally {
      result.stopTest()
    }
  }


  override def toString = this.getClass.toString + "." + methodName
}
