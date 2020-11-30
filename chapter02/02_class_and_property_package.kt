package kotlinInAction.shapes

import java.util.Random

class RealRectangle(val height: Int, val width: Int) {
    val isRealSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): RealRectangle {
    val random = Random()
    return RealRectangle(random.nextInt(), random.nextInt())
}
