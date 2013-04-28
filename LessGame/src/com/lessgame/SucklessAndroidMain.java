package com.lessgame;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.suckless.GameMain;


public class SucklessAndroidMain extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
	        // Activity was brought to front and not created,
	        // Thus finishing this will get us to the last viewed activity
	        finish();
	        return;
	    }
		
		initialize(new GameMain(),true);
		//setContentView(R.layout.activity_suckless_android_main);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_suckless_android_main, menu);
		return true;
	}*/

}
