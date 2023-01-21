package com.example.mylibrary;

import java.util.ArrayList;

public class Utlis {

    private  static Utlis instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;

    private Utlis() {
        if (null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks){
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favouriteBooks){
            favouriteBooks = new ArrayList<>();
        }
    }


    private void initData(){
        ArrayList<Book> books = new ArrayList<>();
        allBooks.add(new Book(1, "Harry Potter", "JK Rowling", 1250,
                "https://5.imimg.com/data5/SELLER/Default/2020/8/PE/PX/MO/54836353/harry-potter-books-collection-j-k-rowling-bloomsbury-publishing-500x500.jpg",
                "Fantasy Mystery", "A boy fights evil master with mystic arts to save the whole world peace An eleven year old boy, Harry Potter, who lives " +
                "with his uncle, aunt and cousin, having lost his parents as an infant, finds out that he’s a wizard (someone with magical powers) and attends Hogwarts School " +
                "of Witchcraft and Wizardry. There he makes many friends, the best of them being Ron Weasley and Hermione Granger. A new teacher at the school that year is " +
                "possessed by Lord Voldemort, the antagonist of the series, who partially lost his life when he failed to kill baby-Harry (difficult to explain in short). He " +
                "tries to steal a stone that’s guarded by the headmaster of the school, Albus Dumbledore, because it’s an elixir of life. It’s up to the trio to try and stop " +
                "him"));

        allBooks.add(new Book(2, "Mahabharatha", "Vedha Vyasa", 10000,
                "https://m.media-amazon.com/images/I/A1gMWKYqAHL.jpg",
                "Historical Human-values", "The battle between Dharma and Adharma from ancient India"));

    }

    public static Utlis getInstance() {
        if (null!= instance){
            return instance;
        }
        else{
            instance = new Utlis();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }
    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }
    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }
    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }
    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public  Book getBookById(int id){
        for (Book b: allBooks){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }
    public boolean addWantToRead(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addFavBooks(Book book){
        return favouriteBooks.add(book);
    }
    public boolean addToCurrentlyReading(Book book){
        return currentlyReadingBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book){
        return alreadyReadBooks.remove(book);
    }
    public boolean removeFromWantToRead(Book book){
        return wantToReadBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeFromFavourites(Book book){
        return favouriteBooks.remove(book);
    }
}
