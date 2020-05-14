package com.example.facerecognition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import java.util.Random;

public class RectOverlay extends GraphicOverlay.Graphic {

    private  int RECT_COLOR = Color.RED;
    private  float STROKE_WIDTH =20.0f;
    private Paint rectPaint;
    GraphicOverlay graphicOverlay;
    Rect rect;
    public RectOverlay(GraphicOverlay graphicOverlay, Rect rect) {
        super(graphicOverlay);
        rectPaint = new Paint();
        rectPaint.setColor(Color.RED);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(STROKE_WIDTH);
        this.graphicOverlay = graphicOverlay;
        this.rect = rect;

        postInvalidate();
    }
    private int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(rect);
        rectF.left  =translateX(rectF.left);
        rectF.right  = translateX(rectF.right);
        rectF.top =translateY(rectF.top);
        rectF.bottom = translateY(rectF.bottom);

        canvas.drawRect(rectF,rectPaint);
    }
}
