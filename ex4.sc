object ex4 {

  val y: Any = "something bar"                    //> y  : Any = something bar
  // Scala has a built-in general pattern matching mechanism.
  // It allows to match on any sort of data with a first-match policy.
  y match {
    case s: String if (s.contains("bar")) => s.length()
    case "something" => "ffo"
    case i: Int => i
    case _ => "default clause"
  }                                               //> res0: Any = 13

  // Most useful with Case Classes
  case class Calculator(make: String, model: String)
  val hp20b = Calculator("hp", "20B")             //> hp20b  : ex4.Calculator = Calculator(hp,20B)
  val hp30b = Calculator("hp", "30B")             //> hp30b  : ex4.Calculator = Calculator(hp,30B)

  def calcType(calc: Calculator) = calc match {
    case Calculator("hp", "20B") => "financial"
    case Calculator("hp", "48G") => "scientific"
    case Calculator("hp", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
  }                                               //> calcType: (calc: ex4.Calculator)String

  calcType(hp20b)                                 //> res1: String = financial
  calcType(hp30b)                                 //> res2: String = business

  // If the type defines an extractor (unapply) can do more sophisticated matching
  def x(l: List[_]) = l match {
    case (x :: xs) => xs
    case (x :: Nil) => Nil
    case Nil => throw new UnsupportedOperationException("foo")
  }                                               //> x: (l: List[_])List[Any]

  x(List(1, 2, 3, 4))                             //> res3: List[Any] = List(2, 3, 4)
  x(List(42))                                     //> res4: List[Any] = List()
  // x(Nil) will throw exception

  try {
    10 / 0
  } catch {
    case aex: ArithmeticException => "maths error"
    case _ => "oops"
  }                                               //> res5: Any = maths error

  // Write a pattern matching function that given a
  // small Cube returns its volume
  // large Cube throws an exception
  // Circle returns its area

  trait Shape
  case class Cube(s: Int) extends Shape { def volume = s * s * s }
  case class Circle(r: Int) extends Shape { def area = scala.math.Pi * r * r }

  def ex4(x: Shape) = {
    x match {
      case Cube(s) if s > 5 => throw new Exception("Big Cube")
      case cube: Cube => cube.volume
      case circ: Circle => circ.area
    }
  }                                               //> ex4: (x: ex4.Shape)AnyVal

  ex4(Circle(1))                                  //> res6: AnyVal = 3.141592653589793
  ex4(Cube(2))                                    //> res7: AnyVal = 8
  //ex4 ( Cube(20) )
  //ex4 ( "foo" )

}