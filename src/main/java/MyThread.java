import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class MyThread extends Thread{
    private HashSet<String> words = new HashSet<>();
    private FileReader fileReader= null;

    public MyThread(String fileName){
        try {
            fileReader = new FileReader(fileName);
            getWords();
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
    }
    @Override
    public void run(){
        System.out.println("words count = " + getWordCount() + " | " + "longest word and length = " + getLongest() + " " + getLongest().length()
                + " | " + "shortest word and length = " + getShortest() + " " + getShortest().length() + " | " + "average leangth = " + calculateAve());
    }
    private void getWords(){
        Scanner s = new Scanner(fileReader);
        HashSet<String> wordsSet = new HashSet<>();
        while (s.hasNext()){
            wordsSet.add(s.next());
        }
        words = wordsSet;
    }
    public int getWordCount(){
        return words.size();
    }
    public int calculateAve(){
        int sum = 0;
        for (String s : words){
            sum += s.length();
        }
        return sum / getWordCount();
    }
    public String getLongest(){
        int length = 0;
        String holder = null;
        for (String s : words){
            if (s.length() > length ) {
                length = s.length();
                holder = s;
            }
        }
        return holder;
    }
    public String getShortest(){
        int length = getLongest().length();
        String holder = null;
        for (String s : words){
            if (s.length() < length ) {
                length = s.length();
                holder = s;
            }
        }
        return holder;
    }
}
