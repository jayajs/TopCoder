package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Even {
	public static int [] counts;
	public static void main(String args[])
	{
		try
		{
			//Main variables Required in the Program//
			
			Map<Integer, List<Integer>> mainList = new HashMap<Integer, List<Integer>>();
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rj1\\workspace\\EvenTree\\src\\Test\\input"));
			//Logic//
			String node_edge = br.readLine();
			int numNodes = Integer.parseInt(node_edge.split(" ")[0]);int numEdges = Integer.parseInt(node_edge.split(" ")[1]);
			 counts = new int [numNodes+1];
			Arrays.fill(counts, 1);
			for(int i=0;i<numNodes;i++)
			{
				String line =br.readLine();
				if(line!=null)
				{
				int a = Integer.parseInt(line.split(" ")[0]);
				int b =Integer.parseInt(line.split(" ")[1]);
				List <Integer> mylist = mainList.get(b);;
				if(mylist == null)
				{
					mylist = new LinkedList<Integer>();
					mylist.add(a);
				}
				else
				{
					mylist.add(a);	
				}
				mainList.put(b, mylist);
				}
			}
			///////////////////////
			//creating an iterator through the map
		     Iterator it = mainList.entrySet().iterator();
		     int ik=1;
		     while(it.hasNext() && ik==1)
		     {
		    	 Map.Entry pair  = (Map.Entry)it.next();
		    	 int key  = (int)pair.getKey();
		    	 //System.out.println(key);
		    	 counts[key]=getCount(key,mainList);
		    	 ik++;
		     }
		     System.out.print(Arrays.toString(counts));
			br.close();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
	public static int getCount(int key ,Map<Integer, List<Integer>> mainMap)
	{
		
		List <Integer> mylist = mainMap.get(key);
		if(mylist == null) return 1;
		for(int i=0;i<mylist.size();i++)
		{
			counts[key]+=getCount(mylist.get(i), mainMap);
		}
		return counts[key];
	}

}
