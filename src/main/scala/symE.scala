class symE(var a: String) extends WAE {
  private var _a = a

  override def interp(c : String, x: WAE): Int = {
    if(x == null || _a != c) {
      0
    }
    else {
      x.interp("", null)
    }
  }

  override def toString: String = _a
}
