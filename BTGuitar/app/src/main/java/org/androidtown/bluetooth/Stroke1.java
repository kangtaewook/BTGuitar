package org.androidtown.bluetooth;



import org.androidtown.bluetooth.Chords.blueToothModule;
import org.miraddi.chord.Chord;



import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.widget.*;

@SuppressLint("ClickableViewAccessibility")
public class Stroke1 extends Activity {
	//--------------------------Bluetooth-----------------------------
		 // Debugging
	    private static final String TAG = "Real Guitar";
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
	    //--------------------------- guitar choice -----------------------------
	    private static final int REQUEST_ACOUSTIC = 2;    
	    private static final int REQUEST_ELECTRICAL = 3;
	    //--------------------------------------------------------------------
	    private static final int REQUEST_ENABLE_BT = 4;
	    
	 // Name of the connected device

	    // Array adapter for the conversation thread
	    private ArrayAdapter<String> mConversationArrayAdapter;
	    private ArrayAdapter<String> mConversationArrayAdapter2;
	    // String buffer for outgoing messages
	    private StringBuffer mOutStringBuffer;
	    // Local Bluetooth adapter
	    public BluetoothAdapter mBluetoothAdapter = null;
	    // Member object for the chat services
	    private BluetoothChatService mChatService = null;
	    private String mConnectedServerName = null;
	    private String mConnectedDeviceName1 = null;
	    private String mConnectedDeviceName2 = null;
	    private String mConnectedDeviceName3 = null;
	   
//	    --------------------------Bluetooth-----------------------------
//	    --------------------------Chord-----------------------------
		Chord chord;
//	    --------------------------Chord-----------------------------
		private long oldTime;
		private float oldX;
	    private float valocity;
		private String result;
		
		private int flag1 = 0;
		private int flag2 = 0;
		private int flag3 = 0;
		private int flag4 = 0;
		private int flag5 = 0;
		private int flag6 = 0;
	    private TextView mTitle;
	    private ListView mConversationView;
	    private ListView mConversationView2;
	    private EditText mOutEditText;
	    private Button mSendButton;
		TextView text;
		private int count = 0;
		public String chordname;
		
		private SoundPool guitar_sound; 

		int [][] string = new int[10][11];
		private int[] flat = new int[11];
		private int[] str= new int [11];

		static final int MODE_TOUCH_PUSH   = 0,

			     MODE_TOUCH_MOVE   = 1,

			     MODE_TOUCH_POP   = 2,

			     INVALID_POINTER_ID  = -1,

			     SIZE_TOUCH_PACKET  = 20;


	
		class blueToothModule extends Thread
		{
			
			public void run(){
				while(true)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					
					str[0] = 0;
					flat[0] = chord.getChord()[0];
					str[1] = 1;
					flat[1] = chord.getChord()[1];
					str[2] = 2;
					flat[2] = chord.getChord()[2];
					str[3] = 3;
					flat[3] = chord.getChord()[3];
					str[4] = 4;
					flat[4] = chord.getChord()[4];
					str[5] = 5;
					flat[5] = chord.getChord()[5];
					
					//C
					if(chord.getChord()[0]==0 && 
					   chord.getChord()[1]==3 && 
					   chord.getChord()[2]==2 && 
					   chord.getChord()[3]==0 && 
					   chord.getChord()[4]==1 && 
					   chord.getChord()[5]==0){
						String message =String.valueOf("1000");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=3 && 
						   chord.getChord()[2]!=2 && 
						   chord.getChord()[4]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Cm
					if(chord.getChord()[0]==3 && chord.getChord()[1]==3 && chord.getChord()[2]==5 && chord.getChord()[3]==5 && chord.getChord()[4]==4 && chord.getChord()[5]==0){
						String message =String.valueOf("1001");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=3 && chord.getChord()[2]!=5 && chord.getChord()[3]!=5 && chord.getChord()[4]!=4){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					
					//C7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==3 && chord.getChord()[2]==2 && chord.getChord()[3]==3 && chord.getChord()[4]==1 && chord.getChord()[5]==0){
						String message =String.valueOf("1002");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=3 && chord.getChord()[2]!=2 && chord.getChord()[3]!=3 && chord.getChord()[4]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//CM7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==3 && chord.getChord()[2]==2 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1003");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=3 && chord.getChord()[2]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					//Cm7
					if(chord.getChord()[0]==3 && chord.getChord()[1]==3 && chord.getChord()[2]==5 && chord.getChord()[3]==3 && chord.getChord()[4]==4 && chord.getChord()[5]==3){
						String message =String.valueOf("1004");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=3 && chord.getChord()[2]!=5 && chord.getChord()[3]!=3 && chord.getChord()[4]!=4 && chord.getChord()[5]!=3){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//D
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==0 && chord.getChord()[3]==2 && chord.getChord()[4]==3 && chord.getChord()[5]==2){
						String message =String.valueOf("1005");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[3]!=2 && chord.getChord()[4]!=3 && chord.getChord()[5]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					
					//Dm
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==0 && chord.getChord()[3]==2 && chord.getChord()[4]==3 && chord.getChord()[5]==1){
						String message =String.valueOf("1006");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[3]!=2 && chord.getChord()[4]!=3 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//D7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==0 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==2){
						String message =String.valueOf("1007");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[3]!=2 && chord.getChord()[4]!=1 && chord.getChord()[5]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//DM7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==0 && chord.getChord()[3]==2 && chord.getChord()[4]==2 && chord.getChord()[5]==2){
						String message =String.valueOf("1008");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[3]!=2 && chord.getChord()[4]!=2 && chord.getChord()[5]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Dm7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==0 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==1){
						String message =String.valueOf("1009");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[3]!=2 && chord.getChord()[4]!=1 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
									
					//E
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==2 && chord.getChord()[3]==1 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1010");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=2 && chord.getChord()[2]!=2 && chord.getChord()[3]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Em
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==2 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1011");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=2 && chord.getChord()[2]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//E7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==0 && chord.getChord()[3]==1 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1012");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=2 && chord.getChord()[3]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//EM7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==1 && chord.getChord()[3]==1 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1013");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=2 && chord.getChord()[2]!=1 && chord.getChord()[3]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Em7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==0 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1014");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//F
					if(chord.getChord()[0]==1 && chord.getChord()[1]==3 && chord.getChord()[2]==3 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==1){
						String message =String.valueOf("1015");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=1 && chord.getChord()[1]!=3 && chord.getChord()[2]!=3 && chord.getChord()[3]!=2 && chord.getChord()[4]!=1 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Fm
					if(chord.getChord()[0]==1 && chord.getChord()[1]==3 && chord.getChord()[2]==3 && chord.getChord()[3]==1 && chord.getChord()[4]==1 && chord.getChord()[5]==1){
						String message =String.valueOf("1016");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=1 && chord.getChord()[1]!=3 && chord.getChord()[2]!=3 && chord.getChord()[3]!=1 && chord.getChord()[4]!=1 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//F7
					if(chord.getChord()[0]==1 && chord.getChord()[1]==3 && chord.getChord()[2]==1 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==1){
						String message =String.valueOf("1017");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=1 && chord.getChord()[1]!=3 && chord.getChord()[2]!=1 && chord.getChord()[3]!=2 && chord.getChord()[4]!=1 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
										
					//FM7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==3 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==0){
						String message =String.valueOf("1018");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=3 && chord.getChord()[3]!=2 && chord.getChord()[4]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Fm7
					if(chord.getChord()[0]==1 && chord.getChord()[1]==3 && chord.getChord()[2]==1 && chord.getChord()[3]==1 && chord.getChord()[4]==1 && chord.getChord()[5]==1){
						String message =String.valueOf("1019");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=1 && chord.getChord()[1]!=3 && chord.getChord()[2]!=1 && chord.getChord()[3]!=1 && chord.getChord()[4]!=1 && chord.getChord()[5]!=1){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//G
					if(chord.getChord()[0]==3 && chord.getChord()[1]==2 && chord.getChord()[2]==0 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==3){
						String message =String.valueOf("1020");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=2 && chord.getChord()[5]!=3){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Gm
					if(chord.getChord()[0]==3 && chord.getChord()[1]==5 && chord.getChord()[2]==5 && chord.getChord()[3]==3 && chord.getChord()[4]==3 && chord.getChord()[5]==3){
						String message =String.valueOf("1021");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=5 && chord.getChord()[2]!=5 && chord.getChord()[3]!=3 && chord.getChord()[4]!=3 && chord.getChord()[5]!=3){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//G7
					if(chord.getChord()[0]==3 && chord.getChord()[1]==2 && chord.getChord()[2]==0 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==0){
						String message =String.valueOf("1022");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=2 && chord.getChord()[5]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//GM7
					if(chord.getChord()[0]==3 && chord.getChord()[1]==2 && chord.getChord()[2]==0 && chord.getChord()[3]==0 && chord.getChord()[4]==0 && chord.getChord()[5]==2){
						String message =String.valueOf("1023");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=2 && chord.getChord()[5]!=2){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//Gm7
					if(chord.getChord()[0]==3 && chord.getChord()[1]==5 && chord.getChord()[2]==3 && chord.getChord()[3]==3 && chord.getChord()[4]==3 && chord.getChord()[5]==3){
						String message =String.valueOf("1024");
						sendMessage(message);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[0]!=3 && chord.getChord()[1]!=5 && chord.getChord()[2]!=3 && chord.getChord()[3]!=3 && chord.getChord()[4]!=3 && chord.getChord()[5]!=3){
							
							String message2 =String.valueOf("0");
							sendMessage(message2);
						}
					}
					
					//A
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==2 && chord.getChord()[3]==2 && chord.getChord()[4]==2 && chord.getChord()[5]==0){
					 String message =String.valueOf("1025");
					 sendMessage(message);
					 try {
					    Thread.sleep(200);
					 } catch (InterruptedException e) {
					 
					    e.printStackTrace();
					 } 
					 if(chord.getChord()[2]!=2 && chord.getChord()[3]!=2 && chord.getChord()[4]!=2){
					    
					    String message2 =String.valueOf("0");
					    sendMessage(message2);
					 }
					}

					//Am
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==2 && chord.getChord()[3]==2 && chord.getChord()[4]==1 && chord.getChord()[5]==0){
					 String message =String.valueOf("1026");
					 sendMessage(message);
					 try {
					    Thread.sleep(200);
					 } catch (InterruptedException e) {
					 
					    e.printStackTrace();
					 } 
					 if(chord.getChord()[2]!=2 && chord.getChord()[3]!=2 && chord.getChord()[4]!=1){
					    
					    String message2 =String.valueOf("0");
					    sendMessage(message2);
					 }
					}

					//A7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==2 && chord.getChord()[3]==0 && chord.getChord()[4]==2 && chord.getChord()[5]==0){
					String message =String.valueOf("1027");
					sendMessage(message);
					try {
					  Thread.sleep(200);
					} catch (InterruptedException e) {

					  e.printStackTrace();
					} 
					if(chord.getChord()[2]!=2 && chord.getChord()[4]!=2){
					  
					  String message2 =String.valueOf("0");
					  sendMessage(message2);
					}
					}


					//AM7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==2 && chord.getChord()[3]==1 && chord.getChord()[4]==2 && chord.getChord()[5]==0){
					String message =String.valueOf("1028");
					sendMessage(message);
					try {
					Thread.sleep(200);
					} catch (InterruptedException e) {

					e.printStackTrace();
					} 
					if(chord.getChord()[2]!=2 && chord.getChord()[3]!=1 && chord.getChord()[4]!=2){

					String message2 =String.valueOf("0");
					sendMessage(message2);
					}
					}

					//Am7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==0 && chord.getChord()[2]==2 && chord.getChord()[3]==0 && chord.getChord()[4]==1 && chord.getChord()[5]==0){
					String message =String.valueOf("1029");
					sendMessage(message);
					try {
					Thread.sleep(200);
					} catch (InterruptedException e) {

					e.printStackTrace();
					} 
					if(chord.getChord()[2]!=2 && chord.getChord()[4]!=1){

					String message2 =String.valueOf("0");
					sendMessage(message2);
					}
					}
					

					//B
					if(chord.getChord()[0]==1 && chord.getChord()[1]==1 && chord.getChord()[2]==3 && chord.getChord()[3]==3 && chord.getChord()[4]==3 && chord.getChord()[5]==1){
					   String message =String.valueOf("1030");
					   sendMessage(message);
					   try {
					      Thread.sleep(200);
					   } catch (InterruptedException e) {
					   
					      e.printStackTrace();
					   } 
					   if(chord.getChord()[0]!=1 && chord.getChord()[1]!=1 && chord.getChord()[2]!=3 && chord.getChord()[3]!=3 && chord.getChord()[4]!=3 && chord.getChord()[5]!=1){
					      
					      String message2 =String.valueOf("0");
					      sendMessage(message2);
					   }
					}

					//Bm
					if(chord.getChord()[0]==1 && chord.getChord()[1]==1 && chord.getChord()[2]==3 && chord.getChord()[3]==3 && chord.getChord()[4]==2 && chord.getChord()[5]==1){
					 String message =String.valueOf("1031");
					 sendMessage(message);
					 try {
					    Thread.sleep(200);
					 } catch (InterruptedException e) {
					 
					    e.printStackTrace();
					 } 
					 if(chord.getChord()[0]!=1 && chord.getChord()[1]!=1 && chord.getChord()[2]!=3 && chord.getChord()[3]!=3 && chord.getChord()[4]!=2 && chord.getChord()[5]!=1){
					    
					    String message2 =String.valueOf("0");
					    sendMessage(message2);
					 }
					}

					//B7
					if(chord.getChord()[0]==0 && chord.getChord()[1]==2 && chord.getChord()[2]==1 && chord.getChord()[3]==2 && chord.getChord()[4]==0 && chord.getChord()[5]==2){
					String message =String.valueOf("1032");
					sendMessage(message);
					try {
					  Thread.sleep(200);
					} catch (InterruptedException e) {

					  e.printStackTrace();
					} 
					if(chord.getChord()[1]!=2 && chord.getChord()[2]!=1 && chord.getChord()[3]!=2 && chord.getChord()[5]!=1){
					  
					  String message2 =String.valueOf("0");
					  sendMessage(message2);
					}
					}

					//BM7
					if(chord.getChord()[0]==1 && chord.getChord()[1]==1 && chord.getChord()[2]==3 && chord.getChord()[3]==2 && chord.getChord()[4]==3 && chord.getChord()[5]==1){
					String message =String.valueOf("1033");
					sendMessage(message);
					try {
					  Thread.sleep(200);
					} catch (InterruptedException e) {

					  e.printStackTrace();
					} 
					if(chord.getChord()[0]!=1 && chord.getChord()[1]!=1 && chord.getChord()[2]!=3 && chord.getChord()[3]!=2 && chord.getChord()[4]!=3 && chord.getChord()[5]!=1){
					  
					  String message2 =String.valueOf("0");
					  sendMessage(message2);
					}
					}

					//Bm7
					if(chord.getChord()[0]==1 && chord.getChord()[1]==1 && chord.getChord()[2]==3 && chord.getChord()[3]==1 && chord.getChord()[4]==2 && chord.getChord()[5]==1){
					String message =String.valueOf("1034");
					sendMessage(message);
					try {
					  Thread.sleep(200);
					} catch (InterruptedException e) {

					  e.printStackTrace();
					} 
					if(chord.getChord()[0]!=1 && chord.getChord()[1]!=1 && chord.getChord()[2]!=3 && chord.getChord()[3]!=1 && chord.getChord()[4]!=2 && chord.getChord()[5]!=1){
					  
					  String message2 =String.valueOf("0");
					  sendMessage(message2);
					}
					}
					
				}
			}
		}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.stroke);
		
		chord = new Chord();
		chord.initChord();
		
		mConversationArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
	    mConversationView = (ListView) findViewById(R.id.in);
	    mConversationView.setAdapter(mConversationArrayAdapter);

	    
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        
        
		for(int i=0; i<6; i++)
		{
			str[i] = i;
			flat[i] = 0;
		}
		
		blueToothModule a = new blueToothModule();
		a.start();
		
        guitar_sound = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        set_sound1();
        
  
        
        
        final Vibrator mVibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

 
/*        
        LinearLayout frame1 = (LinearLayout) findViewById(R.id.BackFrame);
        
        
         
        frame1.setOnTouchListener(new OnTouchListener() {
			
		
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
//				 text = (TextView) findViewById(R.id.textView1);
				 int width = getWindowManager().getDefaultDisplay().getWidth();
				 float block = width/6;
				 int ppp=0;
				 int touchCount = event.getPointerCount();

				

				switch(event.getAction())
					{
				
				
				
				
						case MotionEvent.ACTION_DOWN:
								oldX = (int) event.getRawX();
								oldTime = event.getEventTime();
	
								if(event.getX() < ((block))){
									
										//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f );
										mVibe.vibrate(50);
						
										
										if(flat[0]==0){
											int k = 1;
											String message =String.valueOf(1);
											sendMessage(message);
										}
										if(flat[0]==1){
											int k = 2;
											String message =String.valueOf(2);
											sendMessage(message);
										}
										if(flat[0]==2){
											int k = 3;
											String message =String.valueOf(3);
											sendMessage(message);
										}
										if(flat[0]==3){
											int k = 4;
											String message =String.valueOf(4);
											sendMessage(message);
										}
										if(flat[0]==4){
											int k = 5;
											String message =String.valueOf(5);
											sendMessage(message);
										}
										if(flat[0]==5){
											int k = 6;
											String message =String.valueOf(6);
											sendMessage(message);
										}
										if(flat[0]==6){
											
											String message =String.valueOf(7);
											sendMessage(message);
										}
										if(flat[0]==7){
											
											String message =String.valueOf(8);
											sendMessage(message);
										}
										if(flat[0]==8){
											
											String message =String.valueOf(9);
											sendMessage(message);
										}
										if(flat[0]==9){
											
											String message =String.valueOf(91);
											sendMessage(message);
										}
										if(flat[0]==10){
											
											String message =String.valueOf(92);
											sendMessage(message);
										}
																		
										
										
										
										
								}else if( block <= event.getX() && event.getX() < block*2  ){
									
									
										//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[1] ][ flat[1] ], 1 , 1, 0, 0, 1f );
										mVibe.vibrate(50);
							
								
										
										if(flat[1]==0){
											int k = 11;
											String message =String.valueOf(11);
											sendMessage(message);
										}
										if(flat[1]==1){
											int k = 12;
											String message =String.valueOf(12);
											sendMessage(message);
										}
										if(flat[1]==2){
											int k = 13;
											String message =String.valueOf(13);
											sendMessage(message);
										}
										if(flat[1]==3){
											int k = 14;
											String message =String.valueOf(14);
											sendMessage(message);
										}
										if(flat[1]==4){
											int k = 15;
											String message =String.valueOf(15);
											sendMessage(message);
										}
										if(flat[1]==5){
											int k = 16;
											String message =String.valueOf(16);
											sendMessage(message);
										}
										if(flat[1]==6){
											
											String message =String.valueOf(17);
											sendMessage(message);
										}
										if(flat[1]==7){
											
											String message =String.valueOf(18);
											sendMessage(message);
										}
										if(flat[1]==8){
											
											String message =String.valueOf(19);
											sendMessage(message);
										}
										if(flat[1]==9){
											
											String message =String.valueOf(110);
											sendMessage(message);
										}
										if(flat[1]==10){
											
											String message =String.valueOf(111);
											sendMessage(message);
										}
									
								}else if( block*2 <= event.getX() && event.getX() < block*3  ){
									
								
									
									
										//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );
										mVibe.vibrate(50);
								
										if(flat[2]==0){
											int k = 21;
											String message =String.valueOf(21);
											sendMessage(message);
										}
										if(flat[2]==1){
											int k = 22;
											String message =String.valueOf(22);
											sendMessage(message);
										}
										if(flat[2]==2){
											int k = 23;
											String message =String.valueOf(23);
											sendMessage(message);
										}
										if(flat[2]==3){
											int k = 24;
											String message =String.valueOf(24);
											sendMessage(message);
										}
										if(flat[2]==4){
											int k = 25;
											String message =String.valueOf(25);
											sendMessage(message);
										}
										if(flat[2]==5){
											int k = 26;
											String message =String.valueOf(26);
											sendMessage(message);
										}
										if(flat[2]==6){
											
											String message =String.valueOf(27);
											sendMessage(message);
										}
										if(flat[2]==7){
											
											String message =String.valueOf(28);
											sendMessage(message);
										}
										if(flat[2]==8){
											
											String message =String.valueOf(29);
											sendMessage(message);
										}
										if(flat[2]==9){
											
											String message =String.valueOf(210);
											sendMessage(message);
										}
										if(flat[2]==10){
											
											String message =String.valueOf(211);
											sendMessage(message);
										}
									
									
								}else if( block*3 <= event.getX() && event.getX() < block*4  ){
									
									
										//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[3] ][ flat[3] ], 1 , 1, 0, 0, 1f );
										mVibe.vibrate(50);
						
									
										if(flat[3]==0){
											String message =String.valueOf(31);
											sendMessage(message);
										}
										if(flat[3]==1){
											String message =String.valueOf(32);
											sendMessage(message);
										}
										if(flat[3]==2){
											String message =String.valueOf(33);
											sendMessage(message);
										}
										if(flat[3]==3){
											String message =String.valueOf(34);
											sendMessage(message);
										}
										if(flat[3]==4){
											String message =String.valueOf(35);
											sendMessage(message);
										}
										if(flat[3]==5){
											String message =String.valueOf(36);
											sendMessage(message);
										}
										if(flat[3]==6){
											String message =String.valueOf(37);
											sendMessage(message);
										}
										if(flat[3]==7){				
											String message =String.valueOf(38);
											sendMessage(message);
										}
										if(flat[3]==8){
											String message =String.valueOf(39);
											sendMessage(message);
										}
										if(flat[3]==9){
											String message =String.valueOf(310);
											sendMessage(message);
										}
										if(flat[3]==10){
											String message =String.valueOf(311);
											sendMessage(message);
										}
								}else if( block*4 <= event.getX() && event.getX() < block*5  ){
									
									
										//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[4] ][ flat[4] ],1 , 1, 0, 0, 1f );
										mVibe.vibrate(50);
								
										if(flat[4]==0){
											int k = 41;
											String message =String.valueOf(41);
											sendMessage(message);
										}
										if(flat[4]==1){
											int k = 42;
											String message =String.valueOf(42);
											sendMessage(message);
										}
										if(flat[4]==2){
											int k = 43;
											String message =String.valueOf(43);
											sendMessage(message);
										}
										if(flat[4]==3){
											int k = 44;
											String message =String.valueOf(44);
											sendMessage(message);
										}
										if(flat[4]==4){
											int k = 45;
											String message =String.valueOf(45);
											sendMessage(message);
										}
										if(flat[4]==5){
											int k = 46;
											String message =String.valueOf(46);
											sendMessage(message);
										}
										if(flat[4]==6){
											
											String message =String.valueOf(47);
											sendMessage(message);
										}
										if(flat[4]==7){
											
											String message =String.valueOf(48);
											sendMessage(message);
										}
										if(flat[4]==8){
											
											String message =String.valueOf(49);
											sendMessage(message);
										}
										if(flat[4]==9){
											
											String message =String.valueOf(410);
											sendMessage(message);
										}
										if(flat[4]==10){
											
											String message =String.valueOf(411);
											sendMessage(message);
										}
									
									
									
								}else if( block*5 <= event.getX() && event.getX() < block*6  ){
									
									
										//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
										guitar_sound.play( string[ str[5] ][ flat[5] ],1 ,1, 0, 0, 1f );
										mVibe.vibrate(50);
							
										if(flat[5]==0){
											int k = 51;
											String message =String.valueOf(51);
											sendMessage(message);
										}
										if(flat[5]==1){
											int k = 52;
											String message =String.valueOf(52);
											sendMessage(message);
										}
										if(flat[5]==2){
											int k = 53;
											String message =String.valueOf(53);
											sendMessage(message);
										}
										if(flat[5]==3){
											int k = 54;
											String message =String.valueOf(54);
											sendMessage(message);
										}
										if(flat[5]==4){
											int k = 55;
											String message =String.valueOf(55);
											sendMessage(message);
										}
										if(flat[5]==5){
											int k = 56;
											String message =String.valueOf(56);
											sendMessage(message);
										}
										if(flat[5]==6){
											
											String message =String.valueOf(57);
											sendMessage(message);
										}
										if(flat[5]==7){
											
											String message =String.valueOf(58);
											sendMessage(message);
										}
										if(flat[5]==8){
											
											String message =String.valueOf(59);
											sendMessage(message);
										}
										if(flat[5]==9){
											
											String message =String.valueOf(510);
											sendMessage(message);
										}
										if(flat[5]==10){
											
											String message =String.valueOf(511);
											sendMessage(message);
										}
									
								}
																			
								break;
								
								
						case MotionEvent.ACTION_POINTER_DOWN:
						
							final int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT; //?
							final int pointerId = event.getPointerId(pointerIndex);
				
							final float x = event.getX(pointerId);
							final float y = event.getY(pointerId);
							
									if(x < ((block))){
										   mConversationArrayAdapter.add(": ㅋ1 ");
											//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
											guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f );
											mVibe.vibrate(50);
							
											
											if(flat[0]==0){
												int k = 1;
												String message =String.valueOf(1);
												sendMessage(message);
											}
											if(flat[0]==1){
												int k = 2;
												String message =String.valueOf(2);
												sendMessage(message);
											}
											if(flat[0]==2){
												int k = 3;
												String message =String.valueOf(3);
												sendMessage(message);
											}
											if(flat[0]==3){
												int k = 4;
												String message =String.valueOf(4);
												sendMessage(message);
											}
											if(flat[0]==4){
												int k = 5;
												String message =String.valueOf(5);
												sendMessage(message);
											}
											if(flat[0]==5){
												int k = 6;
												String message =String.valueOf(6);
												sendMessage(message);
											}
											if(flat[0]==6){
												
												String message =String.valueOf(7);
												sendMessage(message);
											}
											if(flat[0]==7){
												
												String message =String.valueOf(8);
												sendMessage(message);
											}
											if(flat[0]==8){
												
												String message =String.valueOf(9);
												sendMessage(message);
											}
											if(flat[0]==9){
												
												String message =String.valueOf(91);
												sendMessage(message);
											}
											if(flat[0]==10){
												
												String message =String.valueOf(92);
												sendMessage(message);
											}
																		
											
											
									}else if( block <= x &&x < block*2  ){
										 mConversationArrayAdapter.add(": ㅋ2 ");

											//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
											guitar_sound.play( string[ str[1] ][ flat[1] ], 1 , 1, 0, 0, 1f );
											mVibe.vibrate(50);
								
									
											
											if(flat[1]==0){
												int k = 11;
												String message =String.valueOf(11);
												sendMessage(message);
											}
											if(flat[1]==1){
												int k = 12;
												String message =String.valueOf(12);
												sendMessage(message);
											}
											if(flat[1]==2){
												int k = 13;
												String message =String.valueOf(13);
												sendMessage(message);
											}
											if(flat[1]==3){
												int k = 14;
												String message =String.valueOf(14);
												sendMessage(message);
											}
											if(flat[1]==4){
												int k = 15;
												String message =String.valueOf(15);
												sendMessage(message);
											}
											if(flat[1]==5){
												int k = 16;
												String message =String.valueOf(16);
												sendMessage(message);
											}
											if(flat[1]==6){
												
												String message =String.valueOf(17);
												sendMessage(message);
											}
											if(flat[1]==7){
												
												String message =String.valueOf(18);
												sendMessage(message);
											}
											if(flat[1]==8){
												
												String message =String.valueOf(19);
												sendMessage(message);
											}
											if(flat[1]==9){
												
												String message =String.valueOf(110);
												sendMessage(message);
											}
											if(flat[1]==10){
												
												String message =String.valueOf(111);
												sendMessage(message);
											}
											
											
									}else if( block*2 <=x &&x < block*3  ){
										
										 mConversationArrayAdapter.add(": ㅋ3 ");

											
											//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
											guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );
											mVibe.vibrate(50);
									
											if(flat[2]==0){
												int k = 21;
												String message =String.valueOf(21);
												sendMessage(message);
											}
											if(flat[2]==1){
												int k = 22;
												String message =String.valueOf(22);
												sendMessage(message);
											}
											if(flat[2]==2){
												int k = 23;
												String message =String.valueOf(23);
												sendMessage(message);
											}
											if(flat[2]==3){
												int k = 24;
												String message =String.valueOf(24);
												sendMessage(message);
											}
											if(flat[2]==4){
												int k = 25;
												String message =String.valueOf(25);
												sendMessage(message);
											}
											if(flat[2]==5){
												int k = 26;
												String message =String.valueOf(26);
												sendMessage(message);
											}
											if(flat[2]==6){
												
												String message =String.valueOf(27);
												sendMessage(message);
											}
											if(flat[2]==7){
												
												String message =String.valueOf(28);
												sendMessage(message);
											}
											if(flat[2]==8){
												
												String message =String.valueOf(29);
												sendMessage(message);
											}
											if(flat[2]==9){
												
												String message =String.valueOf(210);
												sendMessage(message);
											}
											if(flat[2]==10){
												
												String message =String.valueOf(211);
												sendMessage(message);
											}
										
										
									}else if( block*3 <= x&& x < block*4  ){
										 mConversationArrayAdapter.add(": ㅋ4 ");
									
									}else if( block*4 <= x && x < block*5  ){
										 mConversationArrayAdapter.add(": ㅋ5 ");
									
										
									}else if( block*5 <= x && x < block*6  ){
										 mConversationArrayAdapter.add(": ㅋ6 ");
										
									}
								break;	
				
							
						case MotionEvent.ACTION_UP:
							
								valocity = (event.getRawX() - oldX ) / (float)(event.getEventTime() - oldTime);
								if(valocity < 0)
									valocity *= (-1);
								result = "터치 속도 : "+ (int)valocity;
//								text.setText( result );
								 mConversationArrayAdapter2.add(":  " + result);
								break;
								
					

				case MotionEvent.ACTION_MOVE:
					
				
						
						if(event.getX() < ((block))){
							if( flag1 == 0 ){
								//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
								if(flat[0]==0){
									
									String message =String.valueOf(1);
									sendMessage(message);
								}
								if(flat[0]==1){
									
									String message =String.valueOf(2);
									sendMessage(message);
								}
								if(flat[0]==2){
									
									String message =String.valueOf(3);
									sendMessage(message);
								}
								if(flat[0]==3){
								
									String message =String.valueOf(4);
									sendMessage(message);
								}
								if(flat[0]==4){
								
									String message =String.valueOf(5);
									sendMessage(message);
								}
								if(flat[0]==5){
									
									String message =String.valueOf(6);
									sendMessage(message);
								}
								if(flat[0]==6){
									
									String message =String.valueOf(7);
									sendMessage(message);
								}
								if(flat[0]==7){
									
									String message =String.valueOf(8);
									sendMessage(message);
								}
								if(flat[0]==8){
									
									String message =String.valueOf(9);
									sendMessage(message);
								}
								if(flat[0]==9){
									
									String message =String.valueOf(010);
									sendMessage(message);
								}
								if(flat[0]==10){
									
									String message =String.valueOf(011);
									sendMessage(message);
								}
								
					
								
							
								flag1 = 1;
								flag2 = 0;
								flag3 = 0;
								flag4 = 0;
								flag5 = 0;
								flag6 = 0;
						
								
							}
																								
						}else if( block <= event.getX() && event.getX() < block*2  ){
							
							if( flag2 == 0 ){
								//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 ,valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
								
								if(flat[1]==0){
									
									String message =String.valueOf(11);
									sendMessage(message);
								}
								if(flat[1]==1){
									
									String message =String.valueOf(12);
									sendMessage(message);
								}
								if(flat[1]==2){
									
									String message =String.valueOf(13);
									sendMessage(message);
								}
								if(flat[1]==3){
									
									String message =String.valueOf(14);
									sendMessage(message);
								}
								if(flat[1]==4){
									
									String message =String.valueOf(15);
									sendMessage(message);
								}
								if(flat[1]==5){
									
									String message =String.valueOf(16);
									sendMessage(message);
								}
								if(flat[1]==6){
									
									String message =String.valueOf(17);
									sendMessage(message);
								}
								if(flat[1]==7){
									
									String message =String.valueOf(18);
									sendMessage(message);
								}
								if(flat[1]==8){
									
									String message =String.valueOf(19);
									sendMessage(message);
								}
								if(flat[1]==9){
									
									String message =String.valueOf(110);
									sendMessage(message);
								}
								if(flat[1]==10){
									
									String message =String.valueOf(111);
									sendMessage(message);
								}
								
								
							
								
								flag2 = 1;
								flag1 = 0;
								flag3 = 0;
								flag4 = 0;
								flag5 = 0;
								flag6 = 0;

								
							}
																			
							
						}else if( block*2 <= event.getX() && event.getX() < block*3  ){
							
							if( flag3 == 0 ){
								//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
								
								
								
						
								if(flat[2]==0){
									
									String message =String.valueOf(21);
									sendMessage(message);
								}
								if(flat[2]==1){
									
									String message =String.valueOf(22);
									sendMessage(message);
								}
								if(flat[2]==2){
									
									String message =String.valueOf(23);
									sendMessage(message);
								}
								if(flat[2]==3){
									
									String message =String.valueOf(24);
									sendMessage(message);
								}
								if(flat[2]==4){
									
									String message =String.valueOf(25);
									sendMessage(message);
								}
								if(flat[2]==5){
									
									String message =String.valueOf(26);
									sendMessage(message);
								}
								if(flat[2]==6){
									
									String message =String.valueOf(27);
									sendMessage(message);
								}
								if(flat[2]==7){
									
									String message =String.valueOf(28);
									sendMessage(message);
								}
								if(flat[2]==8){
									
									String message =String.valueOf(29);
									sendMessage(message);
								}
								if(flat[2]==9){
									
									String message =String.valueOf(210);
									sendMessage(message);
								}
								if(flat[2]==10){
									
									String message =String.valueOf(211);
									sendMessage(message);
								}
							

								
								flag3 = 1;
								flag2 = 0;
								flag1 = 0;
								flag4 = 0;
								flag5 = 0;
								flag6 = 0;
								

								
							}
							
						}else if( block*3 <= event.getX() && event.getX() < block*4  ){
							
							if( flag4 == 0 ){
								//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
							
								if(flat[3]==0){
									
									String message =String.valueOf(31);
									sendMessage(message);
								}
								if(flat[3]==1){
									
									String message =String.valueOf(32);
									sendMessage(message);
								}
								if(flat[3]==2){
									
									String message =String.valueOf(33);
									sendMessage(message);
								}
								if(flat[3]==3){
									
									String message =String.valueOf(34);
									sendMessage(message);
								}
								if(flat[3]==4){
									
									String message =String.valueOf(35);
									sendMessage(message);
								}
								if(flat[3]==5){
									
									String message =String.valueOf(36);
									sendMessage(message);
								}
								if(flat[3]==6){
									
									String message =String.valueOf(37);
									sendMessage(message);
								}
								if(flat[3]==7){
									
									String message =String.valueOf(38);
									sendMessage(message);
								}
								if(flat[3]==8){
									
									String message =String.valueOf(39);
									sendMessage(message);
								}
								if(flat[3]==9){
									
									String message =String.valueOf(310);
									sendMessage(message);
								}
								if(flat[3]==10){
									
									String message =String.valueOf(311);
									sendMessage(message);
								}
								
								
								
								flag4 = 1;
								flag2 = 0;
								flag3 = 0;
								flag1 = 0;
								flag5 = 0;
								flag6 = 0;								
								
							}
							
						}else if( block*4 <= event.getX() && event.getX() < block*5  ){
							
							if( flag5 == 0 ){
								//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
								
				
								if(flat[4]==0){
									
									String message =String.valueOf(41);
									sendMessage(message);
								}
								if(flat[4]==1){
									
									String message =String.valueOf(42);
									sendMessage(message);
								}
								if(flat[4]==2){
									
									String message =String.valueOf(43);
									sendMessage(message);
								}
								if(flat[4]==3){
									
									String message =String.valueOf(44);
									sendMessage(message);
								}
								if(flat[4]==4){
									
									String message =String.valueOf(45);
									sendMessage(message);
								}
								if(flat[4]==5){
									
									String message =String.valueOf(46);
									sendMessage(message);
								}
								if(flat[4]==6){
									
									String message =String.valueOf(47);
									sendMessage(message);
								}
								if(flat[4]==7){
									
									String message =String.valueOf(48);
									sendMessage(message);
								}
								if(flat[4]==8){
									
									String message =String.valueOf(49);
									sendMessage(message);
								}
								if(flat[4]==9){
									
									String message =String.valueOf(410);
									sendMessage(message);
								}
								if(flat[4]==10){
									
									String message =String.valueOf(411);
									sendMessage(message);
								}
							
						
								flag5 = 1;
								flag2 = 0;
								flag3 = 0;
								flag4 = 0;
								flag1 = 0;
								flag6 = 0;
								

							}
							
						}else if( block*5 <= event.getX() && event.getX() < block*6  ){
							
							if( flag6 == 0 ){
								//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
								guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
								mVibe.vibrate(50);
							
								if(flat[5]==0){
									
									String message =String.valueOf(51);
									sendMessage(message);
								}
								if(flat[5]==1){
									
									String message =String.valueOf(52);
									sendMessage(message);
								}
								if(flat[5]==2){
									
									String message =String.valueOf(53);
									sendMessage(message);
								}
								if(flat[5]==3){
									
									String message =String.valueOf(54);
									sendMessage(message);
								}
								if(flat[5]==4){
									
									String message =String.valueOf(55);
									sendMessage(message);
								}
								if(flat[5]==5){
									
									String message =String.valueOf(56);
									sendMessage(message);
								}
								if(flat[5]==6){
									
									String message =String.valueOf(57);
									sendMessage(message);
								}
								if(flat[5]==7){
									
									String message =String.valueOf(58);
									sendMessage(message);
								}
								if(flat[5]==8){
									
									String message =String.valueOf(59);
									sendMessage(message);
								}
								if(flat[5]==9){
									
									String message =String.valueOf(510);
									sendMessage(message);
								}
								if(flat[5]==10){
									
									String message =String.valueOf(511);
									sendMessage(message);
								}
								flag6 = 1;
								flag2 = 0;
								flag3 = 0;
								flag4 = 0;
								flag5 = 0;
								flag1 = 0;
																		
							}
							
						}
						break;
				
			
				
					}
				return true;
					
			}
		});
		  */
		
        
        
  
        
	}
	
	/*
	public void mute(){		
				AudioManager audio_manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
				 // 미디어 볼륨 줄이기
				audio_manager.setStreamVolume(AudioManager.STREAM_MUSIC, (int)(audio_manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * 0.1), 0);
	}
	
	*/
	
	
    @Override
    public boolean onTouchEvent(MotionEvent event) {

    	final Vibrator mVibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		 int width = getWindowManager().getDefaultDisplay().getWidth();
		 int height = getWindowManager().getDefaultDisplay().getHeight();
		 float block = width/6;
		 float hblock = height/7;
	
        // get pointer index from the event object
        int pointerIndex = event.getActionIndex();

        // get pointer ID
        int pointerId = event.getPointerId(pointerIndex);

        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();

        switch (maskedAction) {

        case MotionEvent.ACTION_DOWN:
        	
        	oldX = (int) event.getRawX();
			oldTime = event.getEventTime();
/*
			if(event.getY() < ((block)) ){
			mute();
			}
			
			*/
			if(event.getX() < ((block))){
				
				
					guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
	
					
					if(flat[0]==0){
					
						String message = "1";
						sendMessage(message);
					}
					if(flat[0]==1){
						
						String message ="2";
						sendMessage(message);
					}
					if(flat[0]==2){
						
						String message ="3";
						sendMessage(message);
					}
					if(flat[0]==3){
						//int k = 4;
						String message ="4";
						sendMessage(message);
					}
					if(flat[0]==4){
						//int k = 5;
						String message ="5";
						sendMessage(message);
					}
					if(flat[0]==5){
						//int k = 6;
						String message ="6";
						sendMessage(message);
					}
					if(flat[0]==6){
						
						String message ="7";
						sendMessage(message);
					}
					if(flat[0]==7){
						
						String message ="8";
						sendMessage(message);
					}
					if(flat[0]==8){
						
						String message ="9";
						sendMessage(message);
					}
					if(flat[0]==9){
						
						String message ="91";
						sendMessage(message);
					}
					if(flat[0]==10){
						
						String message ="92";
						sendMessage(message);
					}
													
					
					
					
					
			}else if( block <= event.getX() && event.getX() < block*2  ){
				
				
			
					guitar_sound.play( string[ str[1] ][ flat[1] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
							
					if(flat[1]==0){
						
						String message ="11";
						sendMessage(message);
					}
					if(flat[1]==1){
						
						String message ="12";
						sendMessage(message);
					}
					if(flat[1]==2){
						
						String message ="13";
						sendMessage(message);
					}
					if(flat[1]==3){
						//int k = 14;
						String message ="14";
						sendMessage(message);
					}
					if(flat[1]==4){
						//int k = 15;
						String message ="15";
						sendMessage(message);
					}
					if(flat[1]==5){
						//int k = 16;
						String message ="16";
						sendMessage(message);
					}
					if(flat[1]==6){
						
						String message ="17";
						sendMessage(message);
					}
					if(flat[1]==7){
						
						String message ="18";
						sendMessage(message);
					}
					if(flat[1]==8){
						
						String message ="19";
						sendMessage(message);
					}
					if(flat[1]==9){
						
						String message ="110";
						sendMessage(message);
					}
					if(flat[1]==10){
						
						String message ="111";
						sendMessage(message);
					}
				
			}else if( block*2 <= event.getX() && event.getX() < block*3  ){
				
			
				
				
					//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
			
					if(flat[2]==0){
						//int k = 21;
						String message ="21";
						sendMessage(message);
					}
					if(flat[2]==1){
						//int k = 22;
						String message ="22";
						sendMessage(message);
					}
					if(flat[2]==2){
						//int k = 23;
						String message ="23";
						sendMessage(message);
					}
					if(flat[2]==3){
						//int k = 24;
						String message ="24";
						sendMessage(message);
					}
					if(flat[2]==4){
						//int k = 25;
						String message ="25";
						sendMessage(message);
					}
					if(flat[2]==5){
						//int k = 26;
						String message ="26";
						sendMessage(message);
					}
					if(flat[2]==6){
						
						String message ="27";
						sendMessage(message);
					}
					if(flat[2]==7){
						
						String message ="28";
						sendMessage(message);
					}
					if(flat[2]==8){
						
						String message ="29";
						sendMessage(message);
					}
					if(flat[2]==9){
						
						String message ="210";
						sendMessage(message);
					}
					if(flat[2]==10){
						
						String message ="211";
						sendMessage(message);
					}
				
				
			}else if( block*3 <= event.getX() && event.getX() < block*4  ){
				
				
					//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[3] ][ flat[3] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
	
				
					if(flat[3]==0){
						String message ="31";
						sendMessage(message);
					}
					if(flat[3]==1){
						String message ="32";
						sendMessage(message);
					}
					if(flat[3]==2){
						String message ="33";
						sendMessage(message);
					}
					if(flat[3]==3){
						String message ="34";
						sendMessage(message);
					}
					if(flat[3]==4){
						String message ="35";
						sendMessage(message);
					}
					if(flat[3]==5){
						String message ="36";
						sendMessage(message);
					}
					if(flat[3]==6){
						String message ="37";
						sendMessage(message);
					}
					if(flat[3]==7){				
						String message ="38";
						sendMessage(message);
					}
					if(flat[3]==8){
						String message ="39";
						sendMessage(message);
					}
					if(flat[3]==9){
						String message ="310";
						sendMessage(message);
					}
					if(flat[3]==10){
						String message ="311";
						sendMessage(message);
					}
			}else if( block*4 <= event.getX() && event.getX() < block*5  ){
				
				
					//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[4] ][ flat[4] ],1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
			
					if(flat[4]==0){
						//int k = 41;
						String message ="41";
						sendMessage(message);
					}
					if(flat[4]==1){
						//int k = 42;
						String message ="42";
						sendMessage(message);
					}
					if(flat[4]==2){
						//int k = 43;
						String message ="43";
						sendMessage(message);
					}
					if(flat[4]==3){
						//int k = 44;
						String message ="44";
						sendMessage(message);
					}
					if(flat[4]==4){
						//int k = 45;
						String message ="45";
						sendMessage(message);
					}
					if(flat[4]==5){
						//int k = 46;
						String message ="46";
						sendMessage(message);
					}
					if(flat[4]==6){
						
						String message ="47";
						sendMessage(message);
					}
					if(flat[4]==7){
						
						String message ="48";
						sendMessage(message);
					}
					if(flat[4]==8){
						
						String message ="49";
						sendMessage(message);
					}
					if(flat[4]==9){
						
						String message ="410";
						sendMessage(message);
					}
					if(flat[4]==10){
						
						String message ="411";
						sendMessage(message);
					}
				
				
				
			}else if( block*5 <= event.getX() && event.getX() < block*6  ){
				
				
					//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[5] ][ flat[5] ],1 ,1, 0, 0, 1f );
					mVibe.vibrate(50);
		
					if(flat[5]==0){
						//int k = 51;
						String message ="51";
						sendMessage(message);
					}
					if(flat[5]==1){
						//int k = 52;
						String message ="52";
						sendMessage(message);
					}
					if(flat[5]==2){
						//int k = 53;
						String message ="53";
						sendMessage(message);
					}
					if(flat[5]==3){
						//int k = 54;
						String message ="54";
						sendMessage(message);
					}
					if(flat[5]==4){
						//int k = 55;
						String message ="55";
						sendMessage(message);
					}
					if(flat[5]==5){
						//int k = 56;
						String message ="56";
						sendMessage(message);
					}
					if(flat[5]==6){
						
						String message ="57";
						sendMessage(message);
					}
					if(flat[5]==7){
						
						String message ="58";
						sendMessage(message);
					}
					if(flat[5]==8){
						
						String message ="59";
						sendMessage(message);
					}
					if(flat[5]==9){
						
						String message ="510";
						sendMessage(message);
					}
					if(flat[5]==10){
						
						String message ="511";
						sendMessage(message);
					}
				
			}
														
			break;
        	
        	
        	
        	
        case MotionEvent.ACTION_POINTER_DOWN: {
          // TODO use data
        	final int pointerIndex2 = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT; //?
			final int pointerId2 = event.getPointerId(pointerIndex2);

			final float x = event.getX(pointerId2);
			final float y = event.getY(pointerId2);
			
					if(x < ((block))){
						   	//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
							guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f );
							mVibe.vibrate(50);
			
							
							if(flat[0]==0){
								//int k = 1;
								String message = "1";
								sendMessage(message);
							}
							if(flat[0]==1){
								//int k = 2;
								String message ="2";
								sendMessage(message);
							}
							if(flat[0]==2){
								//int k = 3;
								String message ="3";
								sendMessage(message);
							}
							if(flat[0]==3){
								//int k = 4;
								String message ="4";
								sendMessage(message);
							}
							if(flat[0]==4){
								//int k = 5;
								String message ="5";
								sendMessage(message);
							}
							if(flat[0]==5){
								//int k = 6;
								String message ="6";
								sendMessage(message);
							}
							if(flat[0]==6){
								
								String message ="7";
								sendMessage(message);
							}
							if(flat[0]==7){
								
								String message ="8";
								sendMessage(message);
							}
							if(flat[0]==8){
								
								String message ="9";
								sendMessage(message);
							}
							if(flat[0]==9){
								
								String message ="91";
								sendMessage(message);
							}
							if(flat[0]==10){
								
								String message ="92";
								sendMessage(message);
							}
															
							
							
							
					}else if( block <= x &&x < block*2  ){
						 mConversationArrayAdapter.add(": ㅋ2 ");

							//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
							guitar_sound.play( string[ str[1] ][ flat[1] ], 1 , 1, 0, 0, 1f );
							mVibe.vibrate(50);
				
					
							
							if(flat[1]==0){
								//int k = 11;
								String message ="11";
								sendMessage(message);
							}
							if(flat[1]==1){
								//int k = 12;
								String message ="12";
								sendMessage(message);
							}
							if(flat[1]==2){
								//int k = 13;
								String message ="13";
								sendMessage(message);
							}
							if(flat[1]==3){
								//int k = 14;
								String message ="14";
								sendMessage(message);
							}
							if(flat[1]==4){
								//int k = 15;
								String message ="15";
								sendMessage(message);
							}
							if(flat[1]==5){
								//int k = 16;
								String message ="16";
								sendMessage(message);
							}
							if(flat[1]==6){
								
								String message ="17";
								sendMessage(message);
							}
							if(flat[1]==7){
								
								String message ="18";
								sendMessage(message);
							}
							if(flat[1]==8){
								
								String message ="19";
								sendMessage(message);
							}
							if(flat[1]==9){
								
								String message ="110";
								sendMessage(message);
							}
							if(flat[1]==10){
								
								String message ="111";
								sendMessage(message);
							}
							
							
					}else if( block*2 <=x &&x < block*3  ){
						
						 mConversationArrayAdapter.add(": ㅋ3 ");

							
							//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
							guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );
							mVibe.vibrate(50);

							if(flat[2]==0){
								//int k = 21;
								String message ="21";
								sendMessage(message);
							}
							if(flat[2]==1){
								//int k = 22;
								String message ="22";
								sendMessage(message);
							}
							if(flat[2]==2){
								//int k = 23;
								String message ="23";
								sendMessage(message);
							}
							if(flat[2]==3){
								//int k = 24;
								String message ="24";
								sendMessage(message);
							}
							if(flat[2]==4){
								//int k = 25;
								String message ="25";
								sendMessage(message);
							}
							if(flat[2]==5){
								//int k = 26;
								String message ="26";
								sendMessage(message);
							}
							if(flat[2]==6){
								
								String message ="27";
								sendMessage(message);
							}
							if(flat[2]==7){
								
								String message ="28";
								sendMessage(message);
							}
							if(flat[2]==8){
								
								String message ="29";
								sendMessage(message);
							}
							if(flat[2]==9){
								
								String message ="210";
								sendMessage(message);
							}
							if(flat[2]==10){
								
								String message ="211";
								sendMessage(message);
							}
						
						
					}else if( block*3 <= x&& x < block*4  ){
						
						if(flat[3]==0){
							String message ="31";
							sendMessage(message);
						}
						if(flat[3]==1){
							String message ="32";
							sendMessage(message);
						}
						if(flat[3]==2){
							String message ="33";
							sendMessage(message);
						}
						if(flat[3]==3){
							String message ="34";
							sendMessage(message);
						}
						if(flat[3]==4){
							String message ="35";
							sendMessage(message);
						}
						if(flat[3]==5){
							String message ="36";
							sendMessage(message);
						}
						if(flat[3]==6){
							String message ="37";
							sendMessage(message);
						}
						if(flat[3]==7){				
							String message ="38";
							sendMessage(message);
						}
						if(flat[3]==8){
							String message ="39";
							sendMessage(message);
						}
						if(flat[3]==9){
							String message ="310";
							sendMessage(message);
						}
						if(flat[3]==10){
							String message ="311";
							sendMessage(message);
						}
					
					}else if( block*4 <= x && x < block*5  ){

						if(flat[4]==0){
							//int k = 41;
							String message ="41";
							sendMessage(message);
						}
						if(flat[4]==1){
							//int k = 42;
							String message ="42";
							sendMessage(message);
						}
						if(flat[4]==2){
							//int k = 43;
							String message ="43";
							sendMessage(message);
						}
						if(flat[4]==3){
							//int k = 44;
							String message ="44";
							sendMessage(message);
						}
						if(flat[4]==4){
							//int k = 45;
							String message ="45";
							sendMessage(message);
						}
						if(flat[4]==5){
							//int k = 46;
							String message ="46";
							sendMessage(message);
						}
						if(flat[4]==6){
							
							String message ="47";
							sendMessage(message);
						}
						if(flat[4]==7){
							
							String message ="48";
							sendMessage(message);
						}
						if(flat[4]==8){
							
							String message ="49";
							sendMessage(message);
						}
						if(flat[4]==9){
							
							String message ="410";
							sendMessage(message);
						}
						if(flat[4]==10){
							
							String message ="411";
							sendMessage(message);
						}
					
					
					}else if( block*5 <= x && x < block*6  ){

						if(flat[5]==0){
							//int k = 51;
							String message ="51";
							sendMessage(message);
						}
						if(flat[5]==1){
							//int k = 52;
							String message ="52";
							sendMessage(message);
						}
						if(flat[5]==2){
							//int k = 53;
							String message ="53";
							sendMessage(message);
						}
						if(flat[5]==3){
							//int k = 54;
							String message ="54";
							sendMessage(message);
						}
						if(flat[5]==4){
							//int k = 55;
							String message ="55";
							sendMessage(message);
						}
						if(flat[5]==5){
							//int k = 56;
							String message ="56";
							sendMessage(message);
						}
						if(flat[5]==6){
							
							String message ="57";
							sendMessage(message);
						}
						if(flat[5]==7){
							
							String message ="58";
							sendMessage(message);
						}
						if(flat[5]==8){
							
							String message ="59";
							sendMessage(message);
						}
						if(flat[5]==9){
							
							String message ="510";
							sendMessage(message);
						}
						if(flat[5]==10){
							
							String message ="511";
							sendMessage(message);
						}
					}
				break;	
        	
        	
        }
          
        
        case MotionEvent.ACTION_MOVE: { // a pointer was moved
          // TODO use data
        	
        	
			if(event.getX() < ((block))){
				if( flag1 == 0 ){
					//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);

					
					if(flat[0]==0){
						//int k = 1;
						String message = "1";
						sendMessage(message);
					}
					if(flat[0]==1){
						//int k = 2;
						String message ="2";
						sendMessage(message);
					}
					if(flat[0]==2){
						//int k = 3;
						String message ="3";
						sendMessage(message);
					}
					if(flat[0]==3){
						//int k = 4;
						String message ="4";
						sendMessage(message);
					}
					if(flat[0]==4){
						//int k = 5;
						String message ="5";
						sendMessage(message);
					}
					if(flat[0]==5){
						//int k = 6;
						String message ="6";
						sendMessage(message);
					}
					if(flat[0]==6){
						
						String message ="7";
						sendMessage(message);
					}
					if(flat[0]==7){
						
						String message ="8";
						sendMessage(message);
					}
					if(flat[0]==8){
						
						String message ="9";
						sendMessage(message);
					}
					if(flat[0]==9){
						
						String message ="91";
						sendMessage(message);
					}
					if(flat[0]==10){
						
						String message ="92";
						sendMessage(message);
					}
													
					
		
					
				
					flag1 = 1;
					flag2 = 0;
					flag3 = 0;
					flag4 = 0;
					flag5 = 0;
					flag6 = 0;
			
					
				}
																					
			}else if( block <= event.getX() && event.getX() < block*2  ){
				
				if( flag2 == 0 ){
					//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[1] ][ flat[1] ], 1 ,1, 0, 0, 1f );
					mVibe.vibrate(50);
					

					
					if(flat[1]==0){
						//int k = 11;
						String message ="11";
						sendMessage(message);
					}
					if(flat[1]==1){
						//int k = 12;
						String message ="12";
						sendMessage(message);
					}
					if(flat[1]==2){
						//int k = 13;
						String message ="13";
						sendMessage(message);
					}
					if(flat[1]==3){
						//int k = 14;
						String message ="14";
						sendMessage(message);
					}
					if(flat[1]==4){
						//int k = 15;
						String message ="15";
						sendMessage(message);
					}
					if(flat[1]==5){
						//int k = 16;
						String message ="16";
						sendMessage(message);
					}
					if(flat[1]==6){
						
						String message ="17";
						sendMessage(message);
					}
					if(flat[1]==7){
						
						String message ="18";
						sendMessage(message);
					}
					if(flat[1]==8){
						
						String message ="19";
						sendMessage(message);
					}
					if(flat[1]==9){
						
						String message ="110";
						sendMessage(message);
					}
					if(flat[1]==10){
						
						String message ="111";
						sendMessage(message);
					}
					
					flag2 = 1;
					flag1 = 0;
					flag3 = 0;
					flag4 = 0;
					flag5 = 0;
					flag6 = 0;

					
				}
																
				
			}else if( block*2 <= event.getX() && event.getX() < block*3  ){
				
				if( flag3 == 0 ){
					//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
					
					if(flat[2]==0){
						//int k = 21;
						String message ="21";
						sendMessage(message);
					}
					if(flat[2]==1){
						//int k = 22;
						String message ="22";
						sendMessage(message);
					}
					if(flat[2]==2){
						//int k = 23;
						String message ="23";
						sendMessage(message);
					}
					if(flat[2]==3){
						//int k = 24;
						String message ="24";
						sendMessage(message);
					}
					if(flat[2]==4){
						//int k = 25;
						String message ="25";
						sendMessage(message);
					}
					if(flat[2]==5){
						//int k = 26;
						String message ="26";
						sendMessage(message);
					}
					if(flat[2]==6){
						
						String message ="27";
						sendMessage(message);
					}
					if(flat[2]==7){
						
						String message ="28";
						sendMessage(message);
					}
					if(flat[2]==8){
						
						String message ="29";
						sendMessage(message);
					}
					if(flat[2]==9){
						
						String message ="210";
						sendMessage(message);
					}
					if(flat[2]==10){
						
						String message ="211";
						sendMessage(message);
					}
				
				

					
					flag3 = 1;
					flag2 = 0;
					flag1 = 0;
					flag4 = 0;
					flag5 = 0;
					flag6 = 0;
					

					
				}
				
			}else if( block*3 <= event.getX() && event.getX() < block*4  ){
				
				if( flag4 == 0 ){
					//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[3] ][ flat[3] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);

					if(flat[3]==0){
						String message ="31";
						sendMessage(message);
					}
					if(flat[3]==1){
						String message ="32";
						sendMessage(message);
					}
					if(flat[3]==2){
						String message ="33";
						sendMessage(message);
					}
					if(flat[3]==3){
						String message ="34";
						sendMessage(message);
					}
					if(flat[3]==4){
						String message ="35";
						sendMessage(message);
					}
					if(flat[3]==5){
						String message ="36";
						sendMessage(message);
					}
					if(flat[3]==6){
						String message ="37";
						sendMessage(message);
					}
					if(flat[3]==7){				
						String message ="38";
						sendMessage(message);
					}
					if(flat[3]==8){
						String message ="39";
						sendMessage(message);
					}
					if(flat[3]==9){
						String message ="310";
						sendMessage(message);
					}
					if(flat[3]==10){
						String message ="311";
						sendMessage(message);
					}
					
					
					flag4 = 1;
					flag2 = 0;
					flag3 = 0;
					flag1 = 0;
					flag5 = 0;
					flag6 = 0;								
					
				}
				
			}else if( block*4 <= event.getX() && event.getX() < block*5  ){
				
				if( flag5 == 0 ){
					//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[4] ][ flat[4] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
					

					if(flat[4]==0){
						//int k = 41;
						String message ="41";
						sendMessage(message);
					}
					if(flat[4]==1){
						//int k = 42;
						String message ="42";
						sendMessage(message);
					}
					if(flat[4]==2){
						//int k = 43;
						String message ="43";
						sendMessage(message);
					}
					if(flat[4]==3){
						//int k = 44;
						String message ="44";
						sendMessage(message);
					}
					if(flat[4]==4){
						//int k = 45;
						String message ="45";
						sendMessage(message);
					}
					if(flat[4]==5){
						//int k = 46;
						String message ="46";
						sendMessage(message);
					}
					if(flat[4]==6){
						
						String message ="47";
						sendMessage(message);
					}
					if(flat[4]==7){
						
						String message ="48";
						sendMessage(message);
					}
					if(flat[4]==8){
						
						String message ="49";
						sendMessage(message);
					}
					if(flat[4]==9){
						
						String message ="410";
						sendMessage(message);
					}
					if(flat[4]==10){
						
						String message ="411";
						sendMessage(message);
					}
				
			
					flag5 = 1;
					flag2 = 0;
					flag3 = 0;
					flag4 = 0;
					flag1 = 0;
					flag6 = 0;
					

				}
				
			}else if( block*5 <= event.getX() && event.getX() < block*6  ){
				
				if( flag6 == 0 ){
					//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
					guitar_sound.play( string[ str[5] ][ flat[5] ], 1 , 1, 0, 0, 1f );
					mVibe.vibrate(50);
					if(flat[5]==0){
						//int k = 51;
						String message ="51";
						sendMessage(message);
					}
					if(flat[5]==1){
						//int k = 52;
						String message ="52";
						sendMessage(message);
					}
					if(flat[5]==2){
						//int k = 53;
						String message ="53";
						sendMessage(message);
					}
					if(flat[5]==3){
						//int k = 54;
						String message ="54";
						sendMessage(message);
					}
					if(flat[5]==4){
						//int k = 55;
						String message ="55";
						sendMessage(message);
					}
					if(flat[5]==5){
						//int k = 56;
						String message ="56";
						sendMessage(message);
					}
					if(flat[5]==6){
						
						String message ="57";
						sendMessage(message);
					}
					if(flat[5]==7){
						
						String message ="58";
						sendMessage(message);
					}
					if(flat[5]==8){
						
						String message ="59";
						sendMessage(message);
					}
					if(flat[5]==9){
						
						String message ="510";
						sendMessage(message);
					}
					if(flat[5]==10){
						
						String message ="511";
						sendMessage(message);
					}
					flag6 = 1;
					flag2 = 0;
					flag3 = 0;
					flag4 = 0;
					flag5 = 0;
					flag1 = 0;
															
				}
				
			}
			
	

        	
        	
        	
          break;
        }
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_POINTER_UP:
        case MotionEvent.ACTION_CANCEL: {
          // TODO use data
          break;
        }
        }
        //invalidate();

        return true;
    } 
    

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		boolean running = false;
		
	}
	
	@Override
    public void onStart() {
        super.onStart();
        if(D) Log.e(TAG, "++ ON START ++");

        // If BT is not on, request that it be enabled.
        // setupChat() will then be called during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        // Otherwise, setup the chat session
        } else {
            if (mChatService == null) setupChat();
        }
        
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        if(D) Log.e(TAG, "+ ON RESUME +");

        // Performing this check in onResume() covers the case in which BT was
        // not enabled during onStart(), so we were paused to enable it...
        // onResume() will be called when ACTION_REQUEST_ENABLE activity returns.
        if (mChatService != null) {
            // Only if the state is STATE_NONE, do we know that we haven't started already
            if (mChatService.getState() == BluetoothChatService.STATE_NONE) {
              // Start the Bluetooth chat services
              mChatService.start();
            }
        }
    }

    private void setupChat() {
        Log.d(TAG, "setupChat()");
        
  
        // Initialize the BluetoothChatService to perform bluetooth connections
        mChatService = new BluetoothChatService(this, mHandler);

        // Initialize the buffer for outgoing messages
        mOutStringBuffer = new StringBuffer("");
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        if(D) Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if(D) Log.e(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the Bluetooth chat services
        if (mChatService != null) mChatService.stop();
        if(D) Log.e(TAG, "--- ON DESTROY ---");
    }
    private void ensureDiscoverable() {
    	if(D) Log.d(TAG, "ensure discoverable");	
    	if (mBluetoothAdapter.getScanMode() !=
            BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
        }
    }

   

    // The action listener for the EditText widget, to listen for the return key
    private TextView.OnEditorActionListener mWriteListener =
        new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            // If the action is a key-up event on the return key, send the message
            if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
                String message = view.getText().toString();
//                sendMessage(message);
            }
            if(D) Log.i(TAG, "END onEditorAction");
            return true;
        }
    };

    private final void setStatus(int resId) {
        //final ActionBar actionBar = getActionBar();
        //actionBar.setSubtitle(resId);
    }

    private final void setStatus(CharSequence subTitle) {
        //final ActionBar actionBar = getActionBar();
        //actionBar.setSubtitle(subTitle);
    }

    // The Handler that gets information back from the BluetoothChatService
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
           
			switch (msg.what) {
            case MESSAGE_STATE_CHANGE:
                if(D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                switch (msg.arg1) {
                case BluetoothChatService.STATE_ALL_CONNECTED:
                	//blueToothModule a = new blueToothModule();
                	//a.start();
                case BluetoothChatService.STATE_CONNECTED:
                	//blueToothModule b = new blueToothModule();
                	//b.start();
                    break;
                case BluetoothChatService.STATE_CONNECTED_TO_SERVER:
                	//blueToothModule c = new blueToothModule();
                	//c.start();
                    break;                    
                case BluetoothChatService.STATE_CONNECTING:
                    
                    break;
                case BluetoothChatService.STATE_LISTEN:
                case BluetoothChatService.STATE_NONE:
                    break;
                }
                break;
            case MESSAGE_READ:
                byte[] readBuf = (byte[]) msg.obj;
                // construct a string from the valid bytes in the buffer
               
                String readMessage = new String(readBuf, 0, msg.arg1);
                long ch = Long.parseLong(readMessage);
               
       
                chord = new Chord();
                chord.chord = ch;
                
                
                if(ch == 0){ chordname = "null"; }
                if ((ch>>32) == 100353){ chordname = "C"; }
                if ((ch>>32) == 100449){ chordname = "C7"; }
                if ((ch>>32) == 100352){ chordname = "CM7"; }
                if ((ch>>32) == 3249316){ chordname = "Cm"; }
                if ((ch>>32) == 3249252){ chordname = "Cm7"; }
                if ((ch>>16) == 4395008){ chordname = "D"; }
                if ((ch>>16) == 4392960){ chordname = "Dm"; }
                if ((ch>>16) == 4263936){ chordname = "D7"; }
                if ((ch>>16) == 4329472){ chordname = "DM7"; }
                if ((ch>>16) == 4261888){ chordname = "Dm7"; }
                if ((ch>>32) == 67616){ chordname = "E"; }
                if ((ch>>32) == 67584){ chordname = "Em"; }
                if ((ch>>32) == 65568){ chordname = "E7"; }
                if ((ch>>32) == 66592){ chordname = "EM7"; }
                if ((ch>>32) == 65536){ chordname = "Em7"; }
                if ((ch>>32) == 1150017){ chordname = "F"; }
                if ((ch>>32) == 1149985){ chordname = "Fm"; }
                if ((ch>>32) == 1147969){ chordname = "F7"; }
                if ((ch>>32) == 3137){ chordname = "FM7"; }
                if ((ch>>32) == 1147937){ chordname = "Fm7"; }
                if ((ch>>27) == 102760451){ chordname = "G"; }
                if ((ch>>32) == 3314787){ chordname = "Gm"; }
                if ((ch>>27) == 102760448){ chordname = "G7"; }
                if ((ch>>27) == 102760450){ chordname = "GM7"; }
                if ((ch>>32) == 3312739){ chordname = "Gm7"; }
                if ((ch>>32) == 2114){ chordname = "A"; }
                if ((ch>>32) == 2113){ chordname = "Am"; }
                if ((ch>>32) == 2050){ chordname = "A7"; }
                if ((ch>>32) == 2082){ chordname = "AM7"; }
                if ((ch>>32) == 2049){ chordname = "Am7"; }
                if ((ch>>32) == 1084515){ chordname = "B"; }
                if ((ch>>32) == 1084514){ chordname = "Bm"; }
                if ((ch>>32) == 66624){ chordname = "B7"; }
                if ((ch>>32) == 1084483){ chordname = "BM7"; }
                if ((ch>>32) == 1084450){ chordname = "Bm7"; }
                
                //if (ch == 10000){ chordname = "C chord"; }
                
                mConversationArrayAdapter.add("Chord:  " +chordname);
                
                             
                //431012853055488
   
              
                
                
                
                
                break;
                
           
            case MESSAGE_DEVICE_NAME:
                // save the connected device's name
            	if (mChatService.getState() == BluetoothChatService.STATE_CONNECTED) {
	   	           	 if (mChatService.connectedDevices == 1) {
	 	           		mConnectedDeviceName1 = msg.getData().getString(DEVICE_NAME);
	 	                   Toast.makeText(getApplicationContext(), "Connected to "
	 	                                  + mConnectedDeviceName1, Toast.LENGTH_SHORT).show();
	 	           	} else if ( mChatService.connectedDevices == 2) {
	 	           		mConnectedDeviceName2 = msg.getData().getString(DEVICE_NAME);
	 	                Toast.makeText(getApplicationContext(), "Connected to "
	 	                               + mConnectedDeviceName2, Toast.LENGTH_SHORT).show();
	 	           	} else if ( mChatService.connectedDevices == 3) {
	 	           		mConnectedDeviceName3 = msg.getData().getString(DEVICE_NAME);
	 	                Toast.makeText(getApplicationContext(), "Connected to "
	 	                               + mConnectedDeviceName3, Toast.LENGTH_SHORT).show();
	 	           	}
            	}
            	
            	if (mChatService.getState() == BluetoothChatService.STATE_CONNECTED_TO_SERVER) {
	           		mConnectedServerName = msg.getData().getString(DEVICE_NAME);
	                Toast.makeText(getApplicationContext(), "Connected to server "
	                               + mConnectedServerName, Toast.LENGTH_SHORT).show();
	           	}
                break;
            case MESSAGE_TOAST:
                Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
                               Toast.LENGTH_SHORT).show();
                break;
            }
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(D) Log.d(TAG, "onActivityResult " + resultCode);
        switch (requestCode) {
        case REQUEST_CONNECT_DEVICE_SECURE:
            // When DeviceListActivity returns with a device to connect
            if (resultCode == Activity.RESULT_OK) {
                connectDevice(data);
            }
            break;
        case REQUEST_ENABLE_BT:
            // When the request to enable Bluetooth returns
            if (resultCode == Activity.RESULT_OK) {
                // Bluetooth is now enabled, so set up a chat session
                setupChat();
            } else {
                // User did not enable Bluetooth or an error occurred
                Log.d(TAG, "BT not enabled");
                Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                finish();
            }
        /*case REQUEST_ACOUSTIC:
        	if (resultCode == Activity.RESULT_OK){
        		set_sound1();
        	}
        	break;
        case REQUEST_ELECTRICAL:
        	if (resultCode == Activity.RESULT_OK){
        		set_sound2();
        	}
        	break;*/
        }
    }

    private void connectDevice(Intent data) {
        // Get the device MAC address
        String address = data.getExtras()
            .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
        // Get the BluetoothDevice object
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        // Attempt to connect to the device
        mChatService.connect(device);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    
    //Option connect
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent serverIntent = null;
        switch (item.getItemId()) {
        case R.id.secure_connect_scan:
            // Launch the DeviceListActivity to see devices and do scan
            serverIntent = new Intent(this, DeviceListActivity.class);
            startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);
            return true;
        case R.id.discoverable:
            // Ensure this device is discoverable by others
            ensureDiscoverable();
            return true;
        case R.id.instrument_select:
        	//serverIntent = new Intent(this,ACOUSTIC.class);
        	//startActivityForResult(serverIntent, REQUEST_ACOUSTIC);
        	
        	AlertDialog dialog = createDialogBox();
        	
        	dialog.show();
        	
        	return true;
        
        }
        return false;
    }

    private AlertDialog createDialogBox(){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setTitle("Guitar chocie");
    	
    	builder.setPositiveButton("ACUOSTIC_GUITAR", new DialogInterface.OnClickListener(){
    		@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
    			long acou = 100;
				String message =String.valueOf(acou);
										
				sendMessage(message);	
				set_sound1();
			}
    		
    	});
    	
    	builder.setNeutralButton("ELETRICAL_GUITAR", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				long elec = 200;
				String message =String.valueOf(elec);
				sendMessage(message);	
				set_sound2();
			}
		});
    	
    	AlertDialog dialog = builder.create();
    	return dialog;
    	
    }
    
    
    
    private void sendMessage(String message) {

    	
    	// Check that we're actually connected before trying anything
    	if (mChatService.serverDevice && mChatService.getState() != BluetoothChatService.STATE_ALL_CONNECTED) {
            Toast.makeText(this, R.string.waiting_others, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!mChatService.serverDevice && mChatService.getState() != BluetoothChatService.STATE_CONNECTED_TO_SERVER) {
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT).show();
            return;
        }

        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = message.getBytes();
            mChatService.write(send);

            // Reset out string buffer to zero and clear the edit text field
            mOutStringBuffer.setLength(0);
//            mOutEditText.setText(mOutStringBuffer);
        }
    }

    
    
    
    
    
    public void set_sound1() {
    	
    	string[0][0] = guitar_sound.load( getBaseContext(), R.raw.a1line, 1 );
    	string[0][1] = guitar_sound.load( getBaseContext(), R.raw.a1f1line, 1 );
    	string[0][2] = guitar_sound.load( getBaseContext(), R.raw.a2f1line, 1 );
    	string[0][3] = guitar_sound.load( getBaseContext(), R.raw.a3f1line, 1 );
    	string[0][4] = guitar_sound.load( getBaseContext(), R.raw.a4f1line, 1 );
    	string[0][5] = guitar_sound.load( getBaseContext(), R.raw.a5f1line, 1 );
    	string[0][6] = guitar_sound.load( getBaseContext(), R.raw.a6f1line, 1 );
    	string[0][7] = guitar_sound.load( getBaseContext(), R.raw.a7f1line, 1 );
    	string[0][8] = guitar_sound.load( getBaseContext(), R.raw.a8f1line, 1 );
    	string[0][9] = guitar_sound.load( getBaseContext(), R.raw.a9f1line, 1 );
    	string[0][10] = guitar_sound.load( getBaseContext(), R.raw.a10f1line, 1 );
    	
        string[1][0] = guitar_sound.load( getBaseContext(), R.raw.a2line, 1 );
        string[1][1] = guitar_sound.load( getBaseContext(), R.raw.a1f2line, 1 );
        string[1][2] = guitar_sound.load( getBaseContext(), R.raw.a2f2line, 1 );
        string[1][3] = guitar_sound.load( getBaseContext(), R.raw.a3f2line, 1 );
        string[1][4] = guitar_sound.load( getBaseContext(), R.raw.a4f2line, 1 );
        string[1][5] = guitar_sound.load( getBaseContext(), R.raw.a5f2line, 1 );
    	string[1][6] = guitar_sound.load( getBaseContext(), R.raw.a6f2line, 1 );
    	string[1][7] = guitar_sound.load( getBaseContext(), R.raw.a7f2line, 1 );
    	string[1][8] = guitar_sound.load( getBaseContext(), R.raw.a8f2line, 1 );
    	string[1][9] = guitar_sound.load( getBaseContext(), R.raw.a9f2line, 1 );
    	string[1][10] = guitar_sound.load( getBaseContext(), R.raw.a10f2line, 1 );
        
        string[2][0] = guitar_sound.load( getBaseContext(), R.raw.a3line, 1 );
        string[2][1] = guitar_sound.load( getBaseContext(), R.raw.a1f3line, 1 );
        string[2][2] = guitar_sound.load( getBaseContext(), R.raw.a2f3line, 1 );
        string[2][3] = guitar_sound.load( getBaseContext(), R.raw.a3f3line, 1 );
        string[2][4] = guitar_sound.load( getBaseContext(), R.raw.a4f3line, 1 );
        string[2][5] = guitar_sound.load( getBaseContext(), R.raw.a5f3line, 1 );
    	string[2][6] = guitar_sound.load( getBaseContext(), R.raw.a6f3line, 1 );
    	string[2][7] = guitar_sound.load( getBaseContext(), R.raw.a7f3line, 1 );
    	string[2][8] = guitar_sound.load( getBaseContext(), R.raw.a8f3line, 1 );
    	string[2][9] = guitar_sound.load( getBaseContext(), R.raw.a9f3line, 1 );
    	string[2][10] = guitar_sound.load( getBaseContext(), R.raw.a10f3line, 1 );
        
        string[3][0] = guitar_sound.load( getBaseContext(), R.raw.a4line, 1 );
        string[3][1] = guitar_sound.load( getBaseContext(), R.raw.a1f4line, 1 );
        string[3][2] = guitar_sound.load( getBaseContext(), R.raw.a2f4line, 1 );
        string[3][3] = guitar_sound.load( getBaseContext(), R.raw.a3f4line, 1 );
        string[3][4] = guitar_sound.load( getBaseContext(), R.raw.a4f4line, 1 );
        string[3][5] = guitar_sound.load( getBaseContext(), R.raw.a5f4line, 1 );
    	string[3][6] = guitar_sound.load( getBaseContext(), R.raw.a6f4line, 1 );
    	string[3][7] = guitar_sound.load( getBaseContext(), R.raw.a7f4line, 1 );
    	string[3][8] = guitar_sound.load( getBaseContext(), R.raw.a8f4line, 1 );
    	string[3][9] = guitar_sound.load( getBaseContext(), R.raw.a9f4line, 1 );
    	string[3][10] = guitar_sound.load( getBaseContext(), R.raw.a10f4line, 1 );
        
        string[4][0] = guitar_sound.load( getBaseContext(), R.raw.a5line, 1 );
        string[4][1] = guitar_sound.load( getBaseContext(), R.raw.a1f5line, 1 );
        string[4][2] = guitar_sound.load( getBaseContext(), R.raw.a2f5line, 1 );
        string[4][3] = guitar_sound.load( getBaseContext(), R.raw.a3f5line, 1 );
        string[4][4] = guitar_sound.load( getBaseContext(), R.raw.a4f5line, 1 );
        string[4][5] = guitar_sound.load( getBaseContext(), R.raw.a5f5line, 1 );
    	string[4][6] = guitar_sound.load( getBaseContext(), R.raw.a6f5line, 1 );
    	string[4][7] = guitar_sound.load( getBaseContext(), R.raw.a7f5line, 1 );
    	string[4][8] = guitar_sound.load( getBaseContext(), R.raw.a8f5line, 1 );
    	string[4][9] = guitar_sound.load( getBaseContext(), R.raw.a9f5line, 1 );
    	string[4][10] = guitar_sound.load( getBaseContext(), R.raw.a10f5line, 1 );
        
        string[5][0] = guitar_sound.load( getBaseContext(), R.raw.a6line, 1 );
        string[5][1] = guitar_sound.load( getBaseContext(), R.raw.a1f6line, 1 );
        string[5][2] = guitar_sound.load( getBaseContext(), R.raw.a2f6line, 1 );
        string[5][3] = guitar_sound.load( getBaseContext(), R.raw.a3f6line, 1 );
        string[5][4] = guitar_sound.load( getBaseContext(), R.raw.a4f6line, 1 );
        string[5][5] = guitar_sound.load( getBaseContext(), R.raw.a5f6line, 1 );
    	string[5][6] = guitar_sound.load( getBaseContext(), R.raw.a6f6line, 1 );
    	string[5][7] = guitar_sound.load( getBaseContext(), R.raw.a7f6line, 1 );
    	string[5][8] = guitar_sound.load( getBaseContext(), R.raw.a8f6line, 1 );
    	string[5][9] = guitar_sound.load( getBaseContext(), R.raw.a9f6line, 1 );
    	string[5][10] = guitar_sound.load( getBaseContext(), R.raw.a10f6line, 1 );
    }
    
    public void set_sound2() {
		
    	string[0][0] = guitar_sound.load( getBaseContext(), R.raw.e00, 1 );
		string[0][1] = guitar_sound.load( getBaseContext(), R.raw.e01, 1 );
		string[0][2] = guitar_sound.load( getBaseContext(), R.raw.e02, 1 );
		string[0][3] = guitar_sound.load( getBaseContext(), R.raw.e03, 1 );
		string[0][4] = guitar_sound.load( getBaseContext(), R.raw.e04, 1 );
		string[0][5] = guitar_sound.load( getBaseContext(), R.raw.e05, 1 );
		string[0][6] = guitar_sound.load( getBaseContext(), R.raw.e06, 1 );
		string[0][7] = guitar_sound.load( getBaseContext(), R.raw.e07, 1 );
		string[0][8] = guitar_sound.load( getBaseContext(), R.raw.e08, 1 );
		string[0][9] = guitar_sound.load( getBaseContext(), R.raw.e09, 1 );
		string[0][10] = guitar_sound.load( getBaseContext(), R.raw.e010, 1 );


		
	    string[1][0] = guitar_sound.load( getBaseContext(), R.raw.e10, 1 );
	    string[1][1] = guitar_sound.load( getBaseContext(), R.raw.e11, 1 );
	    string[1][2] = guitar_sound.load( getBaseContext(), R.raw.e12, 1 );
	    string[1][3] = guitar_sound.load( getBaseContext(), R.raw.e13, 1 );
	    string[1][4] = guitar_sound.load( getBaseContext(), R.raw.e14, 1 );
	    string[1][5] = guitar_sound.load( getBaseContext(), R.raw.e15, 1 );
		string[1][6] = guitar_sound.load( getBaseContext(), R.raw.e16, 1 );
		string[1][7] = guitar_sound.load( getBaseContext(), R.raw.e17, 1 );
		string[1][8] = guitar_sound.load( getBaseContext(), R.raw.e18, 1 );
		string[1][9] = guitar_sound.load( getBaseContext(), R.raw.e19, 1 );
		string[1][10] = guitar_sound.load( getBaseContext(), R.raw.e110, 1 );
	    
	    string[2][0] = guitar_sound.load( getBaseContext(), R.raw.e20, 1 );
	    string[2][1] = guitar_sound.load( getBaseContext(), R.raw.e21, 1 );
	    string[2][2] = guitar_sound.load( getBaseContext(), R.raw.e22, 1 );
	    string[2][3] = guitar_sound.load( getBaseContext(), R.raw.e23, 1 );
	    string[2][4] = guitar_sound.load( getBaseContext(), R.raw.e24, 1 );
	    string[2][5] = guitar_sound.load( getBaseContext(), R.raw.e25, 1 );
		string[2][6] = guitar_sound.load( getBaseContext(), R.raw.e26, 1 );
		string[2][7] = guitar_sound.load( getBaseContext(), R.raw.e27, 1 );
		string[2][8] = guitar_sound.load( getBaseContext(), R.raw.e28, 1 );
		string[2][9] = guitar_sound.load( getBaseContext(), R.raw.e29, 1 );
		string[2][10] = guitar_sound.load( getBaseContext(), R.raw.e210, 1 );
	    
	    string[3][0] = guitar_sound.load( getBaseContext(), R.raw.e30, 1 );
	    string[3][1] = guitar_sound.load( getBaseContext(), R.raw.e31, 1 );
	    string[3][2] = guitar_sound.load( getBaseContext(), R.raw.e32, 1 );
	    string[3][3] = guitar_sound.load( getBaseContext(), R.raw.e33, 1 );
	    string[3][4] = guitar_sound.load( getBaseContext(), R.raw.e34, 1 );
	    string[3][5] = guitar_sound.load( getBaseContext(), R.raw.e35, 1 );
		string[3][6] = guitar_sound.load( getBaseContext(), R.raw.e36, 1 );
		string[3][7] = guitar_sound.load( getBaseContext(), R.raw.e37, 1 );
		string[3][8] = guitar_sound.load( getBaseContext(), R.raw.e38, 1 );
		string[3][9] = guitar_sound.load( getBaseContext(), R.raw.e39, 1 );
		string[3][10] = guitar_sound.load( getBaseContext(), R.raw.e310, 1 );
	    
	    string[4][0] = guitar_sound.load( getBaseContext(), R.raw.e40, 1 );
	    string[4][1] = guitar_sound.load( getBaseContext(), R.raw.e41, 1 );
	    string[4][2] = guitar_sound.load( getBaseContext(), R.raw.e42, 1 );
	    string[4][3] = guitar_sound.load( getBaseContext(), R.raw.e43, 1 );
	    string[4][4] = guitar_sound.load( getBaseContext(), R.raw.e44, 1 );
	    string[4][5] = guitar_sound.load( getBaseContext(), R.raw.e45, 1 );
		string[4][6] = guitar_sound.load( getBaseContext(), R.raw.e46, 1 );
		string[4][7] = guitar_sound.load( getBaseContext(), R.raw.e47, 1 );
		string[4][8] = guitar_sound.load( getBaseContext(), R.raw.e48, 1 );
		string[4][9] = guitar_sound.load( getBaseContext(), R.raw.e49, 1 );
		string[4][10] = guitar_sound.load( getBaseContext(), R.raw.e410, 1 );
	    
	    string[5][0] = guitar_sound.load( getBaseContext(), R.raw.e50, 1 );
	    string[5][1] = guitar_sound.load( getBaseContext(), R.raw.e51, 1 );
	    string[5][2] = guitar_sound.load( getBaseContext(), R.raw.e52, 1 );
	    string[5][3] = guitar_sound.load( getBaseContext(), R.raw.e53, 1 );
	    string[5][4] = guitar_sound.load( getBaseContext(), R.raw.e54, 1 );
	    string[5][5] = guitar_sound.load( getBaseContext(), R.raw.e55, 1 );
		string[5][6] = guitar_sound.load( getBaseContext(), R.raw.e56, 1 );
		string[5][7] = guitar_sound.load( getBaseContext(), R.raw.e57, 1 );
		string[5][8] = guitar_sound.load( getBaseContext(), R.raw.e58, 1 );
		string[5][9] = guitar_sound.load( getBaseContext(), R.raw.e59, 1 );
		string[5][10] = guitar_sound.load( getBaseContext(), R.raw.e510, 1 );
	}
			
}
