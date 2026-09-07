package com.example.springbootstudy.savedroute;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedRouteService {
    public List<String> findAll() {
        return List.of("Route A", "Route B");
    }
}
