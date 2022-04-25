// Decompiled by ImCzf233

package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.Random;

public class Jok extends GuiSettings
{
    public Random r;
    
    public Jok() {
        super(GuiSettings.a(new char[] { 'F', 'a', 's', 't', 'P', 'l', 'a', 'c', 'e' }), "", c4.b, 0, -1);
        this.r = new Random();
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        try {
            final Field field = Minecraft.class.getDeclaredField("rightClickDelayTimer");
            field.setAccessible(true);
            final Field field2 = field;
            final Minecraft mc = Jok.mc;
            field2.set(Minecraft.getMinecraft(), 0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
