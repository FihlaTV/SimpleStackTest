package elton.com.simplestacktest.feature

import android.content.pm.ActivityInfo
import android.support.test.espresso.Espresso
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by elton on 16/04/2018.
 */

@RunWith(AndroidJUnit4::class)
class ActivityTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(rule.activity.idlingResource)
    }

    @After
    fun pullDown() {
        Thread.sleep(1000)
    }

    @Test
    fun generalTest() {
        Thread.sleep(5000)

        Espresso.onView(ViewMatchers.withId(R.id.nextButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.firstButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.pressBack()

        Thread.sleep(3000)
    }

    @Test
    fun dashboardTest() {

        Espresso.onView(ViewMatchers.withId(R.id.nextButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Thread.sleep(3000)
    }

    @Test
    fun rotateActivityTest() {
        Thread.sleep(5000)

        Espresso.onView(ViewMatchers.withId(R.id.nextButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.firstButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Thread.sleep(1000)
        rule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.navigation_first))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())

        Espresso.pressBack()

        Thread.sleep(1000)
        rule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Thread.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())
    }
}