package com.velue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.ReportRepository;
import com.velue.dto.HighSellingProduct;
import com.velue.dto.LowSellingProduct;
import com.velue.dto.PendingOrdersCustomer;
import com.velue.dto.Restock;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<com.velue.dto.PendingOrdersCustomer> getPendingOrdersByCustomer() {
        return reportRepository.getPendingOrdersByCustomer();
    }
    @Override
    public List<com.velue.dto.PendingOrdersProduct> getPendingOrdersByProduct() {
        return reportRepository.getPendingOrdersByProduct();
    }
    
    @Override
    public List<HighSellingProduct>getHighSellingProduct()
    {
    	 return reportRepository.getHighSellingProduct();
    }
    @Override
    public List<LowSellingProduct>getLowSellingProduct()
    {
    	 return reportRepository.getLowSellingProduct();
    }
    
    @Override
    public List<Restock>getRestockReport()
    {
    	 return reportRepository.getRestockReport();
    }
}

