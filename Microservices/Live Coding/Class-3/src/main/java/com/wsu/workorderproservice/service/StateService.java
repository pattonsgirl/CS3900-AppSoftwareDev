package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.model.State;
import com.wsu.workorderproservice.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StateService {

    private final StateRepository stateRepository;

    /**
     * This method used for retrieve the States.
     * @param search - it's optional and used for typeahead search by state code & name.
     * @return - if search query param not given then returns all States otherwise returns filtered states.
     */
    public List<State> get(String search) {
        try {
            if (StringUtils.hasLength(search)) {
                return  stateRepository.findByCodeLikeOrNameLike(search, search);
            }
            return Collections.singletonList(stateRepository.save(State.builder().build()));
        } catch (Exception e) {
            log.error("Failed to retrieve states info. search:{}, Exception:{}", search, e);
            throw new DatabaseErrorException("Failed to retrieve states info", e);
        }
    }
}
