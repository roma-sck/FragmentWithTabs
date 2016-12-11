package romasck.example.com.fragmentwithtabs;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


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
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);

        mTabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getActivity().getSupportFragmentManager(), android.R.id.tabcontent);

        TabHost.TabSpec tab1 = mTabHost
                .newTabSpec("tab1")
                .setIndicator(
                        getTabIndicator(mTabHost.getContext(),
                                R.string.tab_chat_room_title,
                                R.drawable.chat_room_tab)
                );
        TabHost.TabSpec tab2 = mTabHost
                .newTabSpec("tab2")
                .setIndicator(
                        getTabIndicator(mTabHost.getContext(),
                                R.string.tab_chat_user_list_title,
                                R.drawable.chat_user_list_tab)
                );

        mTabHost.addTab(tab1, FragmentOne.class, null);
        mTabHost.addTab(tab2, FragmentTwo.class, null);

        return rootView;
    }

    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_header, null);
        ImageView iv = (ImageView) view.findViewById(R.id.tab_icon_image);
        iv.setImageResource(icon);
        TextView tv = (TextView) view.findViewById(R.id.tab_title_text);
        tv.setText(title);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }

}
