import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.EditText;

public class addStudent_Activity extends AppCompatActivity { EditText name; EditText iin; EditText gpa; @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_add_student); name = findViewById(R.id.StudentName); iin = findViewById(R.id.StudentIin); gpa = findViewById(R.id.StudentGpa);

    Intent student = getIntent();
    student.putExtra("stud",1);
}
public void Save(View v) {
    String studName = name.getText().toString();
    String studIin = iin.getText().toString();
    String studGpa = gpa.getText().toString();

    if (studName.length() >= 1 && studIin.length() >= 1 && studGpa.length() >= 1) {
        finish();
    }else if(studName.equals("") && studIin.equals("")&& studGpa.equals("")){
        name.setError("Enter name!");
        iin.setError("Enter iin!");
        gpa.setError("Enter gpa!");
    }
}
