package net.minecraftforge.fml.relauncher;

public class FMLLaunchHandler {

    public static Side side() {
        return Side.SERVER;
    }

    public enum Side {
        CLIENT,
        SERVER;
    }
}
