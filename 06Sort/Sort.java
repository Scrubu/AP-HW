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

    public static void radix(int[]c){
	int[]numbers= c;
	int loops=10;
	int repeat=10;
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
		for(int x=0;x<numbers.length;x++){
		    if(numbers[x]<loops){
			zero=false;
			System.out.println("FUCL");
		    }
		    //CHECK
		    else{
			zero=true;
			System.out.println(numbers[x]%loops);
		    }
		}
		if(zero){
		    loops=(loops*10);
		}
		else{
		    
		    finish=false;
		}
	    }while(finish);
	
	    for(int x=0; x<numbers.length; x++){
		int placeholder;
		placeholder=numbers[x]%repeat;
		while(placeholder>9){
		    placeholder= placeholder/10;
		}
		System.out.println(placeholder);
		System.out.println(numbers[x]);
		System.out.println(repeat);
		ArrayList<Integer> inner=row.get(placeholder);
		inner.add(numbers[x]);
		System.out.println(row);
	    }
	    int t=0;
	    for(int x=0; x<numbers.length; x++){
		ArrayList<Integer> inner;
	
		
		inner=(ArrayList<Integer>) row.get(x);
		System.out.println(inner);
		System.out.println("^INNER");
		int r =0;
		
		if(!(inner.isEmpty())){
		    for(int y=0; y<inner.size();y++){
			
			numbers[t]=inner.get(r);
			t++;
			r++;
		       	System.out.println(Arrays.toString(numbers));
		    }
		}
		else{
		    
		    System.out.println("FUCK YOU ITS EMPTY");
		}
	    
	    }
	    repeat=repeat*10;
	    System.out.println(repeat);
	    System.out.println(loops);
	    System.out.println(Arrays.toString(numbers));
	}while(repeat<=loops);
	
	c=numbers;
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
	int[] john = new int[10];
	int[] jaques=new int[10];
	int[] paco = new int[10];
	int[] fawlkon=new int[10];
	int[] niagra= new int[10];
	int num;
	for(int x=0;x<john.length;x++){
	    num=rand.nextInt(1000);
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
	System.out.println(Arrays.toString(john));			 
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
	System.out.println(Arrays.toString(niagra));
	radix(niagra);
	System.out.println(Arrays.toString(niagra));			 
	end = System.currentTimeMillis();
	System.out.println("total= " +(end-start));
	System.out.println();
    }
}
