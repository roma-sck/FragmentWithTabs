package romasck.example.com.fragmentwithtabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabsFragment extends Fragment {
    private FragmentTabHost mTabHost;

    public TabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tabs,container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.tabs_content);

        TabHost.TabSpec tab1 = mTabHost.newTabSpec("tab1").setIndicator("Fragment 1");
        TabHost.TabSpec tab2 = mTabHost.newTabSpec("tab2").setIndicator("Fragment 2");
        mTabHost.addTab(tab1, FragmentOne.class, null);
        mTabHost.addTab(tab2, FragmentTwo.class, null);

        return rootView;
    }

}
