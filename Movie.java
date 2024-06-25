package movieınformationsınventory;
import java.util.ArrayList;

public class Movie {
    // Private member variables to store movie details.
    private String movieName;
    private String genreOfMovie;
    private int yearOfMovie;
    private String director;
    private ArrayList <Actor> actorsOfMovie; // Holds the actors' information in a movie.

    // Default constructor initializes member variables to default value.
    public Movie()
    {
        this.movieName = null;
        this.genreOfMovie = null;
        this.yearOfMovie = 0;
        this.director = null;
        this.actorsOfMovie = new ArrayList<>();
    }
    // Parameterized constructor to set movie details.
    public Movie(String name,String genre,int year,String directtorOfMovie, ArrayList<Actor> actors )
    {
        this.movieName = name;
        this.genreOfMovie = genre;
        this.yearOfMovie = year;
        this.director = directtorOfMovie;
        this.actorsOfMovie = actors;
    }
    // Copy constructor.
    public Movie(Movie other){
        this.movieName = other.movieName;
        this.genreOfMovie = other.genreOfMovie;
        this.yearOfMovie = other.yearOfMovie;
        this.director = other.director;
        this.actorsOfMovie = new ArrayList<>(other.getActorsOfMovie());
    }
    // Getter for movieName.
    public String getMovieName() {
        return movieName;
    }
    // Setter for movieName.
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    // Getter for genreOfMovie.
    public String getGenreOfMovie() {
        return genreOfMovie;
    }
    // Setter for genreOfMovie.
    public void setGenreOfMovie(String genreOfMovie) {
        this.genreOfMovie = genreOfMovie;
    }
    // Getter for yearOfMovie.
    public int getYearOfMovie() {
        return yearOfMovie;
    }
    // Setter for yearOfMovie.
    public void setYearOfMovie(int yearOfMovie) {
        this.yearOfMovie = yearOfMovie;
    }
    // Getter for Director.
    public String getDirector() {
        return director;
    }
    // Setter for Director.
    public void setDirector(String director) {
        this.director = director;
    }
    // Getter for actorsOfMovie
    public ArrayList <Actor> getActorsOfMovie() {
        return actorsOfMovie;
    }
    // Setter for actorsOfMovie
    public void setActorsOfMovie(ArrayList <Actor> actorsOfMovie) {
        this.actorsOfMovie = actorsOfMovie;
    }
    // Overriding the toString() method to  create a string representation of an Movie object.
    @Override
    public String toString(){
        return "Movie Name: " + movieName + " Movie Year: " + yearOfMovie + " Genre: "+genreOfMovie+ " Director Of Movie: "+ director+
                "\nActors of movie: " + actorsOfMovie;
    }
}
