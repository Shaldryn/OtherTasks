package corejava.Lab5.mycounter;

import java.io.*;
import java.util.*;

public class WordCounter {
    private String inFile;
    private String outFile;
    private static String testString = " fhfghgf  hello   o wtryh\n  hello o o ";
    private ArrayList<IWordCounter> listenersList = new ArrayList<>();

    public WordCounter(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    private Hashtable words = new Hashtable();
    public  Hashtable getWords() { return words; }

    public void addListener(IWordCounter listener) {
        listenersList.add(listener);
    }

    public void delListeners(IWordCounter listener) {
        listenersList.remove(listener);
    }

    protected void fireCounter(int size) {

        for (IWordCounter listener :
                listenersList) {
            listener.counter(this, size);
        }
        
    }

    public void countWords(){ 
        int num=0;
        try {
            Reader reader;
            if ( inFile == null ) 
                    reader = new StringReader(testString);
            else    reader = new FileReader(inFile);

            BufferedReader br=new BufferedReader(reader);
            for (String line = br.readLine(); line != null; line = br.readLine()) {

                StringTokenizer st =new  StringTokenizer(line," \t\n\r\f.,;:\"");  
                while(st.hasMoreTokens()) {
                    String token=st.nextToken();
                        if (!words.containsKey(token)){
                                words.put(token,1);
                                num++;
                        }
                        else {
                            Object val = words.get(token);
                            int n=(int) val;
                            n++;
                            words.put(token,n);
                        }
                }
            }
            br.close(); 
            System.out.println("num="+num);

            fireCounter(num);
        }
        catch (IOException ex) { ex.printStackTrace(); }
    }
}
