package com.sushma.recyclerwithmvvm.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sushma.recyclerwithmvvm.tabFragment.HomeFragment;
import com.sushma.recyclerwithmvvm.tabFragment.SecondFragment;

public class TabLayoutAdapter extends FragmentStateAdapter {
    int tabCount;
    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity,int tabCount) {
        super(fragmentActivity);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
           case 0:
               HomeFragment homeFragment = new HomeFragment();
               return homeFragment;
           case 1:
               SecondFragment secondFragment =  new SecondFragment();
               return secondFragment;
           default:
               return null;
       }
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }

//    int tabCount;
//    public TabLayoutAdapter(@NonNull FragmentManager fm, int tabCount) {
//        super(fm);
//        this.tabCount = tabCount;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//       switch (position) {
//           case 0:
//               HomeFragment homeFragment = new HomeFragment();
//               return homeFragment;
//           case 1:
//               SecondFragment secondFragment =  new SecondFragment();
//               return secondFragment;
//           default:
//               return null;
//       }
//    }
//
//    @Override
//    public int getCount() {
//        return tabCount;
//    }
}
