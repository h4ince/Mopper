package me.nortw.mopped.settings.impl;

import com.google.gson.JsonObject;
import me.nortw.mopped.settings.Setting;

import me.nortw.mopped.module.Module;
import com.llamalad7.mixinextras.sugar.impl.SingleIterationList;
import me.nortw.mopped.settings.Setting;

public class KeybindSetting extends Setting {

    private int keyCode;
    private JsonObject object;
    private final Module m;

    public KeybindSetting(String name, int keyCode, Module m) {
        super(name);
        this.keyCode = keyCode;
        this.m = m;
    }

    public int getKey(){
        return keyCode;
    }

    public void getKey(int keyCode){
        this.keyCode = keyCode;
        m.setKey(keyCode);
    }
    public Module getModule(){
        return m;
    }

    @Override
    public void save (JsonObject object){
        object.addProperty(getName(), keyCode);
    }
    public void load (JsonObject object){
        keyCode = object.get(getName()).getAsInt();
        this.object = object;
    }
}
