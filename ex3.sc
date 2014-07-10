object ex3 {

  // Collections - lists, sets, maps

  // note apply method on List companion object
  // note polymorphism
  val nums = List(1, 2, 3, 4, 5)                  //> nums  : List[Int] = List(1, 2, 3, 4, 5)
  val strs = List("abc", "def", "ghijk")          //> strs  : List[String] = List(abc, def, ghijk)
  List()                                          //> res0: List[Nothing] = List()
  1.to(20)                                        //> res1: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  Set(1, 1, 2, 2, 2, 2, 2)                        //> res2: scala.collection.immutable.Set[Int] = Set(1, 2)

  Map("a" -> 1, "b" -> 2, "c" -> 3)               //> res3: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 
                                                  //| 3)

  // discuss immutable collections at this point?

  // contrast with Java equivalent

  // Lambdas (small,pure, anonymous functions) and Higher Order Functions

  // map (verb not noun) applies the function you supply to all elements of the collection to create a new collection
  strs.map(_.size)                                //> res4: List[Int] = List(3, 3, 5)
  // OR
  strs.map(s => s.size)                           //> res5: List[Int] = List(3, 3, 5)
  // OR
  strs.map((s: String) => s.size)                 //> res6: List[Int] = List(3, 3, 5)

  // OR
  def sz(s: String): Int = s.size                 //> sz: (s: String)Int
  strs.map(sz)                                    //> res7: List[Int] = List(3, 3, 5)

  // filter selects only elements that pass some predicate function:
  nums.filter(_ < 4)                              //> res8: List[Int] = List(1, 2, 3)
  nums.filter(_ % 2 == 0)                         //> res9: List[Int] = List(2, 4)
  nums.filter(n => n < 4)                         //> res10: List[Int] = List(1, 2, 3)
  nums.filterNot(n => n < 4)                      //> res11: List[Int] = List(4, 5)

  // partition breaks a list into two lists, according to some predicate input function
  nums.partition(_ % 2 == 0)                      //> res12: (List[Int], List[Int]) = (List(2, 4),List(1, 3, 5))

  // Ex 3: create a list containing the odd numbers from 1 to 25, with those divisible by 5 replaced by "fizz"
  1.to(25).filter(_ % 2 != 0).map(n => if (n % 5 == 0) "fizz" else n)
                                                  //> res13: scala.collection.immutable.IndexedSeq[Any] = Vector(1, 3, fizz, 7, 9
                                                  //| , 11, 13, fizz, 17, 19, 21, 23, fizz)
  val oddNums = 1.to(25).filter(_ % 2 != 0)       //> oddNums  : scala.collection.immutable.IndexedSeq[Int] = Vector(1, 3, 5, 7, 
                                                  //| 9, 11, 13, 15, 17, 19, 21, 23, 25)
  oddNums.map(n => if (n % 5 == 0) "fizz" else n) //> res14: scala.collection.immutable.IndexedSeq[Any] = Vector(1, 3, fizz, 7, 9
                                                  //| , 11, 13, fizz, 17, 19, 21, 23, fizz)

}