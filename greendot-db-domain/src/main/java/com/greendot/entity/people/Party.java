package com.greendot.entity.people;

import com.greendot.entity.product.Good;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
@Entity
@Table(name = "PARTY")
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PARTY_ID", nullable = false, updatable = false)
    private Long partyId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "PARTY_TYPE", nullable = false)
    private PartyType partyType;

    public Long getPartyId() {

        return partyId;
    }

    public String getName() {

        return name;
    }

    public PartyType getPartyType() {

        return partyType;
    }

    public Party setPartyId(final Long partyId) {

        this.partyId = partyId;
        return this;
    }

    public Party setName(final String name) {

        this.name = name;
        return this;
    }

    public Party setPartyType(final PartyType partyType) {

        this.partyType = partyType;
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

        final Party party = (Party) o;
        if ((partyId != null) && (party.partyId == partyId))
            return true;
        if (partyId == null)
            return EqualsBuilder.reflectionEquals(this, party, "partyId");
        return false;
    }

    @Override
    public int hashCode() {

        if (partyId != null)
            return Objects.hashCode(partyId);
        return Objects.hash(name, partyType);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}