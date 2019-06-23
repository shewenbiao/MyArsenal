package com.example.androidtestdemo.robolectric;

import android.content.Intent;

import com.example.androidtestdemo.MainActivity;
import com.example.androidtestdemo.R;
import com.example.androidtestdemo.SecondActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    /**
     * 验证点击事件是否触发了页面跳转。验证目标页面是否预期页面
     *
     * @throws Exception
     */
    @Test
    public void testJump() throws Exception {
        // 默认会调用Activity的生命周期: onCreate->onStart->onResume
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        // 触发button点击
        activity.findViewById(R.id.activity_main_jump).performClick();
        // 获取相应的Shadow类
        ShadowActivity shadowActivity = shadowOf(activity);
        // 借助Shadow类获取启动下一Activity的Intent
        Intent nextIntent = shadowActivity.getNextStartedActivity();
        // 校验Intent的正确性
        assertEquals(nextIntent.getComponent().getClassName(), SecondActivity.class.getName());
    }

    @Test
    public void testLifecycle() throws Exception {
        // 创建Activity控制器
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();
        assertNotNull(activity.getLifecycle().getCurrentState());

        // 调用Activity的performCreate方法
        controller.create();
        assertEquals("CREATED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performStart方法
        controller.start();
        assertEquals("STARTED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performResume方法
        controller.resume();
        assertEquals("RESUMED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performPause方法
        controller.pause();
        assertEquals("STARTED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performStop方法
        controller.stop();
        assertEquals("CREATED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performRestart方法
        controller.restart();
        // 注意此处应该是STARTED。由于performRestart不仅会调用restart，还会调用onStart
        assertEquals("STARTED", activity.getLifecycle().getCurrentState().toString());

        // 调用Activity的performDestroy方法
        controller.destroy();
        assertEquals("DESTROYED", activity.getLifecycle().getCurrentState().toString());

        // start for robolectric 3.x
        // 创建Activity控制器
//        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
//        MainActivity activity = controller.get();
//        assertNull(activity.getLifecycleState());
//
//        // 调用Activity的performCreate方法
//        controller.create();
//        assertEquals("onCreate", activity.getLifecycleState());
//
//        // 调用Activity的performStart方法
//        controller.start();
//        assertEquals("onStart", activity.getLifecycleState());
//
//        // 调用Activity的performResume方法
//        controller.resume();
//        assertEquals("onResume", activity.getLifecycleState());
//
//        // 调用Activity的performPause方法
//        controller.pause();
//        assertEquals("onPause", activity.getLifecycleState());
//
//        // 调用Activity的performStop方法
//        controller.stop();
//        assertEquals("onStop", activity.getLifecycleState());
//
//        // 调用Activity的performRestart方法
//        controller.restart();
//        // 注意此处应该是onStart。由于performRestart不仅会调用restart，还会调用onStart
//        assertEquals("onStart", activity.getLifecycleState());
//
//        // 调用Activity的performDestroy方法
//        controller.destroy();
//        assertEquals("onDestroy", activity.getLifecycleState());
        //end for robolectric 3.x
    }

    /**
     * 启动Activity的时候传递Intent
     *
     * @throws Exception
     */
    @Test
    public void testStartActivityWithIntent() throws Exception {
        // start for robolectric 3.x
//        Intent intent = new Intent();
//        intent.putExtra("test", "HelloWorld");
//        Activity activity = Robolectric.buildActivity(MainActivity.class).withIntent(intent).create().get();
//        assertEquals("HelloWorld", activity.getIntent().getExtras().getString("test"));
        //end for robolectric 3.x

    }

    /**
     * 在真实环境下，视图是在onCreate之后的某一时刻在attach到Window上的，在此之前。View是处于不可操作状态的，你不能点击它。
     *
     * 在Activity的onPostResume方法调用之后。View才会attach到Window之中。可是，在Robolectric之中，我们能够用控制器的visible方法使得View变为可见。变为可见之后。就能够模拟点击事件了
     * @throws Exception
     */
    @Test
    public void testVisible() throws Exception {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();

        // 调用Activity的performCreate而且设置视图visible
        controller.create().visible();
        // 触发点击
        activity.findViewById(R.id.activity_main_jump).performClick();

        // 验证
        assertEquals(shadowOf(activity).getNextStartedActivity().getComponent().getClassName(), SecondActivity.class.getName());
    }
}
