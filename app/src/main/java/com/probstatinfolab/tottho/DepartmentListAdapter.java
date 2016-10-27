package com.probstatinfolab.tottho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.probstatinfolab.cmchguide.R;

import java.util.ArrayList;

/**
 * Created by RONY on 26-10-16.
 */
public class DepartmentListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Department> departments;

    public DepartmentListAdapter(Context context, ArrayList<Department> departmentList) {
        this.context = context;
        this.departments = departmentList;

    }

    @Override
    public int getCount() {
        return departments.size();
    }

    @Override
    public Object getItem(int position) {
        return departments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.department_list_item, parent, false);

            //initialize and assign views
            TextView tvName, tvService, tvPosition;
            Button mapButton;
            final ImageView iconView;

            tvName = (TextView) convertView.findViewById(R.id.textViewDepartmentName);
            tvPosition = (TextView) convertView.findViewById(R.id.textViewDepartmentPosition);
            tvService = (TextView) convertView.findViewById(R.id.textViewDepartmentService);

            tvName.setText(departments.get(position).getName());
            tvService.setText(departments.get(position).getService());
            tvPosition.setText(departments.get(position).getPosition());

            mapButton = (Button) convertView.findViewById(R.id.buttonDepartmentShowMap);
            iconView = (ImageView) convertView.findViewById(R.id.imageViewState);
            final LinearLayout layoutDetails = (LinearLayout) convertView.findViewById(R.id.layoutDetails);
            final LinearLayout layouLebel = (LinearLayout) convertView.findViewById(R.id.layoutLabel);

            layoutDetails.setVisibility(View.GONE);
            mapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Map Button Clicked", Toast.LENGTH_SHORT).show();
                }
            });

            layouLebel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (layoutDetails.getVisibility() == View.GONE) {
                        iconView.setImageResource(R.drawable.pragraph);
                        layoutDetails.setVisibility(View.VISIBLE);
                        layoutDetails.setBackgroundResource(R.drawable.label_lower_round);
                        layouLebel.setBackgroundResource(R.drawable.label_upper_round);
                    } else {
                        layoutDetails.setBackgroundResource(R.drawable.label_rounded_corner);
                        iconView.setImageResource(R.drawable.podokrom);
                        layoutDetails.setVisibility(View.GONE);
                        layouLebel.setBackgroundResource(R.drawable.label_rounded_corner);

                    }
                }
            });
        }

        return convertView;
    }

}
