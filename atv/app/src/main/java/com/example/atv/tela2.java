package com.example.atv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela2 extends AppCompatActivity {

    ImageButton bt;
    EditText result;
    CalendarView calendar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calendar = findViewById(R.id.calendar);
        bt = findViewById(R.id.calendarBtn);
        result = findViewById(R.id.date);

        calendar.setVisibility(View.GONE);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                result.setText("Dia : "+day+" Mês: "+month+" ano: "+year);
                bt.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);
                calendar.setVisibility(View.GONE);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt.setVisibility(View.GONE);
                result.setVisibility(View.GONE);
                calendar.setVisibility(View.VISIBLE);
            }
        });

    }
}