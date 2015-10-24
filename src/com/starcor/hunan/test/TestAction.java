package com.starcor.hunan.test;

import java.util.List;
import java.util.Set;

import android.util.Log;
import android.view.KeyEvent;

import com.robotium.solo.Solo;

public class TestAction
{

    //default left up corner(0, 0)
    public static void back00(Solo solo)
    {
        //default left up corner(0, 0)
        for (int i = 0; i < 9;  i++)
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_UP);
            solo.sleep(100);
        }
        
        for (int i = 0; i < 6;  i++)
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_LEFT);
            solo.sleep(100);
        }
    }
    
    //default left up corner(0, 0)
    public static void back(Solo solo, int x, int y)
    {
        
        for (int i = 0; i < x;  i++)
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_UP);
        }
        
        for (int i = 0; i < y;  i++)
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_LEFT);
        }
    }
    
    
    
    //horizon move from (x, y) move to (0,y)
    public static void left00(Solo solo)
    {
 
        for (int i = 0; i < 11;  i++)
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_LEFT);
        }
    }
    
    
    //based on the current location as (0, 0), move to the postion(x, y)
    //
    public static void move(Solo solo, int x, int y)
    {
        if ( x >= 0)
        {
            for (int i = 0; i < x; i++)
            {
                solo.sendKey(KeyEvent.KEYCODE_DPAD_RIGHT);
                solo.sleep(200);
            }
        }
        else
        {
            for (int i = 0; i < Math.abs(x); i++)
            {
                solo.sendKey(KeyEvent.KEYCODE_DPAD_LEFT);
                solo.sleep(200);
            }
        }
        
        if (y >= 0)
        {
            for (int i = 0; i < y; i++)
            {
                solo.sendKey(KeyEvent.KEYCODE_DPAD_UP);
                solo.sleep(200);
            }
        }
        else
        {
            for (int i = 0; i < Math.abs(y); i++)
            {
                solo.sendKey(KeyEvent.KEYCODE_DPAD_DOWN);
                solo.sleep(200);
            }
        }
        
    }
    
    
    
    
   
    
    
    
    public static void Search(Solo solo, String key)
    {
        //get the new key for query
        for (int i = 0; i < key.length(); i++)
        {
            String c = String.valueOf(key.charAt(i));
            int[] out_pos = MyConfig.pos_map.get(String.valueOf(TestAction.getPos(c)[0]));
            int inner_pos = TestAction.getPos(c)[1];
            Log.d("Search Progress:", "the key is :" + c + "  the out pos " + "x: " + out_pos[0] + " y: " + out_pos[1] + "inner pos: " + inner_pos);
            
            TestAction.move(solo, out_pos[0], out_pos[1]);
            TestAction.chooseForSearch(solo, inner_pos);
            //back to 5
            TestAction.move(solo, 0-out_pos[0], 0-out_pos[1]);
            solo.sleep(5500);
        }
        
    }
    
   
    
    public static void clearSearch(Solo solo)
    {
        solo.sendKey(KeyEvent.KEYCODE_BACK);
        solo.sleep(1000);
    }
    
    
    
    private static void chooseForSearch(Solo solo,int pos)
    {
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        //solo.sendKey(KeyEvent.KEYCODE_DPAD_UP);
        //solo.sleep(200);
        for (int j = 0; j < pos; j++ )
        {
            solo.sendKey(KeyEvent.KEYCODE_DPAD_RIGHT);
        }
        solo.sendKey(KeyEvent.KEYCODE_DPAD_CENTER);
        //solo.sleep(100);
    }
    
    
    
   
    
   
    private static int[] getPos(String c)
    {
        Set<String> set = MyConfig.key_map.keySet();
        int pos1 = 0;
        int pos2 = 0;
        for (String s: set)
        {
            List<String> list = MyConfig.key_map.get(s);
            if (list.contains(c))
            {
                pos1 = Integer.parseInt(s);
                pos2 = list.indexOf(c);
                break;
            }
         
        }
        return new int[]{pos1, pos2};
    }
    
}
