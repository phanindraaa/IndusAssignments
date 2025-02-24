import com.indus.training.core.domain.BMICalcInp;
import com.indus.training.core.domain.BMICalcOut;
import com.indus.training.core.impl.BMICalc;

import junit.framework.TestCase;

public class testBMICalc extends TestCase {
	private BMICalc BMICalcObj;

	protected void setUp() throws Exception {
		BMICalcObj = new BMICalc();
	}

	protected void tearDown() throws Exception {
		BMICalcObj = null;
	}

	public void testBMIScenario1() {
		
		//1)Input 
		BMICalcInp BMICalcInpObj = new BMICalcInp();
		BMICalcInpObj.setWeight(75);
		BMICalcInpObj.setHeight(1.8);
		
		//2) Expected Output
		BMICalcOut expBMICalcOutObj = new BMICalcOut();
		expBMICalcOutObj.setHeight(1.8);
		expBMICalcOutObj.setWeight(75);
		expBMICalcOutObj.setBmi(23.0);
		
		//3) Actual Output
		BMICalcOut actBMICalcOutObj = BMICalcObj.BMICalculator(BMICalcInpObj);
		
		//4) Assertions
		assertEquals(expBMICalcOutObj.getWeight(), actBMICalcOutObj.getWeight());
		assertEquals(expBMICalcOutObj.getHeight(), actBMICalcOutObj.getHeight());
		assertEquals(expBMICalcOutObj.getBmi(), actBMICalcOutObj.getBmi());
		
	}
}
