
package movieınformationsınventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieInventory
{
    public static void main(String[] args)
    {
        // Create a doubly linked list to store the movies
        DoublyLinkedList moviesDLL = new DoublyLinkedList();
        // Load movies from file to the doubly linked list
        loadMoviesFromFile(moviesDLL);

        boolean continueToProg = true;
        int choice;

        while (continueToProg)
        {
            Scanner keyboard = new Scanner(System.in);
            displayMenu();
            choice = keyboard.nextInt();

            switch (choice) {
                case ADD : {
                    // Add a movie to the list
                    String allInfo;
                    System.out.println("enter the movie you want to add to the list:");
                    Scanner scanner2 = new Scanner(System.in);
                    allInfo = scanner2.nextLine();
                    splitInfos(allInfo, moviesDLL);
                    break;
                }
                case SEARCH : {
                    // Search for a movie in the list
                    String movieToFind;
                    System.out.println("enter the movie you want to find in the list: ");
                    Scanner scanner4 = new Scanner(System.in);
                    movieToFind = scanner4.nextLine();
                    moviesDLL.findMovie(movieToFind);
                    break;
                }
                case REMOVE :{
                    // Remove a movie from the list
                    String movieToRemove;
                    System.out.println("enter the movie you want to remove from the list: ");
                    Scanner scanner3 = new Scanner(System.in);
                    movieToRemove = scanner3.nextLine();
                    moviesDLL.removeMovie(movieToRemove);
                    break;
                }
                case PRINTFROMHEAD :
                    moviesDLL.displayMovies(); // Print movies of the list from head to tail
                    break;
                case PRINTFROMTAIL :
                    moviesDLL.displayMoviesReverse(); // Print movies of the list from tail to head
                    break;
                case PRINTBEFORE2000 :
                    moviesDLL.displayBefore2000(); // Print movies made before 2000
                    break;
                case EXITSAVE :
                {
                    // Save movies to the file
                    try {
                        moviesDLL.saveMoviesToFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    // Exit the program
                    continueToProg = false;
                }
            }
        }
    }

    private static void splitInfos(String allInformations, DoublyLinkedList DLL)
    {
        DoublyLinkedList moviesDLL = DLL;
        String allInfo = allInformations;
        // Determining the indexes of curly braces to use them as parameters to substring()
        int initialIndex = allInfo.indexOf("{") + 1;
        int finalIndex = allInfo.indexOf("}");
        // Cutting out the actors' information from other movie info using substring()
        String actorInfos = allInfo.substring(initialIndex, finalIndex);
        String[] eachActor = actorInfos.split("\\)");
        // Cutting out the other movie information using substring()
        String movieInfos = allInfo.substring(0, initialIndex - 1);
        String[] movieInfosArr = movieInfos.split(", ");
        // Creating an array list to keep actor information
        ArrayList<Actor> actorArrList = new ArrayList<>();


        for (int i=0; i < eachActor.length; i++)
        {
            // Assigning the actor information as an Actor class object to the array list
            eachActor[i]=eachActor[i].substring(1);
            String[] eachActorInfo = eachActor[i].split(", ");
            Actor actor = new Actor(eachActorInfo[0], eachActorInfo[1], eachActorInfo[2]);

            actorArrList.add(actor);

        }
        // Assigning all the movie information as a Movie class object to the doubly linked list
        Movie movie = new Movie(movieInfosArr[1], movieInfosArr[2], Integer.parseInt(movieInfosArr[0]), movieInfosArr[3], actorArrList);
        moviesDLL.addMovie(movie);
    }

    private static void  loadMoviesFromFile(DoublyLinkedList moviesDLList)
    {
        Scanner scan;
        DoublyLinkedList moviesDLL = moviesDLList;
        // Scanning the data from txt file while checking the case file-not-found
        try
        {
            scan = new Scanner(new File("bilgiler.txt"));
        }

        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        while (scan.hasNextLine())
        {
            String allInfo = scan.nextLine();
            // Calling the method to split information read from the file
            splitInfos(allInfo, moviesDLL);

            allInfo = null;
        }
        scan.close();
    }

    private static final int ADD=1;
    private static final int SEARCH=2;
    private static final int REMOVE=3;
    private static final int PRINTFROMHEAD=4;
    private static final int PRINTFROMTAIL=5;
    private static final int PRINTBEFORE2000=6;
    private static final int EXITSAVE=7;


    private static void displayMenu() {//Displays the program menu to the user when it is necessary.
        System.out.println("----- Movie Inventory -----");
        System.out.println("1) Add a movie");
        System.out.println("2) Search for a movie");
        System.out.println("3) Remove a movie");
        System.out.println("4) Print movies (from head to tail)");
        System.out.println("5) Print movies (from tail to head)");
        System.out.println("6) Print movies before 2000");
        System.out.println("7) Exit and save");}
}
