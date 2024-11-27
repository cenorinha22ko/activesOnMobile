package com.example.formulario;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela2 extends AppCompatActivity {
    EditText name, cpf;
    RadioButton female, male;
    MultiAutoCompleteTextView result;
    Button sBtn;
    ImageButton btImg;
    CalendarView calendar;
    public  String age;
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

        name = findViewById(R.id.name);
        cpf = findViewById(R.id.cpf);
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);
        sBtn = findViewById(R.id.sendBtn);
        btImg = findViewById(R.id.btCalendar);
        calendar = findViewById(R.id.calendarView);
        result = findViewById(R.id.result);

        calendar.setVisibility(View.GONE);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                age = "Data nascimento: "+day +"/"+ month + "/"+ year;
            }
        });
        btImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.VISIBLE);
            }
        });
        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Informações enviadas para o sistema com sucesso",Toast.LENGTH_LONG).show();
                result.setText("Nome: "+name.getText().toString()+
                "\nIdade: "+age+
                "\ncpf: "+cpf.getText().toString());
            }
        });

    }
}