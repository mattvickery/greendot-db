package com.greendot.entity.product;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/3/16.
 */
public class GoodTest {

    private static final String ALTERNATIVE_PRODUCT_NAME = "alternative product name";
    public static final String PRODUCT_NAME = "dummy product name";

    private Good lhs = buildBasicEntity();
    private Good rhs = buildBasicEntity();
    
    public static Good buildBasicEntity() {

        final Good good = new Good();
        good.setProductId(0l).setProductName(PRODUCT_NAME);
        return good;
    }

    @Before
    public void setup() {
        lhs = buildBasicEntity();
        rhs = buildBasicEntity();
    }

    @Test
    public void equals_byPk() {
        lhs.setProductId(1l);
        rhs.setProductId(1l);
        assertThat(lhs, equalTo(rhs));
    }

    @Test
    public void equals_non_byPk() {
        lhs.setProductId(1l);
        rhs.setProductId(2l);
        assertThat(lhs, not(equalTo(rhs)));
    }

    @Test
    public void equals_bothNullPk() {
        lhs.setProductId(null);
        rhs.setProductId(null);
        assertThat(lhs, equalTo(rhs));
    }

    @Test
    public void equals_PkNullNonPkAttributeSet() {
        lhs.setProductId(null);
        rhs.setProductId(null).setProductName(ALTERNATIVE_PRODUCT_NAME);
        assertThat(lhs, not(equalTo(rhs)));
    }

    @Test
    public void equals_onePkSetNull() {
        lhs.setProductId(1l);
        rhs.setProductId(null);
        assertThat(lhs, not(equalTo(rhs)));
    }

    @Test
    public void equals_onePkSetNullOneAttributeMatches() {
        lhs.setProductId(1l).setProductName(PRODUCT_NAME);
        rhs.setProductId(null).setProductName(PRODUCT_NAME);
        assertThat(lhs, not(equalTo(rhs)));
    }

    @Test
    public void equals_sameInstance() {
        assertThat(lhs, equalTo(lhs));
    }

    @Test
    public void equals_classMismatch() {
        final Service rhs = new Service();
        lhs.setProductId(1l);
        rhs.setProductId(1l);
        assertThat(lhs.equals(rhs), is(false));
    }

    @Test
    public void hash_byPk() {
        lhs.setProductId(1l);
        rhs.setProductId(1l);
        assertThat(lhs.hashCode(), equalTo(rhs.hashCode()));
    }

    @Test
    public void hash_non_byPk() {
        lhs.setProductId(1l);
        rhs.setProductId(2l);
        assertThat(lhs.hashCode(), not(equalTo(rhs.hashCode())));
    }

    @Test
    public void hash_bothNullPk() {
        lhs.setProductId(null);
        rhs.setProductId(null);
        assertThat(lhs.hashCode(), equalTo(rhs.hashCode()));
    }

    @Test
    public void hash_PkNullNonPkAttributeSet() {
        lhs.setProductId(null);
        rhs.setProductId(null).setProductName(ALTERNATIVE_PRODUCT_NAME);
        assertThat(lhs.hashCode(), not(equalTo(rhs.hashCode())));
    }

    @Test
    public void hash_onePkSetNull() {
        lhs.setProductId(1l);
        rhs.setProductId(null);
        assertThat(lhs.hashCode(), not(equalTo(rhs.hashCode())));
    }

    @Test
    public void hash_onePkSetNullOneAttributeMatches() {
        lhs.setProductId(1l).setProductName(PRODUCT_NAME);
        rhs.setProductId(null).setProductName(PRODUCT_NAME);
        assertThat(lhs.hashCode(), not(equalTo(rhs.hashCode())));
    }

    @Test
    public void hash_sameInstance() {
        assertThat(lhs.hashCode(), equalTo(lhs.hashCode()));
    }
}