package com.shyam.customviewpagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.shyam.customviewpagerexample.fragments.DeepStudyFragment;
import com.shyam.customviewpagerexample.fragments.NotesFragment;
import com.shyam.customviewpagerexample.fragments.VideoLinkFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    ViewPagerAdapterTabs viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapterTabs(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new NotesFragment(), "Notes");
        viewPagerAdapter.addFragment(new DeepStudyFragment(), "Deep Study");
        viewPagerAdapter.addFragment(new VideoLinkFragment(), "Video Link");
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        viewPager.setPagingEnabled(false);
    }
}