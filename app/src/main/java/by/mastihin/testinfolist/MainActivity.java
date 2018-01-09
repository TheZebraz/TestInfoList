package by.mastihin.testinfolist;

import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentModalBottomSheet fragmentModalBottomSheet = new FragmentModalBottomSheet();
//                fragmentModalBottomSheet.show(getSupportFragmentManager(),"BottomSheet Fragment");
//            }
//        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, MainFragment.newInstance())
                .commit();
    }
}
