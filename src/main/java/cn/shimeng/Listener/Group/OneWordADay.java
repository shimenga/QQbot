package cn.shimeng.Listener.Group;

import cn.shimeng.Basicplugin;
import cn.shimeng.utils.HttpUtils;
import cn.shimeng.utils.StringUtils;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class OneWordADay {
    Listener OneWordADay_listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == Basicplugin.MyGroup) {
            //if (event.getBot().getId() != Basicplugin.TestBot) {
            new Thread(() -> {
                if (event.getMessage().contentToString().equals("每日一言")) {
                    HttpUtils.HttpGetResult result = HttpUtils.getHttps("https://v.api.aa1.cn/api/yiyan/index.php");
                    event.getSubject().sendMessage(StringUtils.getSubString(result.result, "<p>", "</p>"));
                }
            }).start();
            //}
        }
    });
}
