package com.probstatinfolab.tottho;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.probstatinfolab.cmchguide.R;

import java.util.ArrayList;

public class TotthoActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tottho);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tottho, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class TotthoFragment extends Fragment {

        ListView departmentListView;
        DepartmentListAdapter departmentListAdapter;
        ArrayList<Department> outDoorDepartments, inDooorDepartments;
        Button mapButton;
        ImageView iconImageView;


        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public TotthoFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TotthoFragment newInstance(int sectionNumber) {

            TotthoFragment fragment = new TotthoFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);


            if(sectionNumber == 1){

            }else if(sectionNumber ==2){

            }

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tottho, container, false);

            departmentListView =(ListView) rootView.findViewById(R.id.listViewDepartments);

            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            if (sectionNumber == 1) {

                loadOutdoorDepartmentList();

            } else if (sectionNumber == 2) {

                loadIndoorDepartmentList();
            }

            return rootView;
        }


        public ArrayList<Department> getAllOutdoorDepartments(){

            ArrayList<Department> temp = new ArrayList<Department>();

            String[] outoorDepartmentNames = getResources().getStringArray(R.array.outdoor_department_names);
            String[] outDoorDepartmentServices = getResources().getStringArray(R.array.outdoor_department_services);
            String[] outDoorDepartmentPositions = getResources().getStringArray(R.array.outdoor_department_position);

            for(int i = 0; i<outoorDepartmentNames.length; i++){

                temp.add(new Department(outoorDepartmentNames[i], outDoorDepartmentServices[i], outDoorDepartmentPositions[i]));

            }

            //Toast.makeText(getActivity(), temp.get(0).getName(), Toast.LENGTH_SHORT).show();

            return temp;

        }

        public ArrayList<Department> getAllIndoorDepartments(){

            ArrayList<Department> temp = new ArrayList<Department>();

            String[] indoorDepartmentNames = getResources().getStringArray(R.array.indoor_department_names);
            String[] indoorDepartmentServices = getResources().getStringArray(R.array.indoor_department_services);
            String[] indoorDepartmentPositions = getResources().getStringArray(R.array.indoor_department_position);

            for(int i = 0; i<indoorDepartmentNames.length; i++){

                temp.add(new Department(indoorDepartmentNames[i], indoorDepartmentServices[i], indoorDepartmentPositions[i]));

            }

            return temp;

        }

        public void loadOutdoorDepartmentList(){

            outDoorDepartments = getAllOutdoorDepartments();
            departmentListAdapter = new DepartmentListAdapter(getActivity(), outDoorDepartments);
            departmentListView.setAdapter(departmentListAdapter);

        }

        public void loadIndoorDepartmentList(){

            inDooorDepartments = getAllIndoorDepartments();
            departmentListAdapter = new DepartmentListAdapter(getActivity(), inDooorDepartments);
            departmentListView.setAdapter(departmentListAdapter);

        }

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return TotthoFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "বহিঃবিভাগ সমূহ";
                case 1:
                    return "অন্তঃবিভাগ সমূহ";

            }
            return null;
        }
    }
}
