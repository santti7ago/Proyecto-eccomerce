package com.lulopet.ecommerce.application.service;

import com.lulopet.ecommerce.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {

    private List<ItemCart> itemCarts;  // Lista de elementos en el carrito
    private HashMap<Integer, ItemCart> itemCartHashMap;  // Mapa para acceder rápidamente a elementos por su id

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    // Método para agregar un elemento al carrito
    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();  // Actualiza la lista de elementos en el carrito
    }

    // Método para calcular el total del carrito
    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    // Método para eliminar un elemento del carrito
    public void removeItemCart(Integer idProduct) {
        itemCartHashMap.remove(idProduct);
        fillList();  // Actualiza la lista de elementos en el carrito
    }

    // Método para eliminar todos los elementos del carrito
    public void removeAllItemsCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    // Método privado para actualizar la lista de elementos en el carrito a partir del mapa
    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart) -> itemCarts.add(itemCart)
        );
    }

    // Método para obtener la lista de elementos en el carrito (para visualización en consola)
    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}