package com.example.listtest;

        import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.appcompat.app.AlertDialog;import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;import android.content.Intent;import android.os.Bundle;import android.util.Log;import android.view.Menu;import android.view.MenuInflater;import android.view.MenuItem;import android.view.View;import android.widget.AdapterView;import android.widget.ListView;import android.widget.Toast;

        import java.util.ArrayList;

        import Classes.Films;import Classes.Languages;

public class Languages_Activity extends AppCompatActivity {
    ArrayList<Languages> languages;
    private static final int ADD_LANGUAGES = 1;
    LanguageListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        init();

        ListView myLanguageList = findViewById(R.id.myLangList);
        adapter =
                new LanguageListAdapter(this, languages);
        myLanguageList.setAdapter(adapter);

        myLanguageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = (int) view.getTag();
                for (Languages lang : languages) {
                    if (lang.getId() == id) {
                        Intent intent = new Intent(getApplicationContext(),
                                Languages.class);
                        intent.putExtra("language", lang);
                        startActivityForResult(intent, 2);
                        break;
                    }
                }

            }
        });

        myLanguageList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                createDialog(view);
                return true;
            }
        });

    }

    public void createDialog(View v) {
        Log.e("tag", "Dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы хотите удалить язык?");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int Lid = (int) v.getTag();
                Languages delete = null;
                for (Languages l : languages) {
                    if (l.getId() == Lid) {
                        delete = l;
                        break;
                    }
                }
                if (delete != null) {
                    languages.remove(delete);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Вы удалили язык", Toast.LENGTH_LONG).show();
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
        inflater.inflate(R.menu.languages_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAddLanguages) {
            Intent intent = new Intent(this, addLanguages.class);
            startActivityForResult(intent, ADD_LANGUAGES);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_LANGUAGES) {
            if (resultCode == RESULT_OK) {
                Languages lang = (Languages) data.getExtras().get("language");
                this.languages.add(lang);
                adapter.notifyDataSetChanged();
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Languages lang = (Languages) data.getExtras().get("language");
                for (Languages languages1 : languages) {
                    if (languages1.getId() == languages1.getId()) {
                        languages1.setTitle(languages1.getTitle());
                        languages1.setYear(languages1.getYear());
                        languages1.setCreator(languages1.getCreator());
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void init() {
        languages = new ArrayList<>();
        languages.add(new Languages("Java", "Джеймс Гослинг", "(1995)"));
        languages.add(new Languages("C++", "Бьёрн Страуструп", "(1983)"));
        languages.add(new Languages("Python", "Гвидо ван Россум", "(1991)"));
        languages.add(new Languages("Kotlin", "JetBrains", "(2011)"));
        languages.add(new Languages("PHP", "Расмус Лердорф", "(1995)"));
        languages.add(new Languages("C#", " Андерс Хейлсберг", "(1998)"));
        languages.add(new Languages("JavaScript", "Брендан Эйх", "(1996)"));
        languages.add(new Languages("Ruby", "Мацумото Юкихиро", "(1995)"));
        languages.add(new Languages("C", "Деннис Ритчи", "(1973)"));
        languages.add(new Languages("Swift", "Крис Латтнер", "(2010)"));
    }
