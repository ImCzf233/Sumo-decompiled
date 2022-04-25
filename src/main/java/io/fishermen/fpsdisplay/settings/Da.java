// Decompiled by ImCzf233

package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.Random;
import pw.cinque.CommandSettings.CommandSettings;

public class Da extends GuiSettings
{
    public static CommandSettings x;
    public static CommandSettings y;
    public Random random;
    
    public Da() {
        super(GuiSettings.a(new char[] { 'V', 'e', 'l', 'o', 'c', 'i', 't', 'y' }), "", c4.a, 0, 0);
        this.random = new Random();
        Da.x = new CommandSettings(GuiSettings.a(new char[] { 'X' }), 90.0, 1.0, 100.0, 1.0);
        Da.y = new CommandSettings(GuiSettings.a(new char[] { 'Y' }), 90.0, 1.0, 100.0, 1.0);
        this.avav(Da.x);
        this.avav(Da.y);
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.RenderTickEvent ee) {
        if (Da.mc.thePlayer == null) {
            return;
        }
        if (Da.mc.theWorld == null) {
            return;
        }
        if (Da.mc.thePlayer.hurtTime == Da.mc.thePlayer.maxHurtTime && Da.mc.thePlayer.maxHurtTime > 0) {
            final EntityPlayerSP thePlayer = Da.mc.thePlayer;
            thePlayer.motionX *= Da.x.g3tV4l4u3() / 100.0;
            final EntityPlayerSP thePlayer2 = Da.mc.thePlayer;
            thePlayer2.motionY *= Da.y.g3tV4l4u3() / 100.0;
            final EntityPlayerSP thePlayer3 = Da.mc.thePlayer;
            thePlayer3.motionZ *= Da.x.g3tV4l4u3() / 100.0;
        }
    }
}
