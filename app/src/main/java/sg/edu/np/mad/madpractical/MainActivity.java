package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final String title = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Created");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Button follow = findViewById(R.id.button);
        Log.v(title, "Resumed");
        User user1 = new User();
        user1.followed = false;
        Intent myRecvIntent = getIntent();
        TextView madNo = findViewById(R.id.textView);
        madNo.setText("MAD " + String.valueOf(randomNo()));

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.followed == false){
                    follow.setText("UNFOLLOW");
                    user1.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    Log.v(title, "Followed");
                }
                else{
                    follow.setText("FOLLOW");
                    user1.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    Log.v(title, "Unfollowed");
                }
            }
        });

    }
    private int randomNo(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(1000000000);
        return myRandomNumber;
    }
}