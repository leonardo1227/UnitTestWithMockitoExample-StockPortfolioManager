package edu.mum.cs.cs425.stockportifoliomanager.model;

import edu.mum.cs.cs425.stockportifoliomanager.service.StockService;

import java.util.List;

public class Portifolio {
    private StockService stockService;
    private List<Stock> stocks;

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue(){
        double marketValue = 0.0;
        for(Stock stock:stocks){
            marketValue += stockService.getPrices(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
