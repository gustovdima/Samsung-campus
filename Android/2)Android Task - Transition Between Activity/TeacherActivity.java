import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.EditText;

public class addTeacher_Activity extends AppCompatActivity { EditText name; EditText iin; EditText subject; @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_add_teacher);

    name = findViewById(R.id.TeachName);
    iin = findViewById(R.id.TeachIin);
    subject = findViewById(R.id.TeachSubject);

    Intent teacher = getIntent();
    teacher.putExtra("teach",2);
}
public void TeachSave(View v){
    String teachName = name.getText().toString();
    String teachIin = iin.getText().toString();
    String teachSubject = subject.getText().toString();

    if(teachName.length() >= 1 && teachIin.length() >= 1 && teachSubject.length() >= 1){
        finish();
    }else if(teachName.equals("")  && teachIin.equals("")  && teachSubject.equals("")){
        name.setError("Enter name!");
        iin.setError("Enter iin!");
        subject.setError("Enter subject!");
    }
}
