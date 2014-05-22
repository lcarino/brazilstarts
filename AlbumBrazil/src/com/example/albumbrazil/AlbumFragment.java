package com.example.albumbrazil;

import java.io.IOException;

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
	

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		bundle = new Bundle();
		mContext = getActivity().getApplicationContext();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_album, container,false);
		
		GridView gv = (GridView) rootView.findViewById(R.id.gridView);
		gv.setAdapter(new ImageAdapter(mContext));
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            
	            bundle = new Bundle();
	            bundle.putInt("selected_item", position);
	            AlbumFullImagePagerFragment aff = new AlbumFullImagePagerFragment();
//	            AlbumFullImagePagerFragment aff = new AlbumFullImagePagerFragment();
//	            Intent i = new Intent(getActivity(), AlbumFullImagePagerFragment.class);
//	            getActivity().startActivity(i);
	            aff.setArguments(bundle);
	            FragmentManager fm = getActivity().getSupportFragmentManager();
	           
	            fm.beginTransaction().replace(R.id.container, aff).addToBackStack("tag").commit();
	            
	            
	        }

		});
		
		Album a = null;
		
		Usuario u = new Usuario(mContext);
		u.guardarAlbum();
		try {
			a = u.abrirAlbum();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException");
		}
		
		String nombre = a.catalogo.get(1);

		//Toast.makeText(mContext, "**"+nombre, Toast.LENGTH_LONG).show();
		
		return rootView;
	}
	
	

}
