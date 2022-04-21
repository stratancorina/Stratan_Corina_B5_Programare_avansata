package com;

import data.structures.PrefixTree;
import game.components.Bag;
import game.components.Board;
import game.components.Timer;
import utils.FileProcesser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Bag tileBag = new Bag();
        tileBag.fillBag(
                "abcdefghijklmnopqrstuvwxyz",
                List.of(1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10),
                List.of(9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 1, 1)
                );

        PrefixTree wordDictionary = new PrefixTree();
        wordDictionary.loadFromFile("src/main/resources/processedDictionary.txt");

        Board gameBoard = new Board(tileBag, wordDictionary);

        gameBoard.addPlayer("Mary");
        gameBoard.addPlayer("Anna");
        gameBoard.addPlayer("Jane");

        Timer timer = new Timer(7000);

        gameBoard.setTimeDaemon(timer);

        try{
            gameBoard.startGame();
        }
        catch(InterruptedException e){
            System.out.println("Error at thread join");
        }
    }
}
