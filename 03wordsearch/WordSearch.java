import java.util.Random;

public class WordSearch{
    Random rand=new Random();
    private char[][]data;
    private int vertical;
    private int horizontal;
    WordSearch(){
	this(5,5);
    }


    //Makes 2D array
    WordSearch(int vertical, int horizontal){
	vertical=this.vertical;
	horizontal=this.horizontal;
	data=new char[vertical][horizontal];
    }

    //replaces word search with underscore
    private void clear(){
	for(int x=0; x<vertical;x++){
	    for(int y=0;y<horizontal;y++){
		data[x][y]='_';
            }
	}
    }

   //adds words

    public boolean add(String word, int row, int column, int dx, int dy){
	boolean result=false;
	if(dx<-1 && dx>1 && dy>1 && dy<-1 && dx==0 && dy==0){
	    return false;
	}

	//adds vertically

        if(dx==0 && (dy==1||dy==-1)){
	    if(dy==-1){
		if(word.length()>vertical-row+1){
		    return false;
		}
		else{
		    for(int x=0;x<word.length();x++){
			if(data[row+x][column]=='_' || data[row+x][column]==word.charAt(x)){
			    data[row+x][column]=word.charAt(x);
			    result=true;
			}
		    }
		}
	    }
	
	    if(dy==1){
		if(word.length()>row+1){
		    return false;
		}
		else{
		    for(int x=1;x<=word.length();x++){
			if(data[row+x-1][column]=='_' || data[row+x-1][column]==word.charAt(word.length()-x)){
			    data[row+x-1][column]=word.charAt(word.length()-x);
			    result=true;
			}
		    }
		}
	    }
	}

	//ads horizontally
	
	if(dy==0 &&(dx==-1 || dx==1)){
	    if(dx==1){
		if(word.length()>horizontal-column+1){
		    return false;
		}
		else{
		    for(int x=0;x<word.length();x++){
			if(data[row][column+x]=='_' || data[row][column+x]==word.charAt(x)){
			    data[row][column+x]=word.charAt(x);
			    result=true;
			}
		    }
		}
	    }
	}
	return result;
    }
    

	    	 

    //adds words vertically
    public boolean addWordVertical(String word, int row, int column){
	int choice=rand.nextInt(2);
	if(word.length()> row+1){
	    return false;
	}
	boolean result=false;
	for(int x=1;x<=word.length();x++){
	    if (data[row+x-1][column]=='_'){
		result=true;
	    }
	}
	if(result){
		for(int x=1;x<=word.length();x++){
		    if(choice==0){
		    char letter=word.charAt(x-1);
		    data[row+x-1][column]=letter;
			}
		    else{
			char letter=word.charAt(word.length()-x);
			data[row+x-1][column]=letter;
		    }
		}
	}
	return result;
    }

    //adds word horizontally
    public boolean addWordHorizontal(String word, int row, int column){
	int choice=rand.nextInt(2);
	if(word.length()>column+1){
	    return false;
        }
	boolean result=false;
	for(int x=1;x<=word.length();x++){
	    if(data[row][column+x-1]=='_'){
		result=true;
	    }
	}
           
	if(result){
	    for(int a=1;a<=word.length();a++){
		int y=a-1;
		if(choice==0){
		    char letter=word.charAt(y);
		    data[row][column+y]=letter;
		}
		else{
		    char letter = word.charAt(word.length()-a);
		    data[row][column+y]=letter;
		}
		   
	    }
	}    
	return result;
    }


    //creates wordgrid format
    public String toString(){
	String word="";
	for(int x=0;x<vertical;x++){
	    for(int y=0;y<horizontal;y++){
		word= data[x][y]+" ";
	    }
	}
	System.out.println(word);
	return word;
    }
}
    

