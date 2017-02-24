package test

import scala.collection.mutable.ArrayBuffer

object TestSuite {
//  def autoMakeSuit(testCase:{def apply(string: String):test.TestCase} , flagStart: String = "test"): test.TestSuite = {
//    val funsName = testCase.getClass.getMethods.map(x => x.getName).filter(m => m.startsWith(flagStart))
//
//    val suit = new test.TestSuite()
//    suit.addTests(funsName.map(t =>  testCase.apply(t) ))
//    return suit
//  }
}

class TestSuite {

  var listCase: ArrayBuffer[TestCase] = ArrayBuffer()

  def addTest(testCase: TestCase): Unit = {
    listCase.+=(testCase)
  }

  def addTests(testCases: Array[TestCase]): Unit = {
    listCase.++=(testCases)
  }

  def countTestCases = listCase.size

  def run(result: TestResult): TestResult = {
    for (test <- listCase) test.run(result)
    return result
  }

}
