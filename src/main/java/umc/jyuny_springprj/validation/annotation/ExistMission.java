package umc.jyuny_springprj.validation.annotation;

import umc.jyuny_springprj.validation.validator.MissionExistValidator;
import umc.jyuny_springprj.validation.validator.RegionExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    // 여기에 작성하는 코드의 존재 의미를 모르겠음
    String message() default "해당하는 미션이 존재하지 않습니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
