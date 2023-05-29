package GenericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	/**
	 * This method generate random number within the limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random=new Random();
		int randomnum=random.nextInt(limit);
		return randomnum;
	}
	/**
	 * This method return current time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_mm_ss");
		String currentTime=sdf.format(date);
		return currentTime;
	}

}
