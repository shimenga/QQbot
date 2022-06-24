package cn.shimeng;

import cn.shimeng.Listens.GroupListen;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

public final class Basicplugin extends JavaPlugin {
    public static final Basicplugin INSTANCE = new Basicplugin();

    private Basicplugin() {
        super(new JvmPluginDescriptionBuilder("cn.shimeng.Basicplugin", "0.1.0")
                .name("Basicplugin")
                .author("shimeng")
                .build());
    }

    public static GroupListen groupListen;

    @Override
    public void onEnable() {
        groupListen = new GroupListen();
        getLogger().info("GroupListener loaded!");
    }
}