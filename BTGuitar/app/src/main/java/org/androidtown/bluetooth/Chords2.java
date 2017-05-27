package org.androidtown.bluetooth;

import org.androidtown.bluetooth.Stroke1.blueToothModule;
import org.miraddi.chord.Chord;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
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
import android.widget.*;

public class Chords2 extends Activity {

	
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
	    private String mConnectedServerName = null;
	    private String mConnectedDeviceName1 = null;
	    private String mConnectedDeviceName2 = null;
	    private String mConnectedDeviceName3 = null;
	    // Intent request codes
	    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
	    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
	    private static final int REQUEST_ENABLE_BT = 3;
	    
	 // Name of the connected device

	    // Array adapter for the conversation thread
	    private ArrayAdapter<String> mConversationArrayAdapter;
	    // String buffer for outgoing messages
	    private StringBuffer mOutStringBuffer;
	    // Local Bluetooth adapter
	    public BluetoothAdapter mBluetoothAdapter = null;
	    // Member object for the chat services
	    private BluetoothChatService mChatService = null;
	    private int count=0;
	    public String chordname;
//	    --------------------------Bluetooth-----------------------------
	    
		Chord chord;
		private SoundPool guitar_sound;

		int [][] string = new int[10][11];
		private int[] flat = new int[11];
		private int[] str= new int [11];
		public long flag1;
		public long acoustic;
		public long electrical;
		private TextView mTitle;
		private ListView mConversationView;
		private EditText mOutEditText;
		private Button mSendButton;
		
		
		
		class blueToothModule extends Thread
		{
			
			public void run(){
				while(true)
				{
					String str = 	String.valueOf(chord.getChord()[0]) +
									String.valueOf(chord.getChord()[1]) +
									String.valueOf(chord.getChord()[2]) +
									String.valueOf(chord.getChord()[3]) +
									String.valueOf(chord.getChord()[4]) +
									String.valueOf(chord.getChord()[5]);
					Log.d("string", str );
								
				while(true){
					
					if(chord.getChord()[0] ==0){
						if(chord.getChord()[1] ==0){
							if(chord.getChord()[2] ==0){
								if(chord.getChord()[3] ==0){
									if(chord.getChord()[4] ==0){
										if(chord.getChord()[5] ==0){
											if(count ==1 ){
												break;
											}									
												sendMessage(chord);
												count++;
												break;
										}
									}
								}
							}
						}
					}
				}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}	
				//------------------------------ 개방음 ----------------------------------------------------
					while(true){					
						while(count==0){
						if(chord.getChord()[1]==0){
							sendMessage(chord);
									count++;
									try {
										Thread.sleep(200);
									} catch (InterruptedException e) {
									
										e.printStackTrace();
									}
								
							}			
						}
				//------------------------------ 개방음 ----------------------------------------------------
						
	//-----------------------------------------------------1 번 째 줄 -----------------------------------------------------------------------//					
						if(chord.getChord()[0]==1){//1번째 줄 1플랫						    
									sendMessage(chord);
									try {
										Thread.sleep(200);
									} catch (InterruptedException e) {
									
										e.printStackTrace();
									}
									if(chord.getChord()[0]!=1){
										count=0;
									}
						}
						if(chord.getChord()[0]==2){//1번째 줄 2플랫							
							sendMessage(chord);						
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							}
							if(chord.getChord()[0]!=2){
								count=0;
							}						
						}
						if(chord.getChord()[0]==3){//1번째 줄 3플랫							
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=3){
								count=0;
							}						
						}
						if(chord.getChord()[0]==4){//1번째 줄 4플랫						
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=4){
								count=0;
							}						
						}
						if(chord.getChord()[0]==5){//1번째 줄 5플랫				
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=5){
								count=0;
							}						
						}
						if(chord.getChord()[0]==6){//1번째 줄 6플랫																
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=6){
								count=0;
							}
						}	
						if(chord.getChord()[0]==7){//1번째 줄 7플랫																
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=7){
								count=0;
							}
						}	
						if(chord.getChord()[0]==8){//1번째 줄 8플랫														
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=8){
								count=0;
							}
						}	
						if(chord.getChord()[0]==9){///1번째 줄 9플랫														
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=9){
								count=0;
							}
						}	
						if(chord.getChord()[0]==10){//1번째 줄 10플랫														
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							} 
							if(chord.getChord()[0]!=10){
								count=0;
							}
						}	
	//-----------------------------------------------2 번 째 줄--------------------------------------------------------------------------------------------------//					
						
					if(chord.getChord()[1]==1){//2번째 줄 1플랫				    
								sendMessage(chord);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
								
									e.printStackTrace();
								}
								if(chord.getChord()[1]!=1){
									count=0;
								}
					}
					if(chord.getChord()[1]==2){//2번째 줄 2플랫				
						sendMessage(chord);						
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						if(chord.getChord()[1]!=2){
							count=0;
						}				
					}
					if(chord.getChord()[1]==3){//2번째 줄 3플랫						
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=3){
							count=0;
						}					
					}
					if(chord.getChord()[1]==4){//2번째 줄 4플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=4){
							count=0;
						}						
					}
					if(chord.getChord()[1]==5){//2번째 줄 5플랫						
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=5){
							count=0;
						}						
					}
					if(chord.getChord()[1]==6){//2번째 줄 6플랫
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=6){
							count=0;
						}
					}
					if(chord.getChord()[1]==7){//2번째 줄 7플랫
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=7){
							count=0;
						}
					}
					if(chord.getChord()[1]==8){//2번째 줄 8플랫
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=8){
							count=0;
						}
					}
					if(chord.getChord()[1]==9){//2번째 줄 9플랫
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=9){
							count=0;
						}
					}
					if(chord.getChord()[1]==10){//2번째 줄 10플랫
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[1]!=10){
							count=0;
						}
					}
	//-------------------------------------------------------------------------------------------------------------------------------------------------//
					//-----------------------------------------------------3 번 째 줄 -----------------------------------------------------------------------//					
					if(chord.getChord()[2]==1){//3번째 줄 1플랫			    
								sendMessage(chord);
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
								
									e.printStackTrace();
								}
								if(chord.getChord()[2]!=1){
									count=0;
								}
					}
					if(chord.getChord()[2]==2){//3번째 줄 2플랫					
						sendMessage(chord);					
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						if(chord.getChord()[2]!=2){
							count=0;
						}					
					}
					if(chord.getChord()[2]==3){//3번째 줄 3플랫						
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=3){
							count=0;
						}										
					}
					if(chord.getChord()[2]==4){//3번째 줄 4플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=4){
							count=0;
						}
						
					}
					if(chord.getChord()[2]==5){//3번째 줄 5플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=5){
							count=0;
						}					
					}
					if(chord.getChord()[2]==6){//3번째 줄 6플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=6){
							count=0;
						}
					}	
					if(chord.getChord()[2]==7){//3번째 줄 7플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=7){
							count=0;
						}
					}
					if(chord.getChord()[2]==8){//3번째 줄 8플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=8){
							count=0;
						}
					}
					if(chord.getChord()[2]==9){//3번째 줄 9플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=9){
							count=0;
						}
					}
					if(chord.getChord()[2]==10){//3번째 줄 10플랫					
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						} 
						if(chord.getChord()[2]!=10){
							count=0;
						}
					}
	//-----------------------------------------------4 번 째 줄--------------------------------------------------------------------------------------------------//					
					
				if(chord.getChord()[3]==1){//4번째 줄 1플랫		    
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							}
							if(chord.getChord()[3]!=1){
								count=0;
							}
				}
				if(chord.getChord()[3]==2){//4번째 줄 2플랫			
					sendMessage(chord);				
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					if(chord.getChord()[3]!=2){
						count=0;
					}			
				}
				if(chord.getChord()[3]==3){//4번째 줄 3플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=3){
						count=0;
					}				
				}
				if(chord.getChord()[3]==4){//4번째 줄 4플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=4){
						count=0;
					}				
				}
				if(chord.getChord()[3]==5){//4번째 줄 5플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=5){
						count=0;
					}				
				}
				if(chord.getChord()[3]==6){//4번째 줄 6플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=6){
						count=0;
					}
				}	
				if(chord.getChord()[3]==7){//4번째 줄 7플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=7){
						count=0;
					}
				}
				if(chord.getChord()[3]==8){//4번째 줄 8플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=8){
						count=0;
					}
				}
				if(chord.getChord()[3]==9){//4번째 줄 9플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=9){
						count=0;
					}
				}
				if(chord.getChord()[3]==10){//4번째 줄 10플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[3]!=10){
						count=0;
					}
				}
	//-------------------------------------------------------------------------------------------------------------------------------------------------//				
				//-----------------------------------------------------5 번 째 줄 -----------------------------------------------------------------------//					
				if(chord.getChord()[4]==1){//5번째 줄 1플랫			    
							sendMessage(chord);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							}
							if(chord.getChord()[4]!=1){
								count=0;
							}
				}
				if(chord.getChord()[4]==2){//5번째 줄 2플랫				
					sendMessage(chord);					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					if(chord.getChord()[4]!=2){
						count=0;
					}				
				}
				if(chord.getChord()[4]==3){//5번째 줄 3플랫				
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=3){
						count=0;
					}				
				}
				if(chord.getChord()[4]==4){//5번째 줄 4플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=4){
						count=0;
					}					
				}
				if(chord.getChord()[4]==5){//5번째 줄 5플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=5){
						count=0;
					}					
				}
				if(chord.getChord()[4]==6){//5번째 줄 6플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=6){
						count=0;
					}
				}
				if(chord.getChord()[4]==7){//5번째 줄 7플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=7){
						count=0;
					}
				}
				if(chord.getChord()[4]==8){//5번째 줄 8플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=8){
						count=0;
					}
				}
				if(chord.getChord()[4]==9){//5번째 줄 9플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=9){
						count=0;
					}
				}
				if(chord.getChord()[4]==10){//5번째 줄 10플랫					
					sendMessage(chord);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
					if(chord.getChord()[4]!=10){
						count=0;
					}
				}
	//-----------------------------------------------6 번 째 줄--------------------------------------------------------------------------------------------------//					
				
			if(chord.getChord()[5]==1){//6번째 줄 1플랫		    
						sendMessage(chord);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						if(chord.getChord()[5]!=1){
							count=0;
						}
			}
			if(chord.getChord()[5]==2){///6번째 줄 2플랫			
				sendMessage(chord);				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				if(chord.getChord()[5]!=2){
					count=0;
				}		
			}
			if(chord.getChord()[5]==3){//6번째 줄 3플랫				
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=3){
					count=0;
				}
			}
			if(chord.getChord()[5]==4){//6번째 줄 4플랫			
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=4){
					count=0;
				}			
			}
			if(chord.getChord()[5]==5){//6번째 줄 5플랫			
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=5){
					count=0;
				}			
			}
			if(chord.getChord()[5]==6){//6번째 줄 6플랫
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=6){
					count=0;
				}
			}	
			if(chord.getChord()[5]==7){//6번째 줄 7플랫
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=7){
					count=0;
				}
			}
			if(chord.getChord()[5]==8){//6번째 줄 8플랫
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=8){
					count=0;
				}
			}
			if(chord.getChord()[5]==9){//6번째 줄 9플랫
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=9){
					count=0;
				}
			}
			if(chord.getChord()[5]==10){//6번째 줄 10플랫
				sendMessage(chord);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				} 
				if(chord.getChord()[5]!=10){
					count=0;
				}
			}
	//-------------------------------------------------------------------------------------------------------------------------------------------------//
	
					}	
				}
			}	
		}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chords2);
	
	
	
		chord = new Chord();
		chord.initChord();

		findViewById(R.id.imageButton_6_1).setOnTouchListener(new ButtonTouchListner(6, -1, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_6_2).setOnTouchListener(new ButtonTouchListner(-1, 6, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_6_3).setOnTouchListener(new ButtonTouchListner(-1, -1, 6, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_6_4).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, 6, -1, -1, chord));
	    findViewById(R.id.imageButton_6_5).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, 6, -1, chord));
	    findViewById(R.id.imageButton_6_6).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, -1, 6, chord));
		
	    findViewById(R.id.imageButton_7_1).setOnTouchListener(new ButtonTouchListner(7, -1, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_7_2).setOnTouchListener(new ButtonTouchListner(-1, 7, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_7_3).setOnTouchListener(new ButtonTouchListner(-1, -1, 7, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_7_4).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, 7, -1, -1, chord));
	    findViewById(R.id.imageButton_7_5).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, 7, -1, chord));
	    findViewById(R.id.imageButton_7_6).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, -1, 7, chord));
		
	    findViewById(R.id.imageButton_8_1).setOnTouchListener(new ButtonTouchListner(8, -1, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_8_2).setOnTouchListener(new ButtonTouchListner(-1, 8, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_8_3).setOnTouchListener(new ButtonTouchListner(-1, -1, 8, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_8_4).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, 8, -1, -1, chord));
	    findViewById(R.id.imageButton_8_5).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, 8, -1, chord));
	    findViewById(R.id.imageButton_8_6).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, -1, 8, chord));
		
	    findViewById(R.id.imageButton_9_1).setOnTouchListener(new ButtonTouchListner(9, -1, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_9_2).setOnTouchListener(new ButtonTouchListner(-1, 9, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_9_3).setOnTouchListener(new ButtonTouchListner(-1, -1, 9, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_9_4).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, 9, -1, -1, chord));
	    findViewById(R.id.imageButton_9_5).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, 9, -1, chord));
	    findViewById(R.id.imageButton_9_6).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, -1, 9, chord));
		
	    findViewById(R.id.imageButton_10_1).setOnTouchListener(new ButtonTouchListner(10, -1, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_10_2).setOnTouchListener(new ButtonTouchListner(-1, 10, -1, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_10_3).setOnTouchListener(new ButtonTouchListner(-1, -1, 10, -1, -1, -1, chord));
	    findViewById(R.id.imageButton_10_4).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, 10, -1, -1, chord));
	    findViewById(R.id.imageButton_10_5).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, 10, -1, chord));
	    findViewById(R.id.imageButton_10_6).setOnTouchListener(new ButtonTouchListner(-1, -1, -1, -1, -1, 10, chord));
		
	    
	    findViewById(R.id.i10f).setOnTouchListener(new ButtonTouchListner(10, 10, 10, 10, 10, 10, chord));
    
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    mConversationArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
    mConversationView = (ListView) findViewById(R.id.in2);
    mConversationView.setAdapter(mConversationArrayAdapter);
    
    
    
    
    
    
    

    
    
    // If the adapter is null, then Bluetooth is not supported
    if (mBluetoothAdapter == null) {
        Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
        finish();
        return;
    }
    
    //blueToothModule a = new blueToothModule();
	//a.start();

    guitar_sound = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    set_sound1();
   
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

private void sendMessage(Chord ch) {
	//Long->String
	String message = String.valueOf(ch.chord);
	
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
//        mOutEditText.setText(mOutStringBuffer);
    }
}




// The action listener for the EditText widget, to listen for the return key
private TextView.OnEditorActionListener mWriteListener =
    new TextView.OnEditorActionListener() {
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        // If the action is a key-up event on the return key, send the message
        if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
            String message = view.getText().toString();
//            sendMessage(message);
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
            	blueToothModule a = new blueToothModule();
    			a.start();
            case BluetoothChatService.STATE_CONNECTED:
    			blueToothModule b = new blueToothModule();
    			b.start();
                break;
            case BluetoothChatService.STATE_CONNECTED_TO_SERVER:
    			blueToothModule c = new blueToothModule();
    			c.start();
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
            
            long numInt = Long.parseLong(readMessage);
        	//int numInt = Integer.parseInt(readMessage);
            
            if(numInt == 0){ chordname = "null";} 
            if (numInt == 1000){ chordname = "C"; }
            if (numInt == 1001){ chordname = "Cm"; }
            if (numInt == 1002){ chordname = "C7"; }
            if (numInt == 1003){ chordname = "CM7"; }
            if (numInt == 1004){ chordname = "Cm7"; }
            if (numInt == 1005){ chordname = "D"; }
            if (numInt == 1006){ chordname = "Dm"; }
            if (numInt == 1007){ chordname = "D7"; }
            if (numInt == 1008){ chordname = "DM7"; }
            if (numInt == 1009){ chordname = "Dm7"; }
            if (numInt == 1010){ chordname = "E"; }
            if (numInt == 1011){ chordname = "Em"; }
            if (numInt == 1012){ chordname = "E7"; }
            if (numInt == 1013){ chordname = "EM7"; }
            if (numInt == 1014){ chordname = "Em7"; }
            if (numInt == 1015){ chordname = "F"; }
            if (numInt == 1016){ chordname = "Fm"; }
            if (numInt == 1017){ chordname = "F7"; }
            if (numInt == 1018){ chordname = "FM7"; }
            if (numInt == 1019){ chordname = "Fm7"; }
            if (numInt == 1020){ chordname = "G"; }
            if (numInt == 1021){ chordname = "Gm"; }
            if (numInt == 1022){ chordname = "G7"; }
            if (numInt == 1023){ chordname = "GM7"; }
            if (numInt == 1024){ chordname = "Gm7"; }
            if (numInt == 1025){ chordname = "A"; }
            if (numInt == 1026){ chordname = "Am"; }
            if (numInt == 1027){ chordname = "A7"; }
            if (numInt == 1028){ chordname = "AM7"; }
            if (numInt == 1029){ chordname = "Am7"; }
            if (numInt == 1030){ chordname = "B"; }
            if (numInt == 1031){ chordname = "Bm"; }
            if (numInt == 1032){ chordname = "B7"; }
            if (numInt == 1033){ chordname = "BM7"; }
            if (numInt == 1034){ chordname = "Bm7"; }
            
            mConversationArrayAdapter.add("Chord:  " +chordname );
            
            	
			
    		flag1 = numInt;
    		
    		acoustic = numInt;
    		electrical = numInt;
    		
    		if(acoustic == 100){
    			set_sound1();
    		}
    		if(electrical == 200){
    			set_sound2();
    		}
    		
    		if( flag1 == 1){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 2){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 3){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 4){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 5){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 6){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][5], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 7){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 8){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 9){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 91){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 92){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[0][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//
    		if( flag1 == 11){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 12){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 13){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 14){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 15){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 16){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][5], 1 , 1, 0, 0, 1f );						
    		}
			if( flag1 == 17){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 18){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 19){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 110){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 111){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[1][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//
    		if( flag1 == 21){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 22){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 23){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 24){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 25){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 26){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][5], 1 , 1, 0, 0, 1f );						
    		}
			if( flag1 == 27){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 28){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 29){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 210){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 211){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[2][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//	            		
    		if( flag1 == 31){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 32){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 33){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 34){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 35){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 36){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][5], 1 , 1, 0, 0, 1f );						
    		}
			if( flag1 == 37){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 38){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 39){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 310){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 311){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[3][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//
    		if( flag1 == 41){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 42){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 43){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 44){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 45){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 46){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][5], 1 , 1, 0, 0, 1f );						
    		}
			if( flag1 == 47){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 48){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 49){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 410){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 411){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[4][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//
    		if( flag1 == 51){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][0], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag1 == 52){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][1], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag1 == 53){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][2], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag1 == 54){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][3], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag1 == 55){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][4], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag1 == 56){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][5], 1 , 1, 0, 0, 1f );						
    		}
			if( flag1 == 57){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][6], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 58){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][7], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 59){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][8], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 510){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][9], 1 , 1, 0, 0, 1f );						
    		}
    		if( flag1 == 511){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[5][10], 1 , 1, 0, 0, 1f );						
    		}
//------------------------------------------------------------------------------------------------------------------------//	           		
    		
    		
    		
    		
    		
    		
    	/*	if( flag1 == 10){
    			//flat[0] = numInt;
    			//guitar_sound.play( string[ str[0] ][ flat[0] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[0] ][ flat[0] ], 1 , 1, 0, 0, 1f ); 
    		}																						
    		if( flag2 == 11){
    			//flat[1] = numInt;
    			//guitar_sound.play( string[ str[1] ][ flat[1] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[1] ][ flat[1] ], 1 , 1, 0, 0, 1f );						
    		}																				
    		if( flag3 == 12){
    			//guitar_sound.play( string[ str[2] ][ flat[2] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[2] ][ flat[2] ], 1 , 1, 0, 0, 1f );														
    		}

    		if( flag4 == 13){
    			//guitar_sound.play( string[ str[3] ][ flat[3] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[3] ][ flat[3] ], 1 , 1, 0, 0, 1f );				
    		}
    		if( flag5 == 14){
    			//guitar_sound.play( string[ str[4] ][ flat[4] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[4] ][ flat[4] ], 1 , 1, 0, 0, 1f );				
    		}					
    		if( flag6 == 15){
    			//guitar_sound.play( string[ str[5] ][ flat[5] ], valocity/6 , valocity/6, 0, 0, 1f );
    			guitar_sound.play( string[ str[5] ][ flat[5] ], 1 , 1, 0, 0, 1f );						
    		}
    		*/

        	break;
        case MESSAGE_WRITE:
            byte[] writeBuf = (byte[]) msg.obj;
            // construct a string from the buffer
            String writeMessage = new String(writeBuf);
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
    
    }
    return false;
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

