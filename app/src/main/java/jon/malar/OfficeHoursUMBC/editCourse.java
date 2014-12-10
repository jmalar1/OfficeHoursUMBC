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
 * Class that allows users to select a course whose office hours they want to edit,
 * or possibly delete that course altogether.
 */
public class editCourse extends Activity implements View.OnClickListener {

    Spinner myEditSpinner;
    Button confirmEdit, confirmRemove, cancelEditing;
    TextView editIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_editcourse);

        myEditSpinner = (Spinner) findViewById(R.id.editSpinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Main.officeHours.getAllNumbers()); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myEditSpinner.setAdapter(spinnerArrayAdapter);

        confirmEdit = (Button) findViewById(R.id.editHours);
        confirmEdit.setOnClickListener(this);

        confirmRemove = (Button) findViewById(R.id.removeCourse);
        confirmRemove.setOnClickListener(this);

        cancelEditing = (Button) findViewById(R.id.cancelEdit);
        cancelEditing.setOnClickListener(this);

        editIntro = (TextView) findViewById(R.id.introEdit);

        // Check if any courses have been setup, if not then cannot view
        if (Main.officeHours.isEmpty()){
            editIntro.setText("No courses to edit, return to menu and add a course");
            myEditSpinner.setVisibility(View.GONE);
            confirmEdit.setVisibility(View.GONE);
            confirmRemove.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case (R.id.editHours):
                String text = myEditSpinner.getSelectedItem().toString();
                Main.officeHours.setSelected(text);
                Intent openEdit = new Intent(this, editingPage.class);
                startActivityForResult(openEdit, 0);
                break;


            case (R.id.removeCourse):
                String text2 = myEditSpinner.getSelectedItem().toString();
                Main.officeHours.setSelected(text2);
                int selectedIndex = Main.officeHours.getSelectedIndex();

                Main.officeHours.removeTitle(selectedIndex);
                Main.officeHours.removeDays(selectedIndex);
                Main.officeHours.removeNumber(selectedIndex);
                Main.officeHours.removeProf(selectedIndex);
                Main.officeHours.removeTime(selectedIndex);


            case (R.id.cancelEdit):
                finish();
        }
    }
}
