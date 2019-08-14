package com.john.bryce.df.maxhometest;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

@GlideModule
public class MyAppGlideModule extends AppGlideModule {

    /**
     * Overrides applyOptions to enable Hardware Bitmaps
     *
     * @see <a href="https://bumptech.github.io/glide/doc/hardwarebitmaps.html">Hardware Bitmaps</a>
     */
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        builder.setDefaultRequestOptions( new RequestOptions().format( DecodeFormat.PREFER_ARGB_8888 ) );
    }
}
