package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.ClassRoom;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

import static com.korea.soft.templv2.domain.entity.QBoard.board;
import static com.korea.soft.templv2.domain.entity.QBoardGroup.boardGroup;

@RequiredArgsConstructor
@Repository
public class BoardDynamicQuery {
    private final JPAQueryFactory queryFactory;

    public Page<Board> findByGroupIdAndBoardTitle(Pageable pageable, int groupId, String searchText) {
        QueryResults<Board> result = queryFactory
                .selectFrom(board)
                .innerJoin(board.boardGroup, boardGroup)
                .where(board.boardGroup.GroupId.eq(groupId),
                        board.boardGroup.UseYn.eq(TableStatus.Y),
                        containsBoardTitle(searchText)
                )
                .orderBy(board.BoardId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }
    private BooleanExpression containsBoardTitle(String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return null;
        }
        return board.BoardTitle.contains(searchText);
    }

}