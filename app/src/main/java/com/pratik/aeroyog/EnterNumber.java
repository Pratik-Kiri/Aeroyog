package com.pratik.aeroyog;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EnterNumber extends AppCompatActivity {

    TextView query;
     Button sendotp;
    EditText num;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_enter_number);

        num=(EditText)findViewById(R.id.num);

        query=(TextView)findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Inquirypage.class);
                startActivity(intent1);
            }
        });

        sendotp=(Button)findViewById(R.id.sendotp);
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=num.getText().toString();
                Intent intent2=new Intent(getApplicationContext(),OTPscreen.class);
                intent2.putExtra("phone1",number);
                startActivity(intent2);
            }
        });





    }
}
