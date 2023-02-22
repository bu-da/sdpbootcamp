package com.github.buda.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import android.app.Activity;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void isCorrectlyCreated() {
        Intents.init();
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra("name", "James Bond");
        ActivityScenario<Activity> scenario = ActivityScenario.launch(intent);
        ViewInteraction textField = onView(ViewMatchers.withId(R.id.greetingMessage));
        textField.check(matches(ViewMatchers.withText("Hello James Bond")));
        scenario.close();
        Intents.release();
    }
}
