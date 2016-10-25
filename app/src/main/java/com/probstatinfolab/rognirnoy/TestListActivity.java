package com.probstatinfolab.rognirnoy;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.probstatinfolab.cmchguide.R;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class TestListActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{


    ArrayList<Test> testList;
    ListView testListView;
    TestListAdapter testListAdapter;

    SearchView searchView;
    SearchManager searchManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        testListView = (ListView) findViewById(R.id.listViewTest);
        loadTestList("");
        testListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(TestListActivity.this, TestDetailsActivity.class);

                TextView tv = (TextView) view.findViewById(R.id.textViewTestFee);

                String testFee= tv.getText().toString();
                String testName = testList.get(position).getTestName();
                String testPlace = testList.get(position).getTestPlace();
                String testPre = testList.get(position).getTestPrerequisite();

                intent.putExtra("TestName",testName);
                intent.putExtra("TestFee", testFee);
                intent.putExtra("TestPlace", testPlace);
                intent.putExtra("TestPre", testPre);
                startActivity(intent);
            }
        });

        searchManager = (SearchManager)getSystemService(SEARCH_SERVICE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_testlist, menu);


        SearchView searchView = (SearchView) menu.findItem(R.id.action_search_test).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(menu);
        //searchView.requestFocus();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Test> getTestList(String k){

        ArrayList<Test> temp = new ArrayList<Test>();
        String testName[] = getResources().getStringArray(R.array.test_names);
        String testPlaces[] = getResources().getStringArray(R.array.test_place);
        String testFees[] = getResources().getStringArray(R.array.test_fee);
        String testPre[] = getResources().getStringArray(R.array.test_prerequisite);

        for(int i=0; i<testName.length; i++){
            temp.add(new Test(testName[i], testFees[i], testPlaces[i], testPre[i]));
        }

        if(k.equals("")){

            return temp;

        }else{

            for(int i= 0; i<testList.size(); i++){

                if(!testList.get(i).getTestName().toLowerCase().contains(k.toLowerCase())){
                    testList.remove(i);
                    i-=1;
                }

            }
            temp = testList;
        }

        return temp;
    }

    public void loadTestList(String key){

        testList = getTestList(key);
        testListAdapter = new TestListAdapter(testList, getApplicationContext());
        testListView.setAdapter(testListAdapter);

    }

    @Override
    public boolean onClose() {
        //Toast.makeText(getApplicationContext(), "On close", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_SHORT).show();

        loadTestList(newText);
        return false;
    }


    private class TestListAdapter extends BaseAdapter{

        Context context;
        ArrayList<Test> testList;

        public TestListAdapter(ArrayList<Test> testList, Context context) {
            this.testList = testList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return testList.size();
        }

        @Override
        public Object getItem(int position) {
            return testList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(convertView == null){
                convertView = inflater.inflate(R.layout.test_list_item, parent, false);
            }

            String free = getResources().getString(R.string.free);
            String taka = getResources().getString(R.string.taka);

            //our views
            TextView testName = (TextView) convertView.findViewById(R.id.textViewTestName);
            TextView testFee = (TextView) convertView.findViewById(R.id.textViewTestFee);

            if(testList.get(position).getTestFee().equals(free)){
                testFee.setText(testList.get(position).getTestFee());
            }else{
                testFee.setText(testList.get(position).getTestFee() + taka);
            }
            testName.setText(testList.get(position).getTestName());
            return convertView;
        }

    }
}
