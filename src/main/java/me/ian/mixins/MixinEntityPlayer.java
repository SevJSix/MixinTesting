package me.ian.mixins;

import net.bytebuddy.asm.Advice;
import net.minecraft.network.NetworkManager;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.level.World;

public class MixinEntityPlayer {

    @Advice.OnMethodEnter
    public static void onEnter(@Advice.This EntityPlayer entityPlayer, @Advice.Argument(0) World world) {
        System.out.println(entityPlayer.displayName + " spawned in " + world.getWorld().getName());
    }
}
