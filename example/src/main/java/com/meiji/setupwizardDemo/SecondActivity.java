package com.meiji.setupwizardDemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.android.setupwizardlib.SetupWizardLayout;
import com.android.setupwizardlib.view.NavigationBar;

public class SecondActivity extends AppCompatActivity {

    SetupWizardLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        layout = findViewById(R.id.setup);

        layout.setHeaderText("Add your account");
        layout.setIllustrationAspectRatio(4f);

        final ScrollView scrollView = layout.getScrollView();

        layout.getNavigationBar().setNavigationBarListener(new NavigationBar.NavigationBarListener() {
            @Override
            public void onNavigateBack() {
                onBackPressed();
            }

            @Override
            public void onNavigateNext() {
                if (scrollView != null) {
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        //scroll view is at bottom
                        startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                    } else {
                        //scroll view is not at bottom
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);

                    }
                }
            }
        });
    }
}
