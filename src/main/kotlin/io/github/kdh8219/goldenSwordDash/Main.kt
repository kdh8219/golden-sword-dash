package io.github.kdh8219.goldenSwordDash

import org.bukkit.Bukkit.getPluginManager
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin


class Main:JavaPlugin(){
    override fun onEnable() {
        getPluginManager().registerEvents(EventListener(),this)
    }

    override fun onDisable() {
        HandlerList.unregisterAll()
    }
}

class EventListener : Listener {
    @EventHandler
    fun onPlayerRightClick(event:PlayerInteractEvent){
        val item = event.item?.type
        val player = event.player
        val action = event.action
        if (action.isRightClick){
            if(item == Material.GOLDEN_SWORD){
                player.playSound(player.location,Sound.ENTITY_WITHER_SHOOT,0.7F,1.0F)
                player.world.spawnParticle(Particle.CLOUD,player.location,50)
                player.velocity = player.eyeLocation.direction.normalize().multiply(2)
            }
        }
    }

}