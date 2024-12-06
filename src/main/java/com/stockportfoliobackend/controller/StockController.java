package com.stockportfoliobackend.controller;

import com.stockportfoliobackend.model.Stock;
import com.stockportfoliobackend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return (Stock) stockService.addStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }

    @GetMapping("/value")
    public double getPortfolioValue() {
        return stockService.getPortfolioValue();
    }
}
