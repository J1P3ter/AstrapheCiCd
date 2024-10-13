package com.j1p3ter.productserver.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -2103321050L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.j1p3ter.common.auditing.QBaseEntity _super = new com.j1p3ter.common.auditing.QBaseEntity(this);

    public final QCategory category;

    public final com.j1p3ter.productserver.domain.company.QCompany company;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Long> deletedBy = _super.deletedBy;

    public final StringPath description = createString("description");

    public final StringPath descriptionImgUrl = createString("descriptionImgUrl");

    public final NumberPath<Integer> discountedPrice = createNumber("discountedPrice", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final BooleanPath isHidden = createBoolean("isHidden");

    public final BooleanPath isSoldout = createBoolean("isSoldout");

    public final NumberPath<Integer> originalPrice = createNumber("originalPrice", Integer.class);

    public final StringPath productImgUrl = createString("productImgUrl");

    public final StringPath productName = createString("productName");

    public final ListPath<ProductOption, QProductOption> productOptions = this.<ProductOption, QProductOption>createList("productOptions", ProductOption.class, QProductOption.class, PathInits.DIRECT2);

    public final NumberPath<Double> rate = createNumber("rate", Double.class);

    public final DateTimePath<java.time.LocalDateTime> saleEndTime = createDateTime("saleEndTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> saleStartTime = createDateTime("saleStartTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.company = inits.isInitialized("company") ? new com.j1p3ter.productserver.domain.company.QCompany(forProperty("company")) : null;
    }

}

