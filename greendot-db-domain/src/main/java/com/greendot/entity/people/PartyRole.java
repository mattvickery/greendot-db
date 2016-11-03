package com.greendot.entity.people;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
@Entity
@Table(name = "PARTY_ROLE")
public class PartyRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PARTY_ROLE_ID")
    private Long partyRoleId;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "PARTY_ID", referencedColumnName = "PARTY_ID")
    private Party party;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role role;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}