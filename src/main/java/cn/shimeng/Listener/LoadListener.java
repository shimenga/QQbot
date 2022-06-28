package cn.shimeng.Listener;

import cn.shimeng.Listener.Friend.GetFriendList;
import cn.shimeng.Listener.Friend.GetGroupList;
import cn.shimeng.Listener.Friend.GetWeather;
import cn.shimeng.Listener.Group.BedWars;
import cn.shimeng.Listener.Group.FindQQ;
import cn.shimeng.Listener.Group.OneWordADay;
import cn.shimeng.Listener.Group.SignIn;

public class LoadListener {
    public static void Load() {
        //Group
        new BedWars();
        System.out.printf("BedWars Loaded!");
        new FindQQ();
        System.out.printf("FindQQ Loaded!");
        new OneWordADay();
        System.out.printf("OneWordADay Loaded!");
        new SignIn();
        System.out.printf("SignIn Loaded!");
        //Friend
        new GetFriendList();
        System.out.printf("GetFriendList Loaded!");
        new GetGroupList();
        System.out.printf("GetGroupList Loaded!");
        new GetWeather();
        System.out.printf("GetWeather Loaded!");
    }
}
