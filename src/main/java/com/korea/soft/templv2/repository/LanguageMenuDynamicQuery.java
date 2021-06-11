package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.LanguageMenu;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.lettuce.core.ScanIterator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.korea.soft.templv2.domain.entity.QBoard.board;
import static com.korea.soft.templv2.domain.entity.QLanguageMenu.languageMenu;

@RequiredArgsConstructor
@Repository
public class LanguageMenuDynamicQuery {
    private final JPAQueryFactory queryFactory;


    public List<LanguageMenu> findByMainMenu() {
        return queryFactory.selectFrom(languageMenu)
                .where(languageMenu.ParentId.isNull())
                .fetch();
    }

    public List<LanguageMenu> findBySubMenu(Long parentId) {
        return queryFactory.selectFrom(languageMenu)
                .where(languageMenu.ParentId.eq(parentId))
                .fetch();
    }
}