package cs2s03;


public class AList {
	private char hd;
	private int priority;
	private AList tl;
	
	//constructor for empty list
	AList (){}
	
	//constructor for only one item in it
	AList (char c, int p){
		this.hd = c;
		this.priority = p;
		this.tl = null;
	}
	
	//constructor to set the list with more than one item
	AList (final char c, final int p, final AList ll){
		this.hd = c;
		this.priority = p;
		this.tl = ll;
	}

	
	public char peek(){
		//return the first item in the queue
		return this.hd;
	}
		
	public boolean isEmpty(){
		//List is empty when char is equal to '\0'(means null in char)
		//and when list of tail is null
		return (this.tl == null && this.hd == '\0');
	}
	
	//getter and setter helpers
	public char getHd() {
		return this.hd;
	}
	public int getP() {
		return this.priority;
	}

	public AList getTl(){
		return this.tl;
	}
	public void setHd(char c) {
		this.hd = c;
	}
	public void setP(int p) {
		this.priority = p;
	}

	public void setTl(AList l){
		this.tl = l;
	}
	
	//String representation of AList is {}
	@Override
	public String toString(){
		AList temp = new AList(this.getHd(),this.getP(),this.getTl());
		String s = "";
		while(temp.getTl()!=null && temp.getHd() != '\0'){
			s += temp.getP();
			s += temp.getHd();
			temp = temp.getTl();
		}
		//while loop above would exit without adding the last item
		//if statement below will add the one last item into the string
		if((temp.getTl()==null && temp.getHd() != '\0')){
			s += temp.getP();
			s += temp.getHd();
		}
		return "{"+s+"}";
	}

	@Override
	public boolean equals( Object l ){ 
		//compare two strings
		if(this.toString().equals(l.toString())){
			return true;
		}
		return false;
	}
}

