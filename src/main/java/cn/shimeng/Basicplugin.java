package cn.shimeng;

import cn.shimeng.Listens.GroupListener;
import cn.shimeng.Listens.PrivateListener;
import net.mamoe.mirai.console.extension.PluginComponentStorage;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import org.jetbrains.annotations.NotNull;

public final class Basicplugin extends JavaPlugin {
    public static final Basicplugin INSTANCE = new Basicplugin();

    private Basicplugin() {
        super(new JvmPluginDescriptionBuilder("cn.shimeng.Basicplugin", "0.1.0")
                .name("Basicplugin")
                .author("shimeng")
                .build());
    }


    @Override
    public void onEnable() {
        getLogger().info("Loaded!");

    }
    @Override
    public void onLoad(@NotNull PluginComponentStorage $this$onLoad) {
        new GroupListener();
        getLogger().info("GroupListener loaded!");
        new PrivateListener();
        getLogger().info("PrivateListener loaded!");
        super.onLoad($this$onLoad);
    }
}