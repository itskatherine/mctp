package com.katherine.mctp.Events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class onPressButton implements Listener {

    public Config config;
    public onPressButton (Config cfg){
        config = cfg;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        PlayerInteractEvent.Action action =  event.getAction();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location b_loc = block.getLocation();
        Location b_under_loc = block.getLocation().add(new Location(0,-1,0));
        Level level = b_loc.level;
        Block block_under = level.getBlock(b_under_loc);
        String answer = null;
        String wellDone = config.getString("wellDone");


        if (action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)){
            if (block.getName().equals("Stone Button")) {
                //player.sendMessage("The block under this one is: " + block_under.getName());

                if (block_under.getName().equals("Red Wool")) {
                    answer = "A";
                } else if (block_under.getName().equals("Orange Wool")) {
                    answer = "B";
                } else if (block_under.getName().equals("Yellow Wool")) {
                    answer = "C";
                }

                player.sendMessage(TextFormat.GREEN + "Your answer is " + answer);
                player.sendMessage(wellDone);


            }


        }



    }


}
