package com.game;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Game {
   static List<Character>  list= List.of('a','s','w','d');
    public static void main(String[] args) throws IOException {
        char c= (char) System.in.read();
       if(list.contains(c)) {
           System.out.println("correct symbol, let's game");
       }
    }
}
