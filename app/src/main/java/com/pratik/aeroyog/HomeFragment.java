package com.pratik.aeroyog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    Button in,out;
    TextView stopwatch;
    ImageView gifofyoga;
    TextView fakestopwatch;


    //for dialogbox
    EditText ed_text1,ed_text2;
    String ed1,ed2;



    //chronometer
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes ;

  //  ListView listView ;
    String workout;
    TextView time1;
    String zerotime="00:00:00";


   ArrayAdapter<String> adapter ;

   ImageView propic;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        in = (Button) v.findViewById(R.id.in);
        stopwatch = (TextView) v.findViewById(R.id.stopwatch);
        out = (Button) v.findViewById(R.id.out);
        time1 = (TextView) v.findViewById(R.id.time1);
        gifofyoga = (ImageView) v.findViewById(R.id.gifofyoga);
        fakestopwatch = (TextView) v.findViewById(R.id.fakestopwatch);

        propic=(ImageView)v.findViewById(R.id.propic);

        gifofyoga.setVisibility(View.GONE);
        fakestopwatch.setVisibility(View.GONE);




        handler = new Handler();

        Bitmap batmapBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.smiley);
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), batmapBitmap);

        circularBitmapDrawable.setCircular(true);
        propic.setImageDrawable(circularBitmapDrawable);


        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                time1.setVisibility(View.GONE);

                //   Toast.makeText(getContext(),"Please enter your weight before starting workout !",Toast.LENGTH_SHORT).show();


                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_inweight);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(false);
                dialog.setTitle("Title...");

                final EditText inweight1=(EditText)dialog.findViewById(R.id.inweight1);
                final  Button cancel=(Button)dialog.findViewById(R.id.cancel);
                ed1=inweight1.getText().toString().trim();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button dialogButton = (Button) dialog.findViewById(R.id.submitweight1);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ed1=inweight1.getText().toString().trim();
                        int result = Integer.parseInt(ed1);

                        if (ed1.isEmpty() || ed1.length() == 0 || ed1.equals("") || ed1.equals("0"))
                        {
                            Toast.makeText(getContext(),"Please enter your weight before starting workout !",Toast.LENGTH_SHORT).show();

                        }
                        else if (result >150)
                        {
                            Toast.makeText(getContext(),"Are You sure you are not an ELEPHANT ?",Toast.LENGTH_SHORT).show();

                        }
                        else {

                            dialog.dismiss();
                            stopwatch.setVisibility(View.VISIBLE);
                            in.setVisibility(View.GONE);
                            out.setVisibility(View.VISIBLE);
                            gifofyoga.setVisibility(View.VISIBLE);
                            time1.setVisibility(View.INVISIBLE);
                            StartTime = SystemClock.uptimeMillis();
                            handler.postDelayed(runnable, 0);

                        }






                    }
                });

                dialog.show();
            }
        });





        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              //  Toast.makeText(getContext(),"Please enter your weight after working out !",Toast.LENGTH_SHORT).show();

                final Dialog dialog1 = new Dialog(getContext());
                dialog1.setContentView(R.layout.dialog_outweight);
                dialog1.setCanceledOnTouchOutside(false);
                dialog1.setCancelable(false);
                dialog1.setTitle("Title...");


                final EditText outtime=(EditText)dialog1.findViewById(R.id.out1);
                final  Button outcancel=(Button)dialog1.findViewById(R.id.cancelout);

                outcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });


                Button dialogButton1 = (Button) dialog1.findViewById(R.id.outsubmit);

                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed2=outtime.getText().toString().trim();
                        int result1 = Integer.parseInt(ed2);

                        if(ed2.isEmpty() || ed2.length() == 0 || ed2.equals("") || ed2.equals("0"))
                        {
                            Toast.makeText(getContext(),"Please enter your weight before starting workout !",Toast.LENGTH_SHORT).show();

                        }
                        else if (result1 >150)
                        {
                            Toast.makeText(getContext(),"Are You sure you are not an ELEPHANT ?",Toast.LENGTH_SHORT).show();

                        }
                        else {

                            dialog1.dismiss();

                            workout=stopwatch.getText().toString();
                            StartTime = 0L ;
                            TimeBuff = 0L ;
                            UpdateTime = 0L ;
                            Seconds = 0 ;
                            Minutes = 0 ;

                            stopwatch.setText(zerotime);
                            fakestopwatch.setVisibility(View.VISIBLE);
                            fakestopwatch.setText(zerotime);
                            stopwatch.setVisibility(View.INVISIBLE);
                            // in.setVisibility(View.VISIBLE);
                            time1.setText("You have Worked Out for "+workout);
                            gifofyoga.setVisibility(View.GONE);

                            out.setVisibility(View.INVISIBLE);
                            fakestopwatch.setVisibility(View.INVISIBLE);
                            in.setVisibility(View.VISIBLE);
                            gifofyoga.setVisibility(View.INVISIBLE);
                            stopwatch.setVisibility(View.INVISIBLE);
                            time1.setVisibility(View.VISIBLE);


                        }
                    }
                });


                dialog1.show();

    }
        });

        return v;

    }


    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            stopwatch.setText("" + Minutes + " Minutes : "
                    + String.format("%02d", Seconds)+" Seconds");

            handler.postDelayed(this, 0);
        }

    };



}
