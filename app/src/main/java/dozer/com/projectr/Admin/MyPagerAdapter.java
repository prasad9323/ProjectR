package dozer.com.projectr.Admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dozer.com.projectr.R;

/**
 * Created by Prasad on 18-Mar-18.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages.
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for a particular page.
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentWithOneImage.newInstance("Fragment 1", R.drawable.ic_arrow_back_black_24dp);
            case 1:
                return FragmentWithOneImage.newInstance("Fragment 2", R.drawable.ic_arrow_back_black_24dp);
            case 2:
                return FragmentWithTwoImages.newInstance("Fragment 3", R.drawable.ic_arrow_back_black_24dp, R.drawable.ic_arrow_back_black_24dp);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Projects";
            case 1:
                return "Team members";
            case 2:
                return "My tasks";
        }
        return null;
    }
}