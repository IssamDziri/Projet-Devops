/*package tn.esprit.rh.achat.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;
////
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class StcokServiceImplTest {

	@Autowired
	StockServiceImpl stockServiceImpl;
	
	Stock stock= Stock.builder().libelleStock("123").qte(1).build();
	

	@Test
	
	void testAddProduit()  throws ParseException{
		List<Stock> stocks = stockServiceImpl.retrieveAllStocks();
		Stock StockADD = Stock.builder().libelleStock("2000").qte(22).build();
		int expected = stocks.size();
		Stock saveStock = stockServiceImpl.addStock(stock );
		assertEquals(expected + 1, stockServiceImpl.retrieveAllStocks().size());		
	}

	@Test
	
	void testdeleteProduit() throws ParseException {
		Stock stocksADD = Stock.builder().libelleStock("100").qte(1).build();
		Stock addedStock = stockServiceImpl.addStock(stocksADD);
		stockServiceImpl.deleteStock(addedStock.getIdStock());
		assertNull(stockServiceImpl.retrieveStock(addedStock.getIdStock()));

	}
	 
}
*/