object ex6 {

    // tuple combines a fixed number of items, of (potentially) different types
    // Contrast with list (variable number of items of the same type)

    // Declaring a tuple (a pair in this case)
    val t = (10, "abcdefghi")                     //> t  : (Int, String) = (10,abcdefghi)
    // accessing members - note that it's 1-based not 0-based like an array
    t._1                                          //> res0: Int = 10
    t._2                                          //> res1: String = abcdefghi

    // Can have more members than 2!
    val triple = ("abcef", 'b', 10.0f)            //> triple  : (String, Char, Float) = (abcef,b,10.0)
    triple._3                                     //> res2: Float = 10.0

    // Can use tuple types in functions
    def tuplef(tpl: (Int, Int)) = tpl._1 + tpl._2 //> tuplef: (tpl: (Int, Int))Int
    tuplef((10, 20))                              //> res3: Int = 30

    val l = List("abc", "defghi", "jk")           //> l  : List[String] = List(abc, defghi, jk)
    val (heads, tailSizes) = l.unzip(x => (x.head, x.tail.size))
                                                  //> heads  : List[Char] = List(a, d, j)
                                                  //| tailSizes  : List[Int] = List(2, 5, 1)

    heads.zip(tailSizes)                          //> res4: List[(Char, Int)] = List((a,2), (d,5), (j,1))

    t.swap                                        //> res5: (String, Int) = (abcdefghi,10)

    //////// Option
    // introduced to deal with the dreaded NullPointerException!

    val m = Map(
        14 -> "foo",
        7 -> "bar",
        39 -> "donkey")                           //> m  : scala.collection.immutable.Map[Int,String] = Map(14 -> foo, 7 -> bar, 3
                                                  //| 9 -> donkey)

    // compare two ways of getting values out:
    m(14)                                         //> res6: String = foo
    val g = m.get(14)                             //> g  : Option[String] = Some(foo)

    // m(4)  // BOOM NoSuchElementException: key not found: 4

    val h = m.get(4)                              //> h  : Option[String] = None

    // Some & None are the concrete sub types of the abstract Option super type

    // then use existing 'collection' methods to work with them...
    // think of them as collections of 0 or 1 elements...
    g.map(_.length)                               //> res7: Option[Int] = Some(3)
    h.map(_.length)                               //> res8: Option[Int] = None

    // or if you prefer - use pattern matching
    g match {
        case Some(x) => x.length
        case None => None
    }                                             //> res9: Any = 3

    g.getOrElse("")                               //> res10: String = foo
    h.getOrElse("")                               //> res11: String = ""

    // Exercise
    // Write a function that returns the head & the sum of a List[Option[Int]]
    def headAndSum(is: List[Option[Int]]): (Option[Int], Int) = {
        val sum = is.map(_.getOrElse(0)).sum
        val head = is.head
        (head, sum)
    }                                             //> headAndSum: (is: List[Option[Int]])(Option[Int], Int)

    headAndSum(List(Some(0), None, Some(5), Some(7)))
                                                  //> res12: (Option[Int], Int) = (Some(0),12)
    headAndSum(List(None))                        //> res13: (Option[Int], Int) = (None,0)
    headAndSum(List())                            //> java.util.NoSuchElementException: head of empty list
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:337)
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:334)
                                                  //| 	at ex6$$anonfun$main$1.headAndSum$1(ex6.scala:63)
                                                  //| 	at ex6$$anonfun$main$1.apply$mcV$sp(ex6.scala:69)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at ex6$.main(ex6.scala:1)
                                                  //| 	at ex6.main(ex6.scala)

}