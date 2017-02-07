package cybin.cybinapptabs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SIONIN on 06/02/2017.
 */

public class TestFragment extends Fragment {
    public static TestFragment newInstance(String text) {
        TestFragment testFragment = new TestFragment();

        Bundle b = new Bundle();
        b.putString("text", text);

        testFragment.setArguments(b);

        return testFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment, container, false);

        ((TextView) view.findViewById(R.id.fragText)).setText(getArguments().getString("text"));

        return view;
    }
}
