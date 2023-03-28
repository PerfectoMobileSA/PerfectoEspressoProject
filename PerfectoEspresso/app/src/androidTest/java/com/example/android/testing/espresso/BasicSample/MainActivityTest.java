package com.example.android.testing.espresso.BasicSample;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    @LargeTest
    public void mainActivityTest() {
        for(int i = 0; i < 5; i++) {
            ViewInteraction editText = onView(
                    allOf(withId(R.id.editTextUserInput),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText.perform(replaceText("123"), closeSoftKeyboard());

            ViewInteraction button = onView(
                    allOf(withId(R.id.changeTextBt), withText("Change Heading!"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            button.perform(click());

            ViewInteraction editText2 = onView(
                    allOf(withId(R.id.editTextUserInput), withText("123"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText2.perform(click());

            ViewInteraction editText3 = onView(
                    allOf(withId(R.id.editTextUserInput), withText("123"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText3.perform(click());

            ViewInteraction editText4 = onView(
                    allOf(withId(R.id.editTextUserInput), withText("123"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText4.perform(click());

            ViewInteraction editText5 = onView(
                    allOf(withId(R.id.editTextUserInput), withText("123"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText5.perform(replaceText(""));

            ViewInteraction editText6 = onView(
                    allOf(withId(R.id.editTextUserInput),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText6.perform(closeSoftKeyboard());

            ViewInteraction editText7 = onView(
                    allOf(withId(R.id.editTextUserInput),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText7.perform(click());

            ViewInteraction editText8 = onView(
                    allOf(withId(R.id.editTextUserInput),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            editText8.perform(replaceText(String.valueOf(i)), closeSoftKeyboard());

            ViewInteraction button2 = onView(
                    allOf(withId(R.id.changeTextBt), withText("Change Heading!"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            button2.perform(click());
        }
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
