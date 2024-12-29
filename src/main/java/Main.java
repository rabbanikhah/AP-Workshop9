import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            threads.add(new MyThread("workshop9_files\\file_" + (i+1) + ".txt"));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread number " + (i+1));
            threads.get(i).start();
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}