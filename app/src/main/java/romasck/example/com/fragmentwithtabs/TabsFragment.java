package romasck.example.com.fragmentwithtabs;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsFragment extends Fragment {
    ViewPager pager;
    TabsFragmentAdapter adapter;
    TabLayout tabLayout;

    public TabsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
        pager = (ViewPager) rootView.findViewById(R.id.chat_view_pager);
        adapter = new TabsFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentOne(), getString(R.string.tab_chat_room_title));
        adapter.addFragment(new FragmentTwo(), getString(R.string.tab_chat_user_list_title));
        pager.setAdapter(adapter);

        tabLayout = (TabLayout) getActivity().findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).setCustomView(getTabIndicator(
                getActivity(), R.string.tab_chat_room_title, R.drawable.ic_chat_room_selector));
        tabLayout.getTabAt(1).setCustomView(getTabIndicator(
                getActivity(), R.string.tab_chat_user_list_title, R.drawable.ic_user_list_selector));

        return rootView;
    }

    private View getTabIndicator(Context context, int title, int icon) {
        TextView view = (TextView) LayoutInflater.from(context).inflate(R.layout.tab_header, null);
        view.setText(title);
        view.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        tabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
        tabLayout.setVisibility(View.GONE);
    }
}
