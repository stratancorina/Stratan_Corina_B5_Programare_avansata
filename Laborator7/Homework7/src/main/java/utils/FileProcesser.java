package utils;

import java.io.*;
import java.util.Locale;

public class FileProcesser {
    public static void processDictionary(String acceptedChars, String pathToUnprocessed, String pathToProcessed){
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToUnprocessed));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToProcessed))){
            String word;
            while ((word = reader.readLine()) != null){
                word = word.toLowerCase(Locale.ROOT);
                if(hasOnlyValidChars(word, acceptedChars)){
                    if(word.length() == 1 &&  !word.equals("a") && !word.equals("i")) continue;
                    writer.write(word);
                    writer.newLine();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean hasOnlyValidChars(String word, String characters){
        for (char c:
             word.toCharArray()) {
            if(characters.indexOf(c) == -1) return false;
        }
        return true;
    }
}
