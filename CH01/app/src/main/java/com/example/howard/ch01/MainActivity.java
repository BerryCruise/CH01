package com.example.howard.ch01;

import android.app.Activity;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listen for button clicks
        Button button = (Button) findViewById(R.id.buttonCalculate);
        button.setOnClickListener(calcBMI);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View.OnClickListener calcBMI = new View.OnClickListener()
    {
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onClick(View v)
        {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText fieldheight = (EditText) findViewById(R.id.inputHeight);
            EditText fieldweight = (EditText) findViewById(R.id.inputWeight);
            double height = Double
                    .parseDouble(fieldheight.getText().toString()) / 100;
            double weight = Double
                    .parseDouble(fieldweight.getText().toString());
            double BMI = weight / (height * height);

            TextView result = (TextView) findViewById(R.id.textResult);
            result.setText("你的BMI是 " + nf.format(BMI));


        }
    };
}
