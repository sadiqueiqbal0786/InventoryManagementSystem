package com.inventorymanagementsystem.Controller;
import com.inventorymanagementsystem.Entity.Inventory;
import com.inventorymanagementsystem.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/inventory")
    public String listItem(Model model){
        model.addAttribute("inventory",inventoryService.getAllItems());
        return "inventory";
    }
    @GetMapping("/inventory/new")
    public String addItem(Model model){
        Inventory inventory = new Inventory();
        model.addAttribute("inventory",inventory);
        return "add_item";
    }
    @PostMapping("/inventory")
    public String saveItem(@ModelAttribute("inventory")Inventory inventory){
        inventoryService.saveItem(inventory);
        return "redirect:/inventory";
    }
    @GetMapping("/inventory/edit/{id}")
    public String editItem(@PathVariable Long id, Model model){
        model.addAttribute("inventorey",inventoryService.getItemById(id));
        return "edit_item";
    }
    @PostMapping("/inventory/{id}")
    public String updateItem(@PathVariable Long id,
                             @ModelAttribute("inventory")Inventory inventory,
                             Model model){
        Inventory item = inventoryService.getItemById(id);
        item.setId(id);
        item.setProductName(inventory.getProductName());
        item.setVendorName(inventory.getVendorName());
        item.setPrice(inventory.getPrice());
        item.setQuantity(inventory.getQuantity());
        item.setStatus(inventory.getStatus());

        inventoryService.updateItem(item);
        return "redirect:/inventory";
    }
    @GetMapping("/inventory/{id}")
    public String deleteItem(@PathVariable Long id){
        inventoryService.deleteItemById(id);
        return "redirect:/inventory";
    }

}
