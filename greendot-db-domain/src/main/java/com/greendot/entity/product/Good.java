package com.greendot.entity.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
@Entity
@DiscriminatorValue("G")
public class Good extends Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BATCH", length = 512)
    private String batch;

    @Column(name = "REFERENCE_IDENTIFIER", length = 512)
    private String referenceIdentifier;

    public String getBatch() {

        return batch;
    }

    public Good setBatch(final String batch) {

        this.batch = batch;
        return this;
    }

    public String getReferenceIdentifier() {

        return referenceIdentifier;
    }

    public Good setReferenceIdentifier(final String referenceIdentifier) {

        this.referenceIdentifier = referenceIdentifier;
        return this;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == null)
            return false;
        if (this == o)
            return true;
        if (!(Hibernate.getClass(o).equals(Good.class)))
            return false;

        final Good good = (Good) o;
        if ((getProductId() != null) && (good.getProductId() == getProductId()))
            return true;
        if (getProductId() == null)
            return EqualsBuilder.reflectionEquals(this, good, "productId");
        return false;
    }

    @Override
    public int hashCode() {

        if (getProductId() != null)
            return Objects.hashCode(getProductId());
        return Objects.hash(batch, referenceIdentifier, getProductName());
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}