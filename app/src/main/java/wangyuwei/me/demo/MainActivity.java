package wangyuwei.me.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.wangyuwei.costtime.Cost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();

        doSomeThing(new Runnable() {
            @Cost
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        doSomeThing(new Runnable() {
            @Cost
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Cost
    public void show() {
        for (int i = 0; i < 100; i++) {

        }
    }

    private void doSomeThing(Runnable runnable) {
        new Thread(runnable).start();
    }
}
