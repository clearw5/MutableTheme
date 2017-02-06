package com.stardust.theme;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;

import com.stardust.tool.ContextReservoir;
import com.stardust.tool.ViewTool;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Stardust on 2016/5/10.
 */

public class ThemeColorManager {

    private static int mColorPrimary = 0xff4caf50;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextReservoir.getDefaultContext() != null)
                mColorPrimary = ViewTool.getColor(ContextReservoir.getDefaultContext(), android.R.attr.colorPrimary);
        }
    }

    public static void add(ThemeColorMutable colorMutable) {
        ThemeColorMutableManager.add(colorMutable);
    }

    public static void addViewBackground(View titleBarView) {
        BackgroundColorManager.add(titleBarView);
    }

    public static void addActivityStatusBar(Activity activity) {
        StatusBarManager.add(activity);
    }

    public static void addPaint(Paint paint) {
        PaintManager.add(paint);
    }

    public static void addActivityNavigationBar(final Activity activity) {
        if (Build.VERSION.SDK_INT > 19) {
            ThemeColorWidgetReferenceManager.add(new ThemeColorMutableReference() {
                WeakReference<Activity> weakReference = new WeakReference<>(activity);

                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void setColor(int color) {
                    activity.getWindow().setNavigationBarColor(color);
                }

                @Override
                public boolean isNull() {
                    return weakReference.get() == null;
                }
            });
        }
    }

    public static int getColorPrimary() {
        return mColorPrimary;
    }

    /**
     * 设置主题色并为记录的状态栏和标题栏改变颜色
     *
     * @param color 主题色RGB值
     */
    public static void setColorPrimary(int color) {
        mColorPrimary = color;
        BackgroundColorManager.setColor(mColorPrimary);
        StatusBarManager.setColor(mColorPrimary);
        PaintManager.setColor(mColorPrimary);
        ThemeColorMutableManager.setColor(mColorPrimary);
        ThemeColorWidgetReferenceManager.setColor(mColorPrimary);
    }

    private static class BackgroundColorManager {
        private static List<WeakReference<View>> views = new LinkedList<>();

        public static void add(View view) {
            views.add(new WeakReference<>(view));
            view.setBackgroundColor(mColorPrimary);
        }

        public static void setColor(int color) {
            Iterator<WeakReference<View>> iterator = views.iterator();
            while (iterator.hasNext()) {
                View view = iterator.next().get();
                if (view != null) {
                    view.setBackgroundColor(color);
                } else {
                    iterator.remove();
                }
            }
        }
    }

    private static class StatusBarManager {
        private static Vector<WeakReference<Activity>> activities = new Vector<>();

        @TargetApi(21)
        public static void add(Activity activity) {
            if (Build.VERSION.SDK_INT >= 21) {
                activities.add(new WeakReference<>(activity));
                activity.getWindow().setStatusBarColor(mColorPrimary);
            }
        }

        @TargetApi(21)
        public static void setColor(int color) {
            Iterator<WeakReference<Activity>> iterator = activities.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next().get();
                if (activity != null) {
                    activity.getWindow().setStatusBarColor(color);
                } else {
                    iterator.remove();
                }
            }
        }
    }

    private static class PaintManager {
        private static List<WeakReference<Paint>> paints = new LinkedList<>();

        public static void add(Paint paint) {
            paint.setColor(mColorPrimary);
            paints.add(new WeakReference<>(paint));
        }

        public static void setColor(int color) {
            Iterator<WeakReference<Paint>> iterator = paints.iterator();
            while (iterator.hasNext()) {
                Paint paint = iterator.next().get();
                if (paint != null) {
                    paint.setColor(color);
                } else {
                    iterator.remove();
                }
            }
        }
    }

    private static class ThemeColorWidgetReferenceManager {

        private static List<ThemeColorMutableReference> widgets = new LinkedList<>();

        public static void add(ThemeColorMutableReference widget) {
            widget.setColor(mColorPrimary);
            widgets.add(widget);
        }

        public static void setColor(int color) {
            Iterator<ThemeColorMutableReference> iterator = widgets.iterator();
            while (iterator.hasNext()) {
                ThemeColorMutableReference widget = iterator.next();
                if (!widget.isNull()) {
                    widget.setColor(color);
                } else {
                    iterator.remove();
                }
            }
        }

    }

    private static class ThemeColorMutableManager {

        private static List<WeakReference<ThemeColorMutable>> widgets = new LinkedList<>();

        public static void add(ThemeColorMutable widget) {
            widget.setColorPrimary(mColorPrimary);
            widgets.add(new WeakReference<>(widget));
        }

        public static void setColor(int color) {
            Iterator<WeakReference<ThemeColorMutable>> iterator = widgets.iterator();
            while (iterator.hasNext()) {
                ThemeColorMutable widget = iterator.next().get();
                if (widget != null) {
                    widget.setColorPrimary(color);
                } else {
                    iterator.remove();
                }
            }
        }

    }


}
