package com.example.albumbrazil.helpers;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;


/***
 * 
 * Clase que nos permitira ejecutar en background la carga de imagenes
 * 
 */


public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap>{
	
	//creamos una referencia debil a nuestro image view
	private final WeakReference<ImageView> imageViewReference;
	public int data = 0;
	private int reqWidth;
	private int reqHeight;
	private Resources res;
	private Context cntx;
	
	//se recibe la referencia de la ImageView en el constructor
	public BitmapWorkerTask(ImageView imageView, Resources resources, int reqW, int reqH, Context c){
		imageViewReference = new WeakReference<ImageView>(imageView);
		reqWidth = reqW;
		reqHeight = reqH;
		res = resources;
		cntx = c;
	}
	
	//decodifica la imagen en background

	@Override
	protected Bitmap doInBackground(Integer... params) {
		data = params[0]; // aca le pasamos el id de la imagen
		return BitMapHelper.decodeSampledBitmapFromResource(cntx, res, data, reqWidth, reqHeight);
	}
	
	
	//una competada la decodificacion, verificamos si el ImageView sigue por disponible
	@Override
	protected void onPostExecute(Bitmap bitmap){
		
		if(isCancelled()){
			bitmap = null;
		}
		
		if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
	
	
	/***
	 * Clase que permite el manejo efectivo de concurrencia
	 * Almacena una referencia al worker task, es usado un BitMapDrawable para que 
	 * el contenedor pueda ser mostrado en el IV mientrras la tarea se completa
	 */
	public static class AsyncDrawable extends BitmapDrawable{
		
		private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;
		
		public AsyncDrawable(Resources res, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask){
			super(res,bitmap);
			bitmapWorkerTaskReference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
		}
		
		public BitmapWorkerTask getBitmapWorkerTask(){
			return bitmapWorkerTaskReference.get();
		}
	}


}
	

