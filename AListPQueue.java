package cs2s03;

public class AListPQueue implements MyPriorityQueue{
	private AList list;
	
	//constructor for empty queue
	AListPQueue(){
		list = new AList();
	}
	
	//constructor for one item in the queue
	AListPQueue(char hd, int priority){
		list = new AList(hd, priority);
	}
	
	//constructor for more than one item in the queue
	AListPQueue (char hd, int priority, AListPQueue ll){
		//call insert method to set the queue in priority order
		list = insert(priority, hd, ll.list); 
	}
	
	@Override
	public char next() throws EmptyContainerException {
		//return the highest priority item
		if(isEmpty()){
			throw new EmptyContainerException("Empty");
		}
		return list.peek();
	}

	@Override
	public void deleteItem() {
		// the first "if" delete the item when the first item is not empty
		// the second "if" delete the last item when there is only one item left
		if(list.getHd()!='\0' && list.getTl() != null){
				list.setHd(list.getTl().getHd());
				list.setP(list.getTl().getP());
				list.setTl(list.getTl().getTl()); 
		}else if(list.getHd()!='\0' && list.getTl() == null){
				list.setHd('\0');
				list.setTl(null);
		}
	}

	@Override
	public void insertItem(int p, char c) {
		//insert the item 
		list = insert(p, c, list);
	}
	
	//using recursion to insert the item in priority
	public AList insert(int p, char c, AList l){
		//compare the priority and the alphabet if priority tie
		if(l == null || (l.getP() < p || (l.getP() == p && l.getHd() > c))){
			return new AList(c, p, l);
		}
		else{
			//every time insert is called,
			//it creates a new node t the queue
			return new AList(l.getHd(), l.getP(), insert(p, c, l.getTl()));
		}
	}
	
	@Override
	public boolean isEmpty() {
		//check queue if it is empty
		return list.isEmpty();
	}
	
	//String representation of AListPQueue is <>
	@Override
	public String toString(){
		AList temp = new AList(list.getHd(),list.getP(),list.getTl());
		String s = "";
		while(temp.getTl()!=null && temp.getHd() != '\0' ){
			s += temp.getP();
			s += temp.getHd();
			temp = temp.getTl();
		}
		//while loop above would exit without 
		//adding the last item into the string
		//if statement below will add the one last item into the string
		if((temp.getTl()==null && temp.getHd() != '\0')){
			s += temp.getP();
			s += temp.getHd();
		}
		return "<"+s+">";
	}
	
	@Override
	public boolean equals( Object l ){ 
		//compare two string
		if(this.toString().equals(l.toString())){
			return true;
		}
		return false;
	}
}
