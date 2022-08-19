public class Films_Activtity extends AppCompatActivity { 
  ArrayList<Films> films;
  myFilmListAdapter adapter;

private static final int FILM_REQUEST_CODE = 1;
private static final int ADD_FILM_REQUEST_CODE = 2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_films_activtity);

    init();

    ListView myFList = findViewById(R.id.myFilmList);
    adapter =
            new myFilmListAdapter(this, films);
    myFList.setAdapter(adapter);
}



public void init(){
    films = new ArrayList<>();
    films.add(new Films("Зеленая миля ","(1999)","Фрэнк Дарабонт"));
    films.add(new Films("Форрест Гамп","(1994)","Роберт Земекис"));
    films.add(new Films("1 + 1","(2011)","Оливье Накаш"));
    films.add(new Films("В погоне за счастьем","(2001)","Габриэле Муччино"));
    films.add(new Films("Матрица","(1999)","Лана Вачовски"));
    films.add(new Films("Джентельмены","(2019)","Гай Ричи"));
    films.add(new Films("Зелёная книга","(2018)","Питер Фаррелли"));
    films.add(new Films("Волк с Уолл-стрит","(2013)","Мартин Скорсезе"));
    films.add(new Films("Фокус","(2014)","Глен Фикарра"));
    films.add(new Films("Основатель","(2016)","Джон Ли Хэнкок"));
}
