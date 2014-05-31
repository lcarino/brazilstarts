package com.example.albumbrazil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albumbrazil.helpers.CoverFlow;
import com.example.albumbrazil.models.Album;
import com.example.albumbrazil.models.Usuario;

public class CompraSobreFragment extends Fragment implements OnClickListener,AnimationListener{

	private View rootView;
	private Context mContext;
	private Bundle bundle;
	private TextView textView;
	private List<String> sobre;
	Animation animFadein;
	SharedPreferences preferences;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		bundle = new Bundle();
		mContext = getActivity().getApplicationContext();
		preferences = getActivity().getSharedPreferences("preferencesFile", 0);
		if(preferences.getBoolean("inicializacion", true)){
			preferences.edit().putInt("numSobres", 10).commit();
			preferences.edit().putBoolean("inicializacion", false).commit();
		}
		
		super.onCreate(savedInstanceState);
		
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.activity_fragmentos, container,false);
		
			
		
		ImageView img = (ImageView) rootView.findViewById(R.id.sobres);
		
		TextView textView = (TextView) rootView.findViewById(R.id.numeroSobres);
		textView.setText(Integer.toString(preferences.getInt("numSobres", 10))+"/10");
		img.setOnClickListener(this);
							
		return rootView;
		
		
	}

	
	
	
	

	
		

	
	private class LongOperation extends AsyncTask<String, Void, List<Integer>> {

		private Context contextazo;
		ProgressDialog pDialog;
		public List<Integer> compra = new ArrayList<Integer>();
		
		public LongOperation(Context contexto) {
			contextazo=contexto;
			// TODO Auto-generated constructor stub
		}
		@Override
        protected void onPreExecute(){
			// pDialog = new ProgressDialog(mContext);
           //pDialog.setMessage("Comprando...");
           //pDialog.show();
        }
		

		// Call after onPreExecute method
		protected List<Integer> doInBackground(String... params) {

			sobre= getSobre(params[0]); //trae los ids de las estampas
			Log.d("sobre JSON", sobre.toString());
			
			for(String identificador : sobre) //se regresa una lista de enteros con los identificadores de las imagene
				compra.add(getResources().getIdentifier("e"+identificador, "drawable",
						mContext.getPackageName()));
				
				
			return compra;

		}

		protected void onPostExecute(List<Integer> mImageIds) {
			
			
			
			
			Log.d("sobre JSON", sobre.toString());
			Usuario usuario= new Usuario(mContext);
			Album album = usuario.abrirAlbum();
			
			ArrayList<Integer> misEstampas = album.getMisEstampas();
			HashMap<Integer, Integer> misRepetidas = album.getRepetidas();
			
			
			
			//HashMap<Integer, String> catalogo=album.getCatalogo();
			for(String identificador : sobre) //se regresa una lista de enteros con los identificadores de las imagene
			{	
				
				//validacion para repetidas
				if(misEstampas.contains(Integer.valueOf(identificador))){
					
						Integer value = misRepetidas.get(Integer.valueOf(identificador));
						if(value==null){
							misRepetidas.put(Integer.valueOf(identificador), 1);
						}else{
							misRepetidas.put(Integer.valueOf(identificador),value+1);
						}
						
				}else{
					misEstampas.add(Integer.valueOf(identificador));
				}
			}
			
			album.setRepetidas(misRepetidas);
			album.setMisEstampas(misEstampas);
			usuario.guardarAlbum(album);
			
			
			
			
			compra=mImageIds;
			Log.d("hi", compra.toString());
			bundle.putIntegerArrayList("sobre", (ArrayList<Integer>) compra);
			
			CoverFlowFragment cff = new CoverFlowFragment();
            cff.setArguments(bundle);
            FragmentManager fm = getActivity().getSupportFragmentManager();
           
            fm.beginTransaction().replace(R.id.container, cff).addToBackStack("tag").commit();
           
			
			// ya que tenemos el sobre lleno de los ids, ahora tenemos que
			// regresar un arreglo de enteros y ejecutar el codigo que pone las
			// imagenes

			// getResources().getIdentifier(imageString , "id", "package.name");

			// Required initialization

			// private Integer[] mImageIds = new Integer[5];

		}

	}

	private List<String> getSobre(String urlString) {

		List<String> sobre = new ArrayList<String>();
		String Content = "";
		String Error = null;
		//TextView json = (TextView) findViewById(R.id.labelResponse);

		BufferedReader reader = null;

		// Send data
		try {

			// Defined URL where to send data
			URL url = new URL(urlString);

			// Send POST data request

			URLConnection conn = url.openConnection();

			// Get the server response

			reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			// Read Server Response
			while ((line = reader.readLine()) != null) {
				// Append server response in string
				sb.append(line + "");
			}

			// Append Server Response To Content String
			Content = sb.toString();
		} catch (Exception ex) {
			Error = ex.getMessage();
		} finally {
			try {

				reader.close();
			}

			catch (Exception ex) {
			}
		}

		if (Error != null) {

			//json.setText("Output : " + Error);

		} else {

			JSONObject jsonResponse;
			try {
				jsonResponse = new JSONObject(Content);
				JSONArray elementos = ((JSONObject) jsonResponse.opt("result"))
						.optJSONArray("card");

				for (int i = 0; i < elementos.length(); i++) {

					JSONObject elemento = elementos.getJSONObject(i);
					// json.append(elemento.optString("id"));
					sobre.add(elemento.optString("id"));
				}
			} catch (JSONException e) {

				e.printStackTrace();
			}

		}

		Log.d("sobre", sobre.toString());
		
		return sobre;
		

	}

	/**
	 * Sets the up listeners.
	 * 
	 * @param mCoverFlow
	 *            the new up listeners
	 */
	private void setupListeners(final CoverFlow mCoverFlow) {
		mCoverFlow.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(final AdapterView<?> parent,
					final View view, final int position, final long id) {
				textView.setText("Item clicked! : " + id);
			}

		});
		mCoverFlow.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(final AdapterView<?> parent,
					final View view, final int position, final long id) {
				textView.setText("Item selected! : " + id);
			}

			@Override
			public void onNothingSelected(final AdapterView<?> parent) {
				textView.setText("Nothing clicked!");
			}
		});
	}


	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onAnimationEnd(Animation animation) {
		String serverURL = "http://serverbpw.com/cm/cards.php?type=json";		
		new LongOperation(mContext).execute(serverURL);
       
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View v) {
		ImageView img = (ImageView) rootView.findViewById(R.id.sobres);
		animFadein = AnimationUtils.loadAnimation(mContext,
                R.anim.zoom_out); 
		
		TextView textV = (TextView)rootView.findViewById(R.id.numeroSobres);
		
		if(preferences.getInt("numSobres", 10) < 1){
			textV.setText("No puedes comprar mas sobres");
			
		}else{
		
		preferences.edit().putInt("numSobres", (preferences.getInt("numSobres", 10)-1)).commit();
		textV.setText(Integer.toString(preferences.getInt("numSobres", 10))+"/10");
		img.startAnimation(animFadein);
		animFadein.setAnimationListener(this);
		}
		
		

		// TODO Auto-generated method stub
		
	}

}
