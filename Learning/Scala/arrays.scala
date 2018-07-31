
var big = new java.math.BigInteger("12345")

var greetString: Array[String] = new Array[String](3)

greetString.update(0, "Hello")
greetString.update(1, ", ")
greetString.update(2, "World!\n\n")

for (i <- 0 to 2)
    print(greetString.apply(i))

var oneTwo = List(1, 2)
var threeFour = List(3, 4)
var oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were note mutated")
println("Thus, " + oneTwoThreeFour + " is a new List.\n")

var pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

println("\n\n")

var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))