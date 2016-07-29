package com.example.ander.shoppingcart;

/**
 * Created by ander on 7/29/2016.
 */

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnHolderItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToHolder;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ShoppingCart(){
        onView(withId(R.id.shopping_cart_logo))
                .check(matches(isDisplayed()));
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
