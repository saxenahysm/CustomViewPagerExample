package com.shyam.customviewpagerexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shyam.customviewpagerexample.fragments.DeepStudyFragment;
import com.shyam.customviewpagerexample.fragments.NotesFragment;
import com.shyam.customviewpagerexample.fragments.VideoLinkFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterTabs extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitleList = new ArrayList<>();
    private VideoLinkFragment videoLinkFragment = null;
    private NotesFragment notesFragment = null;
    private DeepStudyFragment deepStudyFragment = null;

    public void setVideoLinkFragment(VideoLinkFragment videoLinkFragment) {
        this.videoLinkFragment = videoLinkFragment;
    }

    public void setNotesFragment(NotesFragment notesFragment) {
        this.notesFragment = notesFragment;
    }

    public void setDeepStudyFragment(DeepStudyFragment deepStudyFragment) {
        this.deepStudyFragment = deepStudyFragment;
    }

    public ViewPagerAdapterTabs(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    void addFragment(Fragment fragment, String title) {
        title.toLowerCase();
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}