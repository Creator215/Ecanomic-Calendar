package com.example.ekanomikkalendar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Object {
    private final String time;
    private final String star;
    private final String data;
    private String no_1;
    private String no_2;
    private String no_3;
    private String none = "&nbsp;";
    private String stars1 = "priority-1",stars2 = "priority-2",stars3 = "priority-3";

    public Object(String time,String sity,String sity_flag,String star,String data,String no_1,String no_2,String no_3){
        this.time = time;
        this.star = star;
        this.data = data;
        this.no_1 = no_1;
        this.no_2 = no_2;
        this.no_3 = no_3;

    }
    @SuppressLint("SetTextI18n")
    public void set_object(LinearLayout linearLayout, int width, int height){

        Taqqosla taqqosla = new Taqqosla(this.no_2,this.no_3);

        RelativeLayout relativeLayout = new RelativeLayout(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height/12);
        layoutParams.setMargins(0,0,0,15);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundColor(Color.rgb(30,37,43));

        RelativeLayout relativeLayout1 = new RelativeLayout(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(3*height/20,height/10);
        relativeLayout1.setLayoutParams(layoutParams1);

        LinearLayout linearLayout1 = new LinearLayout(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(3*height/40,height/20);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_START);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        linearLayout1.setLayoutParams(layoutParams2);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout1.setGravity(Gravity.CENTER);
        if(this.star.hashCode() == stars1.hashCode()){
            for(int i = 0;i < 1;i ++){
                ImageView imageView = new ImageView(linearLayout.getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(3*height/130,3*height);
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageResource(R.drawable.staron);
                linearLayout1.addView(imageView);
            }
            for(int i = 0;i < 2;i ++){
                ImageView imageView = new ImageView(linearLayout.getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(3*height/130,3*height);
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageResource(R.drawable.staroff);
                linearLayout1.addView(imageView);
            }

        }else if(this.star.hashCode() == stars2.hashCode()){
            for(int i = 0;i < 2;i ++){
                ImageView imageView = new ImageView(linearLayout.getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(3*height/130,3*height);
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageResource(R.drawable.staron);
                linearLayout1.addView(imageView);
            }
            for(int i = 0;i < 1;i ++){
                ImageView imageView = new ImageView(linearLayout.getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(3*height/130,3*height);
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageResource(R.drawable.staroff);
                linearLayout1.addView(imageView);
            }
        }else if(this.star.hashCode() == stars3.hashCode()){
            for(int i = 0;i < 3;i ++){
                ImageView imageView = new ImageView(linearLayout.getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(3*height/130,3*height);
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageResource(R.drawable.staron);
                linearLayout1.addView(imageView);
            }
        }

        TextView textView = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(3*height/40,height/20);
        layoutParams3.addRule(RelativeLayout.ALIGN_PARENT_START);
        layoutParams3.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(Gravity.CENTER);
        textView.setText(this.time);
        textView.setTextColor(Color.rgb(226,230,233));


        ImageView imageView = new ImageView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(height/25,height/25);
        layoutParams5.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams5.addRule(RelativeLayout.ALIGN_PARENT_END);
        layoutParams5.setMargins(0,0,width/40,0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setImageResource(R.drawable.amerika);

        relativeLayout1.addView(imageView);

        TextView textView1 = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(3*height/40,height/20);
        layoutParams4.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams4.addRule(RelativeLayout.ALIGN_PARENT_END);
        textView1.setLayoutParams(layoutParams4);
        textView1.setGravity(Gravity.CENTER);
        textView1.setTextSize(24);
        textView1.setTypeface(textView1.getTypeface(), Typeface.BOLD);

        textView1.setText(taqqosla.natija());
        textView1.setTextColor(taqqosla.rang());


        relativeLayout1.addView(textView1);
        relativeLayout1.addView(textView);
        relativeLayout1.addView(linearLayout1);
        relativeLayout.addView(relativeLayout1);

        TextView textView2 = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(17*height/52,height/15);
        layoutParams6.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams6.addRule(RelativeLayout.ALIGN_PARENT_END);
        textView2.setLayoutParams(layoutParams6);

        textView2.setGravity(Gravity.CENTER_VERTICAL);
        textView2.setText(this.data);
        textView2.setTextSize(12);
        textView2.setTextColor(Color.WHITE);

        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(17*height/52,height/30);
        layoutParams7.addRule(RelativeLayout.ALIGN_PARENT_END);
        layoutParams7.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        linearLayout2.setLayoutParams(layoutParams7);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);


        TextView textView3 = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(17*height/156,height/30);
        textView3.setLayoutParams(layoutParams8);
        textView3.setTextColor(Color.WHITE);
        textView3.setGravity(Gravity.CENTER);
        textView3.setTextSize(12);
        textView3.setText("Act: "+this.no_3.replace("&nbsp;",""));

        TextView textView4 = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(17*height/156,height/30);
        textView4.setLayoutParams(layoutParams9);
        textView4.setGravity(Gravity.CENTER);
        textView4.setTextColor(Color.WHITE);
        textView4.setTextSize(12);
        textView4.setText("Cons: "+this.no_2.replace("&nbsp;",""));

        TextView textView5 = new TextView(linearLayout.getContext());
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(17*height/156,height/30);
        textView5.setLayoutParams(layoutParams10);
        textView5.setGravity(Gravity.CENTER);
        textView5.setTextColor(Color.WHITE);
        textView5.setTextSize(12);
        textView5.setText("Prev: "+this.no_1.replace("&nbsp;",""));

        linearLayout2.addView(textView3);
        linearLayout2.addView(textView4);
        linearLayout2.addView(textView5);
        relativeLayout.addView(linearLayout2);
        relativeLayout.addView(textView2);
        linearLayout.addView(relativeLayout);
    }
}