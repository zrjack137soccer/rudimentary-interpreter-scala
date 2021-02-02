class DivE(var lhs: WAE, var rhs: WAE) extends WAE {
  private var _lhs = lhs
  private var _rhs = rhs

  override def interp(c : String, x : WAE): Int = {
    if(_rhs.interp(c, x) == 0) {
      throw new ArithmeticException("Cannot divide by zero")
    }
    else {
      _lhs.interp(c, x) / _rhs.interp(c, x)
    }
  }

  override def toString: String = "(DivE " + _lhs.toString + " " + _rhs.toString + ")"
}
