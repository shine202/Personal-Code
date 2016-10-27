
println("\nHello world, from a script \n")

//Say hello to Scala
println("Hello, " + args(0) + "!\n")

// To Loop
var i = 0
while (i < args.length) {
    println(args(i))
    i += 1
}

println("\n\n")

// Even more fun
var s = 0
while (s < args.length) {
    if(s != 0) {
        print(" ")
    }
    print(args(s))
    s += 1
}

println("\n\n")

args.foreach((arg: String) => println(arg))