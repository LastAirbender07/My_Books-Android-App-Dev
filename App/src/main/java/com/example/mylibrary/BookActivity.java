package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_KEY_ID = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDesc, txtlDesc;
    private Button btnwtr, btnar, btncr, btnFav;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();
        /*String longDesc = "A boy fights evil master with mystic arts to save the whole world peace " +
                "An eleven year old boy, Harry Potter, who lives with his uncle, aunt and cousin, having lost his parents as an infant, " +
                "finds out that he’s a wizard (someone with magical powers) and attends Hogwarts School of Witchcraft and Wizardry. There he makes many " +
                "friends, the best of them being Ron Weasley and Hermione Granger. A new teacher at the school that year is possessed by Lord Voldemort, " +
                "the antagonist of the series, who partially lost his life when he failed to kill baby-Harry (difficult to explain in short). He tries to steal a " +
                "stone that’s guarded by the headmaster of the school, Albus Dumbledore, because it’s an elixir of life. It’s up to the trio to try and stop him.";

        Book book = new Book(1, "Harry Potter", "JK Rowling", 1250,
                "https://5.imimg.com/data5/SELLER/Default/2020/8/PE/PX/MO/54836353/harry-potter-books-collection-j-k-rowling-bloomsbury-publishing-500x500.jpg",
                "Fantasy Mystery", longDesc);*/

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_KEY_ID, -1);
            if (bookId != -1){
                Book incomingBook = Utlis.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);

                    handleAlreayRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                }
            }
        }
    }
    private void handleFavouriteBooks(Book book){
        ArrayList<Book> favouriteBooks = Utlis.getInstance().getFavouriteBooks();

        Boolean existInFavouriteBooks = false;

        for (Book b: favouriteBooks) {
            if (b.getId() == book.getId()){
                existInFavouriteBooks = true;
            }
        }
        if (existInFavouriteBooks){
            btnFav.setEnabled(false);
        }
        else {
            btnFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utlis.getInstance().addFavBooks(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavouriteBooksActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleCurrentlyReadingBooks(Book book){
        ArrayList<Book> CurrentlyReadingBook = Utlis.getInstance().getCurrentlyReadingBooks();

        Boolean existInCurrentlyReadingBook = false;

        for (Book b: CurrentlyReadingBook) {
            if (b.getId() == book.getId()){
                existInCurrentlyReadingBook = true;
            }
        }
        if (existInCurrentlyReadingBook){
            btncr.setEnabled(false);
        }
        else {
            btncr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utlis.getInstance().addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleWantToReadBooks(Book book){
        ArrayList<Book> wantToReadBooks = Utlis.getInstance().getWantToReadBooks();

        Boolean existInWantToReadBooks = false;

        for (Book b: wantToReadBooks) {
            if (b.getId() == book.getId()){
                existInWantToReadBooks = true;
            }
        }
        if (existInWantToReadBooks){
            btnwtr.setEnabled(false);
        }
        else {
            btnwtr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utlis.getInstance().addWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    private void handleAlreayRead(Book book){
        ArrayList<Book> alreadyReadBooks = Utlis.getInstance().getAlreadyReadBooks();

        Boolean existInAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks) {
            if (b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }
        if (existInAlreadyReadBooks){
            btnar.setEnabled(false);
        }
        else {
            btnar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utlis.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDesc.setText(book.getShortDesc());
        txtlDesc.setText(book.getLogDesc());
        Glide.with(this)
                .asBitmap().load(book.getImgUrl())
                .into(bookImage);
    }
    private void initViews(){
        txtBookName = findViewById(R.id.bname);
        txtAuthor = findViewById(R.id.bAut);
        txtPages = findViewById(R.id.bpg);
        txtDesc = findViewById(R.id.sdesc);
        txtlDesc = findViewById(R.id.ldesc);

        btnwtr = findViewById(R.id.btnwtr);
        btnar = findViewById(R.id.btnar);
        btncr = findViewById(R.id.btncr);
        btnFav = findViewById(R.id.btnFav);

        bookImage = findViewById(R.id.imagebook);
    }
}