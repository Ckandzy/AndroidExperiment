package com.test3.hotkang.test3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Random;

public class BubbleDragon extends View
{
    public float bitmapX_1;
    public float bitmapY_1;
    public float bitmapX_2;
    public float bitmapY_2;
    public boolean isCatch;
    public BubbleDragon(Context context)
    {
        super(context);
        bitmapX_1 = 300;
        bitmapY_1 = 300;
        bitmapX_2 = 400;
        bitmapY_2 = 400;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        //绘制矩形区域-实心矩形
        //paint.setColor(Color.WHITE);
        //paint.setStyle(Paint.Style.FILL); //设置样式-填充
        //canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), paint); //绘文字
        //paint.setColor(Color.GREEN);
        //canvas.drawText(str, 30, 30, paint); //绘图
        //从资源文件中生成位图
        Bitmap bitmap_1 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
        canvas.drawBitmap(bitmap_1, bitmapX_1, bitmapY_1, paint);
        if(bitmap_1.isRecycled()) //判断bitmap是否被回收
        {
            bitmap_1.recycle(); //强制回收
        }

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Random random = new Random();
        bitmapX_2 = random.nextInt(width);
        bitmapY_2 = random.nextInt(height);
        //从资源文件中生成位图
        Bitmap bitmap_2 = BitmapFactory.decodeResource(getResources(), R.drawable.butterflysmall);
        canvas.drawBitmap(bitmap_2, bitmapX_2, bitmapY_2, paint);
        if(bitmap_2.isRecycled()) //判断bitmap是否被回收
        {
            bitmap_2.recycle(); //强制回收
        }

        if(canCatch(bitmapX_1 + bitmap_1.getWidth()/2, bitmapY_1 + bitmap_1.getHeight()/2,
                bitmapX_2 + bitmap_2.getWidth()/2, bitmapY_2 + bitmap_1.getHeight()/2))
        {
            paint.setTextSize(40);
            canvas.drawText("抓住啦", bitmapX_1, bitmapY_1, paint);
        }
    }

    public boolean canCatch(float bitmapX_1, float bitmapY_1, float bitmapX_2, float bitmapY_2)
    {
        if((Math.abs(bitmapX_1 - bitmapX_2) < 150) && (Math.abs(bitmapY_1 - bitmapY_2) < 150))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
