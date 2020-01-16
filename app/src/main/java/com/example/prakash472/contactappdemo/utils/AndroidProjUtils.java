package com.example.prakash472.contactappdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class AndroidProjUtils {
    /**
     * This is the method used to switch between activity
     *
     * @param callingActivity     intent creator
     * @param destinationActivity name of the next activity to be switched
     * @param finishActivity
     */
    public static void launchNewActivity(Activity callingActivity, Class<?> destinationActivity, boolean finishActivity) {
        Intent intent = new Intent(callingActivity, destinationActivity);
        callingActivity.startActivity(intent);
        if (finishActivity) {
            callingActivity.finish();
        }
    }

    /**
     * Method to hide keyboard when touched in view
     * @param context
     * @param view
     */
    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager in = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
