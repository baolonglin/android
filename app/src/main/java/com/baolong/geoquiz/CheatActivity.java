package com.baolong.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ebaolin on 2015-01-19.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.baolong.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.baolong.geoquiz.answer_shown";

    private static final String CHEAT = "cheat";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private boolean mAnswerIsShown;


    private void setAnswerShownResult(boolean isAnswerShown) {
        mAnswerIsShown = isAnswerShown;
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        if(savedInstanceState != null) {
            mAnswerIsShown = savedInstanceState.getBoolean(CHEAT);
        }

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

        setAnswerShownResult(mAnswerIsShown);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(CHEAT, mAnswerIsShown);
    }

}
