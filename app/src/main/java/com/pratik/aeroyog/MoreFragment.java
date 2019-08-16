package com.pratik.aeroyog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MoreFragment extends Fragment {

    ImageView profilepic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view3= inflater.inflate(R.layout.fragment_more, container, false);

        profilepic=(ImageView)view3.findViewById(R.id.profilepic);

       Bitmap batmapBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.smiley);
       RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), batmapBitmap);

        circularBitmapDrawable.setCircular(true);
        profilepic.setImageDrawable(circularBitmapDrawable);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;


        LinearLayout layout = (LinearLayout)view3.findViewById(R.id.linearLayout3);
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) layout.getLayoutParams();
        params.height = width+2;


        CardView card1=(CardView)view3.findViewById(R.id.card1);
        ViewGroup.LayoutParams params1=(ViewGroup.LayoutParams)card1.getLayoutParams();
        params1.height=width/3;
        params1.width=width/3;


     CardView card2=(CardView)view3.findViewById(R.id.card2);
        ViewGroup.LayoutParams params2=(ViewGroup.LayoutParams)card2.getLayoutParams();
        params2.height=width/3;
        params2.width=width/3;

        CardView card3=(CardView)view3.findViewById(R.id.card3);
        ViewGroup.LayoutParams params3=(ViewGroup.LayoutParams)card3.getLayoutParams();
        params3.height=width/3;
     params3.width=width/3;

        CardView card4=(CardView)view3.findViewById(R.id.card4);
        ViewGroup.LayoutParams params4=(ViewGroup.LayoutParams)card4.getLayoutParams();
        params4.height=width/3;
     params4.width=width/3;

        CardView card5=(CardView)view3.findViewById(R.id.card5);
        ViewGroup.LayoutParams params5=(ViewGroup.LayoutParams)card5.getLayoutParams();
        params5.height=width/3;
     params5.width=width/3;

        CardView card6=(CardView)view3.findViewById(R.id.card6);
        ViewGroup.LayoutParams params6=(ViewGroup.LayoutParams)card6.getLayoutParams();
        params6.height=width/3;
     params6.width=width/3;

        CardView card7=(CardView)view3.findViewById(R.id.card7);
        ViewGroup.LayoutParams params7=(ViewGroup.LayoutParams)card7.getLayoutParams();
        params7.height=width/3;
     params7.width=width/3;

        CardView card8=(CardView)view3.findViewById(R.id.card8);
        ViewGroup.LayoutParams params8=(ViewGroup.LayoutParams)card8.getLayoutParams();
        params8.height=width/3;
     params8.width=width/3;

        CardView card9=(CardView)view3.findViewById(R.id.card9);
        ViewGroup.LayoutParams params9=(ViewGroup.LayoutParams)card9.getLayoutParams();
        params9.height=width/3;
     params9.width=width/3;



        return view3;
    }
}
