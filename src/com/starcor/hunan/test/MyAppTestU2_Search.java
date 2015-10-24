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


import android.os.Environment;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;

import com.robotium.solo.Solo;
import com.robotium.solo.Solo.Config;
import com.robotium.solo.Solo.Config.ScreenshotFileType;



public class MyAppTestU2_Search extends BaseCase{


	private Solo solo;
	
	
	@SuppressWarnings("unchecked")
	public MyAppTestU2_Search()
	{
		super();
	}
	
	
	
	@Override
	public void setUp() throws Exception {
	    Log.d("MyAppTestU2_Search"  , "begin setup");
        solo = new Solo(getInstrumentation(), this.getConfig(), getActivity());
		solo.sleep(10000);
		
	}

	
	
	public void testSearch() throws Exception{
	    TestAction.back00(solo);
        this.toSearchPage(solo);
        solo.sleep(4000);
        
        assertTrue(solo.waitForActivity("TimeSearchActivityV4"));
      
        String key = "JMW";
        TestAction.Search(solo, key);
        solo.sleep(6000);
        solo.takeScreenshot("search_jvw");
        TestAction.clearSearch(solo);
        
        
        key = "ZJL";
        TestAction.Search(solo, key);
        solo.sleep(6000);
        solo.takeScreenshot("search_ZJL");
        TestAction.clearSearch(solo);
        solo.sendKey(KeyEvent.KEYCODE_BACK);
    }
	
	
	
    public void toSearchPage(Solo solo)
    {
        TestAction.back00(solo);
        TestAction.move(solo, 2, 0);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
    }
    
    
    
	

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
