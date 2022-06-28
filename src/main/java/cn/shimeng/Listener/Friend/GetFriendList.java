package cn.shimeng.Listener.Friend;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;

import static cn.shimeng.Basicplugin.DevQQ;

public class GetFriendList {
    Listener GetFriendList_listener = GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, event -> {
        if (event.getSender().getId() == DevQQ) {
            if (event.getMessage().contentToString().equals("getfriend")) {
                event.getFriend().sendMessage(event.getBot().getFriends().toString());
            }
            if (event.getMessage().contentToString().equals("Getfriend")) {
                event.getFriend().sendMessage(event.getBot().getFriends().toString());
            }
            if (event.getMessage().contentToString().equals("GetFriend")) {
                event.getFriend().sendMessage(event.getBot().getFriends().toString());
            }
        }
    });
}
