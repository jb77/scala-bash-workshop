object ex7 {
    
    
    // Another approach to Error handling

    def divide(a: Int, b: Int): Int = a / b       //> divide: (a: Int, b: Int)Int

    divide(10, 5)                                 //> res0: Int = 2
    //divide(10,0) // BOOM java.lang.ArithmeticException: / by zero

    // Try is a bit like Option - but allows an exception to be returned rather than just None
    // Try is abstract super type, Success & Failure are its concrete subtypes
    // contrast with keyword "try"
    import scala.util.Try
    def safeDivide(a: Int, b: Int): Try[Int] = Try { a / b }
                                                  //> safeDivide: (a: Int, b: Int)scala.util.Try[Int]

    val x = safeDivide(10, 5)                     //> x  : scala.util.Try[Int] = Success(2)
    val y = safeDivide(10, 0)                     //> y  : scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero)
                                                  //| 

    x.map(_ + 2)                                  //> res1: scala.util.Try[Int] = Success(4)
    y.map(_ + 2)                                  //> res2: scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero
                                                  //| )
    x.isSuccess                                   //> res3: Boolean = true



    // XML

    val someXML = <person>
                      <name>Joe Bloggs</name>
                      <age>21</age>
                  </person>                       //> someXML  : scala.xml.Elem = <person>
                                                  //|                       <name>Joe Bloggs</name>
                                                  //|                       <age>21</age>
                                                  //|                   </person>

    someXML \\ "name"                             //> res4: scala.xml.NodeSeq = NodeSeq(<name>Joe Bloggs</name>)

    // Can load from URL
    //val cat=scala.xml.XML.load(new java.net.URL("http://www.w3schools.com/xml/cd_catalog.xml"))

    val file = new java.io.File("""C:\Users\bunchj\Desktop\talks\intro_workshop/cd_catalog.xml""")
                                                  //> file  : java.io.File = C:\Users\bunchj\Desktop\talks\intro_workshop\cd_cata
                                                  //| log.xml
    val catalog = scala.xml.XML.loadFile(file)    //> catalog  : scala.xml.Elem = <CATALOG>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Empire Burlesque</TITLE>
                                                  //| 		<ARTIST>Bob Dylan</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>Columbia</COMPANY>
                                                  //| 		<PRICE>10.90</PRICE>
                                                  //| 		<YEAR>1985</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Hide your heart</TITLE>
                                                  //| 		<ARTIST>Bonnie Tyler</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>CBS Records</COMPANY>
                                                  //| 		<PRICE>9.90</PRICE>
                                                  //| 		<YEAR>1988</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Greatest Hits</TITLE>
                                                  //| 		<ARTIST>Dolly Parton</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>RCA</COMPANY>
                                                  //| 		<PRICE>9.90</PRICE>
                                                  //| 		<YEAR>1982</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Still got the blues</TITLE>
                                                  //| 		<ARTIST>Gary Moore</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Virgin records</COMPANY>
                                                  //| 		<PRICE>10.20</PRICE>
                                                  //| 		<YEAR>1990</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Eros</TITLE>
                                                  //| 		<ARTIST>Eros Ramazzotti</ARTIST>
                                                  //| 		<COUNTRY>EU</COUNTRY>
                                                  //| 		<COMPANY>BMG</COMPANY>
                                                  //| 		<PRICE>9.90</PRICE>
                                                  //| 		<YEAR>1997</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>One night only</TITLE>
                                                  //| 		<ARTIST>Bee Gees</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Polydor</COMPANY>
                                                  //| 		<PRICE>10.90</PRICE>
                                                  //| 		<YEAR>1998</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Sylvias Mother</TITLE>
                                                  //| 		<ARTIST>Dr.Hook</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>CBS</COMPANY>
                                                  //| 		<PRICE>8.10</PRICE>
                                                  //| 		<YEAR>1973</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Maggie May</TITLE>
                                                  //| 		<ARTIST>Rod Stewart</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Pickwick</COMPANY>
                                                  //| 		<PRICE>8.50</PRICE>
                                                  //| 		<YEAR>1990</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Romanza</TITLE>
                                                  //| 		<ARTIST>Andrea Bocelli</ARTIST>
                                                  //| 		<COUNTRY>EU</COUNTRY>
                                                  //| 		<COMPANY>Polydor</COMPANY>
                                                  //| 		<PRICE>10.80</PRICE>
                                                  //| 		<YEAR>1996</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>When a man loves a woman</TITLE>
                                                  //| 		<ARTIST>Percy Sledge</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>Atlantic</COMPANY>
                                                  //| 		<PRICE>8.70</PRICE>
                                                  //| 		<YEAR>1987</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Black angel</TITLE>
                                                  //| 		<ARTIST>Savage Rose</ARTIST>
                                                  //| 		<COUNTRY>EU</COUNTRY>
                                                  //| 		<COMPANY>Mega</COMPANY>
                                                  //| 		<PRICE>10.90</PRICE>
                                                  //| 		<YEAR>1995</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>1999 Grammy Nominees</TITLE>
                                                  //| 		<ARTIST>Many</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>Grammy</COMPANY>
                                                  //| 		<PRICE>10.20</PRICE>
                                                  //| 		<YEAR>1999</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>For the good times</TITLE>
                                                  //| 		<ARTIST>Kenny Rogers</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Mucik Master</COMPANY>
                                                  //| 		<PRICE>8.70</PRICE>
                                                  //| 		<YEAR>1995</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Big Willie style</TITLE>
                                                  //| 		<ARTIST>Will Smith</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>Columbia</COMPANY>
                                                  //| 		<PRICE>9.90</PRICE>
                                                  //| 		<YEAR>1997</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Tupelo Honey</TITLE>
                                                  //| 		<ARTIST>Van Morrison</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Polydor</COMPANY>
                                                  //| 		<PRICE>8.20</PRICE>
                                                  //| 		<YEAR>1971</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Soulsville</TITLE>
                                                  //| 		<ARTIST>Jorn Hoel</ARTIST>
                                                  //| 		<COUNTRY>Norway</COUNTRY>
                                                  //| 		<COMPANY>WEA</COMPANY>
                                                  //| 		<PRICE>7.90</PRICE>
                                                  //| 		<YEAR>1996</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>The very best of</TITLE>
                                                  //| 		<ARTIST>Cat Stevens</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Island</COMPANY>
                                                  //| 		<PRICE>8.90</PRICE>
                                                  //| 		<YEAR>1990</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Stop</TITLE>
                                                  //| 		<ARTIST>Sam Brown</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>A and M</COMPANY>
                                                  //| 		<PRICE>8.90</PRICE>
                                                  //| 		<YEAR>1988</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Bridge of Spies</TITLE>
                                                  //| 		<ARTIST>T'Pau</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Siren</COMPANY>
                                                  //| 		<PRICE>7.90</PRICE>
                                                  //| 		<YEAR>1987</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Private Dancer</TITLE>
                                                  //| 		<ARTIST>Tina Turner</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>Capitol</COMPANY>
                                                  //| 		<PRICE>8.90</PRICE>
                                                  //| 		<YEAR>1983</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Midt om natten</TITLE>
                                                  //| 		<ARTIST>Kim Larsen</ARTIST>
                                                  //| 		<COUNTRY>EU</COUNTRY>
                                                  //| 		<COMPANY>Medley</COMPANY>
                                                  //| 		<PRICE>7.80</PRICE>
                                                  //| 		<YEAR>1983</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Pavarotti Gala Concert</TITLE>
                                                  //| 		<ARTIST>Luciano Pavarotti</ARTIST>
                                                  //| 		<COUNTRY>UK</COUNTRY>
                                                  //| 		<COMPANY>DECCA</COMPANY>
                                                  //| 		<PRICE>9.90</PRICE>
                                                  //| 		<YEAR>1991</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>The dock of the bay</TITLE>
                                                  //| 		<ARTIST>Otis Redding</ARTIST>
                                                  //| 		<COUNTRY>USA</COUNTRY>
                                                  //| 		<COMPANY>Atlantic</COMPANY>
                                                  //| 		<PRICE>7.90</PRICE>
                                                  //| 		<YEAR>1987</YEAR>
                                                  //| 	</CD>
                                                  //| 	<CD>
                                                  //| 		<TITLE>Picture book</TITLE>
                                                  //| 		<ARTIST>Simply Red</ARTIST>
                                                  //| 		<COUNTRY>E
                                                  //| Output exceeds cutoff limit.

    // Exercise - Write a function to find the price of the most expensive CD in the catalog
    // make sure the return type accounts for possible Failure
    (catalog \\ "PRICE").map(_.text.toFloat).max  //> res5: Float = 10.9
    
    
    def fetchMostExp(loc:String) : Try[Float] = {
    	Try {
    		val cat=scala.xml.XML.load(loc)
    		(cat \\ "PRICE").map(_.text.toFloat).max
    	}
    }                                             //> fetchMostExp: (loc: String)scala.util.Try[Float]
    
    fetchMostExp("http://www.w3schools.com/xml/cd_catalog.xml")
                                                  //> res6: scala.util.Try[Float] = Failure(java.net.ConnectException: Connection
                                                  //|  timed out: connect)

}