package ru.kdev.standalonemixins.test;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tomixin.TestForMixinClass;

@Mixin(TestForMixinClass.class)
public class MixinTestForMixinClass {

    /**
     * @author fiwka
     */
    @Overwrite
    private void testik() {
        System.out.println("ne test");
    }
}
