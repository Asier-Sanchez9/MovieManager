package org.example;

import org.example.data.MovieManager;

public class Main {
    public static void main(String[] args) {
//        MovieManager.catalogo.forEach(System.out::println);
        MovieManager mm = new MovieManager();
        mm.showTop5Movies();
    }
}
