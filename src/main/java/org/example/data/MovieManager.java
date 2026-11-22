package org.example.data;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieManager {

    public static List<Movie> catalogo;

    static {
        try {
            catalogo = MovieAPI.obtenerPeliculas();
        } catch (IOException  | InterruptedException e) {
            System.err.println("Fallo en la API" + e);
        }
    }

    public List<Movie> getTopMovies(int limit){

        return catalogo.stream()
                .sorted(Comparator.comparing((Movie m) -> m.getStars()).reversed())
                .limit(limit)
                .toList()
                //.collect(Collectors.toList())
                ;
    }

    public void showTop5Movies(){
        getTopMovies(5)
                .forEach(m -> System.out.println(m.getTitle() + "---" + m.getStars()));
    }

//    public String[] moviesForYears(){
//
//
//        Map<Integer,List<Movie>> movies = catalogo.stream()
//                .collect(Collectors.groupingBy(
//                        m -> m.getYear()
//                )).forEach((Movie m) -> System.out.println(m.getImage_url()));
//
//        movies.forEach((Movie m) -> System.out.println(m.getImage_url()));
//    }

    public void movieForId(int id){

        catalogo.stream()
                .filter(m -> m.getId() == id)
                .forEach(m -> System.out.println(id + ": " + m.getTitle()));
    }

    public void skipLongest(int salto){

        catalogo.stream()
                .skip(salto)
                .sorted((a,b) ->  b.getTitle().length() - a.getTitle().length())
                .limit(1)
                .forEach(m -> System.out.println(m.getTitle()));
    }

    public Map<String, Long> movieForGenre(){


        return catalogo.stream()
                .flatMap(m -> Arrays.stream(m.getGenre()))
                .toList()
                .stream().collect(Collectors
                .groupingBy(Function.identity(),Collectors.counting()));

    }

        public Map<String, Double> rankingForGenre(){


            return catalogo.stream()
                    .flatMap(m -> Arrays.stream(m.getGenre())
                            .map(g -> Map.entry(g, m.getStars())))
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.averagingDouble(entry -> entry.getValue())
                    ));
        }
}
