package personnages_classes;
import action_interfaces.CombatCouteau;
import action_interfaces.Deplacement;
import action_interfaces.EspritCombatif;
import action_interfaces.Marcher;
import action_interfaces.Operation;
import action_interfaces.Soin;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deplacement dep = new Marcher();
		EspritCombatif spirit = new CombatCouteau();
		Soin soin = new Operation();
		Personnage chirugien = new Chirugien(spirit, dep, soin, "Harry Potter");
		chirugien.seDeplacer();

	}

}
