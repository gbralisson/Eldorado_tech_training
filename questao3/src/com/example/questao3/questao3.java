package com.example.questao3;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.Button;
import android.os.BatteryManager;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
public class questao3 extends Activity implements BroadcastListener
{
	private TextView txt;
	private Button btn;
	private BatteryManager bm;
	private ImageView img;
	private AnimationDrawable frameAnimation;
	
	BatteryLevelReceiver receiver;
	
	private static final String TAG = "questao3";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        Log.i(TAG, "Inicio");
        setContentView(R.layout.activity_questao3);

        txt = findViewById(R.id.txt);
        txt.setText( "Questão 3!!! Este é o penúltimo exercício!" );
        
        img = findViewById(R.id.spinning_wheel_image);
        
        //btn = findViewById(R.id.showBtn);
        //bm = (BatteryManager) getSystemService(BATTERY_SERVICE);

		/*
        btn.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
					int level = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
					Log.i(TAG, "Level: " + String.valueOf(level));
				}
			});
		*/
    }
    
	@Override
    protected void onStart() {
        super.onStart();
        receiver = new BatteryLevelReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        this.registerReceiver(receiver, filter);
    }
 
    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(receiver);
    }
    
    @Override
    public void setFullAnimation(){
		img.setBackgroundResource(R.drawable.full_battery);
		//frameAnimation = (AnimationDrawable) img.getBackground();
		//frameAnimation.start();
	}
	
	@Override
	public void setHighAnimation(){
		img.setBackgroundResource(R.drawable.high_battery);
	}
	
	@Override
	public void setMiddleAnimation(){
		img.setBackgroundResource(R.drawable.middle_battery);
	}
	
	@Override
	public void setLowAnimation(){
		img.setBackgroundResource(R.drawable.low_battery);
	}
	
	@Override
	public void setEmptyAnimation(){
		img.setBackgroundResource(R.drawable.empty_battery);
	}
}
