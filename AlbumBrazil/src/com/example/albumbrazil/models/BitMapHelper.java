package com.example.albumbrazil.models;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 
 * @author luis cariño
 * Clase que nos ayuda a a cargan las imagenes de forma mas eficiente
 */

public  class BitMapHelper {

		
		/**
		 * Calcula el inSamplezise de una imagen 
		 * @param options
		 * @param reqWidth
		 * @param reqHeight
		 * @return inSampleSize, es el factor por el cual es reducida la imagen
		 * una imagen de 2048X1536 decodificada con un inSampleSize de 4 produce aprox una de 512x384
		 * y aloja en moeria 0.75MB en lugar de 12 MB
		 */
		public static int calculateInSampleZise(
				BitmapFactory.Options options, int reqWidth, int reqHeight){
			
			//raw dimensions of image
			final int height = options.outHeight;
			final int width = options.outWidth;
			int inSampleSize = 1; 
			
			if(height > reqWidth || width > reqWidth){
				
				final int halfHeight = height/2;
				final int halfWidth = width/2;
				
				
				 // Calculate the largest inSampleSize value that is a power of 2 and keeps both
		        // height and width larger than the requested height and width.
		        while ((halfHeight / inSampleSize) > reqHeight
		                && (halfWidth / inSampleSize) > reqWidth) {
		            inSampleSize *= 2;
		        }

			}
			
			return inSampleSize;
		}
		
		
		/**
		 * Codifica y nos devuelve un bitmap con el tamaño apropiado para la vista
		 * @param contx
		 * @param res
		 * @param resId: identificador de cada elemento de nuestra vista
		 * @return
		 */
		public static Bitmap decodeSampledBitmapFromResource(Context contx, Resources res, int resourceId,
					int reqWidth, int reqHeight){
			
			//Generamos el int ResId a partir del identificador obtenido
			String PACKAGE_NAME = contx.getPackageName();
			int resId = res.getIdentifier(PACKAGE_NAME+":drawable/e"+Integer.toString(resourceId), null, null);
			
			//Decodificamos con inJustDecodeBounds=true para verificar las dimensiones
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeResource(res, resId, options);
			
			//Calculamos el factor de escalamiento
			options.inSampleSize = calculateInSampleZise(options, reqWidth, reqHeight);
			
			//Decodificamos bitmap con el factor asignado
			options.inJustDecodeBounds = false;
			return BitmapFactory.decodeResource(res, resId, options);
			
			
			//int si = args.getInt("selected_item")+1;
//			//Toast.makeText(mContext, Integer.toString(si), Toast.LENGTH_LONG).show();
//			imageName = new StringBuilder("e"+Integer.toString(si));
//			String PACKAGE_NAME = mContext.getPackageName();
//			int imgId = getActivity().getResources().getIdentifier(PACKAGE_NAME+":drawable/"+imageName.toString(), null, null);
//			myIV.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(), imgId));
			
		}
}
