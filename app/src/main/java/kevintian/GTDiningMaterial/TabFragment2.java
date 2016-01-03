package kevintian.GTDiningMaterial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kevin on 12/23/2015.
 */
public class TabFragment2 extends Fragment {

    int hallNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_fragment_2,container,false);
        if(getArguments()!=null)
        {
            hallNumber = getArguments().getInt("Dining Hall");
        }
        System.out.println("Frag 2: " + hallNumber);
        return v;
    }
}