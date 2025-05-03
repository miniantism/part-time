package com.fsse2501pt.Project.controller;

import com.fsse2501pt.Project.data.domainObject.CartItemResponseData;
import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import com.fsse2501pt.Project.data.dto.CartItemResponseDto;
import com.fsse2501pt.Project.service.CartItemService;
import com.fsse2501pt.Project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cart")

public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public void putCartItem(JwtAuthenticationToken jwt,
                            @PathVariable Integer pid,
                            @PathVariable Integer quantity) {
        FirebaseUserData fireBaseUserData = JwtUtil.toFirebaseUserData (jwt);

        cartItemService.putCartItem(fireBaseUserData, pid, quantity);
    }

    @GetMapping()
    public List<CartItemResponseDto> getCartItem(JwtAuthenticationToken jwt){
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();

        for (CartItemResponseData cartItemResponseData: cartItemService.getCartItemList(JwtUtil.getFirebaseUserData(jwt))){
            cartItemResponseDtoList.add(new CartItemResponseDto(cartItemResponseData));
        }
        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCartItem (JwtAuthenticationToken jwt,
                                               @PathVariable Integer pid,
                                               @PathVariable Integer quantity){

        return new CartItemResponseDto(
                cartItemService.updateItem(pid,quantity, JwtUtil.getFirebaseUserData(jwt)));

    }

    @DeleteMapping("/{pid}")
    public void deleteCartItem(@PathVariable Integer pid,
                               JwtAuthenticationToken jwt){
        cartItemService.deleteItem(pid, JwtUtil.getFirebaseUserData(jwt));
        
    }

}
