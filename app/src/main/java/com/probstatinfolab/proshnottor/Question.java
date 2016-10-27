package com.probstatinfolab.proshnottor;

/**
 * Created by RONY on 27-10-16.
 */
public class Question {
    private  String  ques, ans;

    public Question(String ques, String ans) {
        this.ques = ques;
        this.ans = ans;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
