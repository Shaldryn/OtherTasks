package Lab4.analysisofwordsintext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

public class MyCounter {

    public static void main(String[] args) throws IOException {
        SimpleParser sp = new SimpleParser();
        sp.Parse(args);

        //WordCount wc = new WordCount(null, null);
        WordCount wc = new WordCount(sp.getInFile(), sp.getOutFile());
//        WordCount wc = new WordCount("inFile.txt", "outFile.txt");
        wc.countWords();
        wc.writeCountWords();

        Enumeration keys = wc.getWords().keys();
        while (keys.hasMoreElements()) {
            String w = keys.nextElement().toString();
            int n = wc.getWords().get(w);
            System.out.println(w + "   " + n);
        }
    }
}
