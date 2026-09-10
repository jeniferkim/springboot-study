package com.example.springbootstudy.savedroute;

import com.example.springbootstudy.savedroute.dto.CreateSavedRouteRequest;
import com.example.springbootstudy.savedroute.dto.SavedRouteResponse;
import com.example.springbootstudy.savedroute.dto.UpdateSavedRouteRequest;
import com.example.springbootstudy.savedroute.exception.SavedRouteNotFoundException;
import com.example.springbootstudy.user.User;
import com.example.springbootstudy.user.UserRepository;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(readOnly=true)
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

    public SavedRouteResponse findById(Long id) {

        SavedRoute savedRoute = savedRouteRepository.findById(id)
                .orElseThrow(
                        () -> new SavedRouteNotFoundException(id)
                );

        return new SavedRouteResponse(
                savedRoute.getId(),
                savedRoute.getTitle(),
                savedRoute.getSavingAmount()
        );
    }

    @Transactional
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

        if (request.getTitle().equals("ERROR")) {
            throw new RuntimeException("transaction test");
        }

        return new SavedRouteResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getSavingAmount()
        );
    }

    @Transactional
    public SavedRouteResponse update(
            Long id,
            UpdateSavedRouteRequest request
    ) {

        SavedRoute savedRoute = savedRouteRepository.findById(id)
                .orElseThrow(
                        () -> new SavedRouteNotFoundException(id)
                );

        savedRoute.changeTitle(request.getTitle());
        // 이거 이후에 따로 savedRouteRepository.save(savedRoute); 가 없음 !!
        // 근데도 DB가 수정될 수 있다~
        // 왜냐면 Entity이기 떄문에. Dirty Checking이 돌아용

        return new SavedRouteResponse(
                savedRoute.getId(),
                savedRoute.getTitle(),
                savedRoute.getSavingAmount()
        );
    }
}
