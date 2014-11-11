public class SuperArray{
    int current;
    Object[]yoMama;


    public boolean anyNull(Object[] o){
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
    public SuperArray(){
	this(10);
    }
    public SuperArray(int num){
	yoMama=new Object[num];
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
    public void add(Object e){
	resize(size()+1);
	yoMama[yoMama.length-1]=e;			  
    }
    public void add(int index, Object o){
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
	Object[]sub = new Object[newCapacity];
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
    public Object set(int index, Object o){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	
	Object replaced=yoMama[index];
	yoMama[index]=o;
	return replaced;
	
    }

    public static void main(String[]aargs){
	Integer x = new Integer(5);
	SuperArray a=new SuperArray(3);
	a.add(1,x);
	a.add(1,x);
	a.remove(1);
	a.resize(5);
       	a.set(4,x);
	a.toString();
	a.get(1);
    }    
}
