package com.example.albumbrazil.models;

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
	
	private static Album album = new Album();
	public static Context mContext;
	
	public Usuario(Context mContex){
		mContext = mContex;
	}
	
	public void guardarAlbum(){
		
		
        try {

//        	ObjectOutput out = new ObjectOutputStream(new FileOutputStream("albumGuardaDo.ser")); 
//            out.writeObject(album); // 
//            out.close();
        	
        	FileOutputStream fos = mContext.openFileOutput("albumguardado", mContext.MODE_PRIVATE);
        	ObjectOutputStream os = new ObjectOutputStream(fos);
        	os.writeObject(album);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        	Log.d("debug","Excepcion lanzada en el guardado del archivo");
            e.printStackTrace();
        }

    }

		
	
	
	
	public  Album abrirAlbum() throws IOException, ClassNotFoundException{
		FileInputStream fis = mContext.openFileInput("albumguardado");
        ObjectInputStream is = new ObjectInputStream(fis);

        album = (Album) is.readObject();
        is.close();
        
		return album;
	}
	
	
	public Album getAlbum(){
		return album;
	}

}
