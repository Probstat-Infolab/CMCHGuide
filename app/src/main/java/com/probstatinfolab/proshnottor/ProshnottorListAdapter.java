package com.probstatinfolab.proshnottor;

/**
 * Created by RONY on 27-10-16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.probstatinfolab.cmchguide.R;

import java.util.ArrayList;

public class ProshnottorListAdapter extends BaseAdapter{

    Context context;
    ArrayList<Question> questions;

    public ProshnottorListAdapter(Context context, ArrayList<Question> questions) {
        this.context = context;
        this.questions = questions;

    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return questions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.prosnottor_list_item, parent, false);

            //initialize and assign views
            TextView tvQuestion, tvAnswer;
            final ImageView iconView;

            tvQuestion = (TextView) convertView.findViewById(R.id.textViewQuestion);
            tvAnswer = (TextView) convertView.findViewById(R.id.textViewAnswer);

            tvQuestion.setText(questions.get(position).getQues());
            tvAnswer.setText(questions.get(position).getAns());

            iconView = (ImageView) convertView.findViewById(R.id.imageViewQAState);
            final LinearLayout layoutAns = (LinearLayout) convertView.findViewById(R.id.layoutAnswer);
            final LinearLayout layouQues = (LinearLayout) convertView.findViewById(R.id.layoutQuestion);

            layoutAns.setVisibility(View.GONE);

            layouQues.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (layoutAns.getVisibility() == View.GONE) {
                        iconView.setImageResource(R.drawable.pragraph);
                        layoutAns.setVisibility(View.VISIBLE);
                        layoutAns.setBackgroundResource(R.drawable.label_lower_round);
                        layouQues.setBackgroundResource(R.drawable.label_upper_round);
                    } else {
                        layoutAns.setBackgroundResource(R.drawable.label_rounded_corner);
                        iconView.setImageResource(R.drawable.podokrom);
                        layoutAns.setVisibility(View.GONE);
                        layouQues.setBackgroundResource(R.drawable.label_rounded_corner);

                    }
                }
            });
        }
        return convertView;
    }

}

