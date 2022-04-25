// Decompiled by ImCzf233

package io.fishermen.fpsdisplay.settings;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.Random;
import pw.cinque.CommandSettings.CommandSettings;

public class das extends GuiSettings
{
    protected long l;
    protected long g;
    public static CommandSettings d;
    protected Random rr;
    private static long t;
    
    public das() {
        super(GuiSettings.a(new char[] { 'C', 'h', 'e', 's', 't', 'S', 't', 'e', 'a', 'l', 'e', 'r' }), "", c4.b, 0, -1);
        this.l = -1L;
        this.rr = new Random();
        this.avav(das.d = new CommandSettings(GuiSettings.a(new char[] { 'D', 'e', 'l', 'a', 'y' }), 100.0, 0.0, 300.0, 1.0));
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent e) {
        if (das.mc.thePlayer != null && (das.mc.currentScreen == null || das.mc.currentScreen instanceof GuiInventory)) {
            int s = -1;
            double m = -1.0;
            int n = -1;
            for (int i = 9; i < 45; ++i) {
                final ItemStack b = das.mc.thePlayer.inventoryContainer.getSlot(i).getStack();
                if (b != null && (this.g(b) || (this.f(b) && !this.g(b)))) {
                    if (this.f(b) && n == -1) {
                        n = this.s(b);
                    }
                    final double v = this.h(b);
                    if (v >= m) {
                        s = i;
                        m = v;
                    }
                }
            }
            if (s != -1 && this.s((long)das.d.g3tV4l4u3())) {
                if (n != -1) {
                    das.mc.playerController.windowClick(das.mc.thePlayer.inventoryContainer.windowId, 4 + n, 1, 4, (EntityPlayer)das.mc.thePlayer);
                }
                das.mc.playerController.windowClick(das.mc.thePlayer.inventoryContainer.windowId, s, 0, 1, (EntityPlayer)das.mc.thePlayer);
            }
        }
    }
    
    public boolean s(final long t) {
        if (pp() >= t) {
            das.t = System.nanoTime() / 1000000L;
            return true;
        }
        return false;
    }
    
    public static long pp() {
        return System.nanoTime() / 1000000L - das.t;
    }
    
    private boolean f(final ItemStack c) {
        if (c.getItem() instanceof ItemArmor) {
            if (das.mc.thePlayer.getEquipmentInSlot(1) != null && c.getUnlocalizedName().contains("boots") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(1)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(1).getItem()).damageReduceAmount) {
                return true;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(2) != null && c.getUnlocalizedName().contains("leggings") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(2)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(2).getItem()).damageReduceAmount) {
                return true;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(3) != null && c.getUnlocalizedName().contains("chestplate") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(3)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(3).getItem()).damageReduceAmount) {
                return true;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(4) != null && c.getUnlocalizedName().contains("helmet") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(4)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(4).getItem()).damageReduceAmount) {
                return true;
            }
        }
        return false;
    }
    
    private int s(final ItemStack s) {
        if (s.getItem() instanceof ItemArmor) {
            if (das.mc.thePlayer.getEquipmentInSlot(1) != null && s.getUnlocalizedName().contains("boots") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(1)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(1).getItem()).damageReduceAmount) {
                return 4;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(2) != null && s.getUnlocalizedName().contains("leggings") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(2)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(2).getItem()).damageReduceAmount) {
                return 3;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(3) != null && s.getUnlocalizedName().contains("chestplate") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(3)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(3).getItem()).damageReduceAmount) {
                return 2;
            }
            if (das.mc.thePlayer.getEquipmentInSlot(4) != null && s.getUnlocalizedName().contains("helmet") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(das.mc.thePlayer.getEquipmentInSlot(4)) + ((ItemArmor)das.mc.thePlayer.getEquipmentInSlot(4).getItem()).damageReduceAmount) {
                return 1;
            }
        }
        return -1;
    }
    
    private boolean g(final ItemStack s) {
        return (das.mc.thePlayer.getEquipmentInSlot(1) == null && s.getUnlocalizedName().contains("boots")) || (das.mc.thePlayer.getEquipmentInSlot(2) == null && s.getUnlocalizedName().contains("leggings")) || (das.mc.thePlayer.getEquipmentInSlot(3) == null && s.getUnlocalizedName().contains("chestplate")) || (das.mc.thePlayer.getEquipmentInSlot(4) == null && s.getUnlocalizedName().contains("helmet"));
    }
    
    private double h(final ItemStack s) {
        if (!(s.getItem() instanceof ItemArmor)) {
            return 0.0;
        }
        return ((ItemArmor)s.getItem()).damageReduceAmount + (100 - ((ItemArmor)s.getItem()).damageReduceAmount * 4) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, s) * 4 * 0.0075;
    }
    
    static {
        das.t = 0L;
    }
}
