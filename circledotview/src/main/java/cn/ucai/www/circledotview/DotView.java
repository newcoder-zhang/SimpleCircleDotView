package cn.ucai.www.circledotview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/9/6.
 */
public class DotView extends View {

    private int circleCorlor;
    private float circleRadius;
    private Paint mPaint;

    public DotView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DotView);
        circleCorlor = array.getColor(R.styleable.DotView_fillColor, Color.GRAY);
        circleRadius = array.getDimension(R.styleable.DotView_circleRadius,10);
        array.recycle();

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(circleCorlor);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(10,10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        int x=(getRight()-getLeft())/2;
        int y=(getBottom()-getTop())/2;
        canvas.drawCircle(x,y,circleRadius,mPaint);
    }
}
