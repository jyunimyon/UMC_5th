package umc.jyuny_springprj.validation.annotation;

import umc.jyuny_springprj.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
// 해당 어노테이션을 실제로 검사하는 검사기(Validator) 클래스를 지정하는 코드
// 즉, CategoriesExistValidator 클래스를 검사기로 지정하여 @ExistCategories 어노테이션이 적용된 객체의 유효성을 검사하도록 설정하는 것
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 생명 주기를 RUNTIME으로 지정
public @interface ExistCategories {
    String message() default "해당하는 카테고리가 존재하지 않습니다";
    Class<?>[] groups() default {};
    //Class 타입의 배열을 나타내며, 배열 요소의 타입이 어떤 클래스든지 상관없다는 의미. 즉, 다양한 타입의 Class 객체들을 담을 수 있는 배열을 선언
    Class<? extends Payload>[] payload() default {};
}
