package org.sfa.request.model.enums;

import lombok.Getter;

@Getter
public enum VolunteerTypeEnum {
    HELPER(0),
    LEAD(1);

    private final int id;

    VolunteerTypeEnum(int id) {
        this.id = id;
    }
}
