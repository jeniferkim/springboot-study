package com.example.springbootstudy.savedroute;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedRouteRepository
        extends JpaRepository<SavedRoute, Long> {
}
