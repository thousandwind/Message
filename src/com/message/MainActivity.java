package com.message;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText MessageText;
	private EditText NumberText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MessageText =(EditText) this.findViewById(R.id.MessageInputeditText);
		NumberText =(EditText) this.findViewById(R.id.NumberInputeditText);
		Button button = (Button) this.findViewById(R.id.Sendbutton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = NumberText.getText().toString();
				String message = MessageText.getText().toString();
				SmsManager manager =SmsManager.getDefault();
				ArrayList<String> texts = manager.divideMessage(message);
				for(String text:texts){
					manager.sendTextMessage(number, null, text, null, null);
				}
				Toast.makeText(getApplicationContext(),R.string.success, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
