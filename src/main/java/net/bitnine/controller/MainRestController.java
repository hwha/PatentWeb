package net.bitnine.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.bitnine.mapper.AgensMapper;

@RestController
public class MainRestController {

    AgensMapper agensMapper;

    @Autowired
    public MainRestController(AgensMapper agensMapper) {
        this.agensMapper = agensMapper;
    }

    @GetMapping("/api/cells")
    public List<Map<String, Object>> getCells() {
        return agensMapper.selectCells();
    }
}
