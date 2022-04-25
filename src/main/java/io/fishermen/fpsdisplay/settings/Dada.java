package io.fishermen.fpsdisplay.settings;

import java.util.Random;

public class Dada extends GuiSettings
{
    public Random r;
    
    public Dada() {
        super(GuiSettings.a(new char[] { 'S', 't', 'r', 'a', 'f', 'e' }), "", c4.a, 0, -1);
        this.r = new Random();
    }
}
