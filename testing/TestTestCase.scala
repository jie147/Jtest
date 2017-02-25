package testing

import test.{TestCase, TestSuite, TextTestRunner}

/**
  * Created by jie on 17-2-23.
  */
class TestTestCase extends TestCase {

  override def apply(mName: String): TestCase = super.apply(mName)

  override // first run it.
  def setUp(): Unit = super.setUp()

  override // last run it.
  def tearDown(): Unit = super.tearDown()

  def test(): Unit = {
    println("test!!!!!")
//    throw new Exception()
    assert(false)
  }

  def test2(): Unit = {
    println("test2!!")
    assert(1 == 1)
  }

}

object TestTestCase {

  def apply(string: String): TestCase = new TestTestCase().apply(string)

  def makeSuite(): TestSuite = {
    val suit = new TestSuite()
    suit.addTest(new TestTestCase().apply("test"))
    suit.addTest(new TestTestCase().apply("test2"))
    return suit
  }

  def main(args: Array[String]): Unit = {
//    val t = new TestTestCase("test").run()
//        TextTestRunner.run(makeSuite())
    TextTestRunner.run(TestSuite.autoMakeSuite(new TestTestCase)(TestTestCase))
  }
}