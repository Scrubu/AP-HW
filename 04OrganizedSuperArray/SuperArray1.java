import java.util.*;
public class SuperArray1{
    int current;
    String[]yoMama;
    public boolean anyNull(String[] o){
	int truth=0;
	for(int x=0;x<o.length;x++){
	    if(o[x]==null){
		truth=1;
	    }
	}
	if(truth==1){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    public SuperArray1(){
	this(10);
    }
    public SuperArray1(int num){
	yoMama=new String[num];
	current=num;
    }
    public String toString(){
	String john="[";
	for(int x=0; x<yoMama.length; x++){
	    john+= yoMama[x]+" ";
	}
	john+="]";
	System.out.println(john);
	System.out.println();
	return john;
    }
    public int size(){
	return current;
    }
    public int compareTo(String a, String b){
	int value=0;
	if(Integer.parseInt(a) >  Integer.parseInt(b)){
	    value=1;
	}
	if(Integer.parseInt(a) < Integer.parseInt(b)){
	    value=-1;
	}
	return value;
    }
    
    
    public void insertionSort(){
	try{
	    for(int x=0;x<yoMama.length;x++){
		if(compareTo(yoMama[x],yoMama[x+1])==1){
		    for(int y=x-1;y>=0;y--){
			if(compareTo(yoMama[x+1],yoMama[y])<=0){
			    String value= yoMama[x+1];
			    for(int z=x+1;z>=0;z--){
				yoMama[z]=yoMama[z-1];
			    }
			    yoMama[y]=value;
			}
		    }
		}
	    }
	}catch(NullPointerException k){}
    }
    public void add(String e){
	resize(size()+1);
	yoMama[yoMama.length-1]=e;
    }
    public void add(int index, String o){
	if(!(anyNull(yoMama))){
	    resize(size()+1);
	}
	if(yoMama[index]==null){
	    yoMama[index]=o;
	}
	else{
	    for(int x=index+1;x<current;x++){
		if(yoMama[x]==null){
		    for(int u=x; u>index;u--){
			yoMama[x]=yoMama[x-1];
		    }
		}
	    }
	}
    }
    public Object remove(int index){
	if(index<0||index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	Object ret=yoMama[index];
	yoMama[index]=null;
	return ret;
    }
    public void resize(int newCapacity){
	String[]sub = new String[newCapacity];
	for(int a=0; a<current;a++){
	    sub[a]=yoMama[a];
	}
	yoMama=sub;
	current = newCapacity;
    }
    public void clear(){
	for(int a=0; a<current; a++){
	    if(yoMama[a]!=null){
		yoMama[a]=null;
	    }
	}
    }
    public Object get(int index){
	if(index< 0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	return yoMama[index];
    }
    public Object set(int index, String o){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	String replaced=yoMama[index];
	yoMama[index]=o;
	return replaced;
    }

}
