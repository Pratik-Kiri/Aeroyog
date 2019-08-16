package com.pratik.aeroyog;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image3,
    };
    // list of titles
    public String[] lst_title = {
            "Yoga",
            "Aerobics",
            "Aeroyog",
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "\"Yoga means addition – addition of energy, strength and beauty to body, mind and soul.\"\n\t–Amit Ray",
            "\"A photographer gets people to pose for him. A yoga instructor gets people to pose for themselves.\"\n\t–T. Guillemets",
            "\"The body is your temple. Keep it pure and clean for the soul to reside in.\"\n\t–B.K.S Iyengar"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
           // Color.rgb(55,55,55)
            Color.rgb(1,188,212),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            //Color.rgb(1,188,212)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
