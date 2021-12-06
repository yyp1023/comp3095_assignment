package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.ShoppingList;
import ca.gbc.recipe.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@RequestMapping("/shopping_list")
@Controller
public class ShoppingListController {

    @Autowired
    ShoppingListRepository shoppingListService;

    @RequestMapping({"/view_shoppinglist"})
    public String viewShoppingList(Model model) {
        model.addAttribute("shopping_lists", shoppingListService.findAll());
        return "shopping_list/index";
    }

    @RequestMapping({"/createShoppingList"})
    public String createShoppingList(Model model) {
        ShoppingList shoppingList = new ShoppingList();
        model.addAttribute("shoppingList", shoppingList);
        return "shopping_list/createShoppingList";
    }

    @RequestMapping(value = "/shoppinglist_created", method= RequestMethod.POST)
    public String success(@ModelAttribute("recipe") ShoppingList shoppingList,
                          HttpSession session, ModelMap modelMap,
                          Model model){
        model.addAttribute("shoppingList", shoppingList);
        shoppingListService.save(shoppingList);
        return "shopping_list/shoppingList_created";
    }

    @RequestMapping(value = "/delete/{itemId}", method= RequestMethod.POST)
    public String success(@PathVariable(name="itemId") Long itemId){
        shoppingListService.delete(shoppingListService.getById(itemId));
        return "shopping_list/index";
    }

    @RequestMapping(value= "/update/{itemId}")
    public String shoppingListUpdate(@PathVariable(name="itemId") Long itemId, HttpSession session, Model model){
        ShoppingList shoppingList = shoppingListService.getById(itemId);
        model.addAttribute("shoppingList", shoppingList);
        return  "shopping_list/update";
    }

    @PostMapping(value = "/update")
    public String itemUpdate(@Param("item_id") Long item_id, @Param("name") String name) throws ParseException {
        ShoppingList shoppingList = shoppingListService.getById(item_id);
        shoppingList.setName(name);
        shoppingListService.save(shoppingList);
        return "shopping_list/index";
    }
}
