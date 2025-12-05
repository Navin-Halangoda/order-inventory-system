package com.example.order.repo;
import com.example.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT * FROM Orders WHERE Id=?1",nativeQuery = true)
    Orders getorderbyid(Integer orderId);

}
