package com.test3.hotkang.test3;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Random;

public class AnimationView extends View
{
    public float bitmapX;
    public float bitmapY;
    public AnimationView(Context context)
    {
        super(context);
        bitmapX = 300;
        bitmapY = 300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //WindowManager windowManager = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        //int width = windowManager.getDefaultDisplay().getWidth();
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Random random = new Random();
        bitmapX = random.nextInt(width);
        bitmapY = random.nextInt(height);
        Paint paint = new Paint();
        //从资源文件中生成位图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.butterflysmall);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
        if(bitmap.isRecycled()) //判断bitmap是否被回收
        {
            bitmap.recycle(); //强制回收
        }
    }
}