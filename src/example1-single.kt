/**
 * Created by keith on 14/02/2017.
 */

/**
 * A higher-order function that takes a function as a parameter.
 *
 * This is a somewhat crude implementation of a map() function - don't
 * stress about the details, it's just to illustrate the usage below it.
 *
 * Look at 'doStuff()' below to see the different ways we can call it.
 */
fun <K, V> List<K>.myMap( mapfun: (K) -> V ): List<V> {

    val result : MutableList<V> = mutableListOf()

    (0..this.size).forEach {
        val current: K = this[it]
        val newThing: V = mapfun(current)
        result.add(newThing)
    }

    return result
}

/**
 * Many ways of calling the above higher-order function.
 *
 * All of these do exactly the same thing, just the syntax is different.
 */
fun doStuff() {

    val list = listOf("one", "two", "three")



    // OPTION ONE: named function defined outside the main call
    fun ucase(input: String): String = input.toUpperCase()
    list.myMap(::ucase)






    // OPTION ONE (variant) - as toUpperCase() already exists on String, we can do this:
    list.myMap(String::toUpperCase)






    // OPTION TWO: explicitly defined anonymous function
    list.myMap( fun(input: String): String {
        return input.toUpperCase()
    })






    // OPTION THREE: Lambda with named parameter(s)
    list.myMap { input: String -> input.toUpperCase() }







    // OPTION FOUR: Lambda with default parameter 'it'
    list.myMap { it.toUpperCase() }







    // OPTION FOUR with different formatting:
    list.myMap {
        it.toUpperCase()
    }
}
