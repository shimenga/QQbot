package cn.shimeng;

import cn.shimeng.Listener.LoadListener;
import cn.shimeng.utils.IniUtils;
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

    public final static long MyGroup = 921808862;
    public final static long TestBot = 3249197780L;
    public final static long DevQQ = 2500689407L;
    public final static long TestGroup = 740061022;

    @Override
    public void onEnable() {
        getLogger().info("Loaded!");

    }

    @Override
    public void onLoad(@NotNull PluginComponentStorage $this$onLoad) {
        LoadListener.Load();
        super.onLoad($this$onLoad);
    }
}