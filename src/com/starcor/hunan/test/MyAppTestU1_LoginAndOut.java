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




public class MyAppTestU1_LoginAndOut extends BaseCase{


	private Solo solo;
	
	private ArrayList<String[]> list = new ArrayList<String[]>();
	
	
	
	@SuppressWarnings("unchecked")
	public MyAppTestU1_LoginAndOut()
	{
		super();
		list = TestUtil.readFile("/testdata/LoginData.txt");
	}
	
	
	
	@Override
	public void setUp() throws Exception {
		
	    Log.d("MyAppTestU1_LoginAndOut"  , "begin setup");
        solo = new Solo(getInstrumentation(), this.getConfig(), getActivity());
		solo.sleep(10000);
		
	}

	
	
	public void testLoginAndOut() throws Exception{
		
		for (int i = 0; i < list.size(); i++)
		{
			Log.d("MyAppTestU1_LoginAndOut"  , "username: " + list.get(i)[0]);
			Log.d("MyAppTestU1_LoginAndOut"  , "password: " + list.get(i)[1]);
			this.Login(solo, list.get(i)[0], list.get(i)[1]);
			this.checkLogin(solo);
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			this.Logout(solo);
		}
    }
    
	
	

	@Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

}
