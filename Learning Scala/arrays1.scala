
import scala.collection.mutable
import scala.collection.immutable.HashSet


val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

println("\n")

val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")

println("\n")

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to Island")
treasureMap += (2 -> "Fing big X on ground")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

println("\n")

var romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
    )
println(romanNumeral(4))

println("\n")
