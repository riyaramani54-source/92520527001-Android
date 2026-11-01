package com.rr;


import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

    private TextView logView;
    private int eventCount = 0;

    private void addEvent(String event) {
        eventCount++;

        String message = eventCount + ". " + event;

        android.util.Log.d("LifecycleDemo", message);

        if (logView != null) {
            logView.append(message + "\n");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(24, 24, 24, 24);
        mainLayout.setBackgroundColor(Color.rgb(245, 248, 255));

        TextView heading = new TextView(this);
        heading.setText("ANDROID ACTIVITY LIFECYCLE");
        heading.setTextSize(22);
        heading.setTextColor(Color.rgb(35, 65, 130));
        heading.setGravity(Gravity.CENTER);
        heading.setPadding(0, 12, 0, 12);
        mainLayout.addView(heading);

        TextView instructions = new TextView(this);
        instructions.setText(
                "Press Home to minimize the app, then reopen it. " +
                        "Watch the lifecycle events below."
        );
        instructions.setTextSize(16);
        instructions.setTextColor(Color.DKGRAY);
        instructions.setPadding(0, 8, 0, 16);
        mainLayout.addView(instructions);

        Button clearButton = new Button(this);
        clearButton.setText("Clear Event Log");
        mainLayout.addView(clearButton);

        TextView logHeading = new TextView(this);
        logHeading.setText("LIFECYCLE EVENT LOG");
        logHeading.setTextSize(18);
        logHeading.setTextColor(Color.BLACK);
        logHeading.setPadding(0, 16, 0, 8);
        mainLayout.addView(logHeading);

        ScrollView scrollView = new ScrollView(this);

        logView = new TextView(this);
        logView.setTextSize(15);
        logView.setTextColor(Color.rgb(20, 100, 65));
        logView.setPadding(12, 12, 12, 12);
        logView.setBackgroundColor(Color.WHITE);

        scrollView.addView(logView);

        mainLayout.addView(scrollView,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1
                )
        );

        setContentView(mainLayout);

        clearButton.setOnClickListener(v -> {
            logView.setText("");
            eventCount = 0;
        });

        addEvent("onCreate() - Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        addEvent("onStart() - Activity visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        addEvent("onResume() - Activity interactive");
    }

    @Override
    protected void onPause() {
        addEvent("onPause() - Activity losing focus");
        super.onPause();
    }

    @Override
    protected void onStop() {
        addEvent("onStop() - Activity no longer visible");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addEvent("onRestart() - Activity restarting");
    }

    @Override
    protected void onDestroy() {
        addEvent("onDestroy() - Activity being destroyed");
        super.onDestroy();
    }
}
