package org.androidtown.bluetooth;


import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.miraddi.chord.*;







public class MainActivity extends Activity {
 
	// Debugging
    private static final String TAG = "BluetoothChat";
    private static final boolean D = true;
    
 // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
    private static final int REQUEST_ENABLE_BT = 3;

    // Layout Views
    private ListView mConversationView;
    private EditText mOutEditText;

    public Button mSendButton;
    public Button mSendButton1;
    //Stroke or Chord state
    //private int state = -1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        mSendButton = (Button) findViewById(R.id.stroke);
        mSendButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	// Send a message using content of the edit text widget
				Intent i = new Intent(MainActivity.this, Stroke1.class);
				startActivity(i);
        }
        });
        
        mSendButton1 = (Button) findViewById(R.id.chord);
        mSendButton1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	// Send a message using content of the edit text widget
				Intent i = new Intent(MainActivity.this, Chords.class);
				startActivity(i);
        }
        });

        
        mSendButton1 = (Button) findViewById(R.id.chord2);
        mSendButton1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	// Send a message using content of the edit text widget
				Intent i = new Intent(MainActivity.this, Chords2.class);
				startActivity(i);
        }
        });
        
        
        mSendButton1 = (Button) findViewById(R.id.chords3button);
        mSendButton1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	// Send a message using content of the edit text widget
				Intent i = new Intent(MainActivity.this, Chords3button.class);
				startActivity(i);
        }
        });
        
        //Stroke or Chord

        
        
        
    }
 
    //Stroke or Chord Select Dialog

    }

