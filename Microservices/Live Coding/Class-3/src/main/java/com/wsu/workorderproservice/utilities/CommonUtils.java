package com.wsu.workorderproservice.utilities;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

//@UtilityClass annotation is a tool in Lombok that automatically turns a class into a utility class
@UtilityClass
public class CommonUtils {

    /**
     * This method used to build Sort for applying sorting
     * @param sortField - specify sort field
     * @param sortOrder - specify sort order
     * @return - built Sort
     */
    public static Sort sort(String sortField, String sortOrder) {
        if (Constants.DESC.equals(sortOrder)) {
            return Sort.by(sortField).descending();
        } else {
            return Sort.by(sortField).ascending();
        }
    }

}
