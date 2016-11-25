package com.lihaizhou.piechartdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class PieChartView extends View{
    private PieDataBean pieDataBeen;
    private float mStartAngle = 0;
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69};
    private int mWidth, mHeight;
    private Paint mPaint = new Paint();

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    private void initPaint()
    {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void setData(PieDataBean pieDataBeen)
    {
        this.pieDataBeen = pieDataBeen;
        initData(pieDataBeen);
        invalidate();
    }

    private void initData(PieDataBean pieDataBeen)
    {
        if(pieDataBeen == null)
        {
            return;
        }
        else
        {
            int wholeSum = 0;
            float percentage = 0;
            float[] percentages = new float[5];
            float[] sumAngles = new float[5];
            for(int i =0;i<pieDataBeen.getFuritNames().length;i++) {
                wholeSum+=pieDataBeen.getFruitSum()[i];
            }
            for(int i =0;i<pieDataBeen.getFuritNames().length;i++)
            {
                pieDataBeen.setColors(mColors);
                percentage = pieDataBeen.getFruitSum()[i] / (float)wholeSum;
                percentages[i] = percentage;
                pieDataBeen.setFruitPercentages(percentages);
                sumAngles[i] = percentage*360;
                pieDataBeen.setFruitAngles(sumAngles);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == pieDataBeen)
        {
            return;
        }
        float curStartAngle = mStartAngle;
        canvas.translate(mWidth/2,mHeight/2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);  // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);                     // 饼状图绘制区域
        for (int i = 0;i<pieDataBeen.getFuritNames().length;i++)
        {
            mPaint.setColor(pieDataBeen.getColors()[i]);
            canvas.drawArc(rect, curStartAngle, pieDataBeen.getFruitAngles()[i]-1, true, mPaint);
            curStartAngle += pieDataBeen.getFruitAngles()[i];
        }
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
    }
}