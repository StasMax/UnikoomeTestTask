package org.example.userapi.common.constants;

public interface Urls {
    String VERSION = "v1";
    String ROOT = "/api/" + VERSION;

    interface User {
        String USERS = ROOT + "/users";

        interface Id {
            String NAME = "/{id}";
            String FULL = USERS + NAME;
        }
    }


}
