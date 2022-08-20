import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.EditText;

import Classes.Books;import Classes.Films;

public class addBooks extends AppCompatActivity {
    EditText txtTitle, txtAuthor, txtYear;
    String value;
    String value2;
    String value3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        txtTitle = findViewById(R.id.etTitle);
        txtAuthor = findViewById(R.id.etAuthor);
        txtYear = findViewById(R.id.etYear);
    }

    public void SaveBooks(View v) {
        String strTitle = txtTitle.getText().toString();
        String strAuthor = txtAuthor.getText().toString();
        String strYear = txtYear.getText().toString();

        boolean found = true;

        if (strTitle.isEmpty() || strTitle == null) {
            txtTitle.setError("Enter Title");
            found = false;
        }
        if (strAuthor.isEmpty() || strAuthor == null) {
            txtAuthor.setError("Enter Author");
            found = false;
        }
        if (strYear.isEmpty() || strYear == null) {
            txtYear.setError("Enter Year");
            found = false;
        }

        if (!found) {
            return;
        }

        Books books = new Books(strTitle, strYear, strAuthor);
        Intent book = new Intent();
        book.putExtra("book", books);
        setResult(RESULT_OK, book);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("title");
            value2 = extras.getString("author");
            value3 = extras.getString("year");
            Log.d("addBook", value);
        }
        txtTitle.setText(value);
        txtAuthor.setText(value2);
        txtYear.setText(value3);
    }
}
