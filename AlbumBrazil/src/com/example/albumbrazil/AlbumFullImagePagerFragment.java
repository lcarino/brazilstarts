package com.example.albumbrazil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
    public static Bundle bundle;
    private Context mContext;
    private View rootView;

    
    static AlbumFullImagePagerFragment newInstance(int num){
    	AlbumFullImagePagerFragment albumFIP = new AlbumFullImagePagerFragment();
    	Bundle arg = new Bundle();
    	arg.putInt("num",num);

    	return albumFIP;
    }
    
    
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
		mPager.setCurrentItem(bundle.getInt("selected_item"));
		
//		int si = args.getInt("selected_item")+1;
//		//Toast.makeText(mContext, Integer.toString(si), Toast.LENGTH_LONG).show();
//		imageName = new StringBuilder("e"+Integer.toString(si));
//		String PACKAGE_NAME = mContext.getPackageName();
//		int imgId = getActivity().getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName.toString(), null, null);
//		myIV.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(), imgId));
		return rootView;
	}


    /**
     * Page adapter que permite visualizar las imagenes en tamaño mas grande
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        
        @Override
        public Fragment getItem(int position) { //devuelve de la imagen en tamaño completo
        	Log.d("LOGEEER***",String.valueOf(bundle.getInt("selected_item")));
        	
        	return AlbumFullImageFragment.newInstance(position);
//        	afif.setArguments(bundle);
//            return afif;
        }

        @Override
        public int getCount() { //numero de fragments a mostrar
            return NUM_PAGES;
        }
        
        
    }
}
	
	

