package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  def pascal(c: Int, r: Int): Int = {
    if (c == r || (c == 0)) 1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
//  def balance(chars: String): Boolean = {
    def balance(chars: List[Char]): Boolean = {
//    def chatsToList = chars.toList
    def balanced(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) open == 0
      else if (chars.head == '(') balanced(chars.tail, open + 1)
      else if (chars.head == ')') open > 0 && balanced(chars.tail, open - 1)
      else balanced(chars.tail, open)
    }
    balanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def calc(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0
      else if (money == 0) 1
      else calc(money, coins.tail) + calc(money - coins.head, coins)
    }
    calc(money, coins)
  }
