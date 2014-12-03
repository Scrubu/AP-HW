import java.io.FileNotFoundException;
public class Driver{
    public static void main(String[]args){
	int row = Integer.parseInt(args[0]);
	int column = Integer.parseInt(args[1]);
	int seed = Integer.parseInt(args[2]);
	int answer = Integer.parseInt(args[3]);
	WordSearch a=new WordSearch(row,column,seed,answer);
	boolean show=false;
	if(answer==0){
	    show = true;
	}
	a.loadWordsFromFile("words.txt",show);
	System.out.println( "Find these words:\n"+ a.wordsInPuzzle() );
	a.toString();

    }
}
//	    if(dx==-1){
//		if(word.length()>horizontal-column+1
//	    }
//	    }true;

