import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle; import android.widget.ListView;

import java.util.ArrayList;

import Classes.Languages;

public class Languages_Activity extends AppCompatActivity {
  ArrayList<Languages> languages;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_languages);
    init();

    ListView myLanguageList = findViewById(R.id.myLangList);
    LanguageListAdapter adapter =
            new LanguageListAdapter(this, languages);
    myLanguageList.setAdapter(adapter);
}

public void init(){
    languages = new ArrayList<>();
    languages.add(new Languages("Java","Джеймс Гослинг","(1995)"));
    languages.add(new Languages("C++","Бьёрн Страуструп","(1983)"));
    languages.add(new Languages("Python","Гвидо ван Россум","(1991)"));
    languages.add(new Languages("Kotlin","JetBrains","(2011)"));
    languages.add(new Languages("PHP","Расмус Лердорф","(1995)"));
    languages.add(new Languages("C#"," Андерс Хейлсберг","(1998)"));
    languages.add(new Languages("JavaScript","Брендан Эйх","(1996)"));
    languages.add(new Languages("Ruby","Мацумото Юкихиро","(1995)"));
    languages.add(new Languages("C","Деннис Ритчи","(1973)"));
    languages.add(new Languages("Swift","Крис Латтнер","(2010)"));
}
} 
