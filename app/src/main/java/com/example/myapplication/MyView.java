package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    boolean playing;
    long lastTime = System.currentTimeMillis();
    Paint paint = new Paint();

    int N =10;
    float x[] = new float[N];
    float y[] = new float[N];
    float vx[] = new float[N];
    float vy[] = new float[N];

    public MyView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!playing){
            //initializing

            //initialize for int x and y maths
            for(int i =0; i<N-1;i++){
             x[i]= (int)(Math.random()*500);
             y[i]= (int)(Math.random()*500);
             vx[i]= (int)(Math.random()*6 - 3);
             vy[i]= (int)(Math.random()*6 - 3);
            }
            //
            paint.setColor(Color.BLUE);
            playing =true;
        }
        long nowTime = System.currentTimeMillis();

        for(int i =0;i<N-1;i++){
            canvas.drawCircle(x[i],y[i],20,paint);
            x[i]+=vx[i];
            y[i]+= vy[i];
            if(x[i]<0||x[i]>canvas.getWidth()){
                vx[i]*= -1;
            }
            if(y[i]<0||y[i]>canvas.getHeight()){
                vy[i]*= -1;
            }
        }



        invalidate();
        lastTime=nowTime;
    }
}
