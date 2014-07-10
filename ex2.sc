object ex2 {

  // class declaration, constructor, val modifier to get getter, var modifier to get setter
  class Circle(var radius: Float, val xPos: Float, yPos: Float) {
    def area = scala.math.Pi * radius * radius
  }
  // replaces ~40 lines of equivalent Java code, with 3 - probably easier to read too

  // create an instance and use it
  val c = new Circle(10, 5, 5)                    //> c  : ex2.Circle = ex2$Circle@77664cb5
  c.area                                          //> res0: Double = 314.1592653589793
  c.radius                                        //> res1: Float = 10.0
  c.radius = 20
  c.area                                          //> res2: Double = 1256.6370614359173
  // c.xPos=40 not allowed
  // c.yPos not allowed

  // for declaring singletons
  // equivalence to static in Java
  // companion object naming convention
  object Circle {
    def perimeter(circ: Circle) = circ.radius * 2 * scala.math.Pi

    // special status of apply method
    def apply(r: Float) = new Circle(r, 0, 0) // factory method
  }

  // can collect functions separately from data, or have them as methods in a class
  Circle.perimeter(c)                             //> res3: Double = 125.66370614359172

  // special call to apply method
  Circle(3).area                                  //> res4: Double = 28.274333882308138

  case class Sphere(radius: Float, xPos: Float, yPos: Float, zPos: Float)
  val s = Sphere(1.5f, 50, 50, 50)                //> s  : ex2.Sphere = Sphere(1.5,50.0,50.0,50.0)
  // case classes are a handy sort of class
  // constructor args are vals by default (automatic getters)
  // automatic equals and hashcode methods based on constructor args
  // don't have to write new
  // can "pattern match" on them

  // ex2: write a class to represent a cube with a volume method
  case class Cuboid(
    h: Float, w: Float, d: Float,
    xPos: Float=0, yPos: Float=0, zPos: Float=0) {

    def volume = h * w * d

  }
  
  // example solution using named arguments and defaults
  Cuboid(
  	h = 5,
  	w = 5,
  	d = 5
  ).volume                                        //> res5: Float = 125.0

}