package movieınformationsınventory;

import java.io.FileWriter;
import java.io.IOException;

public class DoublyLinkedList
{
    private Node head;
    private Node tail;

    public Node getHead()
    {
        return head;
    }

    public void setHead(Node head)
    {
        this.head = head;
    }

    public Node getTail()
    {
        return tail;
    }

    public void setTail(Node tail)
    {
        this.tail = tail;
    }

    // Method to search the movie user entered
    public void findMovie(String nameToFind)
    {
        // Assigning a temporary node to travel the doubly linked list
        Node temp = head;
        int counter = 0;
        while (temp != null)
        {
            if (temp.getMovie().getMovieName().equalsIgnoreCase(nameToFind))
            {
                System.out.println(temp.getMovie());
                counter++;
            }
            temp = temp.getNext();
        }
        if (counter == 0)
        {
            System.out.println("the movie you've searched is not on the list");
        }
    }

    public void removeMovie(String nameToRemove)
    {
        // Assigning a temporary node to travel the doubly linked list
        Node temp = head;
        int counter =0;
        while (temp != null)
        {
            if (temp.movie.getMovieName().equalsIgnoreCase(nameToRemove))
            {
                counter++;
                if (temp == head)
                {
                    head = temp.getNext();
                    if (head != null)
                    {
                        head.setPrev(null);
                    }
                    else
                    {
                        tail = null;
                    }
                }
                else if (temp == tail)
                {
                    tail = temp.getPrev();
                    tail.setNext(null);
                }
                else
                {
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                }
                break;
            }
            temp = temp.getNext();
        }
        if (counter == 0)
        {
            System.out.println("the movie you've wanted to remove is not on the list");
        } 
    }

    public void addMovie(Movie movie)
    {
        // Assigning a temporary node to travel the doubly linked list
        Node newNode = new Node(movie);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            Node currentNode = head;
            while (currentNode != null && currentNode.movie.getYearOfMovie() <= movie.getYearOfMovie())
            {
                if (currentNode.movie.getYearOfMovie() == movie.getYearOfMovie() && currentNode.movie.getMovieName().compareTo(movie.getMovieName()) > 0)
                {
                    break;
                }
                currentNode = currentNode.getNext();
            }

            if (currentNode == head)
            {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
            else if (currentNode == null)
            {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            else
            {
                newNode.setNext(currentNode);
                newNode.setPrev(currentNode.getPrev());
                currentNode.getPrev().setNext(newNode);
                currentNode.setPrev(newNode);
            }
        }
    }

    public void displayBefore2000()
    {
        int counter = 0;
        // Assigning a temporary node to travel the doubly linked list
        Node temp = head;
        while (temp != null && temp.getMovie().getYearOfMovie() < 2000)
        {
            System.out.println(temp.movie + "\n");
            counter++;
            temp = temp.next;
        }
        if (counter == 0)
        {
            System.out.println("there aren't any movies before 2000 on the list");
        }
    }

    public void displayMovies()
    {
        // Assigning a temporary node to travel the doubly linked list from start to end
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.movie + "\n");
            temp = temp.next;
        }
    }

    public void displayMoviesReverse()
    {
        // Assigning a temporary node to travel the doubly linked list from end to start
        Node temp = tail;
        while (temp != null)
        {
            System.out.println(temp.movie + "\n");
            temp = temp.prev;
        }
    }

    public void saveMoviesToFile() throws IOException {
        // Assigning a temporary node to travel the doubly linked list
        Node temp = head;
        try (FileWriter  movieWriter = new FileWriter("bilgiler2.txt"))
        {
            while (temp != null)
            {
                movieWriter.write(temp.movie.getYearOfMovie()+", ");
                movieWriter.write(temp.movie.getMovieName()+", ");
                movieWriter.write(temp.movie.getGenreOfMovie()+", ");
                movieWriter.write(temp.movie.getDirector()+", {");
                movieWriter.write(temp.movie.getActorsOfMovie().toString()+"}"+"\n");
                temp = temp.next;
            }
        }
    }

    private class Node
    {
        Movie movie;
        private Node next;
        private Node prev;

        public Movie getMovie() {
            return movie;
        }

        public void setMovie(Movie movie) {
            this.movie = movie;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node getPrev()
        {
            return prev;
        }

        public void setPrev(Node prev)
        {
            this.prev = prev;
        }

        public Node()
        {
            this.movie = null;
            this.prev = null;
            this.next = null;
        }
        public Node(Movie movie)
        {
            this.movie = movie;
        }

        public Node(Movie movie, Node next, Node prev)
        {
            this.movie = movie;
            this.next = next;
            this.prev = prev;
        }
    }
}
