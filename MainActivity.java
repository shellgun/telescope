package com.example.telescop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float telescope = 14_000;
    int account = 1000;
    float wage = 2500;
    float percentBank = 5;
    float[] activity = new float [120];
    private float percentBankYear;

    private float apartmentPrice() {
        float apartmentPrice = 0;
        return apartmentPrice - account;

    }

    public int countMouth(float mortgageCosts, float total ,float percentBankYear) {
        float percentBankMouth = this.percentBankYear / 12;
        int count = 0;

        while (total > 0) {
            count++;
            total = (total + (total * percentBankMouth) / 100) - mortgageCosts;
            if (total>mortgageCosts){
               activity[count-1]=mortgageCosts;
            } else {
                activity[count-1]=total;
            }
        }

          return count;
    }
    private TextView txt;
    private  TextView txt2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        txt = findViewById (R.id.txt);
        txt2 = findViewById (R.id.txt2);
        txt.setText (" " + countMouth (apartmentPrice ( ), (wage), percentBank) + "месяцев");
        txt2.setText (" " + account + " монет " + activity);
    }
}