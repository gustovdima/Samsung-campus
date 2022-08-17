import androidx.annotation.Nullable; import androidx.annotation.RequiresApi; import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Build; import android.os.Bundle; import android.util.Log; import android.view.View; import android.widget.EditText; import android.widget.TextView; import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

TextView result;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    result = findViewById(R.id.result);
}
public void addStudent(View v){
    Intent student = new Intent(this,addStudent_Activity.class);
    student.putExtra("stud",1);
    startActivityForResult(student,2);
}
public void addTeacher(View v){
    Intent teacher = new Intent(this,addTeacher_Activity.class);
    teacher.putExtra("teach",2);
    startActivityForResult(teacher,3);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == 2){
        if(resultCode == RESULT_OK) {
            Person p = (Person) data.getExtras().get("person");
            Toast.makeText(this, "Student add", Toast.LENGTH_LONG).show();
            result.setText(p.Student());
        }
    }else if(requestCode == 3){
        if(resultCode == RESULT_OK) {
            Person p = (Person) data.getExtras().get("person");
            Toast.makeText(this, "Teacher add", Toast.LENGTH_LONG).show();
            result.setText(p.Teacher());
        }
    }
}
