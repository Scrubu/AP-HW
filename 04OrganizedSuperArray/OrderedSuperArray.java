public class OrderedSuperArray extends SuperArray1{
    public void add(String e){
	super.add(e);
	for(int x=2; x<=super.size();x++){
	    if(compareTo(e, yoMama[super.size()-x])<=0){
		super.remove(super.size()-1);
		super.add(super.size()-x,e);
	    }
	    
	}
    }
}
