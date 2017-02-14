/**
 * Created by keith on 14/02/2017.
 */

/**
 * A higher-order function that takes a function as a parameter.
 *
 * This is a somewhat crude implementation of a map() function with an
 * additional parameter - don't stress about the details, it's just to
 * illustrate the usage below it.
 *
 * Look at 'doMoreStuff()' below to see the different ways we can call it.
 */
fun List<Int>.mapWithConstant( constant: Int, operation: (Int, Int) -> Int): List<Int> {

    val result : MutableList<Int> = mutableListOf()

    (0..this.size).forEach {
        val current = this[it]
        val newThing = operation(constant, current)
        result.add(newThing)
    }

    return result
}

/**
 * Many ways of calling the above higher-order function.
 *
 * All of these do exactly the same thing, just the syntax is different.
 */
fun doMoreStuff() {

    val list = (1..5).toList()

    // OPTION ONE: pass an externally defined function reference
    fun add(a: Int, b: Int) = a + b
    list.mapWithConstant(3, ::add)








    // OPTION TWO: fully explicitly defined anonymous function:
    list.mapWithConstant(3, fun(a: Int, b: Int): Int {
        return a + b
    })








    // OPTION THREE: Lambda with named parameter(s)
    list.mapWithConstant(3) { a: Int, b: Int -> a + b }








    // OPTION FOUR: Lambda with named parameter(s) - inferred types
    list.mapWithConstant(3) { a, b -> a + b }






    // OPTION FOUR :different formatting:
    list.mapWithConstant(3) {
        a, b -> a + b
    }


    // OPTION FIVE: Lambda with default parameter 'it'
    // NOT AN OPTION WITH TWO PARAMS

}