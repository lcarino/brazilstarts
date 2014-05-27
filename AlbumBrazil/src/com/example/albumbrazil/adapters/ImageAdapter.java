package com.example.albumbrazil.adapters;

import java.util.ArrayList;

import com.example.albumbrazil.MainActivity;
import com.example.albumbrazil.R;
import com.example.albumbrazil.helpers.*;
import com.example.albumbrazil.helpers.BitmapWorkerTask.AsyncDrawable;
import com.example.albumbrazil.models.Album;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
	private Album albumOpened;
	
	public ImageAdapter(Context c){
		
		mContext = c;
		
	}
	
	public ImageAdapter(Context c, Resources r){
		res=r;
		mContext = c;
	}
	
	public ImageAdapter(Context c, Resources r, Album a){
		res = r;
		mContext = c;
		albumOpened = a;
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
		
		//checamos las estampas que estan en el arraylist de estampas pegadas
		ArrayList<Integer> estampasPegadas = albumOpened.getMisEstampas();
		int resId;
		if(!estampasPegadas.contains(position+1)){
			resId = 0;
		}else{
			resId=position+1;
		}
		BitmapWorkerTask task = new BitmapWorkerTask(mImageView, res, imgViewWidth, imgViewHeight, mContext);
		task.execute(resId);
		//loadBitmap(mImageView, position+1, imgViewWidth, imgViewHeight);
		return mImageView;
	}
	
	
	public void loadBitmap(ImageView imageView, int resId, int imgViewWidth,int imgViewHeight ){
		
		if(cancalPotentialWork(resId, imageView))
		{
			final BitmapWorkerTask task = 
					new BitmapWorkerTask(imageView, res, imgViewWidth, imgViewHeight, mContext);
		
			Bitmap placeholder = BitMapHelper.decodeSampledBitmapFromResource(mContext, res, 0, 400, 400);
			final AsyncDrawable asyncDrawable = new AsyncDrawable(res, placeholder, task);
			imageView.setImageDrawable(asyncDrawable);
			task.execute(resId);
		}
		
	}
	
	public static boolean cancalPotentialWork(int data, ImageView imageView){
		
		final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
		
		if(bitmapWorkerTask != null){
			final int bitmapData = bitmapWorkerTask.data;
			//si bitmapdata no a sido asigando o es diferente 
			if(bitmapData == 0 || bitmapData != data){
				//cancela el task pasado
				bitmapWorkerTask.cancel(true);
			}else{
				//el mismo trabajo ya esta en progreso
				return false;
			}
		}
		//no existe una tarea asociada o la tarea fue cancelada
		return true;
	}
	
	
	public static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView){
		if(imageView != null){
			final Drawable drawable = imageView.getDrawable();
			if(drawable instanceof AsyncDrawable){
				final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
				return asyncDrawable.getBitmapWorkerTask();
			}
		}
		return null;
	}


}
