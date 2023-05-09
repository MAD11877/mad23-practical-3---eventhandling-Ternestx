package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String title = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "On Create!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "On Resume! ImageButton Page Started!");

        final ImageView imageButton = findViewById(R.id.imageView4);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title, "Image Pressed");
                viewPage();
            }
        });
    }

    private void viewPage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(myIntent);
                Log.v(title, "User Views");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.v(title, "User Declines");
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}