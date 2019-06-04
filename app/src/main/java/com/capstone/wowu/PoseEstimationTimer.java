package com.capstone.wowu;

import android.os.CountDownTimer;
import android.widget.TextView;

public class PoseEstimationTimer {
    private CountDownTimer countDownTimer;
    private long leftsec=10000;
    private static boolean timerRunning=true;
    private String timeLeft="";

    // 자세인식 안내문구: 7초 뒤부터 Flickering,10초 뒤 사라짐
    public void startTimer(TextView count, TextView intro){
        countDownTimer=new CountDownTimer(leftsec,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                leftsec-=1000;
                timeLeft=" "+((leftsec/1000)+1);
                count.setText(timeLeft);
                if(leftsec<3000) {
                    new FlickeringAnimation().Flickering(intro);
                    new FlickeringAnimation().Flickering(count);
                }
            //tt.invalidate();
        }

            @Override
            public void onFinish() {
                count.setText("");
                intro.setText("");
                countDownTimer.cancel();
                timerRunning=false;
            }
        }.start();
        timerRunning=true;
    }

}