package me.nortw.mopped.ui;

import me.nortw.mopped.module.Category;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public int x, y, width, height, dragX, dragY;
    public Category category;
    public boolean dragging, extended;
    public List<ModuleButton>

    public Frame(Category category, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.extended = false;
        buttons = new ArrayList<>();
    }
}
