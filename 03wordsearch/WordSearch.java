import java.util.Random;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class WordSearch{
    private char[][]data;
    private int vertical;
    private int horizontal;
    private long seed;
    private int answer;
    public ArrayList<String> words = new ArrayList<String>();
    Random rand;

    //default
    WordSearch(){
	this(5,5);
    }
    //constructor without seed 
    WordSearch(int vertical, int horizontal){
	this(vertical, horizontal,0,0);
    }

    //constructor Makes 2D array
    WordSearch(int vertical, int horizontal,long seed,int answer){
	rand=new Random(seed);
	this.vertical=vertical;
	this.horizontal=horizontal;
	this.answer=answer;
	this.seed=rand.nextInt(); 
	data=new char[vertical][horizontal];
	for(int x=0;x<vertical;x++){
	    for(int y=0;y<horizontal;y++){
		data[x][y]='_';
	    }
	}
    }

    //loads file
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters){
	//creates word list
	String word="";
	int tries=0;
	try {
	    FileReader file = new FileReader(fileName);
	    BufferedReader buffer = new BufferedReader(file);
 
	    while(word!=null) {
		word=buffer.readLine();
		if (word!=null )
		    words.add(word);
            }
        }
	catch (IOException e)
	    {}
	//chooses random words
	try{
	    while(tries<=10){
		if(add(words.get(rand.nextInt(words.size())),rand.nextInt(vertical),rand.nextInt(horizontal), rand.nextInt(3)-1, rand.nextInt(3)-1)){
		    tries=0;
		}
		else{
		    tries+=1;
		}
	    }
	}
	catch(ArrayIndexOutOfBoundsException e){}
	
	//fill with letters
	if(fillRandomLetters){
	    randomLetters();
	}
    }

    public void randomLetters(){
	String alphabet="abcdefghijklmnopqrstuvwxyz";
	for(int x=0; x<vertical;x++){
	    for(int y=0;y<horizontal;y++){
		if(data[x][y]=='_'){
		    data[x][y]= alphabet.charAt(rand.nextInt(26));
		}
	    }
	}
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
       
		if(word.length()>vertical-row+1){
		    return false;
		}
		else{
		    for(int x=0;x<word.length();x++){
			if(dy==-1){
			    if(data[row+x][column]=='_' || data[row+x][column]==word.charAt(x)){
				result=true;
			    }
			}
			if(dy==1){
			    if(data[row+x][column]=='_'||data[row+x][column]==word.charAt(word.length()-x-1)){
				result=true;
			    }
			}
		    }
		}
		if(result){
		    if(dy==-1){
			for(int x=0; x<word.length();x++){
			    data[row+x][column]=word.charAt(x);
			}
		    }
		    if(dy==1){
			for(int x=1;x<=word.length();x++){
			    data[row+x-1][column]=word.charAt(word.length()-x);
				}
		    }
		}	
	}
    
	//adds horizontally
	if(dy==0 &&(dx==-1 || dx==1)){
		if(word.length()>horizontal-column+1){
		    return false;
		}
		else{
		    for(int x=0;x<word.length();x++){
			//horizontal forward
			if(dx==1){
			    if(data[row][column+x]=='_' || data[row][column+x]==word.charAt(x)){
			    result=true;
			    }
			}
			//horizontal backwards
			if(dx==-1){
			    if(data[row][column+x]=='_' || data[row][column+x]==word.charAt(word.length()-x-1)){
				result=true;
			    }
			}
		    }
		}
		if(result){
		    for(int x=0;x<word.length();x++){
			if(dx==1){
			    data[row][column+x]=word.charAt(x);
			}
			if(dx==-1){
			    data[row][column+x]=word.charAt(word.length()-x-1);
			}
		    }
		}
	}
	//diagonally downwards
	if((dx==-1 && dy==1) || (dy==-1 && dx==1)){
	    if(row>vertical-word.length() || column>horizontal-word.length()){
		    return false;
	    }
	
	    else{
		for(int x=0;x<word.length();x++){
		    if(dy==-1){
			if(data[row+x][column+x]=='_' || data[row+x][column+x]==word.charAt(x)){
			    result=true;
			}
		    }
		    if(dy==1){
			if(data[row+x][column+x]=='_' || data[row+x][column+x]==word.charAt(word.length()-x-1)){
			    result=true;
			}
		    }
		}
	    }
	    if(result){
		for(int x=0;x<word.length();x++){
		    if(dy==-1){
			data[row+x][column+x]=word.charAt(x);
		    }
		    if(dy==1){
			data[row+x][column+x]=word.charAt(word.length()-x-1);
		    }
		}
	    }
	}

	//diagonally upwards
	if((dx==-1 && dy==-1) || (dx==1 && dy==1)){
	    if(word.length()>row+1 ||column>horizontal-word.length()){
		    return false;
	    }
	
	    else{
		for(int x=0;x<word.length();x++){
		    if(dy==-1){
			if(data[row-x][column+x]=='_' || data[row+x][column+x]==word.charAt(x)){
			    result=true;
			}
		    }
		    if(dy==1){
			if(data[row-x][column+x]=='_' || data[row+x][column+x]==word.charAt(word.length()-x-1)){
			    result=true;
			}
		    }
		}
	    }
	    if(result){
		for(int x=0;x<word.length();x++){
		    if(dy==-1){
			data[row-x][column+x]=word.charAt(x);
		    }
		    if(dy==1){
			data[row-x][column+x]=word.charAt(word.length()-x-1);
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

    //sets seed
    public void setSeed(long seed){
	this.seed=seed;
    }


    //creates wordgrid format
    public String toString(){
	String word="";
	for(int x=0;x<vertical;x++){
	    word="";
	    for(int y=0;y<horizontal;y++){
		word+=data[x][y]+" ";
	    }
	    System.out.println(word);
	    System.out.println();
	}
	return word;
    }


}
    

