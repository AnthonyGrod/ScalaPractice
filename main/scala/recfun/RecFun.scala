package recfun

object RecFun extends RecFunInterface:
  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int) : Int = 
    if ((c == 0) || (c == r)) then return 1
    else return (pascal(c, r - 1) + pascal(c - 1, r - 1))

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]) : Boolean = {
    val x = true

    def is_proper(weight: Int) : Boolean = 
      if weight != 0 then false
      else true

    def update_weight(weight: Int, char: Char) : Int = 
      if char == '(' then weight + 1
      else if char == ')' then weight - 1
      else weight

    def balance_with_weights(chars: List[Char], weight: Int, is_ok: Boolean) : Boolean =
      if chars.isEmpty then return is_ok
      else if (weight < 0) then return false
      return balance_with_weights(chars.tail, update_weight(weight, chars.head), is_proper(update_weight(weight, chars.head)))

    val res = balance_with_weights(chars, 0, x)
    return res
  }

