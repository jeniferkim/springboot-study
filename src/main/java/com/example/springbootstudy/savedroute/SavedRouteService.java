package com.example.springbootstudy.savedroute;

import com.example.springbootstudy.savedroute.dto.CreateSavedRouteRequest;
import com.example.springbootstudy.savedroute.dto.SavedRouteResponse;
import com.example.springbootstudy.user.User;
import com.example.springbootstudy.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedRouteService {
    private final SavedRouteRepository savedRouteRepository;
    private final UserRepository userRepository;

    public SavedRouteService (
            SavedRouteRepository savedRouteRepository,
            UserRepository userRepository
    ) {
        this.savedRouteRepository = savedRouteRepository;
        this.userRepository = userRepository;
    }

    public List<SavedRouteResponse> findAll() {
        return savedRouteRepository.findAll()
                .stream()
                .map(savedRoute ->
                        new SavedRouteResponse(
                                savedRoute.getId(),
                                savedRoute.getTitle(),
                                savedRoute.getSavingAmount()
                        )
                )
                .toList();
    }

    public SavedRouteResponse create(
            CreateSavedRouteRequest request
    ) {
        User user = userRepository.findById(1L)
                .orElseThrow();

        SavedRoute savedRoute = new SavedRoute(
                request.getTitle(),
                request.getSavingAmount(),
                user
        );

        SavedRoute saved = savedRouteRepository.save(savedRoute);

        return new SavedRouteResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getSavingAmount()
        );
    }
}
