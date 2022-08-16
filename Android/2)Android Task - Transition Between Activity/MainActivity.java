import androidx.annotation.Nullable; import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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
    if(requestCode == 2) {
        Toast.makeText(this, "Student add", Toast.LENGTH_LONG).show();
    }else if(requestCode == 3){
        Toast.makeText(this, "Teacher add", Toast.LENGTH_LONG).show();
    }
}
