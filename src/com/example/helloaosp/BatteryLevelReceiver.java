package com.example.helloaosp;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;

public class BatteryLevelReceiver extends BroadcastReceiver {

	private static final String TAG = "HelloAosp";
	private BroadcastListener bl;

	@Override
	public void onReceive(Context context, Intent intent){
		String action = intent.getAction();
		Log.i(TAG, "Action: " + action);
		
		bl = (BroadcastListener) context;
	
		int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
		Log.i(TAG, "Level: " + level);
		if (level >= 70){
			Log.i(TAG, "Broadcast: Full Battery");
			bl.setFullAnimation();
		} else if (level >= 30 && level < 70){
			Log.i(TAG, "Broadcast: Middle Battery");
			bl.setMiddleAnimation();
		} else {
			Log.i(TAG, "Broadcast: Low Battery");
			bl.setLowAnimation();
		}

		
		
/*
if (Intent.ACTION_BATTERY_LOW.equals(action)) {
			Log.i(TAG, "Broadcast: Battery low");
		} else {
			Log.i(TAG, "Broadcast: Battery High");
		}

*/
			
	}
	
}
