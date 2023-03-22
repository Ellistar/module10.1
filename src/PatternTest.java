import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- ]?\\d{3}-?\\d{4}$");

        File file = new File("src/file.txt");
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String res = scanner.nextLine();
                    Matcher matcher = pattern.matcher(res);
                    boolean answer = matcher.matches();
                    if(answer) {
                        System.out.println(res);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
