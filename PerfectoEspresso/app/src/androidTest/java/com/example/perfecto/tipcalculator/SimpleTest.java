package com.example.perfecto.tipcalculator;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SimpleTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void simpleTest() {
        ViewInteraction editText = onView(
                withId(R.id.bill_value));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.bill_value));
        editText2.perform(scrollTo(), replaceText("50"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.tip_percent_input),
                        withParent(withId(R.id.tip_percent_container))));
        editText3.perform(scrollTo(), replaceText("12"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.split_number_input),
                        withParent(withId(R.id.split_number_container))));
        editText4.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.split_number_input), withText("2"),
                        withParent(withId(R.id.split_number_container))));
        editText5.perform(pressImeActionButton());

        ViewInteraction button = onView(
                allOf(withId(R.id.calculate_tips), withText("Calculate tip"), isDisplayed()));
        button.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.total_to_pay_result), withText("56"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                7),
                        isDisplayed()));
        textView.check(matches(withText("56")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.total_tip_result), withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                9),
                        isDisplayed()));
        textView2.check(matches(withText("6")));


        ViewInteraction textView4 = onView(
                allOf(withId(R.id.tip_per_person_result), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                11),
                        isDisplayed()));
        textView4.check(matches(withText("3")));

    }

    @Test
    public void simpleTestt() {
        ViewInteraction editText = onView(
                withId(R.id.bill_value));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.bill_value));
        editText2.perform(scrollTo(), replaceText("50"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.tip_percent_input),
                        withParent(withId(R.id.tip_percent_container))));
        editText3.perform(scrollTo(), replaceText("12"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.split_number_input),
                        withParent(withId(R.id.split_number_container))));
        editText4.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.split_number_input), withText("2"),
                        withParent(withId(R.id.split_number_container))));
        editText5.perform(pressImeActionButton());

        ViewInteraction button = onView(
                allOf(withId(R.id.calculate_tips), withText("Calculate tip"), isDisplayed()));
        button.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.total_to_pay_result), withText("56"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                7),
                        isDisplayed()));
        textView.check(matches(withText("56")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.total_tip_result), withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                9),
                        isDisplayed()));
        textView2.check(matches(withText("6")));


        ViewInteraction textView4 = onView(
                allOf(withId(R.id.tip_per_person_result), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll_content),
                                        0),
                                11),
                        isDisplayed()));
        textView4.check(matches(withText("3")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
