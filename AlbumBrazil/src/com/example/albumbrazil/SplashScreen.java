package com.example.albumbrazil;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class SplashScreen extends Activity implements AnimationListener {

	Animation animFadein;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.splash_screen);
		

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		ImageView img = (ImageView) findViewById(R.id.logoCopa);
		TextView organizationName = (TextView) findViewById(R.id.organizationName); 
		TextView version = (TextView) findViewById(R.id.version);		
		
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);

		img.startAnimation(animFadein);
		organizationName.startAnimation(animFadein);
		version.startAnimation(animFadein);
		animFadein.setAnimationListener(this);

		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, MainActivity.class);
	    startActivity(i);

		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Touch listener to use for in-layout UI controls to delay hiding the
	 * system UI. This is to prevent the jarring behavior of controls going away
	 * while interacting with activity UI.
	 */
}