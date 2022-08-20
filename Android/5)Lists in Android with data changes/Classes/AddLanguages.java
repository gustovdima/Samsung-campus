package com.example.listtest;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.EditText;

        import Classes.Films;import Classes.Languages;

public class addLanguages extends AppCompatActivity {
    EditText txtTitle, txtCreator, txtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_films);

        txtTitle = findViewById(R.id.LetTitle);
        txtCreator = findViewById(R.id.LetCreator);
        txtYear = findViewById(R.id.LetYear);
    }

    public void SaveLanguages(View v) {
        String strTitle = txtTitle.getText().toString();
        String strCreator = txtCreator.getText().toString();
        String strYear = txtYear.getText().toString();

        boolean found = true;

        if (strTitle.isEmpty() || strTitle == null) {
            txtTitle.setError("Enter Title");
            found = false;
        }
        if (strCreator.isEmpty() || strCreator == null) {
            txtCreator.setError("Enter Creator");
            found = false;
        }
        if (strYear.isEmpty() || strYear == null) {
            txtYear.setError("Enter Year");
            found = false;
        }

        if (!found) {
            return;
        }

        Languages languages = new Languages(strTitle, strCreator, strYear);
        Intent intent = new Intent();
        intent.putExtra("language", languages);
        setResult(RESULT_OK, intent);
        finish();

    }
} 
