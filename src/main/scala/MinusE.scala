class MinusE(var lhs: WAE, var rhs: WAE) extends WAE {
  private var _lhs = lhs
  private var _rhs = rhs

  override def interp(c : String, x : WAE): Int = _lhs.interp(c, x) - _rhs.interp(c, x)

  override def toString: String = "(MinusE " + _lhs.toString + " " + _rhs.toString + ")"
}
