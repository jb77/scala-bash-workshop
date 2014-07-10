import com.amtsybex.eventprocessing.applications.readingsstore._

import scala.xml._

object scratch {

    class C {
        private val x1 = 24
        def x = x1 * 2
    }

    val c = new C                                 //> c  : scratch.C = scratch$C@15a3d6b
    c.x                                           //> res0: Int = 48

    class Person {
        private var privateName = ""

        def name = privateName

        def name_=(value: String) = privateName = value
    }

    val john = new Person                         //> john  : scratch.Person = scratch$$anonfun$main$1$Person$1@1c1ea29
    john.name = "John Doe"
    println(john.name)                            //> John Doe

}