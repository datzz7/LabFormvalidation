package astapan.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    String user, pass;
    Button login;
    int formsuccess =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.btnLogin);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        TextView reg = (TextView)findViewById(R.id.btnRegister);

        reg.setFocusable(false);
        reg.setClickable(true);
        reg.setInputType(InputType.TYPE_NULL);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        // get user input
                        user = etUser.getText().toString();
                        pass = etPass.getText().toString();
                        formsuccess = 2;
                        // validate username
                        if(user.equals("")) {
                            etUser.setError("This field is required");
                            formsuccess--;
                        }
                        // validate password
                        if(pass.equals("")) {
                            etPass.setError("This field is required");
                            formsuccess--;
                        }
                        // form successfully validated
                        if(formsuccess == 2) {
                            Toast.makeText(MainActivity.this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                        }

            }
        });




    }
}
