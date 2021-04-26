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
        char answer = 'Z';
        String wellDone = config.getString("wellDone");

        ///Question 1
        Location nWCorner = new Location(17,4,135);
        Location sECorner = new Location(24, 4, 145);
        Location correctTp = new Location (20, 4 ,160);
        Location incorrectTp = new  Location(18,4,136);
        char correctAnswer = 'A';

        if (action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)){
            if (block.getName().equals("Stone Button")) {
                //player.sendMessage("The block under this one is: " + block_under.getName());
                if ((player.getLocation().getX()>=nWCorner.getX())&&(player.getLocation().getX()<=sECorner.getX())&&(player.getLocation().getZ()>=nWCorner.getZ())&&(player.getLocation().getZ()<=sECorner.getZ())){
                    if (block_under.getName().equals("Red Wool")) {
                        answer = 'A';
                    } else if (block_under.getName().equals("Orange Wool")) {
                        answer = 'B';
                    } else if (block_under.getName().equals("Yellow Wool")) {
                        answer = 'C';
                    }

                    player.sendMessage(TextFormat.GREEN + "Your answer is " + answer);
                    //check if you're in the right place
                    if (answer == correctAnswer) {
                        player.sendMessage("Well done! You've got to the next stage");
                        player.teleport(correctTp);
                    } else {
                        player.teleport(incorrectTp);
                        player.sendMessage("Not quite, have another go!");
                    }
            }else{
                    player.sendMessage("You're not in the right place");
                }

            }



        }



    }


}
