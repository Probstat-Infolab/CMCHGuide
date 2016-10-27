package com.probstatinfolab.rognirnoy;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.probstatinfolab.cmchguide.MainActivity;
import com.probstatinfolab.cmchguide.R;

public class TestDetailsActivity extends AppCompatActivity {

    private TextView testName, testFee, testPlace, testPre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);

        initializeViews();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_details, menu);

        return true;
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
        else if(id == R.id.action_home){

            Intent intent = new Intent(this, MainActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeViews() {

        testName = (TextView)findViewById(R.id.textViewTestDetailsName);
        testFee = (TextView)findViewById(R.id.textViewTestDetailsFee);
        testPlace = (TextView)findViewById(R.id.textViewTestDetailsPlace);
        testPre = (TextView)findViewById(R.id.textViewTestDetailsPre);

        Intent intent = getIntent();

        testName.setText( testName.getText()+" " + intent.getStringExtra("TestName"));
        testFee.setText(testFee.getText() +" "+ intent.getStringExtra("TestFee"));
        testPlace.setText(intent.getStringExtra("TestPlace"));
        testPre.setText(intent.getStringExtra("TestPre"));

    }
}
