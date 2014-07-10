object motivatingexample {


    // flatten and flatmap
    val xs = List(1, 2, 3, 4, 5)                  //> xs  : List[Int] = List(1, 2, 3, 4, 5)
		def neighbours(x:Int)= List(x-1,x,x+1)
                                                  //> neighbours: (x: Int)List[Int]
    val listOfLists=xs.map(neighbours)            //> listOfLists  : List[List[Int]] = List(List(0, 1, 2), List(1, 2, 3), List(2, 
                                                  //| 3, 4), List(3, 4, 5), List(4, 5, 6))
    listOfLists.flatten                           //> res0: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)
    xs.flatMap(neighbours)                        //> res1: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)
    // maps then flattens



    // domain model
    case class Item(stockCode: String, value: Float)
    case class Address(streetName: String, houseNumber: String, postCode: String)
    case class Person(name: String, age: Int)
    case class Order(deliveryAddress: Address, billingAddress: Address, items: List[Item], customer: Person)

    // find the average value of adult's purchases grouped by postcode (i.e. average in each postcode)
    def query(orders: Seq[Order]): Map[String, Float] = {
        val adultsOrders = orders.filter(_.customer.age >= 18)
        val ordersByPostcode = adultsOrders.groupBy(_.billingAddress.postCode)

        def avgOrderPrice(orders: Seq[Order]) = {
            val items = orders.flatMap(_.items)
            items.map(_.value).sum / items.size
        }

        ordersByPostcode.map(sos => (sos._1, avgOrderPrice(sos._2)))
    }                                             //> query: (orders: Seq[motivatingexample.Order])Map[String,Float]

    def createTestData = 1.to(20).map(createOrder(_))
                                                  //> createTestData: => scala.collection.immutable.IndexedSeq[motivatingexample.
                                                  //| Order]

    def createOrder(i: Int): Order = {
        val a = Address("abc street", "123", "BT" + i + "AB")
        val p = Person("John Smith", i + 10)

        val items = List(
            Item("ZI000001", i),
            Item("ZI000002", 0.55f),
            Item("ZI000003", 75.45f))

        Order(a, a, items, p)
    }                                             //> createOrder: (i: Int)motivatingexample.Order

    query(createTestData)                         //> res2: Map[String,Float] = Map(BT14AB -> 30.0, BT17AB -> 31.0, BT15AB -> 30.
                                                  //| 333334, BT12AB -> 29.333334, BT20AB -> 32.0, BT9AB -> 28.333334, BT18AB -> 
                                                  //| 31.333334, BT19AB -> 31.666666, BT13AB -> 29.666666, BT16AB -> 30.666666, B
                                                  //| T8AB -> 28.0, BT10AB -> 28.666666, BT11AB -> 29.0)

}


 
 
 