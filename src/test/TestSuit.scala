package test

import scala.collection.mutable.ArrayBuffer

object TestSuite {
  def autoMakeSuite(testCase: Object, flagStart: String = "test")(obj:{def apply(string: String):TestCase}): TestSuite = {
    val names = testCase.getClass.getMethods.map(x => x.getName).filter(m => m.startsWith(flagStart))
    val suite = new TestSuite()
    for(n <- names) suite.addTest(obj.apply(n))
    return suite
  }

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
