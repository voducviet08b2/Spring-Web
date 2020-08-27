package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.ProductServiceimp;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService=new ProductServiceimp();
    @GetMapping("/product")
    public String getProductPage(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(Model model, @ModelAttribute Product product) {
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        productService.remove(id);
        return "redirect:/product";
    }
}
