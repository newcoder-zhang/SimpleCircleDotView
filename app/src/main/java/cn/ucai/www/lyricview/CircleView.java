package cn.ucai.www.lyricview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/9/5.
 */
public class CircleView extends ImageView{

    private int radius;
    private Paint mPaint;
    private Paint bitmapPaint;
    private int src_id;
    private Bitmap bitmap;
    private int bitmap_height;
    private int bitmap_width;
    private BitmapFactory.Options options;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        radius = array.getInt(R.styleable.CircleView_radius, 50);
        src_id = array.getResourceId(R.styleable.CircleView_mysrc, R.mipmap.ic_launcher);
        array.recycle();

        mPaint = new Paint();
        bitmapPaint = new Paint();

        options = new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        bitmap=BitmapFactory.decodeResource(getResources(),src_id, options);
        bitmap_height = options.outHeight;
        bitmap_width = options.outWidth;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        canvas.drawCircle((getRight()-getLeft())/2,(getBottom()-getTop())/2,radius,mPaint);

        int sample=calculateSample();
        options.inJustDecodeBounds=false;
        options.inSampleSize=sample;
        bitmap=BitmapFactory.decodeResource(getResources(),src_id,options);

        canvas.drawBitmap(bitmap,getLeft(),getTop(),bitmapPaint);

    }

    private int calculateSample() {
        int view_height=getHeight();
        int view_width=getWidth();
       return bitmap_height/view_height>bitmap_width/view_width?bitmap_height/view_height:bitmap_width/view_width;
    }

}
