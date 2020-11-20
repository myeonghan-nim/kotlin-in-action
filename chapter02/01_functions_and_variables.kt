fun helloWorld() {
    println("Hello World!")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun variables(isTrue: Boolean): String {
    val message: String

    if (isTrue == true) {
        message = "Success"
    } else {
        message = "Failed"
    }

    return message
}

fun greeting(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Java?"
    println("Hello $name!")
}

fun call(args: Array<String>) {
    println("Hello ${if (args.size > 0) args[0] else "someone"}!")
}

fun main() {
    // functions
    helloWorld()
    println(max(1, 2))

    // variables
    val question = "Ultimate question about life, space and all-things"
    val answer = 42
    println("$question, $answer")

    println(variables(false))

    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    println(languages)

    // string template
    greeting(arrayOf())
    greeting(arrayOf("Kotlin"))
    call(arrayOf())
}
