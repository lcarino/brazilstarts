package com.example.albumbrazil;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.albumbrazil.adapters.ImageAdapter;

public class AlbumFullImageFragment extends Fragment{
	
	private View rootView;
	private Context mContext;
	private Bundle args;
	private ImageView myIV;
	StringBuilder imageName;
	private int itemNumber;
	private int mNum;
	
	/**
	 * Crea una nueva instancia del fragment para la imagen completa, y se le pasa como argumento
	 * el numero de imagen seleccionado
	 * @param num
	 * @return
	 */
	static AlbumFullImageFragment newInstance(int num){
		AlbumFullImageFragment f = new AlbumFullImageFragment();
		Bundle arg = new Bundle();
		arg.putInt("num",num);
		f.setArguments(arg);
		return f;
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		args = getArguments();
		mContext = getActivity().getApplicationContext();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_full_image, container,false);
		myIV = (ImageView)rootView.findViewById(R.id.imageView2);
		
		
		int si = args.getInt("num")+1;
		//int si = 
		//Toast.makeText(mContext, Integer.toString(si), Toast.LENGTH_SHORT).show();
		imageName = new StringBuilder("e"+Integer.toString(si));
		String PACKAGE_NAME = mContext.getPackageName();
		int imgId = getActivity().getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName.toString(), null, null);
		myIV.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(), imgId));
		return rootView;
	}
	
	
	
}
