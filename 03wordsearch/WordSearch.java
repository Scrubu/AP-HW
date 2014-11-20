public class WordSearch{
    private char[][]data;
    private int vertical;
    private int horizontal;
    WordSearch(){
    this(5,5);
    }
    WordSearch(int vertical, int horizontal){
    vertical=this.vertical;
    horizontal=this.horizontal;
    data=new char[vertical][horizontal];
    }

    private void clear(){
    for(int x=0; x<vertical;x++){
        for(int y=0;y<horizontal;y++){
        data[x][y]='_';
            }
    }
    }
    public boolean addWordHorizontal(String word, int row, int column){
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
        char letter=word.charAt(y);
            data[row][column+y]=letter;
        }
    }
    return result;
    }
