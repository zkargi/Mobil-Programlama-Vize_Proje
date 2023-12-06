package com.zeynepkargi.vize_proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.health.connect.datatypes.units.Length;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
public class SmsActivity extends AppCompatActivity {
    Button sendButton;
    TextView tvtel,tvmesaj;
    EditText ettel,etmesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        checkSmsPermission();
        sendButton=findViewById(R.id.btn_gonder);
        ettel=findViewById(R.id.et_tel);
        etmesaj=findViewById(R.id.et_mesaj);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
            }
        });
    }
    private void checkSmsPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){
            Log.d("---","Okuma izni var");}
        else{
            Log.d("---","İzin al");
            requestPermission();

        }
    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
        }
        //showPermissionRationale();
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 98);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==98){
            if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Log.d("---","izin alındı");
            }
            else {
                Toast.makeText(getApplicationContext(),"SMS erişim izni vermelisin",Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void sendSms(){
        String Telno=(ettel.getText().toString());
        String Mesaj=(etmesaj.getText().toString());
        if(Mesaj.length()==0||Telno==null||Telno.length()==0||Mesaj==null){
            Toast.makeText(this,"Lütfen numara ve  mesaj kısmını boş bırakmayınız",Toast.LENGTH_SHORT).show();
        }
        else{
            SmsManager sms_manager=SmsManager.getDefault();
            sms_manager.sendTextMessage(Telno,null,Mesaj,null,null);
            Toast.makeText(this,"mesaj gönderildi",Toast.LENGTH_SHORT).show();
        }

    }
}