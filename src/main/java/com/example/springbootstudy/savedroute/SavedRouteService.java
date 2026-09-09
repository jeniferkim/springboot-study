package com.example.springbootstudy.savedroute;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedRouteService {
    private final SavedRouteRepository savedRouteRepository;

    public SavedRouteService(
            SavedRouteRepository savedRouteRepository
    ) {
        this.savedRouteRepository = savedRouteRepository;
    }

    public List<SavedRoute> findAll() {
        return savedRouteRepository.findAll();
    }
}
