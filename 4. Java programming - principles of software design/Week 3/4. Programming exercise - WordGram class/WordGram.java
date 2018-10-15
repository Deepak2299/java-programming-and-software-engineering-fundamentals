import java.util.*;

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }
    
    /**
     * Prints out a WordGram, showing all the words in the WordGram on one line separated by spaces.
     */
    public String toString(){
        String ret = "";
        
        for (int i = 0; i < myWords.length; i++) {
            ret += myWords[i] + " ";
        }
        
        return ret.trim();
    }

    public boolean equals(Object o) {
        // Convert o into a WordGram if it isn't already of that type
        WordGram other = (WordGram) o;
        
        /*
        // (shortcut?) Test with toString 
        String currStr = myWords.toString();
        String otherStr = other.toString();
        if (!currStr.equals(otherStr)) {
            return false;
        }
        return true;
        */
        
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < myWords.length; i++) {
            if (!myWords[i].equals(other.wordAt(i))) {
                return false;
            }
        }
        
        return true;
    }

    public WordGram shiftAdd(String word) { 
        /*ArrayList<String> temp = new ArrayList<String>(Arrays.asList(myWords));
        temp.remove(0);
        temp.add(word);
        WordGram out = new WordGram(temp.toArray(new String[temp.size()]), 0, temp.size());*/
        WordGram out = new WordGram(myWords, 0, myWords.length);
        // shift all words one towards 0 and add word at the end. 
        ArrayList<String> temp= new ArrayList<String>(out.length());
        
        for (int k=1;k<out.length();k++){
             temp.add(out.wordAt(k));         
              }
        temp.add(word);
        out=new WordGram(temp.toArray(new String[temp.size()]), 0, temp.size());
        return out;
    }
    
    /**
     *  Returns an integer that is a hash code that represents the WordGram.
     */
    public int hashCode() {
        return this.toString().hashCode();
    }
}
