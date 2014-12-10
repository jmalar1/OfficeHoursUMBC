package jon.malar.OfficeHoursUMBC;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/*
 * Authors: Jonathan Malar, David Ziska, William Lucas
 * Class: CMSC 331
 * Professor: Lupoli
 */

/**
 * Activity that allows users to edit their selected course's details
 */
public class editingPage extends Activity implements View.OnClickListener {

    Button saveChanges, cancelChanges;
    EditText editCourse, editProf, editTitle, editDays, editTime;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_editingpage);

        cancelChanges = (Button) findViewById(R.id.btnCancelEditing);
        cancelChanges.setOnClickListener(this);

        saveChanges = (Button) findViewById(R.id.btnSaveEditing);
        saveChanges.setOnClickListener(this);

        editCourse = (EditText) findViewById(R.id.etEditCourseNumber);
        editProf = (EditText) findViewById(R.id.etEditProf);
        editTitle = (EditText) findViewById(R.id.etEditCourseTitle);
        editDays = (EditText) findViewById(R.id.etEditDays);
        editTime = (EditText) findViewById(R.id.etEditTime);


        selectedIndex = Main.officeHours.getSelectedIndex();


        String tempCourse = Main.officeHours.getNumber(selectedIndex);
        String tempProf = Main.officeHours.getProf(selectedIndex);
        String tempTitle = Main.officeHours.getTitle(selectedIndex);
        String tempDays = Main.officeHours.getDays(selectedIndex);
        String tempTime = Main.officeHours.getTime(selectedIndex);


        editCourse.setHint(tempCourse);
        editProf.setHint(tempProf);
        editTitle.setHint(tempTitle);
        editDays.setHint(tempDays);
        editTime.setHint(tempTime);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // Save user input and finish
            case (R.id.btnSaveEditing):

                // Only edit what text fields have been changed
                if (editCourse.getText().toString().trim().length() > 0){
                    Main.officeHours.setNumber(editCourse.getText().toString(), selectedIndex);
                }

                if (editProf.getText().toString().trim().length() > 0){
                    Main.officeHours.setProf(editProf.getText().toString(), selectedIndex);
                }

                if (editTitle.getText().toString().trim().length() > 0){
                    Main.officeHours.setTitle(editTitle.getText().toString(), selectedIndex);
                }

                if (editDays.getText().toString().trim().length() > 0){
                    Main.officeHours.setDays(editDays.getText().toString(), selectedIndex);
                }

                if (editTime.getText().toString().trim().length() > 0){
                    Main.officeHours.setTime(editTime.getText().toString(), selectedIndex);
                }

                finish();

            case (R.id.btnCancelEditing):
                finish();
        }
    }
}
