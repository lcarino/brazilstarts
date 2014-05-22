package com.example.albumbrazil.adapters;

import com.example.albumbrazil.MainActivity;
import com.example.albumbrazil.R;

import android.content.Context;
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
	
	public ImageAdapter(Context c){
		
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
		ImageView iv;
		if(convertView == null){ //si no esta siendo reciclada inicializamos
			iv = new ImageView(mContext);
			iv.setLayoutParams(new GridView.LayoutParams(290,290));  // asigna el alto y ancho de los views
			iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
			iv.setPadding(45, 45, 45, 45);
		}else{
			iv = (ImageView) convertView;
		}
		
		
		//Toast.makeText(mContext, Integer.toString(si), Toast.LENGTH_LONG).show();
		StringBuilder imageName = new StringBuilder("e"+Integer.toString(position+1));
		String PACKAGE_NAME = mContext.getPackageName();
		int imgId = mContext.getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName.toString(), null, null);
		iv.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), imgId));
		//iv.setImageResource(mThumbIds[position]);
		return iv;
	}

	
	
	// references to our images
//    private Integer[] mThumbIds = {
//    		R.drawable.e1,
//            R.drawable.e2,
//            R.drawable.e3, 
//            R.drawable.e4,
//            R.drawable.e5,
//            R.drawable.e6, 
//            R.drawable.e7,
//            R.drawable.e8,
//            R.drawable.e9, 
//            R.drawable.e10,
//            R.drawable.e11,
//            R.drawable.e12, 
//            R.drawable.e13,
//            R.drawable.e14,
//            R.drawable.e0, 
//            R.drawable.e16,
//            R.drawable.e17,
//            R.drawable.e18, 
//            R.drawable.e19,
//            R.drawable.e20,
//            R.drawable.e21, 
//            R.drawable.e0,
//            R.drawable.e23,
//            R.drawable.e24, 
//            R.drawable.e25,
//            R.drawable.e26,
//            R.drawable.e27, 
//            R.drawable.e28,
//            R.drawable.e29,
//            R.drawable.e30, 
//            R.drawable.e31,
//            R.drawable.e32,
//            R.drawable.e33,
//            R.drawable.e34,
//            R.drawable.e35,
//            R.drawable.e36, 
//            R.drawable.e0,
//            R.drawable.e38,
//            R.drawable.e39, 
//            R.drawable.e40,
//            R.drawable.e41,
//            R.drawable.e42, 
//            R.drawable.e43,
//            R.drawable.e44,
//            R.drawable.e45, 
//            R.drawable.e46,
//            R.drawable.e47,
//            R.drawable.e48, 
//            R.drawable.e49,
//            R.drawable.e50,
//           
//            
//    };

}
