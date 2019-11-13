package dk.kea.dat18c.webshopmini.Controller;

import dk.kea.dat18c.webshopmini.Model.Product;
import dk.kea.dat18c.webshopmini.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//Dette er controller for WebShop
@Controller
public class WebShopController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/list")
    public String liste(Model model)
    {
        //put noget i model
        model.addAttribute("products", productService.getAll());
        //return side, der skal vises
        return "list";
    }

    @GetMapping("/create")
    public String showCreate()
    {
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product)
    {
        productService.create(product);
        //bed browser om at navigere til liste-siden efter oprettelse
        return "redirect:/list";
    }

    @GetMapping("/delete/{ident}")
    public String deleteProduct(@PathVariable("ident") int id)
    {
        productService.delete(id);
        return "redirect:/list";
    }

    // få fat id fra stien vha. @PathVariable
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        //tilføj product med id til viewmodel
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    // opdater product - @ModelAttribute bruges til at få fat i product fra post
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product){
        //kald update service
        productService.update(product);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/list";
    }

}
