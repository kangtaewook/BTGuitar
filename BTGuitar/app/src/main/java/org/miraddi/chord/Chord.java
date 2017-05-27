package org.miraddi.chord;

public class Chord {

	public long chord;
	public Chord(){
		initChord();
	}
	public void initChord(){ chord = 0; }



	public void setChord( int a, int b, int c, int d, int e, int f )
	{
		long temp, temp2;

		if(a != -1){
			temp = a;
			temp = temp << 52;

			temp2 = 31;
			temp2 = temp2 << 52;
			temp2 = ~temp2;
			this.chord = this.chord & temp2; 

			this.chord = this.chord | temp;
		}

		if(b != -1){
			temp = b;
			temp = temp << 47;

			temp2 = 31;
			temp2 = temp2 << 47;
			temp2 = ~temp2;
			this.chord = this.chord & temp2;

			this.chord = this.chord | temp;
		}

		if(c != -1){
			temp = c;
			temp = temp << 42;

			temp2 = 31;
			temp2 = temp2 << 42;
			temp2 = ~temp2;
			this.chord = this.chord & temp2;

			this.chord = this.chord | temp;
		}

		if(d != -1){
			temp = d;
			temp = temp << 37;

			temp2 = 31;
			temp2 = temp2 << 37;
			temp2 = ~temp2;
			this.chord = this.chord & temp2;

			this.chord = this.chord | temp;
		}

		if(e != -1){
			temp = e;
			temp = temp << 32;

			temp2 = 31;
			temp2 = temp2 << 32;
			temp2 = ~temp2;

			this.chord = this.chord & temp2;

			this.chord = this.chord | temp;
		}

		if(f != -1){
			temp = f;
			temp = temp << 27;

			temp2 = 31;
			temp2 = temp2 << 27;
			temp2 = ~temp2;
			this.chord = this.chord & temp2;

			this.chord = this.chord | temp;
		}
	}

	public int[] getChord()
	{
		int[] chord = new int[6];

		long temp = 0;
		temp = this.chord & 139611588448485376L;
		temp = temp >> 52;
		chord[0] = (int) temp;     

		temp = 0;
		temp = this.chord & 4362862139015168L;
		temp = temp >> 47;
		chord[1] = (int) temp;

		temp = 0;
		temp = this.chord & 136339441844224L;
		temp = temp >> 42;
		chord[2] = (int) temp;

		temp = 0;
		temp = this.chord & 4260607557632L;
		temp = temp >> 37;
		chord[3] = (int) temp;

		temp = 0;
		temp = this.chord & 133143986176L;
		temp = temp >> 32;
		chord[4] = (int) temp;

		temp = 0;
		temp = this.chord & 4160749568L;
		temp = temp >> 27;
		chord[5] = (int) temp;

		return chord;
	}

	

}
