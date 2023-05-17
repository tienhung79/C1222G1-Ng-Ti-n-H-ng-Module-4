package com.example.cartproduct.controller;

import com.example.cartproduct.dto.CartDTO;
import com.example.cartproduct.dto.ProductFromCartDTO;
import com.example.cartproduct.model.Product;
import com.example.cartproduct.service.IServiceProduct;
import com.example.cartproduct.service.IServiceProductFromCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
@SessionAttributes(value = "cartDTO")
public class ControllerCart {
    @ModelAttribute(name = "cartDTO")
    private CartDTO initCartDTO() {
        return new CartDTO();
    }
    @Autowired
    IServiceProductFromCart serviceProductFromCart;
    @Autowired
    IServiceProduct serviceProduct;
    private static final String SEPARATOR = "-";

    @GetMapping("")
    public String disPlay(Model model) {
        List<Product> productList = serviceProduct.getAll();
        model.addAttribute("productList", productList);
        return "/homePage";
    }

    @GetMapping("/detail/{id}")
    public String disPlayById(@PathVariable int id, Model model,
                              @CookieValue(name = "seenProductIds", defaultValue = "") String ids,
                              HttpServletResponse httpServletResponse) {
        Product product = serviceProduct.getById(id);
        model.addAttribute("product", product);
        Cookie cookie;
        if ("".equals(ids)) {
            cookie = new Cookie("seenProductIds", Integer.toString(id));
        } else {
            String idString;
            String[] arrayIds = ids.split(SEPARATOR);
            if (arrayIds.length > 3) {
                idString = id + SEPARATOR + arrayIds[0] + SEPARATOR + arrayIds[1];
            } else {
                idString = id + SEPARATOR + ids;
            }
            cookie = new Cookie("seenProductIds", idString);
        }
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        return "/detail";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable(name = "id") int id, @SessionAttribute(name = "cartDTO") CartDTO cartDTO, Model model) {
        Product product = serviceProduct.getById(id);
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : cartDTO.getSelectedProducts().entrySet()
        ) {
            if (entry.getKey() == product.getId()) {
                entry.setValue(entry.getValue() + 1);
                flag = true;
            }
        }
        if (!flag) {
            cartDTO.getSelectedProducts().put(product.getId(), 1);
        }

        return "redirect:/home";
    }

    @GetMapping("/changeQuantity")
    public String changeQuantity(@RequestParam(value = "id") int id
            , @RequestParam(value = "quantiry") int quantity , @SessionAttribute(name = "cartDTO") CartDTO cartDTO) {
        for (Map.Entry<Integer, Integer> entry : cartDTO.getSelectedProducts().entrySet()
        ) {
            if (entry.getKey() == id) {
                if(quantity<=0){
                    Map<Integer,Integer> cartMap = cartDTO.getSelectedProducts();
                    cartMap.remove(id);
                    return "redirect:/home/cart";
                }else {
                entry.setValue(quantity);}
            }
        }
        return "redirect:/home/cart";
    }
    @GetMapping("/deleteInCart")
    public String delete(@RequestParam(value = "idDelete") int id,@SessionAttribute(name = "cartDTO") CartDTO cartDTO) {
        Map<Integer,Integer> cartMap = cartDTO.getSelectedProducts();
        cartMap.remove(id);
        return "redirect:/home/cart";
    }
    @GetMapping("/cart")
    public String getProductsFromCart(@SessionAttribute(name = "cartDTO") CartDTO cartDTO, Model model) {
        Set<Integer> productsIds = cartDTO.getSelectedProducts().keySet();
        Map<Integer, Product> mapProducts = serviceProduct.geProductstById(productsIds).stream().collect(Collectors.toMap(Product::getId, product -> product));
        List<ProductFromCartDTO> productFromCartDTOList = cartDTO.getSelectedProducts().entrySet().stream()
                .map(e -> new ProductFromCartDTO(e.getKey(),
                        mapProducts.get(e.getKey()).getImg(),
                        mapProducts.get(e.getKey()).getName(),
                        mapProducts.get(e.getKey()).getPrice(),
                        e.getValue(),
                        mapProducts.get(e.getKey()).getPrice()*e.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
        long totalBill = serviceProductFromCart.totalBill(productFromCartDTOList);
        model.addAttribute("totalBill",totalBill);
        model.addAttribute("productFromCartDTOList", productFromCartDTOList);
        return "/cart";
    }
}
