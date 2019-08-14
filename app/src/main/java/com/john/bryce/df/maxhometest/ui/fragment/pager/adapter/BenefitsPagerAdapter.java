package com.john.bryce.df.maxhometest.ui.fragment.pager.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.fragment.all.AllFragment;
import com.john.bryce.df.maxhometest.ui.fragment.favorites.FavoritesFragment;
import com.john.bryce.df.maxhometest.ui.fragment.pager.MainPagerFragment;
import com.john.bryce.df.maxhometest.ui.fragment.persoanl.PersonalBenfitsFragment;
import com.john.bryce.df.maxhometest.ui.fragment.recommended.RecommendedFragment;

public class BenefitsPagerAdapter extends FragmentStatePagerAdapter {

    private static final int FRAGMENT_ALL = 0;
    private static final int FRAGMENT_RECOMMENDED = 1;
    private static final int FRAGMENT_PERSONAL_BENFITS = 2;
    private static final int FRAGMENT_FAVORITES = 3;
    private static final int NUM_PAGES = 4;

    private final Context context;

    public BenefitsPagerAdapter(@NonNull MainPagerFragment fragment) {
        super( fragment.getChildFragmentManager() );
        this.context = fragment.getContext();
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FRAGMENT_ALL:
                return new AllFragment();
            case FRAGMENT_RECOMMENDED:
                return new RecommendedFragment();
            case FRAGMENT_PERSONAL_BENFITS:
                return new PersonalBenfitsFragment();
            case FRAGMENT_FAVORITES:
                return new FavoritesFragment();
            default:
                throw new IllegalStateException( "Unknown item: " + position );
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case FRAGMENT_ALL:
                return context.getString( R.string.fragment_all );
            case FRAGMENT_RECOMMENDED:
                return context.getString( R.string.fragment_recommended );
            case FRAGMENT_PERSONAL_BENFITS:
                return context.getString( R.string.fragment_personal_benfits );
            case FRAGMENT_FAVORITES:
                return context.getString( R.string.fragment_favorites );

            default:
                throw new IllegalStateException( "Unknown item: " + position );
        }
    }
}
