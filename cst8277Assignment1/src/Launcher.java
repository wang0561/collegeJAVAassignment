/* File: Launcher.java
 * course:cst8277 winter 2018
 * Professor: Rejaul Chowdhury,Stanley Pieda
 * lab: 304
 * Student: Tao Wang, 0408578654
 * Date: January 22, 2018
 * Description: Startup for the application.
 */

/**
 * Class for the entry point  of th program
 * @author Tao Wang
 * @version 1.0
 * Date: Januray 2018
 * */
public class Launcher {
   /**Main method for this program
    *@param String[] args 
    */
	public static void main(String[] args) {
		
			DataLoader loader = new DataLoader(); 
			loader.startProcess();
	        try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
