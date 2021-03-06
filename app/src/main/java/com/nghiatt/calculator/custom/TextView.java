package com.nghiatt.calculator.custom;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import com.nghiatt.calculator.R;

import java.io.IOException;

/**
 * Created by FRAMGIA\tran.thanh.nghia on 08/09/2015.
 */
public class TextView extends android.widget.TextView {
    public TextView(Context context) {
        this(context, null);
    }

    public TextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.TextView);
            String font = a.getString(R.styleable.TextView_font);

            if (font != null) {

                if (!font.contains("."))
                    font += ".ttf"; // Add default font's extension.
                try {
                    Typeface typeface = Typeface.createFromAsset(context.getAssets(), font);
                    if (typeface != null) {
                        setTypeface(typeface);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            a.recycle();
        }
    }

}
