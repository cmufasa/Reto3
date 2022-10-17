package com.usa.ciclo3.reto5.web;

//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//@Slf4j
//public class BaseController {
//    
////    @Autowired
////    private CabinService cabinService;
////    
//    @GetMapping("/")
//    public String inicio(Model model){
////        var cabins = cabinService.getList();
//        log.info("ejecutando el controlador Spring MVC");
////        model.addAttribute("cabins", cabins);
////        var saldoTotal = 0D;
////        for(var p: cabins){
////            saldoTotal += p.getSaldo();
////        }
////        model.addAttribute("saldoTotal", saldoTotal);
////        model.addAttribute("totalClientes", cabins.size());
//        return "index";
//    }
//    
////    @GetMapping("/addcabin")
////    public String addCabin(Cabin cabin){
////        return "modifyCabin";
////    }
////       
////    @PostMapping("/savecabin")
////    public String saveCabin(@Valid Cabin cabin, Errors errores){
////        if(errores.hasErrors()){
////            return "modifyCabin";
////        }
////        cabinService.save(cabin);
////        return "redirect:/";
////    }
////    
////    @GetMapping("/editcabin/{id}")
////    public String editCabin(Cabin cabin, Model model){
////        cabin = cabinService.update(cabin);
////        model.addAttribute("cabin", cabin);
////        return "modifyCabin";
////    }
////    
////    @GetMapping("/deletecabin")
////    public String deleteCabin(Cabin cabin){
////        cabinService.delete(cabin.getId());
////        return "redirect:/";
////    }
//}
