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
 * Activity that allows users to add a course's office hours
 */
public class addCourse extends Activity implements View.OnClickListener {

    Button saveAndReturn, cancelCourse;
    EditText eCourse, eProf, eTitle, eDays, eTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_addcourse);

        saveAndReturn = (Button) findViewById(R.id.btnExitCourses);
        saveAndReturn.setOnClickListener(this);

        cancelCourse = (Button) findViewById(R.id.btnCancelAdd);
        cancelCourse.setOnClickListener(this);

        eCourse = (EditText) findViewById(R.id.etCourseNumber);
        eProf = (EditText) findViewById(R.id.etProf);
        eTitle = (EditText) findViewById(R.id.etCourseTitle);
        eDays = (EditText) findViewById(R.id.etDays);
        eTime = (EditText) findViewById(R.id.etTime);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // Save user input and finish
            case (R.id.btnExitCourses):
                if( eCourse.getText().toString().length() == 0 ) {
                    eCourse.setError("Course number is required!");
                    break;
                }
                else if(eProf.getText().toString().length() == 0){
                    eProf.setError("Professor name is required!");
                    break;
                }
                else if(eTitle.getText().toString().length() == 0){
                    eTitle.setError("Class title is required!");
                    break;
                }
                else if(eDays.getText().toString().length() == 0){
                    eDays.setError("Days of office hours is required!");
                    break;
                }
                else if(eTime.getText().toString().length() == 0){
                    eTime.setError("Time period of office hours is required! (Ex: 7-9 AM)");
                    break;
                }
                else {
                    Main.officeHours.addNumber(eCourse.getText().toString());
                    Main.officeHours.addProf(eProf.getText().toString());
                    Main.officeHours.addTitle(eTitle.getText().toString());
                    Main.officeHours.addDays(eDays.getText().toString());
                    Main.officeHours.addTime(eTime.getText().toString());
                    finish();
                }

            case (R.id.btnCancelAdd):
                finish();
        }
    }
}
