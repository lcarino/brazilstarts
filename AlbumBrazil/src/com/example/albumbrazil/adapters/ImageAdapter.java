package com.example.albumbrazil.adapters;

import com.example.albumbrazil.MainActivity;
import com.example.albumbrazil.R;
import com.example.albumbrazil.helpers.*;
import com.example.albumbrazil.helpers.BitmapWorkerTask.AsyncDrawable;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.R.*;

public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;
	private Resources res;
	
	public ImageAdapter(Context c){
		
		mContext = c;
		
	}
	
	public ImageAdapter(Context c, Resources r){
		res=r;
		mContext = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView mImageView;
		int imgViewWidth=400;
		int imgViewHeight=400;
		if(convertView == null){ //si no esta siendo reciclada inicializamos
			mImageView = new ImageView(mContext);
			mImageView.setLayoutParams(new GridView.LayoutParams(imgViewHeight,imgViewWidth));  // asigna el alto y ancho de los views
			//mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			mImageView.setPadding(45, 45, 45, 45);
		}else{
			mImageView = (ImageView) convertView;
		}
		
//			mImageView.setImageBitmap(
//					BitMapHelper.decodeSampledBitmapFromResource(mContext, res, position, imgViewWidth, imgViewHeight));
//		
		BitmapWorkerTask task = new BitmapWorkerTask(mImageView, res, imgViewWidth, imgViewHeight, mContext);
		task.execute(position);
		return mImageView;
	}
	
	
//	public void loadBitmap(ImageView imageView, int resId, int imgViewWidth,int imgViewHeight ){
//		final BitmapWorkerTask task = 
//				new BitmapWorkerTask(imageView, res, imgViewWidth, imgViewHeight, mContext);
//		final AsyncDrawable asyncDrawable = new AsyncDrawable(res, bitmap, bitmapWorkerTask)
//		
//	}


}
