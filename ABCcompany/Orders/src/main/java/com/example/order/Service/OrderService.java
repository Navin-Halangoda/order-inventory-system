package com.example.order.Service;
import com.example.order.Dto.OrderDto;
import com.example.order.model.Orders;
import com.example.order.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderrepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDto> getallorder(){
        List<Orders>orderList=orderrepo.findAll();
        return modelMapper.map(orderList ,new TypeToken<List<OrderDto>>(){}.getType());
    }

    public OrderDto saveorder(OrderDto orderdto){
        orderrepo.save(modelMapper.map(orderdto, Orders.class));
        return orderdto;
    }

    public OrderDto updateorder(OrderDto orderDto){
        orderrepo.save(modelMapper.map(orderDto, Orders.class));
        return  orderDto;
    }

    public String deleteorder(Integer orderId){
        orderrepo.deleteById(orderId);
        return "Order delted";
    }

    public OrderDto getorderbyid(Integer orderId){
        Orders order = orderrepo.getorderbyid(orderId);
        return modelMapper.map(order,OrderDto.class);
    }

}
