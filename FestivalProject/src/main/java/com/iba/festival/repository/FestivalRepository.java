package com.iba.festival.repository;

import com.iba.festival.domain.Festival;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FestivalRepository extends CrudRepository<Festival, Long> {

    List<Festival> findByTag(String tag);

}
