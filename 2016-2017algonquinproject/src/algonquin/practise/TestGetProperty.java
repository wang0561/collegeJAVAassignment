package algonquin.practise;

public class TestGetProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String javaVersion=System.getProperty("java.version");
          String oName = System.getProperty("os.name");
          String user= System.getProperty("user.name");
	      System.out.println("JRE version:"+javaVersion+"\n"+"current os:"+oName+"\n current User:"+user);
	
	} 

}
