package me.nortw.mopped.ui;

import me.nortw.mopped.module.Category;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ClickGui extends Screen {

    public static final ClickGui INSTANCE = new ClickGui();
    private List<Frame> frames;
    private ClickGui() {
        super(Text.literal("ClickGUI"));
        frames = new ArrayList<>();

        int offset = 20;
        for (Category category : Category.values()) {
            frames.add(new Frame(category, offset, 5, 84, 15));
        }
    }
}
