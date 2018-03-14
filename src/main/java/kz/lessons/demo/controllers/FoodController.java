package kz.lessons.demo.controllers;




import kz.lessons.demo.models.Food;
import kz.lessons.demo.reposotories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    private long a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Food> allFoods() {
        return foodRepository.findAll();
    }

    @GetMapping("/all2")
    public String allFoods2(Model model) {
        List<Food> foods = (List<Food>) foodRepository.findAll();
        model.addAttribute("food", foods);
        return "foods";
    }
    @RequestMapping("/add")
    public String foodsForm(Model model) {
        model.addAttribute("food", new Food());
        return "food_add_form";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food) {
        foodRepository.save(food);
        return "redirect:/food/all2";
    }

    @RequestMapping(value = "/deleteFood",method = RequestMethod.GET)
    public ModelAndView deleteFood(@RequestParam("id") long idd){
        foodRepository.deleteById(idd);
        return new ModelAndView("redirect:/food/all2");
    }
    @PostMapping("/editFood")
    public String editFood(@ModelAttribute Food food) {
        Food food1 = new Food();
        food1.setfood_id(a);
        food1.setfood_name(food.getfood_name());
        food1.setFood_finishtime(food.getFood_finishtime());
        food1.setTime(food.getTime());
        foodRepository.save(food1);
        return "redirect:/food/all2";
    }
    @RequestMapping(value = "/editFood",method = RequestMethod.GET)
    public ModelAndView editFood(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Food> food = (Optional<Food>) foodRepository.findById(id);
        model.addAttribute("food",food);
        return new ModelAndView("inp");
    }
    @RequestMapping("/editFood")
    public String bookForm2(Model model){
        model.addAttribute("food",new Food());
        return "inp";
    }

}
