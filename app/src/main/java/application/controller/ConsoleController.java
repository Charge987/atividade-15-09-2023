package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.model.ConsoleRepository;

@Controller
@RequestMapping("/console")
public class ConsoleController{
@Autowired
private ConsoleRepository consoleRepo;

@RequestMapping("/list")
public String list(Model model) {
    model.addAttribute("consoles", consoleRepo.findAll());
    return "console/list";
}
@RequestMapping("/insert")
public String insert() {
    return "/console/list";
}
@RequestMapping(value = "/insert", method = ResquestMethod.POST)
public String insert(@ResquestParam("nome")String nome) {
    Console console = new Console();
    console.setNome(nome);

    consoleRepo.save(console);

    return "redirect:/console/list";

}
  
}
