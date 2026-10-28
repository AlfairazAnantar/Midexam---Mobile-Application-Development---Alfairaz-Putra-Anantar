package com.example.midexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextStudentID;
    private TextView textViewAge;
    private SeekBar seekBarAge;
    private Button btnAdd, btnView;

    private static final int MIN_AGE = 17;
    private int selectedAge = MIN_AGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        textViewAge = findViewById(R.id.textViewAge);
        seekBarAge = findViewById(R.id.seekBarAge);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);

        seekBarAge.setMax(33);
        textViewAge.setText("Age: " + MIN_AGE);

        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedAge = MIN_AGE + progress;
                textViewAge.setText("Age: " + selectedAge);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnAdd.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String studentId = editTextStudentID.getText().toString().trim();

            if (name.isEmpty() || studentId.isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter data", Toast.LENGTH_SHORT).show();
            } else {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                StudentModel studentModel = new StudentModel(studentId, name, selectedAge);
                dbHelper.addStudent(studentModel);

                Toast.makeText(MainActivity.this, "Add Successful", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

        btnView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewStudent.class);
            startActivity(intent);
        });
    }
}