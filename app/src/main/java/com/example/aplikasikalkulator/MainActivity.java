package com.example.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextAngka1, editTextAngka2;
    TextView hasilPerhitungan;
    Button penjumlahan, pengurangan, perkalian, pembagian, clear;
    int angka1, angka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAngka1 = findViewById(R.id.editTextNumber1);
        editTextAngka2 = findViewById(R.id.editTextNumber2);

        penjumlahan = findViewById(R.id.buttonPenjumlahan);
        pengurangan = findViewById(R.id.buttonPengurangan);
        perkalian = findViewById(R.id.buttonPerkalian);
        pembagian = findViewById(R.id.buttonPembagian);

        clear = findViewById(R.id.buttonClear);
        hasilPerhitungan = findViewById(R.id.textViewHasil);


        penjumlahan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (getNumbers()) {
                    int hasil = angka1 + angka2;
                    hasilPerhitungan.setText(Integer.toString(hasil));
                }
            }
        });

        pengurangan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (getNumbers()) {
                    int hasil = angka1 - angka2;
                    hasilPerhitungan.setText(Integer.toString(hasil));
                }
            }
        });

        perkalian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (getNumbers()) {
                    int hasil = angka1 * angka2;
                    hasilPerhitungan.setText(Integer.toString(hasil));
                }
            }
        });

        pembagian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (getNumbers()) {
                    double hasil = (angka1 * 1.0) / angka2;
                    hasilPerhitungan.setText(Double.toString(hasil));
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editTextAngka1.getText().clear();
                editTextAngka2.getText().clear();
                hasilPerhitungan.setText("0");
            }
        });

    }
    public boolean getNumbers() {
        editTextAngka1 = findViewById(R.id.editTextNumber1);
        editTextAngka2 = findViewById(R.id.editTextNumber2);

        hasilPerhitungan = findViewById(R.id.textViewHasil);

        String parseAngka1 = editTextAngka1.getText().toString();
        String parseAngka2 = editTextAngka2.getText().toString();

        if ((parseAngka1.equals(null) && parseAngka2.equals(null)) || (parseAngka1.equals("") && parseAngka2.equals(""))) {
            String result = "Mohon isi kedua angka";
            hasilPerhitungan.setText(result);
            return false;
        } else {
            angka1 = Integer.parseInt(parseAngka1);
            angka2 = Integer.parseInt(parseAngka2);
        }
        return true;
    }
}