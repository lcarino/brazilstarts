package com.example.albumbrazil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

import com.example.albumbrazil.models.Album;
import com.example.albumbrazil.models.Usuario;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class AvanceFragment extends Fragment {
	
	private View rootView;
	private Context mContext;
	private Bundle bundle;
	private Bundle myBundle;
	private Usuario usuario;
	public Album albumOp;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		mContext = getActivity().getApplicationContext();
		
		usuario = new Usuario(mContext);
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.fragment_avance, container,false);
		
		TextView textView = (TextView)rootView.findViewById(R.id.textView1);
		Album albumOpened = usuario.abrirAlbum();
		Log.d("DEBUG AVANCE ",albumOpened.toString());
		Log.d("DEBUG AVANCE",String.valueOf(albumOpened.getMisEstampas().size()));
		
		textView.setText("Tienes "+String.valueOf(albumOpened.getMisEstampas().size())+" estampas");
		
		LinearLayout chartContainer = (LinearLayout)rootView.findViewById(R.id.chart_container);
		chartContainer.addView(openChart(albumOpened.getMisEstampas().size()));
		
		return rootView;
	}
	
	
	private View openChart(int noEstampas){
		 
        // Pie Chart Section Names
        String[] code = new String[] {
            "En album", "Faltantes", "Repetidas"
        };
        
        double enAlbum = (double)noEstampas;
        double faltantes = 50.0 - enAlbum;
        //double repetidas = 10.0;
        // Pie Chart Section Values
        double[] distribution = { enAlbum, faltantes} ;
 
        // Color of each Pie Chart Sections
        int[] colors = { Color.BLUE, Color.RED,
                        };
 
        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries(" Android version distribution as on October 1, 2012");
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i], distribution[i]);
        }
 
        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
 
        defaultRenderer.setChartTitle("Avance registrado en tu album brasil 2014 ");
        defaultRenderer.setChartTitleTextSize(30);
        defaultRenderer.setZoomButtonsVisible(true);
        defaultRenderer.setLabelsTextSize(30);
        defaultRenderer.setLegendTextSize(30);
        // Creating an intent to plot bar chart using dataset and multipleRenderer
        //Intent intent = ChartFactory.getPieChartIntent(getActivity().getBaseContext(), distributionSeries , defaultRenderer, "AChartEnginePieChartDemo");
        return ChartFactory.getPieChartView(getActivity().getBaseContext(), distributionSeries, defaultRenderer);
        // Start Activity
        //startActivity(intent);
 
    }

	
	

}
