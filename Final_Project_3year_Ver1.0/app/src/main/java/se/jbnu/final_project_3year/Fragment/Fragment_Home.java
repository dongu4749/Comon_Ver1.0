package se.jbnu.final_project_3year.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import se.jbnu.final_project_3year.HomeActivity;
import se.jbnu.final_project_3year.Quiz.Quiz_Block_Coding_List_Activity;
import se.jbnu.final_project_3year.Quiz.Quiz_Multiple_choice_List_Activity;
import se.jbnu.final_project_3year.Quiz.Quiz_Short_Answer_List_Activity;
import se.jbnu.final_project_3year.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Home extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public Fragment_Home() {
        // Required empty public constructor
    }
    public static Fragment_Home newInstance() {
        return new Fragment_Home();
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Home newInstance(String param1, String param2) {
        Fragment_Home fragment = new Fragment_Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_home, container, false);

        Toolbar myToolbar = (Toolbar) v.findViewById(R.id.my_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(myToolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);
        Button btn_Daily = (Button) v.findViewById(R.id.buttonHomeDaily);
        Button btn_Trend = (Button) v.findViewById(R.id.buttonHomeTrend);
        Button btn_Keyword = (Button) v.findViewById(R.id.buttonHomeKeyword);


        btn_Daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).replaceFragment(Fragment_DailyKnowledge.newInstance());
            }
        });
        btn_Trend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).replaceFragment(Fragment_Trend.newInstance());
            }
        });
        btn_Keyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).replaceFragment(Fragment_Keyword.newInstance());
            }
        });

        drawerLayout = v.findViewById(R.id.drawer_layout);
        navigationView = v.findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.Quiz_Button){
                    Intent intent=new Intent(getActivity().getApplicationContext(), Quiz_Multiple_choice_List_Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.Quiz_typing){
                    Intent intent=new Intent(getActivity().getApplicationContext(), Quiz_Short_Answer_List_Activity.class);
                    startActivity(intent);
                }else if(id==R.id.Quiz_Block){
                    Intent intent=new Intent(getActivity().getApplicationContext(), Quiz_Block_Coding_List_Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.Quiz_CloseDrawbar){
                    //((HomeActivity)getActivity()).replaceFragment(Fragment_Home.newInstance());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home: {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}