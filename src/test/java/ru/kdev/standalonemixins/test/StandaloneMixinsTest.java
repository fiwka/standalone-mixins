package ru.kdev.standalonemixins.test;

import org.junit.jupiter.api.Test;
import ru.kdev.standalonemixins.StandaloneMixins;
import tomixin.Main;

import java.util.Collections;

public class StandaloneMixinsTest {

    @Test
    public void testStandaloneMixins() {
        StandaloneMixins.run(Main.class, Collections.emptyList(), new String[0], "mixins.test.json");
    }
}
