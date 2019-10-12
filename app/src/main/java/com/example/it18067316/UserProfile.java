package com.example.it18067316;

import android.provider.BaseColumns;

public final class UserProfile {
    private UserProfile() {}

    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "_ID";
        public static final String COLUMN_2 = "userName";
        public static final String COLUMN_3 = "dateOfBirth";
        public static final String COLUMN_4 = "Gender";
    }

}
