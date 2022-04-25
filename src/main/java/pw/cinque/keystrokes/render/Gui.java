// Decompiled by ImCzf233

package pw.cinque.keystrokes.render;

import net.minecraft.client.gui.GuiScreen;
import io.fishermen.fpsdisplay.FPSRenderer;
import io.fishermen.fpsdisplay.settings.GuiSettings;

public class Gui extends GuiSettings
{
    public Gui() {
        super(GuiSettings.a(new char[] { 'G', 'u', 'i' }), "", c4.a, 41, 0);
    }
    
    @Override
    public void en() {
        if (!Entity.a) {
            Gui.mc.displayGuiScreen((GuiScreen)FPSRenderer.c);
            this.t();
        }
    }
}
