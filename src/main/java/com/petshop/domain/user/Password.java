package com.petshop.domain.user;

import com.petshop.exception.UserInputError;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Password {

    private static final int MIN_LENGTH = 7;
    private static final int MAX_LENGTH = 16;

    @Column(nullable = false)
    private String password;

    public Password(String password) {
        validate(password);
        this.password = password;
    }

    private void validate(String password) {
        validateEmpty(password);
    }

    private void validateEmpty(String password) {
        if (Objects.isNull(password) || password.isEmpty()) {
            throw new UserInputError("비밀번호가 비어있습니다. ");
        }
    }
}
