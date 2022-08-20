package com.example.listtest;

        import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.appcompat.app.AlertDialog;import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;import android.content.Intent;import android.os.Bundle;import android.os.Parcelable;import android.view.Menu;import android.view.MenuInflater;import android.view.MenuItem;import android.view.View;import android.widget.AdapterView;import android.widget.ArrayAdapter;import android.widget.ListView;import android.widget.Toast;

        import java.io.Serializable;import java.util.ArrayList;

        import Classes.Books;import Classes.Films;

public class Books_Activity extends AppCompatActivity {

    ArrayList<Books> books;
    myBookListAdapter book;
    private static final int ADD_BOOKS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        init();

        ListView myBookList = findViewById(R.id.myBookList);
        book =
                new myBookListAdapter(this, books);
        myBookList.setAdapter(book);


        myBookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int Bid = (int) view.getTag();
                for (Books b : books) {
                    if (b.getId() == Bid) {
                        Intent intent = new Intent(getApplicationContext(),
                                Books.class);
                        intent.putExtra("book", b);
                        startActivityForResult(intent, 2);
                        break;
                    }
                }
            }
        });


        myBookList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                createDialog(view);
                return true;
            }
        });

        myBookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int Bid = (int) view.getTag() - 1;
                String value = String.valueOf(books.get(Bid).getTitle());
                String value2 = String.valueOf(books.get(Bid).getAuthor());
                String value3 = String.valueOf(books.get(Bid).getYear());
                Intent intent = new Intent(getApplicationContext(), addBooks.class);
                intent.putExtra("title", value);
                intent.putExtra("author", value2);
                intent.putExtra("year", value3);
                startActivity(intent);
            }
        });
    }

    public void createDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы хотите удалить книгу?");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = (int) v.getTag();
                Books delete = null;
                for (Books b : books) {
                    if (b.getId() == id) {
                        delete = b;
                        break;
                    }
                }
                if (delete != null) {
                    books.remove(delete);
                    book.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Вы удалили книгу", Toast.LENGTH_LONG).show();
                }
            }
        };
        builder.setPositiveButton("Yes", listener);
        builder.setNeutralButton("Cancel", null);
        builder.setNegativeButton("No", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.books_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAddBooks) {
            Intent intent = new Intent(this, addBooks.class);
            startActivityForResult(intent, ADD_BOOKS);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_BOOKS) {
            if (resultCode == RESULT_OK) {
                Books b = (Books) data.getExtras().get("book");
                this.books.add(b);
                book.notifyDataSetChanged();
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Books b = (Books) data.getExtras().get("book");
                for (Books books1 : books) {
                    if (books1.getId() == books1.getId()) {
                        books1.setTitle(books1.getTitle());
                        books1.setYear(books1.getYear());
                        books1.setAuthor(books1.getAuthor());
                        book.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void init() {
        books = new ArrayList<>();
        books.add(new Books("Мартин Иден", "(1908)", "Джек Лондон"));
        books.add(new Books("1984", "(1949)", "Джордж Оруэл"));
        books.add(new Books("Процесс", "(1925)", "Франц Кафка"));
        books.add(new Books("451^ по Фаренгейту", "(1953)", "Рэй Бредбери"));
        books.add(new Books("Убить пересмешника", "(1960)", "Харпер Ли"));
        books.add(new Books("Под колесом", "(1906)", "Герман Гессе"));
        books.add(new Books("Финансист", "(1912)", "Теодор Драйзер"));
        books.add(new Books("Титан", "(1914)", "Теодор Драйзер"));
        books.add(new Books("Стоик", "(1947)", "Теодор Драйзер"));
        books.add(new Books("Искусство быть", "(1976)", "Эрих Фром"));
    }
