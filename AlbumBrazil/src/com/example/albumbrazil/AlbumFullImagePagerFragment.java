package com.example.albumbrazil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AlbumFullImagePagerFragment extends Fragment{

	/**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 50;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private Bundle bundle;
    private Context mContext;
    private View rootView;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        
    	bundle = getArguments();
    	mContext = getActivity().getApplicationContext();
    	super.onCreate(savedInstanceState);
       
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_view_pager, container,false);
		
		// Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
		
		
//		int si = args.getInt("selected_item")+1;
//		//Toast.makeText(mContext, Integer.toString(si), Toast.LENGTH_LONG).show();
//		imageName = new StringBuilder("e"+Integer.toString(si));
//		String PACKAGE_NAME = mContext.getPackageName();
//		int imgId = getActivity().getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName.toString(), null, null);
//		myIV.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(), imgId));
		return rootView;
	}

//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	AlbumFullImageFragment afif = new AlbumFullImageFragment();
        	afif.setArguments(bundle);
            return afif;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
	
	

