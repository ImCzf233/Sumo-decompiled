// Decompiled by ImCzf233

package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import java.util.Random;
import pw.cinque.timechanger.ClickListener;
import pw.cinque.CommandSettings.CommandSettings;

public class Pok extends GuiSettings
{
    private long nd;
    public static CommandSettings range;
    public static CommandSettings angle;
    public static CommandSettings min;
    public static CommandSettings max;
    public static ClickListener bh;
    boolean a;
    boolean b;
    public Random rand;
    protected long l;
    
    public Pok() {
        super(GuiSettings.a(new char[] { 'K', 'i', 'l', 'l', 'A', 'u', 'r', 'a' }), "", c4.a, 0, -1);
        this.a = true;
        this.b = false;
        this.rand = new Random();
        this.l = -1L;
        Pok.range = new CommandSettings(GuiSettings.a(new char[] { 'R', 'a', 'n', 'g', 'e' }), 3.7, 1.0, 8.1, 0.1);
        Pok.angle = new CommandSettings(GuiSettings.a(new char[] { 'A', 'n', 'g', 'l', 'e' }), 360.0, 0.0, 360.0, 0.1);
        Pok.min = new CommandSettings(GuiSettings.a(new char[] { 'M', 'i', 'n', 'C', 'P', 'S' }), 15.0, 1.0, 20.0, 0.1);
        Pok.max = new CommandSettings(GuiSettings.a(new char[] { 'M', 'a', 'x', 'C', 'P', 'S' }), 15.0, 1.0, 20.0, 0.1);
        Pok.bh = new ClickListener(GuiSettings.a(new char[] { 'W', 'e', 'a', 'p', 'o', 'n' }), true);
        this.avav(Pok.range);
        this.avav(Pok.angle);
        this.avav(Pok.min);
        this.avav(Pok.max);
        this.avav(Pok.bh);
    }
    
    public boolean a(final Entity t) {
        if (t.isInvisible() && !this.a) {
            return false;
        }
        if (!this.a) {
            final Minecraft mc = Minecraft.getMinecraft();
            if (mc.currentScreen != null) {
                return false;
            }
        }
        if (t instanceof EntityMob) {
            if (!this.b) {
                return false;
            }
        }
        else if (t instanceof EntityAnimal) {
            if (!this.b) {
                return false;
            }
        }
        else {
            if (!(t instanceof EntityPlayer)) {
                return false;
            }
            if (!this.a) {
                return false;
            }
        }
        return true;
    }
    
    public boolean v(final Entity entity) {
        if (entity == null) {
            return false;
        }
        if (!entity.isEntityAlive()) {
            return false;
        }
        if (!this.a(entity)) {
            return false;
        }
        if (!Pok.mc.thePlayer.canEntityBeSeen(entity)) {
            return false;
        }
        final float v = (float)Pok.range.g3tV4l4u3();
        return Pok.mc.thePlayer.getDistanceToEntity(entity) <= v;
    }
    
    public static float[] g(final Entity entity) {
        final double x = entity.posX - Pok.mc.thePlayer.posX;
        final double z = entity.posZ - Pok.mc.thePlayer.posZ;
        double y;
        if (entity instanceof EntityEnderman) {
            y = entity.posY - Pok.mc.thePlayer.posY;
        }
        else {
            y = entity.posY + (entity.getEyeHeight() - 1.9) - Pok.mc.thePlayer.posY + (Pok.mc.thePlayer.getEyeHeight() - 1.9);
        }
        final double helper = MathHelper.sqrt_double(x * x + z * z);
        float bnn = (float)Math.toDegrees(-Math.atan(x / z));
        final float e = (float)(-Math.toDegrees(Math.atan(y / helper)));
        if (z < 0.0 && x < 0.0) {
            bnn = (float)(90.0 + Math.toDegrees(Math.atan(z / x)));
        }
        else if (z < 0.0 && x > 0.0) {
            bnn = (float)(-90.0 + Math.toDegrees(Math.atan(z / x)));
        }
        return new float[] { e, bnn };
    }
    
    public void nd() {
        double a = Pok.min.g3tV4l4u3();
        final double g = Pok.max.g3tV4l4u3();
        if (a > g) {
            a = g;
        }
        final double b = 1000.0 / a;
        final double h = 1000.0 / g;
        final double j = b - h;
        this.nd = (long)(h + this.rand.nextDouble() * j);
    }
    
    public long gg() {
        return System.nanoTime() / 1000000L;
    }
    
    public boolean h(final long MS) {
        return this.gg() >= this.l + MS;
    }
    
    public void ud() {
        this.l = this.gg();
    }
    
    public static double v(final float angle1, final float angle2) {
        float dd = Math.abs(angle1 - angle2) % 360.0f;
        if (dd > 180.0f) {
            dd = 360.0f - dd;
        }
        return dd;
    }
    
    public boolean h() {
        if (!Pok.bh.i()) {
            return true;
        }
        final Minecraft mc = Minecraft.getMinecraft();
        return mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        if (Pok.mc.theWorld == null) {
            return;
        }
        if (Pok.mc.thePlayer == null) {
            return;
        }
        if (!Pok.mc.thePlayer.isEntityAlive()) {
            return;
        }
        if (!this.h()) {
            return;
        }
        Entity v = null;
        double dd = Pok.angle.g3tV4l4u3();
        final float range = (float)Pok.range.g3tV4l4u3();
        for (final Object e : Pok.mc.theWorld.getLoadedEntityList()) {
            final Entity en = (Entity)e;
            if (en.equals((Object)Pok.mc.thePlayer)) {
                continue;
            }
            if (!this.v(en)) {
                continue;
            }
            final float yaw = g(en)[1];
            final double cd = v(yaw, Pok.mc.thePlayer.rotationYaw);
            if (dd <= cd) {
                continue;
            }
            v = en;
            dd = cd;
        }
        if (v != null && this.h(this.nd)) {
            Pok.mc.thePlayer.swingItem();
            Pok.mc.playerController.attackEntity((EntityPlayer)Pok.mc.thePlayer, v);
            this.nd();
            this.ud();
        }
    }
}
