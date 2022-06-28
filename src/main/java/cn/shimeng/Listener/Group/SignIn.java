package cn.shimeng.Listener.Group;

import cn.shimeng.utils.IniUtils;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import static cn.shimeng.Basicplugin.MyGroup;

public class SignIn {
    Listener SignIn_Listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
        if (event.getGroup().getId() == MyGroup) {
            if (event.getMessage().contentToString().equals("签到")) {
                IniUtils.initIni("src/main/resources/user.ini");
                //IniUtils.readIni("")
                event.getSubject().sendMessage("签到成功");
            }
        }
    });
}
