package com.example.myfirstapplication.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/sample")
public class SampleController {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SampleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test")
    public String test(Model model){

        String sql = "SELECT id, name, email FROM inquiry WHERE id = 1";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        model.addAttribute("title", "Inquiry Form");
        model.addAttribute("name", map.get("name"));
        model.addAttribute("email", map.get("email"));
        // test.htmlが呼び出される「html」は自動で補われます
        return "test";
    }
}
