package com.j1p3ter.productserver.domain.product;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.j1p3ter.productserver.config.QueryDslUtil.getAllOrderSpecifiers;
import static com.j1p3ter.productserver.domain.product.QProduct.product;

@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements ProductCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Product> searchByCompanyName(String companyName, Long categoryCode, Pageable pageable) {
        List<OrderSpecifier> orders = getAllOrderSpecifiers(pageable);

        List<Product> query;
        JPAQuery<Long> countQuery;

        if(categoryCode.equals(0L)){
            query = jpaQueryFactory
                    .selectFrom(product)
                    .distinct()
                    .where(
                            product.isDeleted.isFalse(),
                            product.company.companyName.contains(companyName)
                    )
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .orderBy(orders.stream().toArray(OrderSpecifier[]::new))
                    .fetch();
            countQuery = jpaQueryFactory
                    .select(product.count())
                    .from(product)
                    .where(
                            product.isDeleted.isFalse(),
                            product.company.companyName.contains(companyName)
                    );

            return PageableExecutionUtils.getPage(query, pageable, () -> countQuery.fetchOne());
        }

        query = jpaQueryFactory
                .selectFrom(product)
                .distinct()
                .where(
                        product.isDeleted.isFalse(),
                        product.company.companyName.contains(companyName),
                        product.category.categoryCode.eq(categoryCode)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(orders.stream().toArray(OrderSpecifier[]::new))
                .fetch();

        countQuery = jpaQueryFactory
                .select(product.count())
                .from(product)
                .where(
                        product.isDeleted.isFalse(),
                        product.company.companyName.contains(companyName),
                        product.category.categoryCode.eq(categoryCode)
                );

        return PageableExecutionUtils.getPage(query, pageable, () -> countQuery.fetchOne());
    }

    @Override
    public Page<Product> searchByProductName(String productName, Long categoryCode, Pageable pageable) {
        List<OrderSpecifier> orders = getAllOrderSpecifiers(pageable);

        List<Product> query;
        JPAQuery<Long> countQuery;

        if(categoryCode.equals(0L)){
            query = jpaQueryFactory
                    .selectFrom(product)
                    .distinct()
                    .where(
                            product.isDeleted.isFalse(),
                            product.productName.contains(productName)
                    )
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .orderBy(orders.stream().toArray(OrderSpecifier[]::new))
                    .fetch();
            countQuery = jpaQueryFactory
                    .select(product.count())
                    .from(product)
                    .where(
                            product.isDeleted.isFalse(),
                            product.productName.contains(productName)
                    );

            return PageableExecutionUtils.getPage(query, pageable, () -> countQuery.fetchOne());
        }

        query = jpaQueryFactory
                .selectFrom(product)
                .distinct()
                .where(
                        product.isDeleted.isFalse(),
                        product.productName.contains(productName),
                        product.category.categoryCode.eq(categoryCode)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(orders.stream().toArray(OrderSpecifier[]::new))
                .fetch();

        countQuery = jpaQueryFactory
                .select(product.count())
                .from(product)
                .where(
                        product.isDeleted.isFalse(),
                        product.productName.contains(productName),
                        product.category.categoryCode.eq(categoryCode)
                );

        return PageableExecutionUtils.getPage(query, pageable, () -> countQuery.fetchOne());
    }
}
