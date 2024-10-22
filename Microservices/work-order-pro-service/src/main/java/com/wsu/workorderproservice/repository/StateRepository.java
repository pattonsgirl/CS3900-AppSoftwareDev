package com.wsu.workorderproservice.repository;


import com.wsu.workorderproservice.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, String> {

    List<State> findByCodeLikeOrNameLike(String code, String name);

}
