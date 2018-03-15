package kz.lessons.demo.controllers;

import kz.lessons.demo.models.Cosmetika;
import kz.lessons.demo.reposotories.CosmetikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/food")
public class CosmetikaController {
    @Autowired
    private CosmetikaRepository cosmetikaRepository;
    private long a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Cosmetika> allCosmetikas() {
        return cosmetikaRepository.findAll();
    }

    @GetMapping("/all2")
    public String allFoods2(Model model) {
        List<Cosmetika> cosmetikas = (List<Cosmetika>) cosmetikaRepository.findAll();
        model.addAttribute("cosmetika", cosmetikas);
        return "cosmetikas";
    }
    @RequestMapping("/add")
    public String cosmetikasForm(Model model) {
        model.addAttribute("cosmetika", new Cosmetika());
        return "cosmetika_add_form";
    }

    @PostMapping("/add")
    public String addCosmetika(@ModelAttribute Cosmetika cosmetika) {
        cosmetikaRepository.save(cosmetika);
        return "redirect:/cosmetika/all2";
    }

    @RequestMapping(value = "/deleteCosmetika",method = RequestMethod.GET)
    public ModelAndView deleteCosmetika(@RequestParam("id") long idd){
        cosmetikaRepository.deleteById(idd);
        return new ModelAndView("redirect:/cosmetika/all2");
    }
    @PostMapping("/editCosmetika")
    public String editFood(@ModelAttribute Cosmetika cosmetika) {
        Cosmetika cosmetika1 = new Cosmetika();
        cosmetika1.setCosmetika_id(a);
        cosmetika1.setCosmetika_name(cosmetika.getCosmetika_name());
        cosmetika1.setCosmetika_finishtime(cosmetika.getCosmetika_finishtime());
        cosmetika1.setTime(cosmetika.getTime());
        cosmetikaRepository.save(cosmetika1);
        return "redirect:/cosmetika/all2";
    }
    @RequestMapping(value = "/editCosmetika",method = RequestMethod.GET)
    public ModelAndView editFood(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Cosmetika> cosmetika = (Optional<Cosmetika>) cosmetikaRepository.findById(id);
        model.addAttribute("cosmetika",cosmetika);
        return new ModelAndView("inp");
    }
    @RequestMapping("/editCosmetika")
    public String bookForm2(Model model){
        model.addAttribute("cosmetika",new Cosmetika());
        return "inp";
    }

}
