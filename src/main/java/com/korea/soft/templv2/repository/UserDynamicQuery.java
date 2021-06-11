package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.dto.user.UserFindIdDto;
import com.korea.soft.templv2.domain.dto.user.UserFindPasswordDto;
import com.korea.soft.templv2.domain.entity.ClassRoom;
import com.korea.soft.templv2.domain.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.korea.soft.templv2.domain.entity.QUser.user;

@RequiredArgsConstructor
@Repository
public class UserDynamicQuery {
    private final JPAQueryFactory queryFactory;

    public User findByUsernameAndCellPhone(UserFindIdDto userFindIdDto) {
        return queryFactory.selectFrom(user)
                .where(user.UserName.eq(userFindIdDto.getUserName()),
                        user.CellPhone.eq(userFindIdDto.getCellPhone())
                ).fetchFirst(); //무조건 1개만 조회
    }

    public User findByUsernameAndCellPhoneAndUserId(UserFindPasswordDto userFindPasswordDto) {
        return queryFactory.selectFrom(user)
                .where(user.UserName.eq(userFindPasswordDto.getUserName()),
                        user.CellPhone.eq(userFindPasswordDto.getCellPhone()),
                        user.UserId.eq(userFindPasswordDto.getUserId())
                ).fetchFirst(); //무조건 1개만 조회
    }

    public User findByUserIdAndUseYn(String userId) {
        return queryFactory.selectFrom(user)
                .where(user.UserId.eq(userId),
                        user.UseYn.eq(TableStatus.Y)
                ).fetchFirst(); //무조건 1개만 조회
    }


//    public List<Kindergarten> findByNameLikeDSL(String name) {
//        return queryFactory.selectFrom(kindergarten)
//                .where(kindergarten.KindergartenName.contains(name))
//                .fetch();
//    }

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