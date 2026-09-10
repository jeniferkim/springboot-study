package com.example.springbootstudy.savedroute;

import com.example.springbootstudy.savedroute.dto.CreateSavedRouteRequest;
import com.example.springbootstudy.savedroute.dto.SavedRouteResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 이 클래스가 HTTP 요청을 받는 C다
@RequestMapping("/saved-routes")
public class SavedRouteController {
    private final SavedRouteService savedRouteService;

    public SavedRouteController(SavedRouteService savedRouteService) {
        this.savedRouteService = savedRouteService;
    }

    @GetMapping
    public List<SavedRouteResponse> getSavedRoutes() {
        return savedRouteService.findAll();
    }

    @GetMapping("/{id}")
    public SavedRouteResponse getSavedRoute(
            @PathVariable Long id // URL의 값을 Java 변수로 받는 것
    ) {
        return savedRouteService.findById(id);
    }

    @PostMapping
    public SavedRouteResponse create(
            @Valid @RequestBody CreateSavedRouteRequest request
    ) {
        return savedRouteService.create(request);
    }
}
