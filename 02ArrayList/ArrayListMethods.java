import java.util.*;

public class ArrayListMethods{
  
    public static void collapseDuplicates(ArrayList<Integer> L){
	for(int x=0; x<L.size()-1; x++){
	    if(L.get(x).equals(L.get(x+1))){
		L.remove(x);
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	Random rand=new Random();
	int  size=L.size();
	for(int x=L.size()-1; x>=0; x--){
	    int newIndex=rand.nextInt(size);
	    int oldIndex=L.get(x);
	    L.set(x,L.get(newIndex));
	    L.set(newIndex,oldIndex);
	}
    }

    public static void main(String[]arrggs){
	ArrayList<Integer> john=new ArrayList<Integer>();
	john.add(3);
	john.add(3);
	john.add(5);
	randomize(john);

	System.out.println(john);

    }
}

