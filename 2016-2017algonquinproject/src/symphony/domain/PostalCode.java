package symphony.domain;


/**
 * PostalCode class is for store the information of the postalCode
 * @author Bo
 * 
 * */
public class PostalCode {

	
	
	/**postalCode*/
private String postcode;


  //Constructors ****************************************************
  
  /**
   * Constructs a Canadian postal code object.
   *
   * @param code The code to be analysed.
   */
  public PostalCode(String code) 
   {
	if ( validatePostcode ( code))
    this.postcode = code;
  }
  

  
  /**
   * This method will verifiy the validity of the postal code.
   *	@return postalValidate
   * @throws PostalCodeException If the code is found to be invalid.
   */
  private boolean  validatePostcode (String postcode) 
  {
    return postcode.matches( "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$");
  }
  
  /**
   * This method will return the destination of the postal code.
   * @return area
   * 
   */
  public String computeDestination() 
  {
    char firstLetter;  // first letter designates the destination
    
    //If the postal code is valid, get its first letter
    firstLetter = (char)getPostcode().charAt(0);

    // Determine the area the postal code refers to
    switch (firstLetter)
    {
      case 'A':
        return "in Newfoundland";
      case 'B':
        return "in Nova Scotia";
      case 'C':
        return "in PEI";        
      case 'E':
        return "in New Brunswick";        
      case 'G':
        return "in Quebec";        
      case 'H':
        return "in Metropolitan Montreal";        
      case 'J':
        return "in Western Quebec";        
      case 'K':
        return "in Eastern Ontario";        
      case 'L':
        return "in Central Ontario";        
      case 'M':
        return "in Metropolitan Toronto";        
      case 'N':
        return "in Southwestern Ontario";        
      case 'P':
        return "in Northern Ontario";        
      case 'R':
        return "in Manitoba";        
      case 'S':
        return "in Saskatchewan";        
      case 'T':
        return "in Alberta";        
      case 'V':
        return "in British Columbia";        
      case 'X':
        return "in the Northwest Territories or Nunavut";        
      case 'Y':
        return "in the Yukon Territories";        
      default:
      System.out.println("Invalid first letter");
    }
    return "";
  }

  /**
   * getter of the PostalCode
   * @return postCode
   * */
public String getPostcode() {
	return postcode;
}

/**setter of the PostalCode
 * @param postalCode*/
public void setPostcode(String postcode) {
	if ( validatePostcode ( postcode))
	    this.postcode = postcode;
}
  
  
}