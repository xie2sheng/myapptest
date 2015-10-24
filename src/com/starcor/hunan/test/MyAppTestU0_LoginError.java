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


import android.util.Log;
import android.view.KeyEvent;

import com.robotium.solo.Solo;




public class MyAppTestU0_LoginError extends BaseCase{


	private Solo solo;
	
	
	@SuppressWarnings("unchecked")
	public MyAppTestU0_LoginError()
	{
		super();
	}
	
	
	
	@Override
	public void setUp() throws Exception {
		
	    Log.d("MyAppTestU0_LoginError"  , "begin setup");
        solo = new Solo(getInstrumentation(), this.getConfig(), getActivity());
		solo.sleep(10000);
		
	}

	
	
	public void testLoginError() throws Exception{
		
       
		this.toUserCenter(solo);
        this.toPhoneLogin(solo);
       
        assertTrue(solo.waitForText("请输入您的密码"));
        
        //password incorrect
        TestAction.move(solo, 1, -2);
        solo.enterText(0, " 15084947886");
        solo.enterText(1, " qqq2qqq");
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(4000);
        solo.takeScreenshot("password1");
        
        //account not exist
        solo.clearEditText(0);
        solo.clearEditText(1);
        solo.enterText(0, " 15084986");
        solo.enterText(1, " qqqqqq");
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(4000);
        solo.takeScreenshot("password2");
        
        //password null
        solo.clearEditText(0);
        solo.clearEditText(1);
        solo.enterText(0, "xstest");
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(4000);
        solo.takeScreenshot("password3");
        
    }
    
	
	

	@Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

}
