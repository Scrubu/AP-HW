import java.util.Random;
import java.util.Arrays;

public class Sort{
    public static void selection(int[] c){
	int base;
	for(int y=0; y<c.length-1; y++){
	     base=c[y];
	    for(int x=y; x<c.length-1; x++){
		if(base>c[x+1]){
		    int replace=c[x+1];
		    c[x+1]=base;
		    base=replace;
		    c[y]=replace;
		}
	    }
	}
    }
    public static void insertion(int[] c){
	for(int x=0; x< c.length-1; x++){
	    if(c[x]>c[x+1]){
		int replace=c[x+1];
		c[x+1]=c[x];
		c[x]=replace;
		for(int y=x ; y > 0; y--){
		    if(c[y]>c[y-1]){
			break;
		    }
		    else{
			int swap=c[y-1];
			c[y-1]=c[y];
			c[y]=swap;	
		    }
		}
	    }
	}
    }
	      
    public static void bubble(int[] c){
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
    
    public static void main(String[] araara){
	long start, end;
	Random rand = new Random();
	int[] john = new int[10000000];
	int[] jaques=new int[10000000];
	int[] paco = new int[10000000];
	int num;
	for(int x=0;x<john.length;x++){
	    num=rand.nextInt(1000);
	    john[x]=num;
	    jaques[x]=john[x];
	    paco[x]=john[x];
	}
	//BUBBLE SORT
	System.out.println("BUBBLE");
	start = System.currentTimeMillis();;
	bubble(john);
	//System.out.println(Arrays.toString(john));			 
	 end = System.currentTimeMillis();
	System.out.println(end-start);
	
	//INSERTION SORT
	System.out.println("INSERTION");
	start = System.currentTimeMillis();
	insertion(jaques);
	//System.out.println(Arrays.toString(jaques));			 
	 end = System.currentTimeMillis();
	System.out.println(end-start);

	//SELECTION SORT
	System.out.println("SELECTION");
	start = System.currentTimeMillis();
	selection(paco);
	//System.out.println(Arrays.toString(paco));			 
	end = System.currentTimeMillis();
	System.out.println(end-start);
    }
}
