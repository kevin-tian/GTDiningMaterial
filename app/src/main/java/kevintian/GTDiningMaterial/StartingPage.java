package kevintian.GTDiningMaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

/**
 * Created by Kevin on 12/24/2015.
 */
public class StartingPage extends AppCompatActivity implements View.OnClickListener {

    Calendar c = Calendar.getInstance();

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        intent = new Intent(this, MenuActivity.class);
    }


    @Override
    public void onClick(View v) {
        int diningHall = 0;
        switch(v.getId()) {
            case R.id.brittain:
                diningHall = 1;
                break;
            case R.id.northave:
                diningHall = 2;
                break;
            case R.id.woodys:
                diningHall = 3;
                break;
        }
        intent.putExtra("Dining Hall", diningHall);
        TabFragment1 tab1 = new TabFragment1();
        TabFragment2 tab2 = new TabFragment2();
        TabFragment3 tab3 = new TabFragment3();
        Bundle diningHalls = new Bundle();
        diningHalls.putInt("Dining Hall", 1); //passes in the dining halls, with 1 being Brittain
        tab1.setArguments(diningHalls);

        tab2.setArguments(diningHalls);
        tab3.setArguments(diningHalls);
        startActivity(intent);
    }

    @Override
    protected void onResume() {

        super.onResume();

        imageButton1 = (ImageButton)findViewById(R.id.brittain);
        imageButton1.setOnClickListener(this);

        if(isClosed("Brittain")) {
            imageButton1.setImageResource(R.drawable.brittainclosed);
        }

        imageButton2 = (ImageButton)findViewById(R.id.northave);
        imageButton2.setOnClickListener(this);

        if(isClosed("North Ave")) {
            imageButton2.setImageResource(R.drawable.northaveclosed);
        }

        imageButton3 = (ImageButton)findViewById(R.id.woodys);
        imageButton3.setOnClickListener(this);

        if(isClosed("Woody's")) {
            imageButton3.setImageResource(R.drawable.woodysclosed);
        }
    }

    public boolean isClosed(String diningHall) {
        int day = c.get(Calendar.DAY_OF_WEEK);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(diningHall.equals("Brittain")) {
            if(day == 1 && hour >= 16 && hour <=20) {
                return false; //open
            } else if(day > 1 && day < 6 && hour >= 7 && hour <= 20) {
                return false;
            } else if(day == 6 && hour >= 7 && hour <= 15) {
                return false;
            } else {
                return true;
            }

        } else if(diningHall.equals("North Ave") || diningHall.equals("Woody's")) {
            if(day == 1 && ((hour >= 10 && hour <=24) || (hour >= 0 && hour <=2))) {
                return false; //open
            } else if(day > 1 && day < 6 && ((hour >= 7 && hour <=24) || (hour >= 0 && hour <=2))) {
                return false;
            } else if(day == 6 && hour >= 7 && hour <= 22) {
                return false;
            } else if(day == 7 && hour >= 10 && hour <= 22) {
                return false;
            } else {
                return true;
            }

        }
        return true;
    }
}
