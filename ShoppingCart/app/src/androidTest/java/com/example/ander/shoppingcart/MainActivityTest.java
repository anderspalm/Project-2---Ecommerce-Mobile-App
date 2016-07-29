package com.example.ander.shoppingcart;

/**
 * Created by ander on 7/29/2016.
 */

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.v4.app.ActivityCompat.startActivity;

import android.support.test.espresso.contrib.RecyclerViewActions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ShoppingCartLogo(){
        onView(withId(R.id.shopping_cart_logo))
                .check(matches(isDisplayed()));
    }

    @Test
    public void ShoppingCart(){

        onView(withId(R.id.shopping_cart_logo)).perform(click());
        Intents.init();
        mainActivityActivityTestRule.launchActivity(new Intent());
//        SystemClock.sleep(5000);
        intended(hasComponent(hasClassName(ShoppingCart.class.getSimpleName())));
        Intents.release();

    }


    // can I click a recycler view item in the placeholder?
    @Test
    public void recylerViewItemsClickable() {
        onView(withId(R.id.recyler_widget))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

//  can I click a recycler view item in the placeholder?
    @Test
    public void ItemsAppearInCart(){
        onView(withId(R.id.recyler_widget))
                .perform(click());
        onView(withId(R.id.recyler_widget))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.shopping_cart_logo))
                .perform(click());
        onView(withId(R.id.cart_item_name))
                .check(matches(isDisplayed()));
    }


}
