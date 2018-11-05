package gorental.com.sharedprefenceext1practics;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    Button b1, b2;
    TextView tv;

    //String n, pass;

    SharedPreferences sharedPreferences;
    public static  final String MyPreFerence = "MyPref";
    public static  final String Name = "name";
    public static  final String Password = "password";
    public static  final String Email = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);

        tv = findViewById(R.id.tv);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        sharedPreferences = getSharedPreferences(MyPreFerence, Context.MODE_PRIVATE);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String n = ed1.getText().toString();
               final String pass = ed2.getText().toString();
               final String e = ed3.getText().toString();

             SharedPreferences.Editor editor = sharedPreferences.edit();

             editor.putString(Name, n);
             editor.putString(Password, pass);
             editor.putString(Email, e);
             editor.commit();
             Toast.makeText(MainActivity.this, "Succesfully!", Toast.LENGTH_SHORT).show();

               b2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       tv.setText(n+"\n"+pass+"\n"+e);
                      // tv.setText();
                   }
               });
           }
       });



    }
}
