package umc.jyuny_springprj.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.jyuny_springprj.apiPayload.code.status.ErrorStatus;
import umc.jyuny_springprj.repository.MemberRepository;
import umc.jyuny_springprj.validation.annotation.ExistMember;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor // 생성자 주입은 항상 필수! 어노테이션이라고 까먹지 않기.
public class MemberExistValidator implements ConstraintValidator<ExistMember,Long> {
    private final MemberRepository memberRepository;
    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid=memberRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
