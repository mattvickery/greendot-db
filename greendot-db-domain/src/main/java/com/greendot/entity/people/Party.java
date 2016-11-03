package com.greendot.entity.people;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

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

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}