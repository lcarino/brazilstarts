package com.example.albumbrazil;

import java.io.IOException;
import java.util.ArrayList;

import com.example.albumbrazil.adapters.ImageAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.example.albumbrazil.models.Album;
import com.example.albumbrazil.models.Usuario;

public class AlbumFragment extends Fragment {

	
	private View rootView;
	private Context mContext;
	private Bundle bundle;
	private Usuario usuario;
	public Album albumOp;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		mContext = getActivity().getApplicationContext();
		//myBundle =  getArguments();
		usuario = new Usuario(mContext);
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_album, container,false);
		
		//leemos el album desde el archivo
		Album albumOpened = usuario.abrirAlbum();
		Log.d("DEBUG ALBUM FRAGMENT",albumOpened.toString());
		Log.d("DEBUG ALBUM FRAGMENT",String.valueOf(albumOpened.getMisEstampas().size()));
		
		GridView gv = (GridView) rootView.findViewById(R.id.gridView);
		gv.setAdapter(new ImageAdapter(mContext,getActivity().getResources(),albumOpened));
		//gv.setAdapter(new ImageAdapter(mContext,getActivity().getResources()));
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            
	            bundle = new Bundle();
	            bundle.putInt("selected_item", position);
	            AlbumFullImagePagerFragment aff = new AlbumFullImagePagerFragment();
	            aff.setArguments(bundle);
	            FragmentManager fm = getActivity().getSupportFragmentManager();
	           
	            fm.beginTransaction().replace(R.id.container, aff).addToBackStack("tag").commit();
	            
	            
	        }

		});
		
	
		return rootView;
	}
	
	public void setAlbum(Album a){
		albumOp = a;
	}

	@Override
	public void onDestroy() { 
		// TODO Auto-generated method stub
		Log.d("DEBUG ALBUM","ON DESTROY");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() { //ACA SE GUARDAN LA MODIFICACIONES HECHAS AL ALBUM
		// TODO Auto-generated method stub
		Log.d("DEBUG ALBUM","ON DESTROY VIEW");
		super.onDestroyView();
	}
	
	

}
