package jon.malar.OfficeHoursUMBC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/*
 * Authors: Jonathan Malar, David Ziska, William Lucas
 * Class: CMSC 331
 * Professor: Lupoli
 */

/**
 * Activity that allows users to select which course's office hours they want to view
 */
public class findCourse extends Activity implements View.OnClickListener{

    TextView mySelect;
    Button viewHours, cancelView;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_findcourse);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Main.officeHours.getAllNumbers()); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(spinnerArrayAdapter);

        viewHours = (Button) findViewById(R.id.findOffice);
        viewHours.setOnClickListener(this);

        cancelView = (Button) findViewById(R.id.leaveFind);
        cancelView.setOnClickListener(this);

        mySelect = (TextView) findViewById(R.id.introSelect);

        // Check if any courses have been setup, if not then cannot view
        if (Main.officeHours.isEmpty()){
            mySelect.setText("No courses added yet, return to menu and add a course");
            mySpinner.setVisibility(View.GONE);
            viewHours.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case (R.id.findOffice):
                String text = mySpinner.getSelectedItem().toString();
                Main.officeHours.setSelected(text);
                Intent view = new Intent(this, viewCourse.class);
                startActivityForResult(view, 0);
                break;

            case (R.id.leaveFind):
                finish();
        }
    }
}
