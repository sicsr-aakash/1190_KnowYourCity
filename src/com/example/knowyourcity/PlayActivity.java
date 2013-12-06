package com.example.knowyourcity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity {
	TextView tf,question;
	Button next;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		tf=(TextView)findViewById(R.id.textViewtimer);
		question=(TextView)findViewById(R.id.textViewQuestion);
		next=(Button)findViewById(R.id.btnNext);
		
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent=new Intent(getApplicationContext(),PlayActivity.class);
				
			}
		});
		
		new CountDownTimer(30000, 1000) {

		     public void onTick(long millisUntilFinished) {
		         tf.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }

		     public void onFinish() {
		         tf.setText("done!");
		          intent=new Intent(getApplicationContext(),MainActivity.class);
		         startActivity(intent);
		     }
		  }.start();
		  
		  
		  SQLiteAdapter mySQLiteAdapter = new SQLiteAdapter(this);
	        mySQLiteAdapter.openToWrite();
	        mySQLiteAdapter.deleteAll();
	       mySQLiteAdapter.insert("Where is Hollywood gurudwara located in Pune");
	        /*mySQLiteAdapter.insert("FGHIJK");
	        mySQLiteAdapter.insert("1234567");
	        mySQLiteAdapter.insert("890");
	        mySQLiteAdapter.insert("Testing");*/
	        mySQLiteAdapter.close();
	        
	        
	        mySQLiteAdapter = new SQLiteAdapter(this);
	        mySQLiteAdapter.openToRead();
	        String contentRead = mySQLiteAdapter.queueAll();
	        mySQLiteAdapter.close();
	        
	        question.setText(contentRead);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play, menu);
		return true;
	}

}
