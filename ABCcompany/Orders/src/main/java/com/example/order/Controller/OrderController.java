package com.example.order.Controller;
import com.example.order.Dto.OrderDto;
import com.example.order.Service.OrderService;
import com.example.order.common.Orderesponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getorder")
        public List<OrderDto> getorder(){
            return orderService.getallorder();
        }
    @PostMapping("/creteorder")
        public Orderesponse saveorder(@RequestBody OrderDto orderDto){
        return orderService.saveorder(orderDto);
    }

    @PutMapping("/updateorder")
    public  OrderDto updateorder(@RequestBody OrderDto orderDto){
        return orderService.updateorder(orderDto);
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteorder(@PathVariable Integer orderId){
        return orderService.deleteorder(orderId);
    }

    @GetMapping("/getorderbyid/{orderId}")

    public OrderDto getorderbyid(@PathVariable Integer orderId){
        return orderService.getorderbyid(orderId);
    }
}
