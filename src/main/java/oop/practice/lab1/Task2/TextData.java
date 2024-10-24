package oop.practice.lab1.Task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;


    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        this.numberOfVowels = countVowels(text);
        this.numberOfConsonants = countConsonants(text);
        this.numberOfLetters = text.replaceAll("[^a-zA-Z]", "").length();
        this.numberOfSentences = text.split("[.!?]").length;
        this.longestWord = findLongestWord(text);
    }


    private int countVowels(String text) {
        return text.replaceAll("[^AEIOUaeiou]", "").length();
    }


    private int countConsonants(String text) {
        return text.replaceAll("[^BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]", "").length();
    }

    private String findLongestWord(String text) {
        String[] words = text.split("\\s+");
        String longest = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        return longest;
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void displayData() {
        System.out.println("File Name: " + fileName);
        System.out.println("Number of Vowels: " + numberOfVowels);
        System.out.println("Number of Consonants: " + numberOfConsonants);
        System.out.println("Number of Letters: " + numberOfLetters);
        System.out.println("Number of Sentences: " + numberOfSentences);
        System.out.println("Longest Word: " + longestWord);
    }
}
