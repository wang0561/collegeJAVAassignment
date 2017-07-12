package algonquin.cst8284.lab4;

import java.util.ArrayList;

public class TestSolidObject {
	
   // TODO: define a new ArrayList of type SolidObject.  Call this array solidObjects.


private static ArrayList<SolidObject<? extends BasicShape  >>  solidObjects;
	
   public static void main(String[] args){
	 
      Circle circle1 = new Circle(3.0);  // depth = 5.0
      Square square1 = new Square(4.0);  // depth = 2.0
      Rectangle rectangle1 = new Rectangle(2.0, 8.0); // depth = 2.0
      Rectangle rectangle2 = new Rectangle(3.0, 5.0); // depth = 2.0
    
      solidObjects= new ArrayList<SolidObject<? extends BasicShape>>() ; 
      solidObjects.add(new SolidObject<Circle>(circle1,5.0));
      solidObjects.add(new SolidObject<Square>(square1,2.0));
      solidObjects.add(new SolidObject<Rectangle>(rectangle1,2.0));
      solidObjects.add(new SolidObject<Rectangle>(rectangle2,2.0));
      


      
    
     System.out.println("\nCheck the array: are the volumes/surfacearea of the solid objects equal?\n");
      for( SolidObject currentSO1:solidObjects){
   	   for( SolidObject currentSO2:solidObjects){
   		  displayComparison(isVolumeEqual(currentSO1, currentSO2), isSurfaceAreaEqual(currentSO1, currentSO2),currentSO1,currentSO2);  	  }
   	   }
    	  
        
      
      
      
    


      
    displayVolumeComparison(solidObjects); 
      System.out.println("");
      displaySurfaceAreaComparison(solidObjects);
;
   }
	private static void displayComparison(boolean volume, boolean area, SolidObject ala, SolidObject alb) {
		  
	
  System.out.println("\t"+ala.getName()+"\n"+alb.getName()+"\t"+volume+"/"+area);
		  System.out.println("********************************");
		  System.out.println();
}
	/*
	 * 
	 * 
	 * displayVolumeComparison() and displaySurfaceAreaComparison() use almost exactly the 
	 * same code, but they differ in the method used to make the comparison between the shapes, 
	 * since they are comparing different features. Explain how you would modify the current code so a 
	 * single displayComparison() method was needed, with the isVolumeEqual() and isSurfaceAreaEqual() m
	 * ethods passed as parameters.
	 */
  

   public static void displayVolumeComparison(ArrayList<SolidObject<? extends BasicShape>> solidObjects2){
		
      // Print out column header
      System.out.println("\nCheck the array: are the volumes of the solid objects equal?\n");
      System.out.print("\t\t");
      for (SolidObject<? extends BasicShape> ColumnHeader: solidObjects2){
         System.out.print( ColumnHeader.getName());
		 System.out.print("\t\t");}
	 // Print out each row,starting with the name of the object
	 for (SolidObject <? extends BasicShape>solidObjRow: solidObjects2){
	    System.out.println();	// Next line
	    System.out.print(solidObjRow.getName());
            for (SolidObject<? extends BasicShape> solidObjColumn: solidObjects2)
               System.out.print("\t\t" + isVolumeEqual(solidObjColumn, solidObjRow));
         }    
      }
 
public static  boolean isVolumeEqual(SolidObject <? extends BasicShape>solidObjColumn, SolidObject<? extends BasicShape> solidObjRow) {
	boolean b= false;
	if (solidObjColumn.getVolume() == solidObjRow.getVolume()){
	b=true;}
	return b;
}

public static void displaySurfaceAreaComparison(ArrayList<SolidObject<? extends BasicShape>> solidObjects2){
		
      // Print out column header
      System.out.println("\nCheck the array: are the surface areas of the solid objects equal?\n");
      System.out.print("\t\t");
       for ( SolidObject<? extends BasicShape> ColumnHeader: solidObjects2){
         System.out.print(  ColumnHeader.getName());
       System.out.print("\t\t");}
		
      // Print out each row,starting with the name of the object
      for (SolidObject<? extends BasicShape> solidObjRow: solidObjects2){
         System.out.println();	// Next line
         System.out.print(solidObjRow.getName());
         for (SolidObject<? extends BasicShape> solidObjColumn: solidObjects2)
            System.out.print("\t\t" + isSurfaceAreaEqual(solidObjColumn, solidObjRow));  
      }
   }


public static boolean isSurfaceAreaEqual(SolidObject<? extends BasicShape> solidObjColumn, SolidObject<? extends BasicShape> solidObjRow) {
	if(solidObjColumn.getSurfaceArea()==solidObjRow.getSurfaceArea())
		return true;
	else return false;
}
}
