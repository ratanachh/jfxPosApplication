package com.ratana.jfx.utils;

import org.apache.commons.text.CaseUtils;

public enum Menu {
    Home ("POS Dashboard"),
    Pos ("Tiny POS"),
    Sale ("Sale History"),
    Category ("Category Management"),
    Product ("Product Management");

    private String title;
    Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getFxml() {
        return String.format("%s.fxml", CaseUtils.toCamelCase(name(), false));
    }
}
