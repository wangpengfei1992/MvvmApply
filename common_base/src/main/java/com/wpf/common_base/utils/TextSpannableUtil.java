package com.wpf.common_base.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;

/**
 * Created by anker on 2020/11/12.
 *
 * @author nina.ma
 */
public class TextSpannableUtil {
    public static void setTextSpannable(TextView spannableView, String spanText, String spanText_suffix, View.OnClickListener listener) {
        setTextSpannable(spannableView, spanText, spanText_suffix, Color.parseColor("#7FFFFFFF"), listener);
    }

    public static boolean setTextSpannable(TextView spannableView, String spanText, String spanText_suffix, @ColorInt int color, View.OnClickListener listener) {
        SpannableString spannableHome = new SpannableString(spanText);
        int useIndex = spanText.indexOf(spanText_suffix);
        if (useIndex == -1) {
            return false;
        }
        spannableHome.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view);
                }
            }
        }, useIndex, useIndex + spanText_suffix.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableHome.setSpan(new ForegroundColorSpan(color), useIndex,
                useIndex + spanText_suffix.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableView.setText(spannableHome);
        return true;
    }

    public static boolean setTextSpColor(TextView spannableView, String spanText, String spanText_suffix, @ColorInt int color) {
        SpannableString spannableHome = new SpannableString(spanText);
        int useIndex = spanText.indexOf(spanText_suffix);
        if (useIndex == -1) {
            return false;
        }
        spannableHome.setSpan(new ForegroundColorSpan(color), useIndex,
                useIndex + spanText_suffix.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableView.setText(spannableHome);
        return true;
    }

    /**
     * ??????????????????????????????
     *
     * @param spannableView
     * @param spanText
     * @param spanText_suffix
     * @param proportion
     */
    public static void setRelativeSizeSpan(TextView spannableView, String spanText, String spanText_suffix,
                                           @FloatRange(from = 0) float proportion) {
        if (TextUtils.isEmpty(spanText)) {
            return;
        }
        SpannableString spannableHome = new SpannableString(spanText);
        int useIndex = spanText.indexOf(spanText_suffix);
        if (useIndex == -1) {
            return;
        }
        spannableHome.setSpan(new RelativeSizeSpan(proportion), useIndex, useIndex + spanText_suffix.length(),
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableView.setText(spannableHome);
    }

    /**
     * ????????????????????????,?????????????????????????????????
     *
     * @param spannableView
     * @param spanText
     * @param spanText_suffix
     * @param rangeForAll     ????????????????????????????????????
     * @param proportion
     */
    public static void setStrikeAndRelativeSize(TextView spannableView, String spanText, String spanText_suffix,
                                                boolean rangeForAll, @FloatRange(from = 0) float proportion) {
        if (TextUtils.isEmpty(spanText)) {
            return;
        }
        SpannableString spannableHome = new SpannableString(spanText);
        int useIndex = spanText.indexOf(spanText_suffix);
        if (useIndex == -1) {
            return;
        }
        if (rangeForAll) {
            spannableHome.setSpan(new StrikethroughSpan(), 0, spanText.length(),
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            spannableHome.setSpan(new StrikethroughSpan(), useIndex, useIndex + spanText_suffix.length(),
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        spannableHome.setSpan(new RelativeSizeSpan(proportion), useIndex, useIndex + spanText_suffix.length(),
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableView.setText(spannableHome);
    }

    /**
     * ?????????copy??????????????????
     */
    public static void copyTextToClipboard(Context context, String content) {
        //???????????????????????????
        ClipboardManager cm = (ClipboardManager) (context.getSystemService(Context.CLIPBOARD_SERVICE));
        // ?????????????????????ClipData
        ClipData mClipData = ClipData.newPlainText("Label", content);
        // ???ClipData?????????????????????????????????
        cm.setPrimaryClip(mClipData);
    }


    public static class SpannableConfig {
        private String spanText;
        private String spanTextSuffix;
        private int spanColor;
        private boolean hasUnderLine;
        private View.OnClickListener listener;

        public SpannableConfig setSpanText(String spanText) {
            this.spanText = spanText;
            return this;
        }

        public SpannableConfig setSpanTextSuffix(String spanTextSuffix) {
            this.spanTextSuffix = spanTextSuffix;
            return this;
        }

        public SpannableConfig setSpanColor(int spanColor) {
            this.spanColor = spanColor;
            return this;
        }

        public SpannableConfig setOnClickListener(View.OnClickListener listener) {
            this.listener = listener;
            return this;
        }

        public SpannableConfig setHasUnderLine(boolean hasUnderLine) {
            this.hasUnderLine = hasUnderLine;
            return this;
        }

        public void into(TextView textViews) {
            SpannableString spannableHome = new SpannableString(spanText);
            int useIndex = spanText.indexOf(spanTextSuffix);
            if (useIndex == -1) {
                return;
            }

            spannableHome.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onClick(view);
                    }
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    if (hasUnderLine) {
                        super.updateDrawState(ds);
                    } else {
                        ds.setUnderlineText(false);
                    }
                }
            }, useIndex, useIndex + spanTextSuffix.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableHome.setSpan(new ForegroundColorSpan(spanColor),
                    useIndex, useIndex + spanTextSuffix.length(), SpannableString
                            .SPAN_EXCLUSIVE_EXCLUSIVE);

            textViews.setMovementMethod(LinkMovementMethod.getInstance());
            textViews.setText(spannableHome);
        }

    }

    /**
     * SpannableString ???????????????????????????
     *
     * @param context       ?????????
     * @param startText     ???????????????
     * @param endText       ???????????????
     * @param startPosition ?????????????????????????????????
     * @param endPosition   ?????????????????????????????????
     * @param changeColor   ?????????????????????
     * @param changeSize    ?????????????????????
     * @return SpannableString
     */
    public static SpannableString spannableColorSize(Context context, String startText, String endText, int startPosition,
                                                     int endPosition, int changeColor, int changeSize) {
        SpannableString spannableString = new SpannableString(startText + endText);
        spannableString.setSpan(new ForegroundColorSpan(changeColor),
                startPosition,
                endPosition,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtil.dip2px(context, changeSize)),
                startPosition,
                endPosition,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
