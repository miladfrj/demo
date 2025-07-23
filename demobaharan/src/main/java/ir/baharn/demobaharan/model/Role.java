package ir.baharn.demobaharan.model;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN(0, "ادمین"), STUDENT(1, "دانشجو"), TEACHER(2, "استاد");

    private final Integer index;
    private final String title;

    private Role(Integer index, String title) {
        this.index = index;
        this.title = title;
    }
}
