package site.ugaeng.ugaeng.domain.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PersonalInfo {

    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonalInfo(String phoneNumber, Gender gender) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
