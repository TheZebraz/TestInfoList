package by.mastihin.testinfolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheetFragment extends Fragment {


    public SheetFragment() {
        // Required empty public constructor
    }

    public static SheetFragment newInstance() {
        return new SheetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sheet, container, false);
    }

}
