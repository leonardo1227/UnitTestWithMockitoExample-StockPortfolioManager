package edu.mum.cs.cs425.stockportifoliomanager;

import edu.mum.cs.cs425.stockportifoliomanager.service.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd(){
        when(calculatorService.add(10.0,20.0)).thenReturn(30.0);
        Assert.assertEquals(30.0,calculatorService.add(10.0,20.0),0.0);
        verify(calculatorService, times(1)).add(10.0, 20.0);
        reset(calculatorService);
    }

    @Test
    public void testSubtract(){
        when(calculatorService.subtract(20.0,10.0)).thenReturn(10.0);
        Assert.assertEquals(10.0,calculatorService.subtract(20.0,10.0),0.0);
        verify(calculatorService, atLeastOnce()).subtract(20.0,10.0);
        reset(calculatorService);
    }

    @Test
    public void testMultiply(){
        when(calculatorService.multiply(10.0,5.0)).thenReturn(50.0);
        Assert.assertEquals(50.0,calculatorService.multiply(10.0,5.0),0.0);
        Assert.assertEquals(50.0,calculatorService.multiply(10.0,5.0),0.0);
        verify(calculatorService, atLeast(2)).multiply(10.0,5.0);
        verify(calculatorService, atMost(3)).multiply(10.0,5.0);
    }

    @Test
    public void doThrowException(){
        doThrow(new RuntimeException("Divide operation not implemented yet!")).when(calculatorService).divide(10.0,2.0);
        Assert.assertEquals(5.0,calculatorService.divide(10.0,2.0),0.0);
    }

}
