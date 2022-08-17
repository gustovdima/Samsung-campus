import androidx.annotation.NonNull; import androidx.annotation.RequiresApi; import androidx.appcompat.app.AlertDialog; import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface; import android.content.Intent; import android.os.Build; import android.os.Bundle; import android.util.Log; import android.util.SparseIntArray; import android.view.View; import android.widget.EditText; import android.widget.TextView; import android.widget.Toast;

import java.io.Serializable; import java.util.Random;

public class addStudent_Activity extends AppCompatActivity{ EditText name; EditText iin; EditText gpa;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_student);
    name = findViewById(R.id.StudentName);
    iin = findViewById(R.id.StudentIin);
    gpa = findViewById(R.id.StudentGpa);

    Intent student = getIntent();
    student.putExtra("stud",1);

}

public void StudSave(View v) {
    String studName = name.getText().toString();
    String studIin = iin.getText().toString();
    String studGpa = gpa.getText().toString();

    int Siin = Integer.parseInt(iin.getText().toString());
    double Sgpa = Double.parseDouble(gpa.getText().toString());

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Close window?");
    builder.setMessage("Are you sure you want to close window?");
    builder.setCancelable(false);

    DialogInterface.OnClickListener StudYES = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            if (studName.length() >= 1 && studIin.length() >= 1 && studGpa.length() >= 1) {
                Serializable p = new Person(studName,Siin,Sgpa,"");
                Intent intent = new Intent();
                intent.putExtra("person",p);
                setResult(RESULT_OK,intent);
                finish();
            }else {

            }
        }
    };

    DialogInterface.OnClickListener StudNO = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
        }
    };

    builder.setPositiveButton("Yes", StudYES);
    builder.setNegativeButton("No",StudNO);
    builder.setNeutralButton("Cancel", null);

    builder.create().show();

}
