package net.bitnine.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.bitnine.service.AgensService;

@RestController
public class MainRestController {

    AgensService agensService;

    @Autowired
    public MainRestController(AgensService agensMapper) {
        this.agensService = agensMapper;
    }

    @GetMapping("/api/cells")
    public List<Map<String, Object>> getCells() {
        return agensService.getCells();
    }

    @GetMapping("/api/tree")
    public List<Map<String, Object>> getTree() {
        return agensService.getTree();
    }

    @GetMapping("/api/graph")
    public Map<String, Object> getGraph() {
        return agensService.getGraph();
    }
}
