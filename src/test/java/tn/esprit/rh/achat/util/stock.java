package tn.esprit.rh.achat.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class stock {
    @Mock
    StockRepository Repo;

    @InjectMocks
    StockServiceImpl Service;

    Stock stock= Stock.builder().libelleStock("stock").qte(100).qteMin(10).build();
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(Stock.builder().libelleStock("first").qte(10).qteMin(5).build());
            add(Stock.builder().libelleStock("second").qte(200).qteMin(10).build());
        }
    };

    @Test
     void testRetrieveStock() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        @SuppressWarnings("removal")
		Stock s1 = Service.retrieveStock(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
     void testAllRetrieveStock() {
        Mockito.when(Repo.findAll()).thenReturn(listStocks);
        List<Stock> lStocks = Service.retrieveAllStocks();
        Assertions.assertNotNull(lStocks);
    }

    @Test
     void testAddstock() {
        Mockito.when(Repo.save(stock)).thenReturn(stock);
        Stock s1 = Service.addStock(stock);
        Assertions.assertNotNull(s1);

    }
    @Test
     void testUpdatestock() {
    	stock.setQteMin(5);
        Mockito.when(Repo.save(stock)).thenReturn(stock);
        Stock s1 = Service.updateStock(stock);
        Assertions.assertEquals(stock,s1);

    }

    @Test
     void testDeletestock() {
    	Service.deleteStock(stock.getIdStock());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(stock.getIdStock());
    }
 
    

    
    
    
}