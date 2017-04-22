package Server;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Services {
	private ArrayList<Server> ServerList;
	private HashMap<String, Resource> ResourceList;
	// We need to use hash maps for storing the data. 
	// I have created the classes for server and resource
	// Publish method and exchange method developers are free
	// to choose the primary key for the Hash maps. 
	
	public Response publish(Resource toPublish)
	{
		return null;
		
	}
	public Response remove(String toRemove)
	{
		return null;
		
	}
	public Response share(String secret, Resource toShare)
	{
		return null;
		
	}
	public Response query(Boolean relay, Resource toQuery)
	{
	      ArrayList<Resource> matched = getEntry(ResourceList, toQuery);
	      if(relay){
		  // do client side operation 
		  // add the resource returned to the matched
	    }

	    Response queryResponse = new Response();
	    queryResponse.setResourceList(matched);
	    return queryResponse;
	}
	public void fetch(Resource toFetch)
	{
	      String URI = toFetch.getUri();
	      File f = new File(URI);
	      
	      
	      
	      
	}
	
	// Support method for the Query method


	public static ArrayList<Resource> getEntry(HashMap<String, Resource> ResourceList,
		    Resource search){
	      // initialize matching array to be return
	      ArrayList<Resource> match = new ArrayList<Resource>();

	      // Looping through the ResourceList
	      for (Entry<String, Resource> entry : ResourceList.entrySet()){
		    Resource tempResource = entry.getValue();
		    if(matchChannel(search,tempResource) &&
				matchOwner(search, tempResource) &&
				matchTags(search, tempResource) && 
				matchNameDesc(search,tempResource))
		    {  
			  match.add(entry.getValue());
		    }

	      }
	      return match;
	}

	public static boolean matchChannel(Resource res1, Resource res2){
	      if (res1.getChannel().equals(res2.getChannel())) return true;
	      return false;
	}

	public static boolean matchOwner(Resource res1, Resource res2){
	      if (res1.getOwner().equals(res2.getOwner())) return true;
	      if (res1.getOwner().equals("")) return true;
	      return false;
	}

	// Compare if the tags in resource 2 contains all tags in resource 1

	public static boolean matchTags(Resource res1, Resource res2){
	      String[] tagList1 = res1.getTags();
	      String[] tagList2 = res2.getTags();
	      boolean abort = false;
	      for (String tag : tagList1){
		    if (!containString(tag,tagList2)) abort = true;
		    if (abort) break;
	      }
	      if (abort) {return false;} else {
		    return true;
	      }
	}

	// supporting method for comparing the resources
	// This method check whether an array "list" contain 
	// string "check" while being case insensitive
	public static boolean containString(String check,String[] list){
	      for (String str : list){
		    if (check.equalsIgnoreCase(str)){
			  return true;
		    }
	      }
	      return false;

	}

	// 

	public static boolean matchNameDesc(Resource template, Resource res){
	      boolean match = false;
	      String templateName = template.getName();
	      String resName = res.getName();
	      String templateDesc = template.getDescription();
	      String resDesc = res.getDescription();
	      if (templateName.equals("") || templateDesc.equals("")) match = true;
	      if (resName.toLowerCase().contains(templateName)) match = true;
	      if (resDesc.toLowerCase().contains(templateDesc)) match = true;

	      return match;
	}

	
	public Response exchange(ArrayList<Server> incomingServerList)
	{
		return null;
		
	}
	
}
