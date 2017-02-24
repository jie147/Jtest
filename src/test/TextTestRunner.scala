package test

/**
  * Created by jie on 17-2-23.
  */
object TextTestRunner {

  def apply(testCase: {def run(result: TestResult):TestResult}): TextTestResult = run(testCase)

  def run(testCase: {def run(result: TestResult):TestResult}): TextTestResult = {
    var textTestResult = new TextTestResult()
    val startTime = System.currentTimeMillis()
    textTestResult = testCase.run(textTestResult).asInstanceOf[TextTestResult]
    val endTime = System.currentTimeMillis()
    System.err.println("\n")
    System.err.println("Test time is "+(endTime - startTime) + " ms")
    textTestResult.printResult()
    return textTestResult
  }
}
