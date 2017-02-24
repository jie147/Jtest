package test

import scala.collection.mutable.ArrayBuffer


class TestResult {

  var fail: ArrayBuffer[String] = new ArrayBuffer[String]()
  var error: ArrayBuffer[String] = new ArrayBuffer[String]()
  var testsRun: Int = 0
  var flagStop: Boolean = false

  def addFail(str: String): Unit = {
    fail = fail += str
  }

  def addError(str: String):Unit = {
    error = error += str
  }

  def stopTest(): Unit = {
    flagStop = true
  }

  def startTest(): Unit = {
    testsRun += 1
  }

  def wasSuccessful(): Boolean = {
    if (fail.size == error.size & error.size == 0) true else false
  }

}
