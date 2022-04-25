package io.fishermen.fpsdisplay.settings;

import java.util.Iterator;
import pw.cinque.keystrokes.render.Entity;
import io.fishermen.fpsdisplay.FPSDisplay;
import pw.cinque.keystrokes.render.Gui;
import java.util.ArrayList;
import java.util.List;

public class CommandSettings
{
    static List<GuiSettings> m;
    
    public CommandSettings() {
        CommandSettings.m = new ArrayList<GuiSettings>();
    }
    
    public void r() {
        this.r(new Pok());
        this.r(new Gui());
        this.r(new FPSDisplay());
        this.r(new Entity());
        this.r(new Wool());
        this.r(new Boker());
        this.r(new Jok());
        this.r(new Dada());
        this.r(new Covek());
        this.r(new Picke());
        this.r(new Zlo());
        this.r(new RR());
        this.r(new OO());
        this.r(new Da());
        this.r(new nes());
        this.r(new das());
        this.r(new fl());
        this.r(new ne());
    }
    
    private void r(final GuiSettings mm) {
        CommandSettings.m.add(mm);
    }
    
    public List<GuiSettings> g() {
        return CommandSettings.m;
    }
    
    public List<GuiSettings> i(final GuiSettings.c4 c) {
        final List<GuiSettings> mm = new ArrayList<GuiSettings>();
        for (final GuiSettings m : this.g()) {
            if (m.cc().equals(c)) {
                mm.add(m);
            }
        }
        return mm;
    }
}
