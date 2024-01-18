package com.velue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.velue.dto.HighSellingProduct;
import com.velue.dto.LowSellingProduct;
import com.velue.dto.PendingOrdersCustomer;
import com.velue.dto.PendingOrdersProduct;
import com.velue.dto.Restock;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PendingOrdersCustomer> getPendingOrdersByCustomer() {
        String sql = "SELECT c.customer_id, c.customer_name, p.item_code, p.product_name, " +
                     "ip.remaining_quantity, (SUM(o.total_amount) + SUM(ob.invoice_amount)) AS pending_amount " +
                     "FROM velue.customer c " +
                     "JOIN velue.orders o ON c.customer_id = o.customer_id " +
                     "JOIN velue.itemproduct ip ON o.order_id = ip.order_id " +
                     "JOIN velue.product p ON ip.product_id = p.product_id " +
                     "LEFT JOIN velue.orderbatch ob ON ip.order_product_id = ob.order_product_id " +
                     "WHERE o.order_status = 'PartialDelivered' " +
                     "GROUP BY c.customer_id, c.customer_name, p.item_code, p.product_name, ip.remaining_quantity";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PendingOrdersCustomer.class));
    }
    
    @Override
    public List<PendingOrdersProduct> getPendingOrdersByProduct() {
        String sql = "SELECT\r\n"
        		+ "    b.brand_name,\r\n"
        		+ "    c.category_name,\r\n"
        		+ "    p.item_code,\r\n"
        		+ "    p.product_name,\r\n"
        		+ "    ip.remaining_quantity,\r\n"
        		+ "    (SUM(o.total_amount) - COALESCE(SUM(ob.invoice_amount), 0)) AS pending_amount\r\n"
        		+ "FROM\r\n"
        		+ "    velue.orders o\r\n"
        		+ "JOIN\r\n"
        		+ "    velue.itemproduct ip ON o.order_id = ip.order_id\r\n"
        		+ "JOIN\r\n"
        		+ "    velue.product p ON ip.product_id = p.product_id\r\n"
        		+ "JOIN\r\n"
        		+ "    velue.category c ON p.category_id = c.category_id\r\n"
        		+ "JOIN\r\n"
        		+ "    velue.brand b ON c.brand_id = b.brand_id\r\n"
        		+ "LEFT JOIN\r\n"
        		+ "    velue.orderbatch ob ON ip.order_product_id = ob.order_product_id\r\n"
        		+ "WHERE\r\n"
        		+ "    o.order_status = 'PartialDelivered'\r\n"
        		+ "GROUP BY\r\n"
        		+ "    b.brand_name, c.category_name, p.item_code, p.product_name, ip.remaining_quantity;\r\n"
        		+ ""; 

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PendingOrdersProduct.class));
    }
    @Override
    public List<HighSellingProduct> getHighSellingProduct()
    {
    	String sql="SELECT\r\n"
    			+ "    `product`.`product_id`,\r\n"
    			+ "    `product`.`product_name`,\r\n"
    			+ "    `product`.`category_id`,\r\n"
    			+ "    SUM(`itemproduct`.`order_quantity`) AS total_quantity_sold\r\n"
    			+ "FROM\r\n"
    			+ "    `velue`.`product`\r\n"
    			+ "JOIN\r\n"
    			+ "    `velue`.`itemproduct` ON `product`.`product_id` = `itemproduct`.`product_id`\r\n"
    			+ "JOIN\r\n"
    			+ "    `velue`.`orders` ON `itemproduct`.`order_id` = `orders`.`order_id`\r\n"
    			+ "WHERE\r\n"
    			+ "    `orders`.`order_status` = 'Delivered'\r\n"
    			+ "GROUP BY\r\n"
    			+ "    `product`.`product_id`, `product`.`product_name`, `product`.`category_id`\r\n"
    			+ "ORDER BY\r\n"
    			+ "    total_quantity_sold DESC;\r\n"
    			+ "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HighSellingProduct.class));

    }
 //
    @Override
    public List<LowSellingProduct> getLowSellingProduct()
    {
    	String sql="SELECT\r\n"
    			+ "    `product`.`product_id`,\r\n"
    			+ "    `product`.`product_name`,\r\n"
    			+ "    SUM(`itemproduct`.`order_quantity`) AS total_quantity_sold\r\n"
    			+ "FROM\r\n"
    			+ "    `velue`.`product`\r\n"
    			+ "JOIN\r\n"
    			+ "    `velue`.`itemproduct` ON `product`.`product_id` = `itemproduct`.`product_id`\r\n"
    			+ "JOIN\r\n"
    			+ "    `velue`.`orders` ON `itemproduct`.`order_id` = `orders`.`order_id`\r\n"
    			+ "WHERE\r\n"
    			+ "    `orders`.`order_status` = 'Delivered'\r\n"
    			+ "GROUP BY\r\n"
    			+ "    `product`.`product_id`, `product`.`product_name`, `product`.`category_id`\r\n"
    			+ "ORDER BY\r\n"
    			+ "    total_quantity_sold ASC;\r\n"
    			+ "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LowSellingProduct.class));

    }
    @Override
    public List<Restock> getRestockReport()
    {
    	String sql="SELECT\r\n"
    			+ "    `p`.`product_id`,\r\n"
    			+ "    `p`.`product_name`,\r\n"
    			+ "    `c`.`category_name`,\r\n"
    			+ "    `b`.`brand_name`,\r\n"
    			+ "    `p`.`stock_in_hand`,\r\n"
    			+ "    `p`.`re_stock_level`,\r\n"
    			+ "    (`p`.`re_stock_level` - COALESCE(SUM(`ip`.`order_quantity`), 0)) AS quantity_to_order\r\n"
    			+ "FROM\r\n"
    			+ "    `velue`.`product` AS `p`\r\n"
    			+ "LEFT JOIN\r\n"
    			+ "    `velue`.`itemproduct` AS `ip` ON `p`.`product_id` = `ip`.`product_id`\r\n"
    			+ "LEFT JOIN\r\n"
    			+ "    `velue`.`category` AS `c` ON `p`.`category_id` = `c`.`category_id`\r\n"
    			+ "LEFT JOIN\r\n"
    			+ "    `velue`.`brand` AS `b` ON `p`.`brand_id` = `b`.`brand_id`\r\n"
    			+ "GROUP BY\r\n"
    			+ "    `p`.`product_id`, `p`.`product_name`, `c`.`category_name`, `b`.`brand_name`, `p`.`stock_in_hand`, `p`.`re_stock_level`\r\n"
    			+ "HAVING\r\n"
    			+ "    quantity_to_order > 0\r\n"
    			+ "ORDER BY\r\n"
    			+ "    `p`.`product_id`;\r\n"
    			+ "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Restock.class));

    }
}

