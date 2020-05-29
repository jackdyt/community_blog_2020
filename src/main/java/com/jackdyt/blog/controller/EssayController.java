package com.jackdyt.blog.controller;

import com.jackdyt.blog.dto.EssayDTO;
import com.jackdyt.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EssayController {
    @Autowired
    private EssayService essayService;

    @GetMapping("/essay/{id}")
    public String essay(@PathVariable(name = "id") Integer id, Model model){
        essayService.increaseView(id);
        EssayDTO essayDTO = essayService.getById(id);

        model.addAttribute("essay", essayDTO);
        return "essay";
    }
}
