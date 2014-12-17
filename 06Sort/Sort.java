public class Sort{
    public void selection(int[] c){
	for(int y=0; y<c.length-1; y++){
	    int base=c[y];
	    for(int x=y; x<c.length-1; x++){
		if(base<c[x+1]){
		    int replace=c[x+1];
		    c[x+1]=base;
		    base=replace;
		}
	    }
	}
    }
    public void insertion(int[] c){
	
    }
    public void bubble(int[] c){
	int counter=0;
	for(int y=0; y<c.length; y++){
	    if(counter==c.length-1){
		break;
	    }
	    counter=0;
	    for(int x=0; x<c.length-1; x++){
		if(c[x]>c[x+1]){
		    int replace = c[x+1];
		    c[x+1]=c[x];
		    c[x]=replace;
		}
		else{
		    counter++;
		}
	    }
	}
    }
}
