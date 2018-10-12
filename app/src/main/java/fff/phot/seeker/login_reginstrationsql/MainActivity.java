package fff.phot.seeker.login_reginstrationsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pswd;
    Button login;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        uname=(EditText)findViewById(R.id.uname);
        pswd=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=uname.getText().toString().trim();
                String password=pswd.getText().toString().trim();
                int id= checkUser(new User(name,password));

                if(id==-1)
                {
                    Toast.makeText(MainActivity.this,"lOGIN FAILED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"SUCCESSFUL LOGIN "+name,Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(MainActivity.this,Service.class));

                }
            }
        });
        db=new DbHandler(MainActivity.this);



    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }

    public void RegiterAcitvity(View view) {

        startActivity(new Intent(this,Registration.class));
    }
}