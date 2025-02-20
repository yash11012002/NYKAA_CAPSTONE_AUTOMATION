package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProfilePage;

public class AndroidProfilePage extends AndroidBasePage implements ProfilePage {
    @Override
    public boolean isProfilePageDisplayed() {
        return true;
    }

    @Override
    public void changeAddress() {

    }

    @Override
    public void saveDetails() {

    }

    @Override
    public boolean isUpdatesVisible() {
        return false;
    }
}
