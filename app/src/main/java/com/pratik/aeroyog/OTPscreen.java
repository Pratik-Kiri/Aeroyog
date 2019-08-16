package com.pratik.aeroyog;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTPscreen extends AppCompatActivity {

    TextView phonenum;
    Button verify;
    Button changenum;
    String enterdnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_otpscreen);


        phonenum=(TextView)findViewById(R.id.phonenumber);
        verify=(Button)findViewById(R.id.verify);
        changenum=(Button)findViewById(R.id.changenum);

        Intent intent=getIntent();
        enterdnumber=intent.getStringExtra("phone1");
        phonenum.setText("+91 "+enterdnumber);

        changenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),EnterNumber.class);
                startActivity(a);
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(getApplicationContext(),NavbarActivity.class);
                startActivity(b);
            }
        });

    }
}
