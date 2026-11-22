package org.example;

import org.example.data.MovieManager;

public class Main {
    public static void main(String[] args) {
//        MovieManager.catalogo.forEach(System.out::println);
        MovieManager mm = new MovieManager();
        System.out.println("Ejercicio 1:  Las 5 películas mejor valoradas.");
        mm.showTop5Movies();
        System.out.println("================================================\n");
        System.out.println("Ejercicio 1.2: Buscar película por ID");
        mm.movieForId(6);
        System.out.println("================================================\n");
        System.out.println("Ejercicio 1.3: Saltar y obtener el título más largo");
        mm.skipLongest(1);
        System.out.println("================================================\n");
        System.out.println("Ejercicio 2: Número de películas por género");
        System.out.println(mm.movieForGenre());
        System.out.println("================================================\n");
        System.out.println("Ejercicio 3. Nota media por género");
        System.out.println(mm.rankingForGenre());
        System.out.println("================================================\n");
    }
}
