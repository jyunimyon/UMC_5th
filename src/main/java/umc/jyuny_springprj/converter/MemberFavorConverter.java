package umc.jyuny_springprj.converter;

import umc.jyuny_springprj.domain.FoodCategory;
import umc.jyuny_springprj.domain.mapping.MemberFavor;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFavorConverter {
    public static List<MemberFavor> toMemberFavorList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberFavor.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
