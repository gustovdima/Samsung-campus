package com.example.listtest;

        import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.appcompat.app.AlertDialog;import androidx.appcompat.app.AppCompatActivity;

        import android.app.Dialog;import android.content.DialogInterface;import android.content.Intent;import android.icu.text.CaseMap;import android.os.Bundle;import android.util.Log;import android.view.Menu;import android.view.MenuInflater;import android.view.MenuItem;import android.view.View;import android.widget.AdapterView;import android.widget.ListView;import android.widget.Toast;

        import java.util.ArrayList;import Classes.Films;

public class Films_Activtity extends AppCompatActivity {
    ArrayList<Films> films;
    myFilmListAdapter adapter;

    private static final int ADD_FILM_REQUEST_CODE = 2;
    private static final int lIST_CHANGE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films_activtity);

        init();

        ListView myFList = findViewById(R.id.myFilmList);
        adapter =
                new myFilmListAdapter(this, films);
        myFList.setAdapter(adapter);


        myFList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = (int) view.getTag();
                for (Films f : films) {
                    if (f.getId() == id) {
                        Intent intent = new Intent(getApplicationContext(),
                                Films.class);
                        intent.putExtra("film", f);
                        startActivityForResult(intent, 2);
                        break;
                    }
                }
                Toast.makeText(getApplicationContext(),
                        "Item clicked: " + id, Toast.LENGTH_LONG).show();
            }
        });


        myFList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                createDialog(view);
                return true;
            }
        });


        myFList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = (int) view.getTag() - 1;
                String value = String.valueOf(films.get(id).getTitle());
                String value2 = String.valueOf(films.get(id).getDirector());
                String value3 = String.valueOf(films.get(id).getYear());
                Log.d("Films_activtiy", value);
                Intent intent = new Intent(getApplicationContext(), addFilms.class);
                intent.putExtra("title", value);
                intent.putExtra("director", value2);
                intent.putExtra("year", value3);
                startActivity(intent);
            }
        });
    }

    public void createDialog(View v) {
        Log.e("tag", "Dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы хотите удалить фильм?");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = (int) v.getTag();
                Films delete = null;
                for (Films f : films) {
                    if (f.getId() == id) {
                        delete = f;
                        break;
                    }
                }
                if (delete != null) {
                    films.remove(delete);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Вы удалили фильм", Toast.LENGTH_LONG).show();
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
        inflater.inflate(R.menu.films_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAddFilm) {
            Intent intent = new Intent(this, addFilms.class);
            startActivityForResult(intent, ADD_FILM_REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_FILM_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Films f = (Films) data.getExtras().get("film");
                this.films.add(f);
                adapter.notifyDataSetChanged();
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Films f = (Films) data.getExtras().get("film");
                for (Films films1 : films) {
                    if (films1.getId() == films1.getId()) {
                        films1.setTitle(films1.getTitle());
                        films1.setYear(films1.getYear());
                        films1.setDirector(films1.getDirector());
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void init() {
        films = new ArrayList<>();
        films.add(new Films("Зеленая миля ", "(1999)", "Фрэнк Дарабонт"));
        films.add(new Films("Форрест Гамп", "(1994)", "Роберт Земекис"));
        films.add(new Films("1 + 1", "(2011)", "Оливье Накаш"));
        films.add(new Films("В погоне за счастьем", "(2001)", "Габриэле Муччино"));
        films.add(new Films("Матрица", "(1999)", "Лана Вачовски"));
        films.add(new Films("Джентельмены", "(2019)", "Гай Ричи"));
        films.add(new Films("Зелёная книга", "(2018)", "Питер Фаррелли"));
        films.add(new Films("Волк с Уолл-стрит", "(2013)", "Мартин Скорсезе"));
        films.add(new Films("Фокус", "(2014)", "Глен Фикарра"));
        films.add(new Films("Основатель", "(2016)", "Джон Ли Хэнкок"));
    }
