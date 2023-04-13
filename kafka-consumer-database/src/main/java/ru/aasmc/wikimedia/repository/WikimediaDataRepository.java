package ru.aasmc.wikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aasmc.wikimedia.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
