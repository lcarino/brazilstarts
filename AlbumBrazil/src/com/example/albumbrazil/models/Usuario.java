package com.example.albumbrazil.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public static Album album = new Album();
	public static Context mContext;
	
	public Usuario(Context mContex){
		mContext = mContex;
	}
	
	public void guardarAlbum(Album album){
		
		
        try {
        	FileOutputStream fos = mContext.openFileOutput("albumguardado", mContext.MODE_PRIVATE); //Abre un archivo provado asociado con el contexto de la aplicacion. Si el archivo lo existe lo crea
        	ObjectOutputStream os = new ObjectOutputStream(fos);
        	os.writeObject(album);
        	fos.close();
        	os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	Log.d("debug","Excepcion lanzada en el guardado del archivo");
            e.printStackTrace();
        }

    }
		
	/*
	 * Abre el archivo asociado con la aplicacion y en caso de que no exista
	 * lo crea.
	 */
	
	public  Album abrirAlbum(){
		Album album = null;
		File file;
		FileInputStream fis = null;

		try{
			file = mContext.getFileStreamPath("albumguardado");
			
		if(!file.exists()){
			Log.d("DEBUGER","El archivo no existe");
			guardarAlbum(new Album());	
		}
		
		fis  = mContext.openFileInput("albumguardado");
		ObjectInputStream is = new ObjectInputStream(fis);
		album = (Album) is.readObject();
    	is.close();
		
		
		}catch(Exception e){
			Log.d("DEBUGER","Excepcion lanzada en la apertura del archivo");
			e.getClass();
			e.getMessage();
			e.printStackTrace();
			
		}
		return album;
	}
	
	
	
	
	

}
