package Lab4.analysisofwordsintext;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class WordCount {

    private String inFile;
    private String outFile;
    private static String testString = "маленькая игра, большую часть которой сделали два человека. " +
            "У руля проекта стоял Алексей Тестов, ответственный за историю, потрясающий" +
            " (если вы не против 8-битной эстетики) внешний вид и игровой процесс, плотно сплетенный с " +
            "рассказом. Сразу чувствуется, насколько проект личный, — он пропитан грустью и размышлениями, " +
            "к которым нельзя прийти в выхолощенном продюсерами проекте. В очередной раз убеждаюсь, " +
            "что невозможно сделать плохо, когда отдаешь работе всего себя. Хоть игра местами неровная, " +
            "но оторваться от нее все равно невозможно.";
    private Hashtable<String, Integer> words = new Hashtable<>();

    public WordCount(String inFile, String outFile) {
        setInFile(inFile);
        setOutFile(outFile);
    }

    public String getInFile() {
        return inFile;
    }

    public void setInFile(String inFile) {
        this.inFile = inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static String getTestString() {
        return testString;
    }

    public Hashtable<String, Integer> getWords() {
        return words;
    }

    public void countWords() throws IOException {

        Reader reader;

        if (getInFile() == null) {
            reader = new StringReader(getTestString().toLowerCase());
        } else {
            reader = new FileReader(getInFile());
        }

        BufferedReader br = new BufferedReader(reader);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line, "\n\t\r,.;: -()");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (words.containsKey(token)) {
                    words.put(token, words.get(token) + 1);
                } else {
                    words.put(token, 1);
                }
            }
        }
        br.close();
    }


    public void writeCountWords() {

        try (FileWriter fileWriter = new FileWriter(getOutFile())) {
            fileWriter.write(getWords().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
