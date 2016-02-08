package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.advertising_id_client.example.R;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AdvertisingIdClientExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_example);
    	final TextView label = (TextView) findViewById(R.id.label);
        new Thread(new Runnable(){
        	@Override
        	public void run(){
        		final String id = getId();
        		runOnUiThread(new Runnable(){
        			@Override
        			public void run(){
        				label.setText(id);      
        			}
        		});
        	}
        }).start();
    }



    private String getId(){
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this).getId();
        } catch (Exception e) {
            StringWriter wr = new StringWriter();
            e.printStackTrace(new PrintWriter(wr));
            return wr.toString();
        }
    }
}