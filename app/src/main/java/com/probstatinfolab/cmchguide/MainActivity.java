package com.probstatinfolab.cmchguide;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.probstatinfolab.cmchguide.complain.ComplainActivity;
import com.probstatinfolab.cmchguide.links.LinkActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView optionsGV;
    ArrayList<Option> options;

    int img[] = {R.drawable.seba, R.drawable.porisheba, R.drawable.rog_nirnoy, R.drawable.tottho, R.drawable.map_2,
            R.drawable.proshno, R.drawable.sotorkota, R.drawable.porisongkhan, R.drawable.ovijog, R.drawable.jogajog,
            R.drawable.podokrom, R.drawable.hospital, R.drawable.link};

    OptionItemGridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        optionsGV = (GridView) findViewById(R.id.gridView);

        options = getOptions();
        gridAdapter = new OptionItemGridAdapter(getApplicationContext(), options);
        optionsGV.setAdapter(gridAdapter);

        optionsGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), options.get(position).getName() + " Option Clicked", Toast.LENGTH_SHORT).show();
                if(position == 0){


                } else if(position == 1){


                } else if(position == 2){


                }else if(position == 3){


                }else if(position == 4){


                }else if(position == 5){


                }else if(position == 6){


                }else if(position == 7){


                }else if(position == 8){
                    Intent intent = new Intent(MainActivity.this, ComplainActivity.class);
                    startActivity(intent);
                }else if(position == 9){


                }else if(position == 10){


                }else if(position == 11){


                }else if(position == 12){
                    Intent intent = new Intent(MainActivity.this, LinkActivity.class);
                    startActivity(intent);
                }else if(position == 13){

                }else if(position == 14){


                }else if(position == 15) {

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }else if (id == R.id.action_share) {

        }else if (id == R.id.action_rate) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Option> getOptions() {

        Resources resources = getResources();
        String optionNames[] = resources.getStringArray(R.array.options);

        ArrayList<Option> optionList = new ArrayList<Option>();

        for (int i = 0; i < optionNames.length; i++) {
            optionList.add(new Option(optionNames[i], img[i]));
        }
        return optionList;
    }

}
