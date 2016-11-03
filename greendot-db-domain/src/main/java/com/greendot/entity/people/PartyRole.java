package com.greendot.entity.people;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
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

    public Long getPartyRoleId() {

        return partyRoleId;
    }

    public Party getParty() {

        return party;
    }

    public Role getRole() {

        return role;
    }

    public PartyRole setPartyRoleId(final Long partyRoleId) {

        this.partyRoleId = partyRoleId;
        return this;
    }

    public PartyRole setParty(final Party party) {

        this.party = party;
        return this;
    }

    public PartyRole setRole(final Role role) {

        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(Hibernate.getClass(o).equals(PartyRole.class)))
            return false;

        final PartyRole partyRole = (PartyRole) o;
        if (partyRole.partyRoleId == partyRoleId)
            return true;
        if (partyRoleId == null) {
            if ((partyRole.party.equals(party)) &&
                    (partyRole.role.equals(role)))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        if (partyRoleId != null)
            return Objects.hashCode(partyRoleId);
        return Objects.hash(party, role);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}