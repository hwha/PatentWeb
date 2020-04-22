package net.bitnine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String moveMain() {
        return "index";
    }

    @GetMapping("/graph")
    public String moveGraph() {
        return "draw-graph";
    }
}
