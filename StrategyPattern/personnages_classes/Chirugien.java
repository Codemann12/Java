package personnages_classes;

import action_interfaces.Deplacement;
import action_interfaces.EspritCombatif;
import action_interfaces.Soin;

public class Chirugien extends Personnage {

	
	public Chirugien(EspritCombatif com, Deplacement dep, Soin soin, String name)
	{
		super(com, dep, soin);
		name = "Chirugien";
		
	}

	public void seDeplacer()
	{
        this.deplacement.deplace();	
		
	}

	public void combattre() 
	{
		this.combat.combat();
		
	}

	public void soigner() 
	{
		this.soin.soin();
		
		
	}

}
