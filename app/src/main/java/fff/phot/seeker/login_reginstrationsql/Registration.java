package fff.phot.seeker.login_reginstrationsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    DbHandler db;
    EditText etuserName;
    EditText etpassword;


    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etuserName = findViewById(R.id.userName);
        etpassword = findViewById(R.id.passWord);

    }

    public void RegisterBtn(View view) {
        name = etuserName.getText().toString().trim();
        pass = etpassword.getText().toString().trim();

        db = new DbHandler(this);
        db.addUser(new User(name,pass));


        startActivity(new Intent(this,MainActivity.class));
    }
}
