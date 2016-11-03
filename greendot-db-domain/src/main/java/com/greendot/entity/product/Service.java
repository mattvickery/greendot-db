package com.greendot.entity.product;

import com.greendot.entity.people.PartyRole;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
@Entity
@DiscriminatorValue("S")
public class Service extends Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "PROVIDED_BY", referencedColumnName = "PARTY_ID")
    private PartyRole providedBy;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "PROVIDED_FOR", referencedColumnName = "PARTY_ID")
    private PartyRole providedFor;

    public PartyRole getProvidedBy() {

        return providedBy;
    }

    public PartyRole getProvidedFor() {

        return providedFor;
    }

    public Service setProvidedBy(final PartyRole providedBy) {

        this.providedBy = providedBy;
        return this;
    }

    public Service setProvidedFor(final PartyRole providedFor) {

        this.providedFor = providedFor;
        return this;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == null)
            return false;
        if (this == o)
            return true;
        if (!(Hibernate.getClass(o).equals(Service.class)))
            return false;

        final Service service = (Service) o;
        if ((getProductId() != null) && (service.getProductId() == getProductId()))
            return true;
        if (getProductId() == null)
            return EqualsBuilder.reflectionEquals(this, service, "productId");
        return false;
    }

    @Override
    public int hashCode() {

        if (getProductId() != null)
            return Objects.hashCode(getProductId());
        return Objects.hash(providedBy, providedFor);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}