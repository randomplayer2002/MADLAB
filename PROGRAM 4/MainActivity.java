package com.example.pgm4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText inputEditText;
RadioButton inputRadioMeter,inputRadioCentemeter,inputRadioFeet;
RadioButton outputRadioMeter,outputRadioCentemeter,outputRadioFeet;
TextView tv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText=findViewById(R.id.editText);
        inputRadioMeter=findViewById(R.id.inputRadioMeter);
        inputRadioCentemeter=findViewById(R.id.inputRadioCentemeter);
        inputRadioFeet=findViewById(R.id.inputRadioFeet);
        outputRadioMeter=findViewById(R.id.outputRadioMeter);
        outputRadioCentemeter=findViewById(R.id.outputRadioCentemeter);
        outputRadioFeet=findViewById(R.id.outputRadioFeet);
        tv=findViewById(R.id.textView2);
        Button convert=findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertUnits();
            }
        });
    }
    public void convertUnits(){
        String inputStr=inputEditText.getText().toString().trim();
        if (TextUtils.isEmpty(inputStr)){
            tv.setText("Enter a value to convert");
            return;
        }
        double inputValue=Double.parseDouble(inputStr);
        double Meter = 0;
        double Centemeter = 0;
        double Feet = 0;
        if (inputRadioMeter.isChecked()){
            Meter=inputValue;
        }
        else if (inputRadioCentemeter.isChecked()){
            Centemeter=inputValue;
        }
        else if (inputRadioFeet.isChecked()){
            Feet=inputValue;
        }
        if (outputRadioMeter.isChecked()){
            if (Meter>0){
                tv.setText(String.format("%.2f Meters",Meter));
            }
            else if (Centemeter>0){
                Meter=Centemeter/100.0;
                tv.setText(String.format("%.2f Meters",Meter));
            }
            else if (Feet>0){
                Meter=Feet/3.2808;
                tv.setText(String.format("%.2f Meters",Meter));
            }
        }

        if (outputRadioCentemeter.isChecked()){
            if (Centemeter>0){
                tv.setText(String.format("%.2f Centemeters",Centemeter));
            }
            else if (Meter>0){
               Centemeter=Meter*100.0;
                tv.setText(String.format("%.2f Centemeters",Centemeter));
            }
            else if (Feet>0){
                Centemeter=(Feet*100)/3.2808;
                tv.setText(String.format("%.2f Centemeters",Centemeter));
            }
        }
        if (outputRadioFeet.isChecked()){
            if (Feet>0){
                tv.setText(String.format("%.2f Feets",Feet));
            }
            else if (Meter>0){
                Feet=Meter*3.2808;
                tv.setText(String.format("%.2f Feets",Feet));
            }
            else if (Centemeter>0){
                Feet=(Centemeter*3.2808)/100;
                tv.setText(String.format("%.2f Feets",Feet));
            }
        }

    }
}
