package com.kodilla.hibernate.invoice.service;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Transactional
    public Invoice getInvoiceWithItems(Integer id) {
        Invoice invoice = invoiceDao.findById(id).orElseThrow();

        Hibernate.initialize(invoice.getItems());
        return invoice;
    }
}
