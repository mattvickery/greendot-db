package com.greendot.entity.ecommerce;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemId;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, SIMPLE_STYLE).toString();
    }
}