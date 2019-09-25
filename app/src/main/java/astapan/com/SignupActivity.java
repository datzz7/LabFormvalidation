package astapan.com;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
public class SignupActivity extends AppCompatActivity {

    EditText etUsername, etPassword,etFullname;
    String username, password, fullname;
    int formsuccess = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.etRegUser);
        etPassword = findViewById(R.id.etRegPass);
        etFullname = findViewById(R.id.etFullname);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.btnSave:
                // get user input
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                fullname = etFullname.getText().toString();
                formsuccess = 3;
                // validate username
                if(username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                // validate password
                if(password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }
                if(fullname.equals("")) {
                    etFullname.setError("This field is required");
                    formsuccess--;
                }
                // form successfully validated
                if(formsuccess == 3) {
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}