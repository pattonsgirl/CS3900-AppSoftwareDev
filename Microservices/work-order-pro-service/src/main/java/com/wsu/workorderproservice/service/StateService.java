package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.model.State;
import com.wsu.workorderproservice.repository.StateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
            return stateRepository.findAll();
        } catch (Exception e) {
            log.error("Failed to retrieve states info. search:{}, Exception:{}", search, e);
            throw new DatabaseErrorException("Failed to retrieve states info", e);
        }
    }
}
