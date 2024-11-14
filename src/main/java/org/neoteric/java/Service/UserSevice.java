package org.neoteric.java.Service;

import org.neoteric.java.model.User;

public abstract class UserSevice extends User {

    public UserSevice(String userId, String name) {
        super(userId, name);
    }

    @Override
    public String getUserId() {
        return super.getUserId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public abstract boolean isPremiumUser();

}
