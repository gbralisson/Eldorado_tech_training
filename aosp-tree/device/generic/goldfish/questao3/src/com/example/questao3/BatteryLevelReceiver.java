package com.example.questao3;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;

public class BatteryLevelReceiver extends BroadcastReceiver {

	private static final String TAG = "questao3";
	private BroadcastListener bl;

	@Override
	public void onReceive(Context context, Intent intent){
		String action = intent.getAction();
		Log.i(TAG, "Action: " + action);
		
		bl = (BroadcastListener) context;
	
		int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
		Log.i(TAG, "Level: " + level);
		if (level >= 80){
			Log.i(TAG, "Broadcast: Full Battery");
			bl.setFullAnimation();
		} else if (level >= 60 && level < 80){
			Log.i(TAG, "Broadcast: High Battery");
			bl.setHighAnimation();
		} else if (level >= 40 && level < 60){
			Log.i(TAG, "Broadcast: Middle Battery");
			bl.setMiddleAnimation();
		} else if (level >= 15 && level < 40){
			Log.i(TAG, "Broadcast: Low Battery");
			bl.setLowAnimation();
		} else {
			Log.i(TAG, "Broadcast: Empty Battery");
			bl.setEmptyAnimation();
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
