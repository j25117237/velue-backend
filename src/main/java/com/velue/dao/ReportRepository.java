package com.velue.dao;

import java.util.List;

import com.velue.dto.HighSellingProduct;
import com.velue.dto.LowSellingProduct;
import com.velue.dto.PendingOrdersCustomer;
import com.velue.dto.PendingOrdersProduct;
import com.velue.dto.Restock;

public interface ReportRepository {
    List<PendingOrdersCustomer> getPendingOrdersByCustomer();
    List<PendingOrdersProduct> getPendingOrdersByProduct();
    List<HighSellingProduct>getHighSellingProduct();
    List<LowSellingProduct>getLowSellingProduct();
    List<Restock>getRestockReport();
    }


