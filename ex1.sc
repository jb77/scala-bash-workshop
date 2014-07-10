object ex1 {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  println("hello world")                          //> hello world

  // Type inference & lack of semicolons
  val x = 42                                      //> x  : Int = 42
  val y = "hgttg"                                 //> y  : String = hgttg
  // can specify types if needed...
  val z: String = "abcdef"                        //> z  : String = abcdef

  // vals are immutable
  // x=45 ...is a compile error
  var m = 10                                      //> m  : Int = 10
  m = 20

  // IF **expression** everything is an expression - returns a value
  val r = if (x == 42) "ok" else "notok"          //> r  : String = ok

  // String equality
  y == "hgttg"                                    //> res0: Boolean = true

  /*
		I use the terms method and function interchangeably in the discussion.
		This is a simplification.
		In many situations, you can ignore the difference between functions and methods
		and just think of them as the same thing,
		but occasionally you may run into a situation in which the difference matters.
	*/

  // first method, walk through syntax.
  // Keyword, argument, return type inferred, equals, no return keyword needed (last expression is returned automatically)
  // importance of equals sign, or it returns Unit (void) and it's a procedure
  def cube(i: Int) = i * i * i                    //> cube: (i: Int)Int
  // no curly braces needed for single expression methods

  // calling method
  cube(10)                                        //> res1: Int = 1000

  // ex1a: write a function to compare the length of two strings and return true if the 1st is longer
  def cmp(s: String, t: String) = s.length > t.length
                                                  //> cmp: (s: String, t: String)Boolean
  cmp("ab", "abc")                                //> res2: Boolean = false
  cmp("ab", "abc")                                //> res3: Boolean = false
  cmp("abcd", "abc")                              //> res4: Boolean = true

  // ex1b: write a function to compute factorials for non-zero Nats (e.g. factorial(5) = 5 * 4 *3 * 2 * 1
  def factorial(i: Int): Int = {
    if (i == 1) i
    else i * factorial(i - 1)
  }                                               //> factorial: (i: Int)Int

  factorial(1)                                    //> res5: Int = 1

  factorial(10)                                   //> res6: Int = 3628800

  // not tail recursive (would need accumulator?)

}