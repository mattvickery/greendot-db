/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.entity.product;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Inheritance()
@DiscriminatorColumn(name="PRODUCT_TYPE")
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "NAME", length = 512)
    private String productName;

    public Long getProductId() {

        return productId;
    }

    public String getProductName() {

        return productName;
    }

    public Product setProductId(final Long productId) {

        this.productId = productId;
        return this;
    }

    public Product setProductName(final String productName) {

        this.productName = productName;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(Hibernate.getClass(o).equals(Product.class)))
            return false;

        final Product product = (Product) o;
        if (product.productId == productId)
            return true;
        if (productId == null) {
            if (product.productName.equals(productName))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        if (productId != null)
            return Objects.hashCode(productId);
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}
