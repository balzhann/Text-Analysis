import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Clean cl = new Clean();
        File file = new File("Pride&Prejudice.txt");
        String text = cl.cleanText(file);
        System.out.println(text);

        System.out.println(cl.longestWord(text));
        System.out.println(cl.wordFrequency(text));
        cl.howManyStartsWith(text);
        cl.palindromes(text);




    }
}
