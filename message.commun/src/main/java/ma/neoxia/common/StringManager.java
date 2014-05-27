package ma.neoxia.common;

public class StringManager {
	/**
	 * 
	 */
	private static StringManager instance = null;

	/**
	 * one instance
	 * @return
	 */
	public static StringManager getInstance() {
		if(instance == null)
			instance = new StringManager();
		return instance;
	}
	/**
	 * verifier si val est vide ou non 
	 * @param val
	 * @return false if val is null or val.trim() is empty ""
	 * true otherwise
	 */
	public boolean isNotEmpty(String val){
		boolean ret = false;
		if(val !=null)
			ret = !val.trim().isEmpty();
		return ret;
	}
	/**
	 * verifier si val-X sont vide ou non 
	 * @param val
	 * @return false if val-X is null or val-X.trim() is empty ""
	 * true otherwise
	 */
	public boolean isNotEmpty(String val1, String val2){
		return (isNotEmpty(val1)&& isNotEmpty(val2));
	}
	/**
	 * verifier si val-X sont vide ou non 
	 * @param val
	 * @return false if val-X is null or val-X.trim() is empty ""
	 * true otherwise
	 */
	public boolean isNotEmpty(String val1, String val2, String val3){
		return (isNotEmpty(val1,val2)&& isNotEmpty(val3));
	}
	
	

}
