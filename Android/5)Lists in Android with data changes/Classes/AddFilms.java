package com.example.listtest;

        import androidx.appcompat.app.AlertDialog;import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;import android.content.Intent;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.EditText;

        import Classes.Films;

public class addFilms extends AppCompatActivity {
    EditText txtTitle, txtDirector, txtYear;
    String value;
    String value2;
    String value3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_films);

        txtTitle = findViewById(R.id.txtTitle);
        txtDirector = findViewById(R.id.txtDirector);
        txtYear = findViewById(R.id.txtYear);
    }

    public void SaveFilms(View v) {
        String strTitle = txtTitle.getText().toString();
        String strDirector = txtDirector.getText().toString();
        String strYear = txtYear.getText().toString();

        boolean found = true;

        if (strTitle.isEmpty() || strTitle == null) {
            txtTitle.setError("Enter Title");
            found = false;
        }
        if (strDirector.isEmpty() || txtDirector == null) {
            txtDirector.setError("Enter Director");
            found = false;
        }
        if (strYear.isEmpty() || strYear == null) {
            txtYear.setError("Enter Year");
            found = false;
        }

        if (!found) {
            return;
        }

        Films film = new Films(strTitle, strYear, strDirector);
        Intent intent = new Intent();
        intent.putExtra("film", film);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("title");
            value2 = extras.getString("director");
            value3 = extras.getString("year");
            Log.d("addFilm", value);
        }
        txtTitle.setText(value);
        txtDirector.setText(value2);
        txtYear.setText(value3);
    }
}
