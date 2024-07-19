package com.powerpuffsquirrels.noveleaf.service;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;

/**
 * //This will contain the following
 * user_account
 * read_shelf
 * to_read_shelf
 */
//Reed: did I make this? I don't remember making this...
public class User {
    private UserAccount userAccount;
    private ReadShelfEntity readShelfEntity;

    public User(UserAccount userAccount) {
        this.userAccount = userAccount;

        //build readShelf from database
        this.readShelfEntity = new ReadShelfEntity();

    }

    public void populateReadShelf() {

    }
}
