package me.nortw.mopped.module;
import static me.nortw.mopped.module.Module.categories;

public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    MISC("Misc");


    public String name;
    public boolean isHidden;


    Category(String name) {
        this.name = name;
        this.isHidden = true;
        categories.add(this);
        if (this.name=="Category") setHidden(false);

    }

    private void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
}