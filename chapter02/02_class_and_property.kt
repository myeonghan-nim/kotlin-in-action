package kotlinInAction.classAndProperty

import kotlinInAction.shapes.createRandomRectangle

class Person(
    val name: String,
    var isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
    // class and property
    val person = Person("Kotlin", true)

    println(person.name)
    println(person.isMarried)

    person.isMarried = false

    // custom property
    val rectangle = Rectangle(30, 40)
    println(rectangle.isSquare)

    // package
    println(createRandomRectangle().isRealSquare)
}
