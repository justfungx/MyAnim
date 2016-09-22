package tw.org.iii.myanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private ObjectAnimator anim1, anim2, anim3;
    private View drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
        drawer = findViewById(R.id.drawer);
        drawer.setX(-200f);
        drawer.setY(0f);
    }

    public void test1(View v) {
        anim1 = ObjectAnimator.ofFloat(img, "x", 0, 100, 200, 300, 400, 300, 400, 360, 400, 380, 400);
        anim1.setDuration(4 * 1000);
        anim1.setRepeatCount(0);
        anim1.start();
    }

    public void test2(View v) {
        anim1 = ObjectAnimator.ofFloat(img, "y", 0, 400);
        anim1.setDuration(4 * 1000);
        anim1.setRepeatCount(0);
        anim1.start();
    }

    public void test3(View v) {
        anim1 = ObjectAnimator.ofFloat(drawer, "x", -200, 0);
//        anim1.setDuration(4*1000);
//        anim1.setRepeatCount(0);

        anim2 = ObjectAnimator.ofFloat(drawer, "alpha", 0f, 1f);
//        anim2.setDuration(4*1000);
//        anim2.setRepeatCount(0);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(anim1, anim2);
        set.setDuration(2 * 1000);
        set.start();
    }

    public void test4(View v) {
        anim1 = ObjectAnimator.ofFloat(img, "x", 0, 400);
        anim2 = ObjectAnimator.ofFloat(img, "y", 0, 800);
//        anim2 = ObjectAnimator.ofFloat(img, "rotationX", 0f,360f,0f,360f,0f,360f,0f);
//        anim3 = ObjectAnimator.ofFloat(img, "rotationY", 0f,360f,0f,360f,0f,360f,0f);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(anim1, anim2);
        set.setDuration(2 * 1000);
        set.start();

    }
}
