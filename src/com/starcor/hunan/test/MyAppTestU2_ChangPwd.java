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




public class MyAppTestU2_ChangPwd extends BaseCase{


	private Solo solo;
	
	
	@SuppressWarnings("unchecked")
	public MyAppTestU2_ChangPwd()
	{
		super();
	}
	
	
	
	@Override
	public void setUp() throws Exception {
		
	    Log.d("MyAppTestU2_Login"  , "begin setup");
        solo = new Solo(getInstrumentation(), this.getConfig(), getActivity());
		solo.sleep(10000);
		
	}

	
	
	///com.starcor.hunan.XULActivity 
    ///com.starcor.hunan.VideoListActivity
    //com.starcor.hunan.MplayerV2
    //com.starcor.hunan.LiveshowActivity
    //com.starcor.hunan.DetailPageActivity
	

	
	public void testChangePwd() throws Exception {
		
		
	    this.Login(solo, "15084947886", "wwwwww");
	    
	    //come into the change pwd
	    TestAction.move(solo, -2, 0);
	    solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(1000);
        solo.sendKey(KeyEvent.KEYCODE_BACK);
        TestAction.move(solo, 0, -2);
        
        
        //check1
        assertTrue(solo.waitForText("请您输入旧密码"));
        solo.enterText(0, "qqqqqq");
        solo.enterText(1, "qqqqqq");
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(3000);
        solo.takeScreenshot("changepwd1");
        
        
        //check2
        solo.clearEditText(0);
        solo.clearEditText(1);
        solo.enterText(0, "wwwwww");
        solo.enterText(1, "www");
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(3000);
        solo.takeScreenshot("changepwd2");
        
        
        //check3
        solo.clearEditText(0);
        solo.clearEditText(1);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(3000);
        solo.takeScreenshot("changepwd3");
        
        solo.sleep(1000);
        solo.sendKey(KeyEvent.KEYCODE_BACK);
        
        this.Logout(solo);
        this.toUserCenter(solo);
        this.toPhoneLogin(solo);
        assertTrue(solo.waitForText("请输入您的密码"));
	}
	
	
	
	

	@Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

}
