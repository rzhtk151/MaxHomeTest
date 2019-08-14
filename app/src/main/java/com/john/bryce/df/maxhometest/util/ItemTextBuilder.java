package com.john.bryce.df.maxhometest.util;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

public class ItemTextBuilder {

    public static void creataItemDescription(String title, String description, TextView textView) {
        SpannableStringBuilder str = new SpannableStringBuilder( title + " - " + description );
        str.setSpan( new android.text.style.StyleSpan( android.graphics.Typeface.BOLD ), 0, title.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.setText( str );

    }
}
