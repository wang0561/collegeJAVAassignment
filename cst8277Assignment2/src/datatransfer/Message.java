package datatransfer;

import java.io.Serializable;

/**
 * Need programming comments with correct author name throughout this class
 * @author xyz abc
 */
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String command;
    private FishStick fishStick;
    
    public Message(String command) {
    	
    	this.command=command;
    }
    public Message(String command,FishStick fish) 
    {
    	this.command=command;
    	this.fishStick=fish;
    	
    }
    public void set(String command) {
    	
    	this.command=command;
   
    }
    public String getCommand() {
    	return command;
    }
	public void setFishStick(FishStick fish) {
		this.fishStick=fish;
		
	}
	public FishStick getFishStick() {
		return fishStick;
	}
}
