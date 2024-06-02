package me.nortw.mopped;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Mopped implements ClientModInitializer {

    private static final Mopped INSTANCE = new Mopped();
    private final Logger logger = LogManager.getLogManager().getLogger(String.valueOf(Mopped.class));
    private final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {

    }

    public static Mopped getInstance(){
        return INSTANCE;
    }

    public Logger getLogger(){
        return logger;
    }

}
