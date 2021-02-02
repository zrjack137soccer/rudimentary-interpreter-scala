class NumE(var n: Int) extends WAE {
  private var _n = n

  override def interp(c : String, x : WAE): Int = n

  override def toString: String = "(NumE " + Integer.toString(n) + ")"
}
