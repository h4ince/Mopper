package me.nortw.mopped.settings.impl;

import com.google.gson.JsonObject;
import me.nortw.mopped.settings.Setting;

public class TextSetting extends Setting {

    private String text;

    public TextSetting(String name, String text) {
        super(name);
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void getText(String text){
        this.text = text;
    }

    @Override
    public void save(JsonObject object) {
        object.addProperty(getName(), text);
    }

    @Override
    public void load(JsonObject object) {
        text = object.get(getName()).getAsString();
    }
}
