class withE(var a: String, var what: WAE, var in: WAE) extends WAE {
  private var _a = a
  private var _what = what
  private var _in = in

  override def interp(c : String, x : WAE): Int = {
    _in.interp(_a, _what)
  }

  override def toString: String = "(withE ([" + _a + " " + what.toString + "]) " + in.toString + ")"

}
