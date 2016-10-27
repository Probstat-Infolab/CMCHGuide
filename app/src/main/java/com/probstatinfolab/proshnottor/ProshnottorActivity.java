package com.probstatinfolab.proshnottor;

import android.content.res.Resources;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.probstatinfolab.cmchguide.R;

import java.util.ArrayList;

public class ProshnottorActivity extends AppCompatActivity {

    ListView lvQA;
    ProshnottorListAdapter  qaAListAdapter;
    ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshnottor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        lvQA = (ListView) findViewById(R.id.listViewQA);
        questionList = getQuestionsList();
        qaAListAdapter = new ProshnottorListAdapter(this,  questionList);
        lvQA.setAdapter(qaAListAdapter);
    }

    private ArrayList<Question> getQuestionsList() {

        ArrayList<Question> temp = new ArrayList<Question>();
        Resources res = getResources();
        String[] q = res.getStringArray(R.array.q_array);
        String[] a = res.getStringArray(R.array.a_array);

        for(int i=0; i< q.length; i++){

            temp.add(new Question(q[i], a[i]));
        }

        return temp;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proshnottor, menu);
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

}



