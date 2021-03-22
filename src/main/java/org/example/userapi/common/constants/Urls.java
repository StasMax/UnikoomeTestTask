package org.example.userapi.common.constants;

public interface Urls {
    String VALUE = "v1";
    String ROOT = "/api/" + VALUE;

    interface User {
        String USERS = ROOT + "/users";

        interface Id {
            String NAME = "/{id}";
            String FULL = USERS + NAME;
        }

    }
}
