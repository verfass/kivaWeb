package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.entity.Kindergarten;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.korea.soft.templv2.domain.entity.QKindergarten.kindergarten;

@RequiredArgsConstructor
@Repository
public class KindergartenDynamicQuery {
    private final JPAQueryFactory queryFactory;


    public List<Kindergarten> findByNameLikeDSL(String name) {
        return queryFactory.selectFrom(kindergarten)
                .where(kindergarten.KindergartenName.contains(name))
                .fetch();
    }

//    private BooleanExpression eqParentId(Long parentId) {
//        if (parentId == null) {
//            return null;
//        }
//        return category.parentId.eq(parentId);
//    }
//
//    private BooleanExpression eqType2Code(String type2Code) {
//        if (StringUtils.isEmpty(type2Code)) {
//            return null;
//        }
//        return file.type2Code.eq(type2Code);
//    }

}