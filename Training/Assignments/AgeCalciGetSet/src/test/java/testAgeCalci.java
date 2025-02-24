import com.indus.training.core.domain.AgeCalcInp;
import com.indus.training.core.domain.AgeCalciOut;
import com.indus.training.core.impl.AgeCalc;

import junit.framework.TestCase;

public class testAgeCalci extends TestCase {
	
	private AgeCalc AgeCalcObj;
	protected void setUp() throws Exception {
		AgeCalcObj = new AgeCalc();
	}

	protected void tearDown() throws Exception {
		AgeCalcObj = null;
	}
	
	public void testAgeCalcScenario1() {
		
		//1) Input
		AgeCalcInp AgeCalcInpObj = new AgeCalcInp();
		AgeCalcInpObj.setDay(18);
		AgeCalcInpObj.setMonth(12);
		AgeCalcInpObj.setYear(1999);
		
		//2) Expected Output
		AgeCalciOut expAgeCalciOutObj = new AgeCalciOut();
		expAgeCalciOutObj.setDay(18);
		expAgeCalciOutObj.setMonth(12);
		expAgeCalciOutObj.setYear(1999);
		expAgeCalciOutObj.setAge(24);
		
		//3) Actual Output
		AgeCalciOut actAgeCalciOutObj = AgeCalcObj.AgeCalculator(AgeCalcInpObj);
		
		//4) Assertions
		assertEquals(expAgeCalciOutObj.getDay(), actAgeCalciOutObj.getDay());
		assertEquals(expAgeCalciOutObj.getMonth(), actAgeCalciOutObj.getMonth());
		assertEquals(expAgeCalciOutObj.getYear(), actAgeCalciOutObj.getYear());
		assertEquals(expAgeCalciOutObj.getAge(), actAgeCalciOutObj.getAge());
	}

}
