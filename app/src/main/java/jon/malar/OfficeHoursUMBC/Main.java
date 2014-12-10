package jon.malar.OfficeHoursUMBC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
/*
 * Authors: Jonathan Malar, David Ziska, William Lucas
 * Class: CMSC 331
 * Professor: Lupoli
 */

/**
 * Main activity of app, acts as menu of sorts regarding Office Hours
 */
public class Main extends Activity implements View.OnClickListener {

    // Create buttons
    Button myFind, myAdd, myEdit, exit;
    static myData officeHours = new myData();
    ImageView myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Initialize our buttons
        myFind = (Button) findViewById(R.id.findCourse);
        myAdd = (Button) findViewById(R.id.addCourse);
        myEdit = (Button) findViewById(R.id.chooseEditCourse);
        exit = (Button) findViewById(R.id.Exit);

        myFind.setOnClickListener(this);
        myAdd.setOnClickListener(this);
        myEdit.setOnClickListener(this);
        exit.setOnClickListener(this);

        myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageResource(R.drawable.umbc);

    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){

            // Start findCourse activity
            case (R.id.findCourse):
                Intent i = new Intent(Main.this, findCourse.class);
                startActivityForResult(i, 0);
                break;

            case (R.id.addCourse):
                Intent i2 = new Intent(Main.this, addCourse.class);
                startActivityForResult(i2, 0);
                break;

            case (R.id.chooseEditCourse):
                Intent i9 = new Intent(Main.this, editCourse.class);
                startActivityForResult(i9, 0);
                break;

            case (R.id.Exit):
                finish();
                break;
        }

    }
}
