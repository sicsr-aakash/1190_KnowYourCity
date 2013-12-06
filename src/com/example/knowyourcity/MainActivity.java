package com.example.knowyourcity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	
	Button play,about,howtoplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        play=(Button)findViewById(R.id.btnPlay);
        about=(Button)findViewById(R.id.btnAbout);
        howtoplay=(Button)findViewById(R.id.btnHowToPlay);
        
        play.setOnClickListener(new OnClickListener()
        	{
			
			@Override
			public void onClick(View arg0) {
			
				Intent intent=new Intent(getApplicationContext(),PlayActivity.class);
				startActivity(intent);
			}
		});
        
        about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
				startActivity(intent);
			}
		});
        
        howtoplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(),HowToPlayActivity.class);
				startActivity(intent);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
        
        
    }
    
}
