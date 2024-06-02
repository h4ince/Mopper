package me.nortw.mopped.module;

import me.nortw.mopped.event.EventManager;
import me.nortw.mopped.settings.Setting;
import me.nortw.mopped.settings.impl.KeybindSetting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Module {

    private String name, desc, displayname;
    private boolean hasKeybind = true;
    private boolean saveSettings = true;
    private boolean disableOnExit = false;
    private int key;
    private boolean enabled;
    private Category category;
    private KeyBinding keyBinding;
    private boolean expanded;

    protected MinecraftClient mc = MinecraftClient.getInstance();
    private final List<Setting> settings = new ArrayList<Setting>();

    public Module(String name, String desc, Category category){
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.displayname = name;
        this.key = 0;
    }

    public static boolean nullCheck(){
        return MinecraftClient.getInstance().world == null || MinecraftClient.getInstance().player == null;
    }

    public void toggle(){
        this.enabled = !this.enabled;
        if (enabled){
            onEnable();
        }
        else {
            onDisable();
        }
    }

    private void onDisable() {
        EventManager.unregister(this);
    }

    private void onEnable() {
        EventManager.register(this);
    }

    public static List<Category> categories = new ArrayList<>();

    public String getName(){
        return name;
    }
    public void getName(String name){
        this.name = name;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getKey(){
        return key;
    }
    public void setKey(int key){
        this.key = key;
    }
    public boolean hasKeybind(){
        return this.hasKeybind;
    }
    public void removeKeybind(){
        this.hasKeybind = false;
    }
    public void disableOnExit(){
        this.disableOnExit = true;
    }
    public boolean saveSettings(){
        return this.saveSettings;
    }
    public boolean disablesOnExit(){
        return this.disableOnExit;
    }
    public void onSave(){
        this.saveSettings = false;
    }
    public boolean isEnabled(){
        return enabled;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public String getDisplayName(){
        return displayname;
    }
    public void setDisplayname(String displayname){
        this.displayname = displayname;
    }
    public boolean isExpanded(){
        return expanded;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void addSettings(Setting...settings) {
        this.settings.addAll(Arrays.asList(settings));
    }
}