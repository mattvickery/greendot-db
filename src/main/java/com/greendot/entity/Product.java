package com.greendot.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    private Long productId;

    @Column(name = "NAME", length = 12)
    private String productName;

    public Long getProductId() {
        return productId;
    }

    public Product setProductId(final Long productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
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
            if (product.productName == productName)
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
}
