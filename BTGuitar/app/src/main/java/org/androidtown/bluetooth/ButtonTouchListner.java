package org.androidtown.bluetooth;

import org.miraddi.*;
import org.miraddi.chord.Chord;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class ButtonTouchListner implements OnTouchListener{
	int a, b, c, d, e, f;
	Chord chord;
	
	public ButtonTouchListner(int a, int b, int c, int d, int e, int f, Chord chord)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.chord = chord;
	}
	

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(MotionEvent.ACTION_DOWN == event.getAction())
		{
			chord.setChord(this.a, this.b, this.c, this.d, this.e, this.f);
			
		}
		if(MotionEvent.ACTION_UP == event.getAction())
		{
			if( this.a != -1 )
			{
				chord.setChord(0, -1, -1, -1, -1, -1);
			}
			if( this.b != -1 )
			{
				chord.setChord(-1, 0, -1, -1, -1, -1);
			}
			if( this.c != -1 )
			{
				chord.setChord(-1, -1, 0, -1, -1, -1);
			}
			if( this.d != -1 )
			{
				chord.setChord(-1, -1, -1, 0, -1, -1);

			}
			if( this.e != -1 )
			{
				chord.setChord(-1, -1, -1, -1, 0, -1);

			}
			if( this.f != -1 )
			{
				chord.setChord(-1, -1, -1, -1, -1, 0);

			}
		}
//		String str = 	String.valueOf(chord.getChord()[0]) +
//						String.valueOf(chord.getChord()[1]) +
//						String.valueOf(chord.getChord()[2]) +
//						String.valueOf(chord.getChord()[3]) +
//						String.valueOf(chord.getChord()[4]) +
//						String.valueOf(chord.getChord()[5]);
//		Log.d("string", str );
		return false;
	}


	

}
