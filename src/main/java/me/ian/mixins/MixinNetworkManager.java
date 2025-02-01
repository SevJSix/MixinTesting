package me.ian.mixins;

import net.bytebuddy.asm.Advice;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.protocol.Packet;

public class MixinNetworkManager {

    @Advice.OnMethodEnter
    public static void onPacket(@Advice.This NetworkManager networkManager, @Advice.Argument(1) Packet<?> packet) {
        System.out.println(packet);
    }
}
