package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Order;
import lombok.Data;

@Data
public class PlainOrderDto {

    private Long id;
    private String name;

    public static PlainOrderDto from(Order order){
        PlainOrderDto plainOrderDto = new PlainOrderDto();
        plainOrderDto.setId(order.getId());
        plainOrderDto.setName(order.getName());
        return plainOrderDto;
    }
}
