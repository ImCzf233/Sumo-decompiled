// Decompiled by ImCzf233

package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Iterator;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Picke extends GuiSettings
{
    public Picke() {
        super(GuiSettings.a(new char[] { 'H', 'u', 'd' }), "", c4.b, 0, -1);
    }
    
    @SubscribeEvent
    public void a(final RenderGameOverlayEvent.Post e) {
        final Minecraft mc = Picke.mc;
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu) {
            return;
        }
        if (e.type != RenderGameOverlayEvent.ElementType.TEXT) {
            return;
        }
        GL11.glPushMatrix();
        int yCount = 2;
        for (final GuiSettings mod : CommandSettings.m) {
            if (mod != null && mod != this && mod.g3t()) {
                final Minecraft mc2 = Picke.mc;
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(mod.g3t4(), 2.0f, (float)yCount, a(6000, -270));
                yCount += 8;
            }
        }
        GL11.glPopMatrix();
    }
    
    public static int a(final int s, final int o) {
        float h = (System.currentTimeMillis() + (long)o) % (long)s;
        return Color.getHSBColor(h /= (float)s, 1.0f, 1.0f).getRGB();
    }
}
