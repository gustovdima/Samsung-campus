
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    EditText editText2;


    public static final int INFINITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.myTxt);
    }
    public void PMMD(View v) {
        if (v.getId() == R.id.btnPlus) {
            double num1, num2, result;
            String str1 = editText.getText().toString();
            String str2 = editText2.getText().toString();
            if (str1.length() >= 1 && str2.length() >= 1) {
                num1 = Double.parseDouble(str1);
                num2 = Double.parseDouble(str2);
                result = num1 + num2;
                String count = Double.toString(result);
                textView.setText("Result: " + count);
            } else {
                textView.setText("empty input fields!");
            }
        } else if (v.getId() == R.id.btnMinus) {
            double num1, num2, result;
            String str1 = editText.getText().toString();
            String str2 = editText2.getText().toString();
            if (str1.length() >= 1 && str2.length() >= 1) {
                num1 = Double.parseDouble(str1);
                num2 = Double.parseDouble(str2);

                result = num1 - num2;
                String count = Double.toString(result);
                textView.setText("Result: " + count);
            } else {
                textView.setText("empty input fields!");
            }
        } else if (v.getId() == R.id.Multiplication) {
            double num1, num2, result;
            String str1 = editText.getText().toString();
            String str2 = editText2.getText().toString();
            if (str1.length() >= 1 && str2.length() >= 1) {
                num1 = Double.parseDouble(str1);
                num2 = Double.parseDouble(str2);

                result = num1 * num2;
                String count = Double.toString(result);
                textView.setText("Result: " + count);
            } else {
                textView.setText("empty input fields!");
            }

        } else if (v.getId() == R.id.Division) {
            double num1, num2, result;
            String str1 = editText.getText().toString();
            String str2 = editText2.getText().toString();
            if (str1.length() >= 1 && str2.length() >= 1) {
                num1 = Double.parseDouble(str1);
                num2 = Double.parseDouble(str2);

                result = num1 / num2;
                String count = Double.toString(result);
                textView.setText("Result: " + count);
                if (num2 == INFINITY) {
                    textView.setText("Result: На ноль делить нельзя");
                }
            } else {
                textView.setText("empty input fields!");
            }
        }
    }
}
