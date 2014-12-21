import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Sort{

    public static String name(){
	System.out.println("Lai, Kyle");
	return "Lai, Kyle";
    }
    public static int period(){
	System.out.println("6");
	return 6;
    }
    /*loops is a multiple of 10 and is how many times the function has to be done to return the sorted array, so repeat has to
      equal to loops for the function to end. Repeat is used to find the modulos of the numbers in the array.
      zero is what checks if any numberes in the array are less than loops and is used to find the maximum number of placeholders in the array.
      finish ends the first "do" and returns the number of loops needed to return the sorted array.

     */
    public static void radix(int[]c){
	int loops=1;
	int repeat=1;
	boolean zero=true;
	boolean finish=true;

	do{
	    ArrayList<ArrayList<Integer>> row=new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i<10; i++){
		ArrayList<Integer>john=new ArrayList<Integer>();
		for(int j=0; j<0;j++){
		    john.add(0);
		}
		row.add(john);
	    }
	    do{
		zero=true;
		for(int x=0;x<c.length;x++){
		    if(c[x]<loops){
			zero=false;
			
		    }
		    //CHECK
		    else{
			zero=true;
		    }
		}
		if(zero){
		    loops=(loops*10);
		}
		else{
		    
		    finish=false;
		}
	    }while(finish);
	
	    for(int x=0; x<c.length; x++){		
		int placeholder=(c[x]/repeat)%10;	
		ArrayList<Integer> inner=row.get(placeholder);
		inner.add(c[x]);
	    }
	    int t=0;
	    for(int x=0; x<row.size(); x++){
		ArrayList<Integer> inner;
		inner=(ArrayList<Integer>) row.get(x);
	
		
		if(!(inner.isEmpty())){
		    for(int y=0; y<inner.size();y++){
			
			c[t]=inner.get(y);
			t++;
			
		       
		    }
		}	    
	    }
	    repeat=repeat*10;
	}while(repeat<=loops);
	

    }

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
	int[] john = new int[30];
	int[] jaques=new int[30];
	int[] paco = new int[30];
	int[] fawlkon=new int[30];
	int[] niagra= new int[30];
	int num;
	for(int x=0;x<john.length;x++){
	    num=rand.nextInt(100);
	    john[x]=num;
	    jaques[x]=num;
	    paco[x]=num;
	    fawlkon[x]=num;
	    niagra[x]=num;
	}
	//BUBBLE SORT
	System.out.println("BUBBLE");
	start = System.currentTimeMillis();;
	bubble(john);
	//	System.out.println(Arrays.toString(john));			 
	 end = System.currentTimeMillis();
	System.out.println("total= " +(end-start));
	System.out.println();
	
	//INSERTION SORT
	System.out.println("INSERTION");
	start = System.currentTimeMillis();
	insertion(jaques);
	//System.out.println(Arrays.toString(jaques));			 
	 end = System.currentTimeMillis();
	 System.out.println("total= " +(end-start));
	 System.out.println();

	//SELECTION SORT
	System.out.println("SELECTION");
	start = System.currentTimeMillis();
	selection(paco);
	//System.out.println(Arrays.toString(paco));			 
	end = System.currentTimeMillis();
	System.out.println("total= " +(end-start));
	System.out.println();

	//ARRAYS.SORT
	System.out.println("ARRAY.SORT");
	start = System.currentTimeMillis();
	Arrays.sort(fawlkon);
		System.out.println(Arrays.toString(fawlkon));			 
	end = System.currentTimeMillis();
	System.out.println("total= " +(end-start));
	System.out.println();
	
	//RADIX
	System.out.println("RADIX");
	start = System.currentTimeMillis();
	radix(niagra);
		System.out.println(Arrays.toString(niagra));			 
	end = System.currentTimeMillis();
	System.out.println("total= " +(end-start));
	System.out.println();
    }
}
