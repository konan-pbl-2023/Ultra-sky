package com.example.prototypeapi22;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SystemBarController {

    public static void hide(Window window) {
        View decorView = window.getDecorView();
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, decorView);

        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        decorView.setOnApplyWindowInsetsListener(((view, windowInsets) -> {
            controller.hide(WindowInsetsCompat.Type.systemBars());
            return view.onApplyWindowInsets(windowInsets);
        }));
    }
}
