package com.katherine.mctp;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.katherine.mctp.Events.onPressButton;

public class Main extends PluginBase {


    @Override
    public void onEnable() {


        Config config = getConfig();

        getServer().getConsoleSender().sendMessage(TextFormat.GREEN+ "Hello welcome to the server");
        getServer().getPluginManager().registerEvents(new onPressButton(config), this);


    }
}
