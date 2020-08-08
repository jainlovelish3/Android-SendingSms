package com.example.sendingsms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText contactno,txtmsg;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactno = findViewById(R.id.phoneno);
        txtmsg = findViewById(R.id.msgg);
        bt = findViewById(R.id.sendbtn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = contactno.getText().toString();
                String msg = txtmsg.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                smsManager.sendTextMessage(num,null,msg,pi,null);
                Toast.makeText(getApplicationContext(),"Message Sent Successfully ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
