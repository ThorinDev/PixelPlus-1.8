package com.sirhuntpredator.pixelplus.misc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOUtils {

	public static String readFile(String filename) throws IOException
	{
	    String content = null;
	    File file = new File(filename); 
	    FileReader reader = null;
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(reader !=null){reader.close();}
	    }
	    return content;
	}
	public static ArrayList<String> getListFromFormattedFileUsingSpaces(String s)
	{
		try
		{
			ArrayList<String> e = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			for(char f : s.toCharArray())
			{
				if(f == ' ')
				{
					e.add(sb.toString());
					sb = new StringBuilder();
				}
				else
				{
					sb.append(f);
				}
			}
			return e;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
		return new ArrayList<String>();
	}
	

}
