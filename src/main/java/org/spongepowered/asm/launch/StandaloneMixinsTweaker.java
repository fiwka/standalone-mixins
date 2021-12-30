package org.spongepowered.asm.launch;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.platform.CommandLineOptions;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.List;

public class StandaloneMixinsTweaker implements ITweaker {

    private String[] launchArguments;
    public static List<String> exclusions;
    public static Class<?> mainClass;
    public static String[] configFiles;

    public StandaloneMixinsTweaker() {
        setLaunchArguments(new String[] {});
        MixinBootstrap.start();
    }

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        if (args != null && !args.isEmpty()) {
            setLaunchArguments(args.toArray(new String[0]));
        }

        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("IReallyKnowWhatIAmDoingISwear", "true"); // Don't check if build is outdated.
        MixinBootstrap.doInit(CommandLineOptions.ofArgs(args));
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        for (String exclusion : exclusions) {
            classLoader.addClassLoaderExclusion(exclusion);
        }

        Mixins.addConfigurations(configFiles);

        MixinBootstrap.inject();
    }

    @Override
    public String getLaunchTarget() {
        return mainClass.getName();
    }

    @Override
    public String[] getLaunchArguments() {
        return launchArguments;
    }

    private void setLaunchArguments(String[] launchArguments) {
        this.launchArguments = launchArguments;
    }
}
