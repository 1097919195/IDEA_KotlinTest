fun main(args: Array<String>) {
    println("Hello, world!")

    println(max(1, 2))

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")
    println("\$x!")
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
    val person = Person("zjl",false)
    person.isMarried = true
    println(person.name)

    Num(1)
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))


    aa()
    println(bb("123"))
    println(cc("123"))

}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun aa() = println("aa")
fun bb( b : String) : String {
    println("bb")
    return b
}
fun cc( b : String) : String = b
