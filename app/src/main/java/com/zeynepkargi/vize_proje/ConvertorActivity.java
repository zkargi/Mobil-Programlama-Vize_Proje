package com.zeynepkargi.vize_proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class ConvertorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] decimal_items = {"Tip seçiniz", "Binary", "Octal", "Hexadecimal"};
    String[] byte_items = {"Tip seçiniz","kilo byte","byte","kibi byte","bit"};
    RadioButton rbfah, rbkel;
    RadioGroup radiogroup;
    Spinner dec_spinner, byte_spinner;
    TextView tv_sonuc_dec, tv_sonuc_byte, tv_sonuc_celcius  ;
    EditText et_decimal_input, et_byte_input,et_celcius_input;

    public Integer decimalinput;

    public double byte_input;
    public double celcius_input;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        dec_spinner = findViewById(R.id.sp_decimal);
        dec_spinner.setOnItemSelectedListener( this);
        byte_spinner = findViewById(R.id.sp_byte);
        byte_spinner.setOnItemSelectedListener(this);
        rbfah = findViewById(R.id.rb_fah);
        rbkel = findViewById(R.id.rb_kel);
        radiogroup = findViewById(R.id.radio_group);
        et_celcius_input = findViewById(R.id.et_celcius);
        et_decimal_input = findViewById(R.id.et_decimal);
        et_byte_input = findViewById(R.id.et_byte);
        tv_sonuc_dec=findViewById(R.id.et_sonuc_decimal);
        tv_sonuc_celcius=findViewById(R.id.et_sonuc_celcius);
        tv_sonuc_byte=findViewById(R.id.et_sonuc_byte);




        ArrayAdapter decimal_ad
                = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                decimal_items);
        decimal_ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        dec_spinner.setAdapter(decimal_ad);

        ArrayAdapter byte_ad
                = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                byte_items);
        byte_ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        byte_spinner.setAdapter(byte_ad);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int x) {
                if(rbfah.getId()==x)
                    CelciusToFahrenheit();
                else if(rbkel.getId()==x)
                    CelciusToKelvin();
            }
        });




    }

    private void CelciusToFahrenheit(){
        celcius_input=Double.parseDouble(et_celcius_input.getText().toString());
        celcius_input=(celcius_input*((9/5)+32));
        tv_sonuc_celcius.setText(Double.toString(celcius_input)+ "F");
    }
    private void CelciusToKelvin(){
        celcius_input=Double.parseDouble(et_celcius_input.getText().toString());
        celcius_input=(celcius_input+273.15);
        tv_sonuc_celcius.setText((Double.toString(celcius_input)+"K"));
    }


    private void MgByteToByte(){
            byte_input=Double.parseDouble(et_byte_input.getText().toString());
            byte_input=(byte_input*1048576);
            tv_sonuc_byte.setText(Double.toString(byte_input));
    }
    private void MgByteToKiloByte(){
        byte_input=Double.parseDouble(et_byte_input.getText().toString());
        byte_input=(byte_input*1024);
        tv_sonuc_byte.setText(Double.toString(byte_input));
    }
    private void MgByteToBit(){
        byte_input=Double.parseDouble(et_byte_input.getText().toString());
        byte_input=(byte_input*8388608);
        tv_sonuc_byte.setText(Double.toString(byte_input));
    }
    private void MgByteToKibByte(){
        byte_input=Double.parseDouble(et_byte_input.getText().toString());
        byte_input=(byte_input*976.5625);
        tv_sonuc_byte.setText(Double.toString(byte_input));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void decimalToBinary(){
        decimalinput=Integer.parseInt(et_decimal_input.getText().toString());
        tv_sonuc_dec.setText(Integer.toBinaryString(decimalinput));
    }
    private void decimalToOctal(){
        decimalinput=Integer.parseInt(et_decimal_input.getText().toString());
        tv_sonuc_dec.setText(Integer.toOctalString(decimalinput));
    }
    private void decimalToHexadecimal(){
        decimalinput=Integer.parseInt(et_decimal_input.getText().toString());
        tv_sonuc_dec.setText(Integer.toHexString(decimalinput));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.sp_decimal)
            switch (position) {
                case 0:
                    break;
                case 1:
                    decimalToBinary();
                    break;
                case 2:
                    decimalToOctal();break;
                case 3:
                    decimalToHexadecimal();break;
            }
        else if(parent.getId()==R.id.sp_byte)
            switch(position){
                case 0:
                    break;
                case 1:
                    MgByteToKiloByte();
                    break;
                case 2:
                    MgByteToByte();
                    break;
                case 3:
                    MgByteToKibByte();
                    break;
                case 4:
                    MgByteToBit();
                    break;

            }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


