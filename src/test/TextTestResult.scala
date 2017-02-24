package test

import java.io.PrintStream

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jie on 17-2-23.
  */
class TextTestResult(val stream: PrintStream = System.err) extends TestResult {


  override def addFail(str: String): Unit = {
    super.addFail(str)
    stream.print('F')
  }

  override def addError(str: String) = {
    super.addError(str)
    stream.print('E')
  }

  override def startTest() = {
    super.startTest()
    stream.print('.')
  }

  def printNumberError(errFlag: String, errors: ArrayBuffer[String]): Unit = {
    if (errors.size < 1) return
    stream.println("There was " + errors.size + " " + errFlag)
    var i = 1
    for (e <- errors) {
      stream.println(i + " :)  " + e)
      i += 1
    }
  }

  def printError(): Unit = {
    printNumberError("error", error)
  }

  def printFailures(): Unit = {
    printNumberError("failures", fail)
  }

  def printHeard(): Unit = {
    stream.println("\n")
    if (wasSuccessful()) stream.println("OK ( " + testsRun + " tests)")
    else {
      stream.println("!!!FAILURES!!!")
      stream.println("TEST RESULT")
      stream.println()
      stream.println("Run : " + testsRun + " \t Failures: " + fail.size + " \t Errors: " + error.size)
    }
  }

  def printResult(): Unit = {
    printHeard()
    printFailures()
    printError()
  }

}
