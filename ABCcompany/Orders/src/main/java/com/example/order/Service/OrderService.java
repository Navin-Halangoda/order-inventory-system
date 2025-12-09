package com.example.order.Service;
import com.example.inventory.dto.InvetoryDto;
import com.example.order.Dto.OrderDto;
import com.example.order.common.ErrorOrderResponse;
import com.example.order.common.Orderesponse;
import com.example.order.common.succesOrderResponse;
import com.example.order.model.Orders;
import com.example.order.repo.OrderRepo;
import com.example.product.dto.Productdto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
@Transactional
public class OrderService {
    private final WebClient inventorywebclient;

    private  final WebClient productwebclient;
    @Autowired
    private OrderRepo orderrepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient inventorywebclient, WebClient productwebclient , OrderRepo orderrepo, ModelMapper modelMapper) {
        this.inventorywebclient = inventorywebclient;
        this.productwebclient=productwebclient;
        this.orderrepo = orderrepo;
        this.modelMapper =modelMapper;
    }

    public List<OrderDto> getallorder(){
        List<Orders>orderList=orderrepo.findAll();
        return modelMapper.map(orderList ,new TypeToken<List<OrderDto>>(){}.getType());
    }

    public Orderesponse saveorder(OrderDto orderdto){
        Integer itemid =orderdto.getItemId();

        try{
            InvetoryDto inventoryresponse =inventorywebclient.get()
                    .uri(uriBuilder ->uriBuilder.path("/getinventbyid/{itemId}").build(itemid))
                    .retrieve()
                    .bodyToMono(InvetoryDto.class)
                    .block();
            assert  inventoryresponse!= null;

            Integer productId= inventoryresponse.ProductId;

            Productdto productresponse =productwebclient.get()
                    .uri(uriBuilder -> uriBuilder.path("/getproductbyid/{productId}").build(productId))
                    .retrieve()
                    .bodyToMono(Productdto.class)
                    .block();
            assert  productresponse!= null;


            if(inventoryresponse.getQuantity()>0){
                if(productresponse.getForsale()==1){
                    orderrepo.save(modelMapper.map(orderdto, Orders.class));
                }else{
                  return new ErrorOrderResponse("this itrm s not for sale");
                }
                return new succesOrderResponse(orderdto);
            }else{
                return new ErrorOrderResponse("Item not available.");
            }
        }catch (WebClientResponseException e){
            if(e.getStatusCode().is5xxServerError()){
                return new ErrorOrderResponse("Item is not found");
            }
        }
        return  null;

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
