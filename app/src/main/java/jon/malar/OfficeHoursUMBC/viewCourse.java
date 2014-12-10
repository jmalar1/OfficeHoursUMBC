package jon.malar.OfficeHoursUMBC;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/*
 * Authors: Jonathan Malar, David Ziska, William Lucas
 * Class: CMSC 331
 * Professor: Lupoli
 */

/**
 * Activity that displays the selected course's office hours
 */
public class viewCourse extends Activity implements View.OnClickListener {

    TextView profHeader, title, days, time;
    Button leaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewcourse);

        profHeader = (TextView) findViewById(R.id.profTitle);
        title = (TextView) findViewById(R.id.viewTitle);
        days = (TextView) findViewById(R.id.viewDays);
        time = (TextView) findViewById(R.id.viewTime);

        leaveView = (Button) findViewById(R.id.btnleaveView);
        leaveView.setOnClickListener(this);

        int selectedIndex = Main.officeHours.getSelectedIndex();

        profHeader.append(Main.officeHours.getProf(selectedIndex));
        profHeader.append("'s Office Hours");

        title.append(Main.officeHours.getTitle(selectedIndex));
        days.append(Main.officeHours.getDays(selectedIndex));
        time.append(Main.officeHours.getTime(selectedIndex));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            // Save user input and finish
            case (R.id.btnleaveView):
                finish();
        }
    }
}
