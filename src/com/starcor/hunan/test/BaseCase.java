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



public class BaseCase extends ActivityInstrumentationTestCase2{


	private static Class launcherActivityClass;


	private Config config;
	
	static {
		try
		{
			launcherActivityClass = Class
					.forName(MyConfig.LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		Log.d("base case", "initial class ok");
	}
	
	
	
	@SuppressWarnings("unchecked")
	public BaseCase()
	{
		super(launcherActivityClass);
		config = new Config();
        config.screenshotFileType = ScreenshotFileType.PNG;
        config.screenshotSavePath = Environment.getExternalStorageDirectory() + "/TestResult/";
        this.setConfig(config);
	}
	
	
	
	public Config getConfig() {
		return config;
	}



	public void setConfig(Config config) {
		this.config = config;
	}

	
	
	public void toLoginPage(Solo solo) {
		TestAction.back00(solo);
		TestAction.move(solo, 0, 0);
		solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);

	}
	    
	    
	
	

	public void toUserCenter(Solo solo) throws Exception {
		this.toLoginPage(solo);
		solo.sleep(8000);
		assertTrue(solo.waitForActivity("XULActivity"));
	}

	public void toPhoneLogin(Solo solo) throws Exception {
		TestAction.back(solo, 4, 4);
		TestAction.move(solo, 0, -1);
		solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
	}
	
	
	
	public void Login(Solo solo, String usr, String pwd) throws Exception {

		this.toUserCenter(solo);
        this.toPhoneLogin(solo);
        assertTrue(solo.waitForText("请输入您的密码"));
        TestAction.move(solo, 1, -2);
        solo.enterText(0, usr);
        solo.enterText(1, pwd);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(10000);
        //solo.takeScreenshot("loginsuccess");
	}
	
	
    
	public void Logout(Solo solo) throws Exception{
         
        TestAction.move(solo, 3, -3);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(1000);
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        TestAction.back00(solo);
        //solo.takeScreenshot("exit");
        solo.sleep(1000);
        
    }
	
	
	
	public void checkLogin(Solo solo) throws Exception {
		
		 //assume you have login, so move to the change pwd page
	    TestAction.move(solo, -2, 0);
	    solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        solo.sleep(1000);
        solo.sendKey(KeyEvent.KEYCODE_BACK);
        TestAction.move(solo, 0, -2);
        //check1
        assertTrue(solo.waitForText("请您输入旧密码"));
		
	}
	
	
	
}
