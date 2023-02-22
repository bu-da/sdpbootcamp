package com.github.buda.myapplication;

import static androidx.test.espresso.Espresso.onView;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void createsCorrectIntent() {
        Intents.init();
        ViewInteraction textField = onView(ViewMatchers.withId(R.id.mainName));
        textField.perform(ViewActions.clearText());
        textField.perform(ViewActions.typeText("James Bond"));
        textField.perform(ViewActions.closeSoftKeyboard());
        ViewInteraction button = onView(ViewMatchers.withId(R.id.mainGoButton));
        button.perform(ViewActions.click());
        Intents.intended(allOf(IntentMatchers.hasExtra("name", "James Bond"), IntentMatchers.hasComponent(GreetingActivity.class.getName())));
        Intents.release();
    }
}