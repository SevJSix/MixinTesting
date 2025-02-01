package me.ian;

import me.ian.mixin.Mixin;
import me.ian.mixin.MixinManager;
import me.ian.mixins.MixinEntityPlayer;
import me.ian.mixins.MixinNetworkManager;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.level.World;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        MixinManager.register(new Mixin(
                EntityPlayer.class,
                "spawnIn",
                new Class[]{World.class},
                void.class,
                MixinEntityPlayer.class
        ));

        try {
            Class<?> channelHandlerContext = Class.forName("io.netty.channel.ChannelHandlerContext");
            MixinManager.register(new Mixin(
                    NetworkManager.class,
                    "a",
                    new Class[]{channelHandlerContext, Packet.class},
                    void.class,
                    MixinNetworkManager.class
            ));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        MixinManager.init(getServer().getClass().getClassLoader());
    }
}
