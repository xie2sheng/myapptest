/*
 * This is an example test project created in Eclipse to test NotePad which is a sample 
 * project located in AndroidSDK/samples/android-11/NotePad
 * 
 * 
 * You can run these test cases either on the emulator or on device. Right click
 * the test project and select Run As --> Run As Android JUnit Test
 * 
 * @author Renas Reda, renas.reda@robotium.com
 * 
 */

package com.starcor.hunan.test;


import java.util.ArrayList;

import android.util.Log;
import android.view.KeyEvent;

import com.robotium.solo.Solo;




public class MyAppTestU3_Play extends BaseCase{


	private Solo solo;
	
	private ArrayList<String[]> list;
	
	
	@SuppressWarnings("unchecked")
	public MyAppTestU3_Play()
	{
		super();
	}
	
	
	@Override
	public void setUp() throws Exception {
	    Log.d("MyAppTestU3_Play"  , "begin setup");
        solo = new Solo(getInstrumentation(), this.getConfig(), getActivity());
		solo.sleep(10000);
		list = TestUtil.readFile("/testdata/menuData.txt");
	}

	
	
	public void testMoviePlay() throws Exception{
	    //index page operaation
		if (list.size() == 0)
		{
			this.toListPageAndPlay(solo, 4, 0);
		}
		else
		{
			this.toListPageAndPlay(solo, Integer.parseInt(list.get(0)[1]), Integer.parseInt(list.get(0)[2]));
		}

        //list page operation
        solo.sleep(6000);
        assertTrue(solo.waitForActivity("VideoListActivity"));
        TestAction.move(solo, 0, -5);
        TestAction.move(solo, 2, 0);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        
        //detail page operation
        solo.sleep(6000);
        assertTrue(solo.waitForActivity("DetailPageActivity"));
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
         
        //play
        this.play(solo);
        
    }
	
	
	public void toListPageAndPlay(Solo solo, int x, int y) 
	{
		TestAction.back00(solo);
		TestAction.move(solo, 0, -2);
		TestAction.left00(solo);
		
		 Log.d("toListPageAndPlay" , "x:" + x);
		 Log.d("toListPageAndPlay" , "y:" + y);
		TestAction.move(solo, x, y);
		solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
	}
	
	
	public void play(Solo solo)
	{
		 //palyer
        solo.sleep(30000);
        //stop
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.takeScreenshot("play");
        solo.sleep(10000);
        //replay
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(10000);
        
        solo.sendKey(KeyEvent.KEYCODE_BACK);
        solo.sleep(1000);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
	}
	
	
	
    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

}
