package com.poolmuth.s.tutotappydefend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by sylva on 17.12.2017.
 */

public class TDView extends SurfaceView implements Runnable{
    volatile boolean playing;
    Thread gameThread = null;

    public TDView(Context context) {
        super(context);
    }

    public TDView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

        @Override
        public void run() {
            while (playing) {
                update();
                draw();
                control();
            }
        }
        private void update(){
        }
        private void draw(){
        }
        private void control(){
        }

    // Clean up our thread if the game is interrupted or the player
    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }
    // Make a new thread and start it
// Execution moves to our R
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
