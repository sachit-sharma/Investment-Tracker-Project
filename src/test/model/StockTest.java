package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockTest {

    private Stock testStock;

    @BeforeEach
    public void setup() {
        testStock = new Stock("Apple", 10, 180.5, "Technology");
    }

    @Test
    public void testConstructor(){
        assertEquals("Apple",testStock.getName());
        assertEquals(180.5, testStock.getCostPrice());
        assertEquals("Technology", testStock.getCategory());
        assertEquals(10, testStock.getQuantity());
        assertEquals(180.5, testStock.getCurrentPrice());
        assertFalse(testStock.isSold());
    }

    @Test
    public void testBuyMore(){
        testStock.buyMore(20);
        assertEquals(30, testStock.getQuantity());
    }

    @Test
    public void testGetCostPrice(){
        assertEquals(1805, testStock.getAmountInvested());
    }

    @Test
    public void testSell() {
        testStock.sell();
        assertTrue(testStock.isSold());
    }

    @Test
    public void testSetId() {
        testStock.setId(3);
        assertEquals(3,testStock.getId());
    }


    @Test
    public void testGetCurrentValue() {
        testStock.setCurrentPrice(100);
        assertEquals(1000, testStock.getCurrentValue());
    }

    @Test
    public void testCalculatePctReturn() {
        testStock.setCurrentPrice(361);
        assertEquals(100, testStock.calculatePctReturn());
    }

    @Test
    public void testCalculateTotalReturn() {
        testStock.setCurrentPrice(361);
        assertEquals(1805, testStock.calculateTotalReturn());
    }

    @Test
    public void testResetId() {
        Stock.resetNextStockId();
        assertEquals(1, testStock.getNextStockId());
    }

    @Test
    public void testFeaturesToArray() {
        Stock.resetNextStockId();
        Stock tesla = new Stock("Tesla", 10, 100, "Technology");
        assertArrayEquals(tesla.featuresToArray(), new Object []{"1", "Tesla","100.0", "100.0","10", "1000.0","Technology"});

    }
}

