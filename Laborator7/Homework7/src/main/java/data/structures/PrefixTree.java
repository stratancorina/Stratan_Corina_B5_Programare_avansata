package data.structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void loadFromFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String word;
            while ((word = reader.readLine()) != null && !word.isEmpty()){
                this.insert(word);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }


    public synchronized String findWord(List<Character> characters){
        return findWord(characters, root, "");
    }

    private String findWord(List<Character> characters , TrieNode current, String cumulated){
        if(current == null) throw new IllegalArgumentException("Node must not be empty");
        if(current.isEndOfWord()) return cumulated;
        if(current.getChildren().isEmpty()) return null;

        List<String> wordsFound = new ArrayList<String>();

        for (Character c:
             characters) {
            if(current.getChildren().get(c) != null){
                List<Character> remaining = new ArrayList<>(characters);
                remaining.remove(c);
                String word = findWord(remaining, current.getChildren().get(c), cumulated + c);
                if(word != null) wordsFound.add(word);
            }
        }
        if(wordsFound.size() == 0) return null;

        return wordsFound.stream().max((String a, String b) -> Integer.compare(a.length(), b.length())).get();
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }
}
