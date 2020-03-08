package com.app.weatherapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        /*
        *
        * @RunWith(AndroidJUnit4::class)
class NavTest {
    @Test
    fun test() {
        val navDeepLink = NavDeepLink("scheme://host/path\\?query1={query_value1}&query2={query_value2}")
        val deepLink = Uri.parse("scheme://host/path?query1=foo_bar&query2=baz")

        val bundle = navDeepLink.getMatchingArguments(deepLink)!!
        assertTrue(bundle.get("query_value1") == "foo_bar")
        assertTrue(bundle.get("query_value2") == "baz")
    }
}
        * */
    }
}
