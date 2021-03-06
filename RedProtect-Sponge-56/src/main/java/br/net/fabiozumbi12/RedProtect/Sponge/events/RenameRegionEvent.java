package br.net.fabiozumbi12.RedProtect.Sponge.events;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;

import br.net.fabiozumbi12.RedProtect.Sponge.RedProtect;
import br.net.fabiozumbi12.RedProtect.Sponge.Region;

public class RenameRegionEvent implements Cancellable, Event {
	private Region region;
	private String newName;
	private String oldName;
	private Player player;
	private boolean isCancelled = false;
	
	public RenameRegionEvent(Region region, String newName, String oldName, Player p){
		this.region = region;
		this.newName = newName;
		this.oldName = oldName;
		this.player = p;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public Region getRegion(){
		return this.region;
	}
	
	public String getNewName(){
		return this.newName;
	}
	
	public void setNewName(String newName){
		this.newName = newName;
	}
	
	public String getOldName(){
		return this.oldName;
	}
	
	public String getNewID(){
		return this.newName+"@"+this.region.getWorld();
	}
	
	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.isCancelled = arg0;
	}

	@Override
	public Cause getCause() {
		return RedProtect.getPVHelper().getCause(player);
	}

}
