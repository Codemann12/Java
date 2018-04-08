package personnages_classes;
import action_interfaces.Deplacement;
import action_interfaces.EspritCombatif;
import action_interfaces.Soin;

public abstract class Personnage 
{
	protected EspritCombatif combat;
	protected Deplacement deplacement;
	protected Soin soin;
	
	public Personnage(EspritCombatif com, Deplacement dep, Soin soin)
	{
		this.combat = com;
		this.deplacement = dep;
		this.soin = soin;
		
	}
	
	public abstract void seDeplacer();
	public abstract void combattre();
	public abstract void soigner();

}
