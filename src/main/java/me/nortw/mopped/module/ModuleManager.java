package me.nortw.mopped.module;

import me.nortw.mopped.settings.impl.KeybindSetting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    public static final ModuleManager INSTANCE = new ModuleManager();

    public ModuleManager(){
        init();
    }

    private void init() {
        //combat

        //misc

        //movement

        //render

        for (Module module : modules){
            if (module.hasKeybind()) module.addSettings(new KeybindSetting("Keybind", module.getKey(), module));
        }
    }
    public void add(Module m){
        modules.add(m);
    }
    public void remove(Module m){
        modules.remove(m);
    }
    public List<Module> getModules(){
        return modules;
    }
    public Module getModuleByName(String name){
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }
    public ArrayList<Module> getModulesByCategory(Category category){
        ArrayList<Module> modules = new ArrayList<>();
        for (Module m : this.modules){
            if (m.getCategory().equals(category)){
                modules.add(m);
            }
        }
        return modules;
    }
    public Module getModuleByClass(Class<? extends  Module> cls) {
        for (Module m : modules){
            if (m.getClass() !=cls){
                continue;
            }
            return m;
        }
        return null;
    }
    public List<Module> getEnabledModules() {
        List<Module> enabled = new ArrayList<>();
        for (Module m : getModules()){
            if (m.isEnabled()){
                enabled.add(m);
            }
        }
        return enabled;
    }
}
