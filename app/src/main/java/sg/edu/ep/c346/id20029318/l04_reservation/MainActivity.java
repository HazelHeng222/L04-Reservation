package sg.edu.ep.c346.id20029318.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText tabSize;
    CheckBox isSmoking;
    Button reset;
    Button reserve;
    DatePicker date;
    TimePicker time;

    String smoke = "non-smoker";
    String reserveDate = "";
    String reserveTime = "";
    String phNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Uname);
        phone = findViewById(R.id.ph);
        tabSize = findViewById(R.id.sizeNum);
        isSmoking = findViewById(R.id.checkBox);
        reset = findViewById(R.id.butCancel);
        reserve = findViewById(R.id.butRes);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);



        isSmoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewTim) {
                if(isSmoking.isChecked()){
                   smoke = "smoker";
                }

            }
        }
        );

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewPh) {
                phNum = phone.toString();

            }
        }
        );

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewTime) {
                reserveTime = time.getCurrentHour() + ":" + time.getCurrentMinute();

            }
        });

       date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View viewDat){
                int d = date.getDayOfMonth();
                int m = date.getMonth() + 1;
                int y = date.getYear();

                reserveDate =  d + "/" + m + "/"+y;
            }
        });


        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View viewReset) {
                date.updateDate(2020,0,1);
                time.setCurrentHour(0);
                time.setCurrentMinute(0);
                name.setText("");
                phone.setText("");
                tabSize.setText("");
                isSmoking.setChecked(false);

            }

        });

        reserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View viewSub) {

                if (name.isEnabled() && phone.isEnabled() && tabSize.isEnabled()){
                    Toast.makeText(MainActivity.this,"Successfully reserve " + smoke + " table for " + tabSize.toString() + ". We will notify you via " + phNum + ", a few days before " + reserveDate +".", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"ERROR: Please fill in your Name/Phone Number/Size",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}