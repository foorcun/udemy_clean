package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> porducts;

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        porducts = builder.porducts;
        active = builder.active;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<Product> getPorducts() {
        return porducts;
    }

    public boolean isActive() {
        return active;
    }

    private  boolean active;

    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> porducts;
        private boolean active;

        private Builder() {
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder porducts(List<Product> val) {
            porducts = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
