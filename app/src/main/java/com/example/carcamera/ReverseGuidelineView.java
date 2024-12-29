package com.example.carcamera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ReverseGuidelineView extends View {
    private Paint paint;

    public ReverseGuidelineView(Context context) {
        super(context);
        init();
    }

    public ReverseGuidelineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GREEN); // 辅助线颜色
        paint.setStrokeWidth(5);    // 辅助线宽度
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取视图宽高
        int width = getWidth();
        int height = getHeight();
        
        float leftStartX = width * 0.1f;
        float rightStartX = width * 0.9f;
        float centerX = width * 0.5f;
        float startY = height * 0.7f;
        float endY = height;

        // 绘制左侧辅助线
        canvas.drawLine(leftStartX, startY, leftStartX, endY, paint);

        // 绘制右侧辅助线
        canvas.drawLine(rightStartX, startY, rightStartX, endY, paint);

        // 绘制中间辅助线
        canvas.drawLine(centerX, startY, centerX, endY, paint);
    }
}
