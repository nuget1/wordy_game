package server;

import wordy_idl.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InGameServantImpl extends GameServantPOA {

    private static final String FILENAME = "data/words.txt";
    @Override
    public void submitWord(int userId, String word) throws InvalidWordException, WordLengthException, WrongLetterException {

    }

    @Override
    public int checkPlayerCount() {
        return 0;
    }

    @Override
    public String generateRandomLetters() {
        Random random = new Random();
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int numVowels = random.nextInt(3) + 5; // generate a random number of vowels between 5 and 7
        int numConsonants = 17 - numVowels;
        List<Character> letters = new ArrayList<>();
        // add vowels and consonants to the list
        for (int i = 0; i < numVowels; i++) {
            letters.add(vowels.charAt(random.nextInt(vowels.length())));
        }
        for (int i = 0; i < numConsonants; i++) {
            letters.add(consonants.charAt(random.nextInt(consonants.length())));
        }
        // shuffle the letters
        Collections.shuffle(letters, random);
        // create the final string
        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public boolean checkWord(String word, String randomLetters) throws InvalidWordException, WordLengthException, WrongLetterException  {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (char c : word.toCharArray()) {
            if (randomLetters.indexOf(c) == -1) {
                return false;

            }
        }
        return false;
    }

}
