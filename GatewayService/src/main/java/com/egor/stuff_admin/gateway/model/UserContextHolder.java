package com.egor.stuff_admin.gateway.model;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static final UserContext getContext() {
        UserContext context = userContext.get();

        if(context == null) {
            context = createEmptyContext();
            userContext.set(context);
        }

        return userContext.get();
    }

    public static final UserContext createEmptyContext() {
        return new UserContext();
    }
}
