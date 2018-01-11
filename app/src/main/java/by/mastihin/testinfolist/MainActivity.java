package by.mastihin.testinfolist;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      //  setSupportActionBar(toolbar);
        View llBottomSheet = findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setHideable(true);
        Button button = findViewById(R.id.open);

        final Toolbar sheetToolbar = findViewById(R.id.sheet_toolbar);
        final ImageView imageView = findViewById(R.id.arrow);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        final View content = findViewById(R.id.content);

        ViewGroup.LayoutParams params = sheetToolbar.getLayoutParams();
        final int initHeight = params.height;

        final TextView toolbarTitle = sheetToolbar.findViewById(android.R.id.toolbar_title);

        sheetToolbar.setLayoutParams(params);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    imageView.setVisibility(View.GONE);
                }
                else {
                    imageView.setVisibility(View.VISIBLE);
                }
                Log.d("TAG", "onStateChanged: " + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (slideOffset > 0) {
                    if (slideOffset < 0.5) {
                        content.animate().translationY(-600 * slideOffset).setDuration(0).start();
                    }
                    imageView.animate().alpha(1 - slideOffset).setDuration(0).start();
                    ViewGroup.LayoutParams params = sheetToolbar.getLayoutParams();
                    params.height = initHeight + (int)(112 * slideOffset);
                    sheetToolbar.setLayoutParams(params);

                    toolbarTitle.animate().alpha(1 - slideOffset).setDuration(0).start();
                }
            }
        });

        // bottomSheetBehavior.setHideable(false);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.frame, MainFragment.newInstance())
//                .commit();
    }
}
