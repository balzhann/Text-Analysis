import java.io.*;

import java.util.*;

public class Clean {
    public static String cleanText(File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        String res = "";
        String result = "";
        try {
            Scanner inp = new Scanner(new FileInputStream(file));
            while (inp.hasNext()) {
                list.add(inp.next());
            }
            inp.close();
            res = res.replaceAll("[^\\x00-\\x7F]", "");
            res = res.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
            res = res.replaceAll("\\p{C}", "");
            res = res.replaceAll("[@#$%^&*_+=]", "");
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i) + " ";
            }

            result = res.trim().toLowerCase();


        } catch (Exception e) {
            System.out.println("Error reading " + file.getAbsolutePath());
        }
        return result;

    }

    public static void longestWord(String text) {
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        int max = 0, index = 0, i = 0;
        while (words.length > i) {
            if (words[i].length() > max) {
                max = words[i].length();
                index = i;
            }
            i++;
        }
        System.out.println("The longest word is \"" + words[index] + "\". Its length is: " + max);
    }

    public static void wordFrequency(String text) {
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word you want to count in a text: ");
        String w = input.nextLine();
        w = w.toLowerCase();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w)) {
                count++;
            }
        }
        System.out.println("The word \"" + w + "\" is repeated " + count + " times.");
    }

    public static void howManyStartsWith(String text) {
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter with which the word begins: ");
        String w = input.next();
        w = w.toLowerCase();
        System.out.println("These words start with " + w + " letter (removing repetitions):");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(w) && (!list.contains(words[i]))) {
                list.add(words[i]);
                count++;
                System.out.print(words[i] + " ");
            }

        }
        System.out.println();
        System.out.println("Counted: " + count);

    }

    public static void palindromes(String text) {
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("There is a list of palindromes of this text (removing repetitions): ");
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i]) && (words[i].length() > 2) && (!list.contains(words[i]))) {
                list.add(words[i]);
                count++;
                System.out.print(words[i] + " ");
            }

        }
        System.out.println();
        System.out.println("Counted palindromes: " + count);
    }

    public static boolean isPalindrome(String word) {
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

    public static void anagrams(String text) {
        text = text.replaceAll("[^a-zA-Z && [^\\s]]", "");
        String[] words = text.split(" ");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> anagrams = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!list.contains(words[i])) {
                list.add(words[i]);
            }
        }
        char[] word1, word2;
        for (int k = 0; k < list.size(); k++) {
            for (int j = k + 1; j < list.size(); j++) {
                word1 = list.get(k).toCharArray();
                word2 = list.get(j).toCharArray();
                Arrays.sort(word1);
                Arrays.sort(word2);
                if (Arrays.equals(word1, word2)) {
                    if (!anagrams.contains(list.get(k))) {
                        anagrams.add(list.get(k));
                        anagrams.add(list.get(j));
                    } else {
                        anagrams.add(list.get(j));
                    }
                }

            }
        }
        System.out.println("There is a list of anagrams: " + anagrams);

    }
}
