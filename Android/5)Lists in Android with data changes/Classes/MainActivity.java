package com.example.listtest;

import androidx.annotation.NonNull; import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Bundle; import android.view.Menu; import android.view.MenuInflater; import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.itemFilms) {
        Intent film = new Intent(this, Films_Activtity.class);
        startActivity(film);
    }else if(item.getItemId() == R.id.itemBooks) {
        Intent book = new Intent(this,Books_Activity.class);
        startActivity(book);
    }else if(item.getItemId() == R.id.itemLanguages) {
        Intent intent = new Intent(this, Languages_Activity.class);
        startActivity(intent);
    }
    return super.onOptionsItemSelected(item);
}
}
