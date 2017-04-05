package scaldb

import rx.lang.scala.Observable

trait CoreStringGetterSetter {
  def setString(key: String, value: String): String
  def getString(key: String, value: String = ""): String
}

trait CoreIntGetterSetter {
  def setInt(key: String, value: Int): Int
  def getInt(key: String, value: Int = 0): Int
}

trait CoreArrayGetterSetter {
  def setArray(key: String, value: Array[Any]): Array[Any]
  def getArray(key: String, value: Array[Any] = Array.empty): Array[Any]
}

trait CoreListGetterSetter {
  def setList(key: String, value: List[Any]): List[Any]
}

class CoreString extends Object with CoreStringGetterSetter {
  var StringKeys: Array[String] = Array.empty
  var StringValues: Array[String] = Array.empty

  def setString(key: String, value: String): String = {
    if (StringKeys.indexOf(key) > -1) {
      StringValues(StringKeys.indexOf(key)) = value
    } else {
      StringKeys = StringKeys :+ key
      StringValues = StringValues :+ value
    }
    value
  }
  def getString(key: String, value: String = ""): String = {
    if (StringKeys.indexOf(key) > -1) {
      StringValues(StringKeys.indexOf(key))
    } else {
      value
    }
  }
}

class CoreInt extends Object with CoreIntGetterSetter {
  var IntKeys: Array[String] = Array.empty
  var IntValues: Array[Int] = Array.empty

  def setInt(key: String, value: Int): Int = {
    if (IntKeys.indexOf(key) > -1) {
      IntValues(IntKeys.indexOf(key)) = value
    } else {
      IntKeys = IntKeys :+ key
      IntValues = IntValues :+ value
    }
    value
  }
  def getInt(key: String, value: Int = 0): Int = {
    if (IntKeys.indexOf(key) > -1) {
      IntValues(IntKeys.indexOf(key))
    } else {
      value
    }
  }
}

class CoreArray extends Object with CoreArrayGetterSetter {
  var ArrayKeys: Array[String] = Array.empty
  var ArrayValues: Array[Array[Any]] = Array.empty

  def setArray(key: String, value: Array[Any]): Array[Any] = {
    if (ArrayKeys.indexOf(key) > -1) {
      ArrayValues(ArrayKeys.indexOf(key)) = value
    } else {
      ArrayKeys = ArrayKeys :+ key
      ArrayValues = ArrayValues :+ value
    }
    value
  }
  def getArray(key: String, value: Array[Any] = Array.empty): Array[Any] = {
    if (ArrayKeys.indexOf(key) > -1) {
      ArrayValues(ArrayKeys.indexOf(key))
    } else {
      value
    }
  }
}

class CoreList extends Object with CoreListGetterSetter {
  var ListKeys: Array[String] = Array.empty
  var ListValues: Array[List[Any]] = Array.empty

  def setList(key: String, value: List[Any]): List[Any] = {
    if (ListKeys.indexOf(key) > -1) {
      ListValues(ListKeys.indexOf(key))
    } else {
      value
    }
  }
}
