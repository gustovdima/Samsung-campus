androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle; import android.widget.ListView;

import java.util.ArrayList;

import Classes.Books;

public class Books_Activity extends AppCompatActivity {

ArrayList<Books> books;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_books);
    init();

    ListView myBookList = findViewById(R.id.myBookList);
    myBookListAdapter book =
            new myBookListAdapter(this, books);
    myBookList.setAdapter(book);
}

public void init(){
    books = new ArrayList<>();
    books.add(new Books("Мартин Иден","(1908)","Джек Лондон"));
    books.add(new Books("1984","(1949)","Джордж Оруэл"));
    books.add(new Books("Процесс","(1925)","Франц Кафка"));
    books.add(new Books("451^ по Фаренгейту","(1953)","Рэй Бредбери"));
    books.add(new Books("Убить пересмешника","(1960)","Харпер Ли"));
    books.add(new Books("Под колесом","(1906)","Герман Гессе"));
    books.add(new Books("Финансист","(1912)","Теодор Драйзер"));
    books.add(new Books("Титан","(1914)","Теодор Драйзер"));
    books.add(new Books("Стоик","(1947)","Теодор Драйзер"));
    books.add(new Books("Искусство быть","(1976)","Эрих Фром"));
}
