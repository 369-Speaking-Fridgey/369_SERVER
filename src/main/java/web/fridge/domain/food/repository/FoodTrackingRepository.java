package web.fridge.domain.food.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import web.fridge.domain.food.entity.FoodStatus;
import web.fridge.domain.food.entity.QFood;
import web.fridge.domain.member.entity.Member;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static web.fridge.domain.family.entity.QFamily.family;
import static web.fridge.domain.food.entity.QFood.food;
import static web.fridge.domain.fridge.entity.QFridge.fridge;

@Repository
@RequiredArgsConstructor
public class FoodTrackingRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public List<Long> countFoodGroupByStatusAtCurrentMonth(){
        return queryFactory
                .select(food.count())
                .from(food)
                .leftJoin(fridge).on(food.fridge.fridgeId.eq(fridge.fridgeId))
                .leftJoin(family).on(family.fridge.fridgeId.eq(fridge.fridgeId))
                .where(
                        food.createdAt.eq(LocalDateTime.now().withMonth(LocalDate.now().getMonthValue()))
                )
                .groupBy(food.status)
                .fetch();
    }

    public Long countFoodCreatedByMemberAtCurrentMonth(Member member){
        return queryFactory
                .select(food.count())
                .from(food)
                .leftJoin(fridge).on(food.fridge.fridgeId.eq(fridge.fridgeId))
                .leftJoin(family).on(family.fridge.fridgeId.eq(fridge.fridgeId))
                .where(family.member.eq(member),
                        food.createdAt.eq(LocalDateTime.now().withMonth(LocalDate.now().getMonthValue()))
                )
                .fetchFirst();
    }

    public Long countFoodConsumedByMemberAtCurrentMonth(Member member){
        return queryFactory
                .select(food.count())
                .from(food)
                .leftJoin(fridge).on(food.fridge.fridgeId.eq(fridge.fridgeId))
                .leftJoin(family).on(family.fridge.fridgeId.eq(fridge.fridgeId))
                .where(family.member.eq(member),
                        food.createdAt.eq(LocalDateTime.now().withMonth(LocalDate.now().getMonthValue())),
                        food.status.eq(FoodStatus.CONSUMED)
                        ).fetchFirst();
    }

    public Long countFoodWastedByMemberAtCurrentMonth(Member member){
        return queryFactory
                .select(food.count())
                .from(food)
                .leftJoin(fridge).on(food.fridge.fridgeId.eq(fridge.fridgeId))
                .leftJoin(family).on(family.fridge.fridgeId.eq(fridge.fridgeId))
                .where(family.member.eq(member),
                        food.createdAt.eq(LocalDateTime.now().withMonth(LocalDate.now().getMonthValue())),
                        food.status.eq(FoodStatus.WASTED)
                ).fetchFirst();
    }

}
