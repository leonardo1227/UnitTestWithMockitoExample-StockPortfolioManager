package edu.mum.cs.cs425.stockportifoliomanager;

import edu.mum.cs.cs425.stockportifoliomanager.model.Portifolio;
import edu.mum.cs.cs425.stockportifoliomanager.model.Stock;
import edu.mum.cs.cs425.stockportifoliomanager.service.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortifolioTester {
    Portifolio portifolio;
    StockService stockService;

    public static void main(String[] args) {
        PortifolioTester tester = new PortifolioTester();
        tester.setUp();
        System.out.println(tester.testMarketValue());
    }

    public void setUp(){
        portifolio = new Portifolio();
        stockService = mock(StockService.class);
        portifolio.setStockService(stockService);
    }

    public boolean testMarketValue(){
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google",10);
        Stock microsoftStock = new Stock("2","Microsoft",100);
        stocks.add(googleStock);
        stocks.add(microsoftStock);
        portifolio.setStocks(stocks);

        when(stockService.getPrices(googleStock)).thenReturn(50.00);
        when(stockService.getPrices(microsoftStock)).thenReturn(1000.00);

        double marketValue = portifolio.getMarketValue();
        return marketValue == 100500.0;
    }
}
