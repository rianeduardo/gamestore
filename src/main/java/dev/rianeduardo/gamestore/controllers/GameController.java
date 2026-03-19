package dev.rianeduardo.gamestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.rianeduardo.gamestore.models.Game;
import dev.rianeduardo.gamestore.repositories.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    @Autowired
    GameRepository gr;

    @GetMapping("/game-list")
    public ModelAndView abrirGameList() {
        ModelAndView mv = new ModelAndView("/games/list");
        mv.addObject("games", gr.findAll());
        return mv;
    }

    @GetMapping("/game-add")
    public String getGameAdd() {
        return "/games/add";
    }

    @PostMapping("")
    public String postMethodName(Game game, RedirectAttributes redirectAttributes) {
        gr.save(game);
        redirectAttributes.addFlashAttribute("msg", "Sucesso! Game cadastrado");
        return "redirect:/game-add";
    }

}
