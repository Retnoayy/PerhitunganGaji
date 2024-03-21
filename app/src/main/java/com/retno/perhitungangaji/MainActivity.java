package com.retno.perhitungangaji;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung (View v){
        EditText nama = (EditText) findViewById (R.id.nama);
        TextView outputNama = (TextView) findViewById (R.id.outputNama);
        TextView outputStatus = (TextView) findViewById (R.id.outputStatus);
        TextView outputGolongan = (TextView) findViewById (R.id.outputGolongan);
        String name = nama.getText().toString();
        outputNama.setText("Nama : "+name);
        status = (CheckBox) findViewById (R.id.menikah);
        if (status.isChecked()) {
            gajiStatus = 500000;
            outputStatus.setText("Status: Menikah");
        } else {
            gajiStatus = 0;
            outputStatus.setText("Status: Belum Menikah");
        }

        golongan = (RadioGroup) findViewById (R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1){
            gajiGolongan = 1000000;
            outputGolongan.setText("Golongan: 1");
        }
        else
        if (gol == R.id.rbGolongan2){
            gajiGolongan = 2000000;
            outputGolongan.setText("Golongan: 2");
        }

        int totalGaji = gajiStatus+gajiGolongan;
        TextView total = (TextView) findViewById (R.id.outputGaji);
        total.setText(String.valueOf(totalGaji));
    }
}
