package dev.com.sfilizzola.waferchallenge;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Locale;

import timber.log.Timber;

public class BaseApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(@NonNull StackTraceElement element) {
                    return String.format(Locale.getDefault(),"(%s:%s)", element.getFileName(), element.getLineNumber());
                }
            });
        } else {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected boolean isLoggable(String tag, int priority) {
                    return priority == Log.WARN || priority == Log.ERROR;
                }
            });
        }
    }
}
