import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static  String Title (){
		String string=RandomStringUtils.randomAlphabetic(1);
		return ("john"+string);
		
	}

	public static String empname ()
	{
		String string=RandomStringUtils.randomAlphabetic(2);
		return ("john"+string);
	}
	
	public static String empsal ()
	{
		String a=RandomStringUtils.randomNumeric(2);
		return ("111"+a);
	}
	
	
	public static String first_name () {
		
		String string=RandomStringUtils.randomAlphabetic(4);
		return ("vitthal"+string);
	}
	
	public static String last_name() {
		String string=RandomStringUtils.randomAlphabetic(5);
		return ("vitthal"+string);
	}

	}


