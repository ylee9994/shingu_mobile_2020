package com.ylee.a081calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnStop;
    RadioButton rCal, rTime, rCalP;
    CalendarView calView;
    TimePicker timePicker;
    DatePicker datePicker;
    TextView tvmsg;
    Integer sYear, sMonth, sDay;
    Integer tHour, tMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("예약시스템  이용희");

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnEnd);
        chronometer = findViewById(R.id.chronometer);
        rCal = findViewById(R.id.rdoCal);
        rTime = findViewById(R.id.rdoTime);
        calView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        rCalP = findViewById(R.id.rdoCalP);
        tvmsg = findViewById(R.id.tvmsg);

        calView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        rCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });
        rCalP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });


        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                sYear = year;
                sMonth = month + 1;
                sDay = dayOfMonth;
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                String datetime = "예약시간: " + sYear + "년" + sMonth  +  "월" + sDay + "일"
                        + ":::" + timePicker.getCurrentHour() + ": "
                        + timePicker.getCurrentMinute();
                tvmsg.setText(datetime);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tHour = hourOfDay;
                tMin = minute;
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                sYear = year;
                sMonth = monthOfYear + 1;
                sDay = dayOfMonth;
            }
        });

    }
}
