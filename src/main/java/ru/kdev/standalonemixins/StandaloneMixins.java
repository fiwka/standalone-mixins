package ru.kdev.standalonemixins;

import net.minecraft.launchwrapper.Launch;
import org.spongepowered.asm.launch.StandaloneMixinsTweaker;
import org.spongepowered.asm.mixin.Mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandaloneMixins {

    public static void run(Class<?> mainClass, List<String> exclusions, String[] args, String... configFiles) {
        StandaloneMixinsTweaker.exclusions = exclusions;
        StandaloneMixinsTweaker.mainClass = mainClass;
        StandaloneMixinsTweaker.configFiles = configFiles;

        List<String> argsList = Stream.of(args).collect(Collectors.toCollection(ArrayList::new));
        argsList.add("--tweakClass=org.spongepowered.asm.launch.StandaloneMixinsTweaker");
        System.out.println("Initializing LaunchWrapper...");
        Launch.main(argsList.toArray(new String[0]));
    }
}
