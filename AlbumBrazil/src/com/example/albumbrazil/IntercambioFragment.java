package com.example.albumbrazil;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class IntercambioFragment extends Fragment{

	View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);//report this fragment would like to participate populating options menu

	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_intercambio, container,false);
		
		return rootView;
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.intercambio_menu,menu);
		super.onCreateOptionsMenu(menu, inflater);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.enviar) {
			//getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new ScanerFragment()).commit();
			Toast.makeText(getActivity().getApplicationContext(),"**Envio", Toast.LENGTH_LONG).show();
		}else if(id == R.id.recibir){
			Toast.makeText(getActivity().getApplicationContext(),"**Recepcion", Toast.LENGTH_LONG).show();

		}
		return super.onOptionsItemSelected(item);
	}
	
}
