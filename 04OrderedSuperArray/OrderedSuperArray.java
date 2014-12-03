public class OrderedSuperArray extends SuperArray1{
    public void add(Object e){
	super.add(e);
	for(int x=2; x<=super.size();x++);
	if(e.comparesTo(yoMama[super.size()-x])<=0){
	    super.remove(super.size()-1);
	    super.add(e, super[super.size()-x]);
	}
	    
    }
}