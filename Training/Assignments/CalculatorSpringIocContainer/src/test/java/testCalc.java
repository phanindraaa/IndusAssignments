import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.spring.config.CalcConfig;
import com.indus.training.spring.service.CalcInput;
import com.indus.training.spring.service.ClacOutput;
import com.indus.training.spring.svc.Calculator;

import static org.junit.Assert.*;

public class testCalc {
    private Calculator calculator;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalcConfig.class);
        calculator = context.getBean(Calculator.class);
        System.out.println("cal obj 1"+calculator.toString());
        
        Calculator call = context.getBean(Calculator.class);
        System.out.println("cal obj 2"+call.toString());
    }

    @Test
    public void testAddition() {
        CalcInput input = new CalcInput();
        input.setParam1(5);
        input.setParam2(3);
        ClacOutput output = calculator.add(input);
        assertEquals(8, output.getResult(), 0.1);
    }

    @Test
    public void testSubtraction() {
        CalcInput input = new CalcInput();
        input.setParam1(10);
        input.setParam2(4);
        ClacOutput output = calculator.sub(input);
        assertEquals(6, output.getResult(), 0.1);
    }

    @Test
    public void testMultiplication() {
        CalcInput input = new CalcInput();
        input.setParam1(6);
        input.setParam2(7);
        ClacOutput output = calculator.mul(input);
        assertEquals(42, output.getResult(), 0.1);
    }

    @Test
    public void testDivision() {
        CalcInput input = new CalcInput();
        input.setParam1(20);
        input.setParam2(5);
        ClacOutput output = calculator.div(input);
        assertEquals(4, output.getResult(), 0.1);
    }

  
}