package Server;
import java.util.ArrayList;

public class Response {
	private String response;
	private String errorMessage;
	private ArrayList<Resource> responseList;
	
	
	public ArrayList<Resource> getResourceList(){
	      return new ArrayList<Resource>(responseList); // new copy
	}
	
	public void setResourceList(ArrayList<Resource> responseList){
	      this.responseList = responseList;
	}
	
	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
