package example

import org.scalatest._
import rx.lang.scala.Observable

class AxisSpec extends FlatSpec with Matchers {
  "The point class" should "has value" in {
    val point = new Point()
    point.value shouldEqual 0
  }

  "The axis class" should "has points" in {
    val axis = new Axis()
    axis.x shouldEqual 0
    axis.y shouldEqual 0
    axis.z shouldEqual 0
  }

  "The axis class" should "increase the x points" in {
    val axis = new Axis()
    axis.increaseX(10)
    axis.x shouldEqual 10
  }

  "The axis class" should "decrease the x points" in {
    val axis = new Axis()
    axis.decreaseX(5)
    axis.x shouldEqual -5
    axis.increaseX(15)
    axis.decreaseX(5)
    axis.x shouldEqual 5
  }

  "The axis class" should "increase the y points" in {
    val axis = new Axis()
    axis.increaseY(10)
    axis.y shouldEqual 10
  }

  "The axis class" should "decrease the y points" in {
    val axis = new Axis()
    axis.increaseY(10)
    axis.decreaseY(5)
    axis.y shouldEqual 5
  }

  "The axis class" should "increase the z points" in {
    val axis = new Axis()
    axis.increaseZ(10)
    axis.z shouldEqual 10
  }

  "The axis class" should "decrease the z points" in {
    val axis = new Axis()
    axis.increaseZ(10)
    axis.decreaseZ(5)
    axis.z shouldEqual 5
  }

  "The axis class" should "divide x by a default value" in {
    val axis = new Axis()
    axis.increaseX(10)
    axis.divX() shouldEqual 5
  }

  "The axis class" should "divide y by a default value" in {
    val axis = new Axis()
    axis.increaseY(10)
    axis.divY() shouldEqual 5
  }

  "The axis class" should "divide z by a default value" in {
    val axis = new Axis()
    axis.increaseZ(10)
    axis.divZ() shouldEqual 5
  }

  "The axis class" should "show an history of ins for x" in {
    val axis = new Axis()
    axis.increaseX(10)
    axis.increaseHistoryX() shouldEqual List(0)
    axis.increaseX(20)
    axis.increaseHistoryX() shouldEqual List(0,10)
    axis.increaseX(30)
    axis.increaseHistoryX() shouldEqual List(0,10,30)
  }

  "The axis class" should "show an history of ins for y" in {
    val axis = new Axis()
    axis.increaseY(10)
    axis.increaseHistoryY() shouldEqual List(0)
    axis.increaseY(20)
    axis.increaseHistoryY() shouldEqual List(0,10)
    axis.increaseY(30)
    axis.increaseHistoryY() shouldEqual List(0,10,30)
  }

  "The axis class" should "show an history of ins outs for z" in {
    val axis = new Axis()
    axis.increaseZ(10)
    axis.increaseHistoryZ() shouldEqual List(0)
    axis.increaseZ(20)
    axis.increaseHistoryZ() shouldEqual List(0,10)
    axis.increaseZ(30)
    axis.increaseHistoryZ() shouldEqual List(0,10,30)
  }

  "The axis class" should "show an history of outs for x" in {
    val axis = new Axis()
    axis.increaseX(10)
    axis.decreaseX(5)
    axis.decreaseHistoryX() shouldEqual List(0,5)
    axis.increaseX(20)
    axis.decreaseX(10)
    axis.decreaseHistoryX() shouldEqual List(0,5,15)
  }

  "The axis class" should "show an history of outs for y" in {
    val axis = new Axis()
    axis.increaseY(10)
    axis.decreaseY(5)
    axis.decreaseHistoryY() shouldEqual List(0,5)
    axis.increaseY(20)
    axis.decreaseY(10)
    axis.decreaseHistoryY() shouldEqual List(0,5,15)
  }

  "The axis class" should "show an history of outs for z" in {
    val axis = new Axis()
    axis.increaseZ(10)
    axis.decreaseZ(5)
    axis.decreaseHistoryZ() shouldEqual List(0,5)
    axis.increaseZ(20)
    axis.decreaseZ(10)
    axis.decreaseHistoryZ() shouldEqual List(0,5,15)
  }

  "The axis class" should "show decreased values without increased ones" in {
    val neseq: Observable[Int] = Observable.from(1 to 15000)

    neseq.map(v => v * 2) subscribe { v =>
      if (v % 2 == 0 && v % 3 == 0) {
        println(s"$v is multiple of two and three")
      } else if (v % 2 == 0) {
        println(s"$v is multiple of two")
      } else if (v % 3 == 0) {
        println(s"$v in multiple of three")
      } else {
        println(s"$v")
      }
    }
  }
}
