package productManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import productManager.model.Product;
import productManager.service.IServiceProduct;
import productManager.service.impl.ServiceProduct;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ControllerProduct {
    @Autowired
    IServiceProduct serviceProduct = new ServiceProduct();

    @GetMapping("")
    public String displayProductList(Model model) {
        List<Product> productList = serviceProduct.getAll();
        model.addAttribute("productList", productList);
        return "/view";
    }

    @GetMapping("/updateProductList/{id}")
    public String updateProductList(Model model, @PathVariable(value = "id") int id) {
        Product product = serviceProduct.getProductById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/updateProductList")
    public String updateProductList(Product product) {
        serviceProduct.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int id) {
        serviceProduct.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/createProduct")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/createProduct")
    public String createProduct(Product product) {
        serviceProduct.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/findByName")
    public String findByName(Model model, @RequestParam(value = "name", required = false) String name) {
        List<Product> productList = serviceProduct.getProductByName(name);
        model.addAttribute("productList", productList);
        return "/view";
    }
}
