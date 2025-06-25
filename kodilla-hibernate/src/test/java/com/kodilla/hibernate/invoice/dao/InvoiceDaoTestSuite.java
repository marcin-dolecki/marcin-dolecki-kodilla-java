package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        Product product1 = new Product("Phone");
        Product product2 = new Product("Tablet");
        Product product3 = new Product("Computer");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Item item1 = new Item(product1, new BigDecimal("1000"), 2, new BigDecimal("2000"));
        Item item2 = new Item(product2, new BigDecimal("500"), 3, new BigDecimal("1500"));
        Item item3 = new Item(product3, new BigDecimal("3000"), 1, new BigDecimal("3000"));
        Item item4 = new Item(product1, new BigDecimal("1000"), 5, new BigDecimal("5000"));
        Item item5 = new Item(product2, new BigDecimal("500"), 5, new BigDecimal("2500"));

        Invoice invoice1 = new Invoice("FV/2025/05", List.of(item1, item2));
        Invoice invoice2 = new Invoice("FV/2025/06", List.of(item3, item4, item5));

        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int invoiceId1 = invoice1.getId();
        int invoiceId2 = invoice2.getId();
//        Invoice invoice1FromDb = invoiceDao.findById(invoiceId1).get();
//        Invoice invoice2FromDb = invoiceDao.findById(invoiceId2).get();

        assertTrue(invoiceDao.findById(invoiceId1).isPresent());
        assertTrue(invoiceDao.findById(invoiceId2).isPresent());
        assertEquals(2, invoiceDao.findById(invoiceId1).get().getItems().size());
        assertEquals(3, invoiceDao.findById(invoiceId2).get().getItems().size());
//        assertEquals(invoice1FromDb.getId(), invoiceId1);
//        assertEquals(invoice2FromDb.getId(), invoiceId2);
//        assertEquals(2, invoice1FromDb.getItems().size());
//        assertEquals(3, invoice2FromDb.getItems().size());

//        invoiceDao.deleteAll();
//        productDao.deleteAll();
    }
}
