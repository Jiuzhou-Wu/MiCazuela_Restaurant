package experiments;

import cern.jet.random.engine.RandomSeedGenerator;

import mrSimModel.MiCazuela_Restaurant;
import mrSimModel.Seeds;

public class MRExperiment1 {
	 public static void main(String[] args){
		 RandomSeedGenerator rsg = new RandomSeedGenerator();
		 MiCazuela_Restaurant mr;
		 mr = new MiCazuela_Restaurant(0, 300, new Seeds(rsg), true);
		 mr.runSimulation();
         System.out.println("Terminated "+mr.getOutput().numberOfArrivels);		 
	 }
}
