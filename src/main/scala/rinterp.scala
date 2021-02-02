class rinterp {
  def parse(s : String): WAE = {
    var sub : String = ""
    var sArray = Array.empty[String]
    if (s.contains('(' & ')')) {
      sub = s.substring(s.indexOf('(') + 1, s.lastIndexOf(')'))
    }
    else {
      sub = s
    }
    //print(sub + "\n")
    if (sub.contains('(' & ')')) {
      sArray :+= sub.substring(0, sub.indexOf(" "))
      //println("Before split array: " + sub.substring(sub.indexOf("(")))
      var sb = ""
      var count : Int = 0
      var counted : Boolean = true
      for (curr <- sub.substring(sub.indexOf("("))) {
        if(curr == '(') {
          counted = false
          count += 1
        }
        else if(curr == ')') {
          count -= 1
        }
        sb :+= curr
        if(count == 0 & !counted) {
          sArray :+= sb
          sb = ""
          counted = true
        }
      }
      if(sArray.length != 3) {
        sArray :+= sb.substring(1)
      }
    }
    else {
      sArray = sub.split(' ')
    }
    //print(sArray.mkString("Array(", ", ", ")") + " " + sArray.length + "\n")
    if (sArray.length > 3) throw new RuntimeException("Invalid use of expression")

    sArray(0) match {
      case "+" => new PlusE(parse(sArray(1)), parse(sArray(2)))
      case "-" => new MinusE(parse(sArray(1)), parse(sArray(2)))
      case "*" => new MultE(parse(sArray(1)), parse(sArray(2)))
      case "/" => new DivE(parse(sArray(1)), parse(sArray(2)))
      case "with" =>
        //println(sArray.mkString("Array(", ", ", ")"))
        new withE(sArray(1).substring(2,3), parse(sArray(1).substring(4, sArray(1).lastIndexOf(']'))), parse(sArray(2)))
      case _ =>
          if (sArray(0) forall Character.isDigit) {
            new NumE(sArray(0).toInt)
          }
          else {
            new symE(sArray(0))
          }
    }
  }

  def calc(exp : WAE): Int = {
    exp.interp("", null)
  }

}
