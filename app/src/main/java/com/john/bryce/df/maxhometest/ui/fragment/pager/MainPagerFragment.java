package com.john.bryce.df.maxhometest.ui.fragment.pager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.john.bryce.df.maxhometest.R;
import com.john.bryce.df.maxhometest.ui.activity.MainActivity;
import com.john.bryce.df.maxhometest.ui.fragment.pager.adapter.BenefitsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

;

public class MainPagerFragment extends Fragment {
    public static final String TAG = "com.john.bryce.df.maxhometest.ui.fragment.pager.MainPagerFragment.TAG";
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private MainActivity activity;
    private PagerAdapter pagerAdapter;
    private Unbinder unbinder;

    /**
     * Shows the fragment inside the parent layout.
     *
     * @param fragmentManager the fragment manager to hold the fragment.
     * @param parentLayoutId  the layout to contain the fragment.
     */
    public static void show(@NonNull FragmentManager fragmentManager, @IdRes int parentLayoutId) {
        if (fragmentManager.findFragmentByTag( TAG ) == null) {
            final MainPagerFragment fragment = new MainPagerFragment();
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace( parentLayoutId, fragment, TAG );
            transaction.commit();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        this.activity = (MainActivity) context;
    }

    public void disableSwip() {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View layout = LayoutInflater.from( activity ).inflate( R.layout.fragment_pager, container, false );
        unbinder = ButterKnife.bind( this, layout );
        setupPager();
        return layout;
    }

    private void setupPager() {
        pagerAdapter = new BenefitsPagerAdapter( this );
        pager.setAdapter( pagerAdapter );
        tabLayout.setupWithViewPager( pager );
        disableSwip();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
