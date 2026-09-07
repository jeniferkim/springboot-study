package com.example.springbootstudy.savedroute;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 이 클래스가 HTTP 요청을 받는 C다
@RequestMapping("/saved-routes")
public class SavedRouteController {
    private final SavedRouteService savedRouteService;

    public SavedRouteController(SavedRouteService savedRouteService) {
        this.savedRouteService = savedRouteService;
    }

    @GetMapping
    public List<String> getSavedRoutes() {
        return savedRouteService.findAll();
    }
}
