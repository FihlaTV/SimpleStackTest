package elton.com.simplestacktest.feature

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Before
    fun setUp() {
        val application = TestBaseApplication()
        application.createComponent()
        // Use mockWebServer if web server response is needed to be tested
        application.mockWebServer

        TestBaseApplication.setuUpRxSchedulers()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
