# scala test tools

使用方法类似与`python`的`unittest`工具，其主要思想来自`unittest v1.2`工具.

## 使用手册


使用单例添加的方式，将测试的`case`添加到`suit`集合中。
```python
  def makeSuite(): TestSuite = {
    val suit = new TestSuite()
    suit.addTest(new TestTestCase().apply("test"))
    suit.addTest(new TestTestCase().apply("test2"))
    return suit
  }

  TextTestRunner.run(makeSuite())
```

### 自动识别的方法

自动识别需要一些前提条件，比如需要复写父类的`apply()`方法，并且需要在`object`中写`apply()`方法，具体如下：
```python
class TestTestCase extends TestCase {

  override def apply(mName: String): TestCase = super.apply(mName)

  def test(): Unit = {
    println("test!!!!!")
    assert(false)
  }
}

object TestTestCase {
  def apply(string: String): TestCase = new TestTestCase().apply(string)

  def main(args: Array[String]): Unit = {
    TextTestRunner(TestSuite.autoMakeSuite(new TestTestCase)(TestTestCase))
  }
}
```

> 注：`autoMakeSuite`方法默认使用的前缀是`test`，如有需要可自行修改。
> ```python
> TextTestRunner(TestSuite.autoMakeSuite(new TestTestCase,"check")(TestTestCase)) // 以`check`为前缀
> ```


