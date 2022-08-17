import androidx.appcompat.app.AlertDialog; import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface; import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.EditText; import android.widget.Toast;

import java.io.Serializable;

public class addTeacher_Activity extends AppCompatActivity { EditText name; EditText iin; EditText subject;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_teacher);

    name = findViewById(R.id.TeachName);
    iin = findViewById(R.id.TeachIin);
    subject = findViewById(R.id.TeachSubject);

    Intent teacher = getIntent();
    teacher.putExtra("teach", 2);
}

public void TeachSave(View v) {
    String teachName = name.getText().toString();
    String teachIin = iin.getText().toString();
    String teachSubject = subject.getText().toString();

    int Tiin = Integer.parseInt(iin.getText().toString());

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Close window?");
    builder.setMessage("Are you sure you want to close window?");
    builder.setCancelable(false);

    DialogInterface.OnClickListener TeachYES = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (teachName.length() >= 1 && teachIin.length() >= 1 && teachSubject.length() >= 1) {
                setResult(RESULT_OK);
                Serializable p = new Person(teachName,Tiin,0.0,teachSubject);
                Intent intent = new Intent();
                intent.putExtra("person",p);
                setResult(RESULT_OK,intent);
                finish();
            } else if (teachName.equals("") || teachIin.equals("") || teachSubject.equals("")) {
                name.setError("Enter name!");
                iin.setError("Enter iin!");
                subject.setError("Enter subject!");
            }
        }
    };

    DialogInterface.OnClickListener TeachNO = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
        }
    };


    builder.setPositiveButton("Yes", TeachYES);
    builder.setNegativeButton("No", TeachNO);
    builder.setNeutralButton("Cancel", null);

    builder.create().show();
