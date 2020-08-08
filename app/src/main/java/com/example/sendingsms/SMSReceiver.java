package com.example.sendingsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msg = null;
        String str = "SMS from ";
        if (bundle!=null){
            Object[] rcv = (Object[])bundle.get("pdus");
            msg = new SmsMessage[rcv.length];
            for (int i=0;i<msg.length;i++){
                msg[i] = SmsMessage.createFromPdu((byte[])rcv[i]);
                if (i==0){
                    str = str + msg[i].getOriginatingAddress();
                    str = str + ":";
                }
                str += msg[i].getMessageBody().toString();
                Toast.makeText(context,"HI"+str,Toast.LENGTH_SHORT).show();
            }

        }
    }
}
