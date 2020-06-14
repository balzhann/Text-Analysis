import java.io.*;

import java.util.*;

public class Clean {
    public static String cleanText(File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        String res = "";
        try {
            Scanner inp = new Scanner(new FileInputStream(file));
            while (inp.hasNext()) {
                list.add(inp.next());
            }
            inp.close();

        } catch (Exception e) {
            System.out.println("Error reading " + file.getAbsolutePath());
        }

        for(int i = 0; i< list.size(); i++){
            res += list.get(i) + " ";
        }


        res= res.replaceAll("[^\\x00-\\x7F]", "");


        res = res.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        res =res.replaceAll("\\p{C}", "");

        res = res.replaceAll("[@#$%^&*_+=]", "");
        String result = res.trim().toLowerCase();
        return result;

        }
        public static String longestWord(String text){
           text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");

            String[] words = text.split(" ");
            int max = 1;
            int i = 0;
            while(words.length > i){
                if(words[i].length() > max){
                    max = words[i].length();
                }
                i++;
            }

            return words[max];
        }
        public static int wordFrequency(String text){
            text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
            String[] words = text.split(" ");
            int count = 0;
            Scanner input= new Scanner(System.in);
            System.out.print("Enter a word you want to count in a text: ");
            String w = input.nextLine();
            for(int i = 0; i< words.length; i++){
                if(words[i].equals(w)){
                    count++;
                }

            }
            return count;
        }
        public static void howManyStartsWith(String text){
            text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
            String[] words = text.split(" ");
            int count = 0;
            Scanner input= new Scanner(System.in);
            System.out.print("Enter a letter with which the word begins: ");
            String w = input.next();
            w = w.toLowerCase();
            System.out.println("These words start with " + w + " letter.");
            for(int i = 0; i< words.length; i++){
                if(words[i].startsWith(w)){
                    count++;
                    System.out.print(words[i] + " ");
                }

            }
            System.out.println();
            System.out.println("Counted: "+ count);

    }
    public static void palindromes(String text){
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        int count = 0;
        for(int i = 0; i< words.length; i++){
            if(isPalindrome(words[i]) && (words[i].length() > 2)){
                count++;
                System.out.print(words[i] + " ");
            }

        }
        System.out.println();
        System.out.println("Counted palindromes: "+ count);
    }
    public static  boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

}