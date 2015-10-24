package com.starcor.hunan.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;
import android.util.Log;
import android.view.View;

public class TestUtil
{
    
    
    public static void dumpViews(List<View> viewlist)
    {
        Log.d("TestUtil", String.valueOf(viewlist.size()));
        for (View elem : viewlist)
        {
            Log.d("TestUtil", elem.toString());
        }
    }
    
    
    
    public static ArrayList<String[]> readFile(String path)
    {
    	ArrayList<String[]> list = new ArrayList<String[]>();
    	
    	if (path == null)
    	{
    		return null;
    	}
    			
		File file = new File(Environment.getExternalStorageDirectory()
				+ path);

		/**
		 * 
		 * 
		 * menuData.txt
		 * movie|1|-1
	     * TVseries|2|-1
		 * 
		 * LoginData.txt
		 * 15084947886|wwwwww
		 * xs002|qqqqqq
		 * 
		 */
		
		
		
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bf.readLine()) != null) {

				String[] datas = line.split("\\|");
				
				 Log.d("readFile" , "line:" + line);
				 Log.d("readFile" , "1: " + datas[0]);
				 Log.d("readFile" , "2: " + datas[1]);
				 
				list.add(datas);

			}
		} catch (Exception e) {

			Log.d("readFile", "can't find the data file");
		}
		
		return list;
        
    }
    
    
}
